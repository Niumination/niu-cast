package zg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class w implements t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f11607c;

    public w(Map values) {
        Intrinsics.checkNotNullParameter(values, "values");
        f fVar = new f();
        for (Map.Entry entry : values.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i8 = 0; i8 < size; i8++) {
                arrayList.add((String) list.get(i8));
            }
            fVar.put(str, arrayList);
        }
        this.f11607c = fVar;
    }

    @Override // zg.t
    public final Set a() {
        Set setEntrySet = this.f11607c.entrySet();
        Intrinsics.checkNotNullParameter(setEntrySet, "<this>");
        Set setUnmodifiableSet = Collections.unmodifiableSet(setEntrySet);
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(...)");
        return setUnmodifiableSet;
    }

    @Override // zg.t
    public final List b(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (List) this.f11607c.get(name);
    }

    @Override // zg.t
    public final void c(Function2 body) {
        Intrinsics.checkNotNullParameter(body, "body");
        for (Map.Entry entry : this.f11607c.entrySet()) {
            body.invoke((String) entry.getKey(), (List) entry.getValue());
        }
    }

    @Override // zg.t
    public final boolean d() {
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        if (true != tVar.d()) {
            return false;
        }
        return Intrinsics.areEqual(a(), tVar.a());
    }

    @Override // zg.t
    public final String get(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List list = (List) this.f11607c.get(name);
        if (list != null) {
            return (String) CollectionsKt.firstOrNull(list);
        }
        return null;
    }

    public final int hashCode() {
        Set setA = a();
        return setA.hashCode() + (Boolean.hashCode(true) * 961);
    }

    @Override // zg.t
    public final boolean isEmpty() {
        return this.f11607c.isEmpty();
    }

    @Override // zg.t
    public final Set names() {
        Set setKeySet = this.f11607c.keySet();
        Intrinsics.checkNotNullParameter(setKeySet, "<this>");
        Set setUnmodifiableSet = Collections.unmodifiableSet(setKeySet);
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(...)");
        return setUnmodifiableSet;
    }
}
