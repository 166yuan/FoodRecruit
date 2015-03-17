package com.recruit.controller;


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
public class ScoreController {
    @RequestMapping("scorePage")
    public String scorePage(HttpSession session,Long experId,Long userId,String experName,String userName,Model model){
       /* model.addAttribute("userName",userName);
        model.addAttribute("experName",experName);
        ScoreDao scoreDao=ScoreDao.getInstance();
        Score score=scoreDao.getByExperIdAndUserId(experId, userId);
        Long fromId=(Long)session.getAttribute("userId");
        if(score==null){
            score=new Score();
            try{
                scoreDao.begin();
                score.setExper_id(experId);
                score.setUserId(userId);
                score.setFromId(fromId);
                scoreDao.save(score);
                scoreDao.commit();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                scoreDao.close();
            }

        }
        model.addAttribute("score",score);*/
        return "View/experiment/scorePage";
    }
   /* @RequestMapping("saveScoreA")
    public void saveScoreA(int duty,int discipline,int tidy,int care,int operation,int fault,int efficiency,int advise,Long experId,Long userId,HttpSession session,PrintWriter out){
        int result=1,temp=0;
        Long fromId=(Long)session.getAttribute("userId");
        ScoreDao scoreDao=ScoreDao.getInstance();
        Score score=scoreDao.getByExperIdAndUserId(experId,userId);
        if(score==null){
            score=new Score();
            temp=1;
        }
        try{
            scoreDao.begin();
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
                score.setExper_id(experId);
                score.setUserId(userId);
                score.setFromId(fromId);
                scoreDao.save(score);
            }else {
             if(score.getScoreB()!=null&&score.getSecscore()!=null)
                 score.setTotal();
             scoreDao.update(score);
            }
        scoreDao.commit();
        }catch (Exception e){
            e.printStackTrace();
            result=-1;
        }finally {
            scoreDao.close();
        }
        out.print(result);
    }*/

    /*@RequestMapping("saveScoreB")
    public void saveScoreB(int scoreB,Long experId,Long userId,HttpSession session,PrintWriter out){
        int result=1,temp=0;
        Long fromId=(Long)session.getAttribute("userId");
        ScoreDao scoreDao=ScoreDao.getInstance();
        Score score=scoreDao.getByExperIdAndUserId(experId,userId);
        if(score==null){
            score=new Score();
            temp=1;
        }
        try{
        scoreDao.begin();
        score.setScoreB(scoreB);
        if(temp==1){
            score.setExper_id(experId);
            score.setUserId(userId);
            score.setFromId(fromId);
        scoreDao.save(score);
        }else {
        if(score.getScoreA()!=null&&score.getSecscore()!=null)
            score.setTotal();
        scoreDao.update(score);
        }
        scoreDao.commit();
        }catch (Exception e){
        e.printStackTrace();
        }finally {
        scoreDao.close();
        }
        out.print(result);
    }*/

    /*@RequestMapping("saveScoreC")
    public void saveScoreC(int Ttidy,int Tcare,int Toperation,int Tconnect,int member,int recorded,int append,Long experId,Long userId,HttpSession session,PrintWriter out){
        int result=1,temp=0;
        Long fromId=(Long)session.getAttribute("userId");
        ScoreDao scoreDao=ScoreDao.getInstance();
        ExperUserDao experUserDao=ExperUserDao.getInstance();
        Score score=scoreDao.getByExperIdAndUserId(experId,userId);
        if(score==null){
            score=new Score();
            temp=1;
        }
        try{
            scoreDao.begin();
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
                score.setExper_id(experId);
                score.setUserId(userId);
                score.setFromId(fromId);
                score.setSecscore();
                if(score.getScoreA()!=null&&score.getScoreB()!=null)
                score.setTotal();
                ExperUser experUser=experUserDao.forExperIdAndUserId(experId, userId);
                experUser.setIsEvaluate(true);
                scoreDao.update(experUser);
                scoreDao.update(score);
            }
            scoreDao.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            scoreDao.close();
        }
        out.print(result);
    }*/

}
