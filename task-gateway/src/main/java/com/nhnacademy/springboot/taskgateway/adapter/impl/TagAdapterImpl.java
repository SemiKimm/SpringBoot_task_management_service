package com.nhnacademy.springboot.taskgateway.adapter.impl;

import com.nhnacademy.springboot.taskgateway.adapter.TagAdapter;
import com.nhnacademy.springboot.taskgateway.domain.MilestoneDto;
import com.nhnacademy.springboot.taskgateway.domain.TagDto;
import com.nhnacademy.springboot.taskgateway.request.MilestoneRequest;
import com.nhnacademy.springboot.taskgateway.request.TagRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TagAdapterImpl implements TagAdapter {
    private final RestTemplate restTemplate;

    @Override
    public List<TagDto> findTagDtoList(Integer projectNo) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<TagDto>> exchange = restTemplate.exchange("http://localhost:9999/tag/list/" + projectNo,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {});
        return exchange.getBody();
    }

    @Override
    public void create(Integer projectNo, TagRequest tagRequest) {
        RequestEntity<TagRequest> requestEntity = RequestEntity
                .post("http://localhost:9999/tag/register/" + projectNo)
                .accept(MediaType.APPLICATION_JSON)
                .body(tagRequest);

        restTemplate.exchange(requestEntity,
                new ParameterizedTypeReference<>() {});
    }
}
