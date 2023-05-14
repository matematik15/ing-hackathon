package com.ing.hackathon.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Helper {
    public static String readJsonFromFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/test/resources", filename)));
    }
}
