DROP TABLE IF EXISTS material;
DROP TABLE IF EXISTS step;
DROP TABLE IF EXISTS project_category;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS project;

CREATE TABLE project (
	project_id INT AUTO_INCREMENT NOT NULL,
	project_name VARCHAR(128) NOT NULL,
	estimated_hours DECIMAL(7,2),
	actual_hours DECIMAL (7,2),
	difficulty INT ,
	notes TEXT,
);

CREATE TABLE category ();

CREATE TABLE project_category ();

CREATE TABLE step ();

CREATE TABLE material ();