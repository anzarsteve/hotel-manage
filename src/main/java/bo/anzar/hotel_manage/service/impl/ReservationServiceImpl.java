package bo.anzar.hotel_manage.service.impl;

import bo.anzar.hotel_manage.exception.ModelNotFoundException;
import bo.anzar.hotel_manage.model.Reservation;
import bo.anzar.hotel_manage.repo.IGenericRepo;
import bo.anzar.hotel_manage.repo.IReservationRepo;
import bo.anzar.hotel_manage.repo.IRoomRepo;
import bo.anzar.hotel_manage.service.IReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ReservationServiceImpl extends CRUDImpl<Reservation, Integer> implements IReservationService {

    private final IReservationRepo reservationRepo;

    private final IRoomRepo roomRepo;

    @Override
    public Reservation saveTransactional(Reservation reservation) {
        reservationRepo.save(reservation);
        return reservation;
    }

    @Override
    public List<Reservation> searchAll() {
        return List.of();
    }

    @Override
    public Reservation createReservation(Reservation reservation) {

        if(roomRepo.searchAvailable(reservation.getRoom().getIdRoom(),
                reservation.getCheckInDate(),
                reservation.getCheckOutDate()).size() == 0 ){
            throw new ModelNotFoundException("La habitacion no esta disponible");
        }
        roomRepo.updateRoomById(reservation.getRoom().getIdRoom());
        return reservationRepo.save(reservation);
    }

    @Override
    protected IGenericRepo<Reservation, Integer> getRepo() {
        return reservationRepo;
    }
}
