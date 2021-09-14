package com.sunny.poa.config;

import com.sunny.poa.service.impl.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private MyUserDetailsService myUserDetailsService;
   @Bean
    AuthenticationProvider KaptchaAuthenticationProvider(){
        KaptchaAuthenticationProvider provider=new KaptchaAuthenticationProvider();
        provider.setUserDetailsService(myUserDetailsService);
        return provider;
    }
    public AuthenticationManager authenticationManagerBean(){
        ProviderManager manager=new ProviderManager(KaptchaAuthenticationProvider());
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                anyRequest().authenticated().and().
                formLogin().loginPage("").
                loginProcessingUrl("").successHandler(new MyAuthenticationSuccessHandler()).
                failureUrl("").failureHandler(new MyAuthenticationFailureHandler()).
                usernameParameter("").passwordParameter("").permitAll()
                .and().logout().invalidateHttpSession(true).clearAuthentication(true).logoutSuccessUrl("").
                and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }
}
