package com.app.enums;

public enum CurrencyEnum {
    USD("USD", "美元"),
    GBP("GBP", "英鎊"),
    EUR("EUR", "歐元");

    private final String code;
    private final String codeZh;

    CurrencyEnum(String code, String codeZh) {
        this.code = code;
        this.codeZh = codeZh;
    }

    public String getCode() {
        return code;
    }

    public String getCodeZh() {
        return codeZh;
    }

    public static String getChineseName(String code) {
        for (CurrencyEnum currency : CurrencyEnum.values()) {
            if (currency.getCode().equalsIgnoreCase(code)) {
                return currency.getCodeZh();
            }
        }
        return "";
    }
}
