package com.recruit.controller;


import com.recruit.base.BaseController;
import com.recruit.model.ExperUser;
import com.recruit.model.Experiment;
import com.recruit.model.Score;
import com.recruit.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by Mklaus on 15/2/1.
 */
@Controller
@RequestMapping("/score")
public class ScoreController extends BaseController {
    @RequestMapping("scorePage")
    public String scorePage(HttpSession session,Integer experId,Integer userId,String experName,String userName,Model model){
        model.addAttribute("userName",userName);
        model.addAttribute("experName",experName);
        Score score=scoreDao.getByExperIdAndUserId(experId,userId);
        Integer fromId=(Integer)session.getAttribute("userId");
        Experiment experiment=experimentDao.getById(experId);
        User user=userDao.getById(userId);
        User from=userDao.getById(fromId);
        if(score==null){
            score=new Score();
            try{
                score.setExperiment(experiment);
                score.setTeacher(from);
                score.setStudent(user);
                scoreDao.save(score);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        model.addAttribute("score",score);
        return "View/experiment/scorePage";
    }
    @RequestMapping("saveScoreA")
    public void saveScoreA(int duty,int discipline,int tidy,int care,int operation,int fault,int efficiency,int advise,Integer experId,Integer userId,HttpSession session,PrintWriter out){
        int result=1,temp=0;
        Integer fromId=(Integer)session.getAttribute("userId");
        Score score=scoreDao.getByExperIdAndUserId(experId,userId);
        if(score==null){
            score=new Score();
            temp=1;
        }
        try{
        score.setDuty(duty);
        score.setDiscipline(discipline);
        score.setCare(care);
        score.setTidy(tidy);
        score.setOperation(operation);
        score.setFault(fault);
        score.setEfficiency(efficiency);
        score.setAdvise(advise);
        score.setScoreA();
            if (temp==1){
                Experiment experiment=experimentDao.getById(experId);
                User student=userDao.getById(userId);
                User teacher=userDao.getById(fromId);
                score.setStudent(student);
                score.setTeacher(teacher);
                score.setExperiment(experiment);
                scoreDao.save(score);
            }else {
             if(score.getScoreB()!=null&&score.getSecscore()!=null)
                 score.setTotal();
             scoreDao.update(score);
            }
        }catch (Exception e){
            e.printStackTrace();
            result=-1;
        }
        out.print(result);
    }

    @RequestMapping("saveScoreB")
    public void saveScoreB(int scoreB,Integer experId,Integer userId,HttpSession session,PrintWriter out){
        int result=1,temp=0;
        Integer fromId=(Integer)session.getAttribute("userId");
        Score score=scoreDao.getByExperIdAndUserId(experId,userId);
        if(score==null){
            score=new Score();
            temp=1;
        }
        try{
        score.setScoreB(scoreB);
        if(temp==1){
            Experiment experiment=experimentDao.getById(experId);
            User student=userDao.getById(userId);
            User teacher=userDao.getById(fromId);
            score.setStudent(student);
            score.setTeacher(teacher);
            score.setExperiment(experiment);
        scoreDao.save(score);
        }else {
        if(score.getScoreA()!=null&&score.getSecscore()!=null)
            score.setTotal();
        scoreDao.update(score);
        }
        }catch (Exception e){
        e.printStackTrace();
        }
        out.print(result);
    }

    @RequestMapping("saveScoreC")
    public void saveScoreC(int Ttidy,int Tcare,int Toperation,int Tconnect,int member,int recorded,int append,Integer experId,Integer userId,HttpSession session,PrintWriter out){
        int result=1,temp=0;
        Long fromId=(Long)session.getAttribute("userId");
        Score score=scoreDao.getByExperIdAndUserId(experId,userId);
        if(score==null){
            score=new Score();
            temp=1;
        }
        try{
            score.setTtidy(Ttidy);
            score.setTcare(Tcare);
            score.setTconnect(Tconnect);
            score.setToperation(Toperation);
            score.setMember(member);
            score.setAppend(append);
            score.setRecorded(recorded);
            if(temp==1){
                scoreDao.save(score);
            }else {
                Experiment experiment=experimentDao.getById(experId);
                User student=userDao.getById(userId);
                User teacher=userDao.getById(fromId);
                score.setStudent(student);
                score.setTeacher(teacher);
                score.setExperiment(experiment);
                score.setSecscore();
                if(score.getScoreA()!=null&&score.getScoreB()!=null)
                score.setTotal();
                ExperUser experUser=experUserDao.findByExperAndUserId(experId, userId);
                experUser.setIsEvaluate(true);
                experUserDao.update(experUser);
                scoreDao.update(score);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        out.print(result);
    }

}
