package com.example.studentmanagmentsystem.dto.feign;

import lombok.Data;

import java.util.ArrayList;
@Data
public class KnowledgeResponse {
    public int atomicMass;
    public int atomicNumber;
    public int ionizationEnergy;
    public String elementGroup;
    public int group;
    public String name;
    public int period;
    public String symbol;
    public ArrayList<Integer> electronsPerShell;
    public String nameLatin;
    public String nameDE;
}
