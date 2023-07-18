package com.example.practice5.jpa.repository;

import com.example.practice5.jpa.model.Book;
import com.example.practice5.jpa.model.BookAndId;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);

    // JPQL
    @Query(value = "select b from Book b where title = ?1")
    List<Book> findByMyBook(String title);
//    List<Book> findByMyBook(String title);

    @Query(value = "select b from Book b where title = ?1 and id = ?2")
    List<Book> findByMyBooksAndMyId(String title, Long id);

    @Query(value = "select b.title from Book b where title = ?1")
    List<String> findTitleByMyBooks(String title);

    // return 해주는 book객체를 convert가 안되서 안되는 메소드
    @Query(value = "select b.id id, b.title title from Book b where title = ?1")
//    List<Book> findTitleIdByMyBooks(String title);
    List<Map<String, Object>> findTitleIdByMyBooks(String name);

    @Query(value = "select b.id id, b.title title from Book b where title = :title")
    List<Map<String, Object>> findByNamedTitleIdByMyBooks(@Param("title") String title);

    @Query(value = "select b.id abc, b.title title2 from Book b where title = :title")
    List<BookAndId> findByCustomNamedTitleIdByMyBooks(@Param("title") String title);

    @Query(value = "select b.id abc, b.title title2 from Book b where title = :title")
    List<Tuple> findByCustomNamedNameIdByMyBooks(@Param("title") String title);

    // native 쿼리
    @Query(value = "select * from book where title = ?1", nativeQuery = true)
    List<Book> findByNativeByMyBooks(String title);

    @Query(value = "select * from book where title = :title"
            + " and id = 1"
            + " and 1 = 1", nativeQuery = true)
    List<Book> findByNativeTitleByMyBooks(@Param("title") String title);

    @Transactional
    @Query(value = "update book set title = '이상한자바책' where id = :id", nativeQuery = true)
    @Modifying
    int updateSpecificName(@Param("id") Long id);



    @Transactional
    @Modifying
    @Query(value = "update Book b set b.title = '이상한자바책' where b.id = :id")
    int updateSpecificNameByJPQL(@Param("id") Long id);


}
