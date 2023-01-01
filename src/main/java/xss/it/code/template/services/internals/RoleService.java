package xss.it.code.template.services.internals;

import xss.it.code.template.entity.Role;

import java.util.List;

/**
 * @author XDSSWAR
 * Created on 01/01/2023
 */
public interface RoleService {
    Role save(Role role);

    Role findByName(String name);
    List<Role> findAll();
    void deleteById(Long id);
}
