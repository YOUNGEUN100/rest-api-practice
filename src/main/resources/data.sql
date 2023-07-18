insert into member(`id`, `name`, `email`, `create_at`, `update_at`) values (1, '홍길동', 'mars@thejoeun.com', now(), now());
insert into member(`id`, `name`, `email`, `create_at`, `update_at`) values (2, '홍길동', 'namsun@thejoeun.com', now(), now());
insert into member(`id`, `name`, `email`, `create_at`, `update_at`) values (3, '이순신', 'leesunsin@gmail.com', now(), now());
insert into member(`id`, `name`, `email`, `create_at`, `update_at`) values (4, '강감찬', 'namsun@thejoeun.com', now(), now());
insert into member(`id`, `name`, `email`, `create_at`, `update_at`) values (5, '홍길동', 'ryukwansun@thejoeun.com', now(), now());
insert into member(`id`, `name`, `email`, `create_at`, `update_at`) values (6, '이홍렬', 'hong@thejoeun.com', now(), now());

INSERT INTO recipe(`RECIPE_NO`, `RECIPE_NAME`, `COOK_TIME`, `DIFFICULTY`, `RECIPE_HITS`, `DELETE_YN`, `HASHTAG`, `CREATE_AT`) VALUES
	(1, '계란장조림', '40분이내', '쉬움', 20, 'N', '#밑반찬 #집밥 #매실청', now()),
	(4, '고추잡채', '25분', '어려움', 43, 'N', '#중식 #굴소스 #안주', now()),
	(5, '고추참치계란말이', '10분이내', '쉬움', 10, 'N', '#반찬 #간단한끼 #계란요리', now()),
	(12, '누룽지 삼계탕', '20분이내', '쉬움', 10, 'N', '#삼계탕X누룽지 #복날 #보양식', now()),
	(21, '돈까스 샌드위치', '20분이내', '보통', 47, 'N', '#식빵요리 #도시락 #마요네스', now());


insert into users(`id`,`name`,`email`) values (1, '김영미', 'kim0mi@naver.com');
insert into users(`id`,`name`,`email`) values (2, '박현아', 'hyeona@naver.com');
insert into users(`id`,`name`,`email`) values (3, '이진수', 'leejinsu@naver.com');

insert into publisher(`id`, `name`, `create_at`, `update_at`) values (1,'더조은책', now(), now());
insert into publisher(`id`, `name`, `create_at`, `update_at`) values (2,'한빛출판사', now(), now());

insert into book(`id`, `title`,`publisher_id`,`create_at`, `update_at`) values (1,'자바책',1, now(), now());
insert into book(`id`, `title`,`publisher_id`,`create_at`, `update_at`) values (2,'스프링책',1, now(), now());
insert into book(`id`, `title`,`publisher_id`,`create_at`, `update_at`) values (3,'데이버베이스책',1, now(), now());
insert into book(`id`, `title`,`publisher_id`,`create_at`, `update_at`) values (4,'자바책',2, now(), now());


