package q3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8953a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f8954b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f8955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f8956d;

    public i(Executor executor, b bVar) {
        this.f8955c = executor;
        this.f8956d = bVar;
    }

    private final void b(f fVar) {
        if (fVar.d() || ((k) fVar).f8960d) {
            return;
        }
        synchronized (this.f8954b) {
            try {
                if (((c) this.f8956d) == null) {
                    return;
                }
                this.f8955c.execute(new i2.e(this, 10, fVar, false));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void a(f fVar) {
        switch (this.f8953a) {
            case 0:
                if (((k) fVar).f8960d) {
                    synchronized (this.f8954b) {
                        try {
                            if (((a8.a) this.f8956d) != null) {
                                ((j) this.f8955c).getClass();
                                synchronized (this.f8954b) {
                                    a8.a aVar = (a8.a) this.f8956d;
                                    if (aVar != null) {
                                        ((CountDownLatch) aVar.f44b).countDown();
                                    }
                                    break;
                                }
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    return;
                }
                return;
            case 1:
                synchronized (this.f8954b) {
                    try {
                        if (((b) this.f8956d) == null) {
                            return;
                        }
                        this.f8955c.execute(new i2.e(this, 9, fVar, false));
                        return;
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
            case 2:
                b(fVar);
                return;
            default:
                if (fVar.d()) {
                    synchronized (this.f8954b) {
                        try {
                            if (((d) this.f8956d) != null) {
                                this.f8955c.execute(new i2.e(this, 11, fVar, false));
                            }
                        } catch (Throwable th4) {
                            throw th4;
                        }
                    }
                    return;
                }
                return;
        }
    }

    public i(Executor executor, c cVar) {
        this.f8955c = executor;
        this.f8956d = cVar;
    }

    public i(Executor executor, d dVar) {
        this.f8955c = executor;
        this.f8956d = dVar;
    }

    public i(j jVar, a8.a aVar) {
        this.f8955c = jVar;
        this.f8956d = aVar;
    }
}
