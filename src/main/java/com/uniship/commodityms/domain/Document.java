package com.uniship.commodityms.domain;

import java.io.File;

public class Document {

    private int id;
    private String documentSource;
    private File documentImage;
    private String documentType;
    private Byte toBePrinted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumentSource() {
        return documentSource;
    }

    public void setDocumentSource(String documentSource) {
        this.documentSource = documentSource;
    }

    public File getDocumentImage() {
        return documentImage;
    }

    public void setDocumentImage(File documentImage) {
        this.documentImage = documentImage;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Byte getToBePrinted() {
        return toBePrinted;
    }

    public void setToBePrinted(Byte toBePrinted) {
        this.toBePrinted = toBePrinted;
    }
}
