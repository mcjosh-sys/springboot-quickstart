package com.mcjosh.maven.services.impl;

import com.mcjosh.maven.services.GreenPrinter;

public class EnglishGreenPrinter implements GreenPrinter {
    @Override
    public String print() {
        return "green";
    }
}
