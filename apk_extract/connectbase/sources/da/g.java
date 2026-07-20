package da;

import android.content.Context;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ed.h f3648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m7.h f3649b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Locale f3650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3651b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f3652c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Locale f3653d;

        public a(Locale locale, String str, String str2) {
            this.f3650a = locale;
            this.f3651b = str;
            this.f3652c = str2;
        }

        public String a() {
            return this.f3652c;
        }

        public String b() {
            return this.f3651b;
        }

        public Locale c() {
            return this.f3650a;
        }

        public Locale d() {
            return this.f3653d;
        }

        public void e(String str) {
            this.f3652c = str;
        }

        public void f(Locale locale) {
            this.f3653d = locale;
        }

        public String toString() {
            return this.f3651b;
        }
    }

    public Set<a> a(Context context, Set<String> set, a aVar, boolean z10) {
        return c(fc.b.a.f5989i).a(context, set, aVar, z10);
    }

    public Set<a> b(Context context, Set<String> set, a aVar, boolean z10) {
        return c(fc.b.a.f6001u).b(context, set, aVar, z10);
    }

    public xf.d c(String str) {
        if (fc.b.b(str)) {
            ed.h hVar = this.f3648a;
            if (hVar != null) {
                return hVar;
            }
            ed.h hVar2 = new ed.h();
            this.f3648a = hVar2;
            return hVar2;
        }
        m7.h hVar3 = this.f3649b;
        if (hVar3 != null) {
            return hVar3;
        }
        m7.h hVar4 = new m7.h();
        this.f3649b = hVar4;
        return hVar4;
    }
}
