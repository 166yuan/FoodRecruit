package com.recruit.test;

import com.recruit.dao.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2015/3/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration
        ({"/applicationContext.xml"})
public class BaseJunit4Test {
    @Autowired
    protected UserDao userDao;
    @Autowired
    protected ClassesDao classesDao;
    @Autowired
    protected CompetAndTeamDao competAndTeamDao;
    @Autowired
    protected CompetitionDao competitionDao;
    @Autowired
    protected ExperimentDao experimentDao;
    @Autowired
    protected ExperUserDao experUserDao;
    @Autowired
    protected MajorDao majorDao;
    @Autowired
    protected NotificationDao notificationDao;
    @Autowired
    protected PublishLogDao publishLogDao;
    @Autowired
    protected ScoreDao scoreDao;
    @Autowired
    protected TeamDao teamDao;
}
