package na;

import bb.s;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f8133a = LazyKt.lazy(new s(24));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f8134b = LazyKt.lazy(new s(25));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f8135c = LazyKt.lazy(new s(26));

    public static boolean a() {
        return StringsKt__StringsKt.contains$default((String) f8133a.getValue(), "xos", false, 2, (Object) null);
    }
}
