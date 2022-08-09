package com.sain.Service;

import com.sain.Model.RequestEntity;
import com.sain.Model.Response;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;

public interface ReportsService {

    public Response generateReportWithTable(RequestEntity requestEntity) throws JRException;

    public Response generateReportWithoutTable(RequestEntity requestEntity);

}
