package com.example.studentmanagmentsystem.service;

import com.example.studentmanagmentsystem.dto.telegram.Result;
import com.example.studentmanagmentsystem.dto.telegram.TelegramResponseDto;
import com.example.studentmanagmentsystem.dto.telegram.TelegramSendMessageDto;
import com.example.studentmanagmentsystem.feign.TelegramClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TelegramService {
    private final TelegramClient telegramClient;
    private int offset = 0;

//    @Scheduled(fixedRate = 10000)
    public void getUpdate() {
        TelegramResponseDto updates = telegramClient.getUpdates(offset);
        for (Result result : updates.getResult()) {

            String newMessage =result.getMessage().getText();
            log.info("Updates : {}", newMessage);

            if (newMessage.equals("Salam")) {
                sendMessage("Aleykum Salam", result.getMessage().getChat().getId());
            }


            offset = result.getUpdate_id() + 1;
        }
    }

    public void sendMessage(String text, Long chatId) {
        TelegramSendMessageDto telegramSendMessageDto = TelegramSendMessageDto.builder()
                .text(text)
                .chat_id(chatId)
                .build();

        telegramClient.sendMessage(telegramSendMessageDto);

    }


}
