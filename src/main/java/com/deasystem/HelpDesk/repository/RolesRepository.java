package com.deasystem.HelpDesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deasystem.HelpDesk.model.Role;

@Repository
public interface RolesRepository extends JpaRepository<Role, Long> {

}
