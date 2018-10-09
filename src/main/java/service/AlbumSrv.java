package service;

import org.apache.log4j.Logger;
import service.iface.IAlbumSrv;
import utils.config.ConfigReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Paths;

/**
 * Чтение/запись файлов из/в альбомы
 */
public class AlbumSrv implements IAlbumSrv {
    @Override
    public InputStream readFile(String albumName, String fileName) {
        File file = Paths.get(ConfigReader.getAlbumsRoot(), albumName, fileName).toFile();
        if (file.exists()) {
            try {
                return new FileInputStream(file);
            } catch (FileNotFoundException e) {
                Logger.getLogger(AlbumSrv.class).error("Can't read file.", e);
            }
        } else {
            return null;
        }
    }

    @Override
    public boolean writeFile(InputStream stream, String albumName, String fileName) {
        return false;
    }
}
