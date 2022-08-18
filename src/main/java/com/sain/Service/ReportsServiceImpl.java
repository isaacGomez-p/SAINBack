package com.sain.Service;

import com.sain.Model.RequestEntity;
import com.sain.Model.Response;
import com.sain.Model.ResumeEntity;
import com.sain.Repository.ResumeRepository;
import com.sain.Utils.WriteReport;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Service
public class ReportsServiceImpl implements ReportsService {

    @Autowired
    private ResumeRepository resumeRepository;
    @Autowired
    private WriteReport writeReportl;

    @Transactional(readOnly = true)
    public Response generateReportWithTable(RequestEntity requestEntity) throws JRException {
        byte[] report;
        Optional<ResumeEntity> optional = resumeRepository.findById(requestEntity.getId());
        if(optional != null && optional.isPresent()){
            Map<String, Object> parameter = new HashMap<>();
            parameter.put("numberId", optional.get().getNumberId());
            parameter.put("name", optional.get().getName());
            parameter.put("profile", optional.get().getProfile());
            parameter.put("concept", optional.get().getStatus());
            report = writeReportl.createJasperPDF("reportWithTable.jasper", parameter);
            String base64 = Base64.getEncoder().encodeToString(report);
            return new Response(HttpStatus.OK, "Report Generated", base64);
        }else{
            return new Response(HttpStatus.CONFLICT, "Error");
        }
    }

    @Transactional(readOnly = true)
    public Response generateReportWithoutTable(RequestEntity requestEntity) {
        byte[] report;
        Optional<ResumeEntity> optional = resumeRepository.findById(requestEntity.getId());
        if(optional != null && optional.isPresent()){
            Map<String, Object> parameter = new HashMap<>();
            parameter.put("name", this.textReportNoTable(optional.get()));
            report = writeReportl.createJasperPDF("reportWithoutTable.jasper", parameter);
            String base64 = Base64.getEncoder().encodeToString(report);
            return new Response(HttpStatus.OK, "Report Generated", base64);
        }else{
            return new Response(HttpStatus.CONFLICT, "Error");
        }
    }

    @Transactional(readOnly = true)
    public Response generateExcel(RequestEntity requestEntity) throws IOException {
        List<ResumeEntity> resumeEntities = null;
        if(requestEntity.getData1() == null || requestEntity.getData1().equals("")){
            resumeEntities = resumeRepository.findByCreationDateBetween(requestEntity.getStartDate(), requestEntity.getEndDate());
        } else {
            resumeEntities = resumeRepository.findByCreationDateBetweenAndStatus(requestEntity.getStartDate(), requestEntity.getEndDate(), requestEntity.getData1());
        }
        String base64 = Base64.getEncoder().encodeToString(writeReportl.export(resumeEntities));
        return new Response(HttpStatus.OK, "Report Generated", base64);
    }

    private String textReportNoTable (ResumeEntity resumeEntity){
        return "Que se realizó el respectivo análisis Pre empleo " +
                resumeEntity.getProfile()  + " al candidato " +
                resumeEntity.getName() +" identificado con Cédula de Ciudadanía No " +
                resumeEntity.getNumberId() +" con resultado " +
                resumeEntity.getStatus() +" para su contratación.";
    }
}
