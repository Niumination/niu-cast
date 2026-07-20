package uf;

import ag.q;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import oh.u0;
import pf.f0;
import qg.y0;
import se.w2;
import se.x2;
import zf.j0;
import zf.x;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    /* JADX WARN: Code duplicated, block: B:51:0x0101 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x0102  */
    /* JADX WARN: Code duplicated, block: B:54:0x0107 A[Catch: all -> 0x0058, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0058, blocks: (B:21:0x0053, B:73:0x015c, B:74:0x0165, B:26:0x0069, B:62:0x012a, B:59:0x011a, B:70:0x014a, B:34:0x0096, B:54:0x0107, B:75:0x0166, B:76:0x016d), top: B:92:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0118 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x0119  */
    /* JADX WARN: Code duplicated, block: B:61:0x0129 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:65:0x0144 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:72:0x015b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:75:0x0166 A[Catch: all -> 0x0058, TryCatch #3 {all -> 0x0058, blocks: (B:21:0x0053, B:73:0x015c, B:74:0x0165, B:26:0x0069, B:62:0x012a, B:59:0x011a, B:70:0x014a, B:34:0x0096, B:54:0x0107, B:75:0x0166, B:76:0x016d), top: B:92:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Class, java.lang.Class<uf.d>] */
    /* JADX WARN: Type inference failed for: r0v1, types: [wf.j] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v13, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r6v44 */
    /* JADX WARN: Type inference failed for: r7v0, types: [uf.a] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, se.w2] */
    /* JADX WARN: Type inference failed for: r8v1, types: [wf.b] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v4 */
    public static final Object a(jf.d dVar, a aVar, w2 w2Var, ContinuationImpl continuationImpl) throws Throwable {
        b bVar;
        wf.j jVar;
        ?? r10;
        wf.b bVar2;
        KType kTypeTypeOf;
        wf.j jVar2;
        ?? r7;
        wf.b bVar3;
        d dVar2;
        d dVar3;
        d dVar4;
        ?? r11 = d.class;
        if (continuationImpl instanceof b) {
            bVar = (b) continuationImpl;
            int i8 = bVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                bVar.label = i8 - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuationImpl);
            }
        } else {
            bVar = new b(continuationImpl);
        }
        Object objC = bVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
                switch (bVar.label) {
                    case 0:
                        ResultKt.throwOnFailure(objC);
                        f0.a(dVar, m.f10434d);
                        vf.c cVar = new vf.c();
                        q block = new q(17);
                        Intrinsics.checkNotNullParameter(block, "block");
                        j0 j0Var = cVar.f10557a;
                        block.invoke(j0Var, j0Var);
                        aVar.invoke(cVar);
                        wf.j jVar3 = new wf.j(cVar, dVar);
                        bVar.L$0 = w2Var;
                        bVar.L$1 = jVar3;
                        bVar.label = 1;
                        objC = jVar3.c(bVar);
                        if (objC == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        jVar = jVar3;
                        r10 = w2Var;
                        bVar2 = (wf.b) objC;
                        try {
                            kf.c cVarB = bVar2.b();
                            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(r11);
                            try {
                                kTypeTypeOf = Reflection.typeOf((Class) r11);
                            } catch (Throwable unused) {
                                kTypeTypeOf = null;
                            }
                            ih.a aVar2 = new ih.a(orCreateKotlinClass, kTypeTypeOf);
                            bVar.L$0 = r10;
                            bVar.L$1 = jVar;
                            bVar.L$2 = bVar2;
                            bVar.label = 2;
                            objC = cVarB.a(aVar2, bVar);
                            if (objC == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            jVar2 = jVar;
                            r7 = r10;
                            bVar3 = bVar2;
                            if (objC == null) {
                                throw new NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession");
                            }
                            dVar2 = (d) objC;
                            try {
                                bVar.L$0 = jVar2;
                                bVar.L$1 = bVar3;
                                bVar.L$2 = dVar2;
                                bVar.label = 3;
                                if (r7.invoke(dVar2, bVar) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                dVar4 = dVar2;
                                bVar.L$0 = jVar2;
                                bVar.L$1 = bVar3;
                                bVar.L$2 = dVar4;
                                bVar.label = 4;
                                if (u0.b(dVar4, new oh.c(oh.b.NORMAL, ""), bVar) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                dVar4.f10425a.o().h(null);
                                bVar.L$0 = Unit.INSTANCE;
                                bVar.L$1 = null;
                                bVar.L$2 = null;
                                bVar.label = 6;
                                if (jVar2.a(bVar3, bVar) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            } catch (Throwable th2) {
                                th = th2;
                                dVar3 = dVar2;
                                bVar.L$0 = jVar2;
                                bVar.L$1 = bVar3;
                                bVar.L$2 = dVar3;
                                bVar.L$3 = th;
                                bVar.label = 5;
                                if (u0.b(dVar3, new oh.c(oh.b.NORMAL, ""), bVar) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                dVar3.f10425a.o().h(null);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            r11 = jVar;
                            th = th3;
                            w2Var = bVar2;
                            bVar.L$0 = th;
                            bVar.L$1 = null;
                            bVar.L$2 = null;
                            bVar.L$3 = null;
                            bVar.label = 7;
                            if (r11.a(w2Var, bVar) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            throw th;
                        }
                        break;
                    case 1:
                        jVar = (wf.j) bVar.L$1;
                        Function2 function2 = (Function2) bVar.L$0;
                        ResultKt.throwOnFailure(objC);
                        r10 = function2;
                        bVar2 = (wf.b) objC;
                        kf.c cVarB2 = bVar2.b();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(r11);
                        kTypeTypeOf = Reflection.typeOf((Class) r11);
                        ih.a aVar3 = new ih.a(orCreateKotlinClass2, kTypeTypeOf);
                        bVar.L$0 = r10;
                        bVar.L$1 = jVar;
                        bVar.L$2 = bVar2;
                        bVar.label = 2;
                        objC = cVarB2.a(aVar3, bVar);
                        if (objC == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        jVar2 = jVar;
                        r7 = r10;
                        bVar3 = bVar2;
                        if (objC == null) {
                            throw new NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession");
                        }
                        dVar2 = (d) objC;
                        bVar.L$0 = jVar2;
                        bVar.L$1 = bVar3;
                        bVar.L$2 = dVar2;
                        bVar.label = 3;
                        if (r7.invoke(dVar2, bVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        dVar4 = dVar2;
                        bVar.L$0 = jVar2;
                        bVar.L$1 = bVar3;
                        bVar.L$2 = dVar4;
                        bVar.label = 4;
                        if (u0.b(dVar4, new oh.c(oh.b.NORMAL, ""), bVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        dVar4.f10425a.o().h(null);
                        bVar.L$0 = Unit.INSTANCE;
                        bVar.L$1 = null;
                        bVar.L$2 = null;
                        bVar.label = 6;
                        if (jVar2.a(bVar3, bVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 2:
                        bVar3 = (wf.b) bVar.L$2;
                        jVar2 = (wf.j) bVar.L$1;
                        Function2 function3 = (Function2) bVar.L$0;
                        ResultKt.throwOnFailure(objC);
                        r7 = function3;
                        if (objC == null) {
                            throw new NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession");
                        }
                        dVar2 = (d) objC;
                        bVar.L$0 = jVar2;
                        bVar.L$1 = bVar3;
                        bVar.L$2 = dVar2;
                        bVar.label = 3;
                        if (r7.invoke(dVar2, bVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        dVar4 = dVar2;
                        bVar.L$0 = jVar2;
                        bVar.L$1 = bVar3;
                        bVar.L$2 = dVar4;
                        bVar.label = 4;
                        if (u0.b(dVar4, new oh.c(oh.b.NORMAL, ""), bVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        dVar4.f10425a.o().h(null);
                        bVar.L$0 = Unit.INSTANCE;
                        bVar.L$1 = null;
                        bVar.L$2 = null;
                        bVar.label = 6;
                        if (jVar2.a(bVar3, bVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 3:
                        dVar4 = (d) bVar.L$2;
                        wf.b bVar4 = (wf.b) bVar.L$1;
                        wf.j jVar4 = (wf.j) bVar.L$0;
                        try {
                            ResultKt.throwOnFailure(objC);
                            jVar2 = jVar4;
                            bVar3 = bVar4;
                            bVar.L$0 = jVar2;
                            bVar.L$1 = bVar3;
                            bVar.L$2 = dVar4;
                            bVar.label = 4;
                            if (u0.b(dVar4, new oh.c(oh.b.NORMAL, ""), bVar) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            dVar4.f10425a.o().h(null);
                            bVar.L$0 = Unit.INSTANCE;
                            bVar.L$1 = null;
                            bVar.L$2 = null;
                            bVar.label = 6;
                            if (jVar2.a(bVar3, bVar) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        } catch (Throwable th4) {
                            jVar2 = jVar4;
                            bVar3 = bVar4;
                            dVar3 = dVar4;
                            th = th4;
                            bVar.L$0 = jVar2;
                            bVar.L$1 = bVar3;
                            bVar.L$2 = dVar3;
                            bVar.L$3 = th;
                            bVar.label = 5;
                            if (u0.b(dVar3, new oh.c(oh.b.NORMAL, ""), bVar) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            dVar3.f10425a.o().h(null);
                            throw th;
                        }
                    case 4:
                        dVar4 = (d) bVar.L$2;
                        bVar3 = (wf.b) bVar.L$1;
                        jVar2 = (wf.j) bVar.L$0;
                        ResultKt.throwOnFailure(objC);
                        dVar4.f10425a.o().h(null);
                        bVar.L$0 = Unit.INSTANCE;
                        bVar.L$1 = null;
                        bVar.L$2 = null;
                        bVar.label = 6;
                        if (jVar2.a(bVar3, bVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 5:
                        th = (Throwable) bVar.L$3;
                        dVar3 = (d) bVar.L$2;
                        ResultKt.throwOnFailure(objC);
                        dVar3.f10425a.o().h(null);
                        throw th;
                    case 6:
                        ResultKt.throwOnFailure(objC);
                        return Unit.INSTANCE;
                    case 7:
                        th = (Throwable) bVar.L$0;
                        ResultKt.throwOnFailure(objC);
                        throw th;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (CancellationException e) {
            throw xf.a.a(e);
        }
    }

    public static Object b(jf.d dVar, x xVar, String str, Integer num, w2 w2Var, x2 x2Var) throws Throwable {
        Object objA = a(dVar, new a(xVar, str, num, "/ws", new y0(12)), w2Var, x2Var);
        if (objA != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            objA = Unit.INSTANCE;
        }
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }
}
