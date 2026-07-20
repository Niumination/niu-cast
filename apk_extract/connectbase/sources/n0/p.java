package n0;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class p<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final V f11070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Throwable f11071b;

    public p(V v10) {
        this.f11070a = v10;
        this.f11071b = null;
    }

    @Nullable
    public Throwable a() {
        return this.f11071b;
    }

    @Nullable
    public V b() {
        return this.f11070a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        V v10 = this.f11070a;
        if (v10 != null && v10.equals(pVar.f11070a)) {
            return true;
        }
        Throwable th2 = this.f11071b;
        if (th2 == null || pVar.f11071b == null) {
            return false;
        }
        return th2.toString().equals(this.f11071b.toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11070a, this.f11071b});
    }

    public p(Throwable th2) {
        this.f11071b = th2;
        this.f11070a = null;
    }
}
