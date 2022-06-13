package com.nhnacademy.springboot.taskgateway.adapter.impl;

import com.nhnacademy.springboot.taskgateway.adapter.ProjectAdapter;
import com.nhnacademy.springboot.taskgateway.domain.AccountRegisterRequestDto;
import com.nhnacademy.springboot.taskgateway.domain.AccountVO;
import com.nhnacademy.springboot.taskgateway.domain.ParticipantProjectDto;
import com.nhnacademy.springboot.taskgateway.request.ProjectRegisterRequest;
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

    @Override
    public void createProject(String accountId, ProjectRegisterRequest projectRegisterRequest) {
        RequestEntity<ProjectRegisterRequest> requestEntity = RequestEntity
                .post("http://localhost:9999/project/register/" + accountId)
                .accept(MediaType.APPLICATION_JSON)
                .body(projectRegisterRequest);

        ResponseEntity<AccountVO> exchange = restTemplate.exchange(requestEntity,
                new ParameterizedTypeReference<>() {});
    }
}
