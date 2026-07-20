package ql;

import java.nio.ByteBuffer;
import kn.l0;
import tl.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    @f0
    public static final <R> R a(int i10, @os.l jn.l<? super f, ? extends R> lVar) {
        l0.p(lVar, "block");
        long j10 = i10;
        e eVar = e.f14042a;
        ByteBuffer byteBufferB = eVar.b(j10);
        try {
            return lVar.invoke(f.b(byteBufferB));
        } finally {
            eVar.a(byteBufferB);
        }
    }

    @f0
    public static final <R> R b(long j10, @os.l jn.l<? super f, ? extends R> lVar) {
        l0.p(lVar, "block");
        e eVar = e.f14042a;
        ByteBuffer byteBufferB = eVar.b(j10);
        try {
            return lVar.invoke(f.b(byteBufferB));
        } finally {
            eVar.a(byteBufferB);
        }
    }
}
