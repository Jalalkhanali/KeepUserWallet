package com.teanab.jaguar.keepUserWalletData.service;

import com.teanab.jaguar.keepUserWalletData.dto.UpdateUserWalletRequest;
import com.teanab.jaguar.keepUserWalletData.exception.UserWalletNotFoundException;
import com.teanab.jaguar.keepUserWalletData.repository.UserWalletRepository;
import com.teanab.jaguar.keepUserWalletData.model.UserWallet;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserWalletService {

  private final UserWalletRepository userWalletRepository;

  public UserWallet getUserBalance(int userId) {
    return userWalletRepository.findUserWallet(userId)
        .orElseThrow(UserWalletNotFoundException::new);
  }

  public List<UserWallet> getUserWallets(ZonedDateTime yesterdayZonedDateTime) {
    return userWalletRepository.getAllByCreated(yesterdayZonedDateTime);
  }

  public UserWallet partialUpdate(int UserId, UpdateUserWalletRequest request) {
    UserWallet userWallet = userWalletRepository.findUserWallet(UserId)
        .orElseThrow(UserWalletNotFoundException::new);

    if (request.getAmount() < 0) {
      throw new IllegalArgumentException();
    }

    userWallet.setAmount(request.getAmount());

    userWallet.setReferenceId(request.getReferenceId());

    userWalletRepository.addAmountToBalance(userWallet.getId(), request.getAmount());

    return userWalletRepository.save(userWallet);
  }

}
