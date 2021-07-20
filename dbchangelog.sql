-- liquibase formatted sql

-- changeset Viktoriia_Skirko:1618341201054-1
ALTER TABLE "public"."animal" ADD "owner_id" BIGINT;

-- changeset Viktoriia_Skirko:1618341201054-2
ALTER TABLE "public"."animal" ADD "breed_id" SMALLINT NOT NULL;

-- changeset Viktoriia_Skirko:1618341201054-3
ALTER TABLE "public"."animal" ADD "type_id" SMALLINT NOT NULL;

-- changeset Viktoriia_Skirko:1618341201054-4
ALTER TABLE "public"."animal" ADD "curator_id" BIGINT;

-- changeset Viktoriia_Skirko:1618341201054-5
ALTER TABLE "public"."animal" ADD "gender_id" SMALLINT NOT NULL;

-- changeset Viktoriia_Skirko:1618341201054-6
ALTER TABLE "public"."curator" ADD "organization_id" BIGINT NOT NULL;

-- changeset Viktoriia_Skirko:1618341201054-7
ALTER TABLE "public"."animal" ADD "color_id" SMALLINT NOT NULL;

-- changeset Viktoriia_Skirko:1618341201054-8
ALTER TABLE "public"."animal" ADD "city_id" SMALLINT NOT NULL;

-- changeset Viktoriia_Skirko:1618341201054-9
ALTER TABLE "public"."organization" ADD "city_id" SMALLINT NOT NULL;

-- changeset Viktoriia_Skirko:1618341201054-10
ALTER TABLE "public"."breed" ADD "type_id" SMALLINT NOT NULL;

-- changeset Viktoriia_Skirko:1618341201054-11
ALTER TABLE "public"."type" ADD "id" SMALLSERIAL(5) GENERATED BY DEFAULT AS IDENTITY NOT NULL;

-- changeset Viktoriia_Skirko:1618341201054-12
ALTER TABLE "public"."owner" ADD "id" BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL;

-- changeset Viktoriia_Skirko:1618341201054-13
ALTER TABLE "public"."organization" ADD "id" BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL;

-- changeset Viktoriia_Skirko:1618341201054-14
ALTER TABLE "public"."health" ADD "id" SMALLSERIAL(5) GENERATED BY DEFAULT AS IDENTITY NOT NULL;

-- changeset Viktoriia_Skirko:1618341201054-15
ALTER TABLE "public"."gender" ADD "id" SMALLSERIAL(5) GENERATED BY DEFAULT AS IDENTITY NOT NULL;

-- changeset Viktoriia_Skirko:1618341201054-16
ALTER TABLE "public"."curator" ADD "id" BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL;

-- changeset Viktoriia_Skirko:1618341201054-17
ALTER TABLE "public"."color" ADD "id" SMALLSERIAL(5) GENERATED BY DEFAULT AS IDENTITY NOT NULL;

-- changeset Viktoriia_Skirko:1618341201054-18
ALTER TABLE "public"."city" ADD "id" SMALLSERIAL(5) GENERATED BY DEFAULT AS IDENTITY NOT NULL;

-- changeset Viktoriia_Skirko:1618341201054-19
ALTER TABLE "public"."breed" ADD "id" BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL;

-- changeset Viktoriia_Skirko:1618341201054-20
ALTER TABLE "public"."animal" ADD "id" BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL;

-- changeset Viktoriia_Skirko:1618341201054-21
CREATE TABLE "public"."animal" ("id" BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, "name" VARCHAR(100), "avatar" BYTEA, "behavior" TEXT, "birthday" TIMESTAMP WITHOUT TIME ZONE, "city_id" SMALLINT NOT NULL, "color_id" SMALLINT NOT NULL, "health_id" SMALLINT NOT NULL, "history" TEXT, "has_passport" BOOLEAN DEFAULT FALSE NOT NULL, "organization_id" SMALLINT, "gender_id" SMALLINT NOT NULL, "is_sterilized" BOOLEAN, "is_vaccinated" BOOLEAN, "curator_id" BIGINT, "booked" BOOLEAN DEFAULT FALSE NOT NULL, "type_id" SMALLINT NOT NULL, "breed_id" SMALLINT NOT NULL, "owner_id" BIGINT, "created_at" TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL, "is_deleted" BOOLEAN DEFAULT FALSE NOT NULL, CONSTRAINT "animal_pkey" PRIMARY KEY ("id"));

