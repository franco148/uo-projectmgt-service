package com.umssonline.projmgt.repositories;

import com.umssonline.projmgt.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
