package ql;

import io.netty.handler.codec.http2.Http2CodecUtil;
import lm.a2;
import lm.g2;
import lm.t;
import lm.w1;
import tl.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final byte a(short s10) {
        return (byte) (s10 >>> 8);
    }

    @f0
    public static /* synthetic */ void b(short s10) {
    }

    public static final int c(long j10) {
        return (int) (j10 >>> 32);
    }

    @f0
    public static /* synthetic */ void d(long j10) {
    }

    public static final short e(int i10) {
        return (short) (i10 >>> 16);
    }

    @f0
    public static /* synthetic */ void f(int i10) {
    }

    public static final byte g(short s10) {
        return (byte) (s10 & Http2CodecUtil.MAX_UNSIGNED_BYTE);
    }

    @f0
    public static /* synthetic */ void h(short s10) {
    }

    public static final int i(long j10) {
        return (int) (j10 & 4294967295L);
    }

    @f0
    public static /* synthetic */ void j(long j10) {
    }

    public static final short k(int i10) {
        return (short) (i10 & 65535);
    }

    @f0
    public static /* synthetic */ void l(int i10) {
    }

    @t
    public static final long m(long j10) {
        return a2.m(Long.reverseBytes(j10));
    }

    @t
    public static final int n(int i10) {
        return w1.m(Integer.reverseBytes(i10));
    }

    @t
    public static final short o(short s10) {
        return g2.m(Short.reverseBytes(s10));
    }
}
