package com.example.videocaching;

import java.io.File;
import java.io.IOException;

/**
 * Created by cflor on 28.02.2016.
 */
public class VineCacheFileUtils {

    public static void cleanDirectory(File file){
        if (!file.exists()) {
            return;
        }
        File[] contentFiles = file.listFiles();
        if (contentFiles != null) {
            for (File contentFile : contentFiles) {
                try {
                    delete(contentFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void delete(File file) throws IOException {
        if (file.isFile() && file.exists()) {
            deleteOrThrow(file);
        } else {
            cleanDirectory(file);
            deleteOrThrow(file);
        }
    }

    private static void deleteOrThrow(File file) throws IOException {
        if (file.exists()) {
            boolean isDeleted = file.delete();
            if (!isDeleted) {
                throw new IOException(String.format("File %s can't be deleted", file.getAbsolutePath()));
            }
        }
    }
}
