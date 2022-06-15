package com.nhnacademy.springboot.taskgateway.adapter.impl;

import com.nhnacademy.springboot.taskgateway.adapter.AccountAdapter;
import com.nhnacademy.springboot.taskgateway.domain.AccountDto;
import com.nhnacademy.springboot.taskgateway.domain.AccountRegisterRequestDto;
import com.nhnacademy.springboot.taskgateway.domain.AccountVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AccountAdapterImpl implements AccountAdapter {
    private final RestTemplate restTemplate;
    @Value("${host&port}")
    private String host;

    @Override
    public AccountVO getAccountVOBy(String username) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<AccountVO> exchange = restTemplate.exchange(host+"/account/" + username,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {});
        return exchange.getBody();
    }

    @Override
    public AccountVO create(AccountRegisterRequestDto account) {
        RequestEntity<AccountRegisterRequestDto> requestEntity = RequestEntity
                .post(host + "/account/register")
                .accept(MediaType.APPLICATION_JSON)
                .body(account);

        ResponseEntity<AccountVO> exchange = restTemplate.exchange(requestEntity,
                new ParameterizedTypeReference<>() {});

        return exchange.getBody();
    }

    @Override
    public boolean checkIdExists(String id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Boolean> exchange = restTemplate.exchange(host + "/account/check/" + id,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {});
        return Boolean.TRUE.equals(exchange.getBody());
    }

    @Override
    public List<AccountDto> findAccountDtoListBy(String state) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<AccountDto>> exchange = restTemplate.exchange(host + "/account/list/" + state,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {});
        return exchange.getBody();
    }
}
