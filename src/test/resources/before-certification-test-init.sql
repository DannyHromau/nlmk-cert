insert into nsi_warehouse_unit_status (id, name, code) values ('6daa0328-188f-41ed-b30c-25879a6c51ee'::uuid, 'Актуальная', 29);
insert into nsi_warehouse_unit_status (id, name, code) values ('f3643545-1441-4526-89f2-47033d5787b2'::uuid, 'Взята на агрегат', 30);

insert into nsi_unit_required_attribute_group (id, name, code) values ('16e7e3f4-8022-42d1-90b8-3d74809b626b'::uuid, 'Рулон', 1);

insert into nsi_place (id, name) values ('975051c0-6d07-436d-8883-abb3ce8d1b19'::uuid, 'Склад ЦГП');
insert into nsi_place (id, name) values ('b6dc59a4-46f1-4762-bba0-87dfe5b32c32'::uuid, 'Склад ЦГП2');

insert into nsi_place (id) values ('703a0a79-7a75-4780-891e-7ae79b8f57c4'::uuid);
insert into nsi_place (id) values ('df6351ed-6df0-41a6-80fc-27bdcecfb25a'::uuid);

insert into nsi_unit_attribute (id, name, code) values ('703a0a79-7a75-4780-891e-7ae79b8f57c4'::uuid, 'Номер рулона', 1);
insert into nsi_unit_attribute (id, name, code) values ('930adccb-4bb6-4e4d-a48a-7425cee09b63'::uuid, 'Номер плавки', 2);

insert into nsi_required_attribute (id, unit_required_attribute_group_id, attribute_id) values ('accd1dda-1d0e-4c47-b7d4-c64b228c621c'::uuid, '16e7e3f4-8022-42d1-90b8-3d74809b626b'::uuid, '703a0a79-7a75-4780-891e-7ae79b8f57c4'::uuid);

insert into nsi_warehouse_object_model (id, name, sign_deleted) values ('975051c0-6d07-436d-8883-abb3ce8d1b19'::uuid, 'Склад ЦГП', false);
insert into nsi_warehouse_object_model (id, name, sign_deleted) values ('b6dc59a4-46f1-4762-bba0-87dfe5b32c32'::uuid, 'Склад ЦГП2', false);
insert into nsi_warehouse_object_model (id, name, parent_id, sign_deleted) values ('df6351ed-6df0-41a6-80fc-27bdcecfb25a'::uuid, 'Место 10', 'b6dc59a4-46f1-4762-bba0-87dfe5b32c32'::uuid, false);
insert into nsi_warehouse_object_model (id, name, parent_id, sign_deleted) values ('703a0a79-7a75-4780-891e-7ae79b8f57c4'::uuid, 'Место 5', '975051c0-6d07-436d-8883-abb3ce8d1b19'::uuid, false);

insert into nsi_operation_type (id, name, code) values ('d14b6993-c76a-4fa8-a80c-000000000001'::uuid, 'Приход', 42);
insert into nsi_operation_type (id, name, code) values ('d14b6993-c76a-4fa8-a80c-000000000002'::uuid, 'Расход', 211);
insert into nsi_operation_type (id, name, code) values ('d14b6993-c76a-4fa8-a80c-000000000003'::uuid, 'Изменение статуса', 212);
insert into nsi_operation_type (id, name, code) values ('d14b6993-c76a-4fa8-a80c-000000000005'::uuid, 'Перемещение', 214);