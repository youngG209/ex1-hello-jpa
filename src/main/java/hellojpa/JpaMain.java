package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        EntityManager em = entityManagerFactory.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Members member = new Members();
            member.setUsername("member1");

//            역방향(주인이 아닌 방향)만 연관관계 설정
            team.getMembers().add(member);
            member.setTeam(team);
            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
            entityManagerFactory.close();
        }
    }
}
