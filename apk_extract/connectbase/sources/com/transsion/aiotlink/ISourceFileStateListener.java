package com.transsion.aiotlink;

/* JADX INFO: loaded from: classes.dex */
public interface ISourceFileStateListener {
    void onReceiveFileDone(String str);

    void onReceiveFileProgress(int i10, String str, String str2, String str3);

    void onSendFileDone(String str);

    void onSendFileProgress(int i10, String str, String str2, String str3);
}
