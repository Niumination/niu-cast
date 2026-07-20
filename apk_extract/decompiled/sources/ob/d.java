package ob;

import kotlin.Lazy;
import kotlin.LazyKt;
import tj.w;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f8439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w f8440b;

    static {
        Lazy lazy = LazyKt.lazy(new c(0));
        f8439a = lazy;
        f8440b = ((Boolean) lazy.getValue()).booleanValue() ? new a(13) : new w(13);
    }
}
