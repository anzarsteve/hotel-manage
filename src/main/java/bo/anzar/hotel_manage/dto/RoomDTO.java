package bo.anzar.hotel_manage.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoomDTO {

    private Integer idRoom;
    private String number;
    private String type;
    private Double price;
    private Boolean available;

}
