package com.recruit.test;


import com.recruit.bean.NotiUserBean;
import com.recruit.bean.PageBean;
import com.recruit.model.*;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/3/24.
 */
public class SpringTest extends BaseJunit4Test{

    @Test   //标明是测试方法
    @Transactional   //标明此方法需使用事务
    @Rollback(false)
    public void testDemo(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("competition", 4);
        List<Team>list= teamDao.findByProperties(map, 1, 100);
        System.out.println("size of team:"+list.size());
        for(int i=0;i<list.size();i++){
            System.out.println("name of team:"+list.get(i).getName());
        }
}


}
