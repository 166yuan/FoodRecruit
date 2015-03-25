package com.recruit.dao;

import com.recruit.base.DaoSupport;
import com.recruit.model.*;

public interface PublishLogDao extends DaoSupport<PublishLog>{
    public void addExper(User user,Experiment experiment);
    public void updateExper(User user,Experiment experiment);
    public void deleteExper(User user,Experiment experiment);
    public void addUser(User user);
    public void addUser(User operator,User user);
    public void updateUser(User user);
    public void updateUser(User operator,User user);
    public void deleteUser(User operator,User user);
    public void publicCompetition(User user,Competition competition);
    public void updateCompetition(User user,Competition competition);
    public void deleteCompetition(User user,Competition competition);
    public void addMajor(User user,Major major);
    public void deleteMajor(User user,Major major);
    public void addClasses(User user,Classes classes);
    public void deleteClasses(User user,Classes classes);
}
