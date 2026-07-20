package y6;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;
import ik.t;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import k3.dd;
import tj.w;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements f2.b, zj.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile g f11094c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f11095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f11096b;

    public /* synthetic */ g(Object obj, Object obj2) {
        this.f11095a = obj;
        this.f11096b = obj2;
    }

    public static g a() {
        if (f11094c == null) {
            synchronized (g.class) {
                try {
                    if (f11094c == null) {
                        f11094c = new g(0);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f11094c;
    }

    public synchronized void b(d dVar) {
        int i8;
        int i9;
        ThreadPoolExecutor threadPoolExecutor;
        String strB = dVar.b();
        synchronized (this) {
            try {
                ArrayDeque arrayDeque = (ArrayDeque) this.f11095a;
                if (dd.g(arrayDeque)) {
                    i8 = 0;
                } else {
                    Iterator it = arrayDeque.iterator();
                    i8 = 0;
                    while (it.hasNext()) {
                        if (TextUtils.equals(((d) it.next()).b(), strB)) {
                            i8++;
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (i8 <= 0) {
            synchronized (this) {
                ArrayDeque arrayDeque2 = (ArrayDeque) this.f11095a;
                if (dd.g(arrayDeque2)) {
                    i9 = 0;
                } else {
                    Iterator it2 = arrayDeque2.iterator();
                    i9 = 0;
                    while (it2.hasNext()) {
                        if (((d) it2.next()) instanceof e) {
                            i9++;
                        }
                    }
                }
                boolean z2 = i9 > 0;
                if (!z2) {
                    ((ArrayDeque) this.f11095a).add(dVar);
                    synchronized (this) {
                        try {
                            if (((ThreadPoolExecutor) this.f11096b) == null) {
                                this.f11096b = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new t(2));
                            }
                            threadPoolExecutor = (ThreadPoolExecutor) this.f11096b;
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                }
            }
            threadPoolExecutor.execute(dVar);
        }
    }

    @Override // zj.e
    public Type c() {
        return (Type) this.f11095a;
    }

    public byte[] d(byte[] bArr) {
        Cipher cipher = (Cipher) this.f11096b;
        if (cipher != null) {
            try {
                return cipher.doFinal(bArr);
            } catch (Exception e) {
                z6.a.c(Log.getStackTraceString(e));
            }
        }
        return null;
    }

    public synchronized void e(d dVar) {
        ((ArrayDeque) this.f11095a).remove(dVar);
    }

    public byte[] f(byte[] bArr) {
        Cipher cipher = (Cipher) this.f11095a;
        if (cipher != null) {
            try {
                return cipher.doFinal(bArr);
            } catch (Exception e) {
                z6.a.c(Log.getStackTraceString(e));
            }
        }
        return null;
    }

    @Override // yh.a
    public Object get() {
        return new e2.f((Context) ((w) this.f11095a).f10262b, (e2.e) ((a8.a) this.f11096b).get());
    }

    @Override // zj.e
    public Object k(zj.w wVar) {
        Executor executor = (Executor) this.f11096b;
        return executor == null ? wVar : new zj.k(executor, wVar);
    }

    public g(int i8) {
        switch (i8) {
            case 5:
                p2.a aVar = p2.a.f8648d;
                this.f11095a = new SparseIntArray();
                this.f11096b = aVar;
                break;
            default:
                this.f11095a = new ArrayDeque();
                break;
        }
    }

    public g(byte[] bArr) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f11095a = cipher;
            cipher.init(1, secretKeySpec, new IvParameterSpec(s6.d.f9550o));
            SecretKeySpec secretKeySpec2 = new SecretKeySpec(bArr, "AES");
            Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f11096b = cipher2;
            cipher2.init(2, secretKeySpec2, new IvParameterSpec(s6.d.f9550o));
        } catch (Exception e) {
            z6.a.c(Log.getStackTraceString(e));
        }
    }
}
