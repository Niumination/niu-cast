package io.netty.util.internal;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
interface Cleaner {
    void freeDirectBuffer(ByteBuffer byteBuffer);
}
