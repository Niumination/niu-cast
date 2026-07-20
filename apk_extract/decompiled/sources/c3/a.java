package c3;

import android.content.Context;
import java.util.NoSuchElementException;
import u2.s;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f1425a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f1426b;

    public final void a(Context context, s sVar) {
        try {
            context.unbindService(sVar);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }
}
