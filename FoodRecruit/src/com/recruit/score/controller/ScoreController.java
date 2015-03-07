package com.recruit.score.controller;

import com.recruit.score.dao.ScoreDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.PrintWriter;

/**
 * Created by Mklaus on 15/2/1.
 */
@Controller
@RequestMapping("/score")
public class ScoreController {
    @RequestMapping("")
    public void m(PrintWriter out){
        ScoreDao scoreDao = ScoreDao.getInstance();
        int result = 0;
        try {
            scoreDao.begin();

            scoreDao.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            scoreDao.close();
        }
        out.print(result);
    }

}
