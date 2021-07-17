package dto;

import lombok.Data;

@Data
public class BookDto {
    private String startTime;
    private String endTime;
    private Integer capacity;

    public BookDto(String startTime, String endTime, String capacity) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.capacity = Integer.valueOf(capacity);
    }
}
