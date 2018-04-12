INSERT INTO `customer` VALUES (1,'cust-1','1','ups-1','cust-1'),(2,'cust-2','2','ups-','cust-2');

-- INSERT INTO `document` VALUES (1,'Binary Data','doc-source-1','user-1','2018-04-09 12:35:52','user-1','2018-04-09 12:35:52','text-file',1);
INSERT INTO `document` VALUES (1,'00aabb','doc-source-1','text-file',1);

INSERT INTO `freight_class_type` VALUES (1,'freight-class-1','density-1');

insert into freight_goods_type (name, sort_order, terms) values ('freight_goods_type-name', 1, 'freight_goods_type-terms');

insert into freight_haz_class_type (name) values ('name');

insert into freight_haz_packaging_group_type (name, code) values ('name', 'code');

insert into freight_package_type (name, plural_name) values ('name', 'plural_name');

insert into nmfc_density_subclass_mapping (nmfc_code, density, sub_class_name) values ('nmfc_code', 'density', 1);

INSERT INTO commodity
(id, customer_id, name, description, length, width, height, weight, stackable, freight_class_type_id, freight_packaging_type_id, nmfc, freight_goods_type_id, value, insurance_condition, insurance_oversized, stated_quantity, stated_quantity_packaging_type, haz, haz_identification_number, haz_proper_shipping_name, freight_haz_class_type_id, freight_haz_packaging_group_type_id, haz_emergency_contact_name, haz_emergency_contact_phone, haz_placard_required, haz_placard_details, haz_flashpoint_temperature, haz_additional_details, haz_err, document_id, created_by, create_date, add_insurance_reminder, type)
VALUES
(1,2,'commodity-23','third commodity', 7, 5, 2, 3, 0, 1, 1, 'nmfc', 1, 2, 'insurance_condition', 1, 12, 1, 0, 'haz_identification_number', 'haz_proper_shipping_name', 1, 1, 'haz_emergency_contact_name', 'haz_emergency_contact_phone', 0, 'haz_placard_details', 'haz_flashpoint_temperature', 'haz_additional_details', 'haz_err', null, 'user-2', '2018-04-09 17:06:58', 0, 'type');
