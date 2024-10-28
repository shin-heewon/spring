package jpabasic.reserve.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.User;
import jpabasic.reserve.jpa.EMF;

public class GetUserService {
    EntityManager em = EMF.createEntityManeger();
    EntityTransaction transaction = em.getTransaction();

    public void getUser(String email) {

        try {
            transaction.begin();
            User user = em.find(User.class, email);
            System.out.println("여기까지??");
            user.toString();
            if(user == null){
                System.out.println("사용자가 존재하지 않습니다.");
                return;
            }
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            EMF.close();
        }

    }

}
    

