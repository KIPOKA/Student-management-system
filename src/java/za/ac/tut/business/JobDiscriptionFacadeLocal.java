/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.business;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entity.JobDiscription;

/**
 *
 * @author letso
 */
@Local
public interface JobDiscriptionFacadeLocal {

    void create(JobDiscription jobDiscription);

    void edit(JobDiscription jobDiscription);

    void remove(JobDiscription jobDiscription);

    JobDiscription find(Object id);

    List<JobDiscription> findAll();

    List<JobDiscription> findRange(int[] range);

    int count();
    
}
