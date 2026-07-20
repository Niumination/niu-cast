package zg;

import af.s1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class v implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s1 f11606b;

    public /* synthetic */ v(s1 s1Var, int i8) {
        this.f11605a = i8;
        this.f11606b = s1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Set setEmptySet;
        String name = (String) obj;
        List values = (List) obj2;
        switch (this.f11605a) {
            case 0:
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(values, "values");
                this.f11606b.c(name, values);
                break;
            default:
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(values, "values");
                List values2 = values;
                s1 s1Var = this.f11606b;
                s1Var.getClass();
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(values2, "values");
                List list = (List) ((Map) s1Var.f574b).get(name);
                if (list == null || (setEmptySet = CollectionsKt.toSet(list)) == null) {
                    setEmptySet = SetsKt.emptySet();
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj3 : values2) {
                    if (!setEmptySet.contains((String) obj3)) {
                        arrayList.add(obj3);
                    }
                }
                s1Var.c(name, arrayList);
                break;
        }
        return Unit.INSTANCE;
    }
}
