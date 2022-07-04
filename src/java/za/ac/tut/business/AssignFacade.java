/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.ac.tut.entity.Assign;

/**
 *
 * @author letso
 */
@Stateless
public class AssignFacade extends AbstractFacade<Assign> implements AssignFacadeLocal {

    @PersistenceContext(unitName = "i-TechPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AssignFacade() {
        super(Assign.class);
    }
    
}
