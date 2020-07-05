package com.zlb.OnlineExaminationSystem.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Results {
    private Integer results_id;
    private Integer title_id;
    private String results_name;
    private Integer is_correct;
}
