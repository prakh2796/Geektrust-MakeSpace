package service;

import dto.BookDto;
import dto.RoomDto;

import java.util.List;

public interface Rule {
    public String bookRoom(List<RoomDto> roomDtoList, BookDto bookDto);
}
