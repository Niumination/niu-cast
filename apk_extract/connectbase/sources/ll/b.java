package ll;

import fl.t0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
@t0
public abstract class b<T> extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f10136a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus");

    @l
    private volatile /* synthetic */ Object _consensus = d.f10144h;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ll.f
    @m
    public final Object a(@m Object obj) {
        Object objC = this._consensus;
        if (objC == d.f10144h) {
            objC = c(e(obj));
        }
        b(obj, objC);
        return objC;
    }

    public abstract void b(T t10, @m Object obj);

    public final Object c(Object obj) {
        return f(obj) ? obj : this._consensus;
    }

    public final boolean d() {
        return this._consensus != d.f10144h;
    }

    @m
    public abstract Object e(T t10);

    public final boolean f(@m Object obj) {
        if (obj != d.f10144h) {
            return j.d.a(f10136a, this, d.f10144h, obj);
        }
        throw new IllegalStateException("Check failed.");
    }
}
