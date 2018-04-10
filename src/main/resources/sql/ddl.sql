create table freight_package_type (
	id int not null auto_increment,
    name varchar(255) not null,
    plural_name varchar(255) not null,
    PRIMARY KEY (id)
);

create table freight_haz_packaging_group_type (
	id int not null auto_increment,
    name varchar(20) not null,
    code varchar(5) not null,
    PRIMARY KEY (id)
);

create table freight_haz_class_type (
	id int not null auto_increment,
    name varchar(4) not null,
    PRIMARY KEY (id)
);

create table freight_goods_type (
	id int not null auto_increment,
    name varchar(150),
    sort_order int,
    terms varchar(2000),
    PRIMARY KEY (id)
);

create table freight_class_type (
	id int not null auto_increment,
    name varchar(15) not null,
    density varchar(15),
    PRIMARY KEY (id)
);

create table customer (
	id int not null auto_increment,
    name varchar(100) not null,
    customer_number varchar(50) not null,
    ups_account_number varchar(6),
    customer_name varchar(50) not null,
    PRIMARY KEY (id)
);

create table document (
	id int not null auto_increment,
    doc_image varbinary(64500) not null,
    doc_source varchar(200),
    created_by varchar(50) not null,
    create_date datetime,
    last_modified_by varchar(50),
    last_modify_date datetime,
    file_type varchar(15),
    to_be_printed bit,
    PRIMARY KEY (id)
);

create table nmfc_density_subclass_mapping (
  id int NOT NULL auto_increment,
  nmfc_code varchar(15) NOT NULL,
  density varchar(20) NOT NULL,
  sub_class_name int not null,
  PRIMARY KEY (id),
  FOREIGN KEY (sub_class_name) REFERENCES freight_class_type(id)
) ;

create table commodity (
	id int not null auto_increment,
    customer_id int not null,
    name varchar(35) not null,
    description varchar(250),
    length decimal(18,2),
    width decimal(18,2),
    height decimal(18,2),
    weight decimal(18,2),
    stackable bit,
    freight_class_type_id int,
    freight_packaging_type_id int,
    -- Insurance Specific data elements
    nmfc varchar(10),
    freight_goods_type_id int,
    value decimal(18,2),
    insurance_condition varchar(20),
    insurance_oversized bit,
    stated_quantity decimal(18,2),
    stated_quantity_packaging_type int,
    -- Haz commodity specific data elements
    haz bit,
    haz_identification_number varchar(50),
    haz_proper_shipping_name varchar(50),
    freight_haz_class_type_id int,
    freight_haz_packaging_group_type_id int,
    haz_emergency_contact_name varchar(50),
    haz_emergency_contact_phone varchar(50),
    haz_placard_required bit,
    haz_placard_details varchar(50),
    haz_flashpoint_temperature varchar(50),
    haz_additional_details varchar(50),
    haz_err varchar(50),
    -- Commodity Document details
    document_id int,
    -- Auditing
    created_by varchar(50) not null,
    create_date datetime not null,
    last_modified_by varchar(50),
    last_modify_date varchar(50),
    -- Miscellaneous
    add_insurance_reminder bit,
    type varchar(15),

    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (document_id) REFERENCES document(id)
);