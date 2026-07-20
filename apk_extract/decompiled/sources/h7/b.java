package h7;

import android.content.ContentResolver;
import android.content.Context;
import k3.k1;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f5268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f5269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f5270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f5271d = new a(null, 0);
    public static final a e = new a(null, 1);

    public static Context a() {
        if (f5268a == null) {
            k1.b("TransAtomicSDKManager", "TransAtomicSDKManager is not initialized");
        }
        return f5268a;
    }

    public static void b() {
        Object objM159constructorimpl;
        ContentResolver contentResolver;
        ContentResolver contentResolver2;
        try {
            Result.Companion companion = Result.INSTANCE;
            Context context = f5268a;
            if (context != null && (contentResolver2 = context.getContentResolver()) != null) {
                contentResolver2.unregisterContentObserver(e);
            }
            Context context2 = f5268a;
            if (context2 != null && (contentResolver = context2.getContentResolver()) != null) {
                contentResolver.unregisterContentObserver(f5271d);
            }
            f5269b = false;
            f5270c = false;
            objM159constructorimpl = Result.m159constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            objM159constructorimpl = Result.m159constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(objM159constructorimpl);
        if (thM162exceptionOrNullimpl != null) {
            k1.b("TransAtomicSDKManager", "unInit failed:" + thM162exceptionOrNullimpl.getMessage());
        }
    }
}
