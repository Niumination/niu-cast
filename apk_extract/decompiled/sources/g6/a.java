package g6;

import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import d6.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements i6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f5114a;

    public a(d player) {
        Intrinsics.checkNotNullParameter(player, "player");
        this.f5114a = player;
    }

    @Override // i6.a
    public final void a(int i8) {
        this.f5114a.getClass();
    }

    @Override // i6.a
    public final void b() {
    }

    @Override // i6.a
    public final void c(d6.a config) {
        Intrinsics.checkNotNullParameter(config, "config");
    }

    @Override // i6.a
    public final void d(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(ev, "ev");
    }

    @Override // i6.a
    public final void e() {
    }

    @Override // i6.a
    public final void f() {
        Intrinsics.checkNotNullParameter("AnimPlayer.MaskAnimPlugin", "tag");
        Intrinsics.checkNotNullParameter("mask render init", NotificationCompat.CATEGORY_MESSAGE);
        this.f5114a.getClass();
    }
}
