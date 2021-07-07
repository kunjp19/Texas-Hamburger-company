package com.example.passport.thc.dto;

import com.example.passport.thc.model.Locations;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.io.Serializable;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrdersDto implements Serializable {

    private long orderId;

    @JsonProperty(value = "itemName")
    private String itemName;

    @JsonProperty(value = "price")
    private double price;

    @JsonProperty(value = "orderStatus")
    private String orderStatus;

    @JsonProperty(value="orderStatus")
    private Locations locations;

}
