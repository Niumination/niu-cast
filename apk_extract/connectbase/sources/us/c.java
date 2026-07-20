package us;

import android.view.View;
import android.widget.HorizontalScrollView;

/* JADX INFO: loaded from: classes3.dex */
public class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HorizontalScrollView f16400a;

    public c(HorizontalScrollView horizontalScrollView) {
        this.f16400a = horizontalScrollView;
    }

    @Override // us.b
    public View a() {
        return this.f16400a;
    }

    @Override // us.b
    public boolean b() {
        return !this.f16400a.canScrollHorizontally(1);
    }

    @Override // us.b
    public boolean c() {
        return !this.f16400a.canScrollHorizontally(-1);
    }
}
