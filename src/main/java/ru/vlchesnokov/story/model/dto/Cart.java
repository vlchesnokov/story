package ru.vlchesnokov.story.model.dto;

import ru.vlchesnokov.story.model.enums.PaymentType;

import java.io.Serializable;
import java.util.List;

/**
 * Корзина товаров.
 *
 * @author Chesnokov-VL
 */
public class Cart implements Serializable {

    private static final long serialVersionUID = 321332131231231L;

    private List<Position> positions;

    private PaymentType paymentType;

    private int addressId;


    /**
     * Возвращает тип платежа.
     *
     * @return тип платежа
     */
    public PaymentType getPaymentType() {
        return paymentType;
    }

    /**
     * Устанавливает тип платежа.
     *
     * @param paymentType тип платежа
     */
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }


    /**
     * Возвращает идентификатор адреса пользователя.
     *
     * @return идентификатор адреса пользователя
     */
    public int getAddressId() {
        return addressId;
    }

    /**
     * Устанавливает идентификатор адреса пользователя.
     *
     * @param addressId идентификатор адреса пользователя
     */
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    /**
     * Возвращает список позиций товаров.
     *
     * @return список позиций товаров
     */
    public List<Position> getPositions() {
        return positions;
    }

    /**
     * Устанавливает список позиций товаров.
     *
     * @param positions позиции товаров
     */
    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

}
