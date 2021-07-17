package dto;

import lombok.Data;

@Data
public class SlotDto {
    private String startTime;
    private String endTime;

    public SlotDto(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
