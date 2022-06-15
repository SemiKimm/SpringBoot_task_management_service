package com.nhnacademy.springboot.taskgateway.adapter.impl;

import com.nhnacademy.springboot.taskgateway.adapter.ParticipantAdapter;
import com.nhnacademy.springboot.taskgateway.domain.AccountVO;
import com.nhnacademy.springboot.taskgateway.domain.ParticipantDto;
import com.nhnacademy.springboot.taskgateway.request.ParticipantRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ParticipantAdapterImpl implements ParticipantAdapter {
    private final RestTemplate restTemplate;

    @Override
    public Optional<ParticipantDto> getParticipantDto(Integer projectNo, String accountId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Optional<ParticipantDto>> exchange = restTemplate.exchange("http://localhost:9999/participant/" + projectNo + "/" + accountId,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {});
        return exchange.getBody();
    }

    @Override
    public List<ParticipantDto> getParticipantDtoList(Integer projectNo) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<ParticipantDto>> exchange = restTemplate.exchange("http://localhost:9999/participant/" + projectNo,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {});
        return exchange.getBody();
    }

    @Override
    public Boolean isDuplicated(Integer projectNo, String accountId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Boolean> exchange = restTemplate.exchange("http://localhost:9999/participant/check/" + projectNo + "/" + accountId,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {});
        return Boolean.TRUE.equals(exchange.getBody());
    }

    @Override
    public void create(ParticipantRegisterRequest participantRegisterRequest) {
        RequestEntity<ParticipantRegisterRequest> requestEntity = RequestEntity
                .post("http://localhost:9999/participant/register/member")
                .accept(MediaType.APPLICATION_JSON)
                .body(participantRegisterRequest);

        ResponseEntity<AccountVO> exchange = restTemplate.exchange(requestEntity,
                new ParameterizedTypeReference<>() {});
    }
}
