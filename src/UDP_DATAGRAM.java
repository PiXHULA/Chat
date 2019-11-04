import java.net.InetAddress;
import java.net.UnknownHostException;

public class UDP_DATAGRAM {
    public static void main(String[] args) throws UnknownHostException {
        //IP- internet protocoll
        //IPV4 - IPV6 - gamla vs nya. Nya har såpass många kombs. att man kan adressera varje atom i universum
        //Kolla upp vilket ip nummer som jag ha fått från skolan pga dynamiskt.
        //Portal för att veta vilket program som ska få vilken information
        //0-1024 - reserverade för olika standardservicar - 80 för browser
        //Nätverksprotokoll
        //Kommunikationen använder protokoll
        //404 - error
        //DNS - Domain name server
        /*

         */
        InetAddress.getByName("JOAKIM_PC");
        /*
        byte[]address = new byte[4];
        InetAddress.getByAddress(address);

         */
        InetAddress addrees = InetAddress.getLocalHost();
        System.out.println(addrees);
        System.out.println(addrees.isLoopbackAddress());
        System.out.println(addrees.getCanonicalHostName());


    }
}

