package qd;

import com.transsion.widgetslib.view.OverBoundNestedScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends c8.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f8979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ OverBoundNestedScrollView f8980c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(OverBoundNestedScrollView overBoundNestedScrollView, OverBoundNestedScrollView overBoundNestedScrollView2, int i8) {
        super(overBoundNestedScrollView2);
        this.f8979b = i8;
        this.f8980c = overBoundNestedScrollView;
    }

    @Override // tk.a
    public final boolean a() {
        switch (this.f8979b) {
            case 0:
                break;
        }
        return !this.f8980c.canScrollVertically(1);
    }

    @Override // tk.a
    public final boolean b() {
        switch (this.f8979b) {
            case 0:
                break;
        }
        return !this.f8980c.canScrollVertically(-1);
    }
}
