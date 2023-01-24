package multicast;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class testIfs {
	public static void main(String[] args) throws SocketException {
		Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();

		for (NetworkInterface nif: Collections.list(nets)) {
		    System.out.println(nif.getName());
		    for(InetAddress ip : Collections.list(nif.getInetAddresses())){
		    	System.out.println("\t"+ip);
		    }
		}
	}

}
