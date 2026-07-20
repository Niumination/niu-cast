package z1;

import androidx.recyclerview.widget.RecyclerView;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

/* JADX INFO: loaded from: classes.dex */
public final class a extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GravitySnapHelper f11229a;

    public a(GravitySnapHelper gravitySnapHelper) {
        this.f11229a = gravitySnapHelper;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView recyclerView, int i8) {
        super.onScrollStateChanged(recyclerView, i8);
        this.f11229a.getClass();
    }
}
