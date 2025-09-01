package bo.anzar.hotel_manage.dto;

import bo.anzar.hotel_manage.model.Room;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class ReservationDTO {
    private Integer idReservation;
    private String customerName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private RoomDTO room;
}
