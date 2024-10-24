package main;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabasic.reserve.domain.User;

public class UserGetMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabegin");//컨텍스트 생성
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();//정해진 작업 스케줄에 대한 권한 받아옴

        try {
            transaction.begin();
            User user = entityManager.find(User.class, "minji@newjins.com");//기본적으로는 pk로 조회
            if(user == null){
                System.out.println("민지 없다");
            }else {
                System.out.printf("민지가 팬사인회에 참석중 , email=%s, name=%s, createDate=%s\n"
                        , user.getEmail(), user.getName(), user.getCreateDate());
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        emf.close();


    }
}
