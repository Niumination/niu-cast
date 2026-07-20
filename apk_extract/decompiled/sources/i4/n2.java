package i4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;
import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public final class n2 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5651b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s2 f5652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AtomicReferenceArray f5653d;
    public p2 e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public t3 f5654h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public t3 f5655i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ u3 f5656j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f5657k;

    public n2(u3 u3Var, int i8) {
        this.f5657k = i8;
        this.f5656j = u3Var;
        this.f5650a = u3Var.segments.length - 1;
        a();
    }

    public final void a() {
        this.f5654h = null;
        if (e() || f()) {
            return;
        }
        while (true) {
            int i8 = this.f5650a;
            if (i8 < 0) {
                return;
            }
            s2[] s2VarArr = this.f5656j.segments;
            this.f5650a = i8 - 1;
            s2 s2Var = s2VarArr[i8];
            this.f5652c = s2Var;
            if (s2Var.count != 0) {
                AtomicReferenceArray<p2> atomicReferenceArray = this.f5652c.table;
                this.f5653d = atomicReferenceArray;
                this.f5651b = atomicReferenceArray.length() - 1;
                if (f()) {
                    return;
                }
            }
        }
    }

    public final boolean b(p2 p2Var) {
        s2 s2Var;
        u3 u3Var = this.f5656j;
        try {
            Object key = p2Var.getKey();
            Object liveValue = u3Var.getLiveValue(p2Var);
            if (liveValue == null) {
                return false;
            }
            this.f5654h = new t3(u3Var, key, liveValue);
            return true;
        } finally {
            this.f5652c.postReadCleanup();
        }
    }

    public final Object c() {
        return d();
    }

    public final t3 d() {
        t3 t3Var = this.f5654h;
        if (t3Var == null) {
            throw new NoSuchElementException();
        }
        this.f5655i = t3Var;
        a();
        return this.f5655i;
    }

    public final boolean e() {
        p2 p2Var = this.e;
        if (p2Var == null) {
            return false;
        }
        while (true) {
            this.e = p2Var.c();
            p2 p2Var2 = this.e;
            if (p2Var2 == null) {
                return false;
            }
            if (b(p2Var2)) {
                return true;
            }
            p2Var = this.e;
        }
    }

    public final boolean f() {
        while (true) {
            int i8 = this.f5651b;
            if (i8 < 0) {
                return false;
            }
            AtomicReferenceArray atomicReferenceArray = this.f5653d;
            this.f5651b = i8 - 1;
            p2 p2Var = (p2) atomicReferenceArray.get(i8);
            this.e = p2Var;
            if (p2Var != null && (b(p2Var) || e())) {
                return true;
            }
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5654h != null;
    }

    @Override // java.util.Iterator
    public Object next() {
        switch (this.f5657k) {
            case 1:
                return d().f5695a;
            case 2:
                return d().f5696b;
            default:
                return c();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        v8.n(this.f5655i != null, "no calls to next() since the last call to remove()");
        this.f5656j.remove(this.f5655i.f5695a);
        this.f5655i = null;
    }
}
