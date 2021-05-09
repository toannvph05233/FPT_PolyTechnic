package com.fpt.vn.repository;



import com.fpt.vn.model.AppUser;
import com.fpt.vn.model.entitys.ApplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);

    @Query(nativeQuery = true, value = "SELECT * FROM  user_table inner join user_role on user_table.id = user_role.user_id inner join fptpolytechnic.role on user_role.role_id = fptpolytechnic.role.id   where fptpolytechnic.role.name like '%USER'")
    List<AppUser> findAllDoctor();

//    @Query("SELECT count(FeedbackEntity.id) FROM FeedbackEntity inner join AppUser on FeedbackEntity.user.id = FeedbackEntity.id where FeedbackEntity.idDoctor = :id")
//    long coutFeedback(@Param("id") Long id);


    List<AppUser> findAllByLocationEntityId(long id);
}
