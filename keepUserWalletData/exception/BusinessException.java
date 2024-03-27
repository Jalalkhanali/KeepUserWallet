package com.teanab.jaguar.keepUserWalletData.exception;

import com.teanab.jaguar.modules.base.exception.ErrorsEnum;
import java.util.List;

public abstract class BusinessException extends RuntimeException {

    protected com.teanab.jaguar.modules.base.exception.ErrorsEnum errorsEnum;
    protected List<Object> params;


    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(com.teanab.jaguar.modules.base.exception.ErrorsEnum errorsEnum) {
        super(errorsEnum.name());
        this.errorsEnum = errorsEnum;
    }

    public BusinessException(com.teanab.jaguar.modules.base.exception.ErrorsEnum errorsEnum, String message) {
        super(message);
        this.errorsEnum = errorsEnum;
    }

    public BusinessException(com.teanab.jaguar.modules.base.exception.ErrorsEnum errorsEnum, String message, List<Object> params) {
        super(message);
        this.errorsEnum = errorsEnum;
        this.params = params;
    }

    public ErrorsEnum getErrorsEnum() {
        return errorsEnum;
    }

    public List<Object> getParams() {
        return params;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
