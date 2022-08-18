package com.sain.Utils;

import com.sain.Model.ResumeEntity;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<ResumeEntity> listResumes;


    private void writeHeaderLine() {
        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate= DateFor.format(date);
        sheet = workbook.createSheet("Factura - " + stringDate);

        Row row = sheet.createRow(0);

        XSSFCellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(12);
        style.setFont(font);


        byte[] rgb = new byte[3];
        rgb[0] = (byte) 20; // red
        rgb[1] = (byte) 100; // green
        rgb[2] = (byte) 255; // blue
        XSSFColor color = new XSSFColor(rgb, null);
        style.setFillForegroundColor(color);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        createCell(row, 0, "Usuario del Cliente", style);
        createCell(row, 1, "No. ID candidato", style);
        createCell(row, 2, "Nombre", style);
        createCell(row, 3, "Unidad de negocio", style);
        createCell(row, 4, "Centro de costo", style);
        createCell(row, 5, "Fecha Solicitado", style);
        createCell(row, 6, "Tipo de Estudio", style);
        createCell(row, 7, "Resultado", style);
        createCell(row, 8, "Valor al cliente", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(11);
        style.setFont(font);

        for (ResumeEntity resumeEntity : listResumes) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            sheet.autoSizeColumn(columnCount);

            createCell(row, columnCount++, resumeEntity.getUserCreate().getName(), style);
            createCell(row, columnCount++, resumeEntity.getNumberId(), style);
            createCell(row, columnCount++, resumeEntity.getName(), style);
            createCell(row, columnCount++, resumeEntity.getBussUnit(), style);
            createCell(row, columnCount++, resumeEntity.getCostCenter(), style);
            SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
            String stringDate= DateFor.format(resumeEntity.getCreationDate());
            createCell(row, columnCount++, stringDate, style);
            createCell(row, columnCount++, resumeEntity.getProfile(), style);
            createCell(row, columnCount++, resumeEntity.getStatus(), style);


        }
    }

    public byte[] export(List<ResumeEntity> listResumes) throws IOException {

        this.listResumes = listResumes;
        workbook = new XSSFWorkbook();
        writeHeaderLine();
        writeDataLines();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            workbook.write(bos);
        } finally {
            bos.close();
        }
        return bos.toByteArray();
    }

}
