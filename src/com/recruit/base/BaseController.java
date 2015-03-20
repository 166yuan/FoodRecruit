package com.recruit.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.recruit.dao.ClassesDao;
import com.recruit.dao.CompetAndTeamDao;
import com.recruit.dao.CompetitionDao;
import com.recruit.dao.ExperUserDao;
import com.recruit.dao.ExperimentDao;
import com.recruit.dao.MajorDao;
import com.recruit.dao.NotificationDao;
import com.recruit.dao.PublishLogDao;
import com.recruit.dao.ScoreDao;
import com.recruit.dao.TeamDao;
import com.recruit.dao.UserDao;


public abstract class BaseController {

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
