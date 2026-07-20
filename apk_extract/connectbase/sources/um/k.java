package um;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kn.l0;
import kn.w;
import lm.c1;
import lm.f1;
import lm.z0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.3")
@z0
public final class k<T> implements d<T>, xm.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final a f16334b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater<k<?>, Object> f16335c = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "result");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final d<T> f16336a;

    @m
    private volatile Object result;

    public static final class a {
        public a() {
        }

        public static /* synthetic */ void a() {
        }

        public a(w wVar) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(@l d<? super T> dVar, @m Object obj) {
        l0.p(dVar, "delegate");
        this.f16336a = dVar;
        this.result = obj;
    }

    @m
    @z0
    public final Object a() throws Throwable {
        Object obj = this.result;
        wm.a aVar = wm.a.UNDECIDED;
        if (obj == aVar) {
            AtomicReferenceFieldUpdater<k<?>, Object> atomicReferenceFieldUpdater = f16335c;
            wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
            if (j.d.a(atomicReferenceFieldUpdater, this, aVar, aVar2)) {
                return aVar2;
            }
            obj = this.result;
        }
        if (obj == wm.a.RESUMED) {
            return wm.a.COROUTINE_SUSPENDED;
        }
        if (obj instanceof c1.b) {
            throw ((c1.b) obj).exception;
        }
        return obj;
    }

    @Override // xm.e
    @m
    public xm.e getCallerFrame() {
        d<T> dVar = this.f16336a;
        if (dVar instanceof xm.e) {
            return (xm.e) dVar;
        }
        return null;
    }

    @Override // um.d
    @l
    public g getContext() {
        return this.f16336a.getContext();
    }

    @Override // xm.e
    @m
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // um.d
    public void resumeWith(@l Object obj) {
        while (true) {
            Object obj2 = this.result;
            wm.a aVar = wm.a.UNDECIDED;
            if (obj2 != aVar) {
                wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
                if (obj2 != aVar2) {
                    throw new IllegalStateException("Already resumed");
                }
                if (j.d.a(f16335c, this, aVar2, wm.a.RESUMED)) {
                    this.f16336a.resumeWith(obj);
                    return;
                }
            } else if (j.d.a(f16335c, this, aVar, obj)) {
                return;
            }
        }
    }

    @l
    public String toString() {
        return "SafeContinuation for " + this.f16336a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @z0
    public k(@l d<? super T> dVar) {
        this(dVar, wm.a.UNDECIDED);
        l0.p(dVar, "delegate");
    }
}
