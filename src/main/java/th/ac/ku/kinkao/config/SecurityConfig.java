package th.ac.ku.kinkao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    // chaining method จุดต่อกันไปเรื่อยๆ
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/js/**").permitAll() // หน้าเว็บที่เข้าได้โดยไม่ต้อง login
                .anyRequest().authenticated() // หน้าอื่นๆต้องผ่านการ login ถึงจะเข้าได้

        .and()
                .oauth2Login()
                .defaultSuccessUrl("/").permitAll() // config login

        .and()
                .logout()
                .logoutSuccessUrl("/").permitAll(); // config logout
    }
}
