package gc;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.welink.protocol.nfbd.c0;
import hc.c;
import hc.e;
import ic.g;
import ic.h;
import ic.m;
import ic.r;
import java.util.ArrayList;
import java.util.Iterator;
import k3.gc;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f5136a;

    public b() {
        ArrayList arrayList = new ArrayList();
        this.f5136a = arrayList;
        arrayList.add(new g());
        arrayList.add(new m());
        arrayList.add(new r());
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x00f5 A[PHI: r13
      0x00f5: PHI (r13v22 java.lang.Object) = (r13v18 java.lang.Object), (r13v1 java.lang.Object) binds: [B:48:0x00f2, B:12:0x002f] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Code duplicated, block: B:51:0x00bb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(c cVar, ContinuationImpl continuationImpl) {
        a aVar;
        Iterator it;
        Object next;
        h hVar;
        if (continuationImpl instanceof a) {
            aVar = (a) continuationImpl;
            int i8 = aVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                aVar.label = i8 - Integer.MIN_VALUE;
            } else {
                aVar = new a(this, continuationImpl);
            }
        } else {
            aVar = new a(this, continuationImpl);
        }
        Object objB = aVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = aVar.label;
        if (i9 != 0) {
            if (i9 == 1) {
                cVar = (c) aVar.L$1;
                this = (b) aVar.L$0;
                ResultKt.throwOnFailure(objB);
            } else {
                if (i9 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objB);
            }
            return objB;
        }
        ResultKt.throwOnFailure(objB);
        String strN = d.n("connectDevice:", cVar.f5288c, "ConnectApi", "tag", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("ConnectApi"), strN);
        }
        if (!(cVar instanceof e)) {
            Lazy lazy = mc.b.f7958a;
            c0 c0Var = mc.b.e().f9655c.f4191c;
            if ((c0Var != null ? c0Var.d() : 0) != 1) {
                aVar.L$0 = this;
                aVar.L$1 = cVar;
                aVar.label = 1;
                if (mc.b.e().a(true, aVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        it = this.f5136a.iterator();
        do {
            if (it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((h) next).a(cVar));
        hVar = (h) next;
        if (hVar == null) {
            Intrinsics.checkNotNullParameter("ConnectApi", "tag");
            Intrinsics.checkNotNullParameter("connectDevice:no connector", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("ConnectApi"), "connectDevice:no connector");
            }
            return new hc.b(false, null, null, null, 0, null, 0, 0, null, TypedValues.PositionType.TYPE_POSITION_TYPE);
        }
        aVar.L$0 = null;
        aVar.L$1 = null;
        aVar.label = 2;
        objB = hVar.b(cVar, aVar);
        if (objB == coroutine_suspended) {
            return coroutine_suspended;
        }
        return objB;
        Intrinsics.checkNotNullParameter("ConnectApi", "tag");
        Intrinsics.checkNotNullParameter("connectDevice:SmartConnect is enabled.", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("ConnectApi"), "connectDevice:SmartConnect is enabled.");
        }
        it = this.f5136a.iterator();
        do {
            if (it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((h) next).a(cVar));
        hVar = (h) next;
        if (hVar == null) {
            Intrinsics.checkNotNullParameter("ConnectApi", "tag");
            Intrinsics.checkNotNullParameter("connectDevice:no connector", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("ConnectApi"), "connectDevice:no connector");
            }
            return new hc.b(false, null, null, null, 0, null, 0, 0, null, TypedValues.PositionType.TYPE_POSITION_TYPE);
        }
        aVar.L$0 = null;
        aVar.L$1 = null;
        aVar.label = 2;
        objB = hVar.b(cVar, aVar);
        if (objB == coroutine_suspended) {
            return coroutine_suspended;
        }
        return objB;
    }
}
