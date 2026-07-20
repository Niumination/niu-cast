package i8;

import android.content.IntentSender;
import android.content.pm.IShortcutService;
import android.content.pm.ShortcutInfo;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.android.internal.infra.AndroidFuture;
import com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel;
import dc.e;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7748b = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IShortcutService f7749a;

    public a() {
        if (this.f7749a == null) {
            this.f7749a = IShortcutService.Stub.asInterface(ServiceManager.getService(FloatingWindowViewModel.C));
        }
    }

    public final <T> T a(AndroidFuture<T> androidFuture) {
        try {
            return (T) androidFuture.get();
        } catch (Throwable th2) {
            th = th2;
            if (th instanceof ExecutionException) {
                th = th.getCause();
                e.a(f7748b, "ExecutionException fail " + th);
            }
            if (th instanceof RuntimeException) {
                e.a(f7748b, "RuntimeException fail " + th);
            }
            if (th instanceof Error) {
                e.a(f7748b, "Error fail " + th);
            }
            e.a(f7748b, "getFutureOrThrow fail " + th);
            return null;
        }
    }

    public boolean b(String str, ShortcutInfo shortcutInfo, IntentSender intentSender, int i10) {
        AndroidFuture androidFuture = new AndroidFuture();
        try {
            this.f7749a.requestPinShortcut(str, shortcutInfo, intentSender, i10, androidFuture);
            return Boolean.parseBoolean((String) a(androidFuture));
        } catch (RemoteException e10) {
            e.a(f7748b, "requestPinShortcut fail " + e10);
            return false;
        }
    }
}
