package o4;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import k3.fc;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f8370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f8371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f8373d;
    public final Set e;

    public b(HashSet hashSet, HashSet hashSet2, int i8, c cVar, HashSet hashSet3) {
        this.f8370a = Collections.unmodifiableSet(hashSet);
        this.f8371b = Collections.unmodifiableSet(hashSet2);
        this.f8372c = i8;
        this.f8373d = cVar;
        this.e = Collections.unmodifiableSet(hashSet3);
    }

    public static i2.h a(Class cls) {
        return new i2.h(cls, new Class[0]);
    }

    public static b b(Object obj, Class cls, Class... clsArr) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(cls);
        for (Class cls2 : clsArr) {
            fc.a(cls2, "Null interface");
        }
        Collections.addAll(hashSet, clsArr);
        return new b(new HashSet(hashSet), new HashSet(hashSet2), 0, new a(obj, 0), hashSet3);
    }

    public final String toString() {
        return "Component<" + Arrays.toString(this.f8370a.toArray()) + ">{0, type=" + this.f8372c + ", deps=" + Arrays.toString(this.f8371b.toArray()) + "}";
    }
}
