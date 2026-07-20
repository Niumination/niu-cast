package zf;

import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import m3.r6;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class o0 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11530a;

    public /* synthetic */ o0(int i8) {
        this.f11530a = i8;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f11530a) {
            case 0:
                Pair it = (Pair) obj;
                Intrinsics.checkNotNullParameter(it, "it");
                String str = (String) it.getFirst();
                if (it.getSecond() == null) {
                    return str;
                }
                return str + '=' + String.valueOf(it.getSecond());
            case 1:
                Map.Entry DelegatingMutableSet = (Map.Entry) obj;
                Intrinsics.checkNotNullParameter(DelegatingMutableSet, "$this$DelegatingMutableSet");
                return new zg.n(((zg.g) DelegatingMutableSet.getKey()).f11586a, DelegatingMutableSet.getValue());
            case 2:
                Map.Entry DelegatingMutableSet2 = (Map.Entry) obj;
                Intrinsics.checkNotNullParameter(DelegatingMutableSet2, "$this$DelegatingMutableSet");
                return new zg.n(r6.a((String) DelegatingMutableSet2.getKey()), DelegatingMutableSet2.getValue());
            case 3:
                zg.g DelegatingMutableSet3 = (zg.g) obj;
                Intrinsics.checkNotNullParameter(DelegatingMutableSet3, "$this$DelegatingMutableSet");
                return DelegatingMutableSet3.f11586a;
            default:
                String DelegatingMutableSet4 = (String) obj;
                Intrinsics.checkNotNullParameter(DelegatingMutableSet4, "$this$DelegatingMutableSet");
                return r6.a(DelegatingMutableSet4);
        }
    }
}
