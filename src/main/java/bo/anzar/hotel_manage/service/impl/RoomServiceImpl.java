package bo.anzar.hotel_manage.service.impl;

import bo.anzar.hotel_manage.model.Reservation;
import bo.anzar.hotel_manage.model.Room;
import bo.anzar.hotel_manage.repo.IGenericRepo;
import bo.anzar.hotel_manage.repo.IRoomRepo;
import bo.anzar.hotel_manage.service.IRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class RoomServiceImpl extends CRUDImpl<Room, Integer> implements IRoomService {

    private final IRoomRepo roomRepo;


    @Override
    public Room saveTransactional(Room room, List<Reservation> reservations) {
        roomRepo.save(room);
        return room;
    }

    @Override
    public List<Room> searchAll() {
        return roomRepo.findAll();
    }

    @Override
    public Room updateRoomById(Integer idRoom) {
//        Room room = roomRepo.findById(idRoom).orElse(null);
//        if (room != null) {
//            room.setAvailable(!room.isAvailable());
//            return roomRepo.save(room);
//        }
        return null;
    }

    @Override
    protected IGenericRepo<Room, Integer> getRepo() {
        return roomRepo;
    }
}
