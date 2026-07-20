package ij;

import dj.e0;
import dj.h0;
import dj.i0;
import dj.j0;
import dj.l0;
import dj.m;
import dj.m0;
import dj.v;
import dj.w;
import hj.i;
import java.io.IOException;
import java.net.ProtocolException;
import k3.r9;
import k3.sc;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import qj.s;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements w {
    @Override // dj.w
    public final j0 intercept(v chain) throws Throwable {
        boolean z2;
        Long l4;
        boolean z3;
        i0 i0VarF;
        i0 i0VarF2;
        boolean z5;
        i0 i0Var;
        Intrinsics.checkNotNullParameter(chain, "chain");
        f fVar = (f) chain;
        m mVar = fVar.e;
        Intrinsics.checkNotNull(mVar);
        e0 request = fVar.f;
        h0 h0Var = request.e;
        long jCurrentTimeMillis = System.currentTimeMillis();
        i call = (i) mVar.f4610b;
        d dVar = (d) mVar.f4612d;
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            Intrinsics.checkNotNullParameter(call, "call");
            dVar.c(request);
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(request, "request");
            boolean zA = r9.a(request.f4529c);
            i call2 = (i) mVar.f4610b;
            hj.m mVar2 = (hj.m) mVar.f4609a;
            if (!zA || h0Var == null) {
                z2 = false;
                l4 = null;
                call2.h(mVar, true, false, null);
                z3 = true;
                i0VarF = null;
            } else {
                if (StringsKt__StringsJVMKt.equals("100-continue", request.a("Expect"), true)) {
                    try {
                        dVar.h();
                        i0VarF2 = mVar.f(true);
                        Intrinsics.checkNotNullParameter(call2, "call");
                        z5 = false;
                    } catch (IOException ioe) {
                        Intrinsics.checkNotNullParameter(call2, "call");
                        Intrinsics.checkNotNullParameter(ioe, "ioe");
                        mVar.g(ioe);
                        throw ioe;
                    }
                } else {
                    z5 = true;
                    i0VarF2 = null;
                }
                if (i0VarF2 == null) {
                    Intrinsics.checkNotNullParameter(request, "request");
                    h0 h0Var2 = request.e;
                    Intrinsics.checkNotNull(h0Var2);
                    i0Var = i0VarF2;
                    long jA = h0Var2.a();
                    Intrinsics.checkNotNullParameter(call2, "call");
                    z3 = z5;
                    s sVarA = sc.a(new hj.c(mVar, dVar.f(request, jA), jA));
                    h0Var.c(sVarA);
                    sVarA.close();
                } else {
                    i0Var = i0VarF2;
                    z3 = z5;
                    call2.h(mVar, true, false, null);
                    if (mVar2.f == null) {
                        dVar.b().k();
                    }
                }
                i0VarF = i0Var;
                z2 = false;
                l4 = null;
            }
            try {
                dVar.a();
                if (i0VarF == null) {
                    i0VarF = mVar.f(z2);
                    Intrinsics.checkNotNull(i0VarF);
                    if (z3) {
                        Intrinsics.checkNotNullParameter(call2, "call");
                        z3 = false;
                    }
                }
                i0VarF.getClass();
                Intrinsics.checkNotNullParameter(request, "request");
                i0VarF.f4561a = request;
                i0VarF.e = mVar2.f5457d;
                i0VarF.f4569k = jCurrentTimeMillis;
                i0VarF.f4570l = System.currentTimeMillis();
                j0 response = i0VarF.a();
                int i8 = response.f4579d;
                if (i8 == 100) {
                    i0 i0VarF3 = mVar.f(false);
                    Intrinsics.checkNotNull(i0VarF3);
                    if (z3) {
                        Intrinsics.checkNotNullParameter(call2, "call");
                    }
                    i0VarF3.getClass();
                    Intrinsics.checkNotNullParameter(request, "request");
                    i0VarF3.f4561a = request;
                    i0VarF3.e = mVar2.f5457d;
                    i0VarF3.f4569k = jCurrentTimeMillis;
                    i0VarF3.f4570l = System.currentTimeMillis();
                    response = i0VarF3.a();
                    i8 = response.f4579d;
                }
                Intrinsics.checkNotNullParameter(response, "response");
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                i0 i0VarG = response.g();
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    String strA = j0.a(response, "Content-Type");
                    long jD = dVar.d(response);
                    i0VarG.f4565g = new l0(strA, jD, sc.b(new hj.d(mVar, dVar.e(response), jD)));
                    j0 j0VarA = i0VarG.a();
                    if (StringsKt__StringsJVMKt.equals("close", j0VarA.f4576a.a("Connection"), true) || StringsKt__StringsJVMKt.equals("close", j0.a(j0VarA, "Connection"), true)) {
                        dVar.b().k();
                    }
                    if (i8 == 204 || i8 == 205) {
                        m0 m0Var = j0VarA.f4581i;
                        if ((m0Var != null ? m0Var.a() : -1L) > 0) {
                            StringBuilder sbU = a1.a.u(i8, "HTTP ", " had non-zero Content-Length: ");
                            sbU.append(m0Var != null ? Long.valueOf(m0Var.a()) : l4);
                            throw new ProtocolException(sbU.toString());
                        }
                    }
                    return j0VarA;
                } catch (IOException ioe2) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(ioe2, "ioe");
                    mVar.g(ioe2);
                    throw ioe2;
                }
            } catch (IOException ioe3) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(ioe3, "ioe");
                mVar.g(ioe3);
                throw ioe3;
            }
        } catch (IOException ioe4) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(ioe4, "ioe");
            mVar.g(ioe4);
            throw ioe4;
        }
    }
}
