package be;

import android.view.View;
import android.view.ViewGroup;
import com.transsion.hubsdk.preference.TranPreferenceFrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class b implements vg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranPreferenceFrameLayout f836a;

    @Override // vg.b
    public void a(ViewGroup viewGroup, View view, boolean z10) {
        b().setRemoveBorders(viewGroup, view, z10);
    }

    public final TranPreferenceFrameLayout b() {
        if (this.f836a == null) {
            this.f836a = new TranPreferenceFrameLayout();
        }
        return this.f836a;
    }
}
