package xss.it.code.template.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author XDSSWAR
 * Created on 01/01/2023
 */
@Controller
@RequiredArgsConstructor
public class AuthenticationController {
    @GetMapping({"/login"})
    public ModelAndView login(HttpServletRequest request){
        ModelAndView model=new ModelAndView("login");
        model.addObject("title","Login - from thymeleaf");
        return model;
    }

    @GetMapping({"/","/home"})
    public ModelAndView home(HttpServletRequest request){
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        ModelAndView model=new ModelAndView("index");
        model.addObject("title","Home - from thymeleaf");
        model.addObject("loggedUsername",username);
        return model;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return new ModelAndView("redirect:/login?logout");
    }
}
