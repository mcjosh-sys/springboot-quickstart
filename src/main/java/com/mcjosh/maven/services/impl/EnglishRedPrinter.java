package com.mcjosh.maven.services.impl;

import com.mcjosh.maven.services.RedPrinter;

public class EnglishRedPrinter implements RedPrinter {
    @Override
    public String print() {
        return "red";
    }
}
