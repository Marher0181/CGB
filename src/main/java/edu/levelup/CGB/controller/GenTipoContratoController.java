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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public String mensaje() {
        return "Hola mundo";
    }

    @GetMapping("/GetTipoContrato")
    public List<GenTipoContrato> getGenTipoContrato() {
        return gentipocontratoservice.getGenTipoContrato();
    }

    @GetMapping("/buscarxid/{id}")
    public GenTipoContrato getTipoContratoById(@PathVariable Long id) {
        return gentipocontratoservice.getGenTipoContratoById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<GenTipoContrato> saveGenTipoContrato(@RequestBody GenTipoContrato gentipocontrato) {
        GenTipoContrato saveGenTipoContrato = gentipocontratoservice.saveGenTipoContrato(gentipocontrato);
        return ResponseEntity.ok(saveGenTipoContrato);
    }

    @DeleteMapping("/eliminar/{id}")
    public String deleteGenTipoContratoById(@PathVariable Long id) {
        gentipocontratoservice.deleteGenTipoContratoById(id);
        return "Usuario " + id + " eliminado exitosamente";
    }

    @PutMapping("/gentipocontrato/{id}")
    public ResponseEntity<GenTipoContrato> updateGenTipoContrato(@PathVariable Long id, @RequestBody GenTipoContrato genTipoContrato) {
        GenTipoContrato updatedGenTipoContrato = gentipocontratoservice.getGenTipoContratoById(id).map(existingGenTipoContrato -> {
            existingGenTipoContrato.setDescripcionTco(genTipoContrato.getDescripcionTco());
            existingGenTipoContrato.setEliminadoTco(genTipoContrato.getEliminadoTco());
            existingGenTipoContrato.setUsuarioTco(genTipoContrato.getUsuarioTco());
            existingGenTipoContrato.setFechaTco(genTipoContrato.getFechaTco());
            existingGenTipoContrato.setIpTco(genTipoContrato.getIpTco());
            return gentipocontratoservice.save(existingGenTipoContrato);
        }).orElse(null);

        if (updatedGenTipoContrato != null) {
            return ResponseEntity.ok(updatedGenTipoContrato);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
