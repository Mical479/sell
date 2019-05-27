package com.imooc.sell.dto;

import lombok.Data;

@Data
public class CartDTO {
    /**商品id.*/
    private String productId;

    /**数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
