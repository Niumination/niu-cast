package gd;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.transsion.widgetsbottomsheet.R$dimen;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBottomSheetPanel;
import k3.z8;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSBottomSheetPanel f5142b;

    public /* synthetic */ g(OSBottomSheetPanel oSBottomSheetPanel, int i8) {
        this.f5141a = i8;
        this.f5142b = oSBottomSheetPanel;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0049  */
    /* JADX WARN: Code duplicated, block: B:21:0x005d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0124  */
    @Override // java.lang.Runnable
    public final void run() {
        int dimensionPixelOffset;
        int i8;
        switch (this.f5141a) {
            case 0:
                PathInterpolator pathInterpolator = OSBottomSheetPanel.K;
                OSBottomSheetPanel this$0 = this.f5142b;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.mPanelVisibleHeight = this$0.getHeight() - this$0.getResources().getDimensionPixelSize(R$dimen.os_bottom_sheet_pull_rect);
                this$0.setVisibility(0);
                if (this$0.f2997c == null) {
                    this$0.setTranslationY(this$0.mPanelVisibleHeight);
                    long jA = this$0.mCustomEnterDuration;
                    if (jA <= 0) {
                        int i9 = this$0.mPanelVisibleHeight;
                        Context context = this$0.getContext();
                        String[] strArr = pd.j.f8764a;
                        int iA = i9 - hd.a.a(context, 368);
                        if (iA <= 0) {
                            jA = 300;
                        } else {
                            int iA2 = this$0.a();
                            if (iA2 - hd.a.a(this$0.getContext(), 368) <= 0) {
                                jA = 300;
                            } else {
                                jA = (((long) (iA / (iA2 - hd.a.a(this$0.getContext(), 368)))) * 50) + 300;
                            }
                        }
                    }
                    z8.f("OSBottomSheetPanel", "animateEnter: asyncDuration = " + jA);
                    LinearInterpolator linearInterpolator = fd.e.f5027a;
                    Property TRANSLATION_Y = LinearLayout.TRANSLATION_Y;
                    Intrinsics.checkNotNullExpressionValue(TRANSLATION_Y, "TRANSLATION_Y");
                    fd.d dVar = new fd.d(this$0, TRANSLATION_Y, this$0.mPanelVisibleHeight, 0.0f, jA, OSBottomSheetPanel.K);
                    View view = this$0.mOutsideView;
                    Intrinsics.checkNotNull(view);
                    Property ALPHA = LinearLayout.ALPHA;
                    Intrinsics.checkNotNullExpressionValue(ALPHA, "ALPHA");
                    View view2 = this$0.mOutsideView;
                    Intrinsics.checkNotNull(view2);
                    ValueAnimator valueAnimatorA = fd.e.a(jA, dVar, new fd.d(view, ALPHA, view2.getAlpha(), this$0.A, 300.0f, OSBottomSheetPanel.M));
                    this$0.f2997c = valueAnimatorA;
                    valueAnimatorA.addListener(new j(this$0, 0));
                    valueAnimatorA.addUpdateListener(new i());
                    valueAnimatorA.start();
                }
                this$0.d();
                break;
            default:
                PathInterpolator pathInterpolator2 = OSBottomSheetPanel.K;
                OSBottomSheetPanel this$1 = this.f5142b;
                Intrinsics.checkNotNullParameter(this$1, "this$0");
                ViewGroup.LayoutParams layoutParams = this$1.getLayoutParams();
                FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    layoutParams2.gravity = 17;
                    this$1.getContext();
                    if (pd.j.f8768g) {
                        if (pd.j.t(this$1.getContext()) && !pd.j.u(this$1.getContext())) {
                            this$1.getContext();
                            if (pd.j.s()) {
                                if (pd.j.r(this$1.getContext())) {
                                }
                                Context context2 = this$1.getContext();
                                DisplayMetrics displayMetrics = new DisplayMetrics();
                                ((WindowManager) context2.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                                i8 = displayMetrics.heightPixels;
                            } else {
                                i8 = pd.j.i(this$1.getContext());
                            }
                        } else if (!pd.j.r(this$1.getContext()) || pd.j.A(this$1.getContext())) {
                            Context context3 = this$1.getContext();
                            DisplayMetrics displayMetrics2 = new DisplayMetrics();
                            ((WindowManager) context3.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics2);
                            i8 = displayMetrics2.heightPixels;
                        } else {
                            i8 = pd.j.i(this$1.getContext());
                        }
                        dimensionPixelOffset = (int) (i8 * (pd.j.w(this$1.getContext()) ? 0.85f : 0.75f));
                    } else {
                        dimensionPixelOffset = this$1.getResources().getDimensionPixelOffset(R$dimen.os_model_panel_pad_max_height);
                    }
                    int height = this$1.getHeight();
                    int i10 = layoutParams2.height;
                    StringBuilder sbR = o.d.r(dimensionPixelOffset, height, "before, maxHeight: ", ", height: ", ", lp.height: ");
                    sbR.append(i10);
                    z8.b("OSBottomSheetPanel", sbR.toString());
                    if (this$1.getHeight() > dimensionPixelOffset) {
                        layoutParams2.height = dimensionPixelOffset;
                    }
                    z8.d("OSBottomSheetPanel", "after, lp.height: " + layoutParams2.height + ", width: " + this$1.getWidth());
                    this$1.setLayoutParams(layoutParams2);
                }
                break;
        }
    }
}
