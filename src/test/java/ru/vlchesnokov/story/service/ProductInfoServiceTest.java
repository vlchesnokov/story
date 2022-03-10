package ru.vlchesnokov.story.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import ru.vlchesnokov.story.model.dto.CalculatedCart;
import ru.vlchesnokov.story.model.dto.Cart;
import ru.vlchesnokov.story.model.dto.Position;
import ru.vlchesnokov.story.model.dto.ProductPrice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;
import static ru.vlchesnokov.story.model.enums.PaymentType.BANK_CARD;

/**
 * Тестирование класса {@link ProductInfoService}
 *
 * @author Chesnokov-VL
 */
@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
public class ProductInfoServiceTest {

    @InjectMocks
    CartService cartService;

    @Mock
    ProductInfoService productInfoService;

    @Test
    void testGetCalculatedCart() {
        Cart stubCart = new Cart();
        List<Position> positions = List.of(new Position(1, 3), new Position(2, 5));
        stubCart.setPositions(positions);
        stubCart.setAddressId(234);
        stubCart.setPaymentType(BANK_CARD);

        ProductPrice productPrice = new ProductPrice();
        Map<Integer, Float> price = new HashMap<>();
        price.put(1, 300f);
        price.put(2, 500f);
        productPrice.setPrice(price);

        when(productInfoService.getProductPrices(anyList())).thenReturn(productPrice);

        CalculatedCart result = cartService.getCalculatedCart(stubCart);

        assertNotNull(result);
        assertEquals(2, result.getAmountPositions().size());
        assertEquals(3400.00, result.getTotalAmount());

        verify(productInfoService).getProductPrices(anyList());
        verifyNoMoreInteractions(productInfoService);
    }
}
