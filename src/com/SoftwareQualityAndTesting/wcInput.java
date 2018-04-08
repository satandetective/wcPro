package com.SoftwareQualityAndTesting;

import javax.swing.*;
import java.io.*;
import java.util.Vector;

public class wcInput {
    private String inputFile;
    private String fileContent;
    public String judgeInput(String[] args)
    {
        String inputFile="";
        if(args.length==0)//没有文件
        {
            System.out.println("未输入文件名，请重新输入文件名");
            inputFile="no file";
        }
        else if(args.length>1)
        {
            System.out.println("多个文件无法同时处理，请输入一个文件名");
            inputFile="so many files";
        }
        else if(!args[0].endsWith(".txt"))
        {
            if(args[0].equals("-x")){
                JFileChooser jfc=new JFileChooser(".");
                int returnVal = jfc.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION)
                {
                    //获得打开的文件
                    inputFile = jfc.getSelectedFile().getAbsolutePath();
                }
            }
            else
            {
                System.out.println("输入的不是txt格式文件，请重新输入一个txt文件");
                inputFile="not correct file";
            }
        }
        else
        {
            inputFile=args[0];
        }
        this.inputFile = inputFile;
        return inputFile;
    }

    public void readFileContent() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(inputFile));
        BufferedReader br = new BufferedReader(isr);
        char s;
        StringBuilder sb = new StringBuilder();
        while((s = (char)br.read()) != (char)-1)
            sb.append(s);
        isr.close();
        br.close();
        fileContent = sb.toString().toLowerCase();
    }

    public String getFileContent() {
        return fileContent;
    }
}
