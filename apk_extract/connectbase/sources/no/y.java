package no;

import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final y f11796a = new y();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @in.f
    @os.l
    public static final dp.c f11797b = new dp.c("kotlin.jvm.JvmField");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final dp.b f11798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final dp.b f11799d;

    static {
        dp.b bVarM = dp.b.m(new dp.c("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
        l0.o(bVarM, "topLevel(FqName(\"kotlin.….ReflectionFactoryImpl\"))");
        f11798c = bVarM;
        dp.b bVarE = dp.b.e("kotlin/jvm/internal/RepeatableContainer");
        l0.o(bVarE, "fromString(\"kotlin/jvm/i…nal/RepeatableContainer\")");
        f11799d = bVarE;
    }

    @in.n
    @os.l
    public static final String b(@os.l String str) {
        l0.p(str, "propertyName");
        return f(str) ? str : l0.C("get", cq.a.a(str));
    }

    @in.n
    public static final boolean c(@os.l String str) {
        l0.p(str, "name");
        return jq.e0.s2(str, "get", false, 2, null) || jq.e0.s2(str, "is", false, 2, null);
    }

    @in.n
    public static final boolean d(@os.l String str) {
        l0.p(str, "name");
        return jq.e0.s2(str, "set", false, 2, null);
    }

    @in.n
    @os.l
    public static final String e(@os.l String str) {
        String strA;
        l0.p(str, "propertyName");
        if (f(str)) {
            strA = str.substring(2);
            l0.o(strA, "this as java.lang.String).substring(startIndex)");
        } else {
            strA = cq.a.a(str);
        }
        return l0.C("set", strA);
    }

    @in.n
    public static final boolean f(@os.l String str) {
        l0.p(str, "name");
        if (!jq.e0.s2(str, "is", false, 2, null) || str.length() == 2) {
            return false;
        }
        char cCharAt = str.charAt(2);
        return l0.t(97, cCharAt) > 0 || l0.t(cCharAt, y5.a.f20736o0) > 0;
    }

    @os.l
    public final dp.b a() {
        return f11799d;
    }
}
