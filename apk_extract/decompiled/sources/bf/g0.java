package bf;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 implements oi.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ oi.b0 f1283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f1284b;

    public g0(oi.b0 b0Var, Function2 function2) {
        this.f1283a = b0Var;
        this.f1284b = function2;
    }

    @Override // oi.h
    public final Object a(oi.i iVar, Continuation continuation) throws Throwable {
        Object objA = this.f1283a.a(new f0(iVar, this.f1284b), continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }
}
