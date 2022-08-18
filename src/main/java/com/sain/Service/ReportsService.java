package com.sain.Service;

import com.sain.Model.RequestEntity;
import com.sain.Model.Response;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ReportsService {

    public Response generateReportWithTable(RequestEntity requestEntity) throws JRException;

    public Response generateReportWithoutTable(RequestEntity requestEntity);

    public Response generateExcel(RequestEntity requestEntity) throws IOException;

}
