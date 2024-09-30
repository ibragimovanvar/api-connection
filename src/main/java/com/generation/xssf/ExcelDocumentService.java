package com.generation.xssf;

import com.generation.model.WorkbookTemplate;
import org.apache.poi.ss.usermodel.Workbook;

public interface ExcelDocumentService {

    public abstract Workbook createWorkbookWithTemplate(WorkbookTemplate workbookTemplate);

}
