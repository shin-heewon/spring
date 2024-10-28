package jpabasic.reserve.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.User;
import jpabasic.reserve.jpa.EMF;

public class RemoveUserService {
    public void removeUser(String email) {
        EntityManager em = EMF.createEntityManeger();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            User user = em.find(User.class, email);
            em.remove(user);
            transaction.commit();
            System.out.println("삭제됨");

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            EMF.close();
        }
}
}