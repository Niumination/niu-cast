package qg;

import java.util.Iterator;
import java.util.List;
import k3.ga;
import k3.ha;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.StringsKt__StringsJVMKt;
import li.p2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s implements wg.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final zg.a f9107h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ng.b f9108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zf.z f9109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f9110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9111d;
    public final wg.b e;

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(s.class);
        try {
            kTypeTypeOf = Reflection.typeOf(s.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        f9107h = new zg.a("EngineResponse", new ih.a(orCreateKotlinClass, kTypeTypeOf));
    }

    public s(ng.b call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.f9108a = call;
        this.f9110c = LazyKt.lazy(new ag.a(this, 11));
        wg.b bVar = new wg.b(call.f8244a.f8054h);
        wg.b from = call.f8244a.f8057k;
        Intrinsics.checkNotNullParameter(from, "from");
        bVar.f5398b.clear();
        if (bVar.f5399c != 0) {
            throw new IllegalStateException("Check failed.");
        }
        bVar.d(from);
        this.e = bVar;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00c0 A[Catch: all -> 0x00fd, TRY_LEAVE, TryCatch #1 {all -> 0x00fd, blocks: (B:37:0x00b8, B:39:0x00c0), top: B:63:0x00b8 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00d4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00eb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ef A[Catch: all -> 0x003f, TryCatch #2 {all -> 0x003f, blocks: (B:14:0x003a, B:43:0x00d9, B:47:0x00ef, B:48:0x00f4, B:49:0x00f5, B:50:0x00fa, B:21:0x005b, B:29:0x0083, B:31:0x0092, B:33:0x009c), top: B:65:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00f5 A[Catch: all -> 0x003f, TryCatch #2 {all -> 0x003f, blocks: (B:14:0x003a, B:43:0x00d9, B:47:0x00ef, B:48:0x00f4, B:49:0x00f5, B:50:0x00fa, B:21:0x005b, B:29:0x0083, B:31:0x0092, B:33:0x009c), top: B:65:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [jh.j0] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public static Object i(s sVar, jh.o oVar, ContinuationImpl continuationImpl) {
        p pVar;
        jh.j0 j0Var;
        Long l4;
        jh.j0 j0Var2;
        long jLongValue;
        s sVar2;
        Long l8;
        jh.j0 j0Var3;
        long j8;
        long jLongValue2;
        long j10;
        if (continuationImpl instanceof p) {
            pVar = (p) continuationImpl;
            int i8 = pVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                pVar.label = i8 - Integer.MIN_VALUE;
            } else {
                pVar = new p(sVar, continuationImpl);
            }
        } else {
            pVar = new p(sVar, continuationImpl);
        }
        Object objN = pVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r7 = pVar.label;
        try {
            if (r7 != 0) {
                if (r7 == 1) {
                    oVar = (jh.o) pVar.L$1;
                    sVar = (s) pVar.L$0;
                    ResultKt.throwOnFailure(objN);
                } else {
                    if (r7 == 2) {
                        Long l10 = (Long) pVar.L$3;
                        jh.j0 j0Var4 = (jh.j0) pVar.L$2;
                        oVar = (jh.o) pVar.L$1;
                        s sVar3 = (s) pVar.L$0;
                        ResultKt.throwOnFailure(objN);
                        j0Var = j0Var4;
                        l4 = l10;
                        sVar = sVar3;
                        j0Var2 = j0Var;
                        try {
                            jLongValue = ((Number) objN).longValue();
                            if (l4 != null) {
                                pVar.L$0 = sVar;
                                pVar.L$1 = j0Var2;
                                pVar.L$2 = l4;
                                pVar.L$3 = null;
                                pVar.J$0 = jLongValue;
                                pVar.label = 3;
                                objN = jh.g0.d(oVar, 1L, pVar);
                                if (objN == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                sVar2 = sVar;
                                l8 = l4;
                                j0Var3 = j0Var2;
                                j8 = jLongValue;
                            }
                            ha.a(j0Var2);
                            return Unit.INSTANCE;
                        } catch (Throwable th2) {
                            th = th2;
                            r7 = j0Var2;
                            try {
                                jh.o0.a(r7, th);
                                throw th;
                            } catch (Throwable th3) {
                                ha.a(r7);
                                throw th3;
                            }
                        }
                    }
                    if (r7 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j8 = pVar.J$0;
                    l8 = (Long) pVar.L$2;
                    j0Var3 = (jh.j0) pVar.L$1;
                    sVar2 = (s) pVar.L$0;
                    ResultKt.throwOnFailure(objN);
                }
                long jLongValue3 = ((Number) objN).longValue();
                jLongValue2 = l8.longValue();
                j10 = j8 + jLongValue3;
                sVar2.getClass();
                if (jLongValue2 >= j10) {
                    throw new k(jLongValue2);
                }
                if (jLongValue2 <= j10) {
                    throw new l(jLongValue2, j10);
                }
                j0Var2 = j0Var3;
                ha.a(j0Var2);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(objN);
            pVar.L$0 = sVar;
            pVar.L$1 = oVar;
            pVar.label = 1;
            objN = sVar.n(pVar);
            if (objN == coroutine_suspended) {
                return coroutine_suspended;
            }
            jh.j0 j0Var5 = (jh.j0) objN;
            ka.d dVar = ((ng.a0) sVar).q;
            String[] strArr = zf.v.f11551a;
            String strC = dVar.c("Content-Length");
            Long lBoxLong = strC != null ? Boxing.boxLong(Long.parseLong(strC)) : null;
            p2 p2Var = li.v0.f7500c;
            q qVar = new q(oVar, j0Var5, lBoxLong, null);
            pVar.L$0 = sVar;
            pVar.L$1 = oVar;
            pVar.L$2 = j0Var5;
            pVar.L$3 = lBoxLong;
            pVar.label = 2;
            Object objU = li.l0.u(p2Var, qVar, pVar);
            if (objU == coroutine_suspended) {
                return coroutine_suspended;
            }
            j0Var = j0Var5;
            l4 = lBoxLong;
            objN = objU;
            j0Var2 = j0Var;
            jLongValue = ((Number) objN).longValue();
            if (l4 != null) {
                pVar.L$0 = sVar;
                pVar.L$1 = j0Var2;
                pVar.L$2 = l4;
                pVar.L$3 = null;
                pVar.J$0 = jLongValue;
                pVar.label = 3;
                objN = jh.g0.d(oVar, 1L, pVar);
                if (objN == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sVar2 = sVar;
                l8 = l4;
                j0Var3 = j0Var2;
                j8 = jLongValue;
                long jLongValue4 = ((Number) objN).longValue();
                jLongValue2 = l8.longValue();
                j10 = j8 + jLongValue4;
                sVar2.getClass();
                if (jLongValue2 >= j10) {
                    throw new k(jLongValue2);
                }
                if (jLongValue2 <= j10) {
                    throw new l(jLongValue2, j10);
                }
                j0Var2 = j0Var3;
            }
            ha.a(j0Var2);
            return Unit.INSTANCE;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static Object l(s sVar, cg.j jVar, ContinuationImpl continuationImpl) throws Throwable {
        r rVar;
        jh.o oVar;
        s sVar2;
        if (continuationImpl instanceof r) {
            rVar = (r) continuationImpl;
            int i8 = rVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                rVar.label = i8 - Integer.MIN_VALUE;
            } else {
                rVar = new r(sVar, continuationImpl);
            }
        } else {
            rVar = new r(sVar, continuationImpl);
        }
        Object obj = rVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (rVar.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                if (jVar instanceof cg.h) {
                    sVar.d(jVar);
                    rVar.L$0 = sVar;
                    rVar.label = 1;
                    if (sVar.m((cg.h) jVar, rVar) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (jVar instanceof cg.f) {
                    byte[] bArrE = ((cg.f) jVar).e();
                    sVar.d(jVar);
                    rVar.L$0 = sVar;
                    rVar.label = 2;
                    if (sVar.h(bArrE, rVar) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (jVar instanceof cg.i) {
                    jh.o oVarE = ((cg.i) jVar).e();
                    try {
                        sVar.d(jVar);
                        rVar.L$0 = sVar;
                        rVar.L$1 = oVarE;
                        rVar.label = 4;
                        if (i(sVar, oVarE, rVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sVar2 = sVar;
                        oVar = oVarE;
                        ga.a(oVar);
                        sVar = sVar2;
                    } catch (Throwable th2) {
                        th = th2;
                        oVar = oVarE;
                        ga.a(oVar);
                        throw th;
                    }
                } else {
                    if (!(jVar instanceof cg.g)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    sVar.d(jVar);
                    rVar.L$0 = sVar;
                    rVar.label = 5;
                    if (sVar.j(rVar) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                sVar.getClass();
                return Unit.INSTANCE;
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
                sVar = (s) rVar.L$0;
                ResultKt.throwOnFailure(obj);
                sVar.getClass();
                return Unit.INSTANCE;
            case 4:
                oVar = (jh.o) rVar.L$1;
                sVar2 = (s) rVar.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    ga.a(oVar);
                    sVar = sVar2;
                    sVar.getClass();
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    ga.a(oVar);
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // wg.a
    public final boolean b() {
        return this.f9111d;
    }

    @Override // wg.a
    public final /* bridge */ /* synthetic */ mg.b c() {
        return this.f9108a;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x004f  */
    /* JADX WARN: Code duplicated, block: B:18:0x006c  */
    /* JADX WARN: Code duplicated, block: B:20:0x0076  */
    /* JADX WARN: Code duplicated, block: B:26:0x0082  */
    /* JADX WARN: Code duplicated, block: B:27:0x008f  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:42:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:44:0x0102  */
    /* JADX WARN: Code duplicated, block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:? A[RETURN, SYNTHETIC] */
    public final void d(final cg.j content) {
        ng.a0 a0Var;
        Long lA;
        ka.d dVar;
        ng.b bVar;
        String str;
        ka.d dVar2;
        zf.i iVarB;
        long jLongValue;
        String strValueOf;
        Intrinsics.checkNotNullParameter(content, "content");
        if (this.f9111d) {
            throw new o();
        }
        this.f9111d = true;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        zf.z value = content.d();
        if (value == null) {
            if (this.f9109b == null) {
                value = zf.z.e;
                Intrinsics.checkNotNullParameter(value, "value");
                this.f9109b = value;
                a0Var = (ng.a0) this;
            }
            content.c().c(new Function2() { // from class: qg.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    String name = (String) obj;
                    List values = (List) obj2;
                    Intrinsics.checkNotNullParameter(name, "name");
                    Intrinsics.checkNotNullParameter(values, "values");
                    String[] strArr = zf.v.f11551a;
                    boolean zAreEqual = Intrinsics.areEqual(name, "Transfer-Encoding");
                    s sVar = this;
                    if (zAreEqual) {
                        booleanRef.element = true;
                    } else if (Intrinsics.areEqual(name, "Upgrade")) {
                        if (!(content instanceof cg.h)) {
                            throw new n("Upgrade", "non-upgrading response");
                        }
                        Iterator it = values.iterator();
                        while (it.hasNext()) {
                            ((ng.a0) sVar).q.b(name, (String) it.next(), false);
                        }
                        return Unit.INSTANCE;
                    }
                    Iterator it2 = values.iterator();
                    while (it2.hasNext()) {
                        ((ng.a0) sVar).q.b(name, (String) it2.next(), true);
                    }
                    return Unit.INSTANCE;
                }
            });
            lA = content.a();
            if (lA != null) {
                ng.a0 a0Var2 = (ng.a0) this;
                String[] strArr = zf.v.f11551a;
                jLongValue = lA.longValue();
                String[] strArr2 = u0.f9122a;
                if (0 <= jLongValue || jLongValue >= 1024) {
                    strValueOf = String.valueOf(jLongValue);
                } else {
                    strValueOf = u0.f9122a[(int) jLongValue];
                }
                a0Var2.q.b("Content-Length", strValueOf, false);
            } else if (!booleanRef.element && !(content instanceof cg.h)) {
                if (content instanceof cg.g) {
                    String[] strArr3 = zf.v.f11551a;
                    ((ng.a0) this).q.b("Content-Length", "0", false);
                } else {
                    String[] strArr4 = zf.v.f11551a;
                    ((ng.a0) this).q.b("Transfer-Encoding", "chunked", false);
                }
            }
            String[] strArr5 = zf.v.f11551a;
            dVar = ((ng.a0) this).q;
            dVar.getClass();
            Intrinsics.checkNotNullParameter("Content-Type", "name");
            if (dVar.c("Content-Type") == null && (iVarB = content.b()) != null) {
                dVar.b("Content-Type", iVarB.toString(), false);
            }
            bVar = this.f9108a;
            str = bVar.f8247d.a().get("Connection");
            if (str != null) {
                dVar2 = bVar.e.q;
                dVar2.getClass();
                Intrinsics.checkNotNullParameter("Connection", "name");
                if (dVar2.c("Connection") != null) {
                    return;
                }
                if (StringsKt__StringsJVMKt.equals(str, "close", true)) {
                    Intrinsics.checkNotNullParameter(this, "<this>");
                    Intrinsics.checkNotNullParameter("Connection", "name");
                    Intrinsics.checkNotNullParameter("close", "value");
                    dVar.b("Connection", "close", true);
                    return;
                }
                if (StringsKt__StringsJVMKt.equals(str, "keep-alive", true)) {
                    Intrinsics.checkNotNullParameter(this, "<this>");
                    Intrinsics.checkNotNullParameter("Connection", "name");
                    Intrinsics.checkNotNullParameter("keep-alive", "value");
                    dVar.b("Connection", "keep-alive", true);
                }
            }
        }
        Intrinsics.checkNotNullParameter(value, "value");
        this.f9109b = value;
        a0Var = (ng.a0) this;
        Intrinsics.checkNotNullParameter(value, "statusCode");
        a0Var.f8241m = value;
        Unit unit = Unit.INSTANCE;
        content.c().c(new Function2() { // from class: qg.j
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                String name = (String) obj;
                List values = (List) obj2;
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(values, "values");
                String[] strArr6 = zf.v.f11551a;
                boolean zAreEqual = Intrinsics.areEqual(name, "Transfer-Encoding");
                s sVar = this;
                if (zAreEqual) {
                    booleanRef.element = true;
                } else if (Intrinsics.areEqual(name, "Upgrade")) {
                    if (!(content instanceof cg.h)) {
                        throw new n("Upgrade", "non-upgrading response");
                    }
                    Iterator it = values.iterator();
                    while (it.hasNext()) {
                        ((ng.a0) sVar).q.b(name, (String) it.next(), false);
                    }
                    return Unit.INSTANCE;
                }
                Iterator it2 = values.iterator();
                while (it2.hasNext()) {
                    ((ng.a0) sVar).q.b(name, (String) it2.next(), true);
                }
                return Unit.INSTANCE;
            }
        });
        lA = content.a();
        if (lA != null) {
            ng.a0 a0Var3 = (ng.a0) this;
            String[] strArr6 = zf.v.f11551a;
            jLongValue = lA.longValue();
            String[] strArr7 = u0.f9122a;
            if (0 <= jLongValue) {
                strValueOf = String.valueOf(jLongValue);
            } else {
                strValueOf = String.valueOf(jLongValue);
            }
            a0Var3.q.b("Content-Length", strValueOf, false);
        } else if (!booleanRef.element) {
            if (content instanceof cg.g) {
                String[] strArr8 = zf.v.f11551a;
                ((ng.a0) this).q.b("Content-Length", "0", false);
            } else {
                String[] strArr9 = zf.v.f11551a;
                ((ng.a0) this).q.b("Transfer-Encoding", "chunked", false);
            }
        }
        String[] strArr10 = zf.v.f11551a;
        dVar = ((ng.a0) this).q;
        dVar.getClass();
        Intrinsics.checkNotNullParameter("Content-Type", "name");
        if (dVar.c("Content-Type") == null) {
            dVar.b("Content-Type", iVarB.toString(), false);
        }
        bVar = this.f9108a;
        str = bVar.f8247d.a().get("Connection");
        if (str != null) {
            dVar2 = bVar.e.q;
            dVar2.getClass();
            Intrinsics.checkNotNullParameter("Connection", "name");
            if (dVar2.c("Connection") != null) {
                return;
            }
            if (StringsKt__StringsJVMKt.equals(str, "close", true)) {
                Intrinsics.checkNotNullParameter(this, "<this>");
                Intrinsics.checkNotNullParameter("Connection", "name");
                Intrinsics.checkNotNullParameter("close", "value");
                dVar.b("Connection", "close", true);
                return;
            }
            if (StringsKt__StringsJVMKt.equals(str, "keep-alive", true)) {
                Intrinsics.checkNotNullParameter(this, "<this>");
                Intrinsics.checkNotNullParameter("Connection", "name");
                Intrinsics.checkNotNullParameter("keep-alive", "value");
                dVar.b("Connection", "keep-alive", true);
            }
        }
    }

    @Override // wg.c
    public final wg.b e() {
        return this.e;
    }

    @Override // wg.a
    public final wg.d f() {
        return (wg.d) this.f9110c.getValue();
    }

    @Override // wg.a
    public final zf.z g() {
        return this.f9109b;
    }

    public abstract Object h(byte[] bArr, ContinuationImpl continuationImpl);

    public abstract Object j(ContinuationImpl continuationImpl);

    public abstract Object k(cg.j jVar, ContinuationImpl continuationImpl);

    public abstract Object m(cg.h hVar, ContinuationImpl continuationImpl);

    public abstract Object n(ContinuationImpl continuationImpl);
}
