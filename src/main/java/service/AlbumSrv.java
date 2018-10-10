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
        return null;
    }

    @Override
    public boolean writeFile(InputStream stream, String albumName, String fileName) {
//        if (stream != null) {
//            File album = Paths.get(ConfigReader.getAlbumsRoot(), albumName).toFile();
//            album.mkdirs();
//            if (album.exists() && album.isDirectory()) {
//                try {
//                    OutputStream out = new FileOutputStream(Paths.get(ConfigReader.getAlbumsRoot(), albumName, fileName).toFile());
//                } catch (FileNotFoundException e) {
//                    Logger.getLogger(AlbumSrv.class).error("Can't read file.", e);
//                    e.printStackTrace();
//                }
//                //Files.wr
//            }
//
//
//        }
        return false;
    }
}
