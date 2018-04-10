insert into customer values (1, 'cust-1', '1', 'ups-1', 'cust-1');
insert into customer values (2, 'cust-2', '2', 'ups-2', 'cust-2');

insert into commodity (id, customer_id, name, description, created_by, create_date)
values (2, 1, 'commodity-2', 'second commodity', 'user-1', now());

insert into freight_class_type values (1, 'freight-class-1', 'density-1');