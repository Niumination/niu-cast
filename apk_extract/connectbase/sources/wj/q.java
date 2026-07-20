package wj;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f19167f = Logger.getLogger(vj.h.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f19168a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vj.c1 f19169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @gm.j
    @hm.a("lock")
    public final Collection<vj.v0.c.b> f19170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f19171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @hm.a("lock")
    public int f19172e;

    public class a extends ArrayDeque<vj.v0.c.b> {
        final /* synthetic */ int val$maxEvents;

        public a(int i10) {
            this.val$maxEvents = i10;
        }

        @Override // java.util.ArrayDeque, java.util.AbstractCollection, java.util.Collection, java.util.Deque, java.util.Queue
        @hm.a("lock")
        public boolean add(vj.v0.c.b bVar) {
            if (size() == this.val$maxEvents) {
                removeFirst();
            }
            q.a(q.this);
            return super.add(bVar);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19173a;

        static {
            int[] iArr = new int[vj.v0.c.b.EnumC0456b.values().length];
            f19173a = iArr;
            try {
                iArr[vj.v0.c.b.EnumC0456b.CT_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19173a[vj.v0.c.b.EnumC0456b.CT_WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public q(vj.c1 c1Var, int i10, long j10, String str) {
        c1.h0.F(str, "description");
        this.f19169b = (vj.c1) c1.h0.F(c1Var, "logId");
        if (i10 > 0) {
            this.f19170c = new a(i10);
        } else {
            this.f19170c = null;
        }
        this.f19171d = j10;
        vj.v0.c.b.a aVar = new vj.v0.c.b.a();
        aVar.f17318a = j.a.a(str, " created");
        aVar.f17319b = vj.v0.c.b.EnumC0456b.CT_INFO;
        aVar.f17320c = Long.valueOf(j10);
        e(aVar.a());
    }

    public static /* synthetic */ int a(q qVar) {
        int i10 = qVar.f19172e;
        qVar.f19172e = i10 + 1;
        return i10;
    }

    public static void d(vj.c1 c1Var, Level level, String str) {
        Logger logger = f19167f;
        if (logger.isLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, "[" + c1Var + "] " + str);
            logRecord.setLoggerName(logger.getName());
            logRecord.setSourceClassName(logger.getName());
            logRecord.setSourceMethodName("log");
            logger.log(logRecord);
        }
    }

    public vj.c1 b() {
        return this.f19169b;
    }

    public boolean c() {
        boolean z10;
        synchronized (this.f19168a) {
            z10 = this.f19170c != null;
        }
        return z10;
    }

    public void e(vj.v0.c.b bVar) {
        Level level;
        int i10 = b.f19173a[bVar.f17314b.ordinal()];
        if (i10 != 1) {
            level = i10 != 2 ? Level.FINEST : Level.FINER;
        } else {
            level = Level.FINE;
        }
        f(bVar);
        d(this.f19169b, level, bVar.f17313a);
    }

    public void f(vj.v0.c.b bVar) {
        synchronized (this.f19168a) {
            try {
                Collection<vj.v0.c.b> collection = this.f19170c;
                if (collection != null) {
                    collection.add(bVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void g(vj.v0.b.a aVar) {
        synchronized (this.f19168a) {
            try {
                if (this.f19170c == null) {
                    return;
                }
                int i10 = this.f19172e;
                ArrayList arrayList = new ArrayList(this.f19170c);
                vj.v0.c.a aVar2 = new vj.v0.c.a();
                aVar2.f17310a = Long.valueOf(i10);
                aVar2.f17311b = Long.valueOf(this.f19171d);
                aVar.f17300c = aVar2.c(arrayList).a();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
