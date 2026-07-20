package t0;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class n<V, O> implements m<V, O> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a1.a<V>> f15432a;

    public n(V v10) {
        this(Collections.singletonList(new a1.a(v10)));
    }

    @Override // t0.m
    public boolean k() {
        if (this.f15432a.isEmpty()) {
            return true;
        }
        return this.f15432a.size() == 1 && this.f15432a.get(0).h();
    }

    @Override // t0.m
    public List<a1.a<V>> m() {
        return this.f15432a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (!this.f15432a.isEmpty()) {
            sb2.append("values=");
            sb2.append(Arrays.toString(this.f15432a.toArray()));
        }
        return sb2.toString();
    }

    public n(List<a1.a<V>> list) {
        this.f15432a = list;
    }
}
