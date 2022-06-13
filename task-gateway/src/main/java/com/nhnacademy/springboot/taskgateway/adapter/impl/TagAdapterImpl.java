package com.nhnacademy.springboot.taskgateway.adapter.impl;

import com.nhnacademy.springboot.taskgateway.adapter.TagAdapter;
import com.nhnacademy.springboot.taskgateway.domain.TagDto;
import com.nhnacademy.springboot.taskgateway.request.TagRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<TagDto> findTagDto(Integer tagNo) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Optional<TagDto>> exchange = restTemplate.exchange("http://localhost:9999/tag/" + tagNo,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {});
        return exchange.getBody();
    }

    @Override
    public Integer update(Integer tagNo, TagRequest tagRequest) {
        RequestEntity<TagRequest> requestEntity = RequestEntity
                .put("http://localhost:9999/tag/" + tagNo)
                .accept(MediaType.APPLICATION_JSON)
                .body(tagRequest);

        ResponseEntity<Integer> exchange =restTemplate.exchange(requestEntity,
                new ParameterizedTypeReference<>() {});

        return exchange.getBody();
    }

    @Override
    public String deleteByNo(Integer tagNo) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:9999/tag/" + tagNo,
                HttpMethod.DELETE,
                requestEntity,
                new ParameterizedTypeReference<>() {});
        return exchange.getBody();
    }
}
