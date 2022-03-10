package ru.vlchesnokov.story.model.dto;

import java.io.Serializable;
import java.util.Map;

/**
 * Цены товаров.
 */
public class ProductPrice implements Serializable {

    private static final long serialVersionUID = 2425335322131231231L;

    Map<Integer, Float> price;

    /**
     * Возвращает цены товаров.
     *
     * @return цены товаров
     */
    public Map<Integer, Float> getPrice() {
        return price;
    }

    /**
     * Устанавливает цены товаров.
     *
     * @param price цены товаров
     */
    public void setPrice(Map<Integer, Float> price) {
        this.price = price;
    }
}
