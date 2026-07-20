package p1;

import androidx.collection.LruCache;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f8640b = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache f8641a = new LruCache(20);

    public final j1.j a(String str) {
        if (str == null) {
            return null;
        }
        return (j1.j) this.f8641a.get(str);
    }
}
