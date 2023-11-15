INSERT INTO Person (name) VALUES ('John Doe');
INSERT INTO Person (name) VALUES ('Jane Doe');
INSERT INTO Person (name) VALUES ('Alice Smith');
INSERT INTO Person (name) VALUES ('Bob Johnson');

INSERT INTO Address (type, street, city, person_id) VALUES ('PERMANENT', '123 Main St', 'Anytown', 1);
INSERT INTO Address (type, street, city, person_id) VALUES ('TEMPORARY', '456 Temp St', 'Tempville', 1);
INSERT INTO Address (type, street, city, person_id) VALUES ('PERMANENT', '789 Permanent St', 'Permanent City', 2);
INSERT INTO Address (type, street, city, person_id) VALUES ('TEMPORARY', '012 Temp St', 'Tempville', 2);
INSERT INTO Address (type, street, city, person_id) VALUES ('PERMANENT', '111 Oak St', 'Someville', 3);
INSERT INTO Address (type, street, city, person_id) VALUES ('TEMPORARY', '222 Birch St', 'Temporary City', 3);
INSERT INTO Address (type, street, city, person_id) VALUES ('PERMANENT', '333 Pine St', 'Permanent City', 4);


INSERT INTO Contact (type, contact_value, address_id) VALUES ('EMAIL', 'john@example.com', 1);
INSERT INTO Contact (type, contact_value, address_id) VALUES ('PHONE', '123-456-7890', 1);
INSERT INTO Contact (type, contact_value, address_id) VALUES ('EMAIL', 'john.temp@example.com', 2);
INSERT INTO Contact (type, contact_value, address_id) VALUES ('PHONE', '987-654-3210', 2);

INSERT INTO Contact (type, contact_value, address_id) VALUES ('EMAIL', 'jane@example.com', 3);
INSERT INTO Contact (type, contact_value, address_id) VALUES ('PHONE', '555-555-5555', 3);
INSERT INTO Contact (type, contact_value, address_id) VALUES ('EMAIL', 'jane.temp@example.com', 4);
INSERT INTO Contact (type, contact_value, address_id) VALUES ('PHONE', '666-666-6666', 4);

INSERT INTO Contact (type, contact_value, address_id) VALUES ('EMAIL', 'alice@example.com', 5);
INSERT INTO Contact (type, contact_value, address_id) VALUES ('PHONE', '111-222-3333', 5);
INSERT INTO Contact (type, contact_value, address_id) VALUES ('EMAIL', 'alice.temp@example.com', 6);
INSERT INTO Contact (type, contact_value, address_id) VALUES ('PHONE', '444-555-6666', 6);
INSERT INTO Contact (type, contact_value, address_id) VALUES ('EMAIL', 'bob@example.com', 7);
INSERT INTO Contact (type, contact_value, address_id) VALUES ('PHONE', '777-888-9999', 7);