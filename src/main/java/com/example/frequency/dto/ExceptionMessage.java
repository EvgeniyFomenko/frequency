package com.example.frequency.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionMessage {
    String message;
    String error;
}
