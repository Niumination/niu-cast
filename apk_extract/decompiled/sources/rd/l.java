package rd;

import android.view.View;
import com.transsion.widgetslib.view.OverBoundNestedScrollView;
import com.transsion.widgetslib.view.damping.OSScrollbarLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements View.OnScrollChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OverBoundNestedScrollView f9421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSScrollbarLayout f9422b;

    public l(OSScrollbarLayout oSScrollbarLayout, OverBoundNestedScrollView overBoundNestedScrollView) {
        this.f9422b = oSScrollbarLayout;
        this.f9421a = overBoundNestedScrollView;
    }

    @Override // android.view.View.OnScrollChangeListener
    public final void onScrollChange(View view, int i8, int i9, int i10, int i11) {
        OverBoundNestedScrollView overBoundNestedScrollView = this.f9421a;
        int iComputeVerticalScrollRange = overBoundNestedScrollView.computeVerticalScrollRange();
        int iComputeVerticalScrollOffset = overBoundNestedScrollView.computeVerticalScrollOffset();
        int i12 = OSScrollbarLayout.B;
        OSScrollbarLayout oSScrollbarLayout = this.f9422b;
        oSScrollbarLayout.i(overBoundNestedScrollView, iComputeVerticalScrollRange, iComputeVerticalScrollOffset);
        oSScrollbarLayout.g();
    }
}
