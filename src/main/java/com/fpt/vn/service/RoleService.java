package com.fpt.vn.service;


import com.fpt.vn.model.Role;

public interface RoleService {
    Iterable<Role> findAll();

    void save(Role role);

    Role findByName(String name);
}
