package com.fpt.vn.repository;
import org.springframework.data.jpa.repository.Modifying;
import com.fpt.vn.model.entitys.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface BookRepo extends JpaRepository<BookEntity,Long> {
    List<BookEntity> findAllByIdDoctor(Long id);

    List<BookEntity> findAllByIdDoctorAndDateAfter(Long id, Date date);

    @Query(value = "SELECT * FROM book where user_id = ?1 and book.date > ?2 and book.done = false", nativeQuery = true)
    List<BookEntity> findAllBookDoneFalse(Long id, Date date);

    @Query(value = "SELECT * FROM book where id_doctor = ?1 and book.date > ?2 and book.status = false", nativeQuery = true)
    List<BookEntity> findAllByIdDoctorIsTrue(Long id, Date date);

    @Query(value = "SELECT * FROM book where id_doctor = ?1 and book.done = true", nativeQuery = true)
    List<BookEntity> findAllByIdDoctorAndDoneTrue(Long id);

    @Query(value = "SELECT * FROM book where user_id = ?1 and book.status = false", nativeQuery = true)
    BookEntity findByUserId(Long id);

    @Modifying
    @Query("UPDATE BookEntity b SET b.status = 1 WHERE b.id =:id")
    void acceptBooking(@Param("id") Long id);

}
