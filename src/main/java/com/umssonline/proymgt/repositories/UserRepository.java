package com.umssonline.proymgt.repositories;

import com.umssonline.proymgt.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
