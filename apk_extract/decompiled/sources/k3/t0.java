package k3;

/* JADX INFO: loaded from: classes.dex */
public final class t0 implements x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w0 f6650b;

    public t0(int i8, w0 w0Var) {
        this.f6649a = i8;
        this.f6650b = w0Var;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return x0.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x0)) {
            return false;
        }
        t0 t0Var = (t0) ((x0) obj);
        return this.f6649a == t0Var.f6649a && this.f6650b.equals(t0Var.f6650b);
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.f6649a ^ 14552422) + (this.f6650b.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f6649a + "intEncoding=" + this.f6650b + ')';
    }
}
