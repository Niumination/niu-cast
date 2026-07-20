package c3;

import android.content.Context;
import android.net.Uri;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final e f1276a = new e();

    @os.l
    public final x2.c a(@os.l Context context, @os.l Uri uri) {
        l0.p(context, "context");
        l0.p(uri, "uri");
        return l0.g(uri.getScheme(), "text") ? new r(uri) : new o(context, uri);
    }
}
