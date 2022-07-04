/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.entity;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author letso
 */
@Local
public interface VideoFacadeLocal {

    void create(Video video);

    void edit(Video video);

    void remove(Video video);

    Video find(Object id);

    List<Video> findAll();

    List<Video> findRange(int[] range);

    int count();
    
}
