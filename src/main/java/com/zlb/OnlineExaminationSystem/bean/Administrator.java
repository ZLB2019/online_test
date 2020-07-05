package com.zlb.OnlineExaminationSystem.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrator {
    private Integer administrator_id;
    private String administrator_password;
}
