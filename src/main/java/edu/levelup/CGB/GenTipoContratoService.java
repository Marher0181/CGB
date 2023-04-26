/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.levelup.CGB;

import edu.levelup.CGB.exceptions.NonexistentEntityException;
import edu.levelup.CGB.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author marher
 */
public class GenTipoContratoService implements Serializable {

    public GenTipoContratoService(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public String mensaje(){
        return "Hola mundo";
    }

    public void create(GenTipoContrato genTipoContrato) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(genTipoContrato);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findGenTipoContrato(genTipoContrato.getIdTco()) != null) {
                throw new PreexistingEntityException("GenTipoContrato " + genTipoContrato + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(GenTipoContrato genTipoContrato) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            genTipoContrato = em.merge(genTipoContrato);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = genTipoContrato.getIdTco();
                if (findGenTipoContrato(id) == null) {
                    throw new NonexistentEntityException("The genTipoContrato with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            GenTipoContrato genTipoContrato;
            try {
                genTipoContrato = em.getReference(GenTipoContrato.class, id);
                genTipoContrato.getIdTco();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The genTipoContrato with id " + id + " no longer exists.", enfe);
            }
            em.remove(genTipoContrato);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<GenTipoContrato> findGenTipoContratoEntities() {
        return findGenTipoContratoEntities(true, -1, -1);
    }

    public List<GenTipoContrato> findGenTipoContratoEntities(int maxResults, int firstResult) {
        return findGenTipoContratoEntities(false, maxResults, firstResult);
    }

    private List<GenTipoContrato> findGenTipoContratoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(GenTipoContrato.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public GenTipoContrato findGenTipoContrato(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(GenTipoContrato.class, id);
        } finally {
            em.close();
        }
    }

    public int getGenTipoContratoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<GenTipoContrato> rt = cq.from(GenTipoContrato.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
