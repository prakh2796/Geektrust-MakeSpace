package dto;

import lombok.Data;

@Data
public class VacancyDto {
    private String startTime;
    private String endTime;

    public VacancyDto(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
