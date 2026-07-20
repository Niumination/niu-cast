package qd;

import com.google.android.material.appbar.AppBarLayout;
import com.transsion.widgetslib.view.OverBoundNestedScrollView;
import z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements AppBarLayout.OnOffsetChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OverBoundNestedScrollView f8981a;

    public h(OverBoundNestedScrollView overBoundNestedScrollView) {
        this.f8981a = overBoundNestedScrollView;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
    public final void onOffsetChanged(AppBarLayout appBarLayout, int i8) {
        OverBoundNestedScrollView overBoundNestedScrollView = this.f8981a;
        if (overBoundNestedScrollView.mOverScrollDecor != null) {
            if (i8 == 0) {
                ((z1OoOnew) overBoundNestedScrollView.mOverScrollDecor).b(true);
                ((z1OoOnew) overBoundNestedScrollView.mOverScrollDecor).c(false);
                return;
            }
            ((z1OoOnew) overBoundNestedScrollView.mOverScrollDecor).b(false);
            if (Math.abs(i8) >= appBarLayout.getTotalScrollRange()) {
                ((z1OoOnew) overBoundNestedScrollView.mOverScrollDecor).c(true);
            } else {
                ((z1OoOnew) overBoundNestedScrollView.mOverScrollDecor).c(false);
            }
        }
    }
}
