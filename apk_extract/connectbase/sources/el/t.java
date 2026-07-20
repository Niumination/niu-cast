package el;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.l1;
import lm.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class t {
    @os.m
    public static final String a(@os.l dk.b bVar) {
        l0.p(bVar, "<this>");
        List<k<?>> list = ((f0) dk.i.a(bVar.a(), f0.f4523b)).f4525a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((k) obj).f4534d instanceof s) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return c(bVar, ((k) arrayList.get(0)).f4531a);
        }
        throw new IllegalStateException("Multiple session providers installed. Please use sessionId<S>() function instead.");
    }

    public static final <SessionType> String b(dk.b bVar) {
        l0.p(bVar, "<this>");
        d dVarH = h0.h(bVar);
        l0.P();
        return c(bVar, dVarH.c(l1.d(Object.class)));
    }

    @os.m
    @z0
    public static final String c(@os.l dk.b bVar, @os.l String str) {
        Object next;
        l0.p(bVar, "<this>");
        l0.p(str, "name");
        Iterator<T> it = ((f0) dk.i.a(bVar.a(), f0.f4523b)).f4525a.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!l0.g(((k) next).f4531a, str));
        k kVar = (k) next;
        if (kVar == null) {
            throw new IllegalStateException(("No session provider " + str + " found.").toString());
        }
        Object obj = kVar.f4534d;
        s sVar = obj instanceof s ? (s) obj : null;
        if (sVar != null) {
            return (String) bVar.c().b(sVar.f4548e);
        }
        throw new IllegalStateException(("Provider " + str + " doesn't use session IDs").toString());
    }
}
