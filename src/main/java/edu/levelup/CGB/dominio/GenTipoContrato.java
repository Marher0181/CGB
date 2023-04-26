/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.levelup.CGB.dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 *
 * @author marher
 */
@Data
@Entity
@Table(name = "GEN_TIPO_CONTRATO")

public class GenTipoContrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_TCO")
    private Long idTco;
    
    @Column(name = "DESCRIPCION_TCO")
    private String descripcionTco;
    
    @Column(name = "ELIMINADO_TCO")
    private String eliminadoTco;
    
    @Column(name = "USUARIO_TCO")
    private String usuarioTco;
    
    @Column(name = "FECHA_TCO")
    @Temporal(TemporalType.DATE)
    private Date fechaTco;
    
    @Column(name = "IP_TCO")
    private String ipTco;
    
    
    public GenTipoContrato() {
    }

    public GenTipoContrato(Long idTco) {
        this.idTco = idTco;
    }

    public Long getIdTco() {
        return idTco;
    }

    public void setIdTco(Long idTco) {
        this.idTco = idTco;
    }

    public String getDescripcionTco() {
        return descripcionTco;
    }

    public void setDescripcionTco(String descripcionTco) {
        this.descripcionTco = descripcionTco;
    }

    public String getEliminadoTco() {
        return eliminadoTco;
    }

    public void setEliminadoTco(String eliminadoTco) {
        this.eliminadoTco = eliminadoTco;
    }

    public String getUsuarioTco() {
        return usuarioTco;
    }

    public void setUsuarioTco(String usuarioTco) {
        this.usuarioTco = usuarioTco;
    }

    public Date getFechaTco() {
        return fechaTco;
    }

    public void setFechaTco(Date fechaTco) {
        this.fechaTco = fechaTco;
    }

    public String getIpTco() {
        return ipTco;
    }

    public void setIpTco(String ipTco) {
        this.ipTco = ipTco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTco != null ? idTco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenTipoContrato)) {
            return false;
        }
        GenTipoContrato other = (GenTipoContrato) object;
        if ((this.idTco == null && other.idTco != null) || (this.idTco != null && !this.idTco.equals(other.idTco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.levelup.CGB.GenTipoContrato[ idTco=" + idTco + " ]";
    }
    
}
