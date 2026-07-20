package dq;

import eq.e;
import java.util.Collection;
import java.util.LinkedHashSet;
import kn.l0;
import op.h;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    @m
    public static final <T> Collection<T> a(@m Collection<? extends T> collection, @l Collection<? extends T> collection2) {
        l0.p(collection2, "collection");
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == 0) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    @l
    public static final e<h> b(@l Iterable<? extends h> iterable) {
        l0.p(iterable, "scopes");
        e<h> eVar = new e<>();
        for (h hVar : iterable) {
            h hVar2 = hVar;
            if (hVar2 != null && hVar2 != h.c.f12406b) {
                eVar.add(hVar);
            }
        }
        return eVar;
    }
}
