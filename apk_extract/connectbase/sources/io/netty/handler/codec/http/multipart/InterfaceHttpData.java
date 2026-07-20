package io.netty.handler.codec.http.multipart;

import io.netty.util.ReferenceCounted;

/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceHttpData extends Comparable<InterfaceHttpData>, ReferenceCounted {

    public enum HttpDataType {
        Attribute,
        FileUpload,
        InternalAttribute
    }

    HttpDataType getHttpDataType();

    String getName();

    InterfaceHttpData retain();

    InterfaceHttpData retain(int i10);

    InterfaceHttpData touch();

    InterfaceHttpData touch(Object obj);
}
