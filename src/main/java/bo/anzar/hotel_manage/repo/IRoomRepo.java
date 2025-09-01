package bo.anzar.hotel_manage.repo;

import bo.anzar.hotel_manage.model.Room;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IRoomRepo extends IGenericRepo<Room, Integer>{

    @Query(value = "UPDATE room \n" +
            "SET  available = NOT available\n" +
            "WHERE id_room = :idRoom \n" +
            "RETURNING available; ", nativeQuery = true)
    boolean updateRoomById(@Param("idRoom") Integer idRoom);

    @Query(value = "SELECT r.*\n" +
            "FROM room r\n" +
            "WHERE r.id_room = :idRoom\n" +
            "  AND r.available = TRUE\n" +
            "  AND NOT EXISTS (\n" +
            "    SELECT 1\n" +
            "    FROM reservation x\n" +
            "    WHERE x.id_room = r.id_room\n" +
            "      AND x.check_in_date  < :toDate\n" +
            "      AND x.check_out_date > :fromDate\n" +
            "  );\n", nativeQuery = true)
    public List<Room> searchAvailable(@Param("idRoom") Integer idRoom, @Param("toDate") LocalDate toDate, @Param("fromDate") LocalDate fromtDate );
}
