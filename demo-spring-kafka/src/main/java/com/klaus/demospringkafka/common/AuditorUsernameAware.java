package com.klaus.demospringkafka.common;

import com.klaus.demospringkafka.school.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringkafka.common AuditorUsernameAware
 * @description:
 * @date 2019/3/1 21:52
 */

@Slf4j
public class AuditorUsernameAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        log.debug("Getting the username of authenticated user.");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            log.debug("Current user is anonymous. Returning null.");
            return Optional.of("");
        }
        String username = ((User) authentication.getPrincipal()).getUsername();
        log.debug("Returning username: {}", username);
        return Optional.of(username);
    }
}

