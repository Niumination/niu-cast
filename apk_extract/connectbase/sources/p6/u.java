package p6;

import android.app.UiModeManager;

/* JADX INFO: loaded from: classes2.dex */
public class u implements bf.q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13018b = "u";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UiModeManager f13019a = (UiModeManager) bc.a.a().getSystemService("uimode");

    @Override // bf.q
    public boolean a(boolean z10) {
        Object objJ = cc.a.j(cc.a.g(this.f13019a.getClass(), "setNightModeActivated", Boolean.TYPE), this.f13019a, Boolean.valueOf(z10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }
}
