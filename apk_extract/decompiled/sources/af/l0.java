package af;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f409b;

    public /* synthetic */ l0(Object obj, int i8) {
        this.f408a = i8;
        this.f409b = obj;
    }

    public abstract void a();

    public abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f408a) {
            case 0:
                ze.y yVar = (ze.y) this.f409b;
                ze.y yVarC = yVar.c();
                try {
                    b();
                    return;
                } finally {
                    yVar.k(yVarC);
                }
            default:
                cf.c cVar = (cf.c) this.f409b;
                try {
                    if (cVar.f1498k == null) {
                        throw new IOException("Unable to perform write due to unavailable sink.");
                    }
                    a();
                    return;
                } catch (Exception e) {
                    cVar.f1494d.b(e);
                    return;
                }
        }
    }
}
