package af;

import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import k3.u8;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class p5 extends ze.c2 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Logger f509m = Logger.getLogger(p5.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cf.b0 f510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ze.r1 f511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ph.c f512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ze.s f513d;
    public final byte[] e;
    public final ze.b0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final r f514g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f515h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f516i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f517j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ze.o f518k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f519l;

    public p5(cf.b0 b0Var, ze.r1 r1Var, ze.p1 p1Var, ze.s sVar, ze.b0 b0Var2, r rVar) {
        ph.c cVar = ph.a.f8885a;
        this.f510a = b0Var;
        this.f511b = r1Var;
        this.f513d = sVar;
        this.e = (byte[]) p1Var.c(l1.f);
        this.f = b0Var2;
        this.f514g = rVar;
        ((s2) rVar.f539b).e();
        ((k2) rVar.f538a).g();
        this.f512c = cVar;
    }

    @Override // ze.c2
    public final void a(ze.q2 q2Var, ze.p1 p1Var) {
        ph.b.d();
        try {
            ph.b.a();
            e(q2Var, p1Var);
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @Override // ze.c2
    public final void b(int i8) {
        ph.b.d();
        try {
            ph.b.a();
            this.f510a.e(i8);
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @Override // ze.c2
    public final void c(ze.p1 p1Var) {
        ph.b.d();
        try {
            ph.b.a();
            g(p1Var);
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @Override // ze.c2
    public final void d(Object obj) {
        ph.b.d();
        try {
            ph.b.a();
            h(obj);
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final void e(ze.q2 q2Var, ze.p1 p1Var) {
        r rVar = this.f514g;
        v8.n(!this.f517j, "call already closed");
        try {
            this.f517j = true;
            if (q2Var.e() && this.f511b.f11422a.serverSendsOneMessage() && !this.f519l) {
                f(new ze.s2(ze.q2.f11410m.h("Completed without a response")));
            } else {
                this.f510a.x(q2Var, p1Var);
            }
        } finally {
            rVar.b(q2Var.e());
        }
    }

    public final void f(RuntimeException runtimeException) {
        f509m.log(Level.WARNING, "Cancelling the stream because of internal error", (Throwable) runtimeException);
        this.f510a.h(runtimeException instanceof ze.s2 ? ((ze.s2) runtimeException).getStatus() : ze.q2.f11410m.g(runtimeException).h("Internal error so cancelling stream."));
        this.f514g.b(false);
    }

    public final void g(ze.p1 p1Var) {
        byte[] bArr;
        boolean zContains;
        v8.n(!this.f516i, "sendHeaders has already been called");
        v8.n(!this.f517j, "call is closed");
        p1Var.a(l1.f416i);
        p1Var.a(l1.e);
        if (this.f518k == null || (bArr = this.e) == null) {
            this.f518k = ze.o.f11387b;
        } else {
            sj.a aVar = l1.f420m;
            String str = new String(bArr, l1.f412c);
            aVar.getClass();
            Iterable tVar = new h4.t(aVar, str);
            this.f518k.getClass();
            if (!(tVar instanceof Collection)) {
                Iterator it = tVar.iterator();
                while (true) {
                    h4.s sVar = (h4.s) it;
                    if (!sVar.hasNext()) {
                        zContains = false;
                        break;
                    } else if (u8.a(sVar.next(), "identity")) {
                        zContains = true;
                        break;
                    }
                }
            } else {
                try {
                    zContains = ((Collection) tVar).contains("identity");
                } catch (ClassCastException | NullPointerException unused) {
                    zContains = false;
                    break;
                }
            }
            if (!zContains) {
                this.f518k = ze.o.f11387b;
            }
        }
        ze.m1 m1Var = l1.e;
        this.f518k.getClass();
        p1Var.f(m1Var, "identity");
        this.f510a.a(this.f518k);
        ze.m1 m1Var2 = l1.f;
        p1Var.a(m1Var2);
        byte[] bArr2 = this.f.f11326b;
        if (bArr2.length != 0) {
            p1Var.f(m1Var2, bArr2);
        }
        this.f516i = true;
        cf.b0 b0Var = this.f510a;
        this.f511b.f11422a.serverSendsOneMessage();
        b0Var.f = true;
        tj.w wVar = b0Var.f1489h;
        wVar.getClass();
        ph.b.d();
        try {
            ArrayList arrayListB = cf.f.b(p1Var);
            synchronized (((cf.b0) wVar.f10262b).f1488g.f1476s) {
                cf.a0 a0Var = ((cf.b0) wVar.f10262b).f1488g;
                int i8 = a0Var.q;
                cf.e eVar = a0Var.f1479w;
                eVar.Q(false, i8, arrayListB);
                eVar.flush();
            }
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final void h(Object obj) {
        cf.b0 b0Var = this.f510a;
        v8.n(this.f516i, "sendHeaders has not been called");
        v8.n(!this.f517j, "call is closed");
        ze.r1 r1Var = this.f511b;
        if (r1Var.f11422a.serverSendsOneMessage() && this.f519l) {
            f(new ze.s2(ze.q2.f11410m.h("Too many responses")));
            return;
        }
        this.f519l = true;
        try {
            gf.b bVar = r1Var.e;
            bVar.getClass();
            b0Var.i(new gf.a((MessageLite) obj, bVar.f5181a));
            if (r1Var.f11422a.serverSendsOneMessage()) {
                return;
            }
            b0Var.flush();
        } catch (Error e) {
            a(ze.q2.f.h("Server sendMessage() failed with Error"), new ze.p1());
            throw e;
        } catch (RuntimeException e4) {
            f(e4);
        }
    }
}
