package com.company;
import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class text {
    public static void main(String[] args){
        try{
            FileInputStream FIS = new FileInputStream("C:\\Book.txt");
            BufferedReader BR = new BufferedReader(new InputStreamReader(FIS, "Cp1251"));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out, "Cp1251"), true);
            String str;
            String aa[];
            Map<String, Integer> wordToCount = new HashMap<>();
            str = BR.readLine();
            while( str != null){
                str = str.replaceAll("[^а-яА-Яa-zA-Z\\s]", "");
                aa = str.split(" ");
                for (int i = 0; i < aa.length; i++) {
                    for (String word : aa)
                    { if (!word.equals("")) {
                        if (!wordToCount.containsKey(word.toLowerCase()))
                        { wordToCount.put(word.toLowerCase(), 0); }
                        wordToCount.put(word.toLowerCase(), wordToCount.get(word.toLowerCase()) + 1);
                    } } }
                str = BR.readLine();
            }
            List<Map.Entry<String, Integer>> a = new ArrayList<>(wordToCount.entrySet());
            Collections.sort(a, new Comparator() {
                        public int compare(Object o1, Object o2) {
                            Map.Entry e1 = (Map.Entry) o1;
                            Map.Entry e2 = (Map.Entry) o2;
                            return ((Comparable) e2.getValue()).compareTo(e1.getValue());
                        }
                    });
            for (Map.Entry<String, Integer> e : a) {
                System.out.println(e.getKey() + " " + e.getValue());
            } }
        catch(Exception e) {
            System.out.println(e); }}}
