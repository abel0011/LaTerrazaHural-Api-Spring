package com.idat.LaTerrazaHuaral.security;

import com.idat.LaTerrazaHuaral.security.jwt.JWTFilterRequest;
import com.idat.LaTerrazaHuaral.security.jwt.UserDetailsCustomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsCustomService userDetailsCustomService;

    // nuestro filtro modificado para que use JWT

    @Autowired
    private JWTFilterRequest jwtFilterRequest;

    // le indicamos que usara nuestra configuracion de autenticacion
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsCustomService);
    }

    // configuracion de http
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // desabilitaras la proteccion de enlaces cruzados en los siguientes url
        // ("/**/authenticate") y sera
        // permitido el acceso
        // http.authorizeRequests().antMatchers("/**/swagger-ui**").permitAll();

        http.csrf().disable().authorizeRequests().antMatchers("/**/registerPerson","/**/authenticate", 
                 "/**/registerUser", "/**/public/**")
                 .permitAll()
                .anyRequest().authenticated().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // y las demas peticiones si necesitaran autenticacion
        // y que las sesiones estaran desactivadas esto porque siempre se usara el token
        // para su autenticacion
        // se a??ade filtro antes de ejecutar una peticion que sera de tipo usuario y
        // contrase??a
        http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);
        // habilita el cors
        http.cors();
    }

    // rutas a ignorar filtros
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
                "/configuration/security", "/swagger-ui/**", "/webjars/**");
    }

    // le indicamos que implicitamente las configuraciones que realizemos las use
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // se agrega cors globalmente para todos endpoints
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .exposedHeaders("Authorization").allowedMethods("*");
            }
        };
    }

    
}
