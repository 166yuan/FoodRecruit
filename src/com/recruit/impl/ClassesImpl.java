package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.dao.ClassesDao;
import com.recruit.model.Classes;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class ClassesImpl extends DaoSupportImpl<Classes> implements ClassesDao {

}
