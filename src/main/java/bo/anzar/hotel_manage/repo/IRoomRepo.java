package bo.anzar.hotel_manage.repo;

import bo.anzar.hotel_manage.model.Room;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IRoomRepo extends IGenericRepo<Room, Integer>{

    @Query(value = "UPDATE room \n" +
            "SET  available = NOT available\n" +
            "WHERE id_room = :idRoom \n" +
            "RETURNING available; ", nativeQuery = true)
    boolean updateRoomById(@Param("idRoom") Integer idRoom);
}
