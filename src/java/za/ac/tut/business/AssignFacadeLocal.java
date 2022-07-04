/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.business;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entity.Assign;

/**
 *
 * @author letso
 */
@Local
public interface AssignFacadeLocal {

    void create(Assign assign);

//    void edit(Assign assign);
//
//    void remove(Assign assign);
//
//    Assign find(Object id);
//
//    List<Assign> findAll();
//
//    List<Assign> findRange(int[] range);

    int count();
    
}
