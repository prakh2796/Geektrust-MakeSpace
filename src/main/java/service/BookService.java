package service;

import dto.BookDto;
import dto.RoomDto;
import enums.RuleType;
import exception.CustomException;

import java.util.List;

public class BookService {
    private static BookService instance;

    private BookService() {}

    public static BookService getInstance() {
        if(instance == null)
            instance = new BookService();
        return instance;
    }


    public String bookRoom(List<RoomDto> roomDtoList, BookDto bookDto, RuleType ruleType) {
        RuleFactory ruleFactory = RuleFactory.getInstance();
        Rule rule = ruleFactory.getRule(ruleType);
        return rule.bookRoom(roomDtoList, bookDto);
    }
}
