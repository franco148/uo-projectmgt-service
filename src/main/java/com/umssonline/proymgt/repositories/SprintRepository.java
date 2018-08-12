package com.umssonline.proymgt.repositories;

import com.umssonline.proymgt.models.entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {

}
