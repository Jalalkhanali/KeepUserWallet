package com.teanab.jaguar.keepUserWalletData.repository;

import com.teanab.jaguar.keepUserWalletData.model.UserWallet;
import com.teanab.jaguar.modules.otc.model.OtcAssetConfig;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserWalletRepository extends JpaRepository<UserWallet, Long> {

  @Query("SELECT w FROM UserWallet w WHERE w.userId = :userId")
  Optional<UserWallet> findUserWallet(
      @Param("userId") int userId
  );
  @Modifying
  @Query("UPDATE UserWallet w SET w.balance = w.balance + :amount WHERE w.id = :id")
  void addAmountToBalance(
      @Param("id") Long id,
      @Param("amount") int amount
  );

  @Query("SELECT w FROM UserWallet w WHERE w.created > :created")
  List<UserWallet> getAllByCreated(@Param("created") ZonedDateTime yesterdayZonedDateTime);
}
