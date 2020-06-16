package miu.edu.cs425.SEProject.eHouseRentAPI.config;

import miu.edu.cs425.SEProject.eHouseRentAPI.filter.JwtRequestFilter;
import miu.edu.cs425.SEProject.eHouseRentAPI.service.impl.MyUserDetailService;
import miu.edu.cs425.SEProject.eHouseRentAPI.utill.AuthEntryPointJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

//@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)//securedEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

//    public WebSecurityConfig(ElibraryUserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**");
//    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }

//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(this.userDetailsService)
//                .passwordEncoder(passwordEncoder());
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable();
        http
                .authorizeRequests().antMatchers("/ehouserent/signin").permitAll()
                .antMatchers("/ehouserent/user/role/*").permitAll()
                .antMatchers("/ehouserent/user/**").permitAll()
                .antMatchers("/ehouserent/house/search/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

 // with out JWT
//        http.csrf().disable();
//        http.authorizeRequests()
//                .antMatchers("/ehouserent/house/add").hasRole("Owner")
//                .antMatchers("/ehouserent/house/delete").hasRole("Owner")
//                .antMatchers("/ehouserent/house/list").permitAll()
//                .anyRequest().authenticated()
//            .and().httpBasic();
//                .headers()
//                .frameOptions().sameOrigin()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/resources/static/**", "/images/**", "/css/**", "/elibrary/public/**").permitAll()
//                .antMatchers("/", "/elibrary").permitAll()
//                .antMatchers("/elibrary/secured/services/admin/**").hasRole("ADMIN")
//                .antMatchers("/elibrary/secured/services/librarian/**").hasRole("LIBRARIAN")
//                .antMatchers("/elibrary/secured/services/libmember/**").hasRole("LIBMEMBER")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/elibrary/public/login")
//                .defaultSuccessUrl("/elibrary/secured/home")
//                .failureUrl("/elibrary/public/login?error")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/elibrary/public/logout"))
//                .logoutSuccessUrl("/elibrary/public/login?logout")
//                .permitAll()
//                .and()
//                .exceptionHandling();
    }
}
