package gj;

import hj.m;
import java.io.IOException;
import java.net.Socket;
import kj.n;
import kj.s;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends a {
    public final /* synthetic */ int e;
    public final /* synthetic */ Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i8, Object obj, String str) {
        super(str, true);
        this.e = i8;
        this.f = obj;
    }

    @Override // gj.a
    public final long a() {
        int i8 = 0;
        switch (this.e) {
            case 0:
                ((n) this.f).invoke();
                return -1L;
            case 1:
                hj.n nVar = (hj.n) this.f;
                long jNanoTime = System.nanoTime();
                long j8 = Long.MIN_VALUE;
                m mVar = null;
                int i9 = 0;
                for (m connection : nVar.f5470d) {
                    Intrinsics.checkNotNullExpressionValue(connection, "connection");
                    synchronized (connection) {
                        try {
                            if (nVar.b(connection, jNanoTime) > 0) {
                                i9++;
                            } else {
                                i8++;
                                long j10 = jNanoTime - connection.p;
                                if (j10 > j8) {
                                    Unit unit = Unit.INSTANCE;
                                    mVar = connection;
                                    j8 = j10;
                                } else {
                                    Unit unit2 = Unit.INSTANCE;
                                }
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                long j11 = nVar.f5467a;
                if (j8 < j11 && i8 <= nVar.e) {
                    if (i8 > 0) {
                        return j11 - j8;
                    }
                    if (i9 > 0) {
                        return j11;
                    }
                    return -1L;
                }
                Intrinsics.checkNotNull(mVar);
                synchronized (mVar) {
                    if (!mVar.f5466o.isEmpty()) {
                        return 0L;
                    }
                    if (mVar.p + j8 != jNanoTime) {
                        return 0L;
                    }
                    mVar.f5460i = true;
                    nVar.f5470d.remove(mVar);
                    Socket socket = mVar.f5456c;
                    Intrinsics.checkNotNull(socket);
                    ej.b.e(socket);
                    if (!nVar.f5470d.isEmpty()) {
                        return 0L;
                    }
                    nVar.f5468b.a();
                    return 0L;
                }
            default:
                s sVar = (s) this.f;
                sVar.getClass();
                try {
                    sVar.f6954y.j(false, 2, 0);
                    break;
                } catch (IOException e) {
                    sVar.c(e);
                }
                return -1L;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, s sVar) {
        super(str, true);
        this.e = 2;
        this.f = sVar;
    }
}
