package nq;

import java.io.Closeable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class x1 extends n0 implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final a f11984a = new a();

    @lm.r
    public static final class a extends um.b<n0, x1> {

        /* JADX INFO: renamed from: nq.x1$a$a, reason: collision with other inner class name */
        public static final class C0304a extends kn.n0 implements jn.l<um.g.b, x1> {
            public static final C0304a INSTANCE = new C0304a();

            public C0304a() {
                super(1);
            }

            @Override // jn.l
            @os.m
            public final x1 invoke(@os.l um.g.b bVar) {
                if (bVar instanceof x1) {
                    return (x1) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(kn.w wVar) {
            this();
        }

        public a() {
            super(n0.Key, C0304a.INSTANCE);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    @os.l
    public abstract Executor f0();
}
