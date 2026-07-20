package com.transsion.streamServer;

/* JADX INFO: loaded from: classes2.dex */
public class StreamServer {

    public static final class InstanceHolder {
        private static final StreamServer INSTANCE = new StreamServer();

        private InstanceHolder() {
        }
    }

    static {
        try {
            System.loadLibrary("fileNativeJNI");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public static StreamServer getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public native int createWaitConnect(int i10, float f10, IServerStreamData iServerStreamData, IServerStreamClose iServerStreamClose, IServerCreateCallback iServerCreateCallback, IServerConnectCallback iServerConnectCallback);

    public native int disconnect(long j10, IServerDisconnectCallback iServerDisconnectCallback);

    public native int sendBuffer(long j10, byte[] bArr, IServerSendBufferCallback iServerSendBufferCallback);
}
