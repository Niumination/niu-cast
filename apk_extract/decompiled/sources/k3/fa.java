package k3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class fa {
    public static jh.x0 a(byte[] content) {
        int length = content.length;
        Intrinsics.checkNotNullParameter(content, "content");
        wi.a source = new wi.a();
        source.o(content, 0, length);
        Intrinsics.checkNotNullParameter(source, "source");
        return new jh.x0(source);
    }
}
