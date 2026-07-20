package yi;

import j3.z;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import ob.c;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f11224a = LazyKt.lazy(new c(28));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z f11225b = new z();

    static {
        String path = System.getProperty("java.io.tmpdir");
        Intrinsics.checkNotNullExpressionValue(path, "getProperty(...)");
        Intrinsics.checkNotNullParameter(path, "path");
        File file = new File(path);
        Intrinsics.checkNotNullParameter(file, "file");
        String property = System.getProperty("os.name");
        if (property != null) {
            StringsKt__StringsJVMKt.startsWith$default(property, "Windows", false, 2, null);
        }
    }
}
