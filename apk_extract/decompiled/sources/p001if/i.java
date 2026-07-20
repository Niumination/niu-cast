package p001if;

import ad.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import k3.v8;
import ze.h;
import ze.r;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f5814a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f5817d;
    public int e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile b f5815b = new b(3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f5816c = new b(3);
    public final HashSet f = new HashSet();

    public i(m mVar) {
        this.f5814a = mVar;
    }

    public final void a(q qVar) {
        if (d() && !qVar.f) {
            qVar.u();
        } else if (!d() && qVar.f) {
            qVar.f = false;
            r rVar = qVar.f5837g;
            if (rVar != null) {
                qVar.f5838h.a(rVar);
                qVar.f5839i.g(h.INFO, "Subchannel unejected: {0}", qVar);
            }
        }
        qVar.e = this;
        this.f.add(qVar);
    }

    public final void b(long j8) {
        this.f5817d = Long.valueOf(j8);
        this.e++;
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((q) it.next()).u();
        }
    }

    public final long c() {
        return ((AtomicLong) this.f5816c.f93b).get() + ((AtomicLong) this.f5816c.f92a).get();
    }

    public final boolean d() {
        return this.f5817d != null;
    }

    public final void e() {
        v8.n(this.f5817d != null, "not currently ejected");
        this.f5817d = null;
        for (q qVar : this.f) {
            qVar.f = false;
            r rVar = qVar.f5837g;
            if (rVar != null) {
                qVar.f5838h.a(rVar);
                qVar.f5839i.g(h.INFO, "Subchannel unejected: {0}", qVar);
            }
        }
    }

    public final String toString() {
        return "AddressTracker{subchannels=" + this.f + '}';
    }
}
