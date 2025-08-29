package bo.anzar.hotel_manage.service.impl;

import bo.anzar.hotel_manage.model.Reservation;
import bo.anzar.hotel_manage.repo.IGenericRepo;
import bo.anzar.hotel_manage.repo.IReservationRepo;
import bo.anzar.hotel_manage.service.IReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ReservationServiceImpl extends CRUDImpl<Reservation, Integer> implements IReservationService {

    private final IReservationRepo reservationRepo;

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
    protected IGenericRepo<Reservation, Integer> getRepo() {
        return reservationRepo;
    }
}
