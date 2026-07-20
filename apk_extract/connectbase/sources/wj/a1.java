package wj;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@hm.c
public abstract class a1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<T> f18316a = Collections.newSetFromMap(new IdentityHashMap());

    public final boolean a(Object... objArr) {
        for (Object obj : objArr) {
            if (this.f18316a.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract void b();

    public abstract void c();

    public final boolean d() {
        return !this.f18316a.isEmpty();
    }

    public final void e(T t10, boolean z10) {
        int size = this.f18316a.size();
        if (z10) {
            this.f18316a.add(t10);
            if (size == 0) {
                b();
                return;
            }
            return;
        }
        if (this.f18316a.remove(t10) && size == 1) {
            c();
        }
    }
}
