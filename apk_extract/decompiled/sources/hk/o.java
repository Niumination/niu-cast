package hk;

import ik.v;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends AtomicBoolean implements ck.j {
    private static final long serialVersionUID = 247232374289553518L;
    final v parent;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final q f5514s;

    public o(q qVar, v vVar) {
        this.f5514s = qVar;
        this.parent = vVar;
    }

    @Override // ck.j
    public boolean isUnsubscribed() {
        return this.f5514s.isUnsubscribed();
    }

    @Override // ck.j
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            v vVar = this.parent;
            q qVar = this.f5514s;
            if (vVar.f5909b) {
                return;
            }
            synchronized (vVar) {
                LinkedList linkedList = vVar.f5908a;
                if (!vVar.f5909b && linkedList != null) {
                    boolean zRemove = linkedList.remove(qVar);
                    if (zRemove) {
                        qVar.unsubscribe();
                    }
                }
            }
        }
    }
}
