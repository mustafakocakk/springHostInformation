package com.proses.controller;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Disk {
    private String letter;
    private String type;
    private String totalSpace;
    private String freeSpace;
    private String useSpace;

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTotalSpace() {
        return totalSpace;
    }

    public void setTotalSpace(String totalSpace) {
        this.totalSpace = totalSpace;
    }

    public String getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(String freeSpace) {
        this.freeSpace = freeSpace;
    }

    public String getUseSpace() {
        return useSpace;
    }

    public void setUseSpace(String useSpace) {
        this.useSpace = useSpace;
    }

    public void getDiskInfo()
    {   List<String> list = new ArrayList<String>();

        FileSystemView fsv = FileSystemView.getFileSystemView();

        File[] drives = File.listRoots();
        if (drives != null && drives.length > 0) {
            for (File aDrive : drives) {


                this.setLetter(String.valueOf(aDrive));
                this.setType(fsv.getSystemTypeDescription(aDrive));
                this.setTotalSpace(String.valueOf((double)aDrive.getTotalSpace()/1073741824));
                this.setFreeSpace(String.valueOf((double)aDrive.getUsableSpace()/1073741824));
                this.setUseSpace(String.valueOf((double)aDrive.getTotalSpace()/1073741824-aDrive.getUsableSpace()/1073741824));
            }
        }

    }
}
