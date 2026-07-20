package nf;

import ag.p0;
import ag.q0;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import jh.g0;
import jh.j0;
import jh.o0;
import jh.v0;
import k3.ha;
import kotlin.ExceptionsKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import li.f0;
import li.h0;
import li.j1;
import li.l0;
import m3.e6;
import m3.h6;
import zf.r0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b0 {
    public static final j0 a(jh.k kVar, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        l0.k(coroutineContext).A(new jh.l(kVar, 3));
        x block = new x(kVar, null);
        j1 j1Var = j1.f7459a;
        Intrinsics.checkNotNullParameter(j1Var, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(block, "block");
        return g0.p(j1Var, coroutineContext, new jh.k(false), block).f6306a;
    }

    public static final Object b(cg.j jVar, j0 j0Var, y yVar) throws Throwable {
        if (jVar instanceof cg.f) {
            byte[] bArrE = ((cg.f) jVar).e();
            jh.l0 l0Var = o0.f6300a;
            Object objD = o0.d(j0Var, bArrE, 0, bArrE.length, yVar);
            return objD == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objD : Unit.INSTANCE;
        }
        if (jVar instanceof cg.i) {
            Object objA = g0.a(((cg.i) jVar).e(), j0Var, yVar);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
        }
        if (jVar instanceof cg.h) {
            throw new IllegalStateException("unreachable code");
        }
        if (jVar instanceof cg.g) {
            throw new IllegalStateException("unreachable code");
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:55:0x010f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x0115 A[Catch: all -> 0x0048, TRY_ENTER, TryCatch #3 {all -> 0x0048, blocks: (B:15:0x0043, B:65:0x013f, B:58:0x0115, B:60:0x011b, B:62:0x0127, B:73:0x0157, B:74:0x015e), top: B:91:0x002f, outer: #5 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x011b A[Catch: all -> 0x0048, TryCatch #3 {all -> 0x0048, blocks: (B:15:0x0043, B:65:0x013f, B:58:0x0115, B:60:0x011b, B:62:0x0127, B:73:0x0157, B:74:0x015e), top: B:91:0x002f, outer: #5 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0127 A[Catch: all -> 0x0048, TryCatch #3 {all -> 0x0048, blocks: (B:15:0x0043, B:65:0x013f, B:58:0x0115, B:60:0x011b, B:62:0x0127, B:73:0x0157, B:74:0x015e), top: B:91:0x002f, outer: #5 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x013e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:67:0x014a A[Catch: all -> 0x014e, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x014e, blocks: (B:67:0x014a, B:84:0x016e, B:56:0x0110, B:85:0x016f, B:86:0x0176, B:15:0x0043, B:65:0x013f, B:58:0x0115, B:60:0x011b, B:62:0x0127, B:73:0x0157, B:74:0x015e, B:83:0x016d, B:80:0x0167, B:76:0x0161), top: B:91:0x002f, inners: #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0157 A[Catch: all -> 0x0048, TRY_ENTER, TryCatch #3 {all -> 0x0048, blocks: (B:15:0x0043, B:65:0x013f, B:58:0x0115, B:60:0x011b, B:62:0x0127, B:73:0x0157, B:74:0x015e), top: B:91:0x002f, outer: #5 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    /* JADX WARN: Code duplicated, block: B:85:0x016f A[Catch: all -> 0x014e, TryCatch #5 {all -> 0x014e, blocks: (B:67:0x014a, B:84:0x016e, B:56:0x0110, B:85:0x016f, B:86:0x0176, B:15:0x0043, B:65:0x013f, B:58:0x0115, B:60:0x011b, B:62:0x0127, B:73:0x0157, B:74:0x015e, B:83:0x016d, B:80:0x0167, B:76:0x0161), top: B:91:0x002f, inners: #3, #4 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.Closeable, java.lang.Object, jh.j0] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public static final Object c(vf.d dVar, jh.k kVar, jh.k kVar2, ContinuationImpl continuationImpl) throws Throwable {
        w wVar;
        p0 p0Var;
        jh.o oVar;
        ?? r7;
        p0 p0Var2;
        p0 p0Var3;
        q0 q0Var;
        bg.b bVarB;
        Closeable closeable;
        Closeable closeable2;
        ?? r10 = kVar;
        if (continuationImpl instanceof w) {
            wVar = (w) continuationImpl;
            int i8 = wVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                wVar.label = i8 - Integer.MIN_VALUE;
            } else {
                wVar = new w(continuationImpl);
            }
        } else {
            wVar = new w(continuationImpl);
        }
        Object objG = wVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = wVar.label;
        try {
            try {
                try {
                    if (i9 != 0) {
                        if (i9 == 1) {
                            p0 p0Var4 = (p0) wVar.L$2;
                            oVar = (jh.o) wVar.L$1;
                            j0 j0Var = (j0) wVar.L$0;
                            ResultKt.throwOnFailure(objG);
                            p0Var = p0Var4;
                            r7 = j0Var;
                        } else {
                            if (i9 == 2) {
                                p0Var2 = (p0) wVar.L$1;
                                oVar = (jh.o) wVar.L$0;
                                ResultKt.throwOnFailure(objG);
                                wVar.L$0 = oVar;
                                wVar.L$1 = p0Var2;
                                wVar.label = 3;
                                objG = ag.b0.g(oVar, wVar);
                                if (objG == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                p0Var3 = p0Var2;
                                q0Var = (q0) objG;
                                if (q0Var == null) {
                                    throw new EOFException("Failed to parse CONNECT response: unexpected EOF");
                                }
                                if (q0Var.f783d / 200 != 1) {
                                    throw new IOException("Can not establish tunnel connection");
                                }
                                ag.v vVar = q0Var.f797a;
                                String[] strArr = zf.v.f11551a;
                                bVarB = vVar.b("Content-Length");
                                if (bVarB != null) {
                                    long j8 = Long.parseLong(bVarB.toString());
                                    wVar.L$0 = p0Var3;
                                    wVar.L$1 = q0Var;
                                    wVar.I$0 = 0;
                                    wVar.label = 4;
                                    objG = g0.d(oVar, j8, wVar);
                                    if (objG == coroutine_suspended) {
                                        closeable = q0Var;
                                        closeable2 = q0Var;
                                        return coroutine_suspended;
                                    }
                                }
                                if (closeable != null) {
                                    closeable.close();
                                }
                                p0Var3.getClass();
                                return Unit.INSTANCE;
                            }
                            if (i9 == 3) {
                                p0Var2 = (p0) wVar.L$1;
                                oVar = (jh.o) wVar.L$0;
                                ResultKt.throwOnFailure(objG);
                                p0Var3 = p0Var2;
                                q0Var = (q0) objG;
                                if (q0Var == null) {
                                    throw new EOFException("Failed to parse CONNECT response: unexpected EOF");
                                }
                                if (q0Var.f783d / 200 != 1) {
                                    throw new IOException("Can not establish tunnel connection");
                                }
                                ag.v vVar2 = q0Var.f797a;
                                String[] strArr2 = zf.v.f11551a;
                                bVarB = vVar2.b("Content-Length");
                                if (bVarB != null) {
                                    long j10 = Long.parseLong(bVarB.toString());
                                    wVar.L$0 = p0Var3;
                                    wVar.L$1 = q0Var;
                                    wVar.I$0 = 0;
                                    wVar.label = 4;
                                    objG = g0.d(oVar, j10, wVar);
                                    if (objG == coroutine_suspended) {
                                        closeable = q0Var;
                                        closeable2 = q0Var;
                                        return coroutine_suspended;
                                    }
                                }
                                if (closeable != null) {
                                    closeable.close();
                                }
                                p0Var3.getClass();
                                return Unit.INSTANCE;
                            }
                            if (i9 != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            Closeable closeable3 = (Closeable) wVar.L$1;
                            p0Var3 = (p0) wVar.L$0;
                            ResultKt.throwOnFailure(objG);
                            closeable2 = closeable3;
                        }
                        closeable = q0Var;
                        closeable2 = q0Var;
                        Boxing.boxLong(((Number) objG).longValue());
                        closeable = closeable2;
                        if (closeable != null) {
                            closeable.close();
                        }
                        p0Var3.getClass();
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(objG);
                    p0Var = new p0();
                    try {
                        r0 r0Var = dVar.f10561a;
                        zf.t tVar = dVar.f10563c;
                        String strB = h6.b(r0Var);
                        p0Var.c(new zf.x("CONNECT"), strB, zf.y.e.toString());
                        String[] strArr3 = zf.v.f11551a;
                        p0Var.b("Host", strB);
                        p0Var.b("Proxy-Connection", "Keep-Alive");
                        String str = tVar.get("User-Agent");
                        if (str != null) {
                            p0Var.b("User-Agent", str);
                        }
                        String str2 = tVar.get("Proxy-Authenticate");
                        if (str2 != null) {
                            p0Var.b("Proxy-Authenticate", str2);
                        }
                        String str3 = tVar.get("Proxy-Authorization");
                        if (str3 != null) {
                            p0Var.b("Proxy-Authorization", str3);
                        }
                        p0Var.a();
                        wi.a aVar = p0Var.f780a;
                        Intrinsics.checkNotNullParameter(aVar, "<this>");
                        wVar.L$0 = r10;
                        wVar.L$1 = kVar2;
                        wVar.L$2 = p0Var;
                        wVar.label = 1;
                        if (o0.e(r10, aVar, wVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        oVar = kVar2;
                        r7 = r10;
                    } catch (Throwable th2) {
                        th = th2;
                        r10 = p0Var;
                        r10.getClass();
                        throw th;
                    }
                    wVar.L$0 = oVar;
                    wVar.L$1 = p0Var;
                    wVar.L$2 = null;
                    wVar.label = 2;
                    if (((jh.k) r7).h(wVar) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    p0Var2 = p0Var;
                    wVar.L$0 = oVar;
                    wVar.L$1 = p0Var2;
                    wVar.label = 3;
                    objG = ag.b0.g(oVar, wVar);
                    if (objG == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    p0Var3 = p0Var2;
                    q0Var = (q0) objG;
                    if (q0Var == null) {
                        throw new EOFException("Failed to parse CONNECT response: unexpected EOF");
                    }
                    if (q0Var.f783d / 200 != 1) {
                        throw new IOException("Can not establish tunnel connection");
                    }
                    ag.v vVar3 = q0Var.f797a;
                    String[] strArr4 = zf.v.f11551a;
                    bVarB = vVar3.b("Content-Length");
                    if (bVarB != null) {
                        long j11 = Long.parseLong(bVarB.toString());
                        wVar.L$0 = p0Var3;
                        wVar.L$1 = q0Var;
                        wVar.I$0 = 0;
                        wVar.label = 4;
                        objG = g0.d(oVar, j11, wVar);
                        if (objG == coroutine_suspended) {
                            closeable = q0Var;
                            closeable2 = q0Var;
                            return coroutine_suspended;
                        }
                        closeable = q0Var;
                        closeable2 = q0Var;
                        Boxing.boxLong(((Number) objG).longValue());
                        closeable = closeable2;
                    }
                    if (closeable != null) {
                        closeable.close();
                    }
                    p0Var3.getClass();
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                if (r10 == 0) {
                    throw th4;
                }
                try {
                    try {
                        r10.close();
                        throw th4;
                    } catch (Throwable th5) {
                        ExceptionsKt.addSuppressed(th4, th5);
                        throw th4;
                    }
                } catch (Throwable th6) {
                    throw th6;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            r10 = "Proxy-Authorization";
            r10.getClass();
            throw th;
        }
    }

    public static final LinkedHashMap d(ag.v vVar) {
        Intrinsics.checkNotNullParameter(vVar, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i8 = vVar.f793b;
        for (int i9 = 0; i9 < i8; i9++) {
            String string = vVar.c(i9).toString();
            String string2 = vVar.f(i9).toString();
            List list = (List) linkedHashMap.get(string);
            if ((list != null ? Boolean.valueOf(list.add(string2)) : null) == null) {
                linkedHashMap.put(string, CollectionsKt.mutableListOf(string2));
            }
        }
        return linkedHashMap;
    }

    public static Unit e(vf.d dVar, j0 output, CoroutineContext coroutineContext) {
        v0 v0VarP;
        cg.j jVar = dVar.f10564d;
        if (jVar instanceof cg.g) {
            ha.a(output);
            return Unit.INSTANCE;
        }
        if (jVar instanceof cg.h) {
            throw new kf.j(jVar);
        }
        String[] strArr = zf.v.f11551a;
        zf.t tVar = dVar.f10563c;
        String string = tVar.get("Content-Length");
        if (string == null) {
            Long lA = jVar.a();
            string = lA != null ? lA.toString() : null;
        }
        String str = tVar.get("Transfer-Encoding");
        String str2 = jVar.c().get("Transfer-Encoding");
        if (string == null || Intrinsics.areEqual(str2, "chunked") || Intrinsics.areEqual(str, "chunked")) {
            ag.k kVar = ag.p.f777a;
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
            ag.m block = new ag.m(output, null);
            j1 j1Var = j1.f7459a;
            Intrinsics.checkNotNullParameter(j1Var, "<this>");
            Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
            Intrinsics.checkNotNullParameter(block, "block");
            v0VarP = g0.p(j1Var, coroutineContext, new jh.k(false), block);
        } else {
            v0VarP = null;
        }
        l0.p(h0.a(coroutineContext.plus(new f0("Request body writer"))), null, null, new y(dVar, jVar, v0VarP != null ? v0VarP.f6306a : output, v0VarP, output, true, null), 3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:114:0x01d9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:134:0x01ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:99:0x01b2 A[RETURN] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v38, types: [java.lang.Object, jh.j0] */
    /* JADX WARN: Type inference failed for: r1v53 */
    /* JADX WARN: Type inference failed for: r1v54 */
    /* JADX WARN: Type inference failed for: r1v6, types: [ag.p0] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [ag.p0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [int] */
    public static final Object f(vf.d dVar, j0 j0Var, boolean z2, boolean z3, ContinuationImpl continuationImpl) throws Throwable {
        z zVar;
        ?? r7;
        ?? p0Var;
        Object obj;
        ?? r10;
        ?? r11;
        Throwable th2;
        ?? r12;
        z zVar2;
        r0 r0VarB;
        if (continuationImpl instanceof z) {
            zVar = (z) continuationImpl;
            int i8 = zVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                zVar.label = i8 - Integer.MIN_VALUE;
            } else {
                zVar = new z(continuationImpl);
            }
        } else {
            zVar = new z(continuationImpl);
        }
        Object obj2 = zVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r13 = zVar.label;
        if (r13 != 0) {
            try {
                if (r13 == 1) {
                    boolean z5 = zVar.Z$0;
                    p0 p0Var2 = (p0) zVar.L$1;
                    j0 j0Var2 = (j0) zVar.L$0;
                    ResultKt.throwOnFailure(obj2);
                    r7 = z5;
                    p0Var = p0Var2;
                    obj = coroutine_suspended;
                    r10 = j0Var2;
                    try {
                        zVar.L$0 = r10;
                        zVar.L$1 = p0Var;
                        zVar.Z$0 = r7;
                        zVar.label = 2;
                        if (((jh.k) r10).h(zVar) == obj) {
                            return obj;
                        }
                        r12 = p0Var;
                    } catch (Throwable th3) {
                        th = th3;
                        if (r7 != 0) {
                            try {
                                zVar.L$0 = p0Var;
                                zVar.L$1 = th;
                                zVar.label = 3;
                                if (((jh.k) r10).i(zVar) == obj) {
                                    return obj;
                                }
                            } catch (Throwable th4) {
                                th2 = th4;
                                r11 = p0Var;
                                r11.getClass();
                                throw th2;
                            }
                        }
                        r11 = p0Var;
                        throw th;
                    }
                } else {
                    if (r13 != 2) {
                        if (r13 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        th = (Throwable) zVar.L$1;
                        r11 = (p0) zVar.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            r11 = r11;
                            throw th;
                        } catch (Throwable th5) {
                            th2 = th5;
                            r11.getClass();
                            throw th2;
                        }
                    }
                    boolean z10 = zVar.Z$0;
                    p0 p0Var3 = (p0) zVar.L$1;
                    ResultKt.throwOnFailure(obj2);
                    r12 = p0Var3;
                }
                r12.getClass();
                return Unit.INSTANCE;
            } catch (Throwable th6) {
                th = th6;
                r7 = j0Var;
                p0Var = "Host";
                obj = coroutine_suspended;
                r10 = r13;
                if (r7 != 0) {
                    zVar.L$0 = p0Var;
                    zVar.L$1 = th;
                    zVar.label = 3;
                    if (((jh.k) r10).i(zVar) == obj) {
                        return obj;
                    }
                }
                r11 = p0Var;
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj2);
        p0Var = new p0();
        zf.x xVar = dVar.f10562b;
        r0 url = dVar.f10561a;
        String[] strArr = zf.v.f11551a;
        zf.t tVar = dVar.f10563c;
        String string = tVar.get("Content-Length");
        cg.j body = dVar.f10564d;
        if (string == null) {
            Long lA = body.a();
            string = lA != null ? lA.toString() : null;
        }
        String str = tVar.get("Transfer-Encoding");
        String str2 = body.c().get("Transfer-Encoding");
        boolean z11 = false;
        boolean z12 = string == null || Intrinsics.areEqual(str2, "chunked") || Intrinsics.areEqual(str, "chunked");
        String str3 = tVar.get("Expect");
        try {
            if (url.f11541g.isEmpty()) {
                try {
                    Intrinsics.checkNotNullParameter(url, "url");
                    zf.j0 j0Var3 = new zf.j0();
                    h6.c(j0Var3, url);
                    zVar2 = zVar;
                    try {
                        e6.d(j0Var3, "/");
                        r0VarB = j0Var3.b();
                    } catch (Throwable th7) {
                        th = th7;
                        r10 = j0Var;
                        r7 = z3;
                        obj = coroutine_suspended;
                        zVar = zVar2;
                        if (r7 != 0) {
                            zVar.L$0 = p0Var;
                            zVar.L$1 = th;
                            zVar.label = 3;
                            if (((jh.k) r10).i(zVar) == obj) {
                                return obj;
                            }
                        }
                        r11 = p0Var;
                        throw th;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    zVar2 = zVar;
                    r10 = j0Var;
                    r7 = z3;
                    obj = coroutine_suspended;
                    zVar = zVar2;
                    if (r7 != 0) {
                        zVar.L$0 = p0Var;
                        zVar.L$1 = th;
                        zVar.label = 3;
                        if (((jh.k) r10).i(zVar) == obj) {
                            return obj;
                        }
                    }
                    r11 = p0Var;
                    throw th;
                }
            } else {
                zVar2 = zVar;
                r0VarB = url;
            }
            p0Var.c(xVar, z2 ? r0VarB.f : h6.a(r0VarB), zf.y.e.toString());
            Intrinsics.checkNotNullParameter("Host", "name");
            if (!(((List) tVar.f11607c.get("Host")) != null)) {
                p0Var.b("Host", url.f11544j.f11527b == url.a() ? url.f11537a : h6.b(url));
            }
            if (string != null && ((!Intrinsics.areEqual(xVar, zf.x.f11553b) && !Intrinsics.areEqual(xVar, zf.x.f11556g)) || !(body instanceof cg.g))) {
                p0Var.b("Content-Length", string);
            }
            mf.p.a(tVar, body, new lc.a((Object) p0Var, 3));
            if (z12 && str == null && str2 == null && !(body instanceof cg.g)) {
                p0Var.b("Transfer-Encoding", "chunked");
            }
            Intrinsics.checkNotNullParameter(body, "body");
            if (str3 != null && !(body instanceof cg.g)) {
                z11 = true;
            }
            if (z11) {
                Intrinsics.checkNotNull(str3);
                p0Var.b("Expect", str3);
            }
            p0Var.a();
            wi.a aVar = p0Var.f780a;
            Intrinsics.checkNotNullParameter(aVar, "<this>");
            r10 = j0Var;
            zVar = zVar2;
            try {
                zVar.L$0 = r10;
                zVar.L$1 = p0Var;
                r7 = z3;
                try {
                    zVar.Z$0 = r7;
                    zVar.label = 1;
                    Object objE = o0.e(r10, aVar, zVar);
                    obj = coroutine_suspended;
                    r10 = r10;
                    p0Var = p0Var;
                    r7 = r7;
                    if (objE == obj) {
                        return obj;
                    }
                    zVar.L$0 = r10;
                    zVar.L$1 = p0Var;
                    zVar.Z$0 = r7;
                    zVar.label = 2;
                    if (((jh.k) r10).h(zVar) == obj) {
                        return obj;
                    }
                    r12 = p0Var;
                    r12.getClass();
                    return Unit.INSTANCE;
                } catch (Throwable th9) {
                    th = th9;
                    obj = coroutine_suspended;
                    if (r7 != 0) {
                        zVar.L$0 = p0Var;
                        zVar.L$1 = th;
                        zVar.label = 3;
                        if (((jh.k) r10).i(zVar) == obj) {
                            return obj;
                        }
                    }
                    r11 = p0Var;
                    throw th;
                }
            } catch (Throwable th10) {
                th = th10;
                r7 = z3;
                obj = coroutine_suspended;
                if (r7 != 0) {
                    zVar.L$0 = p0Var;
                    zVar.L$1 = th;
                    zVar.label = 3;
                    if (((jh.k) r10).i(zVar) == obj) {
                        return obj;
                    }
                }
                r11 = p0Var;
                throw th;
            }
        } catch (Throwable th11) {
            th = th11;
            r10 = j0Var;
        }
    }
}
