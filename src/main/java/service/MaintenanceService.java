package service;

import dto.RoomDto;
import dto.SlotDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MaintenanceService {
    private static MaintenanceService instance;
    private List<SlotDto> maintenanceSlotList;

    private MaintenanceService() {
        this.maintenanceSlotList = new ArrayList<>();
        maintenanceSlotList.add(new SlotDto("09:00", "09:15"));
        maintenanceSlotList.add(new SlotDto("13:15", "13:45"));
        maintenanceSlotList.add(new SlotDto("18:45", "19:00"));
    }

    public static MaintenanceService getInstance() {
        if(instance == null)
            instance = new MaintenanceService();
        return instance;
    }

    public boolean isAvailable(SlotDto slotDto) {
        SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
        boolean isSlotAvailable = true;
        try {
            Date userStartTime = parser.parse(slotDto.getStartTime());
            Date userEndTime = parser.parse(slotDto.getEndTime());
            for (SlotDto maintenanceSlot : maintenanceSlotList) {
                Date bookedSlotStartTime = parser.parse(maintenanceSlot.getStartTime());
                Date bookedSlotEndTime = parser.parse(maintenanceSlot.getEndTime());

                if (userEndTime.after(bookedSlotStartTime) && userStartTime.before(bookedSlotEndTime)) {
                    isSlotAvailable = false;
                    break;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return isSlotAvailable;
    }
}
