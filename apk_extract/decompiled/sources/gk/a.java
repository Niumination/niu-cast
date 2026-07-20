package gk;

import ck.e;
import ck.i;
import java.util.concurrent.atomic.AtomicInteger;
import k3.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends AtomicInteger implements e {
    static final int HAS_REQUEST_HAS_VALUE = 3;
    static final int HAS_REQUEST_NO_VALUE = 2;
    static final int NO_REQUEST_HAS_VALUE = 1;
    static final int NO_REQUEST_NO_VALUE = 0;
    private static final long serialVersionUID = -2873467947112093874L;
    final i child;
    Object value;

    public a(i iVar) {
        this.child = iVar;
    }

    @Override // ck.e
    public void request(long j8) {
        if (j8 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j8 == 0) {
            return;
        }
        do {
            int i8 = get();
            if (i8 != 0) {
                if (i8 == 1 && compareAndSet(1, 3)) {
                    i iVar = this.child;
                    Object obj = this.value;
                    if (iVar.f1736a.f5909b) {
                        return;
                    }
                    try {
                        iVar.onNext(obj);
                        if (iVar.f1736a.f5909b) {
                            return;
                        }
                        iVar.onCompleted();
                        return;
                    } catch (Throwable th2) {
                        x1.c(th2, iVar, obj);
                        return;
                    }
                }
                return;
            }
        } while (!compareAndSet(0, 2));
    }

    public void setValue(Object obj) {
        do {
            int i8 = get();
            if (i8 != 0) {
                if (i8 == 2 && compareAndSet(2, 3)) {
                    i iVar = this.child;
                    if (iVar.f1736a.f5909b) {
                        return;
                    }
                    try {
                        iVar.onNext(obj);
                        if (iVar.f1736a.f5909b) {
                            return;
                        }
                        iVar.onCompleted();
                        return;
                    } catch (Throwable th2) {
                        x1.c(th2, iVar, obj);
                        return;
                    }
                }
                return;
            }
            this.value = obj;
        } while (!compareAndSet(0, 1));
    }
}
