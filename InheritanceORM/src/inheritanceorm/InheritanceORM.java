/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritanceorm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author USER
 */
public class InheritanceORM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        FulltimeEmployee emp1 = new FulltimeEmployee();
        emp1.setName("John");
        emp1.setSalary(5000);
        ParttimeEmployee emp2 = new ParttimeEmployee();
        emp2.setName("Jane");
        emp2.setHoursWork(4);
        persist(emp1);
        persist(emp2);
    }
    

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InheritanceORMPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
