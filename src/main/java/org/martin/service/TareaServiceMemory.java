/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import org.martin.model.Tarea;

/**
 *
 * @author mdominguez
 */
@ApplicationScoped
public class TareaServiceMemory implements TareaService {
    private static final Logger LOG = Logger.getLogger(TareaServiceMemory.class.getName());
    private List<Tarea> lista;
    private static final AtomicInteger _GENERADOR_ID = new AtomicInteger(0); 
    
    @PostConstruct
    public void init(){
       this.lista = new ArrayList<Tarea>();
    }
    
    @Override
    public Tarea addTarea(Tarea t){
        t.setId(_GENERADOR_ID.getAndIncrement());
        lista.add(t);
        return t;
    }

    @Override
    public Tarea actualizarTarea(Tarea t){
        lista.remove(t);
        lista.add(t);
        return t;
    }

    @Override
    public void borrarTarea(Integer id){
        lista.remove(this.buscarTarea(id));
    }

    @Override
    public Tarea buscarTarea(Integer id){
        LOG.log(Level.INFO,"busco tarea de id "+id);
        Tarea tAux = new Tarea();
        tAux.setId(id);
        int indice = lista.indexOf(tAux);
        return lista.get(indice);
    }

    @Override
    public List<Tarea> buscarTodas(){
        return lista;
    }

    
}
