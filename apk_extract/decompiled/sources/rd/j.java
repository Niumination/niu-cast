package rd;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.widgetslib.view.damping.OSRefreshRecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends GridLayoutManager.SpanSizeLookup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.Adapter f9415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ GridLayoutManager.SpanSizeLookup f9417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ OSRefreshRecyclerView f9418d;

    public j(OSRefreshRecyclerView oSRefreshRecyclerView, RecyclerView.Adapter adapter, int i8, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        this.f9418d = oSRefreshRecyclerView;
        this.f9415a = adapter;
        this.f9416b = i8;
        this.f9417c = spanSizeLookup;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public final int getSpanSize(int i8) {
        if (this.f9415a.getItemViewType(i8) == 145) {
            return this.f9416b;
        }
        return this.f9417c.getSpanSize(i8 - this.f9418d.f3216a.getHeaderCount());
    }
}
