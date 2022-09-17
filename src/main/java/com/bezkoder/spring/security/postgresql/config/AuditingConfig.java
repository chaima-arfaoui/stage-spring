package com.bezkoder.spring.security.postgresql.config;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.bezkoder.spring.security.postgresql.models.User;
import com.bezkoder.spring.security.postgresql.security.UserPrincipal;
import com.bezkoder.spring.security.postgresql.security.services.UserDetailsImpl;
 
@Configuration
@EnableJpaAuditing
public class AuditingConfig {
 
    @Bean
    public Optional<Long> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
 
        if (authentication == null ||
                !authentication.isAuthenticated() ||
                authentication instanceof AnonymousAuthenticationToken) {
        	System.err.println("!!!!!");
            return Optional.empty();
        }
 
        UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();
        System.out.println(userDetails.toString());
 
        return Optional.ofNullable(userDetails.getId());
    }
}