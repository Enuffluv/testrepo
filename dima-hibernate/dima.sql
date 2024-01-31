use hibernatedima;

create table users(
                      id int auto_increment not null,
                      name varchar(35),
                      primary key (id)
);

create table posts(
                      id int auto_increment not null,
                      title varchar(35),
                      date int,
                      user_id int,
                      foreign key (user_id) references users(id),
                      primary key (id)
);