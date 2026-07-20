package sb;

import android.content.Context;
import android.view.KeyEvent;
import android.view.Window;
import dc.e;
import gm.i;
import java.util.List;
import se.f;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f15038c = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f15039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c9.a f15040b;

    public void a(KeyEvent keyEvent, String str) {
        c(fc.b.a.f5989i).f(keyEvent, str);
    }

    public void b(Context context, @i Window window) {
        c(fc.b.a.f5987g).a(context, window);
    }

    public mh.a c(String str) {
        if (fc.b.b(str)) {
            e.f(f15038c, "TranThubInputMethodManager");
            f fVar = this.f15039a;
            if (fVar != null) {
                return fVar;
            }
            f fVar2 = new f();
            this.f15039a = fVar2;
            return fVar2;
        }
        e.f(f15038c, "TranAospInputMethodManager");
        c9.a aVar = this.f15040b;
        if (aVar != null) {
            return aVar;
        }
        c9.a aVar2 = new c9.a();
        this.f15040b = aVar2;
        return aVar2;
    }

    public void d(int i10, int i11) {
        c(fc.b.a.E).c(i10, i11);
    }

    public void e(a aVar) {
        if (aVar == null) {
            throw new NullPointerException("registerGlobalWritingListener() parameter listener must not be null");
        }
        c(fc.b.a.f5994n).d(aVar);
    }

    public void f(boolean z10) {
        c(fc.b.a.f5994n).g(z10);
    }

    public void g(a aVar) {
        if (aVar == null) {
            throw new NullPointerException("unregisterGlobalWritingListener() parameter listener must not be null");
        }
        c(fc.b.a.f5994n).e(aVar);
    }

    @yb.a(level = 1)
    public void h(List<String> list) {
        c(fc.b.a.f5988h).b(list);
    }
}
