import entity.Personnel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class Main {
    public static void main(String[] args) {
        Personnel p=new Personnel("0610223542","nasim","ajloo","Arak");
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em= emf.createEntityManager();
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
}