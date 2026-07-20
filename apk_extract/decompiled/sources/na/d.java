package na;

import android.content.res.Configuration;
import android.content.res.Resources;
import bb.s;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f8136a = LazyKt.lazy(new s(27));

    public static boolean a() {
        Configuration configuration = Resources.getSystem().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
        return (configuration.screenLayout & 15) == 3;
    }
}
