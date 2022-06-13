package com.nhnacademy.springboot.taskprojectapi.controller;

import com.nhnacademy.springboot.taskprojectapi.domain.ParticipantDto;
import com.nhnacademy.springboot.taskprojectapi.entity.Participant;
import com.nhnacademy.springboot.taskprojectapi.request.ParticipantRegisterRequest;
import com.nhnacademy.springboot.taskprojectapi.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/participant")
public class ParticipantRestController {
    private final ParticipantService participantService;
    @PostMapping("/register/member")
    public Participant doRegisterMember(@RequestBody ParticipantRegisterRequest participantRegisterRequest){
        return participantService.registerMember(participantRegisterRequest);
    }

    @DeleteMapping("/{projectNo}/{memberId}")
    public String doDeleteMember(@PathVariable("projectNo") Integer projectNo,
                                 @PathVariable("memberId") String memberId){
        return participantService.deleteMember(projectNo, memberId);
    }

    @GetMapping("/{projectNo}")
    public List<ParticipantDto> getParticipantList(@PathVariable("projectNo") Integer projectNo){
        return participantService.getParticipants(projectNo);
    }

    @GetMapping("/check/{projectNo}/{accountId}")
    public Boolean checkDuplication(@PathVariable("projectNo") Integer projectNo,
                                    @PathVariable("accountId") String accountId){
        return participantService.exists(projectNo, accountId);
    }

    @GetMapping("/{projectNo}/{accountId}")
    public Optional<ParticipantDto> getParticipantDto(@PathVariable("projectNo") Integer projectNo,
                                                      @PathVariable("accountId") String accountId){
        return participantService.getParticipantDto(projectNo, accountId);
    }
}
