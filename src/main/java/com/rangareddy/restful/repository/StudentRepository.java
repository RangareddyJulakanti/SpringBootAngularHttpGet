package com.rangareddy.restful.repository;

import com.rangareddy.restful.model.EStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RANGAREJ on 5/5/2018.
 */
@Repository
public interface StudentRepository extends JpaRepository<EStudent,Integer> {
    @Query("select s from EStudent s join s.addressList adlist where adlist.address=:ad")
    List<EStudent> findStudentByAddressFiller(@Param("ad") String ad);
}
