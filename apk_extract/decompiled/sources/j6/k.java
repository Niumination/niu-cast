package j6;

import androidx.core.app.NotificationCompat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6119d;
    public int e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6120g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f6122i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f6116a = LazyKt.lazy(j.INSTANCE);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f6117b = LazyKt.lazy(i.INSTANCE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f6118c = LazyKt.lazy(h.INSTANCE);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f6121h = c.FIT_XY;

    public final a a() {
        a aVar = this.f6122i;
        if (aVar != null) {
            Intrinsics.checkNotNullParameter("AnimPlayer.ScaleTypeUtil", "tag");
            Intrinsics.checkNotNullParameter("custom scaleType", NotificationCompat.CATEGORY_MESSAGE);
            return aVar;
        }
        String msg = Intrinsics.stringPlus("scaleType=", this.f6121h);
        Intrinsics.checkNotNullParameter("AnimPlayer.ScaleTypeUtil", "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        int i8 = g.$EnumSwitchMapping$0[this.f6121h.ordinal()];
        if (i8 == 1) {
            return (f) this.f6116a.getValue();
        }
        if (i8 == 2) {
            return (e) this.f6117b.getValue();
        }
        if (i8 == 3) {
            return (d) this.f6118c.getValue();
        }
        throw new NoWhenBranchMatchedException();
    }
}
