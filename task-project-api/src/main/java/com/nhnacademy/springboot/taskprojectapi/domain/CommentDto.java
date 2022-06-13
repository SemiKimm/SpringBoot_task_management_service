package com.nhnacademy.springboot.taskprojectapi.domain;

import java.time.LocalDateTime;

public interface CommentDto {
    Integer getNo();
    String getWriterId();
    String getContent();
    LocalDateTime getWriteDateTime();
    LocalDateTime getModifyDateTime();
}
