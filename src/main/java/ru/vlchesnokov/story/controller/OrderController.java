package ru.vlchesnokov.story.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlchesnokov.story.model.dto.CalculatedCart;
import ru.vlchesnokov.story.model.dto.Cart;
import ru.vlchesnokov.story.service.CartService;

/**
 * Контроллер для работы с заказами.
 */
@RestController
@RequestMapping("api")
public class OrderController {

    @Autowired
    private CartService cartService;

    /**
     * Возвращает расчетную корзину товаров.
     *
     * @param cart корзина товаров
     * @return расчетная корзина товаров
     */
    @PostMapping(value = "/cart")
    public CalculatedCart getCalculatedCart(@RequestBody Cart cart) {
        return cartService.getCalculatedCart(cart);
    }
}

