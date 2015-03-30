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
        System.out.println(teamDao.exitMemberByCompet(4,1));
}


}
