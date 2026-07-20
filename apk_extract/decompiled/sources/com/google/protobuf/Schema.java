package com.google.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
interface Schema<T> {
    boolean equals(T t3, T t8);

    int getSerializedSize(T t3);

    int hashCode(T t3);

    boolean isInitialized(T t3);

    void makeImmutable(T t3);

    void mergeFrom(T t3, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    void mergeFrom(T t3, T t8);

    void mergeFrom(T t3, byte[] bArr, int i8, int i9, ArrayDecoders.Registers registers) throws IOException;

    T newInstance();

    void writeTo(T t3, Writer writer) throws IOException;
}
