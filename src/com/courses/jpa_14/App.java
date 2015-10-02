package com.courses.jpa_14;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by VSulevskiy on 25.09.2015.
 */
public class App {
    public static EntityManagerFactory entityManagerFactory;
    public static void main(String[] args) {
        Book book = new Book();
        book.setTitle("Some title");
        book.setPrice(2.3F);
        book.setDescription("Some description");
        book.setIsbn("some isbn");
        book.setNumOfPages(234);
        book.setIllustrations(false);
//        book.getTags().add("good book");
//        book.getTags().add("very good book");
//        book.getTags().add("nice");

        entityManagerFactory =
                Persistence.createEntityManagerFactory("book");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(book);

        entityTransaction.commit();

        entityManager.close();
        getAndPrint();
    }
    public  static void getAndPrint() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Book foundBook = entityManager.find(Book.class, 1L);
        System.out.println("_______________________________");
//        System.out.println(foundBook.getTags());

        entityManager.detach(foundBook);
        foundBook.setNumOfPages(-1);
        entityManager.refresh(foundBook);
        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();

        System.out.println(foundBook.getNumOfPages());


    }
}
