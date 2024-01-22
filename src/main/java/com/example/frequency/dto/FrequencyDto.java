package com.example.frequency.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * Возвращаяемое дто с обработанными данными
 *
 * @author Фоменко Евгений
 */
@Data
@Builder
public class FrequencyDto {
    /**
     * Это поле служит для хранения частоты встерчающихся символов
     */
    private Map<Character, Integer> frequency;

}
