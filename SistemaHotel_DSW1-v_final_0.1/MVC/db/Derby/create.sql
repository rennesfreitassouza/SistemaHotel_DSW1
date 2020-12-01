connect 'jdbc:derby:Sistema;create=true;user=root;password=root';

create table Hotel(
  id bigint not null generated always as identity (start with 1, increment by 1),
  cnpj varchar(18) not null,
  nome varchar(250) not null,
  cidade varchar(250) not null,
  email varchar(200) not null,
  senha varchar(20) not null,
  constraint Hotel_PK primary key (id)
);

create table SiteReserva(
  id bigint not null generated always as identity (start with 1, increment by 1),
  url varchar(250) not null,
  nome varchar(250) not null,
  telefone varchar(14),
  email varchar(200) not null,
  senha varchar(20) not null,
  constraint SiteReserva_PK primary key (id)
);

create table PromoHotel(
  id bigint not null generated always as identity (start with 1, increment by 1),
  preco float not null,
  iniciopromo date not null,
  fimpromo date not null,
  Hotel_id bigint not null,
  Sitereserva_id bigint not null,
  constraint Hotel_FK foreign key (hotel_id) references Hotel(id),
  constraint SiteReserva_FK foreign key (Sitereserva_id) references SiteReserva(id),
  constraint PromoHotel_PK primary key (id)
);


insert into Hotel(cnpj, nome, cidade, email, senha)
  values ('55.789.390/0008-99',
          'Hotel Boa Viagem',
          'São Carlos',
          'hotel1@hotel.com',
          'hotel1');

insert into Hotel(cnpj, nome, cidade, email, senha)
  values ('71.150.470/0001-40',
          'Hotel Bela Vista',
          'São Carlos',
          'hotel2@hotel.com',
          'hotel2');

insert into Hotel(cnpj, nome, cidade, email, senha)
  values ('32.106.536/0001-82',
          'Hotel Bienvenido',
          'São Carlos',
          'hotel3@hotel.com',
          'hotel3');

insert into SiteReserva(url, nome, telefone, email, senha)
  values ('www.sitereservabrasil.com',
          'Reserva Brasil',
          '(16)1234-5678',
          'site1@siteres.com',
          'site1');

insert into SiteReserva(url, nome, telefone, email, senha)
  values ('www.siteboareserva.com',
          'Boa Reserva',
          '(16)1234-5688',
          'site2@siteres.com',
          'site2');

insert into SiteReserva(url, nome, telefone, email, senha)
  values ('www.sitebelareserva.com',
          'Bela Reserva',
          '(16)1234-5699',
          'site3@siteres.com',
          'site3');

insert into PromoHotel(preco, iniciopromo, fimpromo, Hotel_id, SiteReserva_id)
  values (220.5, '2020-11-11', '2020-12-11', 1, 1);

insert into PromoHotel(preco, iniciopromo, fimpromo, Hotel_id, SiteReserva_id)
  values (430.5, '2020-11-11', '2020-12-11', 2, 2);

insert into PromoHotel(preco, iniciopromo, fimpromo, Hotel_id, SiteReserva_id)
values (355.5, '2020-11-11', '2020-12-11', 3, 3);

disconnect;

quit