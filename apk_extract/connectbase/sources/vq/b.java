package vq;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kn.r1;
import nq.g2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nAtomic.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Atomic.kt\nkotlinx/coroutines/internal/AtomicOp\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
@g2
public abstract class b<T> extends m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f17800a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus");

    @os.m
    @in.x
    private volatile Object _consensus = a.f17789a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vq.m0
    @os.l
    public b<?> a() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vq.m0
    @os.m
    public final Object b(@os.m Object obj) {
        Object objD = f17800a.get(this);
        if (objD == a.f17789a) {
            objD = d(e(obj));
        }
        c(obj, objD);
        return objD;
    }

    public abstract void c(T t10, @os.m Object obj);

    public final Object d(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17800a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        Object obj3 = a.f17789a;
        if (obj2 != obj3) {
            return obj2;
        }
        return j.d.a(atomicReferenceFieldUpdater, this, obj3, obj) ? obj : atomicReferenceFieldUpdater.get(this);
    }

    @os.m
    public abstract Object e(T t10);
}
