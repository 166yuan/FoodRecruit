package com.recruit.servlet;
import com.recruit.Bean.PageBean;
import com.recruit.Model.Major;
import com.recruit.mana.dao.MajorDao;
import org.hibernate.Query;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.builders.JUnit4Builder;

import java.util.List;

/**
 * Created by Administrator on 2015/2/16.
 */
public class DevTest extends JUnit4Builder{
    public  static MajorDao majorDao=MajorDao.getInstance();
    @BeforeClass
    public static void beforeClass(){
    majorDao.begin();
    }

    @Test
    public void findMajorByYear(){
        int year=2012;
        Query query1= majorDao.find("from Major m where m.year=?").query;
        query1.setParameter(0,year);
        List<Major>list=query1.list();
        for (int i=0;i< list.size();i++)
        {
            System.out.println("id:"+list.get(i).getId()+" name:"+list.get(i).getMajorName());
        }
    }
    @AfterClass
    public static void afterClass(){
        majorDao.close();
    }
    public static void main(String []args){
        beforeClass();
    }
}
