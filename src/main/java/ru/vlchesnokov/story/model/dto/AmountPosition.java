package ru.vlchesnokov.story.model.dto;

import java.io.Serializable;

/**
 * Позиция с суммой товара.
 *
 * @author Chesnokov-VL
 */
public class AmountPosition implements Serializable {

    private static final long serialVersionUID = 1141335322131231231L;

    private int productId;

    private int count;

    private float amount;


    /**
     * Создает позицию с суммой товара.
     *
     * @param productId идентификатор товара
     * @param count     количество товара
     * @param amount    сумма по позиции
     */
    public AmountPosition(int productId, int count, float amount) {
        this.productId = productId;
        this.count = count;
        this.amount = amount;
    }


    /**
     * Возвращает сумму по позиции.
     *
     * @return сумма по позиции
     */
    public float getAmount() {
        return amount;
    }

    /**
     * Устанавливает сумму по позиции.
     *
     * @param amount сумма по позиции
     */
    public void setAmount(float amount) {
        this.amount = amount;
    }


    /**
     * Возвращает идентификатор товара.
     *
     * @return идентификатор товара
     */
    public int getProductId() {
        return productId;
    }


    /**
     * Устанавливает идентификатор товара.
     *
     * @param productId идентификатор товара
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }


    /**
     * Возвращает количество товара.
     *
     * @return количество товара
     */
    public int getCount() {
        return count;
    }

    /**
     * Устанавливает количество товара.
     *
     * @param count количество товара
     */
    public void setCount(int count) {
        this.count = count;
    }
}
