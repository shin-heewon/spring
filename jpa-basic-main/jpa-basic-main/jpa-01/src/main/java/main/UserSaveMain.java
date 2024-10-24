package main;

import jakarta.persistence.*;
import jpabasic.reserve.domain.User;

import java.time.LocalDateTime;

public class UserSaveMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabegin");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            User user = new User("ssg22@ssg.com", "shw2", LocalDateTime.now());
            em.persist(user);

            //em.flush(); -> 컨텍스트 내부에 있으므로 해 줄 필요 없음!!

            User user1 = em.createQuery("select u from User u where u.name = :name", User.class)//테이블 이름 아니고 클래스 이름 들어가야됨 => 대소문자 구분!!
                            .setParameter("name", "shw2")
                                    .getSingleResult();
            //getSingleResult() 메서드는 결과가 없을 경우 NoResultException을 발생시키기 때문에,
            // if(user1 == null) 조건을 사용하여 결과를 체크하는 것은 작동하지 않습니다. 이 메서드는 결과가 하나도 없는 경우 null을 반환하지 않고, 예외를 발생시킵니다.

//            if(user1 == null){
//                System.out.println("조회 안됨");
//            }else System.out.printf("이름 : %s, 이메일 : %s", user1.getName(), user1.getEmail());
            try {
                System.out.printf("이름 : %s, 이메일 : %s\n", user1.getName(), user1.getEmail());
            } catch (NoResultException e) {
                e.printStackTrace();
                System.out.println("조회 안됨");
            }

            //em.flush();

            if(user1 == null){
                System.out.println("조회 안됨");
            }else {
                user1.changeName("아아아ㅏㅇ");
                System.out.printf("이름 : %s, 이메일 : %s", user1.getName(), user1.getEmail());
            }

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            em.close();
        }

        emf.close();


//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabegin");//User 객체를 매니징 할 매니저 팩토리 생성
//        EntityManager entityManager = emf.createEntityManager();//매니저 하나씩 생성
//
//        EntityTransaction transaction = entityManager.getTransaction();//매니저에게 스케줄을 관리할 수 있는 권한 부여
//
//        try{
//            transaction.begin();
//            User user = new User("minji@newjins.com", "minji", LocalDateTime.now());
//            entityManager.persist(user);
//            transaction.commit();
//        }catch (Exception e){
//            e.printStackTrace();
//            transaction.rollback();
//        }finally {
//            entityManager.close();
//        }
//
//        emf.close();
    }
}
