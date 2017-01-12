package bgu.spl171.net.api.bidi;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by elad on 1/12/17.
 */
public class BidiMessagingProtocolImpl<Packet> implements BidiMessagingProtocol<Packet> {
    private Connections<Packet> connections;
    private int connectionId;
    private static ConcurrentHashMap<Integer, String> activeClients=new ConcurrentHashMap<>();
    @Override
    public void start(int connectionId, Connections<T> connections) {
        this.connectionId=connectionId;
        this.connections=connections;
    }

    @Override
    public void process(Packet message) {
        if (message==null){
            connections.send(connectionId,new ERROR((short)4,(bgu.spl171.net.packets.Packet)"Illegal TFTP operation–Unknown Opcode"));
        }
    }

    @Override
    public boolean shouldTerminate() {
        return false;
    }
}
