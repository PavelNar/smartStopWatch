-- Kustutab public schema (mis põhimõtteliselt kustutab kõik tabelid)
DROP SCHEMA public CASCADE;
-- Loob uue public schema vajalikud õigused
CREATE SCHEMA public
-- taastab vajalikud andmebaasi õigused
    GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-09-16 09:58:27.985

-- tables
-- Table: athlete
CREATE TABLE athlete (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    name varchar(255)  NOT NULL,
    is_active boolean  NOT NULL,
    CONSTRAINT athlete_pk PRIMARY KEY (id)
);

-- Table: athlete_event
CREATE TABLE athlete_event (
    id serial  NOT NULL,
    athlete_id int  NULL,
    event_id int  NOT NULL,
    stroke_id int  NOT NULL,
    start_time timestamp  NULL,
    finish_time timestamp  NULL,
    heat_number int  NOT NULL,
    lane_number int  NOT NULL,
    event_length int  NULL,
    split_length int  NOT NULL,
    split_counter int  NOT NULL,
    is_active boolean  NOT NULL,
    CONSTRAINT athlete_event_pk PRIMARY KEY (id)
);

-- Table: event
CREATE TABLE event (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    stroke_id int  NOT NULL,
    date_time timestamp  NOT NULL,
    event_length int  NULL,
    split_length_id int  NOT NULL,
    number_of_athletes int  NULL,
    number_of_heats int  NULL,
    number_of_lanes int  NULL,
    CONSTRAINT event_pk PRIMARY KEY (id)
);

-- Table: heat
CREATE TABLE heat (
    id serial  NOT NULL,
    event_id int  NOT NULL,
    start timestamp  NOT NULL,
    "end" timestamp  NULL,
    CONSTRAINT heat_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
    id serial  NOT NULL,
    role varchar(255)  NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: split
CREATE TABLE split (
    id serial  NOT NULL,
    start timestamp  NOT NULL,
    "end" timestamp  NULL,
    athlete_id int  NOT NULL,
    athlete_event_id int  NOT NULL,
    is_active boolean  NOT NULL DEFAULT true,
    CONSTRAINT split_pk PRIMARY KEY (id)
);

-- Table: split_length
CREATE TABLE split_length (
    id serial  NOT NULL,
    meters int  NOT NULL,
    time_delay int  NULL,
    CONSTRAINT split_length_pk PRIMARY KEY (id)
);

-- Table: stroke
CREATE TABLE stroke (
    id serial  NOT NULL,
    type varchar(255)  NOT NULL,
    CONSTRAINT stroke_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
    id serial  NOT NULL,
    role_id int  NOT NULL,
    user_name varchar(255)  NOT NULL,
    password varchar(255)  NOT NULL,
    is_active boolean  NOT NULL,
    CONSTRAINT user_name_ak UNIQUE (user_name) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: athlete_event_athlete (table: athlete_event)
ALTER TABLE athlete_event ADD CONSTRAINT athlete_event_athlete
    FOREIGN KEY (athlete_id)
    REFERENCES athlete (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: athlete_event_event (table: athlete_event)
ALTER TABLE athlete_event ADD CONSTRAINT athlete_event_event
    FOREIGN KEY (event_id)
    REFERENCES event (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: athlete_event_stroke (table: athlete_event)
ALTER TABLE athlete_event ADD CONSTRAINT athlete_event_stroke
    FOREIGN KEY (stroke_id)
    REFERENCES stroke (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: athlete_user (table: athlete)
ALTER TABLE athlete ADD CONSTRAINT athlete_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: event_split_length (table: event)
ALTER TABLE event ADD CONSTRAINT event_split_length
    FOREIGN KEY (split_length_id)
    REFERENCES split_length (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: event_stroke (table: event)
ALTER TABLE event ADD CONSTRAINT event_stroke
    FOREIGN KEY (stroke_id)
    REFERENCES stroke (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: event_user (table: event)
ALTER TABLE event ADD CONSTRAINT event_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: heat_event (table: heat)
ALTER TABLE heat ADD CONSTRAINT heat_event
    FOREIGN KEY (event_id)
    REFERENCES event (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: split_athlete (table: split)
ALTER TABLE split ADD CONSTRAINT split_athlete
    FOREIGN KEY (athlete_id)
    REFERENCES athlete (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: split_athlete_event (table: split)
ALTER TABLE split ADD CONSTRAINT split_athlete_event
    FOREIGN KEY (athlete_event_id)
    REFERENCES athlete_event (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
    REFERENCES role (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

