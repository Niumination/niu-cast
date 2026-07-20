package com.transsion.aiotlink;

/* JADX INFO: loaded from: classes.dex */
public interface IUibcListener {
    void onClose();

    void onConnect(int i10);

    void onReceiveData(byte[] bArr, int i10);
}
