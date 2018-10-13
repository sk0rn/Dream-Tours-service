create schema public
;

comment on schema public is 'standard public schema'
;

create table if not exists users
(
	id serial not null
		constraint users_pkey
			primary key,
	login varchar(250) not null
		constraint users_login_key
			unique,
	pass varchar(40) not null,
	options integer,
	fio varchar(250) not null,
	call_time timestamp,
	subscribe boolean,
	bonus double precision,
	album_guid varchar(40)
)
;

create unique index if not exists users_id_uindex
	on users (id)
;

create table if not exists contact
(
	id serial not null
		constraint contact_pkey
			primary key,
	client_id integer
		constraint contact_users_id_fk
			references users
				on update cascade,
	value varchar(300)
)
;

create unique index if not exists contact_id_uindex
	on contact (id)
;

create table if not exists document
(
	id serial not null
		constraint document_pkey
			primary key,
	client_id integer
		constraint document_users_id_fk
			references users
				on update cascade,
	file_name varchar(250) not null
		constraint document_file_name_key
			unique,
	doc_type varchar(250) not null
		constraint document_doc_type_key
			unique
)
;

create unique index if not exists document_id_uindex
	on document (id)
;

create table if not exists tour
(
	id serial not null
		constraint tour_pkey
			primary key,
	name varchar(250) not null,
	album_guid char(40) not null,
	youtube_url varchar(50),
	"desc" text
)
;

create unique index if not exists tour_id_uindex
	on tour (id)
;

create table if not exists wishlist
(
	client_id integer
		constraint wishlist_users_id_fk
			references users
				on update cascade,
	tour_id integer
		constraint wishlist_tour_id_fk
			references tour
				on update cascade
)
;

create table if not exists subject
(
	id serial not null
		constraint subject_pkey
			primary key,
	name varchar(250),
	"desc" text
)
;

create unique index if not exists subject_id_uindex
	on subject (id)
;

create table if not exists place
(
	id serial not null
		constraint place_pkey
			primary key,
	name varchar(250) not null
		constraint place_name_key
			unique,
	"desc" text
)
;

create unique index if not exists place_id_uindex
	on place (id)
;

create table if not exists tour_place
(
	tour_id integer
		constraint tour_place_tour_id_fk
			references tour
				on update cascade,
	place_id integer
		constraint tour_place_place_id_fk
			references place
				on update cascade
)
;

create table if not exists tour_subject
(
	tour_id integer
		constraint tour_subject_tour_id_fk
			references tour
				on update cascade,
	subject_id integer
		constraint tour_subject_subject_id_fk
			references subject
				on update cascade
)
;

create table if not exists tour_duration
(
	id serial not null
		constraint tour_duration_pkey
			primary key,
	tour_id integer
		constraint tour_duration_tour_id_fk
			references tour
				on update cascade,
	number_days integer,
	"desc" varchar(250)
)
;

create unique index if not exists tour_duration_id_uindex
	on tour_duration (id)
;

create table if not exists tour_coast
(
	id serial not null
		constraint tour_coast_pkey
			primary key,
	tour_duration_id integer not null
		constraint tour_coast_tour_duration_id_fk
			references tour_duration
				on update cascade,
	kind boolean,
	coast double precision not null,
	clippino_age integer,
	is_participant boolean
)
;

create unique index if not exists tour_coast_id_uindex
	on tour_coast (id)
;

create table if not exists tour_release
(
	id serial not null
		constraint tour_release_pkey
			primary key,
	tour_duration_id integer
		constraint tour_release_tour_duration_id_fk
			references tour_duration
				on update cascade,
	begin_time timestamp not null
		constraint tour_release_begin_time_key
			unique,
	capacity integer
)
;

create unique index if not exists tour_release_id_uindex
	on tour_release (id)
;

create table if not exists orders
(
	id serial not null
		constraint "Order_pkey"
			primary key,
	user_id integer
		constraint order_users_id_fk
			references users
				on update cascade,
	tour_release_id integer not null
		constraint orders_tour_release_id_key
			unique
		constraint order_tour_release_id_fk
			references tour_release
				on update cascade,
	coast double precision not null
		constraint orders_coast_key
			unique,
	status integer
)
;

create unique index if not exists order_id_uindex
	on orders (id)
;

create table if not exists participant
(
	id serial not null
		constraint participant_pkey
			primary key,
	order_id integer
		constraint participant_order_id_fk
			references orders
				on update cascade,
	clipping_age integer,
	quantity integer not null
)
;

create unique index if not exists participant_id_uindex
	on participant (id)
;

