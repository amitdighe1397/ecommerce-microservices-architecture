package com.example.customer_service.handaler;

import java.util.Map;

public record ErrorResponse(Map<String, String> errors) {
}
