package hj;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile AtomicInteger f5438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f5.a f5439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f5440c;

    public f(i iVar, f5.a responseCallback) {
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        this.f5440c = iVar;
        this.f5439b = responseCallback;
        this.f5438a = new AtomicInteger(0);
    }

    @Override // java.lang.Runnable
    public final void run() {
        dj.m mVar;
        String str = "OkHttp " + this.f5440c.q.f4528b.g();
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "currentThread");
        String name = currentThread.getName();
        currentThread.setName(str);
        try {
            this.f5440c.f5444b.h();
            boolean z2 = false;
            try {
                try {
                    try {
                        this.f5439b.h(this.f5440c.f());
                        mVar = this.f5440c.p.f4495a;
                    } catch (IOException e) {
                        e = e;
                        z2 = true;
                        if (z2) {
                            lj.m mVar2 = lj.m.f7532a;
                            lj.m mVar3 = lj.m.f7532a;
                            String str2 = "Callback failure for " + i.a(this.f5440c);
                            mVar3.getClass();
                            lj.m.f(str2, 4, e);
                        } else {
                            this.f5439b.b(e);
                        }
                        mVar = this.f5440c.p.f4495a;
                    } catch (Throwable th2) {
                        th = th2;
                        z2 = true;
                        this.f5440c.cancel();
                        if (!z2) {
                            IOException iOException = new IOException("canceled due to " + th);
                            ExceptionsKt.addSuppressed(iOException, th);
                            this.f5439b.b(iOException);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    this.f5440c.p.f4495a.c(this);
                    throw th3;
                }
            } catch (IOException e4) {
                e = e4;
            } catch (Throwable th4) {
                th = th4;
            }
            mVar.c(this);
            currentThread.setName(name);
        } catch (Throwable th5) {
            currentThread.setName(name);
            throw th5;
        }
    }
}
