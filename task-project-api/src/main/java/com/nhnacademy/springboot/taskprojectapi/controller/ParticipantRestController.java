package com.nhnacademy.springboot.taskprojectapi.controller;

import com.nhnacademy.springboot.taskprojectapi.entity.Participant;
import com.nhnacademy.springboot.taskprojectapi.request.ParticipantRegisterRequest;
import com.nhnacademy.springboot.taskprojectapi.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/participant")
public class ParticipantRestController {
    private final ParticipantService participantService;
    @PostMapping("/register/member")
    public Participant doRegisterMember(@RequestBody ParticipantRegisterRequest participantRegisterRequest){
        return participantService.registerMember(participantRegisterRequest);
    }
}
