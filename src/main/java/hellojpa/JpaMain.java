package hellojpa;

import javax.persistence.*;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
//            저장
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            entityManager.persist(member);

//            조회
//            member = entityManager.find(Member.class, 1L);

//            수정

//            member.setName("helloJPA");

//            전체 조회 (JPQL)
//            List<Member> result = entityManager.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(0)
//                    .setMaxResults(8)
//                    .getResultList();
//
//            for (Member s : result) {
//                System.out.println(s.getId() + " / " + s.getName());
//            }

//            엔티티를 생성한 상태(비영속)
            Members members = new Members();
            members.setId(100L);
            members.setUsername("회원1");

//            엔티티를 영속
            System.out.println("======== BEFORE =======");
            entityManager.persist(members);
            System.out.println("======== AFTER =======");

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
