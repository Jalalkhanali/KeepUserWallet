package com.teanab.jaguar.keepUserWalletData.exception;

public enum ErrorsEnum {

    general_badRequest(40001, 400, "error_general_bad_request"),

    userWallet_notFound(40401, 404, "error_user_wallet_notfound")
    ;

    // The code should be unique
    private int code;
    private int status;
    private String messageKey;

    ErrorsEnum(int code, int status, String messageKey) {
        this.code = code;
        this.status = status;
        this.messageKey = messageKey;
    }

    public int getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }

    public String getMessageKey() {
        return messageKey;
    }

}
