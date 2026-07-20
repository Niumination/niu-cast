package ge;

import android.database.DataSetObserver;
import com.transsion.widgetslib.widget.tablayout.TabLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends DataSetObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TabLayout f5169a;

    public g(TabLayout tabLayout) {
        this.f5169a = tabLayout;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        this.f5169a.m();
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        this.f5169a.m();
    }
}
