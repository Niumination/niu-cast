package kc;

import java.util.Iterator;
import java.util.List;
import k3.gc;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f6818a = CollectionsKt.listOf(new lc.b());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6820c;

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(int i8, Function1 function1, ContinuationImpl continuationImpl) {
        a aVar;
        Iterator it;
        int i9;
        if (continuationImpl instanceof a) {
            aVar = (a) continuationImpl;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(this, continuationImpl);
            }
        } else {
            aVar = new a(this, continuationImpl);
        }
        Object obj = aVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = aVar.label;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            gc.c("ScanApi", "startScan " + i8);
            Lazy lazy = mc.b.f7958a;
            mc.b.d();
            if (this.f6819b) {
                gc.c("ScanApi", "startScan:scan is already started");
                return Unit.INSTANCE;
            }
            this.f6819b = true;
            it = this.f6818a.iterator();
            i9 = i8;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i9 = aVar.I$0;
            it = (Iterator) aVar.L$1;
            function1 = (Function1) aVar.L$0;
            ResultKt.throwOnFailure(obj);
        }
        while (it.hasNext()) {
            lc.b bVar = (lc.b) it.next();
            bVar.getClass();
            if (i9 == 1 || i9 == 0) {
                aVar.L$0 = function1;
                aVar.L$1 = it;
                aVar.I$0 = i9;
                aVar.label = 1;
                Lazy lazy2 = mc.b.f7958a;
                mc.b.i(new lc.a(bVar, function1));
                if (Unit.INSTANCE == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
