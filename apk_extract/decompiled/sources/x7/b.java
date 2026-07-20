package x7;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends SuspendLambda implements Function2 {
    final /* synthetic */ String $filePackageName;
    final /* synthetic */ List<String> $files;
    final /* synthetic */ String $key;
    final /* synthetic */ int $transportMode;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(List<String> list, int i8, String str, String str2, Continuation<? super b> continuation) {
        super(2, continuation);
        this.$files = list;
        this.$transportMode = i8;
        this.$filePackageName = str;
        this.$key = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new b(this.$files, this.$transportMode, this.$filePackageName, this.$key, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        f.f10882a.sendFile(this.$files, this.$transportMode, this.$filePackageName, this.$key);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((b) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
