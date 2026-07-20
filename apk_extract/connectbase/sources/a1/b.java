package a1;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f21a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f22b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f23c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public T f24d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f25e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f26f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f27g;

    public float a() {
        return this.f22b;
    }

    public T b() {
        return this.f24d;
    }

    public float c() {
        return this.f26f;
    }

    public float d() {
        return this.f25e;
    }

    public float e() {
        return this.f27g;
    }

    public float f() {
        return this.f21a;
    }

    public T g() {
        return this.f23c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public b<T> h(float f10, float f11, T t10, T t11, float f12, float f13, float f14) {
        this.f21a = f10;
        this.f22b = f11;
        this.f23c = t10;
        this.f24d = t11;
        this.f25e = f12;
        this.f26f = f13;
        this.f27g = f14;
        return this;
    }
}
