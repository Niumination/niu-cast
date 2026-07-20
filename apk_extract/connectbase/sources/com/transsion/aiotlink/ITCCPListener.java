package com.transsion.aiotlink;

/* JADX INFO: loaded from: classes.dex */
public interface ITCCPListener {
    void onClose();

    void onConnect(int i10);

    void onTccpRequest(short s10, int i10, String str);

    void onTccpResponse(short s10, int i10, short s11, String str);
}
