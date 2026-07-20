package s0;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f14913b = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache<String, n0.g> f14914a = new LruCache<>(20);

    @VisibleForTesting
    public h() {
    }

    public static h c() {
        return f14913b;
    }

    public void a() {
        this.f14914a.evictAll();
    }

    @Nullable
    public n0.g b(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.f14914a.get(str);
    }

    public void d(@Nullable String str, n0.g gVar) {
        if (str == null) {
            return;
        }
        this.f14914a.put(str, gVar);
    }

    public void e(int i10) {
        this.f14914a.resize(i10);
    }
}
