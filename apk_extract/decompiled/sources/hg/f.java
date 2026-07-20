package hg;

import java.io.Closeable;
import kotlin.Unit;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wi.a f5353a;

    public /* synthetic */ f(wi.a aVar) {
        this.f5353a = aVar;
    }

    public static final byte[] a(wi.a aVar, String hashName) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(hashName, "hashName");
        synchronized (aVar) {
            e function = new e(hashName, 0);
            Intrinsics.checkNotNullParameter(aVar, "<this>");
            Intrinsics.checkNotNullParameter(function, "function");
            wi.f fVarPeek = aVar.peek();
            try {
                Object objInvoke = function.invoke(fVarPeek);
                AutoCloseableKt.closeFinally(fVarPeek, null);
                bArr = (byte[]) objInvoke;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    AutoCloseableKt.closeFinally(fVarPeek, th2);
                    throw th3;
                }
            }
        }
        Intrinsics.checkNotNullExpressionValue(bArr, "synchronized(...)");
        return bArr;
    }

    public static final void c(wi.a aVar, wi.a packet) {
        Intrinsics.checkNotNullParameter(packet, "packet");
        synchronized (aVar) {
            if (packet.T()) {
                return;
            }
            lh.a.m(aVar, lh.a.c(packet));
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            return Intrinsics.areEqual(this.f5353a, ((f) obj).f5353a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5353a.hashCode();
    }

    public final String toString() {
        return "Digest(state=" + this.f5353a + ')';
    }
}
