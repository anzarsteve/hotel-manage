package bo.anzar.hotel_manage.service;

import bo.anzar.hotel_manage.model.Reservation;

import java.util.List;

public interface IReservationService extends ICRUD<Reservation, Integer> {

    Reservation saveTransactional(Reservation reservation);
    List<Reservation> searchAll();

    Reservation createReservation(Reservation reservation);
}
