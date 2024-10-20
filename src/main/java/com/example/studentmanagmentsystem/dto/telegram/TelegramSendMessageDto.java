package com.example.studentmanagmentsystem.dto.telegram;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TelegramSendMessageDto {
    private Long chat_id;
    private String text;
}
