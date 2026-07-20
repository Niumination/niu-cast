package dm;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import jq.d0;
import kn.l0;
import os.l;
import un.q;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final int a(@l String str, int i10) {
        String property;
        Integer numX0;
        l0.p(str, "name");
        try {
            property = System.getProperty(l0.C("io.ktor.utils.io.", str));
        } catch (SecurityException unused) {
            property = null;
        }
        return (property == null || (numX0 = d0.X0(property)) == null) ? i10 : numX0.intValue();
    }

    public static final <Owner> AtomicLongFieldUpdater<Owner> b(q<Owner, Long> qVar) {
        l0.p(qVar, "p");
        l0.P();
        AtomicLongFieldUpdater<Owner> atomicLongFieldUpdaterNewUpdater = AtomicLongFieldUpdater.newUpdater(Object.class, qVar.getName());
        l0.o(atomicLongFieldUpdaterNewUpdater, "newUpdater(Owner::class.java, p.name)");
        return atomicLongFieldUpdaterNewUpdater;
    }
}
