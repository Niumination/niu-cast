package c8;

import android.view.View;
import com.transsion.widgetslib.view.OverBoundNestedScrollView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements tk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OverBoundNestedScrollView f1453a;

    public a(OverBoundNestedScrollView overBoundNestedScrollView) {
        this.f1453a = overBoundNestedScrollView;
    }

    @Override // tk.a
    public View getView() {
        return this.f1453a;
    }
}
