package ke;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.transsion.widgetslib.view.shimmer.OSShimmerLayout;
import com.transsion.widgetslib.widget.FootOperationBar;
import com.transsion.widgetslib.widget.SearchBar;
import com.transsion.widgetslistitemlayout.OSListItemView;
import com.transsion.widgetslistitemlayout.R$dimen;
import java.lang.ref.WeakReference;
import pd.j;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f6851b;

    public /* synthetic */ c(ViewGroup viewGroup, int i8) {
        this.f6850a = i8;
        this.f6851b = viewGroup;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        int i8 = 6;
        int measuredHeight = 0;
        Object obj = this.f6851b;
        switch (this.f6850a) {
            case 0:
                OSListItemView oSListItemView = (OSListItemView) obj;
                oSListItemView.C.getViewTreeObserver().removeOnPreDrawListener(this);
                TextPaint paint = oSListItemView.B.getPaint();
                TextPaint paint2 = oSListItemView.C.getPaint();
                float fMeasureText = paint.measureText(oSListItemView.B.getText().toString());
                float fMeasureText2 = paint2.measureText(oSListItemView.C.getText().toString());
                int dimensionPixelSize = oSListItemView.getContext().getResources().getDimensionPixelSize(R$dimen.os_dimen_icon_common_size);
                Context context = oSListItemView.getContext();
                String[] strArr = j.f8764a;
                int iA = hd.a.a(context, 16) + dimensionPixelSize;
                float dimensionPixelSize2 = fMeasureText + fMeasureText2 + (oSListItemView.getContext().getResources().getDimensionPixelSize(R$dimen.os_list_item_padding) * 2) + iA;
                Log.i("initGroupTitleArrow", "titleTextWidth" + fMeasureText + " subTitleTextWidth:" + fMeasureText2 + "totalWidth:" + dimensionPixelSize2 + " getWidth():" + oSListItemView.getWidth());
                if (!TextUtils.isEmpty(oSListItemView.B.getText().toString())) {
                    if (dimensionPixelSize2 < oSListItemView.getWidth()) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) oSListItemView.C.getLayoutParams();
                        layoutParams.removeRule(3);
                        layoutParams.addRule(15);
                        layoutParams.setMarginEnd(oSListItemView.getContext().getResources().getDimensionPixelSize(R$dimen.os_dimen_icon_common_size));
                        oSListItemView.C.setLayoutParams(layoutParams);
                        oSListItemView.getLayoutParams().height = oSListItemView.getResources().getDimensionPixelOffset(R$dimen.os_list_item_title_min_height);
                    } else {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) oSListItemView.C.getLayoutParams();
                        layoutParams2.removeRule(15);
                        layoutParams2.addRule(3, oSListItemView.B.getId());
                        layoutParams2.addRule(16, oSListItemView.N.getId());
                        layoutParams2.setMarginEnd(oSListItemView.getContext().getResources().getDimensionPixelSize(R$dimen.os_dimen_icon_common_size));
                        oSListItemView.C.setLayoutParams(layoutParams2);
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) oSListItemView.N.getLayoutParams();
                        layoutParams3.addRule(3, oSListItemView.B.getId());
                        layoutParams3.addRule(6, oSListItemView.C.getId());
                        layoutParams3.addRule(8, oSListItemView.C.getId());
                        oSListItemView.N.setLayoutParams(layoutParams3);
                        TextView textView = oSListItemView.C;
                        int width = (oSListItemView.getWidth() - iA) - oSListItemView.getContext().getResources().getDimensionPixelSize(R$dimen.os_list_item_padding);
                        if (textView != null && !TextUtils.isEmpty(textView.getText())) {
                            ViewGroup.LayoutParams layoutParams4 = textView.getLayoutParams();
                            textView.measure(View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
                            measuredHeight = textView.getMeasuredHeight();
                            if (layoutParams4 != null) {
                                textView.setLayoutParams(layoutParams4);
                            }
                        }
                        oSListItemView.getLayoutParams().height = oSListItemView.getPaddingBottom() + oSListItemView.getPaddingTop() + oSListItemView.B.getHeight() + measuredHeight;
                    }
                } else if (dimensionPixelSize2 < oSListItemView.getWidth()) {
                    RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) oSListItemView.C.getLayoutParams();
                    layoutParams5.removeRule(21);
                    layoutParams5.removeRule(16);
                    layoutParams5.addRule(20);
                    layoutParams5.setMarginEnd(0);
                    oSListItemView.C.setLayoutParams(layoutParams5);
                    RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) oSListItemView.N.getLayoutParams();
                    layoutParams6.removeRule(21);
                    layoutParams6.addRule(17, oSListItemView.C.getId());
                    layoutParams6.setMarginStart(0);
                    oSListItemView.N.setLayoutParams(layoutParams6);
                } else {
                    RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) oSListItemView.C.getLayoutParams();
                    layoutParams7.addRule(21);
                    layoutParams7.removeRule(20);
                    layoutParams7.addRule(16, oSListItemView.N.getId());
                    layoutParams7.setMarginEnd(oSListItemView.getContext().getResources().getDimensionPixelSize(R$dimen.os_dimen_icon_common_size));
                    oSListItemView.C.setLayoutParams(layoutParams7);
                    RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) oSListItemView.N.getLayoutParams();
                    layoutParams8.addRule(21);
                    layoutParams8.removeRule(17);
                    layoutParams8.addRule(6, oSListItemView.C.getId());
                    layoutParams8.addRule(8, oSListItemView.C.getId());
                    oSListItemView.N.setLayoutParams(layoutParams8);
                }
                break;
            case 1:
                OSShimmerLayout oSShimmerLayout = (OSShimmerLayout) obj;
                oSShimmerLayout.getViewTreeObserver().removeOnPreDrawListener(oSShimmerLayout.f3345r);
                oSShimmerLayout.f3345r = null;
                oSShimmerLayout.c();
                break;
            case 2:
                FootOperationBar footOperationBar = (FootOperationBar) ((WeakReference) obj).get();
                if (footOperationBar != null) {
                    footOperationBar.getViewTreeObserver().removeOnPreDrawListener(this);
                    footOperationBar.setVisibility(8);
                    if (footOperationBar.f3374i || footOperationBar.e) {
                        footOperationBar.setVisibility(0);
                        if (!footOperationBar.f3373h && !footOperationBar.e) {
                            footOperationBar.f3373h = true;
                            footOperationBar.e = true;
                            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(footOperationBar, "alpha", 0.0f, 1.0f);
                            objectAnimatorOfFloat.setInterpolator(new ie.a(0.33f, 0.66f));
                            objectAnimatorOfFloat.setDuration(150L);
                            objectAnimatorOfFloat.addListener(new d(footOperationBar, i8));
                            objectAnimatorOfFloat.start();
                        }
                    }
                }
                break;
            default:
                SearchBar searchBar = (SearchBar) obj;
                searchBar.getViewTreeObserver().removeOnPreDrawListener(this);
                searchBar.f3442n.offsetLeftAndRight(-searchBar.getBackViewStaticWidth());
                searchBar.f3442n.setVisibility(8);
                searchBar.e = searchBar.p.getMeasuredWidth();
                searchBar.f3437i = searchBar.getBackViewStaticWidth() - searchBar.f3432a;
                searchBar.f3436h = searchBar.e - searchBar.f3437i;
                if (searchBar.getIsBackMode() && searchBar.f3441m) {
                    searchBar.p.setVisibility(8);
                    searchBar.f3442n.setVisibility(0);
                    searchBar.q.setVisibility(0);
                    searchBar.e();
                    FrameLayout.LayoutParams layoutParams9 = (FrameLayout.LayoutParams) searchBar.q.getLayoutParams();
                    layoutParams9.width = searchBar.f3436h;
                    searchBar.q.setLayoutParams(layoutParams9);
                    float f = j.v() ? -searchBar.f3437i : searchBar.f3437i;
                    searchBar.q.setTranslationX(f);
                    searchBar.f3443o.setTranslationX(f);
                }
                searchBar.c();
                break;
        }
        return true;
    }

    public c(FootOperationBar footOperationBar) {
        this.f6850a = 2;
        this.f6851b = new WeakReference(footOperationBar);
    }
}
