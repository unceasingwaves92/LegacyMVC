package com.tim.repository;

import com.tim.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    
    Optional<Application> findByApplicationName(String name);

  //  Optional<Application> findByAppName(String name, int id);

    @Query(value = "Select app from Application app where applicationName=:name and applicationId=:id")
    Optional<Application> findByAppName(@Param("name") String name, @Param("id") long id);


}
