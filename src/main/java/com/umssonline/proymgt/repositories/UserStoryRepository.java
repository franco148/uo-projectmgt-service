package com.umssonline.proymgt.repositories;

import com.umssonline.proymgt.models.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStoryRepository extends JpaRepository<UserStory, Long> {
}
