package com.uni.demo;

import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;

import java.io.*;

public class FileChangeType {

    public static void main(String[] args) {


        File inputWord = new File("/Users/songfei/Downloads/（定）西安市科学技术局创新一码通系统.doc");
        File outputFile = new File("/Users/songfei/Downloads/（定）西安市科学技术局创新一码通系统.pdf");
        try  {
            InputStream docxInputStream = new FileInputStream(inputWord);
            OutputStream outputStream = new FileOutputStream(outputFile);
            IConverter converter = LocalConverter.builder().build();
            converter.convert(docxInputStream).as(DocumentType.DOCX).to(outputStream).as(DocumentType.PDF).execute();
            outputStream.close();
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
