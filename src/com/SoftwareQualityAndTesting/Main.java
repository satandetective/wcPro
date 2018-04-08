package com.SoftwareQualityAndTesting;

import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args)
    {
	// write your code here
        wcInput wci = new wcInput();
        String inputFile = wci.judgeInput(args);
        try {
            wci.readFileContent();
        } catch (IOException e) {
            System.out.println("该文件不存在");
            return;
        }
        String fileContent = wci.getFileContent();
        wcMainProcess wcmp = new wcMainProcess(fileContent);
        Map<String, Integer> result = wcmp.countWordFrequency();
        wcOutput wco = new wcOutput();
        wco.output(result);
    }
}
