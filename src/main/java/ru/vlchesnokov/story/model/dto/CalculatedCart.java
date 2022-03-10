package ru.vlchesnokov.story.model.dto;


import java.io.Serializable;
import java.util.List;

/**
 * Расчитанная корзина товаров.
 *
 * @author Chesnokov-VL
 */
public class CalculatedCart implements Serializable {

    private static final long serialVersionUID = 3213321314234231L;

    private List<AmountPosition> amountPositions;

    private float totalAmount;

    /**
     * Создает расчитанную корзину товаров.
     *
     * @param amountPositions список позиций с суммой цены товара
     * @param totalAmount     общая сумма
     */
    public CalculatedCart(List<AmountPosition> amountPositions, float totalAmount) {
        this.amountPositions = amountPositions;
        this.totalAmount = totalAmount;
    }

    /**
     * Возвращает список позиций с суммой цены товара.
     *
     * @return список позиций с суммой цены товара
     */
    public List<AmountPosition> getAmountPositions() {
        return amountPositions;
    }

    /**
     * Устанавливает список позиций с суммой цены товара
     *
     * @param amountPositions список позиций с суммой цены товара
     */
    public void setAmountPositions(List<AmountPosition> amountPositions) {
        this.amountPositions = amountPositions;
    }

    /**
     * Возвращает общую сумму.
     *
     * @return общую сумму
     */
    public float getTotalAmount() {
        return totalAmount;
    }

    /**
     * Устанавлтвает общую сумму.
     *
     * @param totalAmount общая сумма
     */
    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

}
