package org.cnam.videohub.repository;

import org.cnam.videohub.repository.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
