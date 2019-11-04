import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class ovning1 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        String hostName = localHost.getHostName();
        String hostAddress = localHost.getHostAddress();
        boolean multicast = localHost.isMulticastAddress();
        InetAddress loopBack = localHost.getLoopbackAddress();
        System.out.println("Get LocalHost: " +  localHost);
        System.out.println("Get hostName: " + hostName);
        System.out.println("Get hostAddress: " + hostAddress);
        System.out.println("Is it multicast: " + multicast);
        System.out.println("Loopback address: " + loopBack);
/*

        try {
            String ip;
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                // filters out 127.0.0.1 and inactive interfaces
                if (iface.isLoopback() || !iface.isUp())
                    continue;

                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while(addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    ip = addr.getHostAddress();
                    System.out.println(iface.getDisplayName() + " " + ip);
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

 */
    }
}
