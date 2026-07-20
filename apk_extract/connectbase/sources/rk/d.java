package rk;

import fl.t0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kn.l0;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class d<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f14517a = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_cur");

    @os.l
    private volatile /* synthetic */ Object _cur = new e(8);

    public final boolean a(@os.l E e10) {
        l0.p(e10, "element");
        while (true) {
            e eVar = (e) this._cur;
            int iA = eVar.a(e10);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                j.d.a(f14517a, this, eVar, eVar.h());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            e eVar = (e) this._cur;
            if (eVar.d()) {
                return;
            } else {
                j.d.a(f14517a, this, eVar, eVar.h());
            }
        }
    }

    public final boolean c() {
        return ((e) this._cur).f();
    }

    @m
    public final E d() {
        while (true) {
            e eVar = (e) this._cur;
            E e10 = (E) eVar.i();
            if (e10 != e.f14532r) {
                return e10;
            }
            j.d.a(f14517a, this, eVar, eVar.h());
        }
    }
}
