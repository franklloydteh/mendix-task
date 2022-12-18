package com.franklloydteh.qumulus.mendixtask.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {

    private String title;
    private String description;
    private Date dueDate;
    private String priority;
    private String status;


}


