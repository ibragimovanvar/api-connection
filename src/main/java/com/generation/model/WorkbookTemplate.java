package com.generation.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkbookTemplate {

    private String originalFileName;
    private String sheetName;
    private List<Workplace> workplaceList;
    private String workerFullName;
    private String createdDate;

}
