package com.recruit.test;


import com.recruit.bean.NotiUserBean;
import com.recruit.bean.PageBean;
import com.recruit.model.Notification;
import com.recruit.model.User;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2015/3/24.
 */
public class SpringTest extends BaseJunit4Test{

    @Test   //标明是测试方法
    @Transactional   //标明此方法需使用事务
    @Rollback(false)
    public void testDemo(){
        int total=notificationDao.getSizeByType(3);
        PageBean pageBean= PageBean.getInstance(1, total, "/mana", "/showfeedback");
        List<Notification> list=notificationDao.getAllByType(3,pageBean);
        List<NotiUserBean>nlist = notificationDao.buildList(list);
        System.out.println(nlist.size());
}


}
