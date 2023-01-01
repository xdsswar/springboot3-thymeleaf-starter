package xss.it.code.template.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import xss.it.code.template.entity.AppUser;
import xss.it.code.template.repository.AppUserRepository;
import xss.it.code.template.services.internals.AppUserService;

import java.util.List;

/**
 * @author XDSSWAR
 * Created on 01/01/2023
 */
@Service
@RequiredArgsConstructor
@Transactional
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public AppUser save(AppUser user) {
        if (!user.getPassword().startsWith("$2a$1")) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return appUserRepository.save(user);
    }

    @Override
    public AppUser findByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        appUserRepository.deleteById(id);
    }
}
