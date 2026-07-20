package ia;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f7754d = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public jd.a f7755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r7.a f7756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f7757c;

    public a(Context context) {
        this.f7757c = context;
    }

    public View a() {
        return b(fc.b.a.f5992l).a();
    }

    public cg.a b(String str) {
        if (fc.b.b(str)) {
            e.f(f7754d, "TranThubPhoneWindow");
            jd.a aVar = this.f7755a;
            if (aVar != null) {
                return aVar;
            }
            jd.a aVar2 = new jd.a(this.f7757c);
            this.f7755a = aVar2;
            return aVar2;
        }
        e.f(f7754d, "TranAospPhoneWindow");
        r7.a aVar3 = this.f7756b;
        if (aVar3 != null) {
            return aVar3;
        }
        r7.a aVar4 = new r7.a(this.f7757c);
        this.f7756b = aVar4;
        return aVar4;
    }

    @yb.a(level = 1)
    public boolean c(int i10) {
        return b(fc.b.a.f5992l).b(i10);
    }

    public void d(int i10) {
        b(fc.b.a.f5992l).c(i10);
    }

    @yb.a(level = 1)
    public void e(WindowManager windowManager, IBinder iBinder, String str) {
        b(fc.b.a.f5992l).d(windowManager, iBinder, str);
    }
}
