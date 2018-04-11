package com.uniship.commodityms.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "commodity")
public class Commodity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    @NotNull
    @Column(name = "customer_id", nullable = false)
    private Integer customerId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @NotNull
    private Double length;
    private Double width;
    private Double height;
    private Double weight;
    private Byte stackable = 0;
    @OneToOne()
    @JoinColumn(name = "freight_class_type_id")
    private FreightClassType freightClassType;
    // Insurance Specific data elements
    @OneToOne()
    @JoinColumn(name = "freight_packaging_type_id")
    private FreightPackagingType freightPackagingType;
    private String nmfc;
    @OneToOne()
    @JoinColumn(name = "freight_goods_type_id")
    private FreightGoodsType freightGoodsType;
    private BigDecimal value;
    @Column(name = "insurance_condition")
    private String condition;
    @Column(name = "insurance_oversized")
    private Byte oversized;
    @Column(name = "stated_quantity")
    private Double statedQuantity;
    @OneToOne()
    @JoinColumn(name = "stated_quantity_packaging_type")//perhaps it can have "id" as suffix
    private FreightPackagingType statedQuantityPackagingType;
    //Haz commodity specific data elements
    private Byte haz;
    @Column(name = "haz_identification_number")
    private String hazIdentificationNumber;
    @Column(name = "haz_proper_shipping_name")
    private String hazProperShippingName;
    @OneToOne()
    @JoinColumn(name = "freight_haz_class_type_id")
    private FreightHazClassType freightHazClassType;
    @OneToOne()
    @JoinColumn(name = "freight_haz_packaging_group_type_id")
    private FreightHazPackagingGroupType freightHazPackagingGroupType;
    @Column(name = "haz_emergency_contact_name")
    private String hazEmergencyContact;
    @Column(name = "haz_emergency_contact_phone")
    private String hazEmergencyPhone;
    @Column(name = "haz_placard_required")
    private Byte hazPlacardRequired = 0;
    @Column(name = "haz_placard_details")
    private String hazPlacardDetails;
    @Column(name = "haz_flashpoint_temperature")
    private String hazFlashpointTemperature;
    @Column(name = "haz_additional_details")
    private String hazAdditionalDetails;
    @Column(name = "haz_err")
    private String hazErr;
    //Commodity Document details.
    @OneToOne()
    @JoinColumn(name = "document_id")
    private Document documentDetails;
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;
    //Miscellaneous
    @Column(name = "add_insurance_reminder")
    private Byte addInsuranceReminder = 0;
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Byte getStackable() {
        return stackable;
    }

    public void setStackable(Byte stackable) {
        this.stackable = stackable;
    }

    public FreightClassType getFreightClassType() {
        return freightClassType;
    }

    public void setFreightClassType(FreightClassType freightClassType) {
        this.freightClassType = freightClassType;
    }

    public FreightPackagingType getFreightPackagingType() {
        return freightPackagingType;
    }

    public void setFreightPackagingType(FreightPackagingType freightPackagingType) {
        this.freightPackagingType = freightPackagingType;
    }

    public String getNmfc() {
        return nmfc;
    }

    public void setNmfc(String nmfc) {
        this.nmfc = nmfc;
    }

    public FreightGoodsType getFreightGoodsType() {
        return freightGoodsType;
    }

    public void setFreightGoodsType(FreightGoodsType freightGoodsType) {
        this.freightGoodsType = freightGoodsType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Byte getOversized() {
        return oversized;
    }

    public void setOversized(Byte oversized) {
        this.oversized = oversized;
    }

    public Double getStatedQuantity() {
        return statedQuantity;
    }

    public void setStatedQuantity(Double statedQuantity) {
        this.statedQuantity = statedQuantity;
    }

    public FreightPackagingType getStatedQuantityPackagingType() {
        return statedQuantityPackagingType;
    }

    public void setStatedQuantityPackagingType(FreightPackagingType statedQuantityPackagingType) {
        this.statedQuantityPackagingType = statedQuantityPackagingType;
    }

    public Byte getHaz() {
        return haz;
    }

    public void setHaz(Byte haz) {
        this.haz = haz;
    }

    public String getHazIdentificationNumber() {
        return hazIdentificationNumber;
    }

    public void setHazIdentificationNumber(String hazIdentificationNumber) {
        this.hazIdentificationNumber = hazIdentificationNumber;
    }

    public String getHazProperShippingName() {
        return hazProperShippingName;
    }

    public void setHazProperShippingName(String hazProperShippingName) {
        this.hazProperShippingName = hazProperShippingName;
    }

    public FreightHazClassType getFreightHazClassType() {
        return freightHazClassType;
    }

    public void setFreightHazClassType(FreightHazClassType freightHazClassType) {
        this.freightHazClassType = freightHazClassType;
    }

    public FreightHazPackagingGroupType getFreightHazPackagingGroupType() {
        return freightHazPackagingGroupType;
    }

    public void setFreightHazPackagingGroupType(FreightHazPackagingGroupType freightHazPackagingGroupType) {
        this.freightHazPackagingGroupType = freightHazPackagingGroupType;
    }

    public String getHazEmergencyContact() {
        return hazEmergencyContact;
    }

    public void setHazEmergencyContact(String hazEmergencyContact) {
        this.hazEmergencyContact = hazEmergencyContact;
    }

    public String getHazEmergencyPhone() {
        return hazEmergencyPhone;
    }

    public void setHazEmergencyPhone(String hazEmergencyPhone) {
        this.hazEmergencyPhone = hazEmergencyPhone;
    }

    public Byte getHazPlacardRequired() {
        return hazPlacardRequired;
    }

    public void setHazPlacardRequired(Byte hazPlacardRequired) {
        this.hazPlacardRequired = hazPlacardRequired;
    }

    public String getHazPlacardDetails() {
        return hazPlacardDetails;
    }

    public void setHazPlacardDetails(String hazPlacardDetails) {
        this.hazPlacardDetails = hazPlacardDetails;
    }

    public String getHazFlashpointTemperature() {
        return hazFlashpointTemperature;
    }

    public void setHazFlashpointTemperature(String hazFlashpointTemperature) {
        this.hazFlashpointTemperature = hazFlashpointTemperature;
    }

    public String getHazAdditionalDetails() {
        return hazAdditionalDetails;
    }

    public void setHazAdditionalDetails(String hazAdditionalDetails) {
        this.hazAdditionalDetails = hazAdditionalDetails;
    }

    public String getHazErr() {
        return hazErr;
    }

    public void setHazErr(String hazErr) {
        this.hazErr = hazErr;
    }

    public Document getDocumentDetails() {
        return documentDetails;
    }

    public void setDocumentDetails(Document documentDetails) {
        this.documentDetails = documentDetails;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Byte getAddInsuranceReminder() {
        return addInsuranceReminder;
    }

    public void setAddInsuranceReminder(Byte addInsuranceReminder) {
        this.addInsuranceReminder = addInsuranceReminder;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
