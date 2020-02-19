# REST сервис для бронирования мест в кинотеатрах

REST сервис для бронирования мест в кинотеатрах с использованием [ACT.framework](http://actframework.org/) и [mongoDB](https://www.mongodb.com/).

### API

|№|URI|Метод|Параметры|Описание|
|---|---|---|---|---|
|1|/cinema|GET| |Получить список всех кинотеатров|
|2|/cinema/{cinemaId}|GET|`cinemaId` - ID кинотеатра|Получить кинотеатр с `ID = {cinemaId}`|
|3|/cinema|POST|`name` - наименование кинотеатра|Создать кинотеатр с именем `name`|
|4|/hall|GET| |Получить список всех залов во всех кинотеатрах|
|5|/hall/{hallId}|GET|`hallId` - ID зала|Получить зал с `ID = {hallId}`|
|6|/halls/{cinemaId}|GET|`cinemaId` - ID кинотеатра|Получить список всех залов в кинотеатре с `ID = {cinemaId}`|
|7|/hall/{cinemaId}|POST|`cinemaId` - ID кинотеатра; `rows` - количество рядов в зале; `rowSeats` - количество мест в ряду| Создать в кинотеатре с `ID = {cinemaId}` зал с количеством рядов `rows` и `rowSeats` мест в каждом ряду|
|8|/book/{hallId}|PUT|`hallId` - ID зала; список мест (пример в следующем разделе)|Забронировать метса в зале|

### Примеры запросов

1. Список кинотеатров 
   ```
   curl --request GET \
      --url http://localhost:5460/cinema
   ```
1. Кинотеатр по ID
   ```
   curl --request GET \
     --url http://localhost:5460/cinema/{cinemaId}
   ```
1. Создание кинотеатра
   ```
   curl --request POST \
     --url http://localhost:5460/cinema \
     --header 'content-type: application/json' \
     --data
     '{
        "name": "Test cinema"
      }'
   ```
1. Все залы во всех кинотеатрах
   ```
   curl --request GET \
     --url http://localhost:5460/hall \
     --header 'content-type: application/json'
   ```
1. Зал по ID
   ```
   curl --request GET \
     --url http://localhost:5460/hall/{hallId}
   ```
1. Все залы в кинотеатре с ID = `id`
   ```
   curl --request GET \
     --url http://localhost:5460/halls/{cinemaId}
   ```
1. Создание зала
   ```
   curl --request POST \
     --url http://localhost:5460/hall/{cinemaId} \
     --header 'content-type: application/json' \
     --data
     '{
        "rows": 3,
        "rowSeats": 5
      }'
   ```
1. Бронирование мест в зале
   ```
   curl --request PUT \
     --url http://localhost:5460/book/{hallId} \
     --header 'content-type: application/json' \
     --data
     '[
        {
          "rowNumber": 2,
          "seatNumber": 3
        },
        {
          "rowNumber": 1,
          "seatNumber": 1
        }
      ]'
   ```

### Deployment

Для запуска приложения требуется версия Java не более __Java 8__. Так же необходим локальный инстанс MongoDB.

Запуск приложения: `mvn clean compile -Dprofile=dev act:run`

Запуск тестовых сценариев: `mvn clean compile -Dprofile=test act:test`

### Тестирование

Тесты API оформлены в виде сценариев для ActFramework. Описание сценариев расположено в `/resources/test/scenarios`. В директории `/resources/test/fixtures` расположены данные для сценариев.