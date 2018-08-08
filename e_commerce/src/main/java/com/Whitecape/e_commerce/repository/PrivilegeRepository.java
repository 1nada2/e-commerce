package com.Whitecape.e_commerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Whitecape.e_commerce.model.Privilege;
@CrossOrigin(origins = "http://localhost:4200")
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    Privilege findByName(String name);

    @Override
    void delete(Privilege privilege);

}
