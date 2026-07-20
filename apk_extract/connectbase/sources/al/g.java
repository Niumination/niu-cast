package al;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.kqueue.KQueue;
import io.netty.channel.kqueue.KQueueEventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.ScheduledFuture;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kn.l0;
import kn.n0;
import lm.d0;
import lm.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements EventLoopGroup {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final b f334c = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final d0<Method> f335d = f0.b(a.INSTANCE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final un.d<? extends ServerSocketChannel> f336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EventLoopGroup f337b;

    public static final class a extends n0 implements jn.a<Method> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        @Override // jn.a
        @os.m
        public final Method invoke() {
            try {
                return Class.forName("yl.g").getMethod("prohibitParking", null);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static final class b {
        public b() {
        }

        public static final Thread d(DefaultThreadFactory defaultThreadFactory, final Runnable runnable) {
            l0.p(defaultThreadFactory, "$defaultFactory");
            return defaultThreadFactory.newThread(new Runnable() { // from class: al.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.b.e(runnable);
                }
            });
        }

        public static final void e(Runnable runnable) {
            g.f334c.g();
            runnable.run();
        }

        @os.l
        public final g c(int i10) {
            final DefaultThreadFactory defaultThreadFactory = new DefaultThreadFactory((Class<?>) g.class);
            ThreadFactory threadFactory = new ThreadFactory() { // from class: al.f
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return g.b.d(defaultThreadFactory, runnable);
                }
            };
            un.d<? extends ServerSocketChannel> dVarB = m.b();
            if (KQueue.isAvailable()) {
                return new g(dVarB, new KQueueEventLoopGroup(i10, threadFactory));
            }
            return Epoll.isAvailable() ? new g(dVarB, new EpollEventLoopGroup(i10, threadFactory)) : new g(dVarB, new NioEventLoopGroup(i10, threadFactory));
        }

        public final Method f() {
            return (Method) g.f335d.getValue();
        }

        public final void g() {
            try {
                Method methodF = f();
                if (methodF == null) {
                    return;
                }
                methodF.invoke(null, null);
            } catch (Throwable unused) {
            }
        }

        public b(kn.w wVar) {
        }
    }

    public g(@os.l un.d<? extends ServerSocketChannel> dVar, @os.l EventLoopGroup eventLoopGroup) {
        l0.p(dVar, "channel");
        l0.p(eventLoopGroup, "group");
        this.f336a = dVar;
        this.f337b = eventLoopGroup;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j10, TimeUnit timeUnit) {
        return this.f337b.awaitTermination(j10, timeUnit);
    }

    @os.l
    public final un.d<? extends ServerSocketChannel> b() {
        return this.f336a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f337b.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        return this.f337b.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        return (T) this.f337b.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f337b.isShutdown();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return this.f337b.isShuttingDown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f337b.isTerminated();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.lang.Iterable
    @os.l
    public Iterator<EventExecutor> iterator() {
        return this.f337b.iterator();
    }

    @Override // io.netty.channel.EventLoopGroup, io.netty.util.concurrent.EventExecutorGroup
    public EventLoop next() {
        return this.f337b.next();
    }

    @Override // io.netty.channel.EventLoopGroup
    public ChannelFuture register(Channel channel) {
        return this.f337b.register(channel);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        return this.f337b.schedule(runnable, j10, timeUnit);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        return this.f337b.scheduleAtFixedRate(runnable, j10, j11, timeUnit);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        return this.f337b.scheduleWithFixedDelay(runnable, j10, j11, timeUnit);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ExecutorService
    @lm.k(message = "Deprecated in Java")
    public void shutdown() {
        this.f337b.shutdown();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public io.netty.util.concurrent.Future<?> shutdownGracefully() {
        return this.f337b.shutdownGracefully();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ExecutorService
    @lm.k(message = "Deprecated in Java")
    public List<Runnable> shutdownNow() {
        return this.f337b.shutdownNow();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ExecutorService
    public io.netty.util.concurrent.Future<?> submit(Runnable runnable) {
        return this.f337b.submit(runnable);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public io.netty.util.concurrent.Future<?> terminationFuture() {
        return this.f337b.terminationFuture();
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) {
        return this.f337b.invokeAll(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) {
        return (T) this.f337b.invokeAny(collection, j10, timeUnit);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public EventExecutor next() {
        return this.f337b.next();
    }

    @Override // io.netty.channel.EventLoopGroup
    @lm.k(message = "Deprecated in Java")
    public ChannelFuture register(Channel channel, ChannelPromise channelPromise) {
        return this.f337b.register(channel, channelPromise);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j10, TimeUnit timeUnit) {
        return this.f337b.schedule((Callable) callable, j10, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public java.util.concurrent.ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        return this.f337b.scheduleAtFixedRate(runnable, j10, j11, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public java.util.concurrent.ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        return this.f337b.scheduleWithFixedDelay(runnable, j10, j11, timeUnit);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public io.netty.util.concurrent.Future<?> shutdownGracefully(long j10, long j11, TimeUnit timeUnit) {
        return this.f337b.shutdownGracefully(j10, j11, timeUnit);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ExecutorService
    public <T> io.netty.util.concurrent.Future<T> submit(Runnable runnable, T t10) {
        return this.f337b.submit(runnable, (Object) t10);
    }

    @Override // io.netty.channel.EventLoopGroup
    public ChannelFuture register(ChannelPromise channelPromise) {
        return this.f337b.register(channelPromise);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public java.util.concurrent.ScheduledFuture schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        return this.f337b.schedule(runnable, j10, timeUnit);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ExecutorService
    public <T> io.netty.util.concurrent.Future<T> submit(Callable<T> callable) {
        return this.f337b.submit((Callable) callable);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public java.util.concurrent.ScheduledFuture schedule(Callable callable, long j10, TimeUnit timeUnit) {
        return this.f337b.schedule(callable, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable) {
        return this.f337b.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable, Object obj) {
        return this.f337b.submit(runnable, obj);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Callable callable) {
        return this.f337b.submit(callable);
    }
}
