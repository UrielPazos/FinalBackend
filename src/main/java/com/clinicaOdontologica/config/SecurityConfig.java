package com.clinicaOdontologica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Deshabilitar CSRF
                .authorizeRequests()
                .antMatchers("/login", "/paciente", "/odontologo/**", "/turno/**").permitAll() // Permitir acceso a estos endpoints sin autenticación
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN") // Restringir acceso a ADMIN
                .anyRequest().authenticated() // Cualquier otra solicitud requiere autenticación
                .and()
                .formLogin()
                .loginPage("/login") // Página de login personalizada
                .defaultSuccessUrl("/home", true) // Página a la que se redirige después de un login exitoso
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout") // Endpoint para cerrar sesión
                .logoutSuccessUrl("/login") // Página a la que se redirige después de cerrar sesión
                .permitAll();

                http.headers().frameOptions().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // Mantener contraseñas en texto plano
    }
}




