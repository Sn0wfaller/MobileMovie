package com.infinity.movies.service;


import com.infinity.movies.entity.Actor;
import com.infinity.movies.entity.Role;
import com.infinity.movies.model.ActorModel;
import com.infinity.movies.model.RoleModel;

public interface RoleService {

    Role getRoleById(Long id);

    Iterable<Role> getRoles();

    Role addRole(RoleModel roleModel);

    Role updateRole(Long id, RoleModel roleModel);

    void deleteById(Long id);
}
