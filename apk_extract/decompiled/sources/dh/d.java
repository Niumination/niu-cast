package dh;

import bb.s;
import java.lang.management.ManagementFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f4469a = LazyKt.lazy(new s(3));

    public static final boolean a() {
        try {
            return StringsKt__StringsKt.contains$default(ManagementFactory.getRuntimeMXBean().getInputArguments().toString(), "jdwp", false, 2, (Object) null);
        } catch (Throwable unused) {
            return false;
        }
    }
}
