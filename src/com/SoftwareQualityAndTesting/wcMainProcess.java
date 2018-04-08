package com.SoftwareQualityAndTesting;

import java.util.HashMap;
import java.util.Map;

public class wcMainProcess
{
    private String fileContent;
    private Map<String,Integer> result;
    private int index;
    StringBuilder curWordBuilder;
    public wcMainProcess(String input)
    {
        fileContent = input;
        index = 0;
        result = new HashMap<String, Integer>();
        curWordBuilder = new StringBuilder();
    }

    public Map<String,Integer> countWordFrequency()
    {
        curWordBuilder = new StringBuilder();
        for(;index < fileContent.length(); index++)
        {
            char temp = fileContent.charAt(index);
            if(temp >= 'a' && temp <= 'z')
            {
                String word = Word().toString();
                if(result.containsKey(word))
                    result.put(word,result.get(word)+1);
                else
                    result.put(word,1);
                curWordBuilder = new StringBuilder();
            }
        }
        return result;
    }

    public StringBuilder Word()
    {
        if(index>=fileContent.length())
            return new StringBuilder();
        char temp = fileContent.charAt(index);
        while(temp >= 'a' && temp <= 'z')
        {
            curWordBuilder.append(temp);
            if(index == fileContent.length()-1)
                return curWordBuilder;
            temp = fileContent.charAt(++index);
        }
        if(temp == '-')
        {
            if(index + 1 < fileContent.length())
            {
                char nextChar = fileContent.charAt(index + 1);
                if((nextChar >= 'a' && nextChar <= 'z'))
                {
                   curWordBuilder.append('-');
                   index++;
                   Word();
                }
            }
        }
        return curWordBuilder;
    }

}
