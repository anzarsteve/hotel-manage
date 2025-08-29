package bo.anzar.hotel_manage.controller;

import bo.anzar.hotel_manage.model.Reservation;
import bo.anzar.hotel_manage.service.IReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final IReservationService service;

    @GetMapping
    public ResponseEntity<List<Reservation>> findAll() throws Exception {
        return ResponseEntity.ok().body(service.findAll());
    }


}
