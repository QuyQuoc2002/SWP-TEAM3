-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: apamandb
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `account_id` int NOT NULL AUTO_INCREMENT,
  `apartment_id` int DEFAULT NULL,
  `account_username` varchar(100) DEFAULT NULL,
  `account_password` varchar(100) DEFAULT NULL,
  `account_accessible` tinyint(1) DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,0,'admin','firns',1,1,0),(2,1,'quyquoc2002@gmail.com','6789!@',1,2,0),(3,2,'nguyencongno55@gmail.com','6789!@',1,2,0),(4,3,'quyquoc2002@gmail.com','6789!@',1,2,0),(5,4,'ninhbinh','6789!@',1,2,0),(6,1,'staff001','6789!@',1,3,0),(7,1,'staff002','6789!@',1,3,1),(8,1,'staff3','Kh4wOCcJk',1,3,0);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apartment`
--

DROP TABLE IF EXISTS `apartment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `apartment` (
  `apartment_id` int NOT NULL AUTO_INCREMENT,
  `apartment_name` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `district_id` int DEFAULT NULL,
  `apartment_address` varchar(1000) DEFAULT NULL,
  `apartment_intro` longtext,
  `apartment_lat` varchar(100) DEFAULT NULL,
  `apartment_lon` varchar(100) DEFAULT NULL,
  `apartment_img_aboutus` varchar(1000) DEFAULT NULL,
  `apartment_content_aboutus` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `apartment_content_service` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `apartment_content_recruitment` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `apartment_accessible` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`apartment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apartment`
--

LOCK TABLES `apartment` WRITE;
/*!40000 ALTER TABLE `apartment` DISABLE KEYS */;
INSERT INTO `apartment` VALUES (1,'Phenika',1,'Phenika 123','<p>intro Phenilassssaw</p>','1','1','assets/images/img-about-us1pexels-emre-can-acer-2079234-min.jpg','<p>The About Us page of your website is an essential source of information for all who want to know more about your business.</p><p>About Us pages are where you showcase your history, what is unique about your work, your company’s values, and who you serve.</p>','<ul><li>Giat quan ao</li><li>Giat giay</li><li>don Phong</li><li>van van</li><li>may may</li></ul>','<h3><strong>Mô tả công việc</strong></h3><p><strong>- Công việc:</strong><br>&nbsp;</p><p>· Tạo mối liên hệ khách hàng</p><p>· Tư vấn, bán thẻ game</p><p>· Quản lý khu vực được phân bổ</p><p>· Xử lý các vấn đề phát sinh</p><p>· BC kịp thời cấp quản lý</p><p>· Kết hợp sampling kho phụ trách</p><p>· Tuân thủ nội quy công ty</p><p>· Sẵn sàng được điều động công tác</p><p>· Hoàn thành công việc được phân công</p><p><strong>- Chào hàng khách hàng (Được phân công)</strong></p><p><strong>- Báo cáo cho quản lý: Hàng ngày, Tuần, Tháng, Năm</strong></p><p><strong>- Thời gian làm việc: 8h – 22h, 2 ngày phép/tháng.</strong></p><h3><strong>Yêu cầu ứng viên</strong></h3><p>- Có 1 - 2 năm kinh nghiệm làm việc, chưa có kinh nghiệm sẽ được đào tạo.</p><p>- Tốt nghiệp trung cấp trở lên.</p><p>- Kỹ năng giao tiếp, thuyết trình tốt;</p><p>- Sử dụng thành thạo Microsoft Office (Word, Excel, Powerpoint).</p><p>- Chịu khó, nhanh nhẹn</p><p>- Làm việc nhóm tốt, có tinh thần trách nhiệm cao trong công việc.</p><p>- Có khả năng làm việc độc lập &amp; theo nhóm</p><h3><strong>Quyền lợi</strong></h3><ul><li>Lương cơ bản + Phụ cấp + thưởng doanh số ( 10 triệu – 20 triệu)</li><li>Phép năm</li><li>Công ty có chỗ ở cho nhân viên.</li><li>Bảo hiểm xã hội, bảo hiểm y tế đầy đủ</li><li>Du lịch cùng công ty ( 2 chuyến/1 năm)</li></ul>',1),(2,'Hoang Nam ',1,'Hoang Nam 123','this is exe Hoang Nam ','1','1','assets/images/img-about-us2pexels-andrea-piacquadio-932328-min.jpg','asdasd','asdasd','asdasd',1),(3,'Hoang Nam 2',1,'Hoang Nam 123','this is exe Hoang Nam 2','1','1','assets/system/defaultImgSystem.jpg','asdasd','asd','asd',1),(4,'Bla Bla',369,'Ninh Binh','Blalalala','1','1','assets/system/defaultImgSystem.jpg','asd','asd','asd',1);
/*!40000 ALTER TABLE `apartment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apartment_img_banner`
--

DROP TABLE IF EXISTS `apartment_img_banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `apartment_img_banner` (
  `apartment_img_banner_id` int NOT NULL AUTO_INCREMENT,
  `apartment_id` int DEFAULT NULL,
  `apartment_img_banner_path` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`apartment_img_banner_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apartment_img_banner`
--

LOCK TABLES `apartment_img_banner` WRITE;
/*!40000 ALTER TABLE `apartment_img_banner` DISABLE KEYS */;
INSERT INTO `apartment_img_banner` VALUES (11,1,'assets/images/img-banner11pexels-chait-goli-1918291-min.jpg'),(13,1,'assets/images/img-banner13pexels-charlotte-may-5824518-min.jpg'),(14,1,'assets/images/img-banner14pexels-andrea-davis-5417293-min.jpg'),(15,1,'assets/images/img-banner15pexels-ben-mack-6775268-min.jpg'),(16,2,'assets/images/img-banner16pexels-charlotte-may-5824518-min.jpg'),(17,2,'assets/images/img-banner17pexels-chait-goli-1918291-min.jpg');
/*!40000 ALTER TABLE `apartment_img_banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `city_id` int NOT NULL AUTO_INCREMENT,
  `city_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Ha Noi'),(2,'Ha Giang'),(4,'Cao Bang'),(6,'Bac Kan'),(8,'Tuyen Quang'),(10,'Lao Cai'),(11,'Dien Bien'),(12,'Lai Chau'),(14,'Son La'),(15,'Yen Bai'),(17,'Hoa Binh'),(19,'Thai Nguyen'),(20,'Lang Son'),(22,'Quang Ninh'),(24,'Bac Giang'),(25,'Phu Tho'),(26,'Vinh Phuc'),(27,'Bac Ninh'),(30,'Hai Duong'),(31,'Hai Phong'),(33,'Hung Yen'),(34,'Thai Binh'),(35,'Ha Nam'),(36,'Nam Dinh'),(37,'Ninh Binh'),(38,'Thanh Hoa'),(40,'Nghe An'),(42,'Ha Tinh'),(44,'Quang Binh'),(45,'Quang Tri'),(46,'Thua Thien-Hue'),(48,'Da Nang'),(49,'Quang Nam'),(51,'Quang Ngai'),(52,'Binh Dinh'),(54,'Phu Yen'),(56,'Khanh Hoa'),(58,'Ninh Thuan'),(60,'Binh Thuan'),(62,'Kon Tum'),(64,'Gia Lai'),(66,'Dak Lak'),(67,'Dak Nong'),(68,'Lam Dong'),(70,'Binh Phuoc'),(72,'Tay Ninh'),(74,'Binh Duong'),(75,'Dong Nai'),(77,'Ba Ria-Vung Tau'),(79,'Ho Chi Minh'),(80,'Long An'),(82,'Tien Giang'),(83,'Ben Tre'),(84,'Tra Vinh'),(86,'Vinh Long'),(87,'Dong Thap'),(89,'An Giang'),(91,'Kien Giang'),(92,'Can Tho'),(93,'Hau Giang'),(94,'Soc Trang'),(95,'Bac Lieu'),(96,'Ca Mau');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `district`
--

DROP TABLE IF EXISTS `district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `district` (
  `district_id` int NOT NULL AUTO_INCREMENT,
  `city_id` int DEFAULT NULL,
  `district_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`district_id`)
) ENGINE=InnoDB AUTO_INCREMENT=974 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district`
--

LOCK TABLES `district` WRITE;
/*!40000 ALTER TABLE `district` DISABLE KEYS */;
INSERT INTO `district` VALUES (1,1,'Quan Ba Dinh'),(2,1,'Quan Hoan Kiem'),(3,1,'Quan Tay Ho'),(4,1,'Quan Long Bien'),(5,1,'Quan Cau Giay'),(6,1,'Quan Dong Da'),(7,1,'Quan Hai Ba Trung'),(8,1,'Quan Hoang Mai'),(9,1,'Quan Thanh Xuan'),(16,1,'Huyen Soc Son'),(17,1,'Huyen Dong Anh'),(18,1,'Huyen Gia Lam'),(19,1,'Quan Nam Tu Liem'),(20,1,'Huyen Thanh Tri'),(21,1,'Quan Bac Tu Liem'),(24,2,'Thanh pho Ha Giang'),(26,2,'Huyen Dong Van'),(27,2,'Huyen Meo Vac'),(28,2,'Huyen Yen Minh'),(29,2,'Huyen Quan Ba'),(30,2,'Huyen Vi Xuyen'),(31,2,'Huyen Bac Me'),(32,2,'Huyen Hoang Su Phi'),(33,2,'Huyen Xin Man'),(34,2,'Huyen Bac Quang'),(35,2,'Huyen Quang Binh'),(40,4,'Thanh pho Cao Bang'),(42,4,'Huyen Bao Lam'),(43,4,'Huyen Bao Lac'),(45,4,'Huyen Ha Quang'),(47,4,'Huyen Trung Khanh'),(48,4,'Huyen Ha Lang'),(49,4,'Huyen Quang Hoa'),(51,4,'Huyen Hoa An'),(52,4,'Huyen Nguyen Binh'),(53,4,'Huyen Thach An'),(58,6,'Thanh Pho Bac Kan'),(60,6,'Huyen Pac Nam'),(61,6,'Huyen Ba Be'),(62,6,'Huyen Ngan Son'),(63,6,'Huyen Bach Thong'),(64,6,'Huyen Cho Don'),(65,6,'Huyen Cho Moi'),(66,6,'Huyen Na Ri'),(70,8,'Thanh pho Tuyen Quang'),(71,8,'Huyen Lam Binh'),(72,8,'Huyen Na Hang'),(73,8,'Huyen Chiem Hoa'),(74,8,'Huyen Ham Yen'),(75,8,'Huyen Yen Son'),(76,8,'Huyen Son Duong'),(80,10,'Thanh pho Lao Cai'),(82,10,'Huyen Bat Xat'),(83,10,'Huyen Muong Khuong'),(84,10,'Huyen Si Ma Cai'),(85,10,'Huyen Bac Ha'),(86,10,'Huyen Bao Thang'),(87,10,'Huyen Bao Yen'),(88,10,'Thi xa Sa Pa'),(89,10,'Huyen Van Ban'),(94,11,'Thanh pho Dien Bien Phu'),(95,11,'Thi Xa Muong Lay'),(96,11,'Huyen Muong Nhe'),(97,11,'Huyen Muong Cha'),(98,11,'Huyen Tua Chua'),(99,11,'Huyen Tuan Giao'),(100,11,'Huyen Dien Bien'),(101,11,'Huyen Dien Bien Dong'),(102,11,'Huyen Muong Ang'),(103,11,'Huyen Nam Po'),(105,12,'Thanh pho Lai Chau'),(106,12,'Huyen Tam Duong'),(107,12,'Huyen Muong Te'),(108,12,'Huyen Sin Ho'),(109,12,'Huyen Phong Tho'),(110,12,'Huyen Than Uyen'),(111,12,'Huyen Tan Uyen'),(112,12,'Huyen Nam Nhun'),(116,14,'Thanh pho Son La'),(118,14,'Huyen Quynh Nhai'),(119,14,'Huyen Thuan Chau'),(120,14,'Huyen Muong La'),(121,14,'Huyen Bac Yen'),(122,14,'Huyen Phu Yen'),(123,14,'Huyen Moc Chau'),(124,14,'Huyen Yen Chau'),(125,14,'Huyen Mai Son'),(126,14,'Huyen Song Ma'),(127,14,'Huyen Sop Cop'),(128,14,'Huyen Van Ho'),(132,15,'Thanh pho Yen Bai'),(133,15,'Thi xa Nghia Lo'),(135,15,'Huyen Luc Yen'),(136,15,'Huyen Van Yen'),(137,15,'Huyen Mu Cang Chai'),(138,15,'Huyen Tran Yen'),(139,15,'Huyen Tram Tau'),(140,15,'Huyen Van Chan'),(141,15,'Huyen Yen Binh'),(148,17,'Thanh pho Hoa Binh'),(150,17,'Huyen Da Bac'),(152,17,'Huyen Luong Son'),(153,17,'Huyen Kim Boi'),(154,17,'Huyen Cao Phong'),(155,17,'Huyen Tan Lac'),(156,17,'Huyen Mai Chau'),(157,17,'Huyen Lac Son'),(158,17,'Huyen Yen Thuy'),(159,17,'Huyen Lac Thuy'),(164,19,'Thanh pho Thai Nguyen'),(165,19,'Thanh pho Song Cong'),(167,19,'Huyen Dinh Hoa'),(168,19,'Huyen Phu Luong'),(169,19,'Huyen Dong Hy'),(170,19,'Huyen Vo Nhai'),(171,19,'Huyen Dai Tu'),(172,19,'Thanh pho Pho Yen'),(173,19,'Huyen Phu Binh'),(178,20,'Thanh pho Lang Son'),(180,20,'Huyen Trang Dinh'),(181,20,'Huyen Binh Gia'),(182,20,'Huyen Van Lang'),(183,20,'Huyen Cao Loc'),(184,20,'Huyen Van Quan'),(185,20,'Huyen Bac Son'),(186,20,'Huyen Huu Lung'),(187,20,'Huyen Chi Lang'),(188,20,'Huyen Loc Binh'),(189,20,'Huyen Dinh Lap'),(193,22,'Thanh pho Ha Long'),(194,22,'Thanh pho Mong Cai'),(195,22,'Thanh pho Cam Pha'),(196,22,'Thanh pho Uong Bi'),(198,22,'Huyen Binh Lieu'),(199,22,'Huyen Tien Yen'),(200,22,'Huyen Dam Ha'),(201,22,'Huyen Hai Ha'),(202,22,'Huyen Ba Che'),(203,22,'Huyen Van Don'),(205,22,'Thi xa Dong Trieu'),(206,22,'Thi xa Quang Yen'),(207,22,'Huyen Co To'),(213,24,'Thanh pho Bac Giang'),(215,24,'Huyen Yen The'),(216,24,'Huyen Tan Yen'),(217,24,'Huyen Lang Giang'),(218,24,'Huyen Luc Nam'),(219,24,'Huyen Luc Ngan'),(220,24,'Huyen Son Dong'),(221,24,'Huyen Yen Dung'),(222,24,'Huyen Viet Yen'),(223,24,'Huyen Hiep Hoa'),(227,25,'Thanh pho Viet Tri'),(228,25,'Thi xa Phu Tho'),(230,25,'Huyen Doan Hung'),(231,25,'Huyen Ha Hoa'),(232,25,'Huyen Thanh Ba'),(233,25,'Huyen Phu Ninh'),(234,25,'Huyen Yen Lap'),(235,25,'Huyen Cam Khe'),(236,25,'Huyen Tam Nong'),(237,25,'Huyen Lam Thao'),(238,25,'Huyen Thanh Son'),(239,25,'Huyen Thanh Thuy'),(240,25,'Huyen Tan Son'),(243,26,'Thanh pho Vinh Yen'),(244,26,'Thanh pho Phuc Yen'),(246,26,'Huyen Lap Thach'),(247,26,'Huyen Tam Duong'),(248,26,'Huyen Tam Dao'),(249,26,'Huyen Binh Xuyen'),(250,1,'Huyen Me Linh'),(251,26,'Huyen Yen Lac'),(252,26,'Huyen Vinh Tuong'),(253,26,'Huyen Song Lo'),(256,27,'Thanh pho Bac Ninh'),(258,27,'Huyen Yen Phong'),(259,27,'Huyen Que Vo'),(260,27,'Huyen Tien Du'),(261,27,'Thanh pho Tu Son'),(262,27,'Huyen Thuan Thanh'),(263,27,'Huyen Gia Binh'),(264,27,'Huyen Luong Tai'),(268,1,'Quan Ha Dong'),(269,1,'Thi xa Son Tay'),(271,1,'Huyen Ba Vi'),(272,1,'Huyen Phuc Tho'),(273,1,'Huyen Dan Phuong'),(274,1,'Huyen Hoai Duc'),(275,1,'Huyen Quoc Oai'),(276,1,'Huyen Thach That'),(277,1,'Huyen Chuong My'),(278,1,'Huyen Thanh Oai'),(279,1,'Huyen Thuong Tin'),(280,1,'Huyen Phu Xuyen'),(281,1,'Huyen Ung Hoa'),(282,1,'Huyen My Duc'),(288,30,'Thanh pho Hai Duong'),(290,30,'Thanh pho Chi Linh'),(291,30,'Huyen Nam Sach'),(292,30,'Thi xa Kinh Mon'),(293,30,'Huyen Kim Thanh'),(294,30,'Huyen Thanh Ha'),(295,30,'Huyen Cam Giang'),(296,30,'Huyen Binh Giang'),(297,30,'Huyen Gia Loc'),(298,30,'Huyen Tu Ky'),(299,30,'Huyen Ninh Giang'),(300,30,'Huyen Thanh Mien'),(303,31,'Quan Hong Bang'),(304,31,'Quan Ngo Quyen'),(305,31,'Quan Le Chan'),(306,31,'Quan Hai An'),(307,31,'Quan Kien An'),(308,31,'Quan Do Son'),(309,31,'Quan Duong Kinh'),(311,31,'Huyen Thuy Nguyen'),(312,31,'Huyen An Duong'),(313,31,'Huyen An Lao'),(314,31,'Huyen Kien Thuy'),(315,31,'Huyen Tien Lang'),(316,31,'Huyen Vinh Bao'),(317,31,'Huyen Cat Hai'),(318,31,'Huyen Bach Long Vi'),(323,33,'Thanh pho Hung Yen'),(325,33,'Huyen Van Lam'),(326,33,'Huyen Van Giang'),(327,33,'Huyen Yen My'),(328,33,'Thi xa My Hao'),(329,33,'Huyen An Thi'),(330,33,'Huyen Khoai Chau'),(331,33,'Huyen Kim Dong'),(332,33,'Huyen Tien Lu'),(333,33,'Huyen Phu Cu'),(336,34,'Thanh pho Thai Binh'),(338,34,'Huyen Quynh Phu'),(339,34,'Huyen Hung Ha'),(340,34,'Huyen Dong Hung'),(341,34,'Huyen Thai Thuy'),(342,34,'Huyen Tien Hai'),(343,34,'Huyen Kien Xuong'),(344,34,'Huyen Vu Thu'),(347,35,'Thanh pho Phu Ly'),(349,35,'Thi xa Duy Tien'),(350,35,'Huyen Kim Bang'),(351,35,'Huyen Thanh Liem'),(352,35,'Huyen Binh Luc'),(353,35,'Huyen Ly Nhan'),(356,36,'Thanh pho Nam Dinh'),(358,36,'Huyen My Loc'),(359,36,'Huyen Vu Ban'),(360,36,'Huyen Y Yen'),(361,36,'Huyen Nghia Hung'),(362,36,'Huyen Nam Truc'),(363,36,'Huyen Truc Ninh'),(364,36,'Huyen Xuan Truong'),(365,36,'Huyen Giao Thuy'),(366,36,'Huyen Hai Hau'),(369,37,'Thanh pho Ninh Binh'),(370,37,'Thanh pho Tam Diep'),(372,37,'Huyen Nho Quan'),(373,37,'Huyen Gia Vien'),(374,37,'Huyen Hoa Lu'),(375,37,'Huyen Yen Khanh'),(376,37,'Huyen Kim Son'),(377,37,'Huyen Yen Mo'),(380,38,'Thanh pho Thanh Hoa'),(381,38,'Thi xa Bim Son'),(382,38,'Thanh pho Sam Son'),(384,38,'Huyen Muong Lat'),(385,38,'Huyen Quan Hoa'),(386,38,'Huyen Ba Thuoc'),(387,38,'Huyen Quan Son'),(388,38,'Huyen Lang Chanh'),(389,38,'Huyen Ngoc Lac'),(390,38,'Huyen Cam Thuy'),(391,38,'Huyen Thach Thanh'),(392,38,'Huyen Ha Trung'),(393,38,'Huyen Vinh Loc'),(394,38,'Huyen Yen Dinh'),(395,38,'Huyen Tho Xuan'),(396,38,'Huyen Thuong Xuan'),(397,38,'Huyen Trieu Son'),(398,38,'Huyen Thieu Hoa'),(399,38,'Huyen Hoang Hoa'),(400,38,'Huyen Hau Loc'),(401,38,'Huyen Nga Son'),(402,38,'Huyen Nhu Xuan'),(403,38,'Huyen Nhu Thanh'),(404,38,'Huyen Nong Cong'),(405,38,'Huyen Dong Son'),(406,38,'Huyen Quang Xuong'),(407,38,'Thi xa Nghi Son'),(412,40,'Thanh pho Vinh'),(413,40,'Thi xa Cua Lo'),(414,40,'Thi xa Thai Hoa'),(415,40,'Huyen Que Phong'),(416,40,'Huyen Quy Chau'),(417,40,'Huyen Ky Son'),(418,40,'Huyen Tuong Duong'),(419,40,'Huyen Nghia Dan'),(420,40,'Huyen Quy Hop'),(421,40,'Huyen Quynh Luu'),(422,40,'Huyen Con Cuong'),(423,40,'Huyen Tan Ky'),(424,40,'Huyen Anh Son'),(425,40,'Huyen Dien Chau'),(426,40,'Huyen Yen Thanh'),(427,40,'Huyen Do Luong'),(428,40,'Huyen Thanh Chuong'),(429,40,'Huyen Nghi Loc'),(430,40,'Huyen Nam Dan'),(431,40,'Huyen Hung Nguyen'),(432,40,'Thi xa Hoang Mai'),(436,42,'Thanh pho Ha Tinh'),(437,42,'Thi xa Hong Linh'),(439,42,'Huyen Huong Son'),(440,42,'Huyen Duc Tho'),(441,42,'Huyen Vu Quang'),(442,42,'Huyen Nghi Xuan'),(443,42,'Huyen Can Loc'),(444,42,'Huyen Huong Khe'),(445,42,'Huyen Thach Ha'),(446,42,'Huyen Cam Xuyen'),(447,42,'Huyen Ky Anh'),(448,42,'Huyen Loc Ha'),(449,42,'Thi xa Ky Anh'),(450,44,'Thanh Pho Dong Hoi'),(452,44,'Huyen Minh Hoa'),(453,44,'Huyen Tuyen Hoa'),(454,44,'Huyen Quang Trach'),(455,44,'Huyen Bo Trach'),(456,44,'Huyen Quang Ninh'),(457,44,'Huyen Le Thuy'),(458,44,'Thi xa Ba Don'),(461,45,'Thanh pho Dong Ha'),(462,45,'Thi xa Quang Tri'),(464,45,'Huyen Vinh Linh'),(465,45,'Huyen Huong Hoa'),(466,45,'Huyen Gio Linh'),(467,45,'Huyen Da Krong'),(468,45,'Huyen Cam Lo'),(469,45,'Huyen Trieu Phong'),(470,45,'Huyen Hai Lang'),(471,45,'Huyen Con Co'),(474,46,'Thanh pho Hue'),(476,46,'Huyen Phong Dien'),(477,46,'Huyen Quang Dien'),(478,46,'Huyen Phu Vang'),(479,46,'Thi xa Huong Thuy'),(480,46,'Thi xa Huong Tra'),(481,46,'Huyen A Luoi'),(482,46,'Huyen Phu Loc'),(483,46,'Huyen Nam Dong'),(490,48,'Quan Lien Chieu'),(491,48,'Quan Thanh Khe'),(492,48,'Quan Hai Chau'),(493,48,'Quan Son Tra'),(494,48,'Quan Ngu Hanh Son'),(495,48,'Quan Cam Le'),(497,48,'Huyen Hoa Vang'),(498,48,'Huyen Hoang Sa'),(502,49,'Thanh pho Tam Ky'),(503,49,'Thanh pho Hoi An'),(504,49,'Huyen Tay Giang'),(505,49,'Huyen Dong Giang'),(506,49,'Huyen Dai Loc'),(507,49,'Thi xa Dien Ban'),(508,49,'Huyen Duy Xuyen'),(509,49,'Huyen Que Son'),(510,49,'Huyen Nam Giang'),(511,49,'Huyen Phuoc Son'),(512,49,'Huyen Hiep Duc'),(513,49,'Huyen Thang Binh'),(514,49,'Huyen Tien Phuoc'),(515,49,'Huyen Bac Tra My'),(516,49,'Huyen Nam Tra My'),(517,49,'Huyen Nui Thanh'),(518,49,'Huyen Phu Ninh'),(519,49,'Huyen Nong Son'),(522,51,'Thanh pho Quang Ngai'),(524,51,'Huyen Binh Son'),(525,51,'Huyen Tra Bong'),(527,51,'Huyen Son Tinh'),(528,51,'Huyen Tu Nghia'),(529,51,'Huyen Son Ha'),(530,51,'Huyen Son Tay'),(531,51,'Huyen Minh Long'),(532,51,'Huyen Nghia Hanh'),(533,51,'Huyen Mo Duc'),(534,51,'Thi xa Duc Pho'),(535,51,'Huyen Ba To'),(536,51,'Huyen Ly Son'),(540,52,'Thanh pho Quy Nhon'),(542,52,'Huyen An Lao'),(543,52,'Thi xa Hoai Nhon'),(544,52,'Huyen Hoai An'),(545,52,'Huyen Phu My'),(546,52,'Huyen Vinh Thanh'),(547,52,'Huyen Tay Son'),(548,52,'Huyen Phu Cat'),(549,52,'Thi xa An Nhon'),(550,52,'Huyen Tuy Phuoc'),(551,52,'Huyen Van Canh'),(555,54,'Thanh pho Tuy Hoa'),(557,54,'Thi xa Song Cau'),(558,54,'Huyen Dong Xuan'),(559,54,'Huyen Tuy An'),(560,54,'Huyen Son Hoa'),(561,54,'Huyen Song Hinh'),(562,54,'Huyen Tay Hoa'),(563,54,'Huyen Phu Hoa'),(564,54,'Thi xa Dong Hoa'),(568,56,'Thanh pho Nha Trang'),(569,56,'Thanh pho Cam Ranh'),(570,56,'Huyen Cam Lam'),(571,56,'Huyen Van Ninh'),(572,56,'Thi xa Ninh Hoa'),(573,56,'Huyen Khanh Vinh'),(574,56,'Huyen Dien Khanh'),(575,56,'Huyen Khanh Son'),(576,56,'Huyen Truong Sa'),(582,58,'Thanh pho Phan Rang-Thap Cham'),(584,58,'Huyen Bac Ai'),(585,58,'Huyen Ninh Son'),(586,58,'Huyen Ninh Hai'),(587,58,'Huyen Ninh Phuoc'),(588,58,'Huyen Thuan Bac'),(589,58,'Huyen Thuan Nam'),(593,60,'Thanh pho Phan Thiet'),(594,60,'Thi xa La Gi'),(595,60,'Huyen Tuy Phong'),(596,60,'Huyen Bac Binh'),(597,60,'Huyen Ham Thuan Bac'),(598,60,'Huyen Ham Thuan Nam'),(599,60,'Huyen Tanh Linh'),(600,60,'Huyen Duc Linh'),(601,60,'Huyen Ham Tan'),(602,60,'Huyen Phu Qui'),(608,62,'Thanh pho Kon Tum'),(610,62,'Huyen Dak Glei'),(611,62,'Huyen Ngoc Hoi'),(612,62,'Huyen Dak To'),(613,62,'Huyen Kon Plong'),(614,62,'Huyen Kon Ray'),(615,62,'Huyen Dak Ha'),(616,62,'Huyen Sa Thay'),(617,62,'Huyen Tu Mo Rong'),(618,62,'Huyen Ia H\' Drai'),(622,64,'Thanh pho Pleiku'),(623,64,'Thi xa An Khe'),(624,64,'Thi xa Ayun Pa'),(625,64,'Huyen KBang'),(626,64,'Huyen Dak Doa'),(627,64,'Huyen Chu Pah'),(628,64,'Huyen Ia Grai'),(629,64,'Huyen Mang Yang'),(630,64,'Huyen Kong Chro'),(631,64,'Huyen Duc Co'),(632,64,'Huyen Chu Prong'),(633,64,'Huyen Chu Se'),(634,64,'Huyen Dak Po'),(635,64,'Huyen Ia Pa'),(637,64,'Huyen Krong Pa'),(638,64,'Huyen Phu Thien'),(639,64,'Huyen Chu Puh'),(643,66,'Thanh pho Buon Ma Thuot'),(644,66,'Thi Xa Buon Ho'),(645,66,'Huyen Ea H\'leo'),(646,66,'Huyen Ea Sup'),(647,66,'Huyen Buon Don'),(648,66,'Huyen Cu M\'gar'),(649,66,'Huyen Krong Buk'),(650,66,'Huyen Krong Nang'),(651,66,'Huyen Ea Kar'),(652,66,'Huyen M\'Drak'),(653,66,'Huyen Krong Bong'),(654,66,'Huyen Krong Pac'),(655,66,'Huyen Krong A Na'),(656,66,'Huyen Lak'),(657,66,'Huyen Cu Kuin'),(660,67,'Thanh pho Gia Nghia'),(661,67,'Huyen Dak Glong'),(662,67,'Huyen Cu Jut'),(663,67,'Huyen Dak Mil'),(664,67,'Huyen Krong No'),(665,67,'Huyen Dak Song'),(666,67,'Huyen Dak R\'Lap'),(667,67,'Huyen Tuy Duc'),(672,68,'Thanh pho Da Lat'),(673,68,'Thanh pho Bao Loc'),(674,68,'Huyen Dam Rong'),(675,68,'Huyen Lac Duong'),(676,68,'Huyen Lam Ha'),(677,68,'Huyen Don Duong'),(678,68,'Huyen Duc Trong'),(679,68,'Huyen Di Linh'),(680,68,'Huyen Bao Lam'),(681,68,'Huyen Da Huoai'),(682,68,'Huyen Da Teh'),(683,68,'Huyen Cat Tien'),(688,70,'Thi xa Phuoc Long'),(689,70,'Thanh pho Dong Xoai'),(690,70,'Thi xa Binh Long'),(691,70,'Huyen Bu Gia Map'),(692,70,'Huyen Loc Ninh'),(693,70,'Huyen Bu Dop'),(694,70,'Huyen Hon Quan'),(695,70,'Huyen Dong Phu'),(696,70,'Huyen Bu Dang'),(697,70,'Huyen Chon Thanh'),(698,70,'Huyen Phu Rieng'),(703,72,'Thanh pho Tay Ninh'),(705,72,'Huyen Tan Bien'),(706,72,'Huyen Tan Chau'),(707,72,'Huyen Duong Minh Chau'),(708,72,'Huyen Chau Thanh'),(709,72,'Thi xa Hoa Thanh'),(710,72,'Huyen Go Dau'),(711,72,'Huyen Ben Cau'),(712,72,'Thi xa Trang Bang'),(718,74,'Thanh pho Thu Dau Mot'),(719,74,'Huyen Bau Bang'),(720,74,'Huyen Dau Tieng'),(721,74,'Thi xa Ben Cat'),(722,74,'Huyen Phu Giao'),(723,74,'Thi xa Tan Uyen'),(724,74,'Thanh pho Di An'),(725,74,'Thanh pho Thuan An'),(726,74,'Huyen Bac Tan Uyen'),(731,75,'Thanh pho Bien Hoa'),(732,75,'Thanh pho Long Khanh'),(734,75,'Huyen Tan Phu'),(735,75,'Huyen Vinh Cuu'),(736,75,'Huyen Dinh Quan'),(737,75,'Huyen Trang Bom'),(738,75,'Huyen Thong Nhat'),(739,75,'Huyen Cam My'),(740,75,'Huyen Long Thanh'),(741,75,'Huyen Xuan Loc'),(742,75,'Huyen Nhon Trach'),(747,77,'Thanh pho Vung Tau'),(748,77,'Thanh pho Ba Ria'),(750,77,'Huyen Chau Duc'),(751,77,'Huyen Xuyen Moc'),(752,77,'Huyen Long Dien'),(753,77,'Huyen Dat Do'),(754,77,'Thi xa Phu My'),(755,77,'Huyen Con Dao'),(760,79,'Quan 1'),(761,79,'Quan 12'),(764,79,'Quan Go Vap'),(765,79,'Quan Binh Thanh'),(766,79,'Quan Tan Binh'),(767,79,'Quan Tan Phu'),(768,79,'Quan Phu Nhuan'),(769,79,'Thanh pho Thu Duc'),(770,79,'Quan 3'),(771,79,'Quan 10'),(772,79,'Quan 11'),(773,79,'Quan 4'),(774,79,'Quan 5'),(775,79,'Quan 6'),(776,79,'Quan 8'),(777,79,'Quan Binh Tan'),(778,79,'Quan 7'),(783,79,'Huyen Cu Chi'),(784,79,'Huyen Hoc Mon'),(785,79,'Huyen Binh Chanh'),(786,79,'Huyen Nha Be'),(787,79,'Huyen Can Gio'),(794,80,'Thanh pho Tan An'),(795,80,'Thi xa Kien Tuong'),(796,80,'Huyen Tan Hung'),(797,80,'Huyen Vinh Hung'),(798,80,'Huyen Moc Hoa'),(799,80,'Huyen Tan Thanh'),(800,80,'Huyen Thanh Hoa'),(801,80,'Huyen Duc Hue'),(802,80,'Huyen Duc Hoa'),(803,80,'Huyen Ben Luc'),(804,80,'Huyen Thu Thua'),(805,80,'Huyen Tan Tru'),(806,80,'Huyen Can Duoc'),(807,80,'Huyen Can Giuoc'),(808,80,'Huyen Chau Thanh'),(815,82,'Thanh pho My Tho'),(816,82,'Thi xa Go Cong'),(817,82,'Thi xa Cai Lay'),(818,82,'Huyen Tan Phuoc'),(819,82,'Huyen Cai Be'),(820,82,'Huyen Cai Lay'),(821,82,'Huyen Chau Thanh'),(822,82,'Huyen Cho Gao'),(823,82,'Huyen Go Cong Tay'),(824,82,'Huyen Go Cong Dong'),(825,82,'Huyen Tan Phu Dong'),(829,83,'Thanh pho Ben Tre'),(831,83,'Huyen Chau Thanh'),(832,83,'Huyen Cho Lach'),(833,83,'Huyen Mo Cay Nam'),(834,83,'Huyen Giong Trom'),(835,83,'Huyen Binh Dai'),(836,83,'Huyen Ba Tri'),(837,83,'Huyen Thanh Phu'),(838,83,'Huyen Mo Cay Bac'),(842,84,'Thanh pho Tra Vinh'),(844,84,'Huyen Cang Long'),(845,84,'Huyen Cau Ke'),(846,84,'Huyen Tieu Can'),(847,84,'Huyen Chau Thanh'),(848,84,'Huyen Cau Ngang'),(849,84,'Huyen Tra Cu'),(850,84,'Huyen Duyen Hai'),(851,84,'Thi xa Duyen Hai'),(855,86,'Thanh pho Vinh Long'),(857,86,'Huyen Long Ho'),(858,86,'Huyen Mang Thit'),(859,86,'Huyen Vung Liem'),(860,86,'Huyen Tam Binh'),(861,86,'Thi xa Binh Minh'),(862,86,'Huyen Tra On'),(863,86,'Huyen Binh Tan'),(866,87,'Thanh pho Cao Lanh'),(867,87,'Thanh pho Sa Dec'),(868,87,'Thanh pho Hong Ngu'),(869,87,'Huyen Tan Hong'),(870,87,'Huyen Hong Ngu'),(871,87,'Huyen Tam Nong'),(872,87,'Huyen Thap Muoi'),(873,87,'Huyen Cao Lanh'),(874,87,'Huyen Thanh Binh'),(875,87,'Huyen Lap Vo'),(876,87,'Huyen Lai Vung'),(877,87,'Huyen Chau Thanh'),(883,89,'Thanh pho Long Xuyen'),(884,89,'Thanh pho Chau Doc'),(886,89,'Huyen An Phu'),(887,89,'Thi xa Tan Chau'),(888,89,'Huyen Phu Tan'),(889,89,'Huyen Chau Phu'),(890,89,'Huyen Tinh Bien'),(891,89,'Huyen Tri Ton'),(892,89,'Huyen Chau Thanh'),(893,89,'Huyen Cho Moi'),(894,89,'Huyen Thoai Son'),(899,91,'Thanh pho Rach Gia'),(900,91,'Thanh pho Ha Tien'),(902,91,'Huyen Kien Luong'),(903,91,'Huyen Hon Dat'),(904,91,'Huyen Tan Hiep'),(905,91,'Huyen Chau Thanh'),(906,91,'Huyen Giong Rieng'),(907,91,'Huyen Go Quao'),(908,91,'Huyen An Bien'),(909,91,'Huyen An Minh'),(910,91,'Huyen Vinh Thuan'),(911,91,'Thanh pho Phu Quoc'),(912,91,'Huyen Kien Hai'),(913,91,'Huyen U Minh Thuong'),(914,91,'Huyen Giang Thanh'),(916,92,'Quan Ninh Kieu'),(917,92,'Quan O Mon'),(918,92,'Quan Binh Thuy'),(919,92,'Quan Cai Rang'),(923,92,'Quan Thot Not'),(924,92,'Huyen Vinh Thanh'),(925,92,'Huyen Co Do'),(926,92,'Huyen Phong Dien'),(927,92,'Huyen Thoi Lai'),(930,93,'Thanh pho Vi Thanh'),(931,93,'Thanh pho Nga Bay'),(932,93,'Huyen Chau Thanh A'),(933,93,'Huyen Chau Thanh'),(934,93,'Huyen Phung Hiep'),(935,93,'Huyen Vi Thuy'),(936,93,'Huyen Long My'),(937,93,'Thi xa Long My'),(941,94,'Thanh pho Soc Trang'),(942,94,'Huyen Chau Thanh'),(943,94,'Huyen Ke Sach'),(944,94,'Huyen My Tu'),(945,94,'Huyen Cu Lao Dung'),(946,94,'Huyen Long Phu'),(947,94,'Huyen My Xuyen'),(948,94,'Thi xa Nga Nam'),(949,94,'Huyen Thanh Tri'),(950,94,'Thi xa Vinh Chau'),(951,94,'Huyen Tran De'),(954,95,'Thanh pho Bac Lieu'),(956,95,'Huyen Hong Dan'),(957,95,'Huyen Phuoc Long'),(958,95,'Huyen Vinh Loi'),(959,95,'Thi xa Gia Rai'),(960,95,'Huyen Dong Hai'),(961,95,'Huyen Hoa Binh'),(964,96,'Thanh pho Ca Mau'),(966,96,'Huyen U Minh'),(967,96,'Huyen Thoi Binh'),(968,96,'Huyen Tran Van Thoi'),(969,96,'Huyen Cai Nuoc'),(970,96,'Huyen Dam Doi'),(971,96,'Huyen Nam Can'),(972,96,'Huyen Phu Tan'),(973,96,'Huyen Ngoc Hien');
/*!40000 ALTER TABLE `district` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `floor`
--

DROP TABLE IF EXISTS `floor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `floor` (
  `floor_id` int NOT NULL AUTO_INCREMENT,
  `apartment_id` int NOT NULL,
  `foor_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`floor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `floor`
--

LOCK TABLES `floor` WRITE;
/*!40000 ALTER TABLE `floor` DISABLE KEYS */;
/*!40000 ALTER TABLE `floor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN'),(2,'HOST'),(3,'STAFF'),(4,'TENANT'),(5,'GUEST');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roomtype`
--

DROP TABLE IF EXISTS `roomtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roomtype` (
  `roomtype_id` int NOT NULL AUTO_INCREMENT,
  `apartment_id` int NOT NULL,
  `roomtype_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `roomtype_max_member` int DEFAULT NULL,
  `roomtype_cost` int DEFAULT NULL,
  `roomtype_area` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`roomtype_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roomtype`
--

LOCK TABLES `roomtype` WRITE;
/*!40000 ALTER TABLE `roomtype` DISABLE KEYS */;
/*!40000 ALTER TABLE `roomtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `staff_id` int NOT NULL AUTO_INCREMENT,
  `account_id` int DEFAULT NULL,
  `staff_citizen_identification` varchar(200) DEFAULT NULL,
  `staff_name` varchar(200) DEFAULT NULL,
  `staff_dob` varchar(45) DEFAULT NULL,
  `staff_phone_number` varchar(15) DEFAULT NULL,
  `staff_countryside` varchar(45) DEFAULT NULL,
  `staff_job` varchar(200) DEFAULT NULL,
  `staff_salary` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,6,'1982372138','Nguyen Van A','11-09-2002','098239018','Hoa lac','job job','700000'),(3,8,'---','Phung Quoc','11-09-2003','0911092002','Việt Nam','22','---');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-30 15:57:29
