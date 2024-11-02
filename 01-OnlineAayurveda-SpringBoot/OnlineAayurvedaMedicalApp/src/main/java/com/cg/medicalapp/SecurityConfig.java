//package com.cg.medicalapp;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//    
//    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//        .authorizeRequests()
//         .antMatchers(HttpMethod.GET,"/api/v1/customer","/api/v1/carts","/api/v1/order","/api/v1/orders","/api/v1/orderbycustomer")
//         .hasRole("ADMIN")
//         .antMatchers(HttpMethod.DELETE,"/api/v1/medicine" , "/api/v1/category")
//         .hasRole("ADMIN")
//         .antMatchers(HttpMethod.POST,"/api/v1/medicine" , "/api/v1/category")
//         .hasRole("ADMIN")
//         .antMatchers(HttpMethod.PUT,"/api/v1/medicine" , "/api/v1/category" , "/api/v1/orderstatus")
//         .hasRole("ADMIN")
//         .antMatchers(HttpMethod.GET,"/api/v1/customers" , "/api/v1/medicine" , "/api/v1/medicines" , "/api/v1/category" , "/api/v1/categories" , "/api/v1/cart")
//         .hasRole("ADMIN")
//         
//       .anyRequest()
//       .authenticated()
//       .and()
//       .httpBasic();
//      http.csrf().disable();
//         
//    }
//
//
//
//   @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//
//        auth.inMemoryAuthentication()
//        .withUser("user")
//        .password(passwordEncoder().encode("user"))
//        .roles("USER")
//        .and()
//        .withUser("admin")
//        .password(passwordEncoder().encode("admin"))
//        .roles("ADMIN");
//        }
//    
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    
//    
//}