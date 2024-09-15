package com.ucb.FrankyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

    /*ConverterService converterService;
    ConverterController(ConverterService converterService) {
        this.converterService = converterService;
    }*/

    @Autowired
    ConverterService converterService;

    @GetMapping("/status")
    public String getStatus() {
        return "OK";
    }

    @PostMapping("/converter/celsius-to-fahrenheit")
    public ResponseEntity<ConverterResponseDto> CelsiusToFahrenheit(@RequestBody ConverterRequestDto converterRequestDto) {
        ConverterResponseDto response = new ConverterResponseDto
                (
                        converterService.CelsiusToFahrenheit(converterRequestDto.value()), "F"
                );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/converter/fahrenheit-to-celsius")
    public ResponseEntity<ConverterResponseDto> FahrenheitToCelsius(@RequestBody ConverterRequestDto converterRequestDto) {
        ConverterResponseDto response = new ConverterResponseDto
                (
                        converterService.FahrenheitToCelsius(converterRequestDto.value()), "C"
                );

        return ResponseEntity.ok(response);
    }

    /*@PostMapping("/converter/bolivian-to-dollar")
    public ResponseEntity<ConverterResponseDto> BolivianToDollar(@RequestBody ConverterRequestDto converterRequestDto) {
        ConverterResponseDto response = new ConverterResponseDto
                (
                        converterService.BolivianToDollar(converterRequestDto.value()), "$"
                );
        return ResponseEntity.ok(response);
    }*/
}
