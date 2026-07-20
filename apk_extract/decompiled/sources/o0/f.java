package o0;

import android.view.ViewConfiguration;
import androidx.core.util.Supplier;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewConfiguration f8357b;

    public /* synthetic */ f(ViewConfiguration viewConfiguration, int i8) {
        this.f8356a = i8;
        this.f8357b = viewConfiguration;
    }

    @Override // androidx.core.util.Supplier
    public final Object get() {
        int i8 = this.f8356a;
        ViewConfiguration viewConfiguration = this.f8357b;
        switch (i8) {
            case 0:
                return Integer.valueOf(viewConfiguration.getScaledMaximumFlingVelocity());
            default:
                return Integer.valueOf(viewConfiguration.getScaledMinimumFlingVelocity());
        }
    }
}
