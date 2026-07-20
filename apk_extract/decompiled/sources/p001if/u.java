package p001if;

import af.i4;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import k3.v8;
import o6.a;
import ze.x0;
import ze.z0;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f5849c = AtomicIntegerFieldUpdater.newUpdater(u.class, "b");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f5850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f5851b;

    public u(int i8, ArrayList arrayList) {
        v8.c("empty list", !arrayList.isEmpty());
        this.f5850a = arrayList;
        this.f5851b = i8 - 1;
    }

    @Override // ze.z0
    public final x0 a(i4 i4Var) {
        ArrayList arrayList = this.f5850a;
        int size = arrayList.size();
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f5849c;
        int iIncrementAndGet = atomicIntegerFieldUpdater.incrementAndGet(this);
        if (iIncrementAndGet >= size) {
            int i8 = iIncrementAndGet % size;
            atomicIntegerFieldUpdater.compareAndSet(this, iIncrementAndGet, i8);
            iIncrementAndGet = i8;
        }
        return ((z0) arrayList.get(iIncrementAndGet)).a(i4Var);
    }

    @Override // p001if.v
    public final boolean b(v vVar) {
        if (!(vVar instanceof u)) {
            return false;
        }
        u uVar = (u) vVar;
        if (uVar != this) {
            ArrayList arrayList = this.f5850a;
            if (arrayList.size() != uVar.f5850a.size() || !new HashSet(arrayList).containsAll(uVar.f5850a)) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        a aVar = new a(u.class.getSimpleName());
        aVar.d(this.f5850a, "subchannelPickers");
        return aVar.toString();
    }
}
