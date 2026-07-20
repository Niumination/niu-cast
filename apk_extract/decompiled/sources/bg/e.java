package bg;

import ag.k;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nh.d f1320a;

    static {
        String property = System.getProperty("ktor.internal.cio.disable.chararray.pooling");
        f1320a = property != null ? Boolean.parseBoolean(property) : false ? new d() : new k(4096, 2);
    }
}
