package ij;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.transsion.widgetslib.view.swipmenu.OSSwipeMenuLayout;
import pj.c;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Scroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7936a;

    public a(Context context) {
        super(context, new c(0.4f, 0.0f, 0.2f, 1.0f));
        this.f7936a = OSSwipeMenuLayout.D0;
    }

    public int a() {
        return this.f7936a;
    }

    public void b(int i10) {
        this.f7936a = i10;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i10, int i11, int i12, int i13, int i14) {
        super.startScroll(i10, i11, i12, i13, this.f7936a);
    }

    @Override // android.widget.Scroller
    public void startScroll(int i10, int i11, int i12, int i13) {
        super.startScroll(i10, i11, i12, i13, this.f7936a);
    }

    public a(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.f7936a = OSSwipeMenuLayout.D0;
    }
}
