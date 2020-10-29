package com.example.demospringcucumber.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author aroussi
 * @version %I% %G%
 */
@Builder
@NoArgsConstructor
@Getter
@ToString
public class GreetingResponse {
    private String message;
    private String label;

    public GreetingResponse(String message, String label) {
        this.message = message;
        this.label = label;
    }
}
