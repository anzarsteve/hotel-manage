package bo.anzar.hotel_manage.controller;

import bo.anzar.hotel_manage.model.Room;
import bo.anzar.hotel_manage.service.IRoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final IRoomService service;

//    @Qualifier("consultMapper")
//    private final ModelMapper modelMapper;
//

    @GetMapping
    public ResponseEntity<List<Room>> findAll() throws Exception{
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Room room) throws Exception{
        Room obj = service.save(room);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdRoom()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Room> update(@Valid @RequestBody Room room) throws Exception{
        Room obj = service.update(room, room.getIdRoom());
        return ResponseEntity.ok().body(obj);
    }
}
