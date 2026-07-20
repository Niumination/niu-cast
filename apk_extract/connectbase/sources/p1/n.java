package p1;

import c1.h0;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes.dex */
@d
public abstract class n<T> extends m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeVariable<?> f12719a;

    public n() {
        Type typeCapture = capture();
        h0.u(typeCapture instanceof TypeVariable, "%s should be a type variable.", typeCapture);
        this.f12719a = (TypeVariable) typeCapture;
    }

    public final boolean equals(@gm.a Object o10) {
        if (o10 instanceof n) {
            return this.f12719a.equals(((n) o10).f12719a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f12719a.hashCode();
    }

    public String toString() {
        return this.f12719a.toString();
    }
}
