/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.levelup.CGB.controller;

import edu.levelup.CGB.service.GenTipoContratoService;
import edu.levelup.CGB.dominio.GenTipoContrato;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author marher
 */
@RestController
@RequestMapping("/tipocontrato")
public class GenTipoContratoController {
    @Autowired
    GenTipoContratoService gentipocontratoservice;
    
    @GetMapping("/hola")
    public String mensaje(){
        return "Hola mundo";
    }
    
    @GetMapping
    public List<GenTipoContrato> getGenTipoContrato() {
        return gentipocontratoservice.getGenTipoContrato();
    }
    
    @GetMapping("/buscarxid/{id}")
    public GenTipoContrato getTipoContratoById(@PathVariable Long id){
        return gentipocontratoservice.getGenTipoContratoById(id);
    }
    
    @PostMapping
    public ResponseEntity<GenTipoContrato> addTipoContrato(@RequestBody GenTipoContrato gentipocontrato){
        GenTipoContrato saveGenTipoContrato = gentipocontratoservice.saveGenTipoContrato(gentipocontrato);
        return ResponseEntity.ok(saveGenTipoContrato);
    }

}
