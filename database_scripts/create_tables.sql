CREATE TABLE IF NOT EXISTS ticketmaster.city(
  cityID int primary key,
  name varchar(64),
  state varchar(64),
  zipCode varchar(16)
);

CREATE TABLE IF NOT EXISTS ticketmaster.cinema(
  cinemaID int primary key,
  name varchar(64),
  totalCienaHalls int,
  cityID int,
  FOREIGN KEY (cityID) REFERENCES ticketmaster.city (cityID)
);

CREATE TABLE IF NOT EXISTS ticketmaster.cinema_hall(
  cinemaHallID int primary key,
  name varchar(64),
  totalSeats int,
  cinemaID int,
  FOREIGN KEY (cinemaID) REFERENCES ticketmaster.cinema (cinemaID)
);

CREATE TABLE IF NOT EXISTS ticketmaster.cinema_seat(
  cinemaSeatID int primary key,
  seatNumber int,
  type int,
  cinemaHallID int,
  FOREIGN KEY (cinemaHallID) REFERENCES ticketmaster.cinema_hall (cinemaHallID)
);

CREATE TABLE IF NOT EXISTS ticketmaster.movie(
  movieID int primary key,
  title varchar(256),
  description varchar(512),
  duration datetime,
  language varchar(16),
  releaseDate datetime,
  country varchar(64),
  genre varchar(20)
);

CREATE TABLE IF NOT EXISTS ticketmaster.show(
  showID int primary key,
  date datetime,
  startTime datetime,
  endtime datetime,
  cinemaHallID int,
  movieID int,
  FOREIGN KEY (cinemaHallID) REFERENCES ticketmaster.cinema_hall (cinemaHallID),
  FOREIGN KEY (movieID) REFERENCES ticketmaster.movie (movieID)
);

CREATE TABLE IF NOT EXISTS ticketmaster.user(
  userID int primary key,
  name varchar(64),
  password varchar(20),
  email varchar(512),
  phone varchar(16)
);

CREATE TABLE IF NOT EXISTS ticketmaster.booking(
  bookingID int primary key,
  numberOfSeats int,
  timeStamp datetime,
  status int,
  userID int,
  showID int,
  FOREIGN KEY (userID) REFERENCES ticketmaster.user (userID),
  FOREIGN KEY (showID) REFERENCES ticketmaster.show (showID)  
);

CREATE TABLE IF NOT EXISTS ticketmaster.show_seat(
  showSeatID int primary key,
  status int,
  price decimal(19,4),
  cinemaSeatID int,
  showID int,
  bookingID int,
  FOREIGN KEY (cinemaSeatID) REFERENCES ticketmaster.cinema_seat (cinemaSeatID),
  FOREIGN KEY (showID) REFERENCES ticketmaster.show (showID),
  FOREIGN KEY (bookingID) REFERENCES ticketmaster.booking (bookingID) 
); 

CREATE TABLE IF NOT EXISTS ticketmaster.payment(
  paymentID int primary key,
  amount decimal(19,4),
  timeStamp datetime,
  discountCouponID int,
  remoteTransactionID int,
  paymentMethod int,
  bookingID int,
  FOREIGN KEY (bookingID) REFERENCES ticketmaster.booking (bookingID) 
);
