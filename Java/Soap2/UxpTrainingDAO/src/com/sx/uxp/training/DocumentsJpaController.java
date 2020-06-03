/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sx.uxp.training;

import com.sx.uxp.training.dao.Documents;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.sx.uxp.training.dao.People;
import com.sx.uxp.training.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Koshman
 */
public class DocumentsJpaController implements Serializable {

    public DocumentsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public static DocumentsJpaController getInstance() {
        return DocumentsJpaControllerHolder.INSTANCE;
    }

    private static class DocumentsJpaControllerHolder {

        private static final DocumentsJpaController INSTANCE = new DocumentsJpaController(Persistence.createEntityManagerFactory("UxpTrainingDAOPU"));

    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Documents documents) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            People PId = documents.getPId();
            if (PId != null) {
                PId = em.getReference(PId.getClass(), PId.getId());
                documents.setPId(PId);
            }
            em.persist(documents);
            if (PId != null) {
                PId.getDocumentsCollection().add(documents);
                PId = em.merge(PId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Documents documents) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documents persistentDocuments = em.find(Documents.class, documents.getId());
            People PIdOld = persistentDocuments.getPId();
            People PIdNew = documents.getPId();
            if (PIdNew != null) {
                PIdNew = em.getReference(PIdNew.getClass(), PIdNew.getId());
                documents.setPId(PIdNew);
            }
            documents = em.merge(documents);
            if (PIdOld != null && !PIdOld.equals(PIdNew)) {
                PIdOld.getDocumentsCollection().remove(documents);
                PIdOld = em.merge(PIdOld);
            }
            if (PIdNew != null && !PIdNew.equals(PIdOld)) {
                PIdNew.getDocumentsCollection().add(documents);
                PIdNew = em.merge(PIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = documents.getId();
                if (findDocuments(id) == null) {
                    throw new NonexistentEntityException("The documents with id " + id + " no longer exists.");
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
            Documents documents;
            try {
                documents = em.getReference(Documents.class, id);
                documents.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The documents with id " + id + " no longer exists.", enfe);
            }
            People PId = documents.getPId();
            if (PId != null) {
                PId.getDocumentsCollection().remove(documents);
                PId = em.merge(PId);
            }
            em.remove(documents);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Documents> findDocumentsEntities() {
        return findDocumentsEntities(true, -1, -1);
    }

    public List<Documents> findDocumentsEntities(int maxResults, int firstResult) {
        return findDocumentsEntities(false, maxResults, firstResult);
    }

    private List<Documents> findDocumentsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Documents.class));
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

    public Documents findDocuments(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Documents.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocumentsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Documents> rt = cq.from(Documents.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
