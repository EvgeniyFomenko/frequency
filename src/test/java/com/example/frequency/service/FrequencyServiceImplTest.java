package com.example.frequency.service;

import com.example.frequency.dto.FrequencyDto;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class FrequencyServiceImplTest {
    private final FrequencyServiceImpl frequencyService;
    FrequencyDto frequencyDto;

    @Test
    void frequencyIsCorrect() {
        frequencyDto = frequencyService.getFrequencyChars("aaaaabcccc");
        Assertions.assertEquals("FrequencyDto(frequency={a=5, c=4, b=1})", frequencyDto.toString());
    }

    @Test
    void frequencyIsCorrectWithDigits() {
        frequencyDto = frequencyService.getFrequencyChars("aaaaabcccc11112222");
        System.out.println(frequencyDto);
        Assertions.assertEquals("FrequencyDto(frequency={a=5, 1=4, 2=4, c=4, b=1})", frequencyDto.toString());
    }

    @Test
    void frequencyIsCorrectWithSpaceInStroke() {
        frequencyDto = frequencyService.getFrequencyChars("aaaaa bcccc");
        Assertions.assertEquals("FrequencyDto(frequency={a=5, c=4, b=1})", frequencyDto.toString());
    }

    @Test
    void frequencyIsBlankStroke() {
        frequencyDto = frequencyService.getFrequencyChars("");
        Assertions.assertEquals("FrequencyDto(frequency={})", frequencyDto.toString());
    }

    @Test
    void frequencyIsSpaceStroke() {
        frequencyDto = frequencyService.getFrequencyChars("    ");
        Assertions.assertEquals("FrequencyDto(frequency={})", frequencyDto.toString());
    }
}