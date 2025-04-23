package com.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class CoindeskDto {

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime updatedTime;

    private List<CurrencyRateDto> bpi;

    public CoindeskDto(LocalDateTime updatedTime, List<CurrencyRateDto> bpi) {
        this.updatedTime = updatedTime;
        this.bpi = bpi;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public List<CurrencyRateDto> getBpi() {
        return bpi;
    }

    public void setBpi(List<CurrencyRateDto> bpi) {
        this.bpi = bpi;
    }
}
