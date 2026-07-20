package yj;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class k1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @b1.e
    public static final int f21073e = 128;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Channel f21075b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f21074a = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f21077d = new AtomicBoolean();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue<c> f21076c = new ConcurrentLinkedQueue();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k1.this.e();
        }
    }

    public static abstract class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChannelPromise f21079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final fm.b f21080b = fm.c.o();

        @Override // yj.k1.c
        public final void a(Channel channel) {
            channel.write(this, this.f21079a);
        }

        @Override // yj.k1.c
        public fm.b b() {
            return this.f21080b;
        }

        @Override // yj.k1.c
        public final void c(ChannelPromise channelPromise) {
            this.f21079a = channelPromise;
        }

        @Override // yj.k1.c
        public final ChannelPromise promise() {
            return this.f21079a;
        }
    }

    public interface c {
        void a(Channel channel);

        fm.b b();

        void c(ChannelPromise channelPromise);

        ChannelPromise promise();
    }

    public static class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f21081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final fm.b f21082b = fm.c.o();

        public d(Runnable runnable) {
            this.f21081a = runnable;
        }

        @Override // yj.k1.c
        public final void a(Channel channel) {
            this.f21081a.run();
        }

        @Override // yj.k1.c
        public fm.b b() {
            return this.f21082b;
        }

        @Override // yj.k1.c
        public final void c(ChannelPromise channelPromise) {
            throw new UnsupportedOperationException();
        }

        @Override // yj.k1.c
        public final ChannelPromise promise() {
            throw new UnsupportedOperationException();
        }
    }

    public k1(Channel channel) {
        this.f21075b = (Channel) c1.h0.F(channel, "channel");
    }

    public void b() {
        c1.h0.h0(this.f21075b.eventLoop().inEventLoop(), "must be on the event loop");
        if (this.f21076c.peek() == null) {
            return;
        }
        e();
    }

    @t1.a
    public ChannelFuture c(c cVar, boolean z10) {
        c1.h0.e(cVar.promise() == null, "promise must not be set on command");
        ChannelPromise channelPromiseNewPromise = this.f21075b.newPromise();
        cVar.c(channelPromiseNewPromise);
        this.f21076c.add(cVar);
        if (z10) {
            f();
        }
        return channelPromiseNewPromise;
    }

    public void d(Runnable runnable, boolean z10) {
        this.f21076c.add(new d(runnable));
        if (z10) {
            f();
        }
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0091  */
    public final void e() {
        try {
            fm.f fVarZ = fm.c.z("WriteQueue.periodicFlush");
            int i10 = 0;
            boolean z10 = false;
            while (true) {
                try {
                    c cVarPoll = this.f21076c.poll();
                    if (cVarPoll == null) {
                        break;
                    }
                    cVarPoll.a(this.f21075b);
                    i10++;
                    if (i10 == 128) {
                        fm.f fVarZ2 = fm.c.z("WriteQueue.flush0");
                        try {
                            this.f21075b.flush();
                            if (fVarZ2 != null) {
                                fm.c.u();
                            }
                            z10 = true;
                            i10 = 0;
                        } catch (Throwable th2) {
                            if (fVarZ2 != null) {
                                try {
                                    fm.c.u();
                                } catch (Throwable th3) {
                                    th2.addSuppressed(th3);
                                }
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    if (fVarZ != null) {
                        try {
                            fm.c.u();
                        } catch (Throwable th5) {
                            th4.addSuppressed(th5);
                        }
                    }
                    throw th4;
                }
                this.f21077d.set(false);
                if (!this.f21076c.isEmpty()) {
                    f();
                }
                throw th;
            }
            if (i10 != 0 || !z10) {
                fm.f fVarZ3 = fm.c.z("WriteQueue.flush1");
                try {
                    this.f21075b.flush();
                    if (fVarZ3 != null) {
                        fm.c.u();
                    }
                } catch (Throwable th6) {
                    if (fVarZ3 != null) {
                        try {
                            fm.c.u();
                        } catch (Throwable th7) {
                            th6.addSuppressed(th7);
                        }
                    }
                    throw th6;
                }
            }
            if (fVarZ != null) {
                fm.c.u();
            }
            this.f21077d.set(false);
            if (this.f21076c.isEmpty()) {
                return;
            }
            f();
        } catch (Throwable th8) {
            this.f21077d.set(false);
            if (!this.f21076c.isEmpty()) {
                f();
            }
            throw th8;
        }
    }

    public void f() {
        if (this.f21077d.compareAndSet(false, true)) {
            this.f21075b.eventLoop().execute(this.f21074a);
        }
    }
}
