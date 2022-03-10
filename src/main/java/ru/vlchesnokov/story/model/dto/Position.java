package ru.vlchesnokov.story.model.dto;

import java.io.Serializable;

/**
 * Позиция с товаром.
 *
 * @author Chesnokov-VL
 */
public class Position implements Serializable {

    private static final long serialVersionUID = 531335322131231231L;

    private int productId;

    private int count;

    /**
     * Создает позицию с товаром.
     *
     * @param productId идентификатор товара
     * @param count     количество товара
     */
    public Position(int productId, int count) {
        this.productId = productId;
        this.count = count;
    }

    /**
     * Создает позицию без параметров.
     */
    public Position() {
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
