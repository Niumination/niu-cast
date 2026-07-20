package p9;

import android.content.IntentSender;
import android.content.pm.ShortcutInfo;
import qc.y;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13065c = "i";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f13066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x6.g f13067b;

    public jf.f a(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f13065c, "TranThubShortcutManager");
            y yVar = this.f13066a;
            if (yVar != null) {
                return yVar;
            }
            y yVar2 = new y();
            this.f13066a = yVar2;
            return yVar2;
        }
        dc.e.f(f13065c, "TranAospShortcutManager");
        x6.g gVar = this.f13067b;
        if (gVar != null) {
            return gVar;
        }
        x6.g gVar2 = new x6.g();
        this.f13067b = gVar2;
        return gVar2;
    }

    @yb.a(level = 1)
    public boolean b(String str, ShortcutInfo shortcutInfo, IntentSender intentSender, int i10) {
        return a(fc.b.a.f5988h).a(str, shortcutInfo, intentSender, i10);
    }
}
