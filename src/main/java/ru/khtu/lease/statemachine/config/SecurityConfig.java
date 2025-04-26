package ru.khtu.lease.statemachine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@Configuration
public class SecurityConfig  //extends WebSecurityConfig //WebSecurityConfigurerAdapter
{

        //@Override protected void configure(HttpSecurity http) throws Exception {
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.authorizeRequests(
                    request -> request.requestMatchers(
                            new AntPathRequestMatcher("/api/0.0.1/open/**") )
                            .permitAll() );
            return http.build();
        }

        /*@Bean public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            return http.authorizeHttpRequests(request -> request.requestMatchers(new AntPathRequestMatcher("/products/**"))
                            .permitAll())
                    .authorizeHttpRequests(request -> request.requestMatchers(new AntPathRequestMatcher("/customers/**"))
                            .hasRole("ADMIN")
                            .anyRequest()
                            .authenticated())
                    .httpBasic(Customizer.withDefaults())
                    .build();}*/

        /*http.authorizeRequests()
                .requestMatchers(
                        PathRequest
                                .toStaticResources()
                                .atCommonLocations()).permitAll()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(
                        new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login");*/

}
