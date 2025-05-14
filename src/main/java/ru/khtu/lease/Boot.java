package ru.khtu.lease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
@SpringBootApplication
public class Boot {

    @GetMapping("/")
    public String index(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User)auth.getPrincipal();
        String username = principal.getUsername();
        Object credentials = auth.getCredentials();
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        Object details = auth.getDetails();
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    public static void main(String[] args) {
        /*ConfigurableApplicationContext context =*/ SpringApplication.run(Boot.class);
//        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
//        WorkObject.setBeanFactory(beanFactory);
//        System.out.println();
    }

}
