package xg;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends m3.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f10961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f10962b;

    public j(String rootPath) {
        Intrinsics.checkNotNullParameter(rootPath, "rootPath");
        v vVar = v.f10992b;
        List<w> list = m3.z.a(rootPath).f10993a;
        ArrayList arrayList = new ArrayList(CollectionsKt.i(list));
        for (w wVar : list) {
            if (wVar.f10995b != x.Constant) {
                throw new IllegalArgumentException("rootPath should be constant, no wildcards supported.");
            }
            arrayList.add(wVar.f10994a);
        }
        this.f10961a = arrayList;
        this.f10962b = new m(arrayList.size(), 2, 1.0d);
    }

    @Override // m3.w
    public final n a(c0 c0Var, int i8) {
        if (i8 != 0) {
            throw new IllegalStateException("Root selector should be evaluated first.");
        }
        ArrayList arrayList = this.f10961a;
        if (arrayList.isEmpty()) {
            return n.e;
        }
        List list = c0Var.f10930d;
        if (list.size() < arrayList.size()) {
            return n.f10968a;
        }
        int size = arrayList.size() + i8;
        while (i8 < size) {
            if (!Intrinsics.areEqual(list.get(i8), arrayList.get(i8))) {
                return n.f10968a;
            }
            i8++;
        }
        return this.f10962b;
    }

    public final String toString() {
        return CollectionsKt___CollectionsKt.joinToString$default(this.f10961a, "/", null, null, 0, null, null, 62, null);
    }
}
