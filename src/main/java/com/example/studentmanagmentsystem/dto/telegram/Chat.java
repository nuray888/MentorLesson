package com.example.studentmanagmentsystem.dto.telegram;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Chat {
    public long id;
    public String first_name;
    public String username;
    public String type;
}
