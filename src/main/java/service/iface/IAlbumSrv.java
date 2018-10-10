package service.iface;

import java.io.InputStream;

/**
 * Чтение/запись файлов из/в альбомы
 */
public interface IAlbumSrv {
    InputStream readFile(String albumName, String fileName);

    boolean writeFile(InputStream stream, String albumName, String fileName);
}
