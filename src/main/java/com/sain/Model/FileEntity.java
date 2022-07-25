package com.sain.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="file")
public class FileEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Integer fileId;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_create")
    private Date dtCreate;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_modify")
    private Date dtModify;

    @Column(name = "extension", length = 120)
    private String extension;

    @Column(name = "file_name", length = 120)
    private String fileName;

    @Column(name = "location", length = 400)
    private String location;

    @Column(name="module", length = 50, nullable = false)
    private String module;

    @Column(name="module_id", nullable = false)
    private Integer moduleId;

    @Column(name = "type", length = 120)
    private String type;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] filee;

    @Transient
    private byte[] file;

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public Date getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(Date dtCreate) {
        this.dtCreate = dtCreate;
    }

    public Date getDtModify() {
        return dtModify;
    }

    public void setDtModify(Date dtModify) {
        this.dtModify = dtModify;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public byte[] getFilee() {
        return filee;
    }

    public void setFilee(byte[] filee) {
        this.filee = filee;
    }
}