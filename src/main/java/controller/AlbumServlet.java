package controller;

import org.apache.log4j.Logger;
import utils.config.ConfigReader;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class AlbumServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(AlbumServlet.class);

    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        StringBuilder path = new StringBuilder();
        path.append(ConfigReader.getAlbumsRoot())
                .append(req.getParameter("album"))
                .append('/')
                .append(req.getParameter("filename"));
        resp.setContentType("image/png");
        File file = new File(path.toString());
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
    }
}
