package com.mcjosh.maven.services.impl;

import com.mcjosh.maven.services.BluePrinter;
import com.mcjosh.maven.services.ColorPrinter;
import com.mcjosh.maven.services.GreenPrinter;
import com.mcjosh.maven.services.RedPrinter;

public class ColorPrinterImpl implements ColorPrinter {

    private final RedPrinter redPrinter;
    private final BluePrinter bluePrinter;
    private final GreenPrinter greenPrinter;

    public ColorPrinterImpl(RedPrinter redPrinter, BluePrinter bluePrinter, GreenPrinter greenPrinter) {
        this.redPrinter = redPrinter;
        this.bluePrinter = bluePrinter;
        this.greenPrinter = greenPrinter;
    }

    @Override
    public String print() {
        return String.join(", ", redPrinter.print(), bluePrinter.print(), greenPrinter.print());
    }
}
