package pq;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kn.l0;
import kn.r1;
import lm.l2;
import nq.b4;
import q1.w2;
import vq.r0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/ChannelSegment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,3055:1\n1#2:3056\n*E\n"})
public final class q<E> extends r0<q<E>> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.m
    public final j<E> f13312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final AtomicReferenceArray f13313f;

    public q(long j10, @os.m q<E> qVar, @os.m j<E> jVar, int i10) {
        super(j10, qVar, i10);
        this.f13312e = jVar;
        this.f13313f = new AtomicReferenceArray(k.f13267b * 2);
    }

    public final E A(int i10) {
        E eX = x(i10);
        B(i10, null);
        return eX;
    }

    public final void B(int i10, Object obj) {
        this.f13313f.lazySet(i10 * 2, obj);
    }

    public final void C(int i10, @os.m Object obj) {
        this.f13313f.set((i10 * 2) + 1, obj);
    }

    public final void D(int i10, E e10) {
        B(i10, e10);
    }

    @Override // vq.r0
    public int p() {
        return k.f13267b;
    }

    @Override // vq.r0
    public void q(int i10, @os.m Throwable th2, @os.l um.g gVar) throws IllegalAccessException, InvocationTargetException {
        int i11 = k.f13267b;
        boolean z10 = i10 >= i11;
        if (z10) {
            i10 -= i11;
        }
        E eX = x(i10);
        while (true) {
            Object objY = y(i10);
            if ((objY instanceof b4) || (objY instanceof j0)) {
                if (t(i10, objY, z10 ? k.f13277l : k.f13278m)) {
                    B(i10, null);
                    z(i10, !z10);
                    if (z10) {
                        j<E> jVar = this.f13312e;
                        l0.m(jVar);
                        jn.l<E, l2> lVar = jVar.f13258b;
                        if (lVar != null) {
                            vq.l0.b(lVar, eX, gVar);
                            return;
                        }
                        return;
                    }
                    return;
                }
            } else {
                if (objY == k.f13277l || objY == k.f13278m) {
                    break;
                }
                if (objY != k.f13274i && objY != k.f13273h) {
                    if (objY == k.f13276k || objY == k.f13271f || objY == k.f13279n) {
                        return;
                    }
                    throw new IllegalStateException(("unexpected state: " + objY).toString());
                }
            }
        }
        B(i10, null);
        if (z10) {
            j<E> jVar2 = this.f13312e;
            l0.m(jVar2);
            jn.l<E, l2> lVar2 = jVar2.f13258b;
            if (lVar2 != null) {
                vq.l0.b(lVar2, eX, gVar);
            }
        }
    }

    public final boolean t(int i10, @os.m Object obj, @os.m Object obj2) {
        return w2.a(this.f13313f, (i10 * 2) + 1, obj, obj2);
    }

    public final void u(int i10) {
        B(i10, null);
    }

    @os.m
    public final Object v(int i10, @os.m Object obj) {
        return this.f13313f.getAndSet((i10 * 2) + 1, obj);
    }

    @os.l
    public final j<E> w() {
        j<E> jVar = this.f13312e;
        l0.m(jVar);
        return jVar;
    }

    public final E x(int i10) {
        return (E) this.f13313f.get(i10 * 2);
    }

    @os.m
    public final Object y(int i10) {
        return this.f13313f.get((i10 * 2) + 1);
    }

    public final void z(int i10, boolean z10) {
        if (z10) {
            j<E> jVar = this.f13312e;
            l0.m(jVar);
            jVar.H1((this.f17877c * ((long) k.f13267b)) + ((long) i10));
        }
        r();
    }
}
