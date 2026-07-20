package hj;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f5467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gj.c f5468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gj.b f5469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentLinkedQueue f5470d;
    public final int e;

    public n(gj.d taskRunner, int i8, long j8, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        this.e = i8;
        this.f5467a = timeUnit.toNanos(j8);
        this.f5468b = taskRunner.e();
        this.f5469c = new gj.b(1, this, h0.a.n(new StringBuilder(), ej.b.f4968g, " ConnectionPool"));
        this.f5470d = new ConcurrentLinkedQueue();
        if (j8 <= 0) {
            throw new IllegalArgumentException(o.d.j("keepAliveDuration <= 0: ", j8).toString());
        }
    }

    public final boolean a(dj.a address, i call, ArrayList arrayList, boolean z2) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(call, "call");
        Iterator it = this.f5470d.iterator();
        while (true) {
            if (!it.hasNext()) {
                return false;
            }
            m connection = (m) it.next();
            Intrinsics.checkNotNullExpressionValue(connection, "connection");
            synchronized (connection) {
                if (z2) {
                    if (!(connection.f != null)) {
                    }
                    Unit unit = Unit.INSTANCE;
                }
                if (connection.h(address, arrayList)) {
                    call.b(connection);
                    return true;
                }
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    public final int b(m mVar, long j8) {
        byte[] bArr = ej.b.f4964a;
        ArrayList arrayList = mVar.f5466o;
        int i8 = 0;
        while (i8 < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(i8);
            if (reference.get() != null) {
                i8++;
            } else {
                String message = "A connection to " + mVar.q.f4617a.f4470a + " was leaked. Did you forget to close a response body?";
                lj.m mVar2 = lj.m.f7532a;
                lj.m mVar3 = lj.m.f7532a;
                Throwable th2 = ((g) reference).f5441a;
                mVar3.getClass();
                Intrinsics.checkNotNullParameter(message, "message");
                if (th2 == null) {
                    message = h0.a.B(message, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
                }
                lj.m.f(message, 5, th2);
                arrayList.remove(i8);
                mVar.f5460i = true;
                if (arrayList.isEmpty()) {
                    mVar.p = j8 - this.f5467a;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }
}
