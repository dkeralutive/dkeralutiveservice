package com.example.dkeralutiveservice.user.repository;

import com.example.dkeralutiveservice.user.model.DekeralutiveUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<DekeralutiveUser, Long> {

    DekeralutiveUser findByUserName(String userName);
}
