package nf;

import ag.q0;
import java.io.EOFException;
import java.util.LinkedHashMap;
import jh.j0;
import jh.o0;
import kotlin.ExceptionsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.f0;
import li.g0;
import li.h0;
import m3.b6;
import oh.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends SuspendLambda implements Function2 {
    final /* synthetic */ CoroutineContext $callContext;
    final /* synthetic */ jh.o $input;
    final /* synthetic */ j0 $output;
    final /* synthetic */ vf.d $request;
    final /* synthetic */ ch.d $requestTime;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(jh.o oVar, j0 j0Var, CoroutineContext coroutineContext, ch.d dVar, vf.d dVar2, Continuation<? super v> continuation) {
        super(2, continuation);
        this.$input = oVar;
        this.$output = j0Var;
        this.$callContext = coroutineContext;
        this.$requestTime = dVar;
        this.$request = dVar2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new v(this.$input, this.$output, this.$callContext, this.$requestTime, this.$request, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0061  */
    /* JADX WARN: Code duplicated, block: B:25:0x006b A[Catch: all -> 0x005b, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x005b, blocks: (B:16:0x0050, B:18:0x0056, B:25:0x006b, B:30:0x009c), top: B:73:0x0050 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0071  */
    /* JADX WARN: Code duplicated, block: B:30:0x009c A[Catch: all -> 0x005b, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x005b, blocks: (B:16:0x0050, B:18:0x0056, B:25:0x006b, B:30:0x009c), top: B:73:0x0050 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:43:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:56:0x013e A[Catch: all -> 0x0126, TRY_LEAVE, TryCatch #1 {all -> 0x0126, blocks: (B:46:0x0117, B:54:0x0134, B:56:0x013e, B:59:0x0149, B:60:0x014e, B:53:0x012c), top: B:70:0x00d1 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0149 A[Catch: all -> 0x0126, TRY_ENTER, TryCatch #1 {all -> 0x0126, blocks: (B:46:0x0117, B:54:0x0134, B:56:0x013e, B:59:0x0149, B:60:0x014e, B:53:0x012c), top: B:70:0x00d1 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v3, types: [ag.x] */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r19v5 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG;
        Object obj2;
        Object obj3;
        Throwable th2;
        ?? r19;
        long j8;
        bg.b bVarB;
        String string;
        zf.t tVar;
        zf.y yVarA;
        Object obj4;
        Object obj5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            jh.o oVar = this.$input;
            this.label = 1;
            objG = ag.b0.g(oVar, this);
            if (objG == coroutine_suspended) {
                obj2 = objG;
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        }
        obj2 = objG;
        q0 q0Var = (q0) obj2;
        if (q0Var == null) {
            throw new EOFException("Failed to parse HTTP response: the server prematurely closed the connection");
        }
        ag.v vVar = q0Var.f797a;
        jh.o input = this.$input;
        j0 output = this.$output;
        CoroutineContext coroutineContext = this.$callContext;
        ch.d dVar = this.$requestTime;
        vf.d dVar2 = this.$request;
        try {
            int i9 = q0Var.f783d;
            zf.z zVar = new zf.z(i9, q0Var.e.toString());
            String[] strArr = zf.v.f11551a;
            bg.b bVarB2 = vVar.b("Content-Length");
            if (bVarB2 != null) {
                try {
                    String string2 = bVarB2.toString();
                    if (string2 != null) {
                        j8 = Long.parseLong(string2);
                    } else {
                        j8 = -1;
                    }
                    bVarB = vVar.b("Transfer-Encoding");
                    if (bVarB != null) {
                        string = bVarB.toString();
                    } else {
                        string = null;
                    }
                    ag.r rVar = ag.r.e;
                    ag.r rVarA = g3.g.a(vVar.b("Connection"));
                    LinkedHashMap values = b0.d(vVar);
                    Intrinsics.checkNotNullParameter(values, "values");
                    tVar = new zf.t(values);
                    zf.y yVar = zf.y.f11560d;
                    yVarA = b6.a(q0Var.f782c);
                    if (Intrinsics.areEqual(zVar, zf.z.f11565d)) {
                        Intrinsics.checkNotNullParameter(input, "input");
                        Intrinsics.checkNotNullParameter(output, "output");
                        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
                        vf.g gVar = new vf.g(zVar, dVar, tVar, yVarA, new i0(input, output, 2147483647L, true, coroutineContext), coroutineContext);
                        q0Var.close();
                        return gVar;
                    }
                    try {
                        if (!Intrinsics.areEqual(dVar2.f10562b, zf.x.f11556g) || CollectionsKt.listOf((Object[]) new zf.z[]{zf.z.f11570l, zf.z.f11566h}).contains(zVar)) {
                            jh.o.f6299a.getClass();
                            obj4 = jh.n.f6298b;
                        } else {
                            Intrinsics.checkNotNullParameter(zVar, "<this>");
                            if (i9 / 100 == 1) {
                                jh.o.f6299a.getClass();
                                obj4 = jh.n.f6298b;
                            } else {
                                obj4 = o0.g(h0.a(coroutineContext.plus(new f0("Response"))), null, true, new u(yVarA, j8, string, rVarA, input, null), 1).f6311a;
                            }
                        }
                        obj5 = obj4;
                        if (dVar2.f.d(vf.e.f10566a) == null) {
                            throw new ClassCastException();
                        }
                        vf.g gVar2 = new vf.g(zVar, dVar, tVar, yVarA, obj5, coroutineContext);
                        q0Var.close();
                        return gVar2;
                    } catch (Throwable th3) {
                        th = th3;
                        obj3 = obj;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    r19 = q0Var;
                }
                th2 = th;
                r19 = obj3;
            } else {
                j8 = -1;
                bVarB = vVar.b("Transfer-Encoding");
                if (bVarB != null) {
                    string = bVarB.toString();
                } else {
                    string = null;
                }
                ag.r rVar2 = ag.r.e;
                ag.r rVarA2 = g3.g.a(vVar.b("Connection"));
                LinkedHashMap values2 = b0.d(vVar);
                Intrinsics.checkNotNullParameter(values2, "values");
                tVar = new zf.t(values2);
                zf.y yVar2 = zf.y.f11560d;
                yVarA = b6.a(q0Var.f782c);
                if (Intrinsics.areEqual(zVar, zf.z.f11565d)) {
                    Intrinsics.checkNotNullParameter(input, "input");
                    Intrinsics.checkNotNullParameter(output, "output");
                    Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
                    vf.g gVar3 = new vf.g(zVar, dVar, tVar, yVarA, new i0(input, output, 2147483647L, true, coroutineContext), coroutineContext);
                    q0Var.close();
                    return gVar3;
                }
                if (Intrinsics.areEqual(dVar2.f10562b, zf.x.f11556g)) {
                    jh.o.f6299a.getClass();
                    obj4 = jh.n.f6298b;
                } else {
                    jh.o.f6299a.getClass();
                    obj4 = jh.n.f6298b;
                }
                obj5 = obj4;
                if (dVar2.f.d(vf.e.f10566a) == null) {
                    throw new ClassCastException();
                }
                vf.g gVar4 = new vf.g(zVar, dVar, tVar, yVarA, obj5, coroutineContext);
                q0Var.close();
                return gVar4;
                th2 = th;
                r19 = obj3;
            }
        } catch (Throwable th5) {
            th = th5;
            obj3 = q0Var;
        }
        try {
            r19.close();
            throw th2;
        } catch (Throwable th6) {
            ExceptionsKt.addSuppressed(th2, th6);
            throw th2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super vf.g> continuation) {
        return ((v) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
