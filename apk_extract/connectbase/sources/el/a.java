package el;

import java.time.temporal.TemporalAmount;
import java.util.LinkedHashMap;
import java.util.Map;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public String f4494c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f4496e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f4492a = x.f4554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public ik.o f4493b = ik.o.URI_ENCODING;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public String f4495d = "/";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4497f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final Map<String, String> f4498g = new LinkedHashMap();

    @lm.k(level = lm.m.HIDDEN, message = "Use maxAge or maxAgeInSeconds instead.")
    public static /* synthetic */ void c() {
    }

    @os.m
    public final String a() {
        return this.f4494c;
    }

    public final /* synthetic */ TemporalAmount b() {
        return g.a(this);
    }

    @os.l
    public final ik.o d() {
        return this.f4493b;
    }

    @os.l
    public final Map<String, String> e() {
        return this.f4498g;
    }

    public final boolean f() {
        return this.f4497f;
    }

    public final long g() {
        return this.f4492a;
    }

    @os.m
    public final String h() {
        return this.f4495d;
    }

    public final boolean i() {
        return this.f4496e;
    }

    public final void j(@os.m String str) {
        this.f4494c = str;
    }

    public final /* synthetic */ void k(TemporalAmount temporalAmount) {
        g.c(this, temporalAmount);
    }

    public final void l(@os.l ik.o oVar) {
        l0.p(oVar, "<set-?>");
        this.f4493b = oVar;
    }

    public final void m(boolean z10) {
        this.f4497f = z10;
    }

    public final void n(long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException(l0.C("maxAgeInSeconds shouldn't be negative: ", Long.valueOf(j10)).toString());
        }
        this.f4492a = j10;
    }

    public final void o(@os.m String str) {
        this.f4495d = str;
    }

    public final void p(boolean z10) {
        this.f4496e = z10;
    }
}
