package com.google.protobuf.kotlin;

import com.google.protobuf.ByteString;
import java.nio.ByteBuffer;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class ByteStringsKt {
    public static final byte get(@l ByteString byteString, int i10) {
        l0.p(byteString, "<this>");
        return byteString.byteAt(i10);
    }

    public static final boolean isNotEmpty(@l ByteString byteString) {
        l0.p(byteString, "<this>");
        return !byteString.isEmpty();
    }

    @l
    public static final ByteString plus(@l ByteString byteString, @l ByteString byteString2) {
        l0.p(byteString, "<this>");
        l0.p(byteString2, "other");
        ByteString byteStringConcat = byteString.concat(byteString2);
        l0.o(byteStringConcat, "concat(other)");
        return byteStringConcat;
    }

    @l
    public static final ByteString toByteString(@l byte[] bArr) {
        l0.p(bArr, "<this>");
        ByteString byteStringCopyFrom = ByteString.copyFrom(bArr);
        l0.o(byteStringCopyFrom, "copyFrom(this)");
        return byteStringCopyFrom;
    }

    @l
    public static final ByteString toByteStringUtf8(@l String str) {
        l0.p(str, "<this>");
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8(str);
        l0.o(byteStringCopyFromUtf8, "copyFromUtf8(this)");
        return byteStringCopyFromUtf8;
    }

    @l
    public static final ByteString toByteString(@l ByteBuffer byteBuffer) {
        l0.p(byteBuffer, "<this>");
        ByteString byteStringCopyFrom = ByteString.copyFrom(byteBuffer);
        l0.o(byteStringCopyFrom, "copyFrom(this)");
        return byteStringCopyFrom;
    }
}
