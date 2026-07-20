package we;

import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class j implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10728a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FunctionReferenceImpl f10729b;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ j(Function2 function2) {
        this.f10729b = (FunctionReferenceImpl) function2;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.FunctionReferenceImpl] */
    /* JADX WARN: Type inference failed for: r2v3, types: [kotlin.jvm.functions.Function3, kotlin.jvm.internal.FunctionReferenceImpl] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f10728a) {
            case 0:
                Pair pair = (Pair) obj;
                Intrinsics.checkNotNullParameter(pair, "<destruct>");
                return this.f10729b.invoke(pair.component1(), pair.component2());
            default:
                Triple triple = (Triple) obj;
                Intrinsics.checkNotNullParameter(triple, "<destruct>");
                return this.f10729b.invoke(triple.component1(), triple.component2(), triple.component3());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ j(Function3 function3) {
        this.f10729b = (FunctionReferenceImpl) function3;
    }
}
