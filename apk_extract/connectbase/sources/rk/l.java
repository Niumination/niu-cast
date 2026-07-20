package rk;

import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kn.l0;
import kn.n0;
import lm.c1;
import lm.d1;
import lm.l2;
import nq.p;
import nq.q;
import os.m;
import p6.s;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final SelectorProvider f14549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14551c;

    public static final class a extends CancellationException {
        public a() {
            super("Closed selector");
        }
    }

    public static final class b extends n0 implements jn.l<Throwable, l2> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
            invoke2(th2);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@m Throwable th2) {
        }
    }

    public l() {
        SelectorProvider selectorProviderProvider = SelectorProvider.provider();
        l0.o(selectorProviderProvider, "provider()");
        this.f14549a = selectorProviderProvider;
    }

    public final void A(@os.l Selector selector, @os.l SelectionKey selectionKey, @os.l h hVar) {
        l0.p(selector, "selector");
        l0.p(selectionKey, cb.b.c.f1408o);
        l0.p(hVar, "attachment");
        k(hVar, new ClosedChannelException());
        selectionKey.attach(null);
        selector.wakeup();
    }

    @Override // rk.j
    @m
    public final Object K(@os.l h hVar, @os.l g gVar, @os.l um.d<? super l2> dVar) {
        if ((hVar.X() & gVar.getFlag()) == 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        q qVar = new q(wm.c.e(dVar), 1);
        qVar.F();
        qVar.H(b.INSTANCE);
        hVar.w().j(gVar, qVar);
        if (!qVar.isCancelled()) {
            O(hVar);
        }
        Object objZ = qVar.z();
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        if (objZ == aVar) {
            xm.h.c(dVar);
        }
        return objZ == aVar ? objZ : l2.f10208a;
    }

    public abstract void O(@os.l h hVar);

    public final void b(@os.l Selector selector, @os.l h hVar) {
        l0.p(selector, "selector");
        l0.p(hVar, s.f13016a);
        try {
            SelectableChannel selectableChannelA = hVar.a();
            SelectionKey selectionKeyKeyFor = selectableChannelA.keyFor(selector);
            int iX = hVar.X();
            if (selectionKeyKeyFor == null) {
                if (iX != 0) {
                    selectableChannelA.register(selector, iX, hVar);
                }
            } else if (selectionKeyKeyFor.interestOps() != iX) {
                selectionKeyKeyFor.interestOps(iX);
            }
            if (iX != 0) {
                this.f14550b++;
            }
        } catch (Throwable th2) {
            SelectionKey selectionKeyKeyFor2 = hVar.a().keyFor(selector);
            if (selectionKeyKeyFor2 != null) {
                selectionKeyKeyFor2.cancel();
            }
            k(hVar, th2);
        }
    }

    public final void c(@os.l Selector selector, @m Throwable th2) {
        l0.p(selector, "selector");
        if (th2 == null) {
            th2 = new a();
        }
        Set<SelectionKey> setKeys = selector.keys();
        l0.o(setKeys, "selector.keys()");
        for (SelectionKey selectionKey : setKeys) {
            try {
                if (selectionKey.isValid()) {
                    selectionKey.interestOps(0);
                }
            } catch (CancelledKeyException unused) {
            }
            Object objAttachment = selectionKey.attachment();
            h hVar = objAttachment instanceof h ? (h) objAttachment : null;
            if (hVar != null) {
                k(hVar, th2);
            }
            selectionKey.cancel();
        }
    }

    public final void e0(int i10) {
        this.f14551c = i10;
    }

    public final void g0(int i10) {
        this.f14550b = i10;
    }

    public final void k(@os.l h hVar, @os.l Throwable th2) {
        l0.p(hVar, "attachment");
        l0.p(th2, "t");
        c cVarW = hVar.w();
        g.Companion.getClass();
        g[] gVarArr = g.f14540a;
        int length = gVarArr.length;
        int i10 = 0;
        while (i10 < length) {
            g gVar = gVarArr[i10];
            i10++;
            p<l2> pVarR = cVarW.r(gVar);
            if (pVarR != null) {
                c1.a aVar = c1.Companion;
                pVarR.resumeWith(c1.m59constructorimpl(d1.a(th2)));
            }
        }
    }

    public final void k0(SelectionKey selectionKey, h hVar) {
        selectionKey.attach(hVar);
    }

    public final int n() {
        return this.f14551c;
    }

    public final int o() {
        return this.f14550b;
    }

    public final h p(SelectionKey selectionKey) {
        Object objAttachment = selectionKey.attachment();
        if (objAttachment instanceof h) {
            return (h) objAttachment;
        }
        return null;
    }

    public final void t(@os.l SelectionKey selectionKey) {
        p<l2> pVarQ;
        l0.p(selectionKey, cb.b.c.f1408o);
        try {
            int i10 = selectionKey.readyOps();
            int iInterestOps = selectionKey.interestOps();
            h hVarP = p(selectionKey);
            if (hVarP == null) {
                selectionKey.cancel();
                this.f14551c++;
                return;
            }
            l2 l2Var = l2.f10208a;
            c cVarW = hVarP.w();
            g.Companion.getClass();
            int[] iArr = g.f14541b;
            int length = iArr.length;
            int i11 = 0;
            while (i11 < length) {
                int i12 = i11 + 1;
                if ((iArr[i11] & i10) != 0 && (pVarQ = cVarW.q(i11)) != null) {
                    c1.a aVar = c1.Companion;
                    pVarQ.resumeWith(c1.m59constructorimpl(l2Var));
                }
                i11 = i12;
            }
            int i13 = (~i10) & iInterestOps;
            if (i13 != iInterestOps) {
                selectionKey.interestOps(i13);
            }
            if (i13 != 0) {
                this.f14550b++;
            }
        } catch (Throwable th2) {
            selectionKey.cancel();
            this.f14551c++;
            h hVarP2 = p(selectionKey);
            if (hVarP2 == null) {
                return;
            }
            k(hVarP2, th2);
            selectionKey.attach(null);
        }
    }

    public final void y(@os.l Set<SelectionKey> set, @os.l Set<? extends SelectionKey> set2) {
        l0.p(set, "selectedKeys");
        l0.p(set2, "keys");
        int size = set.size();
        this.f14550b = set2.size() - size;
        this.f14551c = 0;
        if (size > 0) {
            Iterator<SelectionKey> it = set.iterator();
            while (it.hasNext()) {
                t(it.next());
                it.remove();
            }
        }
    }

    @Override // rk.j
    @os.l
    public final SelectorProvider z() {
        return this.f14549a;
    }
}
