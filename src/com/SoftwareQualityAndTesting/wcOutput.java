package com.SoftwareQualityAndTesting;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class wcOutput {
    static final int SZ = 100;

    static boolean cmp(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {//针对输出结果的排序
        if (e1.getValue().intValue() != e2.getValue().intValue()) {
            return e1.getValue() - e2.getValue() < 0;
        }

        return e1.getKey().compareTo(e2.getKey()) > 0;
    }

    public static void swap(Map.Entry<String, Integer> a[], int e1, int e2) {
        Map.Entry<String, Integer> t = a[e1];
        a[e1] = a[e2];
        a[e2] = t;
    }

    public static void sort(Map.Entry<String, Integer> a[], int low, int high) {
        int i, j;
        Map.Entry<String, Integer> tmp;
        if (low > high) {
            return;
        }
        i = low - 1;
        j = high;
        tmp = a[high];
        // 用子表的第一个记录做基准

        while (i < j) { // 从表的两端交替向中间扫描

            while ((++i) < j && !cmp(a[i], tmp)) {
            }

            while (i < (--j) && cmp(a[j], tmp)) {
            }

            if (i < j) {
                swap(a, i, j);
            }
        }
        swap(a, i, high);// 将基准数值替换回 a[i]
        sort(a, low, i - 1); // 对低子表进行递归排序
        sort(a, i + 1, high); // 对高子表进行递归排序

    }


    public static void quickSort(Map.Entry<String, Integer> a[]) {
        sort(a, 0, a.length - 1);
    }


    public void output(Map<String, Integer> result){

        Map<String,Integer> tempMap= result;  //主函数输出的map

        Map.Entry<String,Integer>[]a=new Map.Entry[tempMap.size()];
        int i =0;
        for (Map.Entry<String, Integer> entry : tempMap.entrySet()) {  //遍历Map

            a[i] = entry;
            i++;

        }

        quickSort(a);

        String outName ="result.txt";
        FileWriter writer = null;
        try {
            writer = new FileWriter(outName);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        int len = 1;
        if (a.length<=SZ) {//词表少于100个
            for (Map.Entry<String, Integer> e : a) {

                //System.out.println(e.getKey() + e.getValue());

                try {
                    writer.write(e.getKey() + " " + e.getValue());
                    if(len++ < a.length)
                        writer.write("\r\n");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        }else if (a.length>SZ){//词表大于100个
            for (i=1;i<=SZ;i++){

                try {
                    writer.write(a[i].getKey()+" "+a[i].getValue());
                    if(len++ < SZ)
                        writer.write("\r\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        try {//清空缓存
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
