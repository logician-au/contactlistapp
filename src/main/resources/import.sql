INSERT INTO `Organisation`(`id`,`name`,`abn`) values (1, 'Australian Agent for International Students',12345678901);
INSERT INTO `Organisation`(`id`,`name`,`abn`) values (2, 'CRP AUSTRALIA PTY LTD',23456789012);
INSERT INTO `Organisation`(`id`,`name`,`abn`) values (3, 'THE AUSTRALIAN',34567890123);

INSERT INTO `Contact`(`id`,`first_name`,`last_name`,`create_date`,`organisation_id`) values (1, 'Sophie', 'Klein', {ts '2012-09-17 18:47:52.069'}, 1);
INSERT INTO `Contact`(`id`,`first_name`,`last_name`,`create_date`,`organisation_id`) values (2, 'Perry', 'Kennedy', {ts '2012-09-17 18:47:52.069'}, 1);
INSERT INTO `Contact`(`id`,`first_name`,`last_name`,`create_date`,`organisation_id`) values (3, 'Alma', 'Armstrong', {ts '2012-09-17 18:47:52.069'}, 1);
INSERT INTO `Contact`(`id`,`first_name`,`last_name`,`create_date`,`organisation_id`) values (4, 'Alexander', 'Morris', {ts '2012-09-17 18:47:52.069'}, 2);
INSERT INTO `Contact`(`id`,`first_name`,`last_name`,`create_date`,`organisation_id`) values (5, 'Wm', 'Brady', {ts '2012-09-17 18:47:52.069'}, 2);
INSERT INTO `Contact`(`id`,`first_name`,`last_name`,`create_date`,`organisation_id`) values (6, 'Rudy', 'Bush', {ts '2012-09-17 18:47:52.069'}, 2);
INSERT INTO `Contact`(`id`,`first_name`,`last_name`,`create_date`,`organisation_id`) values (7, 'Andres', 'Mcguire', {ts '2012-09-17 18:47:52.069'}, 2);
INSERT INTO `Contact`(`id`,`first_name`,`last_name`,`create_date`,`organisation_id`) values (8, 'Nick', 'Lane', {ts '2012-09-17 18:47:52.069'}, 3);