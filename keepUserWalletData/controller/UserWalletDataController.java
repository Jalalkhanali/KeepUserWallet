package com.teanab.jaguar.keepUserWalletData.controller;

import com.teanab.jaguar.keepUserWalletData.dto.UpdateUserWalletRequest;
import com.teanab.jaguar.keepUserWalletData.service.UserWalletService;
import com.teanab.jaguar.modules.base.dto.GenericResponse;
import com.teanab.jaguar.keepUserWalletData.dto.UserWalletResponse;
import com.teanab.jaguar.keepUserWalletData.model.UserWallet;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/user-wallets")
@PreAuthorize("hasAnyAuthority('SYSADMIN')")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserWalletDataController {

  private final UserWalletService userWalletService;

  @GetMapping("/{id}")
  public GenericResponse<UserWalletResponse> getUserBalance(
      @PathVariable("id") int userId
  ) {
    UserWallet userWallet = userWalletService.getUserBalance(userId);

    return GenericResponse.success(mapToResponse(userWallet));
  }


  @PatchMapping("/{id}")
  public GenericResponse<UserWalletResponse> update(
      @PathVariable("id") int userId,
      @Valid @RequestBody UpdateUserWalletRequest request
  ) {
    UserWallet userWallet = userWalletService.partialUpdate(userId, request);

    return GenericResponse.success(mapToResponse(userWallet));
  }

  private UserWalletResponse mapToResponse(UserWallet userWallet) {
    return UserWalletResponse.builder()
        .id(userWallet.getId())
        .created(userWallet.getCreated())
        .updated(userWallet.getUpdated())
        .userId(userWallet.getUserId())
        .balance(userWallet.getBalance())
        .build();
  }

}
