package no;

import java.util.List;
import java.util.Map;
import java.util.Set;
import lm.t0;
import nm.c1;
import nm.d1;
import nm.o1;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final dp.c f11716a = new dp.c("javax.annotation.meta.TypeQualifierNickname");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final dp.c f11717b = new dp.c("javax.annotation.meta.TypeQualifier");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final dp.c f11718c = new dp.c("javax.annotation.meta.TypeQualifierDefault");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final dp.c f11719d = new dp.c("kotlin.annotations.jvm.UnderMigration");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final List<a> f11720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final Map<dp.c, q> f11721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final Map<dp.c, q> f11722g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final Set<dp.c> f11723h;

    static {
        a aVar = a.FIELD;
        a aVar2 = a.METHOD_RETURN_TYPE;
        a aVar3 = a.VALUE_PARAMETER;
        List<a> listO = nm.y.O(aVar, aVar2, aVar3, a.TYPE_PARAMETER_BOUNDS, a.TYPE_USE);
        f11720e = listO;
        dp.c cVarI = a0.i();
        vo.g gVar = vo.g.NOT_NULL;
        Map<dp.c, q> mapK = c1.k(new t0(cVarI, new q(new vo.h(gVar, false, 2, null), listO, false)));
        f11721f = mapK;
        f11722g = d1.o0(d1.W(new t0(new dp.c("javax.annotation.ParametersAreNullableByDefault"), new q(new vo.h(vo.g.NULLABLE, false, 2, null), nm.x.k(aVar3), false, 4, null)), new t0(new dp.c("javax.annotation.ParametersAreNonnullByDefault"), new q(new vo.h(gVar, false, 2, null), nm.x.k(aVar3), false, 4, null))), mapK);
        f11723h = o1.u(a0.f11706e, a0.f11707f);
    }

    @os.l
    public static final Map<dp.c, q> a() {
        return f11722g;
    }

    @os.l
    public static final Set<dp.c> b() {
        return f11723h;
    }

    @os.l
    public static final Map<dp.c, q> c() {
        return f11721f;
    }

    @os.l
    public static final dp.c d() {
        return f11719d;
    }

    @os.l
    public static final dp.c e() {
        return f11718c;
    }

    @os.l
    public static final dp.c f() {
        return f11717b;
    }

    @os.l
    public static final dp.c g() {
        return f11716a;
    }
}
