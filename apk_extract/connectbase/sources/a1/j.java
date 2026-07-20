package a1;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public class j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b<T> f33a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public q0.a<?, ?> f34b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public T f35c;

    public j() {
        this.f33a = new b<>();
        this.f35c = null;
    }

    @Nullable
    public T a(b<T> bVar) {
        return this.f35c;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T b(float f10, float f11, T t10, T t11, float f12, float f13, float f14) {
        return a(this.f33a.h(f10, f11, t10, t11, f12, f13, f14));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void c(@Nullable q0.a<?, ?> aVar) {
        this.f34b = aVar;
    }

    public final void d(@Nullable T t10) {
        this.f35c = t10;
        q0.a<?, ?> aVar = this.f34b;
        if (aVar != null) {
            aVar.k();
        }
    }

    public j(@Nullable T t10) {
        this.f33a = new b<>();
        this.f35c = t10;
    }
}
