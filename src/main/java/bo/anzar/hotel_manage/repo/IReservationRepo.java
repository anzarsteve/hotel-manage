package bo.anzar.hotel_manage.repo;

import bo.anzar.hotel_manage.model.Reservation;
import org.springframework.data.jpa.repository.Query;

public interface IReservationRepo extends IGenericRepo<Reservation, Integer> {

}
