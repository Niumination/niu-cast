package com.transsion.iotservice.multiscreen.pc.socket;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import k3.gc;
import k3.ob;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/socket/TCCPHandshakeSocketServer;", "Lcom/transsion/iotservice/multiscreen/pc/socket/TranTCCPChannel;", "Lcom/transsion/iotservice/multiscreen/pc/socket/IHandshakeChannelServer;", "<init>", "()V", "socket", "Ljava/net/ServerSocket;", "running", "", "startServer", "", "port", "", "releaseServer", "quietlyExit", "release", "waitConnect", "Companion", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TCCPHandshakeSocketServer extends TranTCCPChannel implements IHandshakeChannelServer {
    private static final String TAG = "TCCPHandshakeSocketServer";
    private boolean running;
    private ServerSocket socket;

    private final void release() {
        ob.a(this.socket);
        ob.a(getInput(), getOutput());
        ob.a(getInput());
        this.socket = null;
        setInput(null);
        setOutput(null);
        getHandlerThread().quitSafely();
    }

    private final void waitConnect() {
        new Thread(new c(this, 4)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void waitConnect$lambda$2(TCCPHandshakeSocketServer tCCPHandshakeSocketServer) {
        Socket socketAccept;
        try {
            gc.c(TAG, "wait for connection");
            ServerSocket serverSocket = tCCPHandshakeSocketServer.socket;
            if (serverSocket != null && (socketAccept = serverSocket.accept()) != null) {
                tCCPHandshakeSocketServer.setInput(socketAccept.getInputStream());
                tCCPHandshakeSocketServer.setOutput(socketAccept.getOutputStream());
            }
            gc.c(TAG, "connected");
            EventListener msgListener = tCCPHandshakeSocketServer.getMsgListener();
            if (msgListener != null) {
                msgListener.onConnected();
            }
            while (true) {
                ServerSocket serverSocket2 = tCCPHandshakeSocketServer.socket;
                if (serverSocket2 == null || serverSocket2.isClosed() || !tCCPHandshakeSocketServer.running) {
                    return;
                }
                try {
                    tCCPHandshakeSocketServer.handleTccp();
                } catch (Exception e) {
                    String log = "TCCP:receive err: " + e;
                    Intrinsics.checkNotNullParameter(TAG, "tag");
                    Intrinsics.checkNotNullParameter(log, "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat(TAG), log);
                    }
                    tCCPHandshakeSocketServer.releaseServer(false);
                }
            }
        } catch (IOException e4) {
            Intrinsics.checkNotNullParameter(TAG, "tag");
            Intrinsics.checkNotNullParameter(e4, "e");
            Log.e(gc.f6463b.concat(TAG), e4.getMessage(), e4);
            tCCPHandshakeSocketServer.releaseServer(false);
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.socket.IHandshakeChannelServer
    public void releaseServer(boolean quietlyExit) {
        EventListener msgListener;
        gc.c(TAG, "handshake release quietlyExit:" + quietlyExit);
        if (!this.running) {
            gc.c(TAG, "releaseServer when not running");
            release();
            return;
        }
        gc.c(TAG, "releaseServer when running");
        this.running = false;
        release();
        if (!quietlyExit && (msgListener = getMsgListener()) != null) {
            msgListener.onDisconnected();
        }
        setMsgListener(null);
    }

    @Override // com.transsion.iotservice.multiscreen.pc.socket.IHandshakeChannelServer
    public void startServer(int port) {
        gc.c(TAG, "handshake start");
        if (this.socket != null) {
            gc.c(TAG, "start:already working");
            return;
        }
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(InetAddress.getByName("0.0.0.0"), port));
            gc.c(TAG, "start:port:" + serverSocket.getLocalPort() + " ip:" + serverSocket.getLocalSocketAddress());
            serverSocket.setSoTimeout(100000);
            this.socket = serverSocket;
            this.running = true;
            waitConnect();
        } catch (IOException e) {
            Intrinsics.checkNotNullParameter(TAG, "tag");
            Intrinsics.checkNotNullParameter(e, "e");
            Log.e(gc.f6463b.concat(TAG), e.getMessage(), e);
        }
    }
}
