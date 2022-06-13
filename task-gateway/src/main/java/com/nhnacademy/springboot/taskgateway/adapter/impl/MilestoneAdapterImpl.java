package com.nhnacademy.springboot.taskgateway.adapter.impl;

import com.nhnacademy.springboot.taskgateway.adapter.MilestoneAdapter;
import com.nhnacademy.springboot.taskgateway.domain.AccountVO;
import com.nhnacademy.springboot.taskgateway.domain.MilestoneDto;
import com.nhnacademy.springboot.taskgateway.request.MilestoneRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Component
public class MilestoneAdapterImpl implements MilestoneAdapter {
    private final RestTemplate restTemplate;

    @Override
    public List<MilestoneDto> findMilestoneDtoList(Integer projectNo, String state) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<MilestoneDto>> exchange = restTemplate.exchange("http://localhost:9999/milestone/list/" + projectNo + "/" + state,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {});
        return exchange.getBody();
    }

    @Override
    public void create(Integer projectNo, MilestoneRequest milestoneRequest) {
        RequestEntity<MilestoneRequest> requestEntity = RequestEntity
                .post("http://localhost:9999/milestone/register/" + projectNo)
                .accept(MediaType.APPLICATION_JSON)
                .body(milestoneRequest);

        ResponseEntity<AccountVO> exchange = restTemplate.exchange(requestEntity,
                new ParameterizedTypeReference<>() {});
    }
}
