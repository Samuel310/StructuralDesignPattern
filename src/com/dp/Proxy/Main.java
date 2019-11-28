package com.dp.Proxy;
import java.util.ArrayList;
import java.util.List;

interface Internet {
    void connectTo(String serverHost);
}

class RealInternet implements Internet {
    @Override
    public void connectTo(String serverHost) {
        System.out.println("Connected : "+ serverHost);
    }
}

class ProxyInternet implements Internet {
    private Internet internet = new RealInternet();
    private static List<String> bannedSites;

    static {
        bannedSites = new ArrayList<String>();
        bannedSites.add("abc.com");
        bannedSites.add("def.com");
        bannedSites.add("ijk.com");
        bannedSites.add("lnm.com");
    }

    @Override
    public void connectTo(String serverHost){
        if(bannedSites.contains(serverHost.toLowerCase())) {
            System.out.println("Access Denied : " + serverHost);
        }else {
            internet.connectTo(serverHost);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        internet.connectTo("karunya.edu");
        internet.connectTo("abc.com");
    }
}
