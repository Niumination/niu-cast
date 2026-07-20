package ic;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import eb.e1;
import eb.t0;
import k3.gc;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import li.g2;
import li.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g2 f5742b;

    @Override // ic.h
    public final boolean a(hc.c device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return device instanceof hc.e;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // ic.h
    public final Object b(hc.c cVar, Continuation continuation) {
        n nVar;
        hc.b bVar;
        if (continuation instanceof n) {
            nVar = (n) continuation;
            int i8 = nVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                nVar.label = i8 - Integer.MIN_VALUE;
            } else {
                nVar = new n(this, continuation);
            }
        } else {
            nVar = new n(this, continuation);
        }
        Object objR = nVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = nVar.label;
        if (i9 != 0) {
            if (i9 == 1) {
                this = (r) nVar.L$0;
                ResultKt.throwOnFailure(objR);
            } else {
                if (i9 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bVar = (hc.b) nVar.L$0;
                ResultKt.throwOnFailure(objR);
            }
            if (((Boolean) objR).booleanValue()) {
                return bVar;
            }
            return new hc.b(false, null, null, null, 0, null, 0, 0, null, TypedValues.PositionType.TYPE_POSITION_TYPE);
        }
        ResultKt.throwOnFailure(objR);
        Intrinsics.checkNotNullParameter("USBConnectHelper", "tag");
        Intrinsics.checkNotNullParameter("start USB connect", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("USBConnectHelper"), "start USB connect");
        }
        na.n.b(true);
        nVar.L$0 = this;
        nVar.label = 1;
        li.l lVar = new li.l(1, IntrinsicsKt.intercepted(nVar));
        lVar.s();
        o oVar = new o(lVar, null);
        qi.c cVar2 = this.f5733a;
        this.f5742b = l0.p(cVar2, null, null, oVar, 3);
        e1 e1Var = new e1(this, lVar, 1);
        jc.a.a(e1Var);
        t0 t0Var = new t0(e1Var, 3);
        na.a.a(lVar, t0Var);
        lVar.v(t0Var);
        l0.p(cVar2, null, null, new p(e1Var, null), 3);
        objR = lVar.r();
        if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(nVar);
        }
        if (objR == coroutine_suspended) {
            return coroutine_suspended;
        }
        hc.b bVar2 = (hc.b) objR;
        if (!bVar2.f5279a) {
            na.n.b(false);
            return bVar2;
        }
        nVar.L$0 = bVar2;
        nVar.label = 2;
        Object objC = this.c(nVar);
        if (objC == coroutine_suspended) {
            return coroutine_suspended;
        }
        objR = objC;
        bVar = bVar2;
        if (((Boolean) objR).booleanValue()) {
            return new hc.b(false, null, null, null, 0, null, 0, 0, null, TypedValues.PositionType.TYPE_POSITION_TYPE);
        }
        return bVar;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0043  */
    /* JADX WARN: Code duplicated, block: B:19:0x004d  */
    /* JADX WARN: Code duplicated, block: B:21:0x0059  */
    /* JADX WARN: Code duplicated, block: B:24:0x0067  */
    /* JADX WARN: Code duplicated, block: B:26:0x0073 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0076  */
    /* JADX WARN: Code duplicated, block: B:30:0x0082  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0071 -> B:27:0x0074). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object c(kotlin.coroutines.jvm.internal.ContinuationImpl r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof ic.q
            if (r0 == 0) goto L13
            r0 = r9
            ic.q r0 = (ic.q) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            ic.q r0 = new ic.q
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L34
            if (r1 != r3) goto L2c
            int r1 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L74
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            kotlin.ResultKt.throwOnFailure(r8)
            r1 = r2
        L38:
            java.lang.String r8 = "USBConnectHelper"
            r4 = 31
            r5 = 3
            java.lang.String r6 = "log"
            java.lang.String r7 = "tag"
            if (r1 >= r4) goto L76
            android.app.Application r4 = k3.pb.a()
            boolean r4 = na.n.a(r4, r2)
            if (r4 == 0) goto L67
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r7)
            java.lang.String r9 = "setIpForward SUCCESS"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r6)
            int r0 = k3.gc.f6462a
            if (r0 > r5) goto L62
            java.lang.String r0 = k3.gc.f6463b
            java.lang.String r8 = r0.concat(r8)
            android.util.Log.d(r8, r9)
        L62:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r8
        L67:
            r0.I$0 = r1
            r0.label = r3
            r4 = 100
            java.lang.Object r8 = li.r0.a(r4, r0)
            if (r8 != r9) goto L74
            return r9
        L74:
            int r1 = r1 + r3
            goto L38
        L76:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r7)
            java.lang.String r9 = "setIpForward failed"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r6)
            int r0 = k3.gc.f6462a
            if (r0 > r5) goto L8b
            java.lang.String r0 = k3.gc.f6463b
            java.lang.String r8 = r0.concat(r8)
            android.util.Log.d(r8, r9)
        L8b:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ic.r.c(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
