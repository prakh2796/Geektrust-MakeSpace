package service;

import dto.BookDto;
import dto.SlotDto;
import dto.RoomDto;
import exception.CustomException;
import utils.BookUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Rule1 implements Rule{
    @Override
    public String bookRoom(List<RoomDto> roomDtoList, BookDto bookDto) {
        SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
        String bookedRoom = "NO_VACANT_ROOM";
        try {
            Date userStartTime = parser.parse(bookDto.getStartTime());
            Date userEndTime = parser.parse(bookDto.getEndTime());
            for (RoomDto room : roomDtoList) {
                Boolean isSlotAvailable = true;
                List<SlotDto> slotDtoList = room.getSlotDtoList();
                if(bookDto.getCapacity() <= room.getRoomType().getPersonCapactity()) {
                    for (SlotDto slotDto : slotDtoList) {
                        Date bookedSlotStartTime = parser.parse(slotDto.getStartTime());
                        Date bookedSlotEndTime = parser.parse(slotDto.getEndTime());

                        if (userEndTime.after(bookedSlotStartTime) && userStartTime.before(bookedSlotEndTime)) {
                            isSlotAvailable = false;
                            break;
                        }
                    }
                    if (isSlotAvailable) {
                        SlotDto slotDto = new SlotDto(parser.format(userStartTime), parser.format(userEndTime));
                        slotDtoList.add(slotDto);
                        room.setSlotDtoList(slotDtoList);
                        bookedRoom = room.getRoomType().getRoomName() + " ";
                        break;
                    }
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return bookedRoom;
    }
}
