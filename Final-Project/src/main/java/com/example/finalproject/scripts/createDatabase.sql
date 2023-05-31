CREATE TABLE products(
                         id serial primary key,
                         name varchar(100) NOT NULL,
                         type varchar(50) not null,
                         price numeric(5, 2) not null
);

CREATE TABLE salesperson(
                            id serial primary key,
                            name varchar(100) not null,
                            history_id integer not null,
                            username varchar(100) not null,

                            FOREIGN KEY(history_id)
                                REFERENCES historic(id)
);

CREATE TABLE sell(
                     id serial primary key,
                     product_id integer not null,
                     salesperson_id integer not null,
                     total_price numeric(6, 2) not null,

                     FOREIGN KEY(salesperson_id)
                         REFERENCES salesperson(id),

                     FOREIGN KEY (product_id)
                         REFERENCES products(id)
);

CREATE TABLE historic(
                         id serial primary key,
                         sell_id integer not null,

                         FOREIGN KEY (sell_id)
                             REFERENCES sell(id)
);

CREATE TABLE clients(
                        id serial primary key,
                        name varchar(100) not null,
                        phone_number varchar(20) not null,
                        address varchar(200) not null,
                        history_id integer,
                        password varchar(255) not null,

                        FOREIGN KEY(history_id)
                            REFERENCES historic(id)
                            ON DELETE CASCADE
);

CREATE TABLE managers(
                         id serial primary key,
                         name varchar(100) not null,
                         username varchar(100) not null,
                         password varchar(255) not null
)