package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.Grade;
import jpabasic.reserve.domain.Hotel;
import jpabasic.reserve.jpa.EMF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main04 {
    private static Logger logger = LoggerFactory.getLogger(Main04.class);

    public static void main(String[] args) {
        EMF.init();
        Hotel entity = new Hotel("H-01", "KOREA", 2023, Grade.S7);
//        save(entity);

        Hotel h2 = read("H-01");
        if(h2 == null){
            logger.info("해당 호텔은 존재하지 않습니다.");
        }else {
            logger.info("해당 호텔 정보 : {}", h2);
        }
        EMF.close();

    }

    private static void save(Hotel entity) {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(entity);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    private static Hotel read(String id) {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Hotel hotel = new Hotel();

        try {
            tx.begin();
            hotel = em.find(Hotel.class, id);
            hotel.toString();
            tx.commit();
            return hotel;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        return hotel;
    }
}
