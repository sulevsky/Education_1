package com.courses.jpa_14.test;

import com.courses.jpa_14.Book;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

/**
 * Created by VSulevskiy on 25.09.2015.
 */
public class BookTest {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static EntityTransaction entityTransaction;

    @BeforeClass
    public static void initEntityManager(){
        entityManagerFactory = Persistence.createEntityManagerFactory("book_test");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterClass
    public static void closeEntityManager(){
        entityManager.close();
        entityManagerFactory.close();
    }

    @Before
    public void initTransaction(){
        entityTransaction = entityManager.getTransaction();
    }

    @Test
    public void shouldCreateABook(){
        Book book  = new Book();
        book.setTitle("Some title");
        book.setPrice(2.3F);
        book.setDescription("Some description");
        book.setIsbn("some isbn");
        book.setNumOfPages(234);
        book.setIllustrations(false);

        entityTransaction.begin();
        entityManager.persist(book);
        entityTransaction.commit();

//        assertNotNull("Id should be null", book.getId());
        Book bookGotFromDb = entityManager.find(Book.class,1L);
        assertNotNull("Book is not stored", bookGotFromDb);
    }
}
