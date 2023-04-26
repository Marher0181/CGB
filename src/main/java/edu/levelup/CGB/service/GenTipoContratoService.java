/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.levelup.CGB.service;

import edu.levelup.CGB.dominio.GenTipoContrato;
import edu.levelup.CGB.exceptions.NonexistentEntityException;
import edu.levelup.CGB.exceptions.PreexistingEntityException;
import edu.levelup.CGB.repo.GenTipoContratoRepository;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marher
 */

@Service
public class GenTipoContratoService implements Serializable {

    
    @Autowired
    GenTipoContratoRepository gentipocontratorepository;
    
    public List<GenTipoContrato> getGenTipoContrato(){
        return gentipocontratorepository.findAll();
    }
    
    public GenTipoContrato getGenTipoContratoById(Long id){
        return gentipocontratorepository.findById(id).orElse(null);
    }

    public GenTipoContrato saveGenTipoContrato(GenTipoContrato genTipoContrato) {
        return gentipocontratorepository.save(genTipoContrato); 
    }
    
    
}
