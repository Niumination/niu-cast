package zj;

import af.r5;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n0 f11714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f11715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.d f11716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f11717d;
    public volatile boolean e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public hj.i f11718h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Throwable f11719i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f11720j;

    public w(n0 n0Var, Object[] objArr, dj.d dVar, j jVar) {
        this.f11714a = n0Var;
        this.f11715b = objArr;
        this.f11716c = dVar;
        this.f11717d = jVar;
    }

    public final hj.i a() {
        dj.u url;
        n0 n0Var = this.f11714a;
        Object[] objArr = this.f11715b;
        int length = objArr.length;
        s[] sVarArr = n0Var.f11687j;
        if (length != sVarArr.length) {
            throw new IllegalArgumentException(h0.a.m(a1.a.u(length, "Argument count (", ") doesn't match expected count ("), ")", sVarArr.length));
        }
        l0 l0Var = new l0(n0Var.f11682c, n0Var.f11681b, n0Var.f11683d, n0Var.e, n0Var.f, n0Var.f11684g, n0Var.f11685h, n0Var.f11686i);
        if (n0Var.f11688k) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i8 = 0; i8 < length; i8++) {
            arrayList.add(objArr[i8]);
            sVarArr[i8].a(l0Var, objArr[i8]);
        }
        dj.t tVar = l0Var.f11649d;
        if (tVar != null) {
            url = tVar.a();
        } else {
            String link = l0Var.f11648c;
            dj.u uVar = l0Var.f11647b;
            uVar.getClass();
            Intrinsics.checkNotNullParameter(link, "link");
            dj.t tVarF = uVar.f(link);
            url = tVarF != null ? tVarF.a() : null;
            if (url == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + uVar + ", Relative: " + l0Var.f11648c);
            }
        }
        dj.h0 f0Var = l0Var.f11654k;
        if (f0Var == null) {
            tc.d dVar = l0Var.f11653j;
            if (dVar != null) {
                f0Var = new dj.n((ArrayList) dVar.f10209a, (ArrayList) dVar.f10210b);
            } else {
                u6.a aVar = l0Var.f11652i;
                if (aVar != null) {
                    ArrayList arrayList2 = (ArrayList) aVar.f10380d;
                    if (arrayList2.isEmpty()) {
                        throw new IllegalStateException("Multipart body must have at least one part.");
                    }
                    f0Var = new dj.z((qj.j) aVar.f10378b, (dj.x) aVar.f10379c, ej.b.w(arrayList2));
                } else if (l0Var.f11651h) {
                    byte[] toRequestBody = new byte[0];
                    Intrinsics.checkNotNullParameter(toRequestBody, "content");
                    Intrinsics.checkNotNullParameter(toRequestBody, "$this$toRequestBody");
                    long j8 = 0;
                    ej.b.c(j8, j8, j8);
                    f0Var = new dj.g0(toRequestBody, null, 0, 0);
                }
            }
        }
        dj.x xVar = l0Var.f11650g;
        dj.r rVar = l0Var.f;
        if (xVar != null) {
            if (f0Var != null) {
                f0Var = new dj.f0(f0Var, xVar, 1);
            } else {
                rVar.a("Content-Type", xVar.f4642a);
            }
        }
        r5 r5Var = l0Var.e;
        r5Var.getClass();
        Intrinsics.checkNotNullParameter(url, "url");
        r5Var.f557b = url;
        dj.s headers = rVar.c();
        Intrinsics.checkNotNullParameter(headers, "headers");
        r5Var.f559d = headers.g();
        r5Var.w(l0Var.f11646a, f0Var);
        r5Var.z(o.class, new o(n0Var.f11680a, arrayList));
        dj.e0 request = r5Var.o();
        dj.b0 b0Var = (dj.b0) this.f11716c;
        b0Var.getClass();
        Intrinsics.checkNotNullParameter(request, "request");
        return new hj.i(b0Var, request);
    }

    public final hj.i b() throws IOException {
        hj.i iVar = this.f11718h;
        if (iVar != null) {
            return iVar;
        }
        Throwable th2 = this.f11719i;
        if (th2 != null) {
            if (th2 instanceof IOException) {
                throw ((IOException) th2);
            }
            if (th2 instanceof RuntimeException) {
                throw ((RuntimeException) th2);
            }
            throw ((Error) th2);
        }
        try {
            hj.i iVarA = a();
            this.f11718h = iVarA;
            return iVarA;
        } catch (IOException | Error | RuntimeException e) {
            s.p(e);
            this.f11719i = e;
            throw e;
        }
    }

    public final o0 c(dj.j0 j0Var) throws IOException {
        dj.i0 i0VarG = j0Var.g();
        dj.m0 m0Var = j0Var.f4581i;
        i0VarG.f4565g = new v(m0Var.c(), m0Var.a());
        dj.j0 j0VarA = i0VarG.a();
        int i8 = j0VarA.f4579d;
        if (i8 < 200 || i8 >= 300) {
            try {
                s.b(m0Var);
                if (j0VarA.c()) {
                    throw new IllegalArgumentException("rawResponse should not be successful response");
                }
                o0 o0Var = new o0(j0VarA, null);
                m0Var.close();
                return o0Var;
            } catch (Throwable th2) {
                m0Var.close();
                throw th2;
            }
        }
        if (i8 == 204 || i8 == 205) {
            m0Var.close();
            if (j0VarA.c()) {
                return new o0(j0VarA, null);
            }
            throw new IllegalArgumentException("rawResponse must be successful response");
        }
        u uVar = new u(m0Var);
        try {
            Object objConvert = this.f11717d.convert(uVar);
            if (j0VarA.c()) {
                return new o0(j0VarA, objConvert);
            }
            throw new IllegalArgumentException("rawResponse must be successful response");
        } catch (RuntimeException e) {
            IOException iOException = uVar.f11706d;
            if (iOException == null) {
                throw e;
            }
            throw iOException;
        }
    }

    @Override // zj.c
    public final void cancel() {
        hj.i iVar;
        this.e = true;
        synchronized (this) {
            iVar = this.f11718h;
        }
        if (iVar != null) {
            iVar.cancel();
        }
    }

    public final Object clone() {
        return new w(this.f11714a, this.f11715b, this.f11716c, this.f11717d);
    }

    @Override // zj.c
    public final o0 execute() {
        hj.i call;
        synchronized (this) {
            if (this.f11720j) {
                throw new IllegalStateException("Already executed.");
            }
            this.f11720j = true;
            call = b();
        }
        if (this.e) {
            call.cancel();
        }
        if (!call.f5445c.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        call.f5444b.h();
        call.d();
        try {
            dj.m mVar = call.p.f4495a;
            synchronized (mVar) {
                Intrinsics.checkNotNullParameter(call, "call");
                ((ArrayDeque) mVar.f4612d).add(call);
            }
            dj.j0 j0VarF = call.f();
            dj.m mVar2 = call.p.f4495a;
            mVar2.getClass();
            Intrinsics.checkNotNullParameter(call, "call");
            mVar2.b((ArrayDeque) mVar2.f4612d, call);
            return c(j0VarF);
        } catch (Throwable th2) {
            dj.m mVar3 = call.p.f4495a;
            mVar3.getClass();
            Intrinsics.checkNotNullParameter(call, "call");
            mVar3.b((ArrayDeque) mVar3.f4612d, call);
            throw th2;
        }
    }

    @Override // zj.c
    public final void g(f fVar) {
        hj.i iVar;
        Throwable th2;
        hj.f other;
        synchronized (this) {
            try {
                if (this.f11720j) {
                    throw new IllegalStateException("Already executed.");
                }
                this.f11720j = true;
                iVar = this.f11718h;
                th2 = this.f11719i;
                if (iVar == null && th2 == null) {
                    try {
                        hj.i iVarA = a();
                        this.f11718h = iVarA;
                        iVar = iVarA;
                    } catch (Throwable th3) {
                        th2 = th3;
                        s.p(th2);
                        this.f11719i = th2;
                    }
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
        if (th2 != null) {
            fVar.onFailure(th2);
            return;
        }
        if (this.e) {
            iVar.cancel();
        }
        f5.a responseCallback = new f5.a(this, fVar);
        iVar.getClass();
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        if (!iVar.f5445c.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        iVar.d();
        dj.m mVar = iVar.p.f4495a;
        hj.f call = new hj.f(iVar, responseCallback);
        mVar.getClass();
        Intrinsics.checkNotNullParameter(call, "call");
        synchronized (mVar) {
            ((ArrayDeque) mVar.f4610b).add(call);
            String str = iVar.q.f4528b.e;
            Iterator it = ((ArrayDeque) mVar.f4611c).iterator();
            do {
                if (!it.hasNext()) {
                    Iterator it2 = ((ArrayDeque) mVar.f4610b).iterator();
                    do {
                        if (!it2.hasNext()) {
                            other = null;
                            break;
                        }
                        other = (hj.f) it2.next();
                    } while (!Intrinsics.areEqual(other.f5440c.q.f4528b.e, str));
                } else {
                    other = (hj.f) it.next();
                }
            } while (!Intrinsics.areEqual(other.f5440c.q.f4528b.e, str));
            if (other != null) {
                Intrinsics.checkNotNullParameter(other, "other");
                call.f5438a = other.f5438a;
            }
            Unit unit = Unit.INSTANCE;
        }
        mVar.e();
    }

    @Override // zj.c
    public final boolean isCanceled() {
        boolean z2 = true;
        if (this.e) {
            return true;
        }
        synchronized (this) {
            hj.i iVar = this.f11718h;
            if (iVar == null || !iVar.f5452m) {
                z2 = false;
            }
        }
        return z2;
    }

    @Override // zj.c
    public final synchronized dj.e0 request() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create request.", e);
        }
        return b().q;
    }

    @Override // zj.c
    public final c clone() {
        return new w(this.f11714a, this.f11715b, this.f11716c, this.f11717d);
    }
}
