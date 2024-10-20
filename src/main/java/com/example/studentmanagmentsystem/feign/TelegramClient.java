package com.example.studentmanagmentsystem.feign;

import com.example.studentmanagmentsystem.dto.telegram.TelegramResponseDto;
import com.example.studentmanagmentsystem.dto.telegram.TelegramSendMessageDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "telegram-client", url = "https://api.telegram.org/bot7088090581:AAHpuDPuYJPYZZKEjNUdXCzt28oi1VZAIX0/")
public interface TelegramClient {
    @GetMapping("getUpdates")
    TelegramResponseDto getUpdates(@RequestParam int offset);


    @PostMapping("/sendMessage")
    void sendMessage(@RequestBody TelegramSendMessageDto telegramSendMessageDto);
}
