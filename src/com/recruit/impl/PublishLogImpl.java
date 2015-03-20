package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.dao.PublishLogDao;
import com.recruit.model.PublishLog;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class PublishLogImpl extends DaoSupportImpl<PublishLog> implements PublishLogDao {
}
