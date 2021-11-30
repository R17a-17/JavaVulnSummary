package com.r17a.commonvuln.file;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileUnzip {
    public static void main(String[] args) {
        try{
            FileUnzip fileUnzip = new FileUnzip();
            fileUnzip.unzipNoFix("./owasp/src/main/resources/1.zip");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static final int BUFFER = 512;
    private static final int TOOBIG = 0x6400000; // 100MB
    private static final int TOOMANY = 1024; // max number of files


    public final void unzipNoFix(String filename) throws java.io.IOException {
        FileInputStream fis = new FileInputStream(filename);
        ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
        ZipEntry entry;
        try {
            while ((entry = zis.getNextEntry()) != null) {
                System.out.println("Extracting: " + entry);
                int count;
                byte[] data = new byte[BUFFER];
                // Write the files to the disk, but only if the file is not insanely big
                if (entry.getSize() > TOOBIG) {
                    throw new IllegalStateException("File to be unzipped is huge.");
                }
                if (entry.getSize() == -1) {
                    throw new IllegalStateException("File to be unzipped might be huge.");
                }
                FileOutputStream fos = new FileOutputStream(entry.getName());
                BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER);
                while ((count = zis.read(data, 0, BUFFER)) != -1) {
                    dest.write(data, 0, count);
                }
                dest.flush();
                dest.close();
                zis.closeEntry();
            }
        } finally {
            zis.close();
        }
    }


    public final void unzipWithFix(String fileName) throws java.io.IOException {
        FileInputStream fis = new FileInputStream(fileName);
        ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
        ZipEntry entry;
        int entries = 0;
        int total = 0;
        byte[] data = new byte[BUFFER];
        try {
            while ((entry = zis.getNextEntry()) != null) {
                System.out.println("Extracting: " + entry);
                int count;
                // Write the files to the disk, but ensure that the entryName is valid,
                // and that the file is not insanely big
                String name = sanitzeFileName(entry.getName(), ".");
                FileOutputStream fos = new FileOutputStream(name);
                BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER);
                while (total + BUFFER <= TOOBIG && (count = zis.read(data, 0, BUFFER)) != -1) {
                    dest.write(data, 0, count);
                    total += count;
                }
                dest.flush();
                dest.close();
                zis.closeEntry();
                entries++;
                if (entries > TOOMANY) {
                    throw new IllegalStateException("Too many files to unzip.");
                }
                if (total > TOOBIG) {
                    throw new IllegalStateException(
                            "File being unzipped is too big.");
                }
            }
        } finally {
            zis.close();
        }
    }

    // 将文件放在指定目录，防止 ../ 路径穿越
    private String sanitzeFileName(String entryName, String intendedDir) throws IOException {
        File f = new File(intendedDir, entryName);
        String canonicalPath = f.getCanonicalPath();
        File iD = new File(intendedDir);
        String canonicalID = iD.getCanonicalPath();
        if (canonicalPath.startsWith(canonicalID)) {
            return canonicalPath;
        } else {
            throw new IllegalStateException("File is outside extraction target directory.");
        }
    }
}
