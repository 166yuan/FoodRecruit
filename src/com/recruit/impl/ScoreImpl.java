package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.dao.ScoreDao;
import com.recruit.model.Score;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ScoreImpl extends DaoSupportImpl<Score> implements ScoreDao {
    public Score getByExperIdAndUserId(Integer experId,Integer userId){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("student",userId);
        map.put("experiment",experId);
        List<Score>list=this.findByProperties(map,1,10);
        if (list!=null){
            return list.get(0);
        }else {
            return null;
        }
    }
}
