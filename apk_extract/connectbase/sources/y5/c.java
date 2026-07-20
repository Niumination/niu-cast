package y5;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import k4.m;
import w4.o1;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile c f20749g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f20750h = "MirrorClipboardManager";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f20751i = "sync_pc_content";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f20752j = "insert_by_shared";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f20753k = 200;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f20754l = "clipboard_shared_enabled";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClipboardManager f20755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f20756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f20757c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ClipboardManager.OnPrimaryClipChangedListener f20758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ContentObserver f20759e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InterfaceC0538c f20760f;

    public class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            super.onChange(z10);
            c.this.e();
        }
    }

    public interface b {
        void a(String str);
    }

    /* JADX INFO: renamed from: y5.c$c, reason: collision with other inner class name */
    public interface InterfaceC0538c {
        void a(boolean z10);
    }

    public c(Context context) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        this.f20755a = clipboardManager;
        if (clipboardManager == null) {
            m.c(f20750h, "clipboardManager not available");
        } else {
            this.f20758d = new ClipboardManager.OnPrimaryClipChangedListener() { // from class: y5.b
                @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
                public final void onPrimaryClipChanged() {
                    this.f20748a.g();
                }
            };
        }
    }

    public static c d(Context context) {
        if (f20749g == null) {
            synchronized (c.class) {
                try {
                    if (f20749g == null) {
                        f20749g = new c(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f20749g;
    }

    public void c() {
        ClipboardManager.OnPrimaryClipChangedListener onPrimaryClipChangedListener;
        ClipboardManager clipboardManager = this.f20755a;
        if (clipboardManager == null || (onPrimaryClipChangedListener = this.f20758d) == null) {
            return;
        }
        clipboardManager.addPrimaryClipChangedListener(onPrimaryClipChangedListener);
    }

    public final void e() {
        boolean zF = f();
        m.b(f20750h, "Clipboard Status: " + zF);
        InterfaceC0538c interfaceC0538c = this.f20760f;
        if (interfaceC0538c != null) {
            interfaceC0538c.a(zF);
        }
    }

    public boolean f() {
        if (Settings.Global.getString(l6.c.f9711b.getContentResolver(), f20754l) != null) {
            return Settings.Global.getInt(l6.c.f9711b.getContentResolver(), f20754l, 0) == 1;
        }
        m.c(f20750h, "Cross device clipboard setting not found");
        return false;
    }

    public final void g() {
        b bVar;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f20757c < 200) {
                return;
            }
            o1.a.f18113a.Q();
            this.f20757c = jCurrentTimeMillis;
            ClipData primaryClip = this.f20755a.getPrimaryClip();
            if (primaryClip == null || primaryClip.getItemCount() <= 0) {
                return;
            }
            CharSequence text = primaryClip.getItemAt(0).getText();
            String str = (String) this.f20755a.getPrimaryClip().getDescription().getLabel();
            if (TextUtils.equals(str, f20751i) || TextUtils.equals(str, f20752j) || (bVar = this.f20756b) == null || text == null) {
                return;
            }
            bVar.a(text.toString());
        } catch (Exception e10) {
            m.c(f20750h, "clip error: " + e10);
        }
    }

    public void h(CharSequence charSequence) {
        this.f20755a.setPrimaryClip(ClipData.newPlainText(f20751i, charSequence));
    }

    public void i(Context context) {
        e();
        this.f20759e = new a(null);
        context.getContentResolver().registerContentObserver(Settings.Global.getUriFor(f20754l), false, this.f20759e);
    }

    public void j() {
        ClipboardManager.OnPrimaryClipChangedListener onPrimaryClipChangedListener;
        ClipboardManager clipboardManager = this.f20755a;
        if (clipboardManager == null || (onPrimaryClipChangedListener = this.f20758d) == null) {
            return;
        }
        clipboardManager.removePrimaryClipChangedListener(onPrimaryClipChangedListener);
    }

    public void k(b bVar) {
        this.f20756b = bVar;
    }

    public void l(InterfaceC0538c interfaceC0538c) {
        this.f20760f = interfaceC0538c;
        if (interfaceC0538c != null) {
            interfaceC0538c.a(f());
        }
    }

    public void m(Context context) {
        if (this.f20759e != null) {
            context.getContentResolver().unregisterContentObserver(this.f20759e);
        }
    }
}
