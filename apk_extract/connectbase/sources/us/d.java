package us;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: classes3.dex */
public class d implements us.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f16401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f16402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f16403c = false;

    public interface a {
        boolean b();

        boolean c();
    }

    public class b implements a {
        public b() {
        }

        @Override // us.d.a
        public boolean b() {
            return !d.this.f16401a.canScrollVertically(1);
        }

        @Override // us.d.a
        public boolean c() {
            return !d.this.f16401a.canScrollVertically(-1);
        }
    }

    public class c implements a {
        public c() {
        }

        @Override // us.d.a
        public boolean b() {
            return !d.this.f16401a.canScrollHorizontally(1);
        }

        @Override // us.d.a
        public boolean c() {
            return !d.this.f16401a.canScrollHorizontally(-1);
        }
    }

    public d(RecyclerView recyclerView) {
        this.f16401a = recyclerView;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        boolean z10 = layoutManager instanceof LinearLayoutManager;
        if (!z10 && !(layoutManager instanceof StaggeredGridLayoutManager)) {
            throw new IllegalArgumentException("Set a valid layout managers first, and custom layout manager is not support.");
        }
        this.f16402b = (z10 ? ((LinearLayoutManager) layoutManager).getOrientation() : ((StaggeredGridLayoutManager) layoutManager).getOrientation()) == 0 ? new c() : new b();
    }

    @Override // us.b
    public View a() {
        return this.f16401a;
    }

    @Override // us.b
    public boolean b() {
        return !this.f16403c && this.f16402b.b();
    }

    @Override // us.b
    public boolean c() {
        return !this.f16403c && this.f16402b.c();
    }
}
