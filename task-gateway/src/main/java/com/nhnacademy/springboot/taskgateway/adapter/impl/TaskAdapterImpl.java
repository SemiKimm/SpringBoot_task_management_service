package com.nhnacademy.springboot.taskgateway.adapter.impl;

import com.nhnacademy.springboot.taskgateway.adapter.TaskAdapter;
import com.nhnacademy.springboot.taskgateway.domain.AccountVO;
import com.nhnacademy.springboot.taskgateway.domain.TaskDto;
import com.nhnacademy.springboot.taskgateway.request.ProjectRegisterRequest;
import com.nhnacademy.springboot.taskgateway.request.TaskRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TaskAdapterImpl implements TaskAdapter {
    private final RestTemplate restTemplate;

    @Override
    public List<TaskDto> findTaskDtoList(Integer projectNo) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<TaskDto>> exchange = restTemplate.exchange("http://localhost:9999/task/list/"+projectNo,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {});
        return exchange.getBody();
    }

    @Override
    public void create(Integer projectNo, String accountId, TaskRegisterRequest taskRegisterRequest) {
        RequestEntity<TaskRegisterRequest> requestEntity = RequestEntity
                .post("http://localhost:9999/task/register/" + projectNo + "/" + accountId)
                .accept(MediaType.APPLICATION_JSON)
                .body(taskRegisterRequest);

        restTemplate.exchange(requestEntity,
                new ParameterizedTypeReference<>() {});
    }
}
