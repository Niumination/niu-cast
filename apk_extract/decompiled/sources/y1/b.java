package y1;

import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f11025d = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(b.class), "subscriptionsMap", "getSubscriptionsMap()Ljava/util/HashMap;"))};
    public static final b e = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f11022a = b.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f11023b = LazyKt.lazy(a.INSTANCE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final pk.b f11024c = new pk.b(pk.a.b());

    public static HashMap a() {
        KProperty kProperty = f11025d[0];
        return (HashMap) f11023b.getValue();
    }
}
