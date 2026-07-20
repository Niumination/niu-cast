package com.transsion.streamClient;

/* JADX INFO: loaded from: classes2.dex */
public class StreamClient {

    public static final class InstanceHolder {
        private static final StreamClient INSTANCE = new StreamClient();

        private InstanceHolder() {
        }
    }

    static {
        System.loadLibrary("fileNativeJNI");
    }

    public static StreamClient getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public native int connectTo(String str, int i10, IClientStreamData iClientStreamData, IClientStreamClose iClientStreamClose, IClientConnectCallback iClientConnectCallback);

    public native int disconnect(long j10, IClientDisconnectCallback iClientDisconnectCallback);

    public native int sendBuffer(long j10, byte[] bArr, IClientSendBufferCallback iClientSendBufferCallback);
}
