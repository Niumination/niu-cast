package qc;

import android.content.IntentSender;
import android.content.pm.ShortcutInfo;
import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.content.pm.ITranShortcutManager;

/* JADX INFO: loaded from: classes2.dex */
public class y implements jf.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13963b = "y";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranShortcutManager f13964a = ITranShortcutManager.Stub.asInterface(TranServiceManager.getServiceIBinder(FloatingWindowViewModel.C));

    @Override // jf.f
    public boolean a(final String str, final ShortcutInfo shortcutInfo, final IntentSender intentSender, final int i10) {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: qc.x
            @Override // zb.f.b
            public final Object run() {
                return this.f13958a.c(str, shortcutInfo, intentSender, i10);
            }
        }, FloatingWindowViewModel.C)).booleanValue();
        dc.e.a(f13963b, "requestPinShortcut result:" + zBooleanValue);
        return zBooleanValue;
    }

    public final /* synthetic */ Object c(String str, ShortcutInfo shortcutInfo, IntentSender intentSender, int i10) throws RemoteException {
        ITranShortcutManager iTranShortcutManager = this.f13964a;
        return iTranShortcutManager != null ? Boolean.valueOf(iTranShortcutManager.requestPinShortcut(str, shortcutInfo, intentSender, i10)) : Boolean.FALSE;
    }

    @VisibleForTesting
    public void d(ITranShortcutManager iTranShortcutManager) {
        this.f13964a = iTranShortcutManager;
    }
}
