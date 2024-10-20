package com.example.studentmanagmentsystem.dto.telegram;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Result {
    public int update_id;
    public Message message;
}
