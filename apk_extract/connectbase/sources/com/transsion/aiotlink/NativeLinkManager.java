package com.transsion.aiotlink;

import k4.m;

/* JADX INFO: loaded from: classes.dex */
public class NativeLinkManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1809a = "NativeLinkManager";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NativeLinkManager f1810a = new NativeLinkManager();
    }

    static {
        try {
            System.loadLibrary("CastBaseLinkSDK");
        } catch (UnsatisfiedLinkError e10) {
            m.d(f1809a, e10);
        }
    }

    public NativeLinkManager() {
    }

    public static NativeLinkManager a() {
        return a.f1810a;
    }

    public native void cancelReceiveCurrentFile();

    public native boolean closeAudioServer();

    public native boolean closeFileServer();

    public native boolean closeFileServerCallback(ICloseFileServersListener iCloseFileServersListener);

    public native boolean closeTccpServer();

    public native boolean closeUibcServer();

    public native boolean closeVideoServer(int i10);

    public native boolean connectAudio(String str, int i10, IStreamDataListener iStreamDataListener);

    public native boolean connectAudioServer(String str, int i10);

    public native boolean connectTccpServer(String str, int i10, ITCCPListener iTCCPListener);

    public native void connectUibcServer(String str, int i10);

    public native boolean connectVideo(String str, int i10, IStreamDataListener iStreamDataListener);

    public native boolean connectVideoServer(String str, int i10);

    public native boolean createAudioServer(int i10);

    public native boolean createFileServer(int i10, IStreamDataListener iStreamDataListener);

    public native boolean createTccpServer(int i10);

    public native boolean createUibcServer(int i10);

    public native boolean createVideoServer(String str, int i10);

    public native void destroyEventThread();

    public native boolean listenTccpData(ITCCPListener iTCCPListener);

    public native void qosType(int i10);

    public native void releaseJNI();

    public native int sendAudioData(String str, byte[] bArr, int i10);

    public native void sendFileOnConnect(String str);

    public native int sendTccpData(byte[] bArr, int i10);

    public native int sendTccpRequest(short s10, String str);

    public native int sendTccpRequestBySink(short s10, String str);

    public native boolean sendTccpResponse(short s10, int i10, String str);

    public native void sendUibcData(byte[] bArr, int i10);

    public native int sendVideoData(int i10, byte[] bArr, int i11);

    public native boolean setAudioListener(IStreamDataListener iStreamDataListener);

    public native void setFileSavePath(String str);

    public native void setFileSendPath(String str, String str2, int i10, String str3);

    public native void setFileStatusListener(ISourceFileStateListener iSourceFileStateListener);

    public native void setFileTransferConfig(int i10, int i11, int i12);

    public native boolean setUibcListener(int i10, IUibcListener iUibcListener);

    public native boolean setVideoListener(int i10, IStreamDataListener iStreamDataListener);

    public NativeLinkManager(m2.a aVar) {
    }
}
