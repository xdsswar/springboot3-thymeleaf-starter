package xss.it.code.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xss.it.code.template.entity.Role;

/**
 * @author XDSSWAR
 * Created on 01/01/2023
 */
public interface RolesRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
