package xss.it.code.template.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xss.it.code.template.entity.Role;
import xss.it.code.template.repository.RolesRepository;
import xss.it.code.template.services.internals.RoleService;

import java.util.List;

/**
 * @author XDSSWAR
 * Created on 01/01/2023
 */
@Service
@RequiredArgsConstructor
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RolesRepository rolesRepository;

    @Override
    public Role save(Role role) {
        return rolesRepository.save(role);
    }

    @Override
    public Role findByName(String name) {
        return rolesRepository.findByName(name);
    }

    @Override
    public List<Role> findAll() {
        return rolesRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        rolesRepository.deleteById(id);
    }
}
