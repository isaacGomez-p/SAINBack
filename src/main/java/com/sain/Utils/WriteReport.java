package com.sain.Utils;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Component
public class WriteReport {

    public byte[] createJasperPDF(String template, Map<String, Object> parameter){
        try{
            JasperPrint print = this.printJasper(template, parameter);
            return JasperExportManager.exportReportToPdf(print);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ERROR CREATING REPORT");
        }
        return null;
    }

    private JasperPrint printJasper(String template, Map<String, Object> parameter) throws IOException, JRException {
        InputStream file = new ClassPathResource(template).getInputStream();
        JasperReport jr = (JasperReport) JRLoader.loadObject(file);
        return JasperFillManager.fillReport(jr,parameter, new JREmptyDataSource());
    }

}
