package com.example.frequency.controller;

import com.example.frequency.dto.FrequencyDto;
import com.example.frequency.service.FrequencyService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * RESTfull контроллер
 *
 * @author Фоменко Евгений
 */
@RestController
@RequiredArgsConstructor
public class FrequencyController {
    /**
     * Приватное поле сервиса для вызова методов обработки входящих данных
     */
    private final FrequencyService frequencyService;

    /**
     * http://localhost:8080/frequency?stroke=onetwothree
     * Эндпоинт принимает на вход строку и передаёт в сервис для подсчёта количества символов
     * @param stroke входящая строка от пользователя для будущей обработки
     * @return FrequencyDto дто с данными о количестве повторяющихся символов в строке
     * @since 1.0
     */
    @GetMapping("/frequency")
    public FrequencyDto getFrequencyCharsFrom(@RequestParam  @Length(min = 1,max = 200) String stroke) {

        return frequencyService.getFrequencyChars(stroke);
    }
}
