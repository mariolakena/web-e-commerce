package com.e.web.commerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientRequestDto {
    @NotBlank(message = "FirstName is required")
    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private LocalDate birthday;

    @NotBlank(message = "Email is required")
    private String email;

    @JsonProperty("payment_method")
    private String paymentMethod;

    private String country;

    private String city;

    private String street;

    @JsonProperty("postal_code")
    private Integer postalCode;
}