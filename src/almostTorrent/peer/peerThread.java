package almostTorrent.peer;

import almostTorrent.communication.messagePacket;
import almostTorrent.tracker.trackerMain;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static almostTorrent.utils.ioUtils.ep;

public class peerThread implements Runnable {

    private Socket mSocket = null;
    private long id = 0;

    public Socket getmSocket() {
        return mSocket;
    }

    public void setmSocket(Socket mSocket) {
        this.mSocket = mSocket;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    peerThread(Socket socket) {
        this.mSocket = socket;
        this.id = System.currentTimeMillis();

    }

    public void run() {
        try {
            ep("Peer thread " + id + ": handling connection on port " + String.valueOf(mSocket.getPort()));

            //ObjectOutputStream mObjectOutputStream = new ObjectOutputStream(mSocket.getOutputStream());
            ObjectInputStream mObjectInputStream = new ObjectInputStream(mSocket.getInputStream());

            try {
                ep("Receiving object");
                messagePacket mReceivedPacket = (messagePacket) mObjectInputStream.readObject();
                ep(mReceivedPacket.toString());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                mObjectInputStream.close();
                //mObjectOutputStream.close();
                trackerMain.cleanSocket(mSocket,id);
                mSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
