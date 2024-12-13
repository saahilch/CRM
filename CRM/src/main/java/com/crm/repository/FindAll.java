package com.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.entities.User;

@Repository
public interface FindAll extends JpaRepository<User, Long> {

}
