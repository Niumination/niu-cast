package bi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final char[] f877f = jq.j.f8822b.toCharArray();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f882e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<s, ei.n> f879b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<t> f880c = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ei.p f878a = new ei.p(w.a());

    public m a(boolean z10) {
        this.f881d = z10;
        return this;
    }

    public m b(String... strArr) {
        for (String str : strArr) {
            e(str);
        }
        return this;
    }

    public String c(Object obj) {
        return d(obj, u.SHALLOW, new v(new StringBuilder()));
    }

    public String d(Object obj, u uVar, r rVar) {
        j jVarP = j.p();
        jVarP.k(this.f882e);
        jVarP.m(this.f881d);
        jVarP.f(rVar);
        jVarP.g(uVar);
        jVarP.i(this.f878a);
        jVarP.l(this.f879b);
        jVarP.s(this.f880c);
        try {
            String strY = jVarP.y();
            if (strY == null || strY.trim().equals("")) {
                jVarP.j(obj);
            } else {
                jVarP.H();
                jVarP.u(strY);
                jVarP.j(obj);
                jVarP.D();
            }
            return jVarP.v().toString();
        } finally {
            j.c();
        }
    }

    public void e(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf > 0) {
            t tVar = new t(str.substring(0, iLastIndexOf), true);
            if (!tVar.f899b) {
                this.f880c.add(tVar);
            }
        }
        this.f880c.add(new t(str, false));
    }
}
