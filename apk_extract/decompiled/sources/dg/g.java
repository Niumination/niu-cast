package dg;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f4467a;

    public g(List sourceGrammars) {
        Intrinsics.checkNotNullParameter(sourceGrammars, "sourceGrammars");
        ArrayList arrayList = new ArrayList();
        for (Object obj : sourceGrammars) {
            if (obj instanceof g) {
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((b) obj).a());
            } else {
                arrayList.add(obj);
            }
        }
        this.f4467a = arrayList;
    }

    @Override // dg.b
    public final List a() {
        return this.f4467a;
    }
}
