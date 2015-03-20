package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.dao.ScoreDao;
import com.recruit.model.Score;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ScoreImpl extends DaoSupportImpl<Score> implements ScoreDao {
}
