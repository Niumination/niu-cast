package gd;

import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBottomSheetPanel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OSBottomSheetPanel f5156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f5157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f5158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f5159d;
    public final float e;
    public float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5160g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public VelocityTracker f5161h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f5162i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5163j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5164k;

    public q(OSBaseBottomSheetDialog mDialog, OSBottomSheetPanel mPanel) {
        Intrinsics.checkNotNullParameter(mDialog, "mDialog");
        Intrinsics.checkNotNullParameter(mPanel, "mPanel");
        this.f5156a = mPanel;
        this.e = mPanel.getTranslationY();
        this.f5163j = true;
        this.f5162i = ViewConfiguration.get(mDialog).getScaledMaximumFlingVelocity();
    }

    public static float a(float f, float f4) {
        return (float) (((double) f4) * Math.pow(1.0f - (Math.abs(f) / 1600), 4.0d) * 0.4d);
    }
}
