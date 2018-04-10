package com.uniship.commodityms.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    @Access(AccessType.PROPERTY)
    private Integer id;
    @Column(name = "doc_source")
    private String documentSource;
    @Column(name = "doc_image", nullable = false)
    @Lob
//    private File documentImage;
    private Byte[] documentImage;
    @Column(name = "file_type")
    private String documentType;
    @Column(name = "to_be_printed")
    private Byte toBePrinted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumentSource() {
        return documentSource;
    }

    public void setDocumentSource(String documentSource) {
        this.documentSource = documentSource;
    }

    /*public File getDocumentImage() {
        return documentImage;
    }

    public void setDocumentImage(File documentImage) {
        this.documentImage = documentImage;
    }*/

    @JsonIgnore
    public Byte[] getDocumentImage() {
        return documentImage;
    }

    public void setDocumentImage(Byte[] documentImage) {
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
