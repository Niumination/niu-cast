package s4;

import java.util.Date;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class d implements r4.a {
    public static final c e = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f9502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f9503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f9504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9505d;

    public d() {
        HashMap map = new HashMap();
        this.f9502a = map;
        HashMap map2 = new HashMap();
        this.f9503b = map2;
        this.f9504c = a.f9497a;
        this.f9505d = false;
        map2.put(String.class, b.f9498b);
        map.remove(String.class);
        map2.put(Boolean.class, b.f9499c);
        map.remove(Boolean.class);
        map2.put(Date.class, e);
        map.remove(Date.class);
    }

    @Override // r4.a
    public final r4.a d(Class cls, q4.d dVar) {
        this.f9502a.put(cls, dVar);
        this.f9503b.remove(cls);
        return this;
    }
}
