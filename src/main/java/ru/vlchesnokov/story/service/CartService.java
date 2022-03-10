package ru.vlchesnokov.story.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlchesnokov.story.model.dto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Сервис по работе c корзиной товаров.
 *
 * @author Chesnokov-vl
 */
@Service
public class CartService {

    @Autowired
    private ProductInfoService productInfoService;

    private final Map<Integer, Float> cache = new ConcurrentHashMap<>();

    /**
     * Возвращает расчитанную корзину товаров.
     *
     * @param cart корзина товаров
     * @return расчитанная корзина товаров
     */
    public CalculatedCart getCalculatedCart(Cart cart) {
        List<Integer> idsWithoutPrice = cart.getPositions().stream().map(Position::getProductId).filter(id -> !cache.containsKey(id)).collect(Collectors.toList());

        if (!idsWithoutPrice.isEmpty()) {
            fillCache(idsWithoutPrice);
        }

        float totalAmount = 0;
        List<AmountPosition> amountPositions = new ArrayList<>();

        for (Position position : cart.getPositions()) {
            float amount = position.getCount() * cache.get(position.getProductId());
            totalAmount += amount;
            amountPositions.add(new AmountPosition(position.getProductId(), position.getCount(), amount));
        }

        return new CalculatedCart(amountPositions, totalAmount);
    }


    private void fillCache(List<Integer> idsWithoutPrice) {
        ProductPrice price = productInfoService.getProductPrices(idsWithoutPrice);
        cache.putAll(price.getPrice());
    }
}
