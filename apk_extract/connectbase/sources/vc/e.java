package vc;

import android.graphics.Outline;
import com.transsion.hubsdk.graphics.TranOutline;

/* JADX INFO: loaded from: classes2.dex */
public class e implements of.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16895b = "e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranOutline f16896a = new TranOutline();

    @Override // of.d
    public boolean a() {
        TranOutline tranOutline = this.f16896a;
        if (tranOutline != null) {
            return tranOutline.smoothcornerCubicEdgeEnabled();
        }
        return false;
    }

    @Override // of.d
    public void b(Outline outline, int i10, int i11, int i12, int i13, float f10, int i14) {
        TranOutline tranOutline = this.f16896a;
        if (tranOutline != null) {
            tranOutline.setSmoothRoundRect(outline, i10, i11, i12, i13, f10, i14);
        } else {
            dc.e.c(f16895b, "cannot get core");
        }
    }
}
