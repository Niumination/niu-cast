package m3;

/* JADX INFO: loaded from: classes.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f7642b;

    public c(int i8, e eVar) {
        this.f7641a = i8;
        this.f7642b = eVar;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return f.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        c cVar = (c) ((f) obj);
        return this.f7641a == cVar.f7641a && this.f7642b.equals(cVar.f7642b);
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.f7641a ^ 14552422) + (this.f7642b.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f7641a + "intEncoding=" + this.f7642b + ')';
    }
}
