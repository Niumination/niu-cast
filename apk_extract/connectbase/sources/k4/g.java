package k4;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f8949b;

    public g(T t10) {
        this.f8949b = t10;
    }

    @Nullable
    public synchronized T a() {
        if (this.f8948a) {
            return null;
        }
        this.f8948a = true;
        return this.f8949b;
    }

    public T b() {
        return this.f8949b;
    }
}
