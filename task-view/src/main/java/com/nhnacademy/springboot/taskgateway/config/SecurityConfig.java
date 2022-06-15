package com.nhnacademy.springboot.taskgateway.config;

import com.nhnacademy.springboot.taskgateway.auth.LoginSuccessHandler;
import com.nhnacademy.springboot.taskgateway.auth.LogoutHandlerImpl;
import com.nhnacademy.springboot.taskgateway.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@EnableWebSecurity(debug = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/account/list/**").authenticated()
                .antMatchers("/milestone/**").authenticated()
                .antMatchers("/participant/**").authenticated()
                .antMatchers("/project/**").authenticated()
                .antMatchers("/tag/**").authenticated()
                .antMatchers("/task/**").authenticated()
                .antMatchers("/signIn").anonymous()
                .antMatchers("/account/register").anonymous()
                .anyRequest().permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/error/403")
                .and()
                .formLogin()
                    .usernameParameter("id")
                    .passwordParameter("password")
                    .loginProcessingUrl("/login")
                    .loginPage("/signIn")
                    .successForwardUrl("/")
                    .successHandler(loginSuccessHandler(null))
                        .and()
                .logout()
                    .deleteCookies("JSESSIONID","SESSION")
                    .invalidateHttpSession(true)
                    .logoutSuccessUrl("/")
                    .addLogoutHandler(logoutHandler(null))
                        .and()
                .csrf().disable()
                .sessionManagement()
                .sessionFixation().none();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider(null));
    }

    @Bean
    public AuthenticationProvider authenticationProvider(
            UserDetailsServiceImpl userDetailsServiceImpl) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsServiceImpl);
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler(RedisTemplate<String, String> redisTemplate) {
        return new LoginSuccessHandler(redisTemplate);
    }

    @Bean
    public LogoutHandler logoutHandler(RedisTemplate<String, String> redisTemplate){
        return new LogoutHandlerImpl(redisTemplate);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
