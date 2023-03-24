/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package fr.kdr.tpcustomerapplicationyoucefrand.session;

import fr.kdr.tpcustomerapplicationyoucefrand.entities.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author youcef.kaddour
 */
@Stateless
public class CustomerManager {
    /*
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;
    */
    @PersistenceContext
    private EntityManager em;
    
    /*
    La methode persist permet de push un objet Customer en base 
    */
    public void persist(Customer customer) {
        em.persist(customer);
    }
    
    /*
    La méthode getAllCustomers comme son nom l'indqiue recupere la liste de tout les customer en base de donnée
    et renvois la liste
    */
    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }
    
    
    public Customer update(Customer customer) {
      return em.merge(customer);
    } 
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
