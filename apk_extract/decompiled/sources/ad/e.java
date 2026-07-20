package ad;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.PopupMenu;
import com.transsion.widgetslib.widget.actionbar.OverflowMenu;
import java.lang.ref.WeakReference;
import ld.m;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f97a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f98b;

    public /* synthetic */ e(Object obj, int i8) {
        this.f97a = i8;
        this.f98b = obj;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (this.f97a) {
            case 0:
                c.g("ReplyMessenger msg.what = " + message.what);
                f fVar = (f) this.f98b;
                Handler.Callback callback = fVar.f100b;
                if (callback != null) {
                    callback.handleMessage(message);
                }
                try {
                    if (fVar.f101c != null) {
                        fVar.f101c = null;
                        fVar.f99a.unbindService(fVar);
                    }
                } catch (Exception e) {
                    c.h(Log.getStackTraceString(e));
                    return;
                }
                break;
            case 1:
                OverflowMenu overflowMenu = (OverflowMenu) this.f98b;
                PopupMenu popupMenu = overflowMenu.f3461k;
                if (popupMenu != null) {
                    popupMenu.getMenu().clear();
                    overflowMenu.f3461k.inflate(overflowMenu.f3465o);
                }
                break;
            default:
                try {
                    int i8 = message.what;
                    if (i8 == -3 || i8 == -2 || i8 == -1) {
                        ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) ((WeakReference) this.f98b).get(), message.what);
                    } else if (i8 == 1) {
                        ((DialogInterface) message.obj).dismiss();
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
                break;
        }
    }

    public e(m mVar) {
        this.f97a = 2;
        this.f98b = new WeakReference(mVar);
    }
}
