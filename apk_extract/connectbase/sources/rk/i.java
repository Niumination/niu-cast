package rk;

import java.nio.channels.SelectableChannel;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kn.l0;
import kn.w;
import lm.c1;
import lm.d1;
import lm.l2;
import nq.p;

/* JADX INFO: loaded from: classes2.dex */
public class i implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final a f14544c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final AtomicIntegerFieldUpdater<i> f14545d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final SelectableChannel f14546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final c f14547b;
    private volatile int interestedOps;

    public static final class a {
        public a() {
        }

        @os.l
        public final AtomicIntegerFieldUpdater<i> a() {
            return i.f14545d;
        }

        public a(w wVar) {
        }
    }

    static {
        AtomicIntegerFieldUpdater<i> atomicIntegerFieldUpdaterNewUpdater = AtomicIntegerFieldUpdater.newUpdater(i.class, "interestedOps");
        l0.m(atomicIntegerFieldUpdaterNewUpdater);
        f14545d = atomicIntegerFieldUpdaterNewUpdater;
    }

    public i(@os.l SelectableChannel selectableChannel) {
        l0.p(selectableChannel, "channel");
        this.f14546a = selectableChannel;
        this.f14547b = new c();
    }

    public void A(int i10) {
        this.interestedOps = i10;
    }

    @Override // rk.h
    public int X() {
        return this.interestedOps;
    }

    @Override // rk.h
    @os.l
    public SelectableChannel a() {
        return this.f14546a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        int i10 = 0;
        A(0);
        c cVarW = w();
        g.Companion.getClass();
        g[] gVarArr = g.f14540a;
        int length = gVarArr.length;
        while (i10 < length) {
            g gVar = gVarArr[i10];
            i10++;
            p<l2> pVarR = cVarW.r(gVar);
            if (pVarR != null) {
                c1.a aVar = c1.Companion;
                pVarR.resumeWith(c1.m59constructorimpl(d1.a(new b())));
            }
        }
    }

    @Override // nq.n1
    public void dispose() {
        close();
    }

    @Override // rk.h
    public void e2(@os.l g gVar, boolean z10) {
        int iX;
        l0.p(gVar, "interest");
        int flag = gVar.getFlag();
        do {
            iX = X();
        } while (!f14545d.compareAndSet(this, iX, z10 ? iX | flag : (~flag) & iX));
    }

    @Override // rk.h
    @os.l
    public c w() {
        return this.f14547b;
    }
}
