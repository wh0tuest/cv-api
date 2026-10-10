package com.oleksandr.cv_api.dto;
import java.util.Map;

public record ValidationErrorResponse(String error, Map<String, String> fields) {
    
}
