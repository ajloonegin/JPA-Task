package dao;

import entity.Personnel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Set;

public class PersonnelDao {
    static EntityManagerFactory emf= Persistence.createEntityManagerFactory("my-persistence-unit");
    static EntityManager em= emf.createEntityManager();
    public Personnel get(Long id) {

        Personnel p=null;
        try{
            em.getTransaction().begin();
            p=em.find(Personnel.class,id);
            em.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            em.close();
            emf.close();
        }
        return p;

    }




    public void save(Personnel p) {

        try{
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            em.close();
            emf.close();
        }



    }



    public void update(Long id,String fn,String ln) {
        try{
            em.getTransaction().begin();
            Personnel p=em.find(Personnel.class,id);
            em.getTransaction().commit();
            System.out.println("Before Updation");
            System.out.println("Personnel id = "+p.getId());
            System.out.println("Personnel firstName = "+p.getFirstName());
            System.out.println("Personnel familyName = "+p.getLastName());

            p.setFirstName(fn);
            p.setLastName(ln);

            System.out.println("After Updation");
            System.out.println("Personnel id = "+p.getId());
            System.out.println("Personnel firstName = "+p.getFirstName());
            System.out.println("Personnel familyName = "+p.getLastName());
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            em.close();
            emf.close();
        }







    }


    public void delete(Long id) {
        try{
            em.getTransaction().begin();
            Personnel p=em.find(Personnel.class,id);
            em.remove(p);
            em.getTransaction().commit();
            System.out.println("removed");
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            em.close();
            emf.close();
        }






    }

}
