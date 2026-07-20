package com.transsion.fileTransfer;

/* JADX INFO: loaded from: classes2.dex */
public class SourceJniMethod {

    public static final class InstanceHolder {
        private static final SourceJniMethod INSTANCE = new SourceJniMethod();

        private InstanceHolder() {
        }
    }

    static {
        System.loadLibrary("fileNativeJNI");
    }

    public static SourceJniMethod getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public native int cancelFileTransfer(String str, ICancelSingleFileTransfer iCancelSingleFileTransfer);

    public native int confirmSessionsId(String str, IConfirmId iConfirmId);

    public native int disconnectCleanup();

    public native int openServerAndWaitClient(int i10, int i11, IPortListenedListener iPortListenedListener, ICreateFileServersListener iCreateFileServersListener);

    public native int requestSendFile(String str, String str2, IRequestSendFile iRequestSendFile);

    public native int requestSendFolder(String str, String str2, IRequestSendFile iRequestSendFile);

    public native int setFinishedTransferListener(ISingleFileFinish iSingleFileFinish);

    public native int setInterruptTransferListener(IInterruptFile iInterruptFile);

    public native int setPassiveReceiveEmptyListener(IReceiveFileFinish iReceiveFileFinish);

    public native int setProgressTransferListener(ITransferProgress iTransferProgress);

    public native int setRequestReceiveListener(IFileRequestReceive iFileRequestReceive);

    public native int unInitFileTransfer();
}
