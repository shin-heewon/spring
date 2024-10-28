package jpabasic.reserve.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.User;
import jpabasic.reserve.jpa.EMF;

public class ChangeNameService {
    EntityManager em = EMF.createEntityManeger();
    EntityTransaction transaction = em.getTransaction();

    public void changeName(String email, String newName) {

        try {
            transaction.begin();
            User user = em.find(User.class, email);
            if(user==null){
                System.out.println("존재하지 않는 사용자입니다.");
                return;
            }
            user.changeName(newName);
            transaction.commit();
            user.toString();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            em.close();
        }

    }
    
}
