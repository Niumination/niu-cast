package xn;

import java.lang.ref.WeakReference;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final WeakReference<ClassLoader> f20362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public ClassLoader f20364c;

    public i0(@os.l ClassLoader classLoader) {
        l0.p(classLoader, "classLoader");
        this.f20362a = new WeakReference<>(classLoader);
        this.f20363b = System.identityHashCode(classLoader);
        this.f20364c = classLoader;
    }

    public final void a(@os.m ClassLoader classLoader) {
        this.f20364c = classLoader;
    }

    public boolean equals(@os.m Object obj) {
        return (obj instanceof i0) && this.f20362a.get() == ((i0) obj).f20362a.get();
    }

    public int hashCode() {
        return this.f20363b;
    }

    @os.l
    public String toString() {
        ClassLoader classLoader = this.f20362a.get();
        return classLoader == null ? "<null>" : classLoader.toString();
    }
}
