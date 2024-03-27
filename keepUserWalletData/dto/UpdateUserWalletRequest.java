package com.teanab.jaguar.keepUserWalletData.dto;

import com.teanab.jaguar.common.AssetId;
import com.teanab.jaguar.common.Network;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserWalletRequest implements Serializable {


  @NotNull
  private int amount;
  @NotNull
  private String referenceId;

}
