package com.example.frequency.service;

import com.example.frequency.dto.FrequencyDto;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Service для обработки входящей строки
 *
 * @author Фоменко Евгений
 */
@Service
public class FrequencyServiceImpl implements FrequencyService {

    /**
     * Метод обрабатывает переданную строку из контроллера и возвращает FrequencyDto
     *
     * @param stroke входящая строка от пользователя для будущей обработки
     * @return FrequencyDto дто с данными о количестве повторяющихся символов в строке
     * @since 1.0
     */
    @Override
    public FrequencyDto getFrequencyChars(String stroke) {
        char[] arrayForPrepare = stroke.toLowerCase().toCharArray();
        Map<Character, Integer> unsortedMap = new HashMap<>();

        for (Character ch : arrayForPrepare) {
             if(isNotBlank(ch)){
                unsortedMap.put(ch, unsortedMap.getOrDefault(ch, 0) + 1);
            }
        }

        Map<Character, Integer> sortedMap = unsortedMap.entrySet().stream()
                .sorted((e,e1)->Integer.compare(e1.getValue(),e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));

        return FrequencyDto.builder().frequency(sortedMap).build();
    }
    /**
     * Метод принимает символ и проверяет его содержание пробела.
     *
     * @param character  принимает символ типа char
     * @return значение типа boolean
     * @since 1.0
     */
    private boolean isNotBlank(char character){
        return character != ' ';
    }
}

