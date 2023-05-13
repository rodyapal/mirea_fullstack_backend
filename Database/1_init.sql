CREATE TABLE services
(
    id_service  SERIAL PRIMARY KEY,
    name        VARCHAR(128) NOT NULL check ( length(name) > 0 ),
    description TEXT         NOT NULL check ( length(description) > 0 ),
    duration    INT          NOT NULL check ( duration > 0 ),
    price       INT          NOT NULL check ( price > 0 )
);

CREATE TABLE barbers
(
    id_barber SERIAL PRIMARY KEY,
    name      VARCHAR(128) NOT NULL check ( length(name) > 0 )
);

CREATE TABLE barber_service
(
    id_barber  INT NOT NULL,
    id_service INT NOT NULL,
    FOREIGN KEY (id_barber) REFERENCES barbers (id_barber) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_service) REFERENCES services (id_service) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (id_barber, id_service)
);

CREATE TABLE clients
(
    id_client    SERIAL PRIMARY KEY,
    name         VARCHAR(128) NOT NULL check ( length(name) > 0 ),
    email        VARCHAR(128) NOT NULL,
    password     VARCHAR(128) NOT NULL check ( length(password) > 7 ),
    phone_number VARCHAR(128) NOT NULL
);

CREATE TABLE events
(
    id_event        SERIAL,
    id_service      INT       NOT NULL,
    id_barber       INT       NOT NULL,
    id_client       INT       NOT NULL,
    visit_date_time TIMESTAMP NOT NULL,
    FOREIGN KEY (id_barber) REFERENCES barbers (id_barber) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_service) REFERENCES services (id_service) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_client) REFERENCES clients (id_client) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (id_event, id_service, id_barber, id_client)
);