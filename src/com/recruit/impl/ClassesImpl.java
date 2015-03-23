package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.dao.ClassesDao;
import com.recruit.model.Classes;
import com.recruit.model.Major;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ClassesImpl extends DaoSupportImpl<Classes> implements ClassesDao {
    public List<Classes>getClassByMajor(Integer mid){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("major",mid);
        return this.findByProperties(map,1,50);
    }
}
