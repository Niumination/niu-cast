package fb;

import af.d2;
import bb.s;
import kotlin.Lazy;
import kotlin.LazyKt;
import tc.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f5016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5017b;

    static {
        Lazy lazy = LazyKt.lazy(new s(8));
        f5016a = lazy;
        f5017b = ((Boolean) lazy.getValue()).booleanValue() ? new d2(2) : new d(2);
    }
}
