package pd;

import android.content.res.Resources;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.widget.actionbar.OverflowMenu;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static float f8747n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f8748o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OverflowMenu f8749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f8750b;
    public ArrayList e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f8755i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f f8756j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f8757k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8758l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f8759m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8751c = 300;
    public int f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8753g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8754h = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AccelerateInterpolator f8752d = new AccelerateInterpolator();

    public g(OverflowMenu overflowMenu) {
        this.f8749a = overflowMenu;
        Resources resources = overflowMenu.getResources();
        f8747n = resources.getDimension(R$dimen.os_overflowmenu_circle_radiu);
        f8748o = (int) ((f8747n * 2.0f) + ((int) resources.getDimension(R$dimen.os_overflowmenu_circle_spacing)));
        this.f8755i = new f();
        this.f8756j = new f();
        this.f8757k = new f();
    }

    public final void a(f fVar, f fVar2) {
        if (this.f8753g) {
            this.f = 2;
            if (this.f8754h == 0) {
                int i8 = this.f8758l;
                int i9 = f8748o;
                int i10 = i8 - i9;
                int i11 = this.f8759m;
                fVar.f8745c = i10;
                fVar.f8746d = i11;
                fVar2.f8745c = i10;
                fVar2.f8746d = i11 + i9;
            } else {
                int i12 = this.f8758l;
                int i13 = f8748o;
                int i14 = i12 + i13;
                int i15 = this.f8759m;
                fVar.f8745c = i14;
                fVar.f8746d = i15;
                fVar2.f8745c = i14;
                fVar2.f8746d = i15 + i13;
            }
        } else {
            this.f = 1;
            if (this.f8754h == 0) {
                int i16 = this.f8758l;
                int i17 = f8748o;
                int i18 = this.f8759m;
                fVar.f8745c = i16 + i17;
                fVar.f8746d = i18 - i17;
                fVar2.f8745c = i16;
                fVar2.f8746d = i18;
            } else {
                int i19 = this.f8758l;
                int i20 = f8748o;
                int i21 = this.f8759m;
                fVar.f8745c = i19 - i20;
                fVar.f8746d = i21 - i20;
                fVar2.f8745c = i19;
                fVar2.f8746d = i21;
            }
        }
        this.f8749a.invalidate();
    }

    public final void b(boolean z2) {
        if (this.f == 4) {
            a((f) this.e.get(1), (f) this.e.get(2));
        }
        this.f8753g = z2;
        this.f8750b = AnimationUtils.currentAnimationTimeMillis();
        this.f = 4;
        c();
    }

    public final void c() {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        float interpolation = this.f8752d.getInterpolation(Math.min((jCurrentAnimationTimeMillis - this.f8750b) / (this.f8751c * 1.0f), 1.0f));
        if (this.e.size() < 3) {
            return;
        }
        f fVar = (f) this.e.get(1);
        int i8 = fVar.f8743a;
        fVar.f8743a = (int) (((fVar.f8745c - i8) * interpolation) + i8);
        int i9 = fVar.f8744b;
        fVar.f8744b = (int) (((fVar.f8746d - i9) * interpolation) + i9);
        f fVar2 = (f) this.e.get(2);
        int i10 = fVar2.f8743a;
        fVar2.f8743a = (int) (((fVar2.f8745c - i10) * interpolation) + i10);
        int i11 = fVar2.f8744b;
        fVar2.f8744b = (int) (((fVar2.f8746d - i11) * interpolation) + i11);
        this.f8749a.invalidate();
        if (jCurrentAnimationTimeMillis - this.f8750b >= this.f8751c) {
            a(fVar, fVar2);
        }
    }

    public void setDuration(int i8) {
        this.f8751c = i8;
    }
}
