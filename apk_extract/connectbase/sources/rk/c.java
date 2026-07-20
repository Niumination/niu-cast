package rk;

import fl.t0;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kn.l0;
import kn.w;
import kn.x0;
import lm.i0;
import lm.l2;
import nq.p;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final e f14514a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater<c, p<l2>>[] f14515b;

    @m
    private volatile p<? super l2> acceptHandlerReference;

    @m
    private volatile p<? super l2> connectHandlerReference;

    @m
    private volatile p<? super l2> readHandlerReference;

    @m
    private volatile p<? super l2> writeHandlerReference;

    public static final class e {
        public e() {
        }

        public static /* synthetic */ void b() {
        }

        public final AtomicReferenceFieldUpdater<c, p<l2>> c(g gVar) {
            return c.f14515b[gVar.ordinal()];
        }

        public e(w wVar) {
        }
    }

    public /* synthetic */ class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14516a;

        static {
            int[] iArr = new int[g.values().length];
            iArr[g.READ.ordinal()] = 1;
            iArr[g.WRITE.ordinal()] = 2;
            iArr[g.ACCEPT.ordinal()] = 3;
            iArr[g.CONNECT.ordinal()] = 4;
            f14516a = iArr;
        }
    }

    static {
        un.c cVar;
        g.Companion.getClass();
        g[] gVarArr = g.f14540a;
        ArrayList arrayList = new ArrayList(gVarArr.length);
        int length = gVarArr.length;
        int i10 = 0;
        while (i10 < length) {
            g gVar = gVarArr[i10];
            i10++;
            int i11 = f.f14516a[gVar.ordinal()];
            if (i11 == 1) {
                cVar = new x0() { // from class: rk.c.a
                    @Override // kn.x0, un.q
                    @m
                    public Object get(@m Object obj) {
                        return ((c) obj).readHandlerReference;
                    }

                    @Override // kn.x0, un.l
                    public void set(@m Object obj, @m Object obj2) {
                        ((c) obj).readHandlerReference = (p) obj2;
                    }
                };
            } else if (i11 == 2) {
                cVar = new x0() { // from class: rk.c.b
                    @Override // kn.x0, un.q
                    @m
                    public Object get(@m Object obj) {
                        return ((c) obj).writeHandlerReference;
                    }

                    @Override // kn.x0, un.l
                    public void set(@m Object obj, @m Object obj2) {
                        ((c) obj).writeHandlerReference = (p) obj2;
                    }
                };
            } else if (i11 == 3) {
                cVar = new x0() { // from class: rk.c.c
                    @Override // kn.x0, un.q
                    @m
                    public Object get(@m Object obj) {
                        return ((c) obj).acceptHandlerReference;
                    }

                    @Override // kn.x0, un.l
                    public void set(@m Object obj, @m Object obj2) {
                        ((c) obj).acceptHandlerReference = (p) obj2;
                    }
                };
            } else {
                if (i11 != 4) {
                    throw new i0();
                }
                cVar = new x0() { // from class: rk.c.d
                    @Override // kn.x0, un.q
                    @m
                    public Object get(@m Object obj) {
                        return ((c) obj).connectHandlerReference;
                    }

                    @Override // kn.x0, un.l
                    public void set(@m Object obj, @m Object obj2) {
                        ((c) obj).connectHandlerReference = (p) obj2;
                    }
                };
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdaterNewUpdater = AtomicReferenceFieldUpdater.newUpdater(c.class, p.class, cVar.getName());
            if (atomicReferenceFieldUpdaterNewUpdater == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.util.concurrent.atomic.AtomicReferenceFieldUpdater<io.ktor.network.selector.InterestSuspensionsMap, kotlinx.coroutines.CancellableContinuation<kotlin.Unit>?>");
            }
            arrayList.add(atomicReferenceFieldUpdaterNewUpdater);
        }
        Object[] array = arrayList.toArray(new AtomicReferenceFieldUpdater[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        f14515b = (AtomicReferenceFieldUpdater[]) array;
    }

    public static /* synthetic */ void k() {
    }

    public static /* synthetic */ void l() {
    }

    public static /* synthetic */ void m() {
    }

    public static /* synthetic */ void n() {
    }

    public final void j(@os.l g gVar, @os.l p<? super l2> pVar) {
        l0.p(gVar, "interest");
        l0.p(pVar, "continuation");
        if (j.d.a(f14514a.c(gVar), this, null, pVar)) {
            return;
        }
        throw new IllegalStateException("Handler for " + gVar.name() + " is already registered");
    }

    public final void o(int i10, @os.l jn.l<? super p<? super l2>, l2> lVar) {
        p<l2> pVarQ;
        l0.p(lVar, "block");
        g.Companion.getClass();
        int[] iArr = g.f14541b;
        int length = iArr.length;
        int i11 = 0;
        while (i11 < length) {
            int i12 = i11 + 1;
            if ((iArr[i11] & i10) != 0 && (pVarQ = q(i11)) != null) {
                lVar.invoke(pVarQ);
            }
            i11 = i12;
        }
    }

    public final void p(@os.l jn.p<? super p<? super l2>, ? super g, l2> pVar) {
        l0.p(pVar, "block");
        g.Companion.getClass();
        g[] gVarArr = g.f14540a;
        int length = gVarArr.length;
        int i10 = 0;
        while (i10 < length) {
            g gVar = gVarArr[i10];
            i10++;
            p<l2> pVarR = r(gVar);
            if (pVarR != null) {
                pVar.invoke(pVarR, gVar);
            }
        }
    }

    @m
    public final p<l2> q(int i10) {
        return f14515b[i10].getAndSet(this, null);
    }

    @m
    public final p<l2> r(@os.l g gVar) {
        l0.p(gVar, "interest");
        return f14514a.c(gVar).getAndSet(this, null);
    }

    @os.l
    public String toString() {
        return "R " + this.readHandlerReference + " W " + this.writeHandlerReference + " C " + this.connectHandlerReference + " A " + this.acceptHandlerReference;
    }
}
