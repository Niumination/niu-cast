package bb;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.r0;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends SuspendLambda implements Function2 {
    final /* synthetic */ boolean $isDelete;
    int label;
    final /* synthetic */ r this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(boolean z2, r rVar, Continuation<? super p> continuation) {
        super(2, continuation);
        this.$isDelete = z2;
        this.this$0 = rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new p(this.$isDelete, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$isDelete || !this.this$0.f1242b) {
                this.label = 2;
                if (r0.a(500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.label = 1;
                if (r0.a(2000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i8 != 1 && i8 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        String strO = o.d.o("<refreshUIData> isUiRefresh:", this.this$0.f1242b, "BleScanDataFilterHelper", "tag", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("BleScanDataFilterHelper"), strO);
        }
        Collection collectionValues = this.this$0.f1244d.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        List listSortedWith = CollectionsKt.sortedWith(collectionValues, this.this$0.f1250l);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(listSortedWith);
        this.this$0.f1242b = !arrayList.isEmpty();
        zb.b bVar = this.this$0.f1247i;
        if (bVar != null) {
            bVar.invoke(arrayList);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((p) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
