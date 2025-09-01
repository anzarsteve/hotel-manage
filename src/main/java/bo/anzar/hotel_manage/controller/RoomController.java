package bo.anzar.hotel_manage.controller;

import bo.anzar.hotel_manage.dto.RoomDTO;
import bo.anzar.hotel_manage.model.Room;
import bo.anzar.hotel_manage.service.IRoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

// ADICIONAMOS ESTA LINEA PARA QUE SALTE EL ERROR DE CORS Y HABILITE A CUALQUIER FRONT QUE QUIERA CONSUMIR LOS SERVICIOS
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final IRoomService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;


    @GetMapping
    public ResponseEntity<List<RoomDTO>> findAll() throws Exception{

        List<RoomDTO> list = service.findAll().stream()
                .map(this::convertToDto).toList();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> findById(@PathVariable("id") Integer id) throws Exception{
        RoomDTO obj = convertToDto(service.findById(id));
        return ResponseEntity.ok().body(obj);
    }


    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Room room) throws Exception{
        Room obj = service.save(room);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdRoom()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<RoomDTO> update(@Valid @RequestBody Room room) throws Exception{
        RoomDTO obj = convertToDto(service.update(room, room.getIdRoom()));

        return ResponseEntity.ok().body(obj);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRoomById(@PathVariable Integer id){
        service.updateRoomById(id);
        return ResponseEntity.ok().build();
    }

    private RoomDTO convertToDto(Room entity){
        return modelMapper.map(entity, RoomDTO.class);
    }
}
