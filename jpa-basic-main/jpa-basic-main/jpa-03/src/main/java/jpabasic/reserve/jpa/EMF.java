package jpabasic.reserve.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EMF {

    private static  EntityManagerFactory emf;

    public static void init(){
        emf = Persistence.createEntityManagerFactory("jpabegin");
    }//초기화

    public static EntityManager createEntityManeger(){
        return emf.createEntityManager();
    }

    public static void close(){
        emf.close();//factory 닫으니까 manager까지 close
    }


}
