/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.levelup.CGB;

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
    
    @GetMapping
    public String getMessage(){
        return "Hola";
    }
    
    @GetMapping("/Findall")
    public ResponseEntity<List<GenTipoContrato>> buscarTodo(){
        return ResponseEntity.ok(gentipocontratoservice.findGenTipoContratoEntities());
        
    }
    
    
}
