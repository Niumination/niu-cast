package c8;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import tj.w;
import tj.x;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements tk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f1454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f1455b;

    public c(RecyclerView recyclerView) {
        this.f1454a = recyclerView;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        boolean z2 = layoutManager instanceof LinearLayoutManager;
        if (!z2 && !(layoutManager instanceof StaggeredGridLayoutManager)) {
            throw new IllegalArgumentException("Set a valid layout managers first, and custom layout manager is not support.");
        }
        this.f1455b = (z2 ? ((LinearLayoutManager) layoutManager).getOrientation() : ((StaggeredGridLayoutManager) layoutManager).getOrientation()) == 0 ? new x(this) : new w(this, 4);
    }

    @Override // tk.a
    public final boolean a() {
        return this.f1455b.a();
    }

    @Override // tk.a
    public final boolean b() {
        return this.f1455b.b();
    }

    @Override // tk.a
    public final View getView() {
        return this.f1454a;
    }
}
