package com.fpt.vn.repository;

import com.fpt.vn.model.entitys.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<BookEntity,Long> {
}
