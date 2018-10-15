package controller;

import org.apache.log4j.Logger;
import utils.config.ConfigReader;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AlbumServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(AlbumServlet.class);

    public void doGet(HttpServletRequest req, HttpServletResponse resp){

        if (true) {
            try {
                resp.sendRedirect("/static/images/" + req.getParameter("album")
                + '/' + req.getParameter("filename"));
            } catch (IOException e) {
                LOGGER.error(e);
            }
        }

        List<File> files;
        File file = null;
        // если указан определенный файл, берем его
        if (req.getParameter("filename") != null) {
            file = Paths.get(ConfigReader.getAlbumsRoot(),
                    req.getParameter("album"),
                    req.getParameter("filename")).toFile();
        } else {
            // если не указан(нет параметра filename), то берем первый файл из директории
            try (Stream<Path> paths = Files.walk(Paths.get(ConfigReader.getAlbumsRoot(),
                    req.getParameter("album")))) {
                files = paths.filter(Files::isRegularFile)
                        .map(Path::toFile).collect(Collectors.toList());
                file = files.get(0);
            } catch (IOException e) {
                LOGGER.error(e);
            }
        }

        if (file != null) {
            resp.setContentType("image/png");
            resp.setContentLength((int) file.length());

            try (FileInputStream input = new FileInputStream(file);
                 OutputStream out = resp.getOutputStream()) {
                byte[] buf = new byte[1024];
                int count;
                while ((count = input.read(buf)) >= 0) {
                    out.write(buf, 0, count);
                }
            } catch (IOException e) {
                LOGGER.error(e);
            }
        } else {
            LOGGER.error("File(s) not found");
        }
    }
}
