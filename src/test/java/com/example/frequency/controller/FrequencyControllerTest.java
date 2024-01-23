package com.example.frequency.controller;

import com.example.frequency.dto.FrequencyDto;
import com.example.frequency.exception.ErrorController;
import com.example.frequency.service.FrequencyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class FrequencyControllerTest {
    @Mock
    FrequencyService frequencyService;
    @InjectMocks
    FrequencyController frequencyController;
    private final ObjectMapper mapper = new ObjectMapper();
    private MockMvc mvc;
    FrequencyDto frequencyDto;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders
                .standaloneSetup(frequencyController)
                .setControllerAdvice(new ErrorController())
                .build();
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 3);
        map.put('b', 2);
        map.put('c', 1);
        frequencyDto = FrequencyDto.builder().frequency(map).build();
    }

    @Test
    void getFrequencyCharsFrom() throws Exception {
        when(frequencyService.getFrequencyChars(any()))
                .thenReturn(frequencyDto);

        mvc.perform(get("/frequency?stroke=aaabbb")
                        .content(mapper.writeValueAsString(frequencyDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpectAll(jsonPath("$.frequency").isMap());
    }

    @Test
    @Disabled
    void getFrequencyCharsFrom400and0Len() throws Exception {
        mvc.perform(get("/frequency?stroke=")
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Disabled
    void getFrequencyCharsFrom400and201Len() throws Exception {
        mvc.perform(get("/frequency?stroke=fыфвафываыфвасчмвапфывафываыыфвафывафываыфваыфваыфваыфваыфвафывафывафываыфвафывафывафываыфваыфваывафываывфафывфываывфаыфвафывафывафывафывафывафывафывафывафывфываывафыффывафывыфвафывафываыфвафывафывафыв")
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}