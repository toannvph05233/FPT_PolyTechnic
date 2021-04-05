package com.fpt.vn.repository;



import com.fpt.vn.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);

//    AppUser findByEmail(String email);
}
