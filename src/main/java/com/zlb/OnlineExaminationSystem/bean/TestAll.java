package com.zlb.OnlineExaminationSystem.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestAll {
    private Title title;
    private ArrayList<Results> resultsArrayList;
}
