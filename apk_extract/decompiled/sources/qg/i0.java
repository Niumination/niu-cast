package qg;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import m3.p6;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements zf.r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ag.d f9080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zf.s f9081d;
    public final LinkedHashSet e;
    public final boolean f;

    public i0(ag.d original) {
        Intrinsics.checkNotNullParameter(original, "original");
        this.f9080c = original;
        this.f9081d = new zf.s();
        this.e = new LinkedHashSet();
        original.getClass();
        this.f = true;
    }

    @Override // zg.t
    public final Set a() {
        Set setPlus = SetsKt.plus(this.f9080c.a(), (Iterable) this.f9081d.o().a());
        ArrayList arrayList = new ArrayList();
        for (Object obj : setPlus) {
            if (!this.e.contains(((Map.Entry) obj).getKey())) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    @Override // zg.t
    public final List b(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.e.contains(name)) {
            return null;
        }
        zf.s sVar = this.f9081d;
        sVar.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        return ((Map) sVar.f574b).containsKey(name) ? sVar.b(name) : this.f9080c.b(name);
    }

    @Override // zg.t
    public final void c(Function2 body) {
        Intrinsics.checkNotNullParameter(body, "body");
        p6.a(this, body);
    }

    @Override // zg.t
    public final boolean d() {
        return this.f;
    }

    @Override // zg.t
    public final String get(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(name, "name");
        List listB = b(name);
        if (listB != null) {
            return (String) CollectionsKt.firstOrNull(listB);
        }
        return null;
    }

    @Override // zg.t
    public final Set names() {
        return SetsKt___SetsKt.minus(SetsKt.plus(this.f9080c.names(), (Iterable) ((Map) this.f9081d.f574b).keySet()), (Iterable) this.e);
    }
}
