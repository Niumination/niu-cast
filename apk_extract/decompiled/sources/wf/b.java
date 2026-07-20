package wf;

import jh.o;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import zf.w;
import zf.y;
import zf.z;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements w, g0 {
    public abstract kf.c b();

    public abstract o d();

    public abstract ch.d e();

    public abstract ch.d f();

    public abstract z h();

    public abstract y j();

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("HttpResponse[");
        Intrinsics.checkNotNullParameter(this, "<this>");
        sb2.append(b().d().getUrl());
        sb2.append(", ");
        sb2.append(h());
        sb2.append(']');
        return sb2.toString();
    }
}
