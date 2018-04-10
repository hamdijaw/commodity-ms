package com.uniship.commodityms.domain;

import javax.persistence.*;

@Entity
@Table(name = "nmfc_density_subclass_mapping")
public class NmfcDensitySubclassMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    @Column(name = "nmfc_code", nullable = false)
    private String nmfcCode;
    @Column(name = "density")
    private String density;
    @Column(name = "sub_class_name", nullable = false)
    private String SubClassName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNmfcCode() {
        return nmfcCode;
    }

    public void setNmfcCode(String nmfcCode) {
        this.nmfcCode = nmfcCode;
    }

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    public String getSubClassName() {
        return SubClassName;
    }

    public void setSubClassName(String subClassName) {
        SubClassName = subClassName;
    }
}
