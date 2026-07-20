package af;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class k2 implements g0, h0, f6, ze.s0, ze.l1, z5 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k2 f376b = new k2(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k2 f377c = new k2(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f378a;

    public /* synthetic */ k2(int i8) {
        this.f378a = i8;
    }

    public static d1 h() {
        d1 d1Var = new d1();
        d1Var.f209a = new Random();
        long nanos = TimeUnit.SECONDS.toNanos(1L);
        d1Var.f210b = TimeUnit.MINUTES.toNanos(2L);
        d1Var.f211c = 1.6d;
        d1Var.f212d = 0.2d;
        d1Var.e = nanos;
        return d1Var;
    }

    @Override // ze.o1
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] mo1a(Object obj) {
        switch (this.f378a) {
            case 12:
                return (byte[]) obj;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // af.f6
    public Object b() {
        switch (this.f378a) {
            case 9:
                return Executors.newCachedThreadPool(l1.f("grpc-default-executor-%d"));
            default:
                ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, l1.f("grpc-timer-%d"));
                try {
                    scheduledExecutorServiceNewScheduledThreadPool.getClass().getMethod("setRemoveOnCancelPolicy", Boolean.TYPE).invoke(scheduledExecutorServiceNewScheduledThreadPool, Boolean.TRUE);
                    break;
                } catch (NoSuchMethodException unused) {
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e4) {
                    throw new RuntimeException(e4);
                }
                return Executors.unconfigurableScheduledExecutorService(scheduledExecutorServiceNewScheduledThreadPool);
        }
    }

    @Override // ze.l1
    public Object c(String str) {
        v8.c("empty timeout", str.length() > 0);
        v8.c("bad timeout format", str.length() <= 9);
        long j8 = Long.parseLong(str.substring(0, str.length() - 1));
        char cCharAt = str.charAt(str.length() - 1);
        if (cCharAt == 'H') {
            return Long.valueOf(TimeUnit.HOURS.toNanos(j8));
        }
        if (cCharAt == 'M') {
            return Long.valueOf(TimeUnit.MINUTES.toNanos(j8));
        }
        if (cCharAt == 'S') {
            return Long.valueOf(TimeUnit.SECONDS.toNanos(j8));
        }
        if (cCharAt == 'u') {
            return Long.valueOf(TimeUnit.MICROSECONDS.toNanos(j8));
        }
        if (cCharAt == 'm') {
            return Long.valueOf(TimeUnit.MILLISECONDS.toNanos(j8));
        }
        if (cCharAt == 'n') {
            return Long.valueOf(j8);
        }
        throw new IllegalArgumentException("Invalid timeout unit: " + cCharAt);
    }

    @Override // ze.o1
    public Object d(byte[] bArr) {
        switch (this.f378a) {
            case 12:
                return bArr;
            default:
                if (bArr.length < 3) {
                    throw new NumberFormatException("Malformed status code ".concat(new String(bArr, ze.t0.f11435a)));
                }
                return Integer.valueOf((bArr[2] - 48) + ((bArr[1] - 48) * 10) + ((bArr[0] - 48) * 100));
        }
    }

    @Override // af.h0
    public int e(d dVar, int i8, Object obj, int i9) {
        switch (this.f378a) {
            case 3:
                return dVar.m();
            case 4:
                dVar.t(i8);
                return 0;
            case 5:
                dVar.l((byte[]) obj, i9, i8);
                return i9 + i8;
            case 6:
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                int iLimit = byteBuffer.limit();
                byteBuffer.limit(byteBuffer.position() + i8);
                dVar.k(byteBuffer);
                byteBuffer.limit(iLimit);
                return 0;
            default:
                dVar.i((OutputStream) obj, i8);
                return 0;
        }
    }

    @Override // af.f6
    public void f(Object obj) {
        switch (this.f378a) {
            case 9:
                ((ExecutorService) ((Executor) obj)).shutdown();
                break;
            default:
                ((ScheduledExecutorService) obj).shutdown();
                break;
        }
    }

    public long g() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }

    @Override // af.j6
    public void j(a8.a aVar) {
        while (true) {
            InputStream inputStreamF = aVar.f();
            if (inputStreamF == null) {
                return;
            }
            try {
                inputStreamF.close();
            } catch (IOException e) {
                while (true) {
                    InputStream inputStreamF2 = aVar.f();
                    if (inputStreamF2 == null) {
                        throw new RuntimeException(e);
                    }
                    try {
                        inputStreamF2.close();
                    } catch (IOException e4) {
                        w5.f662t.log(Level.WARNING, "Exception closing stream", (Throwable) e4);
                    }
                }
            }
        }
    }

    @Override // af.z5
    public void n() {
    }

    @Override // af.z5
    public void p(ze.q2 q2Var) {
    }

    @Override // af.j6
    public void q() {
    }

    public String toString() {
        switch (this.f378a) {
            case 9:
                return "grpc-default-executor";
            default:
                return super.toString();
        }
    }

    @Override // ze.l1
    public String a(Object obj) {
        Long l4 = (Long) obj;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        if (l4.longValue() < 0) {
            throw new IllegalArgumentException("Timeout too small");
        }
        if (l4.longValue() < 100000000) {
            return l4 + "n";
        }
        if (l4.longValue() < 100000000000L) {
            return timeUnit.toMicros(l4.longValue()) + "u";
        }
        if (l4.longValue() < 100000000000000L) {
            return timeUnit.toMillis(l4.longValue()) + "m";
        }
        if (l4.longValue() < 100000000000000000L) {
            return timeUnit.toSeconds(l4.longValue()) + ExifInterface.LATITUDE_SOUTH;
        }
        if (l4.longValue() < 6000000000000000000L) {
            return timeUnit.toMinutes(l4.longValue()) + "M";
        }
        return timeUnit.toHours(l4.longValue()) + "H";
    }
}
