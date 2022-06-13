package com.nhnacademy.springboot.taskgateway.adapter.impl;

import com.nhnacademy.springboot.taskgateway.adapter.ProjectAdapter;
import com.nhnacademy.springboot.taskgateway.domain.ParticipantProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProjectAdapterImpl implements ProjectAdapter {
    private final RestTemplate restTemplate;

    @Override
    public List<ParticipantProjectDto> findProjectList(String accountId, String state) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<ParticipantProjectDto>> exchange = restTemplate.exchange("http://localhost:9999/project/list/" + accountId + "/" + state,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {});
        return exchange.getBody();
    }
}
