package qg;

import androidx.core.app.NotificationCompat;

/* JADX INFO: loaded from: classes3.dex */
public final class t0 extends hh.e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final hh.h f9114k = new hh.h("before");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final hh.h f9115l = new hh.h(NotificationCompat.CATEGORY_CALL);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f9116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final vg.b f9117i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final wg.b f9118j;

    public t0(boolean z2) {
        super(f9114k, f9115l);
        this.f9116h = z2;
        this.f9117i = new vg.b(z2);
        this.f9118j = new wg.b(z2);
    }

    @Override // hh.e
    public final boolean h() {
        return this.f9116h;
    }
}
