/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.ac.tut.entity.JobDiscription;

/**
 *
 * @author letso
 */
@Stateless
public class JobDiscriptionFacade extends AbstractFacade<JobDiscription> implements JobDiscriptionFacadeLocal {

    @PersistenceContext(unitName = "i-TechPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JobDiscriptionFacade() {
        super(JobDiscription.class);
    }
    
}
