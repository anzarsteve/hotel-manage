package bo.anzar.hotel_manage.service;

import bo.anzar.hotel_manage.model.Reservation;
import bo.anzar.hotel_manage.model.Room;

import java.util.List;

public interface IRoomService extends ICRUD<Room, Integer>{
    Room saveTransactional(Room room, List<Reservation> reservations);

    Room findById(Integer id) throws Exception;
    List<Room> searchAll();
    void updateRoomById(Integer idRoom);
}
