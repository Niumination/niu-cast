package s1;

import g1.h;
import g1.i;
import io.netty.util.internal.StringUtil;
import jq.m0;

/* JADX INFO: loaded from: classes.dex */
@a
@b1.b
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f14921a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char f14922b = 31;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f14923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f14924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h f14925e;

    static {
        i.c cVarB = i.b();
        cVarB.f6369b = (char) 0;
        cVarB.f6370c = (char) 65533;
        cVarB.f6371d = "�";
        for (char c10 = 0; c10 <= 31; c10 = (char) (c10 + 1)) {
            if (c10 != '\t' && c10 != '\n' && c10 != '\r') {
                cVarB.b(c10, "�");
            }
        }
        cVarB.b(m0.f8866d, "&amp;");
        cVarB.b(m0.f8867e, "&lt;");
        cVarB.b(m0.f8868f, "&gt;");
        f14924d = cVarB.c();
        cVarB.b('\'', "&apos;");
        cVarB.b('\"', "&quot;");
        f14923c = cVarB.c();
        cVarB.b('\t', "&#x9;");
        cVarB.b('\n', "&#xA;");
        cVarB.b(StringUtil.CARRIAGE_RETURN, "&#xD;");
        f14925e = cVarB.c();
    }

    public static h a() {
        return f14925e;
    }

    public static h b() {
        return f14924d;
    }
}
