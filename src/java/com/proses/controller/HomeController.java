package com.proses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {

    public HostInformation  hostInfo() throws SocketException, UnknownHostException {
        String isim="";
        List<InterfaceAddress> ip = null;
        InetAddress inetAddress = InetAddress.getLocalHost();
        HostInformation hostInformation=new HostInformation();
        ArrayList<NetworkInterface> interfaces = Collections.list(
                NetworkInterface.getNetworkInterfaces());
        for (NetworkInterface iface : interfaces)
        {
            if (iface.isUp())
            {
                ip=iface.getInterfaceAddresses();
            }
            break;
        }
        String macInterface=String.valueOf(ip.get(0));
        String ipInfo=String.valueOf(ip.get(1));

        String[] parts = macInterface.split("/");
        String part2 = parts[1];
        String[] bilgi =(part2.split("%"));
        String mac1=bilgi[0];
        String interface2=bilgi[1];

        String[] ipGet=ipInfo.split("/");
        String ipAdress = ipGet[1];
        String subnet=ipGet[2];
        String broadcast=ipGet[3];
        String[] subnetGet=subnet.split(" ");
        subnet=subnetGet[0];
        String[] broadcastGet=broadcast.split("]");
        broadcast=broadcastGet[0];
        hostInformation.setHost(inetAddress.getHostName());
        hostInformation.setLoopBack(inetAddress.getHostAddress());
        hostInformation.setIpAdress(ipAdress);
        hostInformation.setMacAdress(mac1);
        hostInformation.setMacAdress(mac1);
        hostInformation.setNetworkInterfaces(interface2);
        hostInformation.setSubnet(subnet);
        hostInformation.setBroadcast(broadcast);
        // get open ports
        ArrayList<String> ports=new ArrayList<>();
        for (int port = 1; port <= 1024; port++) {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress("localhost", port), 1000);
                socket.close();
                ports.add(String.valueOf(port));

            } catch (Exception ex) {
            }
        }
        hostInformation.setOpenPorts(ports);
        return hostInformation;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap model) throws UnknownHostException, SocketException {
HostInformation hostInformation=new HostInformation();
hostInformation=hostInfo();
        model.addAttribute("infoHost",hostInformation);

        return "index";
    }




    @RequestMapping(value = "/proses", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        ArrayList<String> baslik =new ArrayList();

        int i=0;
        List<Proses> list = new ArrayList<Proses>();

        try {
            String process;
            Process p = Runtime.getRuntime().exec("ps -aux");
            BufferedReader input;
            input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((process = input.readLine()) != null) {
                Proses p1=new Proses();
                ArrayList<String> items =new ArrayList(Arrays.asList(process.split(" ")));
                if(i!=0) {
                    for (int j = 0; j < items.size(); j++) {
                        if (!items.get(j).equals("")) {
                            baslik.add(items.get(j));
                        }
                    }
                    p1.setUser(baslik.get(0));
                    p1.setPid(baslik.get(1));
                    p1.setCpu(baslik.get(2));
                    p1.setMem(baslik.get(3));
                    p1.setVsz(baslik.get(4));
                    p1.setRss(baslik.get(5));
                    p1.setTty(baslik.get(6));
                    p1.setStat(baslik.get(7));
                    p1.setStart(baslik.get(8));
                    p1.setTime(baslik.get(9));
                    p1.setCommand(baslik.get(10));

                    list.add(p1);
                }i++;
            baslik.clear();
            }

            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
        model.addAttribute("allProses", list);
        return "proses";

    }


    @RequestMapping(value = "/kill", method = RequestMethod.POST)
    public @ResponseBody    String getir(@RequestParam(value = "id") String id) throws IOException {
        Process proc = Runtime.getRuntime().exec("kill -SIGTERM -" + id);
        return "proses";
    }
    @RequestMapping(value = "/disk", method = RequestMethod.GET)
    public String disk(ModelMap model) {
            Runtime runtime = Runtime.getRuntime();
            long disk=0;
            Disk d1=new Disk();
            d1.getDiskInfo();
            model.addAttribute("diskInfo",d1);
            disk=(runtime.totalMemory()/1024-runtime.freeMemory()/1024)*100/8192;
            model.addAttribute("memory",disk);
        return "disk";
    }


}
