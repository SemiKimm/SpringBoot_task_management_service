package com.nhnacademy.springboot.taskgateway.controller;

import com.nhnacademy.springboot.taskgateway.domain.ParticipantDto;
import com.nhnacademy.springboot.taskgateway.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/participant")
public class ParticipantController {
    private final ParticipantService participantService;

    @GetMapping("/list/{projectNo}")
    public String participantList(@PathVariable("projectNo") Integer projectNo,
                                  Principal principal,
                                  Model model){
        List<ParticipantDto> participants = participantService.getParticipantDtoList(projectNo);
        String userAuthority = participants.stream()
                .filter(participantDto -> participantDto.getPk()
                        .getParticipantId().equals(principal.getName()))
                .findFirst().orElseThrow(() -> new NotFoundException("participant")).getAuthority();

        model.addAttribute("participants", participants);
        model.addAttribute("projectNo", projectNo);
        model.addAttribute("userAuthority", userAuthority);

        return "participant/participantList";
    }

    @GetMapping("/register/{projectNo}/{accountId}")
    public String doRegister(@PathVariable("projectNo") Integer projectNo,
                             @PathVariable("accountId") String accountId){
        participantService.register(projectNo, accountId);

        return "redirect:/participant/list/"+projectNo;
    }
}
