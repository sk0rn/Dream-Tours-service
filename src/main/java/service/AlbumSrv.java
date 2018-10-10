package service;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import utils.config.ConfigReader;

import java.io.*;
import java.nio.file.Paths;

/**
 * Чтение/запись файлов из/в альбомы
 */
public final class AlbumSrv {
    private AlbumSrv() {
    }

    public static InputStream readFile(String albumName, String fileName) {
        File file = Paths.get(ConfigReader.getAlbumsRoot(), albumName, fileName).toFile();
        if (file.exists()) {
            try {
                return new FileInputStream(file);
            } catch (FileNotFoundException e) {
                Logger.getLogger(AlbumSrv.class).error("Can't read file " + file.getName(), e);
            }
        }
        return null;
    }

    public static boolean writeFile(InputStream stream, String albumName, String fileName) {
        if (stream != null) {
            File album = Paths.get(ConfigReader.getAlbumsRoot(), albumName).toFile();
            File file = Paths.get(ConfigReader.getAlbumsRoot(), albumName, fileName).toFile();
            album.mkdirs();
            if (album.exists() && album.isDirectory()) {
                try {
                    FileUtils.copyInputStreamToFile(stream, file);
                    return true;
                } catch (IOException e) {
                    Logger.getLogger(AlbumSrv.class).error("Can't write file " + file.getName(), e);
                }
            }
        }
        return false;
    }
}
