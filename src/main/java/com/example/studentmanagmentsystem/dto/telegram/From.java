package com.example.studentmanagmentsystem.dto.telegram;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class From {
    public long id;
    public boolean is_bot;
    public String first_name;
    public String username;
    public String language_code;
}
