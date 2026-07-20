package h3;

import com.google.android.gms.common.Feature;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Feature f5238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Feature[] f5239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Feature f5240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Feature[] f5241d;

    static {
        Feature feature = new Feature("CLIENT_TELEMETRY", 1L);
        f5238a = feature;
        f5239b = new Feature[]{feature};
        Feature feature2 = new Feature("moduleinstall", 7L);
        f5240c = feature2;
        f5241d = new Feature[]{feature2};
    }
}
