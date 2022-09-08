-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-09-08 06:53:19.035

-- tables
-- Table: athlete
CREATE TABLE athlete (
    id serial  NOT NULL,
    first_name varchar(255)  NOT NULL,
    last_name varchar(255)  NOT NULL,
    personal_code varchar(255)  NOT NULL,
    CONSTRAINT personal_code_ak UNIQUE (personal_code) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT athlete_pk PRIMARY KEY (id)
);

-- Table: athlete_event
CREATE TABLE athlete_event (
    id serial  NOT NULL,
    athlete_id int  NOT NULL,
    event_id int  NOT NULL,
    start_time timestamp  NOT NULL,
    finish_time timestamp  NOT NULL,
    heat_number int  NOT NULL,
    lane_number int  NOT NULL,
    event_length int  NOT NULL,
    split_length int  NOT NULL,
    split_counter int  NOT NULL,
    CONSTRAINT athlete_event_pk PRIMARY KEY (id)
);

-- Table: event
CREATE TABLE event (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    stroke_id int  NOT NULL,
    date_time timestamp  NOT NULL,
    event_length int  NOT NULL,
    split_length_id int  NOT NULL,
    number_of_athletes int  NULL,
    number_of_heats int  NOT NULL,
    number_of_lanes int  NOT NULL,
    heat_interval_seconds int  NULL,
    CONSTRAINT event_pk PRIMARY KEY (id)
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
    CONSTRAINT split_pk PRIMARY KEY (id)
);

-- Table: split_length
CREATE TABLE split_length (
    id serial  NOT NULL,
    meters int  NOT NULL,
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
    user_name varchar(255)  NOT NULL,
    password varchar(255)  NOT NULL,
    CONSTRAINT user_name_ak UNIQUE (user_name) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: user_role
CREATE TABLE user_role (
    id serial  NOT NULL,
    role_id int  NOT NULL,
    user_id int  NOT NULL,
    CONSTRAINT user_role_pk PRIMARY KEY (id)
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

-- Reference: user_role_role (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_role
    FOREIGN KEY (role_id)
    REFERENCES role (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role_user (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

