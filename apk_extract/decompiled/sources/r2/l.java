package r2;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import mg.b0;

/* JADX INFO: loaded from: classes.dex */
public final class l implements q2.g, q2.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q2.c f9341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f9342d;
    public final f5.a e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f9344h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final t f9345i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f9346j;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ c f9350n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList f9340b = new LinkedList();
    public final HashSet f = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap f9343g = new HashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f9347k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ConnectionResult f9348l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f9349m = 0;

    public l(c cVar, q2.f fVar) {
        this.f9350n = cVar;
        Looper looper = cVar.f9334o.getLooper();
        u6.a aVarA = fVar.a();
        c2.k kVar = new c2.k((String) aVarA.f10380d, (ArraySet) aVarA.f10378b, (String) aVarA.f10379c);
        o3.b bVar = (o3.b) fVar.f8946c.f10388c;
        u2.l.e(bVar);
        q2.c cVarA = bVar.a(fVar.f8944a, looper, kVar, fVar.f8947d, this, this);
        String str = fVar.f8945b;
        if (str != null && (cVarA instanceof com.google.android.gms.common.internal.a)) {
            ((com.google.android.gms.common.internal.a) cVarA).f1890t = str;
        }
        if (str != null && (cVarA instanceof g)) {
            o.d.y(cVarA);
            throw null;
        }
        this.f9341c = cVarA;
        this.f9342d = fVar.e;
        this.e = new f5.a(5);
        this.f9344h = fVar.f;
        if (!cVarA.e()) {
            this.f9345i = null;
            return;
        }
        Context context = cVar.e;
        h3.e eVar = cVar.f9334o;
        u6.a aVarA2 = fVar.a();
        this.f9345i = new t(context, eVar, new c2.k((String) aVarA2.f10380d, (ArraySet) aVarA2.f10378b, (String) aVarA2.f10379c));
    }

    public final void a(ConnectionResult connectionResult) {
        HashSet hashSet = this.f;
        Iterator it = hashSet.iterator();
        if (!it.hasNext()) {
            hashSet.clear();
        } else {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (u2.l.h(connectionResult, ConnectionResult.e)) {
                this.f9341c.b();
            }
            throw null;
        }
    }

    public final void b(Status status) {
        u2.l.b(this.f9350n.f9334o);
        c(status, null, false);
    }

    public final void c(Status status, RuntimeException runtimeException, boolean z2) {
        u2.l.b(this.f9350n.f9334o);
        if ((status == null) == (runtimeException == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f9340b.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            if (!z2 || oVar.f9353a == 2) {
                if (status != null) {
                    oVar.c(status);
                } else {
                    oVar.d(runtimeException);
                }
                it.remove();
            }
        }
    }

    public final void d() {
        LinkedList linkedList = this.f9340b;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            o oVar = (o) arrayList.get(i8);
            if (!this.f9341c.g()) {
                return;
            }
            if (j(oVar)) {
                linkedList.remove(oVar);
            }
        }
    }

    @Override // q2.g
    public final void e(int i8) {
        Looper looperMyLooper = Looper.myLooper();
        c cVar = this.f9350n;
        if (looperMyLooper == cVar.f9334o.getLooper()) {
            h(i8);
        } else {
            cVar.f9334o.post(new af.g(i8, 2, this));
        }
    }

    public final void f() {
        c cVar = this.f9350n;
        u2.l.b(cVar.f9334o);
        this.f9348l = null;
        a(ConnectionResult.e);
        if (this.f9346j) {
            h3.e eVar = cVar.f9334o;
            a aVar = this.f9342d;
            eVar.removeMessages(11, aVar);
            cVar.f9334o.removeMessages(9, aVar);
            this.f9346j = false;
        }
        Iterator it = this.f9343g.values().iterator();
        if (it.hasNext()) {
            throw null;
        }
        d();
        i();
    }

    @Override // q2.h
    public final void g(ConnectionResult connectionResult) {
        n(connectionResult, null);
    }

    public final void h(int i8) {
        c cVar = this.f9350n;
        u2.l.b(cVar.f9334o);
        this.f9348l = null;
        this.f9346j = true;
        String strK = this.f9341c.k();
        f5.a aVar = this.e;
        aVar.getClass();
        StringBuilder sb2 = new StringBuilder("The connection to Google Play services was lost");
        if (i8 == 1) {
            sb2.append(" due to service disconnection.");
        } else if (i8 == 3) {
            sb2.append(" due to dead object exception.");
        }
        if (strK != null) {
            sb2.append(" Last reason for disconnect: ");
            sb2.append(strK);
        }
        aVar.i(true, new Status(20, sb2.toString()));
        h3.e eVar = cVar.f9334o;
        a aVar2 = this.f9342d;
        eVar.sendMessageDelayed(Message.obtain(eVar, 9, aVar2), CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        h3.e eVar2 = cVar.f9334o;
        eVar2.sendMessageDelayed(Message.obtain(eVar2, 11, aVar2), 120000L);
        ((SparseIntArray) cVar.f9328i.f11095a).clear();
        Iterator it = this.f9343g.values().iterator();
        while (it.hasNext()) {
            ((s) it.next()).getClass();
        }
    }

    public final void i() {
        c cVar = this.f9350n;
        h3.e eVar = cVar.f9334o;
        a aVar = this.f9342d;
        eVar.removeMessages(12, aVar);
        h3.e eVar2 = cVar.f9334o;
        eVar2.sendMessageDelayed(eVar2.obtainMessage(12, aVar), cVar.f9323a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean j(o oVar) {
        Feature feature;
        if (oVar == null) {
            q2.c cVar = this.f9341c;
            oVar.f(this.e, cVar.e());
            try {
                oVar.e(this);
            } catch (DeadObjectException unused) {
                e(1);
                cVar.disconnect("DeadObjectException thrown while running ApiCallRunner.");
            }
            return true;
        }
        Feature[] featureArrB = oVar.b(this);
        if (featureArrB == null || featureArrB.length == 0) {
            feature = null;
            break;
        }
        Feature[] featureArrJ = this.f9341c.j();
        if (featureArrJ == null) {
            featureArrJ = new Feature[0];
        }
        ArrayMap arrayMap = new ArrayMap(featureArrJ.length);
        for (Feature feature2 : featureArrJ) {
            arrayMap.put(feature2.f1804a, Long.valueOf(feature2.g()));
        }
        int length = featureArrB.length;
        int i8 = 0;
        while (true) {
            if (i8 >= length) {
                feature = null;
                break;
            }
            feature = featureArrB[i8];
            Long l4 = (Long) arrayMap.get(feature.f1804a);
            if (l4 == null || l4.longValue() < feature.g()) {
                break;
            }
            i8++;
        }
        if (feature == null) {
            q2.c cVar2 = this.f9341c;
            oVar.f(this.e, cVar2.e());
            try {
                oVar.e(this);
            } catch (DeadObjectException unused2) {
                e(1);
                cVar2.disconnect("DeadObjectException thrown while running ApiCallRunner.");
            }
            return true;
        }
        Log.w("GoogleApiManager", this.f9341c.getClass().getName() + " could not execute call because it requires feature (" + feature.f1804a + ", " + feature.g() + ").");
        if (!this.f9350n.p || !oVar.a(this)) {
            oVar.d(new q2.l(feature));
            return true;
        }
        m mVar = new m(this.f9342d, feature);
        int iIndexOf = this.f9347k.indexOf(mVar);
        if (iIndexOf >= 0) {
            m mVar2 = (m) this.f9347k.get(iIndexOf);
            this.f9350n.f9334o.removeMessages(15, mVar2);
            h3.e eVar = this.f9350n.f9334o;
            Message messageObtain = Message.obtain(eVar, 15, mVar2);
            this.f9350n.getClass();
            eVar.sendMessageDelayed(messageObtain, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        } else {
            this.f9347k.add(mVar);
            h3.e eVar2 = this.f9350n.f9334o;
            Message messageObtain2 = Message.obtain(eVar2, 15, mVar);
            this.f9350n.getClass();
            eVar2.sendMessageDelayed(messageObtain2, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
            h3.e eVar3 = this.f9350n.f9334o;
            Message messageObtain3 = Message.obtain(eVar3, 16, mVar);
            this.f9350n.getClass();
            eVar3.sendMessageDelayed(messageObtain3, 120000L);
            ConnectionResult connectionResult = new ConnectionResult(2, null);
            if (!k(connectionResult)) {
                this.f9350n.b(connectionResult, this.f9344h);
            }
        }
        return false;
    }

    public final boolean k(ConnectionResult connectionResult) {
        synchronized (c.f9321s) {
            this.f9350n.getClass();
        }
        return false;
    }

    public final void l() {
        c cVar = this.f9350n;
        u2.l.b(cVar.f9334o);
        q2.c cVar2 = this.f9341c;
        if (cVar2.g() || cVar2.a()) {
            return;
        }
        try {
            y6.g gVar = cVar.f9328i;
            Context context = cVar.e;
            gVar.getClass();
            u2.l.e(context);
            int iH = cVar2.h();
            SparseIntArray sparseIntArray = (SparseIntArray) gVar.f11095a;
            int iC = sparseIntArray.get(iH, -1);
            if (iC == -1) {
                iC = 0;
                int i8 = 0;
                while (true) {
                    if (i8 >= sparseIntArray.size()) {
                        iC = -1;
                        break;
                    }
                    int iKeyAt = sparseIntArray.keyAt(i8);
                    if (iKeyAt > iH && sparseIntArray.get(iKeyAt) == 0) {
                        break;
                    } else {
                        i8++;
                    }
                }
                if (iC == -1) {
                    iC = ((p2.a) gVar.f11096b).c(context, iH);
                }
                sparseIntArray.put(iH, iC);
            }
            if (iC != 0) {
                ConnectionResult connectionResult = new ConnectionResult(iC, null);
                Log.w("GoogleApiManager", "The service for " + cVar2.getClass().getName() + " is not available: " + connectionResult.toString());
                n(connectionResult, null);
                return;
            }
            b0 b0Var = new b0(cVar, cVar2, this.f9342d);
            if (cVar2.e()) {
                t tVar = this.f9345i;
                u2.l.e(tVar);
                p3.a aVar = tVar.f9369h;
                if (aVar != null) {
                    aVar.disconnect();
                }
                Integer numValueOf = Integer.valueOf(System.identityHashCode(tVar));
                c2.k kVar = tVar.f9368g;
                kVar.f1408b = numValueOf;
                h3.e eVar = tVar.f9367d;
                tVar.f9369h = (p3.a) tVar.e.a(tVar.f9366c, eVar.getLooper(), kVar, (o3.a) kVar.f1411g, tVar, tVar);
                tVar.f9370i = b0Var;
                Set set = tVar.f;
                if (set == null || set.isEmpty()) {
                    eVar.post(new af.f(tVar, 29));
                } else {
                    p3.a aVar2 = tVar.f9369h;
                    aVar2.getClass();
                    aVar2.c(new u2.e(aVar2));
                }
            }
            try {
                cVar2.c(b0Var);
            } catch (SecurityException e) {
                n(new ConnectionResult(10), e);
            }
        } catch (IllegalStateException e4) {
            n(new ConnectionResult(10), e4);
        }
    }

    public final void m(o oVar) {
        u2.l.b(this.f9350n.f9334o);
        boolean zG = this.f9341c.g();
        LinkedList linkedList = this.f9340b;
        if (zG) {
            if (j(oVar)) {
                i();
                return;
            } else {
                linkedList.add(oVar);
                return;
            }
        }
        linkedList.add(oVar);
        ConnectionResult connectionResult = this.f9348l;
        if (connectionResult == null || connectionResult.f1798b == 0 || connectionResult.f1799c == null) {
            l();
        } else {
            n(connectionResult, null);
        }
    }

    public final void n(ConnectionResult connectionResult, RuntimeException runtimeException) {
        p3.a aVar;
        u2.l.b(this.f9350n.f9334o);
        t tVar = this.f9345i;
        if (tVar != null && (aVar = tVar.f9369h) != null) {
            aVar.disconnect();
        }
        u2.l.b(this.f9350n.f9334o);
        this.f9348l = null;
        ((SparseIntArray) this.f9350n.f9328i.f11095a).clear();
        a(connectionResult);
        if ((this.f9341c instanceof w2.c) && connectionResult.f1798b != 24) {
            c cVar = this.f9350n;
            cVar.f9324b = true;
            h3.e eVar = cVar.f9334o;
            eVar.sendMessageDelayed(eVar.obtainMessage(19), PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
        }
        if (connectionResult.f1798b == 4) {
            b(c.f9320r);
            return;
        }
        if (this.f9340b.isEmpty()) {
            this.f9348l = connectionResult;
            return;
        }
        if (runtimeException != null) {
            u2.l.b(this.f9350n.f9334o);
            c(null, runtimeException, false);
            return;
        }
        if (!this.f9350n.p) {
            b(c.c(this.f9342d, connectionResult));
            return;
        }
        c(c.c(this.f9342d, connectionResult), null, true);
        if (this.f9340b.isEmpty() || k(connectionResult) || this.f9350n.b(connectionResult, this.f9344h)) {
            return;
        }
        if (connectionResult.f1798b == 18) {
            this.f9346j = true;
        }
        if (!this.f9346j) {
            b(c.c(this.f9342d, connectionResult));
            return;
        }
        h3.e eVar2 = this.f9350n.f9334o;
        Message messageObtain = Message.obtain(eVar2, 9, this.f9342d);
        this.f9350n.getClass();
        eVar2.sendMessageDelayed(messageObtain, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
    }

    public final void o() {
        u2.l.b(this.f9350n.f9334o);
        Status status = c.q;
        b(status);
        this.e.i(false, status);
        for (f fVar : (f[]) this.f9343g.keySet().toArray(new f[0])) {
            m(new v(fVar, new q3.g()));
        }
        a(new ConnectionResult(4));
        q2.c cVar = this.f9341c;
        if (cVar.g()) {
            cVar.i(new se.e(this, 17));
        }
    }

    @Override // q2.g
    public final void onConnected() {
        Looper looperMyLooper = Looper.myLooper();
        c cVar = this.f9350n;
        if (looperMyLooper == cVar.f9334o.getLooper()) {
            f();
        } else {
            cVar.f9334o.post(new af.f(this, 27));
        }
    }
}
