package com.app.dto;

public class CurrencyRateDto {

    private String code;
    private String codeNameZh;
    private String rate;
    private String description;

    public CurrencyRateDto(String code, String codeNameZh, String rate, String description) {
        this.code = code;
        this.codeNameZh = codeNameZh;
        this.rate = rate;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeNameZh() {
        return codeNameZh;
    }

    public void setCodeNameZh(String codeNameZh) {
        this.codeNameZh = codeNameZh;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
