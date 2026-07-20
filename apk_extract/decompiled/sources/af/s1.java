package af;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s1 implements q1.e, zg.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f574b;

    public s1(List list) {
        this.f573a = 2;
        this.f574b = list;
    }

    @Override // zg.u
    public Set a() {
        Set setEntrySet = ((Map) this.f574b).entrySet();
        Intrinsics.checkNotNullParameter(setEntrySet, "<this>");
        Set setUnmodifiableSet = Collections.unmodifiableSet(setEntrySet);
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(...)");
        return setUnmodifiableSet;
    }

    @Override // zg.u
    public List b(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (List) ((Map) this.f574b).get(name);
    }

    @Override // zg.u
    public void c(String name, Iterable values) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(values, "values");
        List listH = h(name);
        Iterator it = values.iterator();
        while (it.hasNext()) {
            n((String) it.next());
        }
        CollectionsKt__MutableCollectionsKt.addAll(listH, values);
    }

    @Override // zg.u
    public void d(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        n(value);
        h(name).add(value);
    }

    public void e(zg.t stringValues) {
        Intrinsics.checkNotNullParameter(stringValues, "stringValues");
        stringValues.c(new zg.v(this, 0));
    }

    public abstract Object f();

    @Override // q1.e
    public List getKeyframes() {
        return (List) this.f574b;
    }

    public List h(String str) {
        Map map = (Map) this.f574b;
        List list = (List) map.get(str);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        m(str);
        map.put(str, arrayList);
        return arrayList;
    }

    public String i(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List listB = b(name);
        if (listB != null) {
            return (String) CollectionsKt.firstOrNull(listB);
        }
        return null;
    }

    @Override // q1.e
    public boolean isStatic() {
        List list = (List) this.f574b;
        if (list.isEmpty()) {
            return true;
        }
        return list.size() == 1 && ((x1.a) list.get(0)).c();
    }

    public abstract void j();

    public abstract void k();

    public void l(Object obj, boolean z2) {
        Set set = (Set) this.f574b;
        int size = set.size();
        if (z2) {
            set.add(obj);
            if (size == 0) {
                j();
                return;
            }
            return;
        }
        if (set.remove(obj) && size == 1) {
            k();
        }
    }

    public void m(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
    }

    public void n(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // zg.u
    public Set names() {
        return ((Map) this.f574b).keySet();
    }

    public String toString() {
        switch (this.f573a) {
            case 2:
                StringBuilder sb2 = new StringBuilder();
                List list = (List) this.f574b;
                if (!list.isEmpty()) {
                    sb2.append("values=");
                    sb2.append(Arrays.toString(list.toArray()));
                }
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public s1(byte b9, int i8) {
        this.f573a = i8;
        switch (i8) {
            case 1:
                AtomicReference atomicReference = new AtomicReference();
                if (kk.s.f6994a != null && !kk.s.f6995b) {
                    this.f574b = new kk.e(Math.max(2, Math.max(0, 1024)));
                } else {
                    this.f574b = new ConcurrentLinkedQueue();
                }
                ck.g gVarA = ok.a.f8565b.f8566a.a();
                if (atomicReference.compareAndSet(null, gVarA)) {
                    ik.o oVar = new ik.o(this);
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    long nanos = timeUnit.toNanos(67L);
                    long nanos2 = TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
                    long nanos3 = timeUnit.toNanos(67L) + nanos2;
                    qk.a aVar = new qk.a(1);
                    ck.f fVar = new ck.f(gVarA, nanos2, nanos3, aVar, oVar, nanos);
                    qk.a aVar2 = new qk.a(1);
                    aVar.a(aVar2);
                    aVar2.a(gVarA.a(fVar, 67L, timeUnit));
                } else {
                    ((hk.g) gVarA).unsubscribe();
                }
                break;
            default:
                this.f574b = Collections.newSetFromMap(new IdentityHashMap());
                break;
        }
    }

    public s1(int i8) {
        this.f573a = 3;
        this.f574b = new zg.f();
    }
}
