package com.teanab.jaguar.keepUserWalletData.model;

import com.teanab.jaguar.common.MarketId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "user_wallet",
    uniqueConstraints = {@UniqueConstraint(name = "uc_user_wallet_id_reference", columnNames = {"id", "refernceId"})}

)
public class UserWallet implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @CreationTimestamp
  @Column(columnDefinition = "DATETIME(3)")
  private ZonedDateTime created;

  @UpdateTimestamp
  @Column(columnDefinition = "DATETIME(3)")
  private ZonedDateTime updated;

  private int userId;

  @Column
  private int balance = 0;

  @Column
  private int amount = 0;

  @Column
  private String referenceId;

}
