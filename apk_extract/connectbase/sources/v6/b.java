package v6;

import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public class b implements hf.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16665a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f16666b = cc.a.a("android.content.ContentProvider");

    @Override // hf.b
    public Uri a(Uri uri, int i10) {
        Object objJ = cc.a.j(cc.a.g(f16666b, "maybeAddUserId", Uri.class, Integer.TYPE), null, uri, Integer.valueOf(i10));
        return objJ instanceof Uri ? (Uri) objJ : uri;
    }
}
