package pn;

import in.f;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final a f13218a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @f
    public static final double f13219b = Math.log(2.0d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @f
    public static final double f13220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @f
    public static final double f13221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @f
    public static final double f13222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @f
    public static final double f13223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @f
    public static final double f13224g;

    static {
        double dUlp = Math.ulp(1.0d);
        f13220c = dUlp;
        double dSqrt = Math.sqrt(dUlp);
        f13221d = dSqrt;
        double dSqrt2 = Math.sqrt(dSqrt);
        f13222e = dSqrt2;
        double d10 = 1;
        f13223f = d10 / dSqrt;
        f13224g = d10 / dSqrt2;
    }
}
