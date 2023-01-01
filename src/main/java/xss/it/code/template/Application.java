package xss.it.code.template;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import xss.it.code.template.entity.AppUser;
import xss.it.code.template.entity.Permits;
import xss.it.code.template.entity.Role;
import xss.it.code.template.services.internals.AppUserService;
import xss.it.code.template.services.internals.RoleService;

/**
 * @author XDSSWAR
 * Created on 01/01/2023
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner(AppUserService appUserService, RoleService roleService){
        return args -> {
            var u=appUserService.findByUsername("admin");
            if (u==null) {
                AppUser emp = new AppUser();
                emp.setUsername("admin");
                emp.setPassword("admin");
                emp = appUserService.save(emp);
                Role role = new Role();
                role.setName("Admin");
                role.getPermits().add(Permits.ADMIN);
                role = roleService.save(role);
                emp.getRoles().add(role);
                appUserService.save(emp);
            }
        };
    }
}
