package xss.it.code.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xss.it.code.template.entity.AppUser;

/**
 * @author XDSSWAR
 * Created on 01/01/2023
 */
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUsername(String username);
}
