package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public class ServiceException extends Exception {
    private static final long serialVersionUID = -1219262335729891920L;

    public ServiceException(String str) {
        super(str);
    }

    public ServiceException(Throwable th2) {
        super(th2);
    }

    public ServiceException(String str, Throwable th2) {
        super(str, th2);
    }
}
