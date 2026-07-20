package y4;

/* JADX INFO: loaded from: classes2.dex */
public final class t0 extends v4.p0 {
    @Override // v4.p0
    public final Object read(d5.b bVar) {
        throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?\nSee " + x4.d0.createUrl("java-lang-class-unsupported"));
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) {
        throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + ((Class) obj).getName() + ". Forgot to register a type adapter?\nSee " + x4.d0.createUrl("java-lang-class-unsupported"));
    }
}
