package o4;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import k3.dc;

/* JADX INFO: loaded from: classes.dex */
public final class u extends dc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f8400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f8401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f8402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f8403d;
    public final dc e;

    public u(b bVar, dc dcVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (j jVar : bVar.f8371b) {
            int i8 = jVar.f8390c;
            boolean z2 = i8 == 0;
            int i9 = jVar.f8389b;
            Class cls = jVar.f8388a;
            if (z2) {
                if (i9 == 2) {
                    hashSet4.add(cls);
                } else {
                    hashSet.add(cls);
                }
            } else if (i8 == 2) {
                hashSet3.add(cls);
            } else if (i9 == 2) {
                hashSet5.add(cls);
            } else {
                hashSet2.add(cls);
            }
        }
        if (!bVar.e.isEmpty()) {
            hashSet.add(t4.a.class);
        }
        this.f8400a = Collections.unmodifiableSet(hashSet);
        this.f8401b = Collections.unmodifiableSet(hashSet2);
        Collections.unmodifiableSet(hashSet3);
        this.f8402c = Collections.unmodifiableSet(hashSet4);
        this.f8403d = Collections.unmodifiableSet(hashSet5);
        this.e = dcVar;
    }

    @Override // k3.dc
    public final Object a(Class cls) {
        if (!this.f8400a.contains(cls)) {
            throw new l("Attempting to request an undeclared dependency " + cls + ".");
        }
        Object objA = this.e.a(cls);
        if (!cls.equals(t4.a.class)) {
            return objA;
        }
        return new t();
    }

    @Override // k3.dc
    public final u4.a b(Class cls) {
        if (this.f8401b.contains(cls)) {
            return this.e.b(cls);
        }
        throw new l("Attempting to request an undeclared dependency Provider<" + cls + ">.");
    }

    @Override // k3.dc
    public final Set c(Class cls) {
        if (this.f8402c.contains(cls)) {
            return this.e.c(cls);
        }
        throw new l("Attempting to request an undeclared dependency Set<" + cls + ">.");
    }

    @Override // k3.dc
    public final u4.a d(Class cls) {
        if (this.f8403d.contains(cls)) {
            return this.e.d(cls);
        }
        throw new l("Attempting to request an undeclared dependency Provider<Set<" + cls + ">>.");
    }
}
