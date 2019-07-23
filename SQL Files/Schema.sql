CREATE TABLE users (
	userId      serial PRIMARY KEY,
	"firstName" character varying(256),
	"lastName"  character varying(256),
	email       character varying(256),
	password    character varying(256),
	dob         date
)