# Тестовое задание.

Спроектировать(продумать формат и ограничения входящих/исходящих параметров) и реализовать REST API,
вычисляющее частоту встречи символов по заданной строке.
Результат должен быть отсортирован по убыванию количества вхождений символа в заданную строку.

Пример входной строки: “aaaaabcccc”
Пример выходного результата: “a”: 5, “c”: 4, “b”: 1

## Стек

* java 11, Spring Boot

## Сборка проекта

* mvn clean package
* docker build -t frequency .
* docker run --name frequency -p 8080:8080 frequency

## Эндпоинты

http://localhost:8080/frequency?stroke=