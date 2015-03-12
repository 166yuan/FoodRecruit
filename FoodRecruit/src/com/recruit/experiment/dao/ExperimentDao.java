package com.recruit.experiment.dao;

import com.recruit.BaseDao.DaoBase;
import com.recruit.experiment.model.Experiment;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Mklaus on 15/1/26.
 */
public class ExperimentDao extends DaoBase<Experiment> {
    public ExperimentDao() {}

    public Class classOfT(){
        return Experiment.class;
    }

    //SINGLETON
    private static class Singleton{
        public static final ExperimentDao INSTANCE = new ExperimentDao();
    }
    public static ExperimentDao getInstance(){
        return Singleton.INSTANCE;
    }

    public Experiment forName(String name)
    {
        DetachedCriteria dc = DetachedCriteria.forClass(Experiment.class)
                .add(Restrictions.eq("name", name));
        return(
                this.get(dc)
        );
    }

    public List<Experiment> findAllNeedAssistant(){
        DetachedCriteria dc = DetachedCriteria.forClass(Experiment.class)
                .add(Restrictions.eq("isOk",false));

        List<Experiment> list = this.search(dc);
        return list;
    }

    public List<Experiment> getAllExperiment(){
        DetachedCriteria dc = DetachedCriteria.forClass(Experiment.class);
        List<Experiment>list=this.search(dc);
        return list;
    }

    public List<Experiment> findMyPublishExperiment(Long publishId){
        DetachedCriteria dc = DetachedCriteria.forClass(Experiment.class)
                .add(Restrictions.eq("publishId",publishId));

        List<Experiment> list = this.search(dc);
        return list;
    }

    public Experiment getById(Long experId){
        DetachedCriteria dc = DetachedCriteria.forClass(Experiment.class)
                .add(Restrictions.eq("id", experId));
        return(
                this.get(dc)
        );
    }
}
