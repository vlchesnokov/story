# story

Что в перспективе я бы добавил:

1. Кэш реализован примитивно, так как не обновляется цена товара. Для улучшения ситуации необходимо прикрутить Ehcache и
   выставить настройки времени хранения цен (TTL или TTI);

2. Логирование;

3. Lombok для лаконичности кода;