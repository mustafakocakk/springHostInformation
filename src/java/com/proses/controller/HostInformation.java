package com.proses.controller;

import java.util.Collections;
import java.util.List;

public class HostInformation {
    private String host;
    private String ipAdress;
    private String macAdress;
    private String networkInterfaces;
    private List<String> openPorts;
    private String loopBack;
    private  String broadcast;
    private  String subnet;

    public String getSubnet() {
        return subnet;
    }

    public void setSubnet(String subnet) {
        this.subnet = subnet;
    }

    public String getLoopBack() {
        return loopBack;
    }

    public void setLoopBack(String loopBack) {
        this.loopBack = loopBack;
    }

    public  HostInformation(){

    }
    public HostInformation(String host, String ipAdress, String macAdress, String networkInterfaces, String openPorts) {
        this.host = host;
        this.ipAdress = ipAdress;
        this.macAdress = macAdress;
        this.networkInterfaces = networkInterfaces;
        this.openPorts = Collections.singletonList(openPorts);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public String getMacAdress() {
        return macAdress;
    }

    public void setMacAdress(String macAdress) {
        this.macAdress = macAdress;
    }

    public void setOpenPorts(List<String> openPorts) {
        this.openPorts = openPorts;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }



    public String getNetworkInterfaces() {
        return networkInterfaces;
    }

    public void setNetworkInterfaces(String networkInterfaces) {
        this.networkInterfaces = networkInterfaces;
    }

    public List<String> getOpenPorts() {
        return openPorts;
    }

    public void setOpenPorts(String openPorts) {
        this.openPorts = Collections.singletonList(openPorts);
    }
}
