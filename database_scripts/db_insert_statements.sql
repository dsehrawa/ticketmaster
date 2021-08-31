/* create two Cities in Delhi */
insert into ticketmaster.city values(1, 'Vasant Kunj, New Delhi', 'Delhi', 110070);
insert into ticketmaster.city values(2, 'Saket, New Delhi', 'Delhi', 110071);

/* create cinema for Vasant Kunj */
insert into ticketmaster.cinema values(1, 'PVR', 2, 1);
insert into ticketmaster.cinema values(2, 'Inox', 2, 1);

/* create cinema for Saket */
insert into ticketmaster.cinema values(3, 'Carival', 2, 2);
insert into ticketmaster.cinema values(4, 'Miraj', 2, 2);

/* create cinema Hall for Vasant Kunj */
insert into ticketmaster.cinema_hall values(1, 'Ganga', 5, 1);
insert into ticketmaster.cinema_hall values(2, 'Yamuna', 5, 1);
insert into ticketmaster.cinema_hall values(3, '2D', 5, 2);
insert into ticketmaster.cinema_hall values(4, '3D', 5, 2);

/* create cinema Hall for Saket */
insert into ticketmaster.cinema_hall values(5, 'Carival-1', 5, 3);
insert into ticketmaster.cinema_hall values(6, 'Carival-2', 5, 3);
insert into ticketmaster.cinema_hall values(7, 'Miraj-1', 5, 4);
insert into ticketmaster.cinema_hall values(8, 'Miraj-2', 5, 4);

/* Create Seat for PVR Vasant Kunj Hall-1*/
insert into ticketmaster.cinema_seat values(1,1,1,1);
insert into ticketmaster.cinema_seat values(2,2,1,1);
insert into ticketmaster.cinema_seat values(3,3,1,1);
insert into ticketmaster.cinema_seat values(4,4,1,1);
insert into ticketmaster.cinema_seat values(5,5,1,1);

/* Create Seat for PVR Vasant Kunj Hall-2*/
insert into ticketmaster.cinema_seat values(6,1,1,2);
insert into ticketmaster.cinema_seat values(7,2,1,2);
insert into ticketmaster.cinema_seat values(8,3,1,2);
insert into ticketmaster.cinema_seat values(9,4,1,2);
insert into ticketmaster.cinema_seat values(10,5,1,2);

/* Create Seat for Inox Vasant Kunj Hall-1*/
insert into ticketmaster.cinema_seat values(11,1,1,3);
insert into ticketmaster.cinema_seat values(12,2,1,3);
insert into ticketmaster.cinema_seat values(13,3,1,3);
insert into ticketmaster.cinema_seat values(14,4,1,3);
insert into ticketmaster.cinema_seat values(15,5,1,3);

/* Create Seat for Inox Vasant Kunj Hall-2*/
insert into ticketmaster.cinema_seat values(16,6,1,4);
insert into ticketmaster.cinema_seat values(17,7,1,4);
insert into ticketmaster.cinema_seat values(18,8,1,4);
insert into ticketmaster.cinema_seat values(19,9,1,4);
insert into ticketmaster.cinema_seat values(20,10,1,4);

/* Create Seat for Carnival Saket Hall-1*/
insert into ticketmaster.cinema_seat values(21,1,1,5);
insert into ticketmaster.cinema_seat values(22,2,1,5);
insert into ticketmaster.cinema_seat values(23,3,1,5);
insert into ticketmaster.cinema_seat values(24,4,1,5);
insert into ticketmaster.cinema_seat values(25,5,1,5);

/* Create Seat for Carnival Saket Hall-2*/
insert into ticketmaster.cinema_seat values(26,1,1,6);
insert into ticketmaster.cinema_seat values(27,2,1,6);
insert into ticketmaster.cinema_seat values(28,3,1,6);
insert into ticketmaster.cinema_seat values(29,4,1,6);
insert into ticketmaster.cinema_seat values(30,5,1,6);

/* Create Seat for Miraj Saket Hall-1*/
insert into ticketmaster.cinema_seat values(31,1,1,7);
insert into ticketmaster.cinema_seat values(32,2,1,7);
insert into ticketmaster.cinema_seat values(33,3,1,7);
insert into ticketmaster.cinema_seat values(34,4,1,7);
insert into ticketmaster.cinema_seat values(35,5,1,7);

/* Create Seat for Miraj Saket Hall-2*/
insert into ticketmaster.cinema_seat values(36,6,1,8);
insert into ticketmaster.cinema_seat values(37,7,1,8);
insert into ticketmaster.cinema_seat values(38,8,1,8);
insert into ticketmaster.cinema_seat values(39,9,1,8);
insert into ticketmaster.cinema_seat values(40,10,1,8);


/* Create data for Movies*/
insert into ticketmaster.movie values(1,'Bell Bottom','Amongst multiple heinous airplane hijacks, India was made to face another such challenge in 1984.','3h', 'Hindi', '2021-08-31', 'India', 'Action');
insert into ticketmaster.movie values(2,'Fast and Furious 9','Dom`s peaceful life with his wife Letty and son Brian is shattered when Dom`s past catches up to him.','2h', 'English', '2021-08-12', 'USA', 'Action');

/*Create show timing for Movie-1*/
insert into ticketmaster.show values(1, '2021-08-31', '2021-08-31 11:00:00', '2021-08-31 14:00:00', 1, 1);
insert into ticketmaster.show values(2, '2021-08-31', '2021-08-31 10:00:00', '2021-08-31 12:00:00', 1, 2);
insert into ticketmaster.show values(3, '2021-08-31', '2021-08-31 11:00:00', '2021-08-31 14:00:00', 2, 1);
insert into ticketmaster.show values(4, '2021-08-31', '2021-08-31 10:00:00', '2021-08-31 12:00:00', 2, 2);

insert into ticketmaster.show values(5, '2021-08-31', '2021-08-31 11:00:00', '2021-08-31 14:00:00', 3, 1);
insert into ticketmaster.show values(6, '2021-08-31', '2021-08-31 10:00:00', '2021-08-31 12:00:00', 3, 2);
insert into ticketmaster.show values(7, '2021-08-31', '2021-08-31 11:00:00', '2021-08-31 14:00:00', 4, 1);
insert into ticketmaster.show values(8, '2021-08-31', '2021-08-31 10:00:00', '2021-08-31 12:00:00', 4, 2);

/*Create show timing for Movie-2*/
insert into ticketmaster.show values(9, '2021-08-31', '2021-08-31 11:00:00', '2021-08-31 14:00:00', 5, 1);
insert into ticketmaster.show values(10, '2021-08-31', '2021-08-31 10:00:00', '2021-08-31 12:00:00', 5, 2);
insert into ticketmaster.show values(11, '2021-08-31', '2021-08-31 11:00:00', '2021-08-31 14:00:00', 6, 1);
insert into ticketmaster.show values(12, '2021-08-31', '2021-08-31 10:00:00', '2021-08-31 12:00:00', 6, 2);

insert into ticketmaster.show values(13, '2021-08-31', '2021-08-31 11:00:00', '2021-08-31 14:00:00', 7, 1);
insert into ticketmaster.show values(14, '2021-08-31', '2021-08-31 10:00:00', '2021-08-31 12:00:00', 7, 2);
insert into ticketmaster.show values(15, '2021-08-31', '2021-08-31 11:00:00', '2021-08-31 14:00:00', 8, 1);
insert into ticketmaster.show values(16, '2021-08-31', '2021-08-31 10:00:00', '2021-08-31 12:00:00', 8, 2);
