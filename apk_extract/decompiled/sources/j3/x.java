package j3;

import kotlin.jvm.internal.Intrinsics;
import oi.b0;

/* JADX INFO: loaded from: classes.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static w f6090a;

    public static final b0 a(oi.h hVar, Object descriptor) {
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        Intrinsics.checkNotNullParameter("request", "expected");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return new b0(new bf.r(hVar, "request", descriptor, null));
    }
}
