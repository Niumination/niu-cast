package z1;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

/* JADX INFO: loaded from: classes.dex */
public final class b extends LinearSmoothScroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GravitySnapHelper f11230a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GravitySnapHelper gravitySnapHelper, Context context) {
        super(context);
        this.f11230a = gravitySnapHelper;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return this.f11230a.e / displayMetrics.densityDpi;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public final void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        GravitySnapHelper gravitySnapHelper = this.f11230a;
        RecyclerView recyclerView = gravitySnapHelper.f1765j;
        if (recyclerView == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        int[] iArrCalculateDistanceToFinalSnap = gravitySnapHelper.calculateDistanceToFinalSnap(gravitySnapHelper.f1765j.getLayoutManager(), view);
        int i8 = iArrCalculateDistanceToFinalSnap[0];
        int i9 = iArrCalculateDistanceToFinalSnap[1];
        int iCalculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i8), Math.abs(i9)));
        if (iCalculateTimeForDeceleration > 0) {
            action.update(i8, i9, iCalculateTimeForDeceleration, this.mDecelerateInterpolator);
        }
    }
}
