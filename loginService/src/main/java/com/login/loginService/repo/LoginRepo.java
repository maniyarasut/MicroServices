package com.login.loginService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.loginService.models.LoginModel;

@Repository
public interface LoginRepo extends JpaRepository<LoginModel, String> {

}
