package service;

import dto.SlotDto;
import dto.RoomDto;
import dto.VacancyDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class VacancyService {
    private static VacancyService instance;

    private VacancyService() {}

    public static VacancyService getInstance() {
        if(instance == null)
            instance = new VacancyService();
        return instance;
    }

    public String checkVacancy(List<RoomDto> roomDtoList, VacancyDto vacancyDto) {
        SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
        String availableRoom = "";
        try {
            Date userStartTime = parser.parse(vacancyDto.getStartTime());
            Date userEndTime = parser.parse(vacancyDto.getEndTime());
            for (int i=0; i < roomDtoList.size(); i++) {
                RoomDto room = roomDtoList.get(i);
                Boolean isSlotAvailable = true;
                List<SlotDto> slotDtoList = room.getSlotDtoList();
                for (SlotDto slotDto : slotDtoList) {
                    Date bookedSlotStartTime = parser.parse(slotDto.getStartTime());
                    Date bookedSlotEndTime = parser.parse(slotDto.getEndTime());

                    if (userEndTime.after(bookedSlotStartTime) && userStartTime.before(bookedSlotEndTime)) {
                        isSlotAvailable = false;
                        break;
                    }
                }
                if (isSlotAvailable) {
                    availableRoom += room.getRoomType().getRoomName() + " ";
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(availableRoom.isEmpty())
            return "NO_VACANT_ROOM";
        return availableRoom;
    }
}
