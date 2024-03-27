package com.teanab.jaguar.keepUserWalletData.scheduler;

import com.teanab.jaguar.keepUserWalletData.model.UserWallet;
import com.teanab.jaguar.keepUserWalletData.service.UserWalletService;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserTransactionalMonitorScheduler {

  private final UserWalletService userWalletService;

  @SchedulerLock(
      name = "UserWalletMonitorScheduler",
      lockAtLeastFor = "20m",
      lockAtMostFor = "30m"
  )
  @Scheduled(cron = "${0 0 1 * * *}")
  public void run() {
    ZonedDateTime yesterdayZonedDateTime = ZonedDateTime.now(ZoneId.systemDefault()).minusDays(1L);

    List<UserWallet> userWallets = userWalletService.getUserWallets(yesterdayZonedDateTime);

    printTransactional(userWallets);
  }


  private void printTransactional(List<UserWallet> userWallets) {
    if (userWallets == null || userWallets.isEmpty()) {
      return;
    }

    for (UserWallet userWallet : userWallets) {
      log.info(userWallet.toString());
    }

  }

}
