package bo.anzar.hotel_manage.controller;

import bo.anzar.hotel_manage.dto.ReservationDTO;
import bo.anzar.hotel_manage.dto.RoomDTO;
import bo.anzar.hotel_manage.model.Reservation;
import bo.anzar.hotel_manage.model.Room;
import bo.anzar.hotel_manage.service.IReservationService;
import bo.anzar.hotel_manage.service.IRoomService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// ADICIONAMOS ESTA LINEA PARA QUE SALTE EL ERROR DE CORS Y HABILITE A CUALQUIER FRONT QUE QUIERA CONSUMIR LOS SERVICIOS
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final IReservationService service;
    private final IRoomService roomService;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> findAll() throws Exception {

        List<ReservationDTO> list = service.findAll().stream()
                .map(this::convertToDto).toList();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Reservation> save(@RequestBody Reservation reservation) throws Exception{
        Reservation reservationNew = service.createReservation(reservation);
        return ResponseEntity.ok().body(reservationNew);
    }
    private ReservationDTO convertToDto(Reservation entity){
        return modelMapper.map(entity, ReservationDTO.class);
    }

}
