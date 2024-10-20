package com.example.studentmanagmentsystem.dto.telegram;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {
    public int message_id;
    public From from;
    public Chat chat;
    public int date;
    public String text;
}
