package com.teanab.jaguar.keepUserWalletData.exception;

import com.teanab.jaguar.modules.base.exception.BusinessException;

public class UserWalletNotFoundException extends BusinessException {

  public UserWalletNotFoundException() {
    super(String.valueOf(ErrorsEnum.userWallet_notFound));
  }
}
