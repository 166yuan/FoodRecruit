package com.recruit.servlet;
import com.recruit.mana.model.Major;
import com.recruit.controller.ExperController;
import com.recruit.mana.dao.MajorDao;
import org.hibernate.Query;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.builders.JUnit4Builder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    @Test
    public void dateFormat(){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy k:m a", Locale.US);
        String date="03/01/2015 8:48 AM";
        try{
            Date date1=sdf.parse(date);
           System.out.println(date1.toString());
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
    @Test
    public void format(){
        System.out.println(new ExperController().handleLocale("04/08/2016 3:41 下午"));
    }
    @AfterClass
    public static void afterClass(){
        majorDao.close();
    }
    public static void main(String []args){
        beforeClass();
    }
}
