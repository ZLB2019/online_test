package com.zlb.OnlineExaminationSystem.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    private Integer user_id;
    private Integer user_grade;
    private String time;
}
