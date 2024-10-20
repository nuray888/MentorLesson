package com.example.studentmanagmentsystem.dto.telegram;

import java.util.ArrayList;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TelegramResponseDto {
    public boolean ok;
    public ArrayList<Result> result;
}
