/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.business;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entity.Security;

/**
 *
 * @author letso
 */
@Local
public interface SecurityFacadeLocal {

    void create(Security security);

    void edit(Security security);

    void remove(Security security);

    Security find(Object id);

    List<Security> findAll();

    List<Security> findRange(int[] range);

    int count();
    
}
