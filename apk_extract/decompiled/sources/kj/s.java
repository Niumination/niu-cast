package kj;

import com.transsion.core.pool.TranssionPoolExecutor;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements Closeable {
    public static final e0 B;
    public final LinkedHashSet A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f6936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f6937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6939d;
    public int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6940h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final gj.d f6941i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final gj.c f6942j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final gj.c f6943k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final gj.c f6944l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d0 f6945m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f6946n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f6947o;
    public long p;
    public long q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final e0 f6948r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public e0 f6949s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f6950t;
    public long u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f6951v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f6952w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Socket f6953x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final b0 f6954y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final n f6955z;

    static {
        e0 e0Var = new e0();
        e0Var.c(7, 65535);
        e0Var.c(5, 16384);
        B = e0Var;
    }

    public s(d2.a builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f6936a = (j) builder.e;
        this.f6937b = new LinkedHashMap();
        String str = (String) builder.f4257a;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionName");
        }
        this.f6938c = str;
        this.e = 3;
        gj.d dVar = (gj.d) builder.f4261h;
        this.f6941i = dVar;
        this.f6942j = dVar.e();
        this.f6943k = dVar.e();
        this.f6944l = dVar.e();
        this.f6945m = d0.f6902a;
        e0 e0Var = new e0();
        e0Var.c(7, 16777216);
        Unit unit = Unit.INSTANCE;
        this.f6948r = e0Var;
        e0 e0Var2 = B;
        this.f6949s = e0Var2;
        this.f6952w = e0Var2.a();
        Socket socket = (Socket) builder.f4258b;
        if (socket == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socket");
        }
        this.f6953x = socket;
        qj.s sVar = (qj.s) builder.f4260d;
        if (sVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sink");
        }
        this.f6954y = new b0(sVar);
        qj.t tVar = (qj.t) builder.f4259c;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(TranssionPoolExecutor.DEFAULT_SOURCE_EXECUTOR_NAME);
        }
        this.f6955z = new n(this, new w(tVar));
        this.A = new LinkedHashSet();
    }

    public final void a(c connectionCode, c streamCode, IOException iOException) {
        int i8;
        a0[] a0VarArr;
        Intrinsics.checkNotNullParameter(connectionCode, "connectionCode");
        Intrinsics.checkNotNullParameter(streamCode, "streamCode");
        byte[] bArr = ej.b.f4964a;
        try {
            i(connectionCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (this.f6937b.isEmpty()) {
                    a0VarArr = null;
                } else {
                    Object[] array = this.f6937b.values().toArray(new a0[0]);
                    if (array == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    a0VarArr = (a0[]) array;
                    this.f6937b.clear();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (a0VarArr != null) {
            for (a0 a0Var : a0VarArr) {
                try {
                    a0Var.c(streamCode, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.f6954y.close();
        } catch (IOException unused3) {
        }
        try {
            this.f6953x.close();
        } catch (IOException unused4) {
        }
        this.f6942j.e();
        this.f6943k.e();
        this.f6944l.e();
    }

    public final void c(IOException iOException) {
        c cVar = c.PROTOCOL_ERROR;
        a(cVar, cVar, iOException);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a(c.NO_ERROR, c.CANCEL, null);
    }

    public final void flush() {
        this.f6954y.flush();
    }

    public final synchronized a0 g(int i8) {
        return (a0) this.f6937b.get(Integer.valueOf(i8));
    }

    public final synchronized a0 h(int i8) {
        a0 a0Var;
        a0Var = (a0) this.f6937b.remove(Integer.valueOf(i8));
        notifyAll();
        return a0Var;
    }

    public final void i(c statusCode) {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        synchronized (this.f6954y) {
            synchronized (this) {
                if (this.f6940h) {
                    return;
                }
                this.f6940h = true;
                int i8 = this.f6939d;
                Unit unit = Unit.INSTANCE;
                this.f6954y.g(i8, statusCode, ej.b.f4964a);
            }
        }
    }

    public final synchronized void k(long j8) {
        long j10 = this.f6950t + j8;
        this.f6950t = j10;
        long j11 = j10 - this.u;
        if (j11 >= this.f6948r.a() / 2) {
            o(0, j11);
            this.u += j11;
        }
    }

    public final void l(int i8, boolean z2, qj.f fVar, long j8) {
        long j10;
        long j11;
        int iMin;
        long j12;
        if (j8 == 0) {
            this.f6954y.e0(z2, i8, fVar, 0);
            return;
        }
        while (j8 > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        try {
                            j10 = this.f6951v;
                            j11 = this.f6952w;
                            if (j10 >= j11) {
                                if (!this.f6937b.containsKey(Integer.valueOf(i8))) {
                                    throw new IOException("stream closed");
                                }
                                wait();
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                iMin = Math.min((int) Math.min(j8, j11 - j10), this.f6954y.f6889b);
                j12 = iMin;
                this.f6951v += j12;
                Unit unit = Unit.INSTANCE;
            }
            j8 -= j12;
            this.f6954y.e0(z2 && j8 == 0, i8, fVar, iMin);
        }
    }

    public final void m(int i8, c errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.f6942j.c(new q(this.f6938c + '[' + i8 + "] writeSynReset", this, i8, errorCode, 1), 0L);
    }

    public final void o(int i8, long j8) {
        this.f6942j.c(new r(this.f6938c + '[' + i8 + "] windowUpdate", this, i8, j8), 0L);
    }
}
