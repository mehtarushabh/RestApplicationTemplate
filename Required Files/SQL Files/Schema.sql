CREATE TABLE users (
	"userId"    serial PRIMARY KEY,
	"firstName" character varying(512),
	"lastName"  character varying(512),
	"email"     character varying(512),
	"password"  character varying(256),
	"dob"       date
);