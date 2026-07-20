package si;

import li.a0;
import qi.s;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f10120b = new f(l.f10128c, l.f10129d, l.e, l.f10126a);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // li.a0
    public final a0 limitedParallelism(int i8, String str) {
        qi.g.c(i8);
        if (i8 >= l.f10128c) {
            return str != null ? new s(this, str) : this;
        }
        return super.limitedParallelism(i8, str);
    }

    @Override // li.a0
    public final String toString() {
        return "Dispatchers.Default";
    }
}
