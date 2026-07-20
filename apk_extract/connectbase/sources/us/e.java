package us;

import android.view.View;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes3.dex */
public class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScrollView f16406a;

    public e(ScrollView scrollView) {
        this.f16406a = scrollView;
    }

    @Override // us.b
    public View a() {
        return this.f16406a;
    }

    @Override // us.b
    public boolean b() {
        return !this.f16406a.canScrollVertically(1);
    }

    @Override // us.b
    public boolean c() {
        return !this.f16406a.canScrollVertically(-1);
    }
}
