import dto.BookDto;
import dto.RoomDto;
import dto.SlotDto;
import dto.VacancyDto;
import enums.RoomType;
import enums.RuleType;
import exception.CustomException;
import service.BookService;
import service.MaintenanceService;
import service.VacancyService;
import utils.BookUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Geektrust {

    public static void main(String[] args) {

        BookService bookService = BookService.getInstance();
        VacancyService vacancyService = VacancyService.getInstance();
        MaintenanceService maintenanceService = MaintenanceService.getInstance();

        RoomDto room1 = new RoomDto(RoomType.C_Cave);
        RoomDto room2 = new RoomDto(RoomType.D_Tower);
        RoomDto room3 = new RoomDto(RoomType.G_Mansion);

        List<RoomDto> roomDtoList = new ArrayList<>();
        roomDtoList.add(room1);
        roomDtoList.add(room2);
        roomDtoList.add(room3);

        roomDtoList.sort(Comparator.comparing(a -> a.getRoomType().getPersonCapactity()));

        String filePath = args[0];

        File file = new File(filePath);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                List<String> list = Arrays.asList(line.split(" "));

                SlotDto slotDto = new SlotDto(list.get(1), list.get(2));
                try {
                    BookUtils.validateBooking(slotDto);

                    if (maintenanceService.isAvailable(slotDto)) {
                        if (list.get(0).equals("VACANCY")) {
                            VacancyDto vacancyDto = new VacancyDto(list.get(1), list.get(2));
                            String vacantRoom = vacancyService.checkVacancy(roomDtoList, vacancyDto);
                            System.out.println(vacantRoom);
                        } else if (list.get(0).equals("BOOK")) {
                            BookDto bookDto = new BookDto(list.get(1), list.get(2), list.get(3));
                            String bookedRoom = bookService.bookRoom(roomDtoList, bookDto, RuleType.RULE1);
                            System.out.println(bookedRoom);
                        }
                    } else
                        System.out.println("NO_VACANT_ROOM");
                } catch (CustomException e) {
                    System.out.println(e.getMessage());
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
