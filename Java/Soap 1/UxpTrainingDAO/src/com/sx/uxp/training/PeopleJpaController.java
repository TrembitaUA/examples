/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sx.uxp.training;

import com.sx.uxp.training.dao.People;
import com.sx.uxp.training.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Koshman
 */
public class PeopleJpaController implements Serializable {

    public PeopleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public static PeopleJpaController getInstance() {
        return PeopleJpaControllerHolder.INSTANCE;
    }

    private static class PeopleJpaControllerHolder {

        private static final PeopleJpaController INSTANCE = new PeopleJpaController(Persistence.createEntityManagerFactory("UxpTrainingDAOPU"));

    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(People people) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(people);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(People people) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            people = em.merge(people);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = people.getId();
                if (findPeople(id) == null) {
                    throw new NonexistentEntityException("The people with id " + id + " no longer exists.");
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
            People people;
            try {
                people = em.getReference(People.class, id);
                people.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The people with id " + id + " no longer exists.", enfe);
            }
            em.remove(people);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<People> findPeopleEntities() {
        return findPeopleEntities(true, -1, -1);
    }

    public List<People> findPeopleEntities(int maxResults, int firstResult) {
        return findPeopleEntities(false, maxResults, firstResult);
    }

    private List<People> findPeopleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(People.class));
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

    public People findPeople(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(People.class, id);
        } finally {
            em.close();
        }
    }

    public List<People> findPeopleByInn(String inn) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<People> query
                    = em.createNamedQuery("People.findByInn", People.class);
            return query.setParameter("inn", inn).getResultList();
        } finally {
            em.close();
        }
    }
    
    public int getPeopleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<People> rt = cq.from(People.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
