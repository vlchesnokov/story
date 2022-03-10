package ru.vlchesnokov.story.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.vlchesnokov.story.model.dto.AmountPosition;
import ru.vlchesnokov.story.model.dto.CalculatedCart;
import ru.vlchesnokov.story.model.dto.Cart;
import ru.vlchesnokov.story.service.CartService;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Тестирование класса {@link OrderController}
 *
 * @author Chesnokov-VL
 */
@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private CartService cartService;

    @Test
    void testGetCalculatedCart() throws Exception {
        List<AmountPosition> positions = List.of(new AmountPosition(1, 3, 5), new AmountPosition(2, 1, 4));

        CalculatedCart calculatedCart = new CalculatedCart(positions, 9);

        when(cartService.getCalculatedCart(any(Cart.class))).thenReturn(calculatedCart);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/api/cart").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsBytes(calculatedCart));

        MvcResult result = mockMvc.perform(builder).andExpect(status().isOk()).andReturn();
        Assertions.assertNotNull(result);

        verify(cartService).getCalculatedCart(any(Cart.class));
        verifyNoMoreInteractions(cartService);
    }
}
