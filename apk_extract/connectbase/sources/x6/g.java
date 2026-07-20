package x6;

import android.content.Context;
import android.content.IntentSender;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.os.Build;
import com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class g implements jf.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f20095d = "g";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Class<?> f20096e = cc.a.a("android.os.ServiceManager");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Class<?> f20097f = cc.a.a("android.content.pm.IShortcutService$Stub");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f20098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i8.a f20099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ShortcutManager f20100c;

    public g() {
        Context contextA = bc.a.a();
        this.f20098a = contextA;
        this.f20100c = (ShortcutManager) contextA.getSystemService(FloatingWindowViewModel.C);
    }

    @Override // jf.f
    public boolean a(String str, ShortcutInfo shortcutInfo, IntentSender intentSender, int i10) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 > 32) {
            if (i11 == 33) {
                return b().b(str, shortcutInfo, intentSender, i10);
            }
            return false;
        }
        Object objJ = cc.a.j(cc.a.g(this.f20100c.getClass(), "requestPinShortcut", ShortcutInfo.class, IntentSender.class), this.f20100c, shortcutInfo, intentSender);
        boolean zBooleanValue = objJ instanceof Boolean ? ((Boolean) objJ).booleanValue() : false;
        dc.e.a(f20095d, "requestPinShortcut result:" + zBooleanValue);
        return zBooleanValue;
    }

    public final i8.a b() {
        if (this.f20099b == null) {
            this.f20099b = new i8.a();
        }
        return this.f20099b;
    }
}
