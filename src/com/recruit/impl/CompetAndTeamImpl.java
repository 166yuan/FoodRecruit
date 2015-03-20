package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.bean.PageBean;
import com.recruit.dao.CompetAndTeamDao;
import com.recruit.model.CompetAndTeam;
import com.recruit.model.User;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class CompetAndTeamImpl extends DaoSupportImpl<CompetAndTeam> implements CompetAndTeamDao {
    public List<CompetAndTeam> getByUser(User user,PageBean pageBean){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("user",user);
        return this.findByProperties(map,pageBean.getCurPage(),pageBean.getPerPage());
    }

    /**
     *
     * @param userId
     * @param type 时间类型 1表示全部 2进行中 3过期
     * @return
     */
    public Integer getSizeByType(Integer userId,int type){
        Date now=new java.sql.Date(new Date().getTime());
        String hql=null;
        if (type==1){
            hql="from CompetAndTeam cat where cat.user.id="+userId;
        }else if (type==2){
            hql="from CompetAndTeam cat where cat.user.id="+userId+" and cat.team.competition.endTime<"+now;
        }else {
            hql="from CompetAndTeam cat where cat.user.id="+userId+" and cat.team.competition.endTime>="+now;
        }

        Query query=this.createQuery(hql);
        return query.list().size();
    }

   /* public List<ComTeamBean> getAll(List<CompetAndTeam>list){
        Date now = new Date();
        Iterator<CompetAndTeam>it=list.iterator();
        while (it.hasNext()){

        }
    }*/
}
