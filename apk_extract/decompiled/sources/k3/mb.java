package k3;

import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class mb {
    public static mh.e a(InputStream inputStream) {
        li.v0 v0Var = li.v0.f7498a;
        si.e context = si.e.f10118a;
        ag.k pool = nh.a.f8277a;
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pool, "pool");
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        return new mh.e(new wi.c(inputStream), context);
    }
}
