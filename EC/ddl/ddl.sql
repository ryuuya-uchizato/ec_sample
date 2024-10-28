/*会員テーブル*/
CREATE TABLE public.members
(
    member_code integer NOT NULL,
    last_name varchar(20) NOT NULL,
    frist_name varchar(20) NOT NULL,
    last_name_kana varchar(50) NOT NULL,
    first_name_kana varchar(50) NOT NULL,
    email varchar(256) NOT NULL,
    password varchar(256) NOT NULL,
    post_code char(7) NOT NULL,
    address varchar(256) NOT NULL,
    tel_number char(11) NOT NULL,
	gender_id char(1) NOT NULL,
	birthday date NOT NULL,
	deleted_status boolean NOT NULL,
	signup_date timestamp NOT NULL,
	updated_date timestamp NOT NULL,
    CONSTRAINT members_pkey PRIMARY KEY (member_code)
)

/*配送先テーブル*/
CREATE TABLE public.addresses
(
    address_code integer NOT NULL,
	member_code integer NOT NULL,
    post_code char(7) NOT NULL,
    address varchar(256) NOT NULL,
    tel_number char(11) NOT NULL,
	address_name varchar(256) NOT NULL,
	signup_date timestamp NOT NULL,
	updated_date timestamp NOT NULL,
    CONSTRAINT addresses_pkey PRIMARY KEY (address_code)
)

/*商品テーブル*/
CREATE TABLE public.items
(
    item_code integer NOT NULL,
	genre_code integer NOT NULL,
	item_name varchar(256) NOT NULL,
	item_details text NOT NULL,
    price integer NOT NULL,
	sale_status boolean NOT NULL,
	signup_date timestamp NOT NULL,
	updated_date timestamp NOT NULL,
    CONSTRAINT items_pkey PRIMARY KEY (item_code)
)

/*カート内商品テーブル*/
CREATE TABLE public.cart_items
(
    cart_item_code integer NOT NULL,
	member_code integer NOT NULL,
	item_code integer NOT NULL,
    quantity integer NOT NULL,
	signup_date timestamp NOT NULL,
	updated_date timestamp NOT NULL,
    CONSTRAINT cart_items_pkey PRIMARY KEY (cart_item_code)
)

/*ジャンルテーブル*/
CREATE TABLE public.genres
(
	genre_code integer NOT NULL,
	genre_name varchar(256) NOT NULL,
	signup_date timestamp NOT NULL,
	updated_date timestamp NOT NULL,
    CONSTRAINT genres_pkey PRIMARY KEY (genre_code)
)

/*注文テーブル*/
CREATE TABLE public.orders
(
	order_code integer NOT NULL,
	member_code integer NOT NULL,
	name varchar(256) NOT NULL,
	post_code char(7) NOT NULL,
	address varchar(256) NOT NULL,
	tel_number char(11) NOT NULL,
	shipping_fee integer NOT NULL,
	total_price integer NOT NULL,
	order_status integer NOT NULL,
	pay_method integer NOT NULL,
	signup_date timestamp NOT NULL,
	updated_date timestamp NOT NULL,
    CONSTRAINT orders_pkey PRIMARY KEY (order_code)
)
/*注文詳細テーブル*/
CREATE TABLE public.order_details
(
	order_item_code integer NOT NULL,
	order_code integer NOT NULL,
	item_code integer NOT NULL,
	price integer NOT NULL,
	quantity integer NOT NULL,
	making_status integer NOT NULL,
	signup_date timestamp NOT NULL,
	updated_date timestamp NOT NULL,
    CONSTRAINT order_details_pkey PRIMARY KEY (order_item_code)
)

/*ロールテーブル*/
CREATE TABLE public.member_roles
(
    member_code integer NOT NULL,
    role char(2) NOT NULL,
    delflg char(1),
    CONSTRAINT member_roles_pkey PRIMARY KEY (member_code, role)
)

/*コードマスタテーブル*/
CREATE TABLE public.codemst
(
    code_id integer NOT NULL,
    code character varying(8) COLLATE pg_catalog."default" NOT NULL,
    code_nm character varying(256) COLLATE pg_catalog."default",
    delflg character(1) COLLATE pg_catalog."default"
)


