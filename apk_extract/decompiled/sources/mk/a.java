package mk;

import ck.i;
import dk.c;
import dk.e;
import dk.f;
import dk.g;
import dk.k;
import java.util.Arrays;
import k3.t9;
import k3.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends i {
    public final ik.a e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8110h;

    public a(ik.a aVar) {
        super(aVar, true);
        this.f8110h = false;
        this.e = aVar;
    }

    @Override // ck.d
    public final void onCompleted() {
        if (this.f8110h) {
            return;
        }
        this.f8110h = true;
        try {
            this.e.onCompleted();
            try {
                unsubscribe();
            } catch (Throwable th2) {
                t9.a();
                throw new k(th2.getMessage(), th2);
            }
        } catch (Throwable th3) {
            try {
                x1.b(th3);
                t9.a();
                throw new e(th3.getMessage(), th3);
            } catch (Throwable th4) {
                try {
                    unsubscribe();
                    throw th4;
                } catch (Throwable th5) {
                    t9.a();
                    throw new k(th5.getMessage(), th5);
                }
            }
        }
    }

    @Override // ck.d
    public final void onError(Throwable th2) {
        x1.b(th2);
        if (this.f8110h) {
            return;
        }
        this.f8110h = true;
        t9.a();
        try {
            this.e.onError(th2);
            try {
                unsubscribe();
            } catch (RuntimeException e) {
                t9.a();
                throw new f(e);
            }
        } catch (Throwable th3) {
            if (th3 instanceof g) {
                try {
                    unsubscribe();
                    throw th3;
                } catch (Throwable th4) {
                    t9.a();
                    throw new RuntimeException("Observer.onError not implemented and error while unsubscribing.", new c(Arrays.asList(th2, th4)));
                }
            }
            t9.a();
            try {
                unsubscribe();
                throw new f("Error occurred when trying to propagate error to Observer.onError", new c(Arrays.asList(th2, th3)));
            } catch (Throwable th5) {
                t9.a();
                throw new f("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new c(Arrays.asList(th2, th3, th5)));
            }
        }
    }

    @Override // ck.d
    public final void onNext(Object obj) {
        try {
            if (this.f8110h) {
                return;
            }
            this.e.onNext(obj);
        } catch (Throwable th2) {
            x1.b(th2);
            onError(th2);
        }
    }
}
