package com.nhnacademy.springboot.taskgateway.auth;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class LogoutHandlerImpl implements LogoutHandler {
    private final RedisTemplate<String,String> redisTemplate;

    public LogoutHandlerImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        HttpSession session = request.getSession(false);
        if(Objects.nonNull(session)){
            redisTemplate.delete(session.getId());
        }
    }
}