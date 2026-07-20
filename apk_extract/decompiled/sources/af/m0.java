package af;

import android.graphics.Rect;
import android.os.Handler;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import com.transsion.widgetslib.widget.FootOperationBar;
import com.welink.protocol.nfbd.NearDevice;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import k3.be;
import k3.dd;
import k3.ja;
import k3.la;
import k3.q9;
import k3.sc;
import k3.yd;

/* JADX INFO: loaded from: classes3.dex */
public final class m0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f451d;

    public /* synthetic */ m0(Object obj, int i8, Object obj2, Object obj3) {
        this.f448a = i8;
        this.f451d = obj;
        this.f450c = obj2;
        this.f449b = obj3;
    }

    /* JADX WARN: Code duplicated, block: B:69:0x0331  */
    @Override // java.lang.Runnable
    public final void run() {
        cf.q qVar;
        cf.p pVar;
        Socket socketI;
        SSLSession session;
        Socket socket;
        Iterator it;
        long j8;
        m0 m0Var = this;
        switch (m0Var.f448a) {
            case 0:
                ((e3) m0Var.f451d).f.f((ze.f0) m0Var.f450c, (ze.p1) m0Var.f449b);
                return;
            case 1:
                ((q0) m0Var.f451d).f522a.f((ze.q2) m0Var.f450c, (ze.p1) m0Var.f449b);
                return;
            case 2:
                a3 a3Var = (a3) m0Var.f451d;
                j3 j3Var = a3Var.f141b;
                if (a3Var != j3Var.f364w) {
                    return;
                }
                ze.z0 z0Var = (ze.z0) m0Var.f450c;
                j3Var.f365x = z0Var;
                j3Var.D.h(z0Var);
                ze.q qVar2 = ze.q.SHUTDOWN;
                ze.q qVar3 = (ze.q) m0Var.f449b;
                if (qVar3 != qVar2) {
                    a3Var.f141b.N.g(ze.h.INFO, "Entering {0} state with picker: {1}", qVar3, z0Var);
                    a3Var.f141b.f360r.b(qVar3);
                    return;
                }
                return;
            case 3:
                s3 s3Var = (s3) m0Var.f451d;
                if (!s3Var.f) {
                    ((cf.c0) m0Var.f449b).run();
                    s3Var.f576b = null;
                    return;
                } else {
                    if (s3Var.f579g) {
                        return;
                    }
                    s3Var.f576b = ((ScheduledExecutorService) m0Var.f450c).schedule(s3Var.f577c, s3Var.e - System.nanoTime(), TimeUnit.NANOSECONDS);
                    s3Var.f = false;
                    return;
                }
            case 4:
                try {
                    ((CountDownLatch) m0Var.f450c).await();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                qj.t tVarB = sc.b(new cf.o());
                try {
                    try {
                        cf.q qVar4 = (cf.q) m0Var.f451d;
                        ze.i0 i0Var = qVar4.N;
                        if (i0Var == null) {
                            socketI = qVar4.A.createSocket(qVar4.f1611a.getAddress(), ((cf.q) m0Var.f451d).f1611a.getPort());
                        } else {
                            if (!(i0Var.getProxyAddress() instanceof InetSocketAddress)) {
                                throw new ze.r2(ze.q2.f11410m.h("Unsupported SocketAddress implementation " + ((cf.q) m0Var.f451d).N.getProxyAddress().getClass()));
                            }
                            cf.q qVar5 = (cf.q) m0Var.f451d;
                            socketI = cf.q.i(qVar5, qVar5.N.getTargetAddress(), (InetSocketAddress) ((cf.q) m0Var.f451d).N.getProxyAddress(), ((cf.q) m0Var.f451d).N.getUsername(), ((cf.q) m0Var.f451d).N.getPassword());
                        }
                        cf.q qVar6 = (cf.q) m0Var.f451d;
                        SSLSocketFactory sSLSocketFactory = qVar6.B;
                        if (sSLSocketFactory != null) {
                            String host = qVar6.f1612b;
                            URI uriA = l1.a(host);
                            if (uriA.getHost() != null) {
                                host = uriA.getHost();
                            }
                            SSLSocket sSLSocketA = cf.i0.a(sSLSocketFactory, socketI, host, ((cf.q) m0Var.f451d).l(), ((cf.q) m0Var.f451d).E);
                            session = sSLSocketA.getSession();
                            socket = sSLSocketA;
                        } else {
                            session = null;
                            socket = socketI;
                        }
                        socket.setTcpNoDelay(true);
                        qj.t tVarB2 = sc.b(sc.f(socket));
                        ((cf.c) m0Var.f449b).a(sc.d(socket), socket);
                        cf.q qVar7 = (cf.q) m0Var.f451d;
                        n6.a aVarA = qVar7.u.a();
                        aVarA.j(ze.i.f11361a, socket.getRemoteSocketAddress());
                        aVarA.j(ze.i.f11362b, socket.getLocalSocketAddress());
                        aVarA.j(ze.i.f11363c, session);
                        aVarA.j(d6.f221a, session == null ? ze.a2.NONE : ze.a2.PRIVACY_AND_INTEGRITY);
                        qVar7.u = aVarA.g();
                        cf.q qVar8 = (cf.q) m0Var.f451d;
                        qVar8.f1615g.getClass();
                        qVar8.f1626t = new cf.p(qVar8, new ef.k(tVarB2, true));
                        synchronized (((cf.q) m0Var.f451d).f1619k) {
                            try {
                                ((cf.q) m0Var.f451d).getClass();
                                if (session != null) {
                                    cf.q qVar9 = (cf.q) m0Var.f451d;
                                    new ze.p2(session);
                                    qVar9.getClass();
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                            break;
                        }
                        return;
                    } catch (Throwable th3) {
                        cf.q qVar10 = (cf.q) m0Var.f451d;
                        qVar10.f1615g.getClass();
                        qVar10.f1626t = new cf.p(qVar10, new ef.k(tVarB, true));
                        throw th3;
                    }
                } catch (ze.r2 e) {
                    ((cf.q) m0Var.f451d).r(0, ef.a.INTERNAL_ERROR, e.getStatus());
                    qVar = (cf.q) m0Var.f451d;
                    qVar.f1615g.getClass();
                    pVar = new cf.p(qVar, new ef.k(tVarB, true));
                    qVar.f1626t = pVar;
                    return;
                } catch (Exception e4) {
                    ((cf.q) m0Var.f451d).b(e4);
                    qVar = (cf.q) m0Var.f451d;
                    qVar.f1615g.getClass();
                    pVar = new cf.p(qVar, new ef.k(tVarB, true));
                    qVar.f1626t = pVar;
                    return;
                }
                break;
            case 5:
                if (e8.b.f4711h > 0) {
                    if (dd.l(e8.b.f4712i)) {
                        if (((SimpleDateFormat) m0Var.f449b) == null) {
                            m0Var.f449b = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
                        }
                        String str = ((SimpleDateFormat) m0Var.f449b).format(new Date());
                        if (!str.equals((String) m0Var.f451d)) {
                            for (Integer num : t6.d.f10185b) {
                                if (num.intValue() != 9999) {
                                    e8.b.n(num.intValue()).o("app_heartbeat", null, num.intValue());
                                }
                            }
                            m0Var.f451d = str;
                        }
                    }
                    ((Handler) m0Var.f450c).postDelayed(m0Var, 3600000L);
                    return;
                }
                return;
            case 6:
                h2.a aVar = (h2.a) m0Var.f450c;
                d2.d dVar = (d2.d) m0Var.f449b;
                String str2 = dVar.f4269a;
                d2.b bVar = (d2.b) m0Var.f451d;
                Logger logger = h2.a.f;
                try {
                    e2.g gVarA = aVar.f5232c.a(str2);
                    if (gVarA == null) {
                        String str3 = "Transport backend '" + str2 + "' is not registered";
                        logger.warning(str3);
                        new IllegalArgumentException(str3);
                    } else {
                        ((j2.h) aVar.e).h(new qf.c(aVar, 6, dVar, ((b2.d) gVarA).a(bVar)));
                    }
                    return;
                } catch (Exception e10) {
                    logger.warning("Error scheduling event " + e10.getMessage());
                    return;
                }
            case 7:
                p001if.r rVar = (p001if.r) m0Var.f451d;
                rVar.f5846j = Long.valueOf(rVar.f5843g.g());
                for (p001if.i iVar : ((p001if.r) m0Var.f451d).f5842d.f5818a.values()) {
                    ad.b bVar2 = iVar.f5816c;
                    ((AtomicLong) bVar2.f92a).set(0L);
                    ((AtomicLong) bVar2.f93b).set(0L);
                    ad.b bVar3 = iVar.f5815b;
                    iVar.f5815b = iVar.f5816c;
                    iVar.f5816c = bVar3;
                }
                p001if.m mVar = (p001if.m) m0Var.f450c;
                ze.i iVar2 = (ze.i) m0Var.f449b;
                i4.c0 c0VarBuilder = i4.h0.builder();
                if (mVar.e != null) {
                    c0VarBuilder.b(new p001if.k(mVar, iVar2, 1));
                }
                if (mVar.f != null) {
                    c0VarBuilder.b(new p001if.k(mVar, iVar2, 0));
                }
                c0VarBuilder.f5714c = true;
                Iterator it2 = i4.h0.asImmutableList(c0VarBuilder.f5712a, c0VarBuilder.f5713b).iterator();
                while (it2.hasNext()) {
                    p001if.k kVar = (p001if.k) it2.next();
                    p001if.r rVar2 = (p001if.r) m0Var.f451d;
                    p001if.j jVar = rVar2.f5842d;
                    long jLongValue = rVar2.f5846j.longValue();
                    switch (kVar.f5819a) {
                        case 0:
                            it = it2;
                            p001if.m mVar2 = kVar.f5820b;
                            ArrayList<p001if.i> arrayListH = p001if.r.h(jVar, mVar2.f.f5825d.intValue());
                            int size = arrayListH.size();
                            p001if.l lVar = mVar2.f;
                            if (size >= lVar.f5824c.intValue() && arrayListH.size() != 0) {
                                for (p001if.i iVar3 : arrayListH) {
                                    if (jVar.a() >= mVar2.f5829d.intValue()) {
                                    }
                                    if (iVar3.c() >= lVar.f5825d.intValue()) {
                                        if (((AtomicLong) iVar3.f5816c.f93b).get() / iVar3.c() > ((double) lVar.f5822a.intValue()) / 100.0d) {
                                            kVar.f5821c.g(ze.h.DEBUG, "FailurePercentage algorithm detected outlier: {0}, failureRate={1}", iVar3, Double.valueOf(((AtomicLong) iVar3.f5816c.f93b).get() / iVar3.c()));
                                            if (new Random().nextInt(100) < lVar.f5823b.intValue()) {
                                                iVar3.b(jLongValue);
                                            }
                                        }
                                    }
                                    break;
                                }
                            }
                            break;
                        default:
                            p001if.m mVar3 = kVar.f5820b;
                            ArrayList<p001if.i> arrayListH2 = p001if.r.h(jVar, mVar3.e.f5825d.intValue());
                            int size2 = arrayListH2.size();
                            p001if.l lVar2 = mVar3.e;
                            if (size2 < lVar2.f5824c.intValue() || arrayListH2.size() == 0) {
                                it = it2;
                            } else {
                                ArrayList arrayList = new ArrayList();
                                for (p001if.i iVar4 : arrayListH2) {
                                    arrayList.add(Double.valueOf(((AtomicLong) iVar4.f5816c.f92a).get() / iVar4.c()));
                                }
                                Iterator it3 = arrayList.iterator();
                                double dDoubleValue = 0.0d;
                                while (it3.hasNext()) {
                                    dDoubleValue += ((Double) it3.next()).doubleValue();
                                }
                                double size3 = dDoubleValue / ((double) arrayList.size());
                                Iterator it4 = arrayList.iterator();
                                double d7 = 0.0d;
                                while (it4.hasNext()) {
                                    double dDoubleValue2 = ((Double) it4.next()).doubleValue() - size3;
                                    d7 += dDoubleValue2 * dDoubleValue2;
                                }
                                it = it2;
                                double dSqrt = Math.sqrt(d7 / ((double) arrayList.size()));
                                double dIntValue = size3 - (((double) (lVar2.f5822a.intValue() / 1000.0f)) * dSqrt);
                                Iterator it5 = arrayListH2.iterator();
                                while (it5.hasNext()) {
                                    p001if.i iVar5 = (p001if.i) it5.next();
                                    Iterator it6 = it5;
                                    p001if.m mVar4 = mVar3;
                                    p001if.j jVar2 = jVar;
                                    if (jVar.a() >= mVar3.f5829d.intValue()) {
                                    }
                                    long j10 = jLongValue;
                                    if (((AtomicLong) iVar5.f5816c.f92a).get() / iVar5.c() < dIntValue) {
                                        kVar.f5821c.g(ze.h.DEBUG, "SuccessRate algorithm detected outlier: {0}. Parameters: successRate={1}, mean={2}, stdev={3}, requiredSuccessRate={4}", iVar5, Double.valueOf(((AtomicLong) iVar5.f5816c.f92a).get() / iVar5.c()), Double.valueOf(size3), Double.valueOf(dSqrt), Double.valueOf(dIntValue));
                                        if (new Random().nextInt(100) < lVar2.f5823b.intValue()) {
                                            j8 = j10;
                                            iVar5.b(j8);
                                        } else {
                                            j8 = j10;
                                        }
                                    } else {
                                        j8 = j10;
                                    }
                                    jLongValue = j8;
                                    it5 = it6;
                                    jVar = jVar2;
                                    mVar3 = mVar4;
                                }
                            }
                            break;
                    }
                    m0Var = this;
                    it2 = it;
                }
                p001if.r rVar3 = (p001if.r) m0Var.f451d;
                p001if.j jVar3 = rVar3.f5842d;
                Long l4 = rVar3.f5846j;
                for (p001if.i iVar6 : jVar3.f5818a.values()) {
                    if (!iVar6.d()) {
                        int i8 = iVar6.e;
                        iVar6.e = i8 == 0 ? 0 : i8 - 1;
                    }
                    if (iVar6.d()) {
                        if (l4.longValue() > Math.min(iVar6.f5814a.f5827b.longValue() * ((long) iVar6.e), Math.max(iVar6.f5814a.f5827b.longValue(), iVar6.f5814a.f5828c.longValue())) + iVar6.f5817d.longValue()) {
                            iVar6.e();
                        }
                    }
                }
                return;
            case 8:
                be beVar = (be) m0Var.f450c;
                HashMap map = beVar.f6389j;
                la laVar = (la) m0Var.f449b;
                k3.g gVar = (k3.g) map.get(laVar);
                if (gVar != null) {
                    for (Object obj : gVar.zzw()) {
                        ArrayList arrayList2 = new ArrayList(gVar.zze(obj));
                        Collections.sort(arrayList2);
                        d2.a aVar2 = new d2.a();
                        Iterator it7 = arrayList2.iterator();
                        long jLongValue2 = 0;
                        while (it7.hasNext()) {
                            jLongValue2 += ((Long) it7.next()).longValue();
                        }
                        aVar2.f4257a = Long.valueOf((jLongValue2 / ((long) arrayList2.size())) & Long.MAX_VALUE);
                        aVar2.f4260d = Long.valueOf(be.a(arrayList2, 100.0d) & Long.MAX_VALUE);
                        aVar2.f4261h = Long.valueOf(be.a(arrayList2, 75.0d) & Long.MAX_VALUE);
                        aVar2.f4259c = Long.valueOf(be.a(arrayList2, 50.0d) & Long.MAX_VALUE);
                        aVar2.f4258b = Long.valueOf(be.a(arrayList2, 25.0d) & Long.MAX_VALUE);
                        aVar2.e = Long.valueOf(be.a(arrayList2, 0.0d) & Long.MAX_VALUE);
                        q9 q9Var = new q9(aVar2);
                        int size4 = arrayList2.size();
                        se.e eVar = (se.e) m0Var.f451d;
                        k3.g1 g1Var = (k3.g1) obj;
                        d2.a aVar3 = new d2.a();
                        aVar3.f4259c = ((v5.f) eVar.f9720b).f10519i ? ja.TYPE_THICK : ja.TYPE_THIN;
                        u6.a aVar4 = new u6.a(9, false);
                        aVar4.f10379c = Integer.valueOf(size4 & Integer.MAX_VALUE);
                        aVar4.f10378b = g1Var;
                        aVar4.f10380d = q9Var;
                        aVar3.f4261h = new k3.h1(aVar4);
                        p5.l.INSTANCE.execute(new yd(beVar, new df.m(aVar3, 0), laVar, beVar.c(), 0));
                    }
                    map.remove(laVar);
                    return;
                }
                return;
            case 9:
                we.h.b("NearLanTcpClient", "Lan waiting service response timeout, accept the request default");
                ((se.d3) m0Var.f450c).o((NearDevice) m0Var.f449b, (String) m0Var.f451d, 20);
                return;
            case 10:
                Rect rect = new Rect();
                View view = (View) m0Var.f450c;
                view.getHitRect(rect);
                Rect rect2 = new Rect();
                ViewGroup viewGroup = (ViewGroup) m0Var.f449b;
                viewGroup.getHitRect(rect2);
                rect.top = 0;
                rect.bottom = rect2.height();
                int i9 = rect.left;
                int i10 = ((FootOperationBar) m0Var.f451d).f3387y;
                rect.left = i9 - i10;
                rect.right += i10;
                view.setTag(rect);
                viewGroup.setTouchDelegate(new TouchDelegate(rect, view));
                return;
            default:
                ((ze.v2) m0Var.f451d).execute((ze.u2) m0Var.f450c);
                return;
        }
    }

    public String toString() {
        switch (this.f448a) {
            case 11:
                return ((Runnable) this.f449b).toString() + "(scheduled in SynchronizationContext)";
            default:
                return super.toString();
        }
    }

    public /* synthetic */ m0(Object obj, Object obj2, Object obj3, int i8, boolean z2) {
        this.f448a = i8;
        this.f450c = obj;
        this.f449b = obj2;
        this.f451d = obj3;
    }

    public m0(Handler handler) {
        this.f448a = 5;
        this.f451d = "";
        this.f450c = handler;
    }
}
