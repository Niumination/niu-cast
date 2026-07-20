package io.netty.util;

/* JADX INFO: loaded from: classes3.dex */
public interface ReferenceCounted {
    int refCnt();

    boolean release();

    boolean release(int i10);

    ReferenceCounted retain();

    ReferenceCounted retain(int i10);

    ReferenceCounted touch();

    ReferenceCounted touch(Object obj);
}
