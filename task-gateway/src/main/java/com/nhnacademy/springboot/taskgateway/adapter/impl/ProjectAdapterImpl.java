package com.nhnacademy.springboot.taskgateway.adapter.impl;

import com.nhnacademy.springboot.taskgateway.adapter.ProjectAdapter;
import com.nhnacademy.springboot.taskgateway.domain.AccountRegisterRequestDto;
import com.nhnacademy.springboot.taskgateway.domain.AccountVO;
import com.nhnacademy.springboot.taskgateway.domain.ParticipantProjectDto;
import com.nhnacademy.springboot.taskgateway.domain.ProjectDto;
import com.nhnacademy.springboot.taskgateway.request.ProjectModifyRequest;
import com.nhnacademy.springboot.taskgateway.request.ProjectRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ProjectAdapterImpl implements ProjectAdapter {
    private final RestTemplate restTemplate;

    @Override
    public void createProject(String accountId, ProjectRegisterRequest projectRegisterRequest) {
        RequestEntity<ProjectRegisterRequest> requestEntity = RequestEntity
                .post("http://localhost:9999/project/register/" + accountId)
                .accept(MediaType.APPLICATION_JSON)
                .body(projectRegisterRequest);

        ResponseEntity<AccountVO> exchange = restTemplate.exchange(requestEntity,
                new ParameterizedTypeReference<>() {});
    }

    @Override
    public Integer modifyProject(Integer projectNo, ProjectModifyRequest projectModifyRequest) {
        RequestEntity<ProjectModifyRequest> requestEntity = RequestEntity
                .put("http://localhost:9999/project/"+projectNo+"/modify")
                .accept(MediaType.APPLICATION_JSON)
                .body(projectModifyRequest);

        ResponseEntity<Integer> exchange = restTemplate.exchange(requestEntity,
                new ParameterizedTypeReference<>() {});

        return exchange.getBody();
    }


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
    public Optional<ProjectDto> findProject(Integer projectNo) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Optional<ProjectDto>> exchange = restTemplate.exchange("http://localhost:9999/project/" + projectNo,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {});
        return exchange.getBody();
    }
}
