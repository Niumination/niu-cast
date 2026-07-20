package q0;

import androidx.annotation.Nullable;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class p<K, A> extends a<K, A> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a1.b<A> f13398i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final A f13399j;

    public p(a1.j<A> jVar) {
        this(jVar, null);
    }

    @Override // q0.a
    public float c() {
        return 1.0f;
    }

    @Override // q0.a
    public A h() {
        a1.j<A> jVar = this.f13354e;
        A a10 = this.f13399j;
        return jVar.b(0.0f, 0.0f, a10, a10, f(), f(), f());
    }

    @Override // q0.a
    public A i(a1.a<K> aVar, float f10) {
        return h();
    }

    @Override // q0.a
    public void k() {
        if (this.f13354e != null) {
            super.k();
        }
    }

    @Override // q0.a
    public void m(float f10) {
        this.f13353d = f10;
    }

    public p(a1.j<A> jVar, @Nullable A a10) {
        super(Collections.emptyList());
        this.f13398i = new a1.b<>();
        n(jVar);
        this.f13399j = a10;
    }
}
