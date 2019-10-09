package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TrackRepository extends JpaRepository<Track,Integer> {

    @Query("select name from Track t where name = :name")
    List<String> trackSearch(@Param("name") String name);
}
