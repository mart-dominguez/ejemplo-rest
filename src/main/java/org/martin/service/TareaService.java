/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.service;

import java.util.List;
import javax.inject.Named;
import org.martin.model.Tarea;

/**
 *
 * @author mdominguez
 */
@Named
public interface TareaService {

    Tarea actualizarTarea(Tarea t);

    Tarea addTarea(Tarea t);

    void borrarTarea(Integer id);

    Tarea buscarTarea(Integer id);

    List<Tarea> buscarTodas();
    
}
