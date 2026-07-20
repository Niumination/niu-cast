package vj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<g> f17161a;

    public i(List<g> list) {
        this.f17161a = list;
    }

    public static g b(g... gVarArr) {
        if (gVarArr.length == 0) {
            throw new IllegalArgumentException("At least one credential is required");
        }
        for (g gVar : gVarArr) {
            gVar.getClass();
        }
        return new i(Collections.unmodifiableList(new ArrayList(Arrays.asList(gVarArr))));
    }

    @Override // vj.g
    public g a() {
        ArrayList arrayList = new ArrayList();
        Iterator<g> it = this.f17161a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        return new i(Collections.unmodifiableList(arrayList));
    }

    public List<g> c() {
        return this.f17161a;
    }
}
