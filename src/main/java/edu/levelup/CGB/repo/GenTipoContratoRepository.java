/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.levelup.CGB.repo;

import edu.levelup.CGB.dominio.GenTipoContrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marher
 */
@Repository
public interface GenTipoContratoRepository extends JpaRepository<GenTipoContrato, Long>{
    
}

