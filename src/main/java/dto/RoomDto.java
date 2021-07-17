package dto;

import enums.RoomType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RoomDto {
    private RoomType roomType;
    private List<SlotDto> slotDtoList;

    public RoomDto(RoomType roomType) {
        this.roomType = roomType;
        this.slotDtoList = new ArrayList<>();
    }
}
