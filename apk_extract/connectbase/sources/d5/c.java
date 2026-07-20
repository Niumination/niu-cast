package d5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T, R> implements g<T, R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g<T, R> f3530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g<T, R> f3531b;

    public c(g<T, R> gVar, g<T, R> gVar2) {
        this.f3530a = gVar;
        this.f3531b = gVar2;
    }

    @Override // d5.g
    public void a() {
        i6.a aVar = i6.a.b.f7724a;
        g<T, R> gVar = this.f3530a;
        Objects.requireNonNull(gVar);
        aVar.b(new b(gVar));
        i6.a aVar2 = i6.a.b.f7724a;
        g<T, R> gVar2 = this.f3531b;
        Objects.requireNonNull(gVar2);
        aVar2.b(new b(gVar2));
    }

    @Override // d5.g
    @NonNull
    public Collection<T> b() {
        return !this.f3531b.b().isEmpty() ? this.f3531b.b() : this.f3530a.b();
    }

    @Override // d5.g
    public void c() {
        i6.a aVar = i6.a.b.f7724a;
        g<T, R> gVar = this.f3530a;
        Objects.requireNonNull(gVar);
        aVar.b(new a(gVar));
        i6.a aVar2 = i6.a.b.f7724a;
        g<T, R> gVar2 = this.f3531b;
        Objects.requireNonNull(gVar2);
        aVar2.b(new a(gVar2));
    }

    @Override // d5.g
    @Nullable
    public T d(R r10) {
        return !this.f3531b.b().isEmpty() ? this.f3531b.d(r10) : this.f3530a.d(r10);
    }
}
