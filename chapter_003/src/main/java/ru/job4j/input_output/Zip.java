package ru.job4j.input_output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Андрей on 19.07.2017.
 */
public class Zip {
    /**
     * method run archive.
     * @param zip_file  - archived file
     * @param source_dir - directory for archive
     */
    public void zipData(File zip_file, File source_dir) throws IOException {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zip_file))) {
            addDirectory(zout, source_dir);
        }
    }
    /**
     * method archives data.
     * @param zout  - stream for archive data
     * @param fileSource - file for archive
     */
    private void addDirectory(ZipOutputStream zout, File fileSource) throws IOException {
        File[] files = fileSource.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                addDirectory(zout, files[i]);
            } else {
                FileInputStream fis = new FileInputStream(files[i]);

                zout.putNextEntry(new ZipEntry(files[i].getPath()));

                byte[] buffer = new byte[4096];
                int length;
                while ((length = fis.read(buffer)) > 0)
                    zout.write(buffer, 0, length);
                zout.closeEntry();
                fis.close();
            }
        }
    }
}
