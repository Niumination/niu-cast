package z1;

import androidx.recyclerview.widget.RecyclerView;
import com.github.rubensousa.gravitysnaphelper.OrientationAwareRecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class d extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OrientationAwareRecyclerView f11231a;

    public d(OrientationAwareRecyclerView orientationAwareRecyclerView) {
        this.f11231a = orientationAwareRecyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView recyclerView, int i8) {
        super.onScrollStateChanged(recyclerView, i8);
        this.f11231a.f1770c = i8 != 0;
    }
}
