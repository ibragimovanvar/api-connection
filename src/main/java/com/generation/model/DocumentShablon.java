package com.generation.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentShablon {
    private String name;
    private String desc;
    private List<ExamStudent> students;
    private String createdBy;
}
