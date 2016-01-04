package com.jing.svg;

import org.junit.Test;

import java.io.*;

public class Statistics {

    @Test
    public void count_line(){
        File file = new File("c:/workspace/full-svg-java-impl/src");
        try {
            int count = recCount(file);
            System.out.println(count);
            System.out.print((int)'a');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int recCount(File file) throws IOException {
        if(file.isFile() && file.getName().endsWith(".java")){
            int lineCount = 0;
            BufferedReader br = new BufferedReader(new FileReader(file));
            while(br.readLine() != null){
                lineCount++;
            }
            return lineCount;
        }
        else if(file.isDirectory()){
            File[] files = file.listFiles();
            int count = 0;
            for(File javaFile : files){
                count += recCount(javaFile);
            }
            return count;
        }
        return 0;
    }

}
