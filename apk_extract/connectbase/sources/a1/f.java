package a1;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes.dex */
public abstract class f<T> extends j<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final T f29d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final T f30e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Interpolator f31f;

    public f(T t10, T t11) {
        this(t10, t11, new LinearInterpolator());
    }

    @Override // a1.j
    public T a(b<T> bVar) {
        return e(this.f29d, this.f30e, this.f31f.getInterpolation(bVar.e()));
    }

    public abstract T e(T t10, T t11, float f10);

    public f(T t10, T t11, Interpolator interpolator) {
        this.f29d = t10;
        this.f30e = t11;
        this.f31f = interpolator;
    }
}
