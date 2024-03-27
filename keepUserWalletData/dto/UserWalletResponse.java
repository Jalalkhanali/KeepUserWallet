package com.teanab.jaguar.keepUserWalletData.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.teanab.jaguar.common.AssetId;
import com.teanab.jaguar.common.Network;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserWalletResponse implements Serializable {

  private Long id;

  @JsonFormat(timezone = "UTC", pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  private ZonedDateTime created;
  @JsonFormat(timezone = "UTC", pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  private ZonedDateTime updated;

  private int userId;
  private int balance;

}
