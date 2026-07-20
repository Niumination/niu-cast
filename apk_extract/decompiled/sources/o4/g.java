package o4;

import android.util.Log;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import k3.dc;
import k3.ec;

/* JADX INFO: loaded from: classes.dex */
public final class g extends dc implements p4.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f8382d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f8379a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f8380b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f8381c = new HashMap();
    public final AtomicReference e = new AtomicReference();

    public g(d2.h hVar, ArrayList arrayList, ArrayList arrayList2) {
        m mVar = new m();
        new HashMap();
        mVar.f8391a = new ArrayDeque();
        this.f8382d = mVar;
        ArrayList<b> arrayList3 = new ArrayList();
        arrayList3.add(b.b(mVar, m.class, t4.b.class, t4.a.class));
        arrayList3.add(b.b(this, p4.a.class, new Class[0]));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar != null) {
                arrayList3.add(bVar);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList4.add(it2.next());
        }
        ArrayList arrayList5 = new ArrayList();
        synchronized (this) {
            Iterator it3 = arrayList4.iterator();
            while (it3.hasNext()) {
                try {
                    d dVar = (d) ((u4.a) it3.next()).get();
                    if (dVar != null) {
                        arrayList3.addAll(dVar.a());
                        it3.remove();
                    }
                } catch (n e) {
                    it3.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e);
                }
            }
            if (this.f8379a.isEmpty()) {
                ec.a(arrayList3);
            } else {
                ArrayList arrayList6 = new ArrayList(this.f8379a.keySet());
                arrayList6.addAll(arrayList3);
                ec.a(arrayList6);
            }
            for (final b bVar2 : arrayList3) {
                this.f8379a.put(bVar2, new o(new u4.a(this, bVar2) { // from class: o4.e

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final g f8374a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final b f8375b;

                    {
                        this.f8374a = this;
                        this.f8375b = bVar2;
                    }

                    @Override // u4.a
                    public final Object get() {
                        b bVar3 = this.f8375b;
                        return bVar3.f8373d.a(new u(bVar3, this.f8374a));
                    }
                }));
            }
            arrayList5.addAll(g(arrayList3));
            arrayList5.addAll(h());
            f();
        }
        Iterator it4 = arrayList5.iterator();
        while (it4.hasNext()) {
            ((Runnable) it4.next()).run();
        }
        Boolean bool = (Boolean) this.e.get();
        if (bool != null) {
            e(this.f8379a, bool.booleanValue());
        }
    }

    @Override // k3.dc
    public final synchronized u4.a b(Class cls) {
        return (u4.a) this.f8380b.get(cls);
    }

    @Override // k3.dc
    public final synchronized u4.a d(Class cls) {
        p pVar = (p) this.f8381c.get(cls);
        if (pVar != null) {
            return pVar;
        }
        return f.f8376b;
    }

    public final void e(HashMap map, boolean z2) {
        ArrayDeque arrayDeque;
        for (Map.Entry entry : map.entrySet()) {
            b bVar = (b) entry.getKey();
            bVar.getClass();
        }
        m mVar = this.f8382d;
        synchronized (mVar) {
            arrayDeque = mVar.f8391a;
            if (arrayDeque != null) {
                mVar.f8391a = null;
            } else {
                arrayDeque = null;
            }
        }
        if (arrayDeque != null) {
            Iterator it = arrayDeque.iterator();
            if (it.hasNext()) {
                it.next().getClass();
                throw new ClassCastException();
            }
        }
    }

    public final void f() {
        for (b bVar : this.f8379a.keySet()) {
            for (j jVar : bVar.f8371b) {
                if (jVar.f8389b == 2 && !this.f8381c.containsKey(jVar.f8388a)) {
                    HashMap map = this.f8381c;
                    Class cls = jVar.f8388a;
                    Set setEmptySet = Collections.emptySet();
                    p pVar = new p();
                    pVar.f8396b = null;
                    pVar.f8395a = Collections.newSetFromMap(new ConcurrentHashMap());
                    pVar.f8395a.addAll(setEmptySet);
                    map.put(cls, pVar);
                } else if (this.f8380b.containsKey(jVar.f8388a)) {
                    continue;
                } else {
                    int i8 = jVar.f8389b;
                    if (i8 == 1) {
                        throw new q("Unsatisfied dependency for component " + bVar + ": " + jVar.f8388a);
                    }
                    if (i8 != 2) {
                        HashMap map2 = this.f8380b;
                        Class cls2 = jVar.f8388a;
                        r rVar = r.f8397a;
                        f fVar = f.f8377c;
                        s sVar = new s();
                        sVar.f8398a = rVar;
                        sVar.f8399b = fVar;
                        map2.put(cls2, sVar);
                    }
                }
            }
        }
    }

    public final ArrayList g(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.f8372c == 0) {
                u4.a aVar = (u4.a) this.f8379a.get(bVar);
                for (Class cls : bVar.f8370a) {
                    HashMap map = this.f8380b;
                    if (map.containsKey(cls)) {
                        arrayList2.add(new i2.e(3, (s) ((u4.a) map.get(cls)), aVar));
                    } else {
                        map.put(cls, aVar);
                    }
                }
            }
        }
        return arrayList2;
    }

    public final ArrayList h() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f8379a.entrySet()) {
            b bVar = (b) entry.getKey();
            if (bVar.f8372c != 0) {
                u4.a aVar = (u4.a) entry.getValue();
                for (Class cls : bVar.f8370a) {
                    if (!map.containsKey(cls)) {
                        map.put(cls, new HashSet());
                    }
                    ((Set) map.get(cls)).add(aVar);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            Object key = entry2.getKey();
            HashMap map2 = this.f8381c;
            if (map2.containsKey(key)) {
                p pVar = (p) map2.get(entry2.getKey());
                Iterator it = ((Set) entry2.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new i2.e(4, pVar, (u4.a) it.next()));
                }
            } else {
                Class cls2 = (Class) entry2.getKey();
                Set set = (Set) ((Collection) entry2.getValue());
                p pVar2 = new p();
                pVar2.f8396b = null;
                pVar2.f8395a = Collections.newSetFromMap(new ConcurrentHashMap());
                pVar2.f8395a.addAll(set);
                map2.put(cls2, pVar2);
            }
        }
        return arrayList;
    }
}
