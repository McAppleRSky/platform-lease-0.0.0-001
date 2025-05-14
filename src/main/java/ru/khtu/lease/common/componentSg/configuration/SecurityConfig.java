package ru.khtu.lease.common.componentSg.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
//@EnableWebSecurity(debug=true)
//@EnableMethodSecurity
public class SecurityConfig {

    @Value("${config.admin.name}") private String username;

    @Value("${config.admin.pass}") private String userpass;

    @Value("${config.admin.pass.testseq}") private String testSeq;
//    @Value("${config.admin.request.empty}") private String queryEmptyAdmin;

//    @Value("${config.admin.request.fill}") private String queryFillAdmin;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Value("${config.auth.request.user}")
    private String queryAdmin;

    @Value("${config.auth.request.role}")
    private String queryRole;

//    @Autowired private HikariDataSource dataSource;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, HikariDataSource dataSource) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(queryAdmin)
                .authoritiesByUsernameQuery(queryRole);
    }

//    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        /*UserDetails user1 = User.withUsername("user1")
                .password(passwordEncoder().encode("user1Pass"))
                .roles("USER")
                .build();
        UserDetails user2 = User.withUsername("user2")
                .password(passwordEncoder().encode("user2Pass"))
                .roles("USER")
                .build();*/
        UserDetails admin = User
                .withUsername(username)
                .password(passwordEncoder().encode(userpass))
                .roles("ADMIN","USER")
                .build();
        return new InMemoryUserDetailsManager(/*user1, user2,*/ admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        if (jdbcTemplate.queryForObject(queryEmptyAdmin, Integer.class) == 1) jdbcTemplate.update(queryFillAdmin, passwordEncoder().encode(testSeq));
        return httpSecurity
                .csrf(
                        cfg -> cfg.ignoringAntMatchers("/api/0.0.1/open/**") )
                .authorizeHttpRequests(
                cfg -> {
                    try {
                        cfg.requestMatchers(
                                        new AntPathRequestMatcher("/api/0.0.1/open/**"),
                                        PathRequest
                                                .toStaticResources()
                                                .atCommonLocations() ).permitAll()
                                .anyRequest().authenticated()
                                .and()
                                .formLogin().loginPage("/login").permitAll()
                                .and()
                                .logout()
                                .logoutRequestMatcher(
                                        new AntPathRequestMatcher("/logout"))
                                .logoutSuccessUrl("/login");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
//                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
//                .csrf().disable()
                .build();
    }

}
