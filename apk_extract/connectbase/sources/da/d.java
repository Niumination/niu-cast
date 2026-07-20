package da;

import bf.l;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ed.e f3641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m7.f f3642b;

    public String a(Locale locale, Locale locale2, boolean z10) {
        if (locale == null || locale2 == null) {
            throw new NullPointerException("locale or displayLocale cannot be null");
        }
        return c(fc.b.a.H).a(locale, locale2, z10);
    }

    public String b(Locale locale, boolean z10) {
        if (locale != null) {
            return c(fc.b.a.f5992l).b(locale, z10);
        }
        throw new NullPointerException("locale cannot be null");
    }

    public l c(String str) {
        if (fc.b.b(str)) {
            ed.e eVar = this.f3641a;
            if (eVar != null) {
                return eVar;
            }
            ed.e eVar2 = new ed.e();
            this.f3641a = eVar2;
            return eVar2;
        }
        m7.f fVar = this.f3642b;
        if (fVar != null) {
            return fVar;
        }
        m7.f fVar2 = new m7.f();
        this.f3642b = fVar2;
        return fVar2;
    }
}
