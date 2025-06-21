package ru.khtu.lease;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
@SpringBootApplication
public class Boot {

    @GetMapping("/")
    public String index() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User)auth.getPrincipal();
        String username = principal.getUsername();
        Object credentials = auth.getCredentials();
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        Object details = auth.getDetails();
        return new String("index");
    }
    /*@GetMapping("/{static_webpage}")
    public ModelAndView getWeb(@PathVariable("static_webpage") String static_webpage) {
        ModelAndView modelAndView = new ModelAndView();
        if (new String("favicon.ico").equalsIgnoreCase(static_webpage)) {
        }
//        modelAndView.setViewName("webpages/" + static_webpage);
        return modelAndView;
    }*/

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Boot.class);
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
//        WorkObject.setBeanFactory(beanFactory);
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
//        Map<String, Object> beans = new HashMap<>();
        List beanList = new ArrayList<>();
        for (String beanDefinitionName : beanDefinitionNames) {
            if (beanFactory.getBean(beanDefinitionName).getClass().getCanonicalName() != null) {
                if ( beanFactory.getBean(beanDefinitionName).getClass().getCanonicalName().startsWith("ru.khtu") ) {
//                    beans.put(beanFactory.getBean(beanDefinitionName).getClass().getCanonicalName(), beanDefinitionName);
                    beanList.add(beanFactory.getBean(beanDefinitionName).getClass().getCanonicalName());
                }
            }
        }
        String[] beans = new String[beanList.size()];
        beanList.toArray(beans);
        Arrays.sort(beans);
        System.out.println();
    }

}
