package com.sain.Controller;

import com.sain.Model.RequestEntity;
import com.sain.Model.Response;
import com.sain.Service.ReportsService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/report")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ReportController {

    @Autowired
    private ReportsService reportsService;

    @PostMapping(value = "/generate")
    public Response generate(@RequestBody RequestEntity requestEntity) throws JRException {
        return reportsService.generateReportWithTable(requestEntity);
    }

    @PostMapping(value = "/generateNoTable")
    public Response generateNoTable(@RequestBody RequestEntity requestEntity) throws JRException {
        return reportsService.generateReportWithoutTable(requestEntity);
    }

}
