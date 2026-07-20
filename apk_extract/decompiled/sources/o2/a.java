package o2;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReentrantLock f8362c = new ReentrantLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f8363d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f8364a = new ReentrantLock();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f8365b;

    public a(Context context) {
        this.f8365b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public final String a(String str) {
        ReentrantLock reentrantLock = this.f8364a;
        reentrantLock.lock();
        try {
            return this.f8365b.getString(str, null);
        } finally {
            reentrantLock.unlock();
        }
    }
}
