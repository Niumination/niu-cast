package bl;

import al.i;
import androidx.core.app.NotificationCompat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kn.l0;
import nq.l2;
import os.l;
import pq.f0;
import pq.g0;
import pq.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final pq.l<C0029a> f940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final f0<C0029a> f941d;

    /* JADX INFO: renamed from: bl.a$a, reason: collision with other inner class name */
    public static final class C0029a extends ll.e {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f942f = AtomicIntegerFieldUpdater.newUpdater(C0029a.class, "scheduled");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @l
        public final i f943d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @l
        public final l2 f944e;

        @l
        private volatile /* synthetic */ int scheduled;

        public C0029a(@l i iVar) {
            l0.p(iVar, NotificationCompat.CATEGORY_CALL);
            this.f943d = iVar;
            this.scheduled = 0;
            this.f944e = iVar.p().f385k;
        }

        public final boolean N() {
            int i10;
            do {
                i10 = this.scheduled;
                if (i10 != 0) {
                    return i10 == 1;
                }
            } while (!f942f.compareAndSet(this, i10, 1));
            i iVar = this.f943d;
            iVar.f340c.fireChannelRead((Object) iVar);
            return true;
        }

        @l
        public final i O() {
            return this.f943d;
        }

        public final boolean P() {
            return this.f944e.isCompleted();
        }

        public final void Q() {
            if (f942f.compareAndSet(this, 0, 2)) {
                this.f943d.j();
            }
        }
    }

    public a(int i10, int i11) {
        this.f938a = i10;
        this.f939b = i11;
        if (i10 <= 0) {
            throw new IllegalArgumentException(l0.C("readLimit should be positive: ", Integer.valueOf(i10)).toString());
        }
        if (i11 <= 0) {
            throw new IllegalArgumentException(l0.C("executeLimit should be positive: ", Integer.valueOf(i11)).toString());
        }
        pq.l<C0029a> lVarD = o.d(Integer.MAX_VALUE, null, null, 6, null);
        this.f940c = lVarD;
        this.f941d = lVarD;
    }

    public final boolean a() {
        return this.f940c.isEmpty();
    }

    public final void b() {
        lm.l2 l2Var;
        g0.a.a(this.f940c, null, 1, null);
        do {
            C0029a c0029aPoll = this.f940c.poll();
            if (c0029aPoll == null) {
                l2Var = null;
            } else {
                c0029aPoll.Q();
                l2Var = lm.l2.f10208a;
            }
        } while (l2Var != null);
    }

    public final void c() {
        g0.a.a(this.f940c, null, 1, null);
    }

    @l
    public final f0<C0029a> d() {
        return this.f941d;
    }

    public final int e() {
        return this.f938a;
    }

    public final int f() {
        return this.f939b;
    }

    public final void g(@l i iVar) {
        l0.p(iVar, NotificationCompat.CATEGORY_CALL);
        C0029a c0029a = new C0029a(iVar);
        try {
            this.f940c.offer(c0029a);
        } catch (Throwable unused) {
            c0029a.Q();
        }
    }
}
