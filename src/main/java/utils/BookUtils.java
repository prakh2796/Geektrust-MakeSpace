package utils;

import dto.SlotDto;
import exception.CustomException;

import java.util.Arrays;
import java.util.List;

public class BookUtils {
    public static void validateBooking(SlotDto slotDto) throws CustomException {

        List<String> time = Arrays.asList(slotDto.getStartTime().split(":"));
        Integer startHour = Integer.valueOf(time.get(0));
        Integer startMin = Integer.valueOf(time.get(1));

        time = Arrays.asList(slotDto.getEndTime().split(":"));
        Integer endHour = Integer.valueOf(time.get(0));
        Integer endMin = Integer.valueOf(time.get(1));

        if(startHour < 0 && startHour > 23)
            throw new CustomException("INCORRECT_INPUT");
        if(endHour < 0 && endHour > 23)
            throw new CustomException("INCORRECT_INPUT");
        if(startMin < 0 && startMin > 59)
            throw new CustomException("INCORRECT_INPUT");
        if(endMin < 0 && endMin > 59)
            throw new CustomException("INCORRECT_INPUT");

        if(startHour > endHour)
            throw new CustomException("INCORRECT_INPUT");
        if(startHour == endHour && startMin >= endMin)
            throw new CustomException("INCORRECT_INPUT");

        if(startMin % 15 != 0 || endMin % 15 != 0)
            throw new CustomException("INCORRECT_INPUT");


    }
}