-- changeset Viktoriia_Skirko:1618341201054-22
INSERT INTO "public"."animal" ("id", "name", "avatar", "behavior", "birthday", "city_id", "color_id", "health_id", "history", "has_passport", "organization_id", "gender_id", "is_sterilized", "is_vaccinated", "curator_id", "booked", "type_id", "breed_id", "owner_id", "created_at", "is_deleted") VALUES (1, 'Gayka', NULL, 'Doesn''t misbehave, does not spoil anything, she is accustomed to walking', '2018-02-02 00:00:00', 1, 1, 1, 'Lives in a shelter, but hopes to find a home and a faithful friend.', TRUE, 1, 2, TRUE, TRUE, 1, FALSE, 2, 2, NULL, '2021-04-04 18:18:27.967531', FALSE);
INSERT INTO "public"."animal" ("id", "name", "avatar", "behavior", "birthday", "city_id", "color_id", "health_id", "history", "has_passport", "organization_id", "gender_id", "is_sterilized", "is_vaccinated", "curator_id", "booked", "type_id", "breed_id", "owner_id", "created_at", "is_deleted") VALUES (2, 'Visky', NULL, 'Friendly, cute, who likes to purr', '2016-12-03 00:00:00', 1, 2, 1, 'Visky is a very ordinary pussy who believes that she will be needed and loved by someone.
This is every cat''s dream, and our Visky is no exception.', FALSE, 1, 2, TRUE, TRUE, 1, FALSE, 1, 1, NULL, '2021-04-04 18:18:27.967531', FALSE);
INSERT INTO "public"."animal" ("id", "name", "avatar", "behavior", "birthday", "city_id", "color_id", "health_id", "history", "has_passport", "organization_id", "gender_id", "is_sterilized", "is_vaccinated", "curator_id", "booked", "type_id", "breed_id", "owner_id", "created_at", "is_deleted") VALUES (3, 'Matilda', NULL, 'She is charming! Meek, neat and dignified! Very gentle and affectionate. Likes to play. Not big, looks like a teenager - a real beauty!', '2017-12-03 00:00:00', 2, 2, 2, 'We found her by the road completely confused and scared with her little brothers and sisters.', FALSE, 2, 2, FALSE, TRUE, 2, FALSE, 1, 1, NULL, '2021-04-12 20:56:10.638921', FALSE);
INSERT INTO "public"."animal" ("id", "name", "avatar", "behavior", "birthday", "city_id", "color_id", "health_id", "history", "has_passport", "organization_id", "gender_id", "is_sterilized", "is_vaccinated", "curator_id", "booked", "type_id", "breed_id", "owner_id", "created_at", "is_deleted") VALUES (4, 'Rex', NULL, 'Calm, unobtrusive. good guard', '2017-12-12 00:00:00', 2, 3, 1, 'Found outside the city. Was still newborns taken to the field', FALSE, 2, 1, FALSE, FALSE, 2, FALSE, 2, 2, NULL, '2021-04-12 20:59:53.984078', FALSE);
INSERT INTO "public"."animal" ("id", "name", "avatar", "behavior", "birthday", "city_id", "color_id", "health_id", "history", "has_passport", "organization_id", "gender_id", "is_sterilized", "is_vaccinated", "curator_id", "booked", "type_id", "breed_id", "owner_id", "created_at", "is_deleted") VALUES (5, 'Buch', NULL, 'Active, curious', '2018-12-12 00:00:00', 1, 1, 1, 'Found in a field outside the city', FALSE, 1, 1, FALSE, FALSE, 1, FALSE, 2, 4, NULL, '2021-04-12 21:03:04.844418', FALSE);
INSERT INTO "public"."animal" ("id", "name", "avatar", "behavior", "birthday", "city_id", "color_id", "health_id", "history", "has_passport", "organization_id", "gender_id", "is_sterilized", "is_vaccinated", "curator_id", "booked", "type_id", "breed_id", "owner_id", "created_at", "is_deleted") VALUES (6, 'Helga', NULL, 'Active and playful', '2019-02-12 00:00:00', 1, 1, 1, 'Found in a box in a box', TRUE, 1, 2, TRUE, TRUE, 1, FALSE, 1, 3, NULL, '2021-04-12 21:05:46.303343', FALSE);
INSERT INTO "public"."animal" ("id", "name", "avatar", "behavior", "birthday", "city_id", "color_id", "health_id", "history", "has_passport", "organization_id", "gender_id", "is_sterilized", "is_vaccinated", "curator_id", "booked", "type_id", "breed_id", "owner_id", "created_at", "is_deleted") VALUES (7, 'Pulga', NULL, 'Very intelligent, incredibly kind and purring. He is incredibly happy when he is scratched behind the ear', '2020-02-12 00:00:00', 1, 1, 3, 'Gorgeous young handsome cat is looking for a caring and loving owner, a warm and cozy home', TRUE, 1, 1, TRUE, TRUE, 2, FALSE, 1, 1, NULL, '2021-04-12 21:09:21.907537', FALSE);
INSERT INTO "public"."animal" ("id", "name", "avatar", "behavior", "birthday", "city_id", "color_id", "health_id", "history", "has_passport", "organization_id", "gender_id", "is_sterilized", "is_vaccinated", "curator_id", "booked", "type_id", "breed_id", "owner_id", "created_at", "is_deleted") VALUES (8, 'Gata', NULL, 'Playful, active, smart girl', '2020-02-02 00:00:00', 1, 2, 1, 'The kitten lives in a shelter and really wants to find a real caring family.', TRUE, 1, 2, FALSE, TRUE, 2, FALSE, 1, 3, NULL, '2021-04-12 21:14:45.35568', FALSE);
INSERT INTO "public"."animal" ("id", "name", "avatar", "behavior", "birthday", "city_id", "color_id", "health_id", "history", "has_passport", "organization_id", "gender_id", "is_sterilized", "is_vaccinated", "curator_id", "booked", "type_id", "breed_id", "owner_id", "created_at", "is_deleted") VALUES (10, 'Kiriusha', NULL, 'Calm cat', '2019-06-03 00:00:00', 1, 4, 1, 'Found her abandoned in the park by all signs was a domestic cat.', FALSE, 1, 2, TRUE, TRUE, 1, TRUE, 1, 1, 2, '2021-04-12 21:17:40.373033', FALSE);
INSERT INTO "public"."animal" ("id", "name", "avatar", "behavior", "birthday", "city_id", "color_id", "health_id", "history", "has_passport", "organization_id", "gender_id", "is_sterilized", "is_vaccinated", "curator_id", "booked", "type_id", "breed_id", "owner_id", "created_at", "is_deleted") VALUES (9, 'Bublik', NULL, 'Friendly, very kind and loyal dog', '2019-03-03 00:00:00', 1, 1, 1, 'The owners went abroad and the dog was left completely alone, homeless and without a family', TRUE, 1, 1, TRUE, TRUE, 1, TRUE, 2, 4, 2, '2021-04-12 21:14:45.35568', FALSE);

-- changeset Viktoriia_Skirko:1618341201054-23
CREATE TABLE "public"."breed" ("id" BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, "name" VARCHAR(250) NOT NULL, "type_id" SMALLINT NOT NULL, "created_at" TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL, CONSTRAINT "breed_pkey" PRIMARY KEY ("id"));

-- changeset Viktoriia_Skirko:1618341201054-24
INSERT INTO "public"."breed" ("id", "name", "type_id", "created_at") VALUES (1, 'Metis', 1, '2021-04-04 18:19:12.751333');
INSERT INTO "public"."breed" ("id", "name", "type_id", "created_at") VALUES (2, 'Metis', 2, '2021-04-04 18:19:12.751333');
INSERT INTO "public"."breed" ("id", "name", "type_id", "created_at") VALUES (3, 'Scottish straight', 1, '2021-04-04 18:19:12.751333');
INSERT INTO "public"."breed" ("id", "name", "type_id", "created_at") VALUES (4, 'Siberian husky', 2, '2021-04-04 18:19:12.751333');

-- changeset Viktoriia_Skirko:1618341201054-25
CREATE TABLE "public"."city" ("id" SMALLSERIAL(5) GENERATED BY DEFAULT AS IDENTITY NOT NULL, "name" VARCHAR(200) NOT NULL, "created_at" TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL, CONSTRAINT "city_pkey" PRIMARY KEY ("id"));

-- changeset Viktoriia_Skirko:1618341201054-26
INSERT INTO "public"."city" ("id", "name", "created_at") VALUES (1, 'Kharkiv', '2021-04-04 18:13:34.931423');
INSERT INTO "public"."city" ("id", "name", "created_at") VALUES (2, 'Kyiv', '2021-04-04 18:13:34.931423');
INSERT INTO "public"."city" ("id", "name", "created_at") VALUES (3, 'Kherson', '2021-04-05 23:48:10.47856');

-- changeset Viktoriia_Skirko:1618341201054-27
CREATE TABLE "public"."color" ("id" SMALLSERIAL(5) GENERATED BY DEFAULT AS IDENTITY NOT NULL, "description" VARCHAR(100) NOT NULL, "created_at" TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL, CONSTRAINT "color_pkey" PRIMARY KEY ("id"));

-- changeset Viktoriia_Skirko:1618341201054-28
INSERT INTO "public"."color" ("id", "description", "created_at") VALUES (1, 'black', '2021-04-04 18:13:55.169208');
INSERT INTO "public"."color" ("id", "description", "created_at") VALUES (2, 'grey', '2021-04-04 18:13:55.169208');
INSERT INTO "public"."color" ("id", "description", "created_at") VALUES (3, 'white', '2021-04-04 18:13:55.169208');
INSERT INTO "public"."color" ("id", "description", "created_at") VALUES (4, 'red', '2021-04-04 18:13:55.169208');

-- changeset Viktoriia_Skirko:1618341201054-29
CREATE TABLE "public"."curator" ("id" BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, "first_name" VARCHAR(250) NOT NULL, "last_name" VARCHAR(250) NOT NULL, "phone_number" VARCHAR(100), "created_at" TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL, "is_deleted" BOOLEAN DEFAULT FALSE NOT NULL, "organization_id" BIGINT NOT NULL, CONSTRAINT "curator_pkey" PRIMARY KEY ("id"));

-- changeset Viktoriia_Skirko:1618341201054-30
INSERT INTO "public"."curator" ("id", "first_name", "last_name", "phone_number", "created_at", "is_deleted", "organization_id") VALUES (1, 'Viktoriia', 'Skirko', '+380 95 706 35 23', '2021-04-04 18:14:17.146539', FALSE, 1);
INSERT INTO "public"."curator" ("id", "first_name", "last_name", "phone_number", "created_at", "is_deleted", "organization_id") VALUES (2, 'Artem', 'Romanenko', '+380 95 888 83 68', '2021-04-04 18:14:17.146539', FALSE, 2);

-- changeset Viktoriia_Skirko:1618341201054-31
CREATE TABLE "public"."owner" ("id" BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, "first_name" VARCHAR(250) NOT NULL, "last_name" VARCHAR(250) NOT NULL, "phone_number" VARCHAR(100) NOT NULL, "created_at" TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL, "is_deleted" BOOLEAN DEFAULT FALSE NOT NULL, CONSTRAINT "owner_pkey" PRIMARY KEY ("id"));

-- changeset Viktoriia_Skirko:1618341201054-32
INSERT INTO "public"."owner" ("id", "first_name", "last_name", "phone_number", "created_at", "is_deleted") VALUES (1, 'Liza', 'Klimenko', '+380 95 765 23 41', '2021-04-04 18:15:25.66301', FALSE);
INSERT INTO "public"."owner" ("id", "first_name", "last_name", "phone_number", "created_at", "is_deleted") VALUES (2, 'Viktoriia', 'Glushko', '+380 66 725 73 72', '2021-04-13 02:11:07.738449', FALSE);

-- changeset Viktoriia_Skirko:1618341201054-33
CREATE TABLE "public"."gender" ("id" SMALLSERIAL(5) GENERATED BY DEFAULT AS IDENTITY NOT NULL, "name" VARCHAR(20) NOT NULL, "created_at" TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL, CONSTRAINT "sex_pkey" PRIMARY KEY ("id"));

-- changeset Viktoriia_Skirko:1618341201054-34
INSERT INTO "public"."gender" ("id", "name", "created_at") VALUES (1, 'male', '2021-04-04 18:23:10.63379');
INSERT INTO "public"."gender" ("id", "name", "created_at") VALUES (2, 'female', '2021-04-04 18:23:10.63379');

-- changeset Viktoriia_Skirko:1618341201054-35
CREATE TABLE "public"."type" ("id" SMALLSERIAL(5) GENERATED BY DEFAULT AS IDENTITY NOT NULL, "name" VARCHAR(20) NOT NULL, "created_at" TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL, CONSTRAINT "type_pkey" PRIMARY KEY ("id"));

-- changeset Viktoriia_Skirko:1618341201054-36
INSERT INTO "public"."type" ("id", "name", "created_at") VALUES (1, 'cat', '2021-04-04 18:24:24.420916');
INSERT INTO "public"."type" ("id", "name", "created_at") VALUES (2, 'dog', '2021-04-04 18:24:24.420916');

-- changeset Viktoriia_Skirko:1618341201054-37
CREATE TABLE "public"."health" ("id" SMALLSERIAL(5) GENERATED BY DEFAULT AS IDENTITY NOT NULL, "description" VARCHAR(50) NOT NULL, "created_at" TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL, CONSTRAINT "health_pkey" PRIMARY KEY ("id"));

-- changeset Viktoriia_Skirko:1618341201054-38
INSERT INTO "public"."health" ("id", "description", "created_at") VALUES (1, 'healthy', '2021-04-04 18:21:37.285711');
INSERT INTO "public"."health" ("id", "description", "created_at") VALUES (2, 'sick', '2021-04-04 18:21:37.285711');
INSERT INTO "public"."health" ("id", "description", "created_at") VALUES (3, 'featured', '2021-04-04 18:21:37.285711');

-- changeset Viktoriia_Skirko:1618341201054-39
CREATE TABLE "public"."organization" ("id" BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, "name" VARCHAR(200) NOT NULL, "address" VARCHAR(250) NOT NULL, "phone_number" VARCHAR(100) NOT NULL, "city_id" SMALLINT NOT NULL, "created_at" TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL, "is_deleted" BOOLEAN DEFAULT FALSE NOT NULL, CONSTRAINT "organization_pkey" PRIMARY KEY ("id"));

-- changeset Viktoriia_Skirko:1618341201054-40
INSERT INTO "public"."organization" ("id", "name", "address", "phone_number", "city_id", "created_at", "is_deleted") VALUES (2, 'Happy Cat Club', 'Zhukovsky Avenue (Astronomical Street). Kharkiv, Kharkov region', '+380 57 315 40 11', 1, '2021-04-04 18:15:07.614885', FALSE);
INSERT INTO "public"."organization" ("id", "name", "address", "phone_number", "city_id", "created_at", "is_deleted") VALUES (1, 'Pet4Y', 'Amosova street, 13, Kharkiv, Kharkiv region', '+380 93 408 09 36', 1, '2021-04-04 18:15:07.614885', TRUE);
INSERT INTO "public"."organization" ("id", "name", "address", "phone_number", "city_id", "created_at", "is_deleted") VALUES (19, 'TestName', 'TestAddress', '+380 65 725 73 72', 2, '2021-04-13 01:10:55.842605', TRUE);

-- changeset Viktoriia_Skirko:1618341201054-41
ALTER TABLE "public"."organization" ADD CONSTRAINT "organization_city_fk" FOREIGN KEY ("city_id") REFERENCES "public"."city" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset Viktoriia_Skirko:1618341201054-42
ALTER TABLE "public"."animal" ADD CONSTRAINT "animal_breed_fk" FOREIGN KEY ("breed_id") REFERENCES "public"."breed" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset Viktoriia_Skirko:1618341201054-43
ALTER TABLE "public"."animal" ADD CONSTRAINT "animal_city_fk" FOREIGN KEY ("city_id") REFERENCES "public"."city" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset Viktoriia_Skirko:1618341201054-44
ALTER TABLE "public"."animal" ADD CONSTRAINT "animal_color_fk" FOREIGN KEY ("color_id") REFERENCES "public"."color" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset Viktoriia_Skirko:1618341201054-45
ALTER TABLE "public"."animal" ADD CONSTRAINT "animal_curator_fk" FOREIGN KEY ("curator_id") REFERENCES "public"."curator" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset Viktoriia_Skirko:1618341201054-46
ALTER TABLE "public"."animal" ADD CONSTRAINT "animal_owner_fk" FOREIGN KEY ("owner_id") REFERENCES "public"."owner" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset Viktoriia_Skirko:1618341201054-47
ALTER TABLE "public"."animal" ADD CONSTRAINT "animal_sex_fk" FOREIGN KEY ("gender_id") REFERENCES "public"."gender" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset Viktoriia_Skirko:1618341201054-48
ALTER TABLE "public"."animal" ADD CONSTRAINT "animal_type_fk" FOREIGN KEY ("type_id") REFERENCES "public"."type" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset Viktoriia_Skirko:1618341201054-49
ALTER TABLE "public"."breed" ADD CONSTRAINT "breed_type_fk" FOREIGN KEY ("type_id") REFERENCES "public"."type" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

-- changeset Viktoriia_Skirko:1618341201054-50
ALTER TABLE "public"."curator" ADD CONSTRAINT "curator_organization_fk" FOREIGN KEY ("organization_id") REFERENCES "public"."organization" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;
