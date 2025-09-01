INSERT INTO public.room (number, type, price, available) VALUES ('101', 'Single', 100.0, false);
INSERT INTO public.room (number, type, price, available) VALUES ('102', 'Double', 150.0, true);
INSERT INTO public.room (number, type, price, available) VALUES ('103', 'Suite', 250.0, true);
INSERT INTO public.room (number, type, price, available) VALUES ('104', 'Single', 100.0, false);
INSERT INTO public.room (number, type, price, available) VALUES ('105', 'Double', 150.0, true);
INSERT INTO public.room (number, type, price, available) VALUES ('106', 'Suite', 250.0, false);
INSERT INTO public.room (number, type, price, available) VALUES ('107', 'Single', 100.0, true);
INSERT INTO public.room (number, type, price, available) VALUES ('108', 'Double', 150.0, false);
INSERT INTO public.room (number, type, price, available) VALUES ('109', 'Suite', 250.0, true);
INSERT INTO public.room (number, type, price, available) VALUES ('110', 'Single', 100.0, true);

INSERT INTO public.reservation (customer_name, check_in_date, check_out_date, id_room) VALUES ('JUAN PEREZ', '2025-08-28', '2025-08-29', 1);