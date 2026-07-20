package i4;

import java.util.AbstractMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public final class l4 extends o4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f5638a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractMap f5639b;

    public l4() {
        AbstractMap abstractMapCreate;
        i2 i2Var = new i2();
        w2 w2Var = w2.WEAK;
        w2 w2Var2 = i2Var.f5610d;
        v8.l("Key strength was already set to %s", w2Var2 == null, w2Var2);
        w2Var.getClass();
        i2Var.f5610d = w2Var;
        if (w2Var != w2.STRONG) {
            i2Var.f5607a = true;
        }
        if (i2Var.f5607a) {
            abstractMapCreate = u3.create(i2Var);
        } else {
            int i8 = i2Var.f5608b;
            i8 = i8 == -1 ? 16 : i8;
            int i9 = i2Var.f5609c;
            abstractMapCreate = new ConcurrentHashMap(i8, 0.75f, i9 == -1 ? 4 : i9);
        }
        this.f5639b = abstractMapCreate;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.AbstractMap, java.util.Map, java.util.concurrent.ConcurrentMap] */
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return -1;
        }
        if (obj2 == null) {
            return 1;
        }
        int iIdentityHashCode = System.identityHashCode(obj);
        int iIdentityHashCode2 = System.identityHashCode(obj2);
        if (iIdentityHashCode != iIdentityHashCode2) {
            return iIdentityHashCode < iIdentityHashCode2 ? -1 : 1;
        }
        ?? r7 = this.f5639b;
        Integer numValueOf = (Integer) r7.get(obj);
        AtomicInteger atomicInteger = this.f5638a;
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(atomicInteger.getAndIncrement());
            Integer num = (Integer) r7.putIfAbsent(obj, numValueOf);
            if (num != null) {
                numValueOf = num;
            }
        }
        Integer numValueOf2 = (Integer) r7.get(obj2);
        if (numValueOf2 == null) {
            numValueOf2 = Integer.valueOf(atomicInteger.getAndIncrement());
            Integer num2 = (Integer) r7.putIfAbsent(obj2, numValueOf2);
            if (num2 != null) {
                numValueOf2 = num2;
            }
        }
        int iCompareTo = numValueOf.compareTo(numValueOf2);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        throw new AssertionError();
    }

    public final String toString() {
        return "Ordering.arbitrary()";
    }
}
