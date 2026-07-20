package zf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import m3.i6;

/* JADX INFO: loaded from: classes3.dex */
public final class s0 implements e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0 f11550a;

    public s0(f0 encodedParametersBuilder) {
        Intrinsics.checkNotNullParameter(encodedParametersBuilder, "encodedParametersBuilder");
        this.f11550a = encodedParametersBuilder;
    }

    @Override // zg.u
    public final Set a() {
        return ((zg.w) i6.a(this.f11550a)).a();
    }

    @Override // zg.u
    public final List b(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List listB = this.f11550a.b(d.e(name, false));
        if (listB == null) {
            return null;
        }
        List list = listB;
        ArrayList arrayList = new ArrayList(CollectionsKt.i(list));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(d.d((String) it.next(), 0, 0, true, 11));
        }
        return arrayList;
    }

    @Override // zf.e0
    public final d0 build() {
        return i6.a(this.f11550a);
    }

    @Override // zg.u
    public final void c(String name, Iterable values) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(values, "values");
        String strE = d.e(name, false);
        ArrayList arrayList = new ArrayList(CollectionsKt.i(values));
        Iterator it = values.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Intrinsics.checkNotNullParameter(str, "<this>");
            arrayList.add(d.e(str, true));
        }
        this.f11550a.c(strE, arrayList);
    }

    @Override // zg.u
    public final void d(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        String strE = d.e(name, false);
        Intrinsics.checkNotNullParameter(value, "<this>");
        this.f11550a.d(strE, d.e(value, true));
    }

    @Override // zg.u
    public final Set names() {
        Set setKeySet = ((Map) this.f11550a.f574b).keySet();
        ArrayList arrayList = new ArrayList(CollectionsKt.i(setKeySet));
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            arrayList.add(d.d((String) it.next(), 0, 0, false, 15));
        }
        return CollectionsKt.toSet(arrayList);
    }
}
