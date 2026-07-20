package vq;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kn.r1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nOnDemandAllocatingPool.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnDemandAllocatingPool.kt\nkotlinx/coroutines/internal/OnDemandAllocatingPool\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 OnDemandAllocatingPool.kt\nkotlinx/coroutines/internal/OnDemandAllocatingPoolKt\n*L\n1#1,107:1\n41#1:108\n41#1:109\n35#1,7:110\n41#1:127\n1549#2:117\n1620#2,2:118\n1622#2:122\n1549#2:123\n1620#2,3:124\n101#3,2:120\n*S KotlinDebug\n*F\n+ 1 OnDemandAllocatingPool.kt\nkotlinx/coroutines/internal/OnDemandAllocatingPool\n*L\n35#1:108\n54#1:109\n76#1:110,7\n92#1:127\n77#1:117\n77#1:118,2\n77#1:122\n91#1:123\n91#1:124,3\n79#1:120,2\n*E\n"})
public final class j0<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final AtomicIntegerFieldUpdater f17856d = AtomicIntegerFieldUpdater.newUpdater(j0.class, "controlState");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.l<Integer, T> f17858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final AtomicReferenceArray f17859c;

    @in.x
    private volatile int controlState;

    /* JADX WARN: Multi-variable type inference failed */
    public j0(int i10, @os.l jn.l<? super Integer, ? extends T> lVar) {
        this.f17857a = i10;
        this.f17858b = lVar;
        this.f17859c = new AtomicReferenceArray(i10);
    }

    public final boolean a() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f17856d;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            if ((Integer.MIN_VALUE & i10) != 0) {
                return false;
            }
            if (i10 >= this.f17857a) {
                return true;
            }
        } while (!f17856d.compareAndSet(this, i10, i10 + 1));
        this.f17859c.set(i10, this.f17858b.invoke(Integer.valueOf(i10)));
        return true;
    }

    @os.l
    public final List<T> b() {
        int i10;
        Object andSet;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f17856d;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            if ((i10 & Integer.MIN_VALUE) != 0) {
                i10 = 0;
                break;
            }
        } while (!f17856d.compareAndSet(this, i10, Integer.MIN_VALUE | i10));
        tn.l lVarW1 = tn.u.W1(0, i10);
        ArrayList arrayList = new ArrayList(nm.z.b0(lVarW1, 10));
        Iterator<Integer> it = lVarW1.iterator();
        while (it.hasNext()) {
            int iNextInt = ((nm.v0) it).nextInt();
            do {
                andSet = this.f17859c.getAndSet(iNextInt, null);
            } while (andSet == null);
            arrayList.add(andSet);
        }
        return arrayList;
    }

    public final boolean c(int i10) {
        return (Integer.MIN_VALUE & i10) != 0;
    }

    public final void d(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, jn.l<? super Integer, l2> lVar, Object obj) {
        while (true) {
            lVar.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    @os.l
    public final String e() {
        int i10 = f17856d.get(this);
        tn.l lVarW1 = tn.u.W1(0, Integer.MAX_VALUE & i10);
        ArrayList arrayList = new ArrayList(nm.z.b0(lVarW1, 10));
        Iterator<Integer> it = lVarW1.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f17859c.get(((nm.v0) it).nextInt()));
        }
        return j.a.a(arrayList.toString(), (i10 & Integer.MIN_VALUE) != 0 ? "[closed]" : "");
    }

    public final int f() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f17856d;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            if ((i10 & Integer.MIN_VALUE) != 0) {
                return 0;
            }
        } while (!f17856d.compareAndSet(this, i10, Integer.MIN_VALUE | i10));
        return i10;
    }

    @os.l
    public String toString() {
        return "OnDemandAllocatingPool(" + e() + ')';
    }
}
