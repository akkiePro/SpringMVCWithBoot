package com.akki.SpringMVCWithBoot.repository;

import com.akki.SpringMVCWithBoot.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface AlienRepo extends JpaRepository<Alien, Integer> {

    List<Alien> findByAnameOrderByAidDesc(String aname);    // Query DSL(Domain Specific Language)

    @Query("FROM Alien WHERE aname= :n ORDER BY aid DESC")
    List<Alien> findAllTargetAliensOrderedDescending(@Param("n") String aname);

}
