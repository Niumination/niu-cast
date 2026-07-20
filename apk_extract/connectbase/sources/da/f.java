package da;

import android.os.LocaleList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f3645c = "f";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ed.g f3646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m7.g f3647b;

    @yb.a(level = 1)
    public List<e> a(boolean z10) {
        return b(fc.b.a.f5983c).b(z10);
    }

    public xf.c b(String str) {
        if (fc.b.b(str)) {
            ed.g gVar = this.f3646a;
            if (gVar != null) {
                return gVar;
            }
            ed.g gVar2 = new ed.g();
            this.f3646a = gVar2;
            return gVar2;
        }
        m7.g gVar3 = this.f3647b;
        if (gVar3 != null) {
            return gVar3;
        }
        m7.g gVar4 = new m7.g();
        this.f3647b = gVar4;
        return gVar4;
    }

    public void c(Locale locale) {
        b(fc.b.a.f5992l).c(locale);
    }

    @yb.a(level = 1)
    public void d(LocaleList localeList) {
        b(fc.b.a.f5988h).a(localeList);
    }
}
