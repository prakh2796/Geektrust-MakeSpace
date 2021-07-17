import dto.BookDto;
import dto.RoomDto;
import dto.SlotDto;
import enums.RoomType;
import enums.RuleType;
import org.junit.jupiter.api.Test;
import service.BookService;
import service.MaintenanceService;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookTest {
    @Test
    public void maintenanceSlot() {
        MaintenanceService maintenanceService = MaintenanceService.getInstance();
        SlotDto slotDto = new SlotDto("18:00", "19:00");
        assertEquals(false, maintenanceService.isAvailable(slotDto));
    }

    @Test
    public void roomCapacityCheck() {
        BookService bookService = BookService.getInstance();
        List<RoomDto> roomDtoList = createRooms();
        BookDto bookDto = new BookDto("11:30", "13:00", "35");
        String bookedRoom = bookService.bookRoom(roomDtoList, bookDto, RuleType.RULE1);
        assertEquals("NO_VACANT_ROOM", bookedRoom);
    }

    private List<RoomDto> createRooms() {
        RoomDto room1 = new RoomDto(RoomType.C_Cave);
        RoomDto room2 = new RoomDto(RoomType.D_Tower);
        RoomDto room3 = new RoomDto(RoomType.G_Mansion);

        List<RoomDto> roomDtoList = new ArrayList<>();
        roomDtoList.add(room1);
        roomDtoList.add(room2);
        roomDtoList.add(room3);

        roomDtoList.sort(Comparator.comparing(a -> a.getRoomType().getPersonCapactity()));
        return roomDtoList;
    }
}
