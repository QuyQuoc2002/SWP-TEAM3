drop table if exists `account`;
create table  `account` (
    account_id        		int auto_increment,
    apartment_id      		int,
    account_username   		varchar(100),
    account_password   		varchar(100),
    account_accessible 		boolean,
    constraint account_pk
        primary key (account_id)
);

drop table if exists `apartment`;
create table  `apartment` (
    apartment_id        	int auto_increment,
    apartment_name      	varchar(50) CHARACTER SET utf8mb4,
    apartment_city_cd   	varchar(100) CHARACTER SET utf8mb4,
    apartment_district_cd   varchar(100) CHARACTER SET utf8mb4,
    apartment_lat			float,
    apartment_lon			float,
    apartment_img_thumnail  varchar(300),
    apartment_img_aboutus 	varchar(300),
    apartment_content_aboutus 		text CHARACTER SET utf8mb4,
    apartment_content_service 		text CHARACTER SET utf8mb4,
    apartment_content_recruitment 	text CHARACTER SET utf8mb4,
    constraint apartment_pk
        primary key (apartment_id)
);

drop table if exists `apartment_img_banner`;
create table  `apartment_img_banner` (
    apartment_img_banner_id       	int auto_increment,
    apartment_id      				int,
    apartment_img_banner_id_url  	varchar(300),
    constraint apartment_img_banner
        primary key (apartment_img_banner_id)
);