package bo.anzar.hotel_manage.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idReservation;

    private String customerName;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_room", nullable = false, foreignKey = @ForeignKey(name = "FK_RESERVATION_ROOM"))
    private Room room;
}
