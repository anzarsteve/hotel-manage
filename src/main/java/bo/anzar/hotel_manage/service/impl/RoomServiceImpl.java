package bo.anzar.hotel_manage.service.impl;

import bo.anzar.hotel_manage.exception.ModelNotFoundException;
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
    public void updateRoomById(Integer idRoom) {
        roomRepo.updateRoomById(idRoom);
        //return roomRepo.save(room);
    }

    @Override
    protected IGenericRepo<Room, Integer> getRepo() {
        return roomRepo;
    }
}
