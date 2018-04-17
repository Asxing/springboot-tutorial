package com.holddie.springboot.elasticsearch.tutorial.common.utils;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileUtils {

    private static Logger log = Logger.getLogger(FileUtils.class);

    public static String readFileAsString(String fileName) {
        String path = FileUtils.class.getClassLoader().getResource(fileName).getPath();
        File file = new File(path);
        try {
            String fileReaded = Files.asCharSource(file, Charsets.UTF_8).read();
            return fileReaded;
        } catch (IOException e) {
            log.warn("read file " + fileName + "error.");
            return null;
        }
    }

    public static Properties loadProps(String propsFile) {
        Properties props = new Properties();
        InputStream inp = Thread.currentThread().getContextClassLoader().getResourceAsStream(propsFile);

        if (inp == null) {
            throw new RuntimeException("time sequnce properties not found " + propsFile);
        }
        try {
            props.load(inp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props;
    }

}
