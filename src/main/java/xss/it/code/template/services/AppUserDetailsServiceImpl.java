package xss.it.code.template.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xss.it.code.template.entity.AppUser;
import xss.it.code.template.repository.AppUserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XDSSWAR
 * Created on 01/01/2023
 */
@Service
@RequiredArgsConstructor
@Transactional
public class AppUserDetailsServiceImpl implements UserDetailsService {
    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user=appUserRepository.findByUsername(username);
        if (user==null) throw new UsernameNotFoundException(String.format("App user with username %s not found!", username));
        List<GrantedAuthority> authorities=new ArrayList<>();
        user.getRoles().forEach(r-> r.getPermits().forEach(p-> authorities.add(new SimpleGrantedAuthority(p.name()))));
        return new User(user.getUsername(), user.getPassword(), authorities);
    }

}
