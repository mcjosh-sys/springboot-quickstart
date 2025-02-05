package com.mcjosh.maven.config;

import com.mcjosh.maven.services.BluePrinter;
import com.mcjosh.maven.services.ColorPrinter;
import com.mcjosh.maven.services.GreenPrinter;
import com.mcjosh.maven.services.RedPrinter;
import com.mcjosh.maven.services.impl.ColorPrinterImpl;
import com.mcjosh.maven.services.impl.SpanishBluePrinter;
import com.mcjosh.maven.services.impl.SpanishGreenPrinter;
import com.mcjosh.maven.services.impl.SpanishRedPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrinterConfig {

    @Bean
    public BluePrinter bluePrinter() {
        return new SpanishBluePrinter();
    }

    @Bean
    public RedPrinter redPrinter() {
        return new SpanishRedPrinter();
    }

    @Bean
    public GreenPrinter greenPrinter() {
        return new SpanishGreenPrinter();
    }

    @Bean
    public ColorPrinter colorPrinter(BluePrinter bluePrinter, RedPrinter redPrinter, GreenPrinter greenPrinter) {
        return new ColorPrinterImpl(redPrinter, bluePrinter, greenPrinter);
    }
}
