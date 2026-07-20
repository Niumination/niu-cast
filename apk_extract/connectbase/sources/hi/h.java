package hi;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import kn.l0;
import kn.w;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends ContentObserver {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final a f7137c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final String f7138d = "CastStateObserver";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Context f7139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.l<g, l2> f7140b;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public h(@os.l Context context, @os.l jn.l<? super g, l2> lVar) {
        super(new Handler(Looper.getMainLooper()));
        l0.p(context, "context");
        l0.p(lVar, "callback");
        this.f7139a = context;
        this.f7140b = lVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        super.onChange(z10);
        try {
            String string = Settings.Global.getString(this.f7139a.getContentResolver(), b.f7117f);
            if (string == null) {
                string = b.f7118g;
            }
            g gVarA = g.f7132b.a(string);
            Log.d(f7138d, "Cast state changed: state=" + gVarA.f7133a);
            this.f7140b.invoke(gVarA);
        } catch (Exception e10) {
            Log.e(f7138d, "Failed to read cast state", e10);
        }
    }
}
