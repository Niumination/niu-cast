package og;

import ag.p0;
import ag.r;
import jh.o0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.g2;
import li.l0;
import ng.d0;
import ni.q;
import ni.t;
import zf.y;
import zf.z;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wi.a f8469a;

    static {
        p0 p0Var = new p0();
        p0Var.d(z.f11573o.f11581a, "HTTP/1.0", "Bad Request");
        p0Var.b("Connection", "close");
        p0Var.a();
        wi.a aVar = p0Var.f780a;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        f8469a = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x008c  */
    /* JADX WARN: Code duplicated, block: B:28:0x009e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:29:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b3 A[Catch: all -> 0x003f, TRY_ENTER, TryCatch #0 {all -> 0x003f, blocks: (B:14:0x0039, B:37:0x00b3, B:40:0x00c6, B:21:0x005f), top: B:49:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [long] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [long] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [ni.f0] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [long] */
    /* JADX WARN: Type inference failed for: r9v4, types: [long] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object, ni.f0] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00d6 -> B:15:0x003c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:39:0x00c5
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object a(ni.f0 r9, long r10, og.c r12, kotlin.coroutines.jvm.internal.ContinuationImpl r13) {
        /*
            Method dump skipped, instruction units count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: og.j.a(ni.f0, long, og.c, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object b(q qVar, ContinuationImpl continuationImpl) {
        f fVar;
        q qVar2;
        jh.k kVar;
        if (continuationImpl instanceof f) {
            fVar = (f) continuationImpl;
            int i8 = fVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                fVar.label = i8 - Integer.MIN_VALUE;
            } else {
                fVar = new f(continuationImpl);
            }
        } else {
            fVar = new f(continuationImpl);
        }
        Object obj = fVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = fVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            jh.k kVar2 = new jh.k(false);
            if (!(qVar.f(kVar2) instanceof t)) {
                wi.a aVarC = lh.a.c(f8469a);
                fVar.L$0 = qVar;
                fVar.L$1 = kVar2;
                fVar.label = 1;
                if (o0.e(kVar2, aVarC, fVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                qVar2 = qVar;
                kVar = kVar2;
            }
            qVar.q(null);
            return Unit.INSTANCE;
        }
        if (i9 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kVar = (jh.k) fVar.L$1;
        qVar2 = (q) fVar.L$0;
        ResultKt.throwOnFailure(obj);
        kVar.a();
        qVar = qVar2;
        qVar.q(null);
        return Unit.INSTANCE;
    }

    public static final boolean c(y version, r rVar) {
        Intrinsics.checkNotNullParameter(version, "version");
        if (rVar == null) {
            y yVar = y.f11560d;
            if (Intrinsics.areEqual(version, y.f)) {
                return true;
            }
        }
        if (rVar == null) {
            y yVar2 = y.f11560d;
            if (!Intrinsics.areEqual(version, y.e)) {
                return true;
            }
        } else if (!rVar.f785b && rVar.f784a) {
            return true;
        }
        return false;
    }

    public static final g2 d(g0 startServerConnectionPipeline, c connection, long j8, Function3 handler) {
        Intrinsics.checkNotNullParameter(startServerConnectionPipeline, "$this$startServerConnectionPipeline");
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return l0.p(startServerConnectionPipeline, d0.f8257a, null, new i(connection, j8, handler, null), 2);
    }
}
