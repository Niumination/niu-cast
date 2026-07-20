package zb;

import android.content.Context;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public class f<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f21904b = "f";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f21905c = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f21906a;

    public interface a<T> {
        T run() throws RemoteException;
    }

    public interface b<T> {
        T run() throws RemoteException;
    }

    public interface c<T> {
        T run() throws RemoteException;
    }

    public f() {
    }

    public T a(a aVar, String str) {
        try {
            return (T) aVar.run();
        } catch (RemoteException e10) {
            if (this.f21906a != null) {
                e.l(this.f21906a, str, e10);
            } else {
                e.m(str, e10);
            }
            return null;
        }
    }

    public void b(String str, long j10) {
        if (j10 >= 200) {
            Context context = this.f21906a;
            if (context != null) {
                e.n(context, str, j10);
            } else {
                e.o(str, j10);
            }
        }
    }

    public T c(b bVar, String str) {
        T t10;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            t10 = (T) bVar.run();
        } catch (RemoteException e10) {
            if (this.f21906a != null) {
                e.l(this.f21906a, str, e10);
            } else {
                e.m(str, e10);
            }
            t10 = null;
        }
        b(str, System.currentTimeMillis() - jCurrentTimeMillis);
        return t10;
    }

    public T d(c cVar, String str) {
        T t10;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            t10 = (T) cVar.run();
        } catch (RemoteException e10) {
            j7.b.a("TimeOutException : ", e10, f21904b);
            t10 = null;
        }
        b(str, System.currentTimeMillis() - jCurrentTimeMillis);
        return t10;
    }

    public f(Context context) {
        this.f21906a = context;
    }
}
