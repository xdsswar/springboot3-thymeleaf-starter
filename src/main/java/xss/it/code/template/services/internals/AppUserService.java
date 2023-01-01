package xss.it.code.template.services.internals;

import xss.it.code.template.entity.AppUser;

import java.util.List;

/**
 * @author XDSSWAR
 * Created on 01/01/2023
 */
public interface AppUserService {
    AppUser save(AppUser user);

    AppUser findByUsername(String  username);

    List<AppUser> findAll();

    void deleteById(Long id);
}
