package com.fpt.vn.repository;



import com.fpt.vn.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);

//    AppUser findByEmail(String email);

    List<AppUser> findAllByLocationEntityId(long id);
}
