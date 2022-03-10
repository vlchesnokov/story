package ru.vlchesnokov.story.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.vlchesnokov.story.model.dto.ProductPrice;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

/**
 * Сервис для предоставления информации о товаре.
 */
@Service
public class ProductInfoService {
    private static final String URL_PRICE_SOURCE = "https://price-source.ru";

    /**
     * Возвращает цены товаров.
     *
     * @param ids идентификаторы запрашиваемых товаров
     * @return цены товаров
     */
    // Вызывается внешний микросервис для предоставления информации по ценам продуктов, заданных идентификаторами
    public ProductPrice getProductPrices(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new IllegalArgumentException("Не заданы идентификаторы товаров");
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<List<Integer>> requestBody = new HttpEntity<>(ids);

        ResponseEntity<ProductPrice> result = restTemplate.postForEntity(URL_PRICE_SOURCE, requestBody, ProductPrice.class);

        if (result.getStatusCode() == OK) {
            return result.getBody();
        } else {
            throw new IllegalStateException(result.getStatusCode().getReasonPhrase());
        }
    }

}
