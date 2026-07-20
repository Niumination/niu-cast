package yj;

import f1.x7;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ReflectiveChannelFactory;
import io.netty.channel.ServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2FlowController;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.NettyRuntime;
import io.netty.util.concurrent.DefaultThreadFactory;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.UnresolvedAddressException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLException;
import vj.v1;
import vj.y2;
import wj.f3;
import wj.h2;
import wj.o3;
import wj.q3;

/* JADX INFO: loaded from: classes2.dex */
public class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f20988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AsciiString f20989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AsciiString f20990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AsciiString f20991d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AsciiString f20992e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AsciiString f20993f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AsciiString f20994g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AsciiString f20995h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AsciiString f20996i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AsciiString f20997j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AsciiString f20998k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final f3.d<EventLoopGroup> f20999l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final f3.d<EventLoopGroup> f21000m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final f3.d<EventLoopGroup> f21001n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final f3.d<EventLoopGroup> f21002o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ChannelFactory<? extends ServerChannel> f21003p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Class<? extends Channel> f21004q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Class<? extends Channel> f21005r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @gm.j
    public static final Constructor<? extends EventLoopGroup> f21006s;

    public class a implements ChannelFactory<ServerChannel> {
        @Override // io.netty.channel.ChannelFactory, io.netty.bootstrap.ChannelFactory
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ServerChannel newChannel() {
            return new NioServerSocketChannel();
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21007a;

        static {
            int[] iArr = new int[f.values().length];
            f21007a = iArr;
            try {
                iArr[f.NIO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21007a[f.EPOLL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ByteBufAllocator f21008a = i1.j(true);
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ByteBufAllocator f21009a = i1.j(false);
    }

    public static final class e implements f3.d<EventLoopGroup> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f21010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f21011b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final f f21012c;

        public e(int i10, String str, f fVar) {
            this.f21010a = str;
            if (i10 == 0 && System.getProperty("io.netty.eventLoopThreads") == null) {
                this.f21011b = NettyRuntime.availableProcessors();
            } else {
                this.f21011b = i10;
            }
            this.f21012c = fVar;
        }

        @Override // wj.f3.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void close(EventLoopGroup eventLoopGroup) {
            eventLoopGroup.shutdownGracefully(0L, 0L, TimeUnit.SECONDS);
        }

        @Override // wj.f3.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public EventLoopGroup a() {
            DefaultThreadFactory defaultThreadFactory = new DefaultThreadFactory(this.f21010a, true);
            int i10 = b.f21007a[this.f21012c.ordinal()];
            if (i10 == 1) {
                return new NioEventLoopGroup(this.f21011b, defaultThreadFactory);
            }
            if (i10 == 2) {
                return i1.k(this.f21011b, defaultThreadFactory);
            }
            throw new AssertionError("Unknown/Unsupported EventLoopGroupType: " + this.f21012c);
        }

        public String toString() {
            return this.f21010a;
        }
    }

    public enum f {
        NIO,
        EPOLL
    }

    public static final class g implements q3.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Http2Stream f21014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Http2FlowController f21015b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Http2FlowController f21016c;

        public g(Http2Connection http2Connection) {
            this.f21015b = http2Connection.remote().flowController();
            this.f21016c = http2Connection.local().flowController();
            this.f21014a = http2Connection.connectionStream();
        }

        @Override // wj.q3.c
        public q3.d read() {
            return new q3.d(this.f21015b.windowSize(this.f21014a), this.f21016c.windowSize(this.f21014a));
        }
    }

    static {
        Logger logger = Logger.getLogger(i1.class.getName());
        f20988a = logger;
        f20989b = AsciiString.of("200");
        f20990c = AsciiString.of(wj.v0.f19370p);
        f20991d = AsciiString.of("GET");
        f20992e = AsciiString.of(h2.f18719h);
        f20993f = AsciiString.of("http");
        f20994g = AsciiString.of(wj.v0.f19364j.f17442b);
        f20995h = AsciiString.of(wj.v0.f19369o);
        f20996i = AsciiString.of(wj.v0.f19365k.f17442b);
        f20997j = AsciiString.of("trailers");
        f20998k = AsciiString.of(wj.v0.f19366l.f17442b);
        f fVar = f.NIO;
        e eVar = new e(1, "grpc-nio-boss-ELG", fVar);
        f20999l = eVar;
        e eVar2 = new e(0, "grpc-nio-worker-ELG", fVar);
        f21000m = eVar2;
        if (t()) {
            f21004q = l();
            f21005r = m();
            f21003p = new ReflectiveChannelFactory(o());
            f21006s = n();
            f fVar2 = f.EPOLL;
            f21001n = new e(1, "grpc-default-boss-ELG", fVar2);
            f21002o = new e(0, "grpc-default-worker-ELG", fVar2);
            return;
        }
        logger.log(Level.FINE, "Epoll is not available, using Nio.", r());
        f21003p = new a();
        f21004q = NioSocketChannel.class;
        f21005r = null;
        f21001n = eVar;
        f21002o = eVar2;
        f21006s = null;
    }

    public static byte[] c(CharSequence charSequence) {
        if (!(charSequence instanceof AsciiString)) {
            return charSequence.toString().getBytes(CharsetUtil.UTF_8);
        }
        AsciiString asciiString = (AsciiString) charSequence;
        return asciiString.isEntireArrayUsed() ? asciiString.array() : asciiString.toByteArray();
    }

    public static Http2Headers d(v1 v1Var, AsciiString asciiString, AsciiString asciiString2, AsciiString asciiString3, AsciiString asciiString4, AsciiString asciiString5) {
        c1.h0.F(asciiString2, "defaultPath");
        c1.h0.F(asciiString3, "authority");
        c1.h0.F(asciiString4, "method");
        v1Var.j(wj.v0.f19364j);
        v1Var.j(wj.v0.f19365k);
        v1Var.j(wj.v0.f19366l);
        return n.Q0(o3.d(v1Var), asciiString3, asciiString2, asciiString4, asciiString, asciiString5);
    }

    public static v1 e(Http2Headers http2Headers) {
        if (!(http2Headers instanceof m.b)) {
            return vj.f1.e(f(http2Headers));
        }
        m.b bVar = (m.b) http2Headers;
        return vj.f1.d(bVar.b1(), bVar.Y0());
    }

    @gm.c
    public static byte[][] f(Http2Headers http2Headers) {
        byte[][] bArr = new byte[http2Headers.size() * 2][];
        int i10 = 0;
        for (Map.Entry<CharSequence, CharSequence> entry : http2Headers) {
            int i11 = i10 + 1;
            bArr[i10] = c(entry.getKey());
            i10 += 2;
            bArr[i11] = c(entry.getValue());
        }
        return o3.e(bArr);
    }

    public static Http2Headers g(v1 v1Var) {
        v1Var.j(wj.v0.f19364j);
        v1Var.j(wj.v0.f19365k);
        v1Var.j(wj.v0.f19366l);
        return n.R0(o3.d(v1Var));
    }

    public static Http2Headers h(v1 v1Var, boolean z10) {
        return !z10 ? g(v1Var) : n.S0(o3.d(v1Var));
    }

    public static v1 i(Http2Headers http2Headers) {
        if (!(http2Headers instanceof m.b)) {
            return vj.f1.e(f(http2Headers));
        }
        m.b bVar = (m.b) http2Headers;
        return vj.f1.d(bVar.b1(), bVar.Y0());
    }

    public static ByteBufAllocator j(boolean z10) {
        int i10;
        Logger logger = f20988a;
        Level level = Level.FINE;
        logger.log(level, "Creating allocator, preferDirect=" + z10);
        if (System.getProperty("io.netty.allocator.maxOrder") == null) {
            logger.log(level, "Forcing maxOrder=8");
            i10 = 8;
        } else {
            int iDefaultMaxOrder = PooledByteBufAllocator.defaultMaxOrder();
            logger.log(level, "Using default maxOrder=" + iDefaultMaxOrder);
            i10 = iDefaultMaxOrder;
        }
        return new PooledByteBufAllocator(z10, PooledByteBufAllocator.defaultNumHeapArena(), z10 ? PooledByteBufAllocator.defaultNumDirectArena() : 0, PooledByteBufAllocator.defaultPageSize(), i10, PooledByteBufAllocator.defaultSmallCacheSize(), PooledByteBufAllocator.defaultNormalCacheSize(), PooledByteBufAllocator.defaultUseCacheForAllThreads());
    }

    public static EventLoopGroup k(int i10, ThreadFactory threadFactory) {
        Constructor<? extends EventLoopGroup> constructor = f21006s;
        c1.h0.h0(constructor != null, "Epoll is not available");
        try {
            return constructor.newInstance(Integer.valueOf(i10), threadFactory);
        } catch (Exception e10) {
            throw new RuntimeException("Cannot create Epoll EventLoopGroup", e10);
        }
    }

    public static Class<? extends Channel> l() {
        try {
            return Class.forName("io.netty.channel.epoll.EpollSocketChannel").asSubclass(Channel.class);
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException("Cannot load EpollSocketChannel", e10);
        }
    }

    public static Class<? extends Channel> m() {
        try {
            return Class.forName("io.netty.channel.epoll.EpollDomainSocketChannel").asSubclass(Channel.class);
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException("Cannot load EpollDomainSocketChannel", e10);
        }
    }

    public static Constructor<? extends EventLoopGroup> n() {
        try {
            return Class.forName("io.netty.channel.epoll.EpollEventLoopGroup").asSubclass(EventLoopGroup.class).getConstructor(Integer.TYPE, ThreadFactory.class);
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException("Cannot load EpollEventLoopGroup", e10);
        } catch (NoSuchMethodException e11) {
            throw new RuntimeException("EpollEventLoopGroup constructor not found", e11);
        }
    }

    public static Class<? extends ServerChannel> o() {
        try {
            return Class.forName("io.netty.channel.epoll.EpollServerSocketChannel").asSubclass(ServerChannel.class);
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException("Cannot load EpollServerSocketChannel", e10);
        }
    }

    public static ByteBufAllocator p(boolean z10) {
        if (!Boolean.parseBoolean(System.getProperty("io.grpc.netty.useCustomAllocator", "true"))) {
            f20988a.log(Level.FINE, "Using default allocator");
            return ByteBufAllocator.DEFAULT;
        }
        if (System.getProperty("io.netty.allocator.type", "pooled").toLowerCase(Locale.ROOT).equals("unpooled")) {
            f20988a.log(Level.FINE, "Using unpooled allocator");
            return UnpooledByteBufAllocator.DEFAULT;
        }
        boolean zDefaultPreferDirect = PooledByteBufAllocator.defaultPreferDirect();
        f20988a.log(Level.FINE, "Using custom allocator: forceHeapBuffer={0}, defaultPreferDirect={1}", new Object[]{Boolean.valueOf(z10), Boolean.valueOf(zDefaultPreferDirect)});
        return (z10 || !zDefaultPreferDirect) ? d.f21009a : c.f21008a;
    }

    @gm.j
    public static <T> ChannelOption<T> q(String str) {
        if (!t()) {
            return null;
        }
        try {
            return (ChannelOption) Class.forName("io.netty.channel.epoll.EpollChannelOption").getField(str).get(null);
        } catch (Exception e10) {
            throw new RuntimeException(n.a.a("ChannelOption(", str, ") is not available"), e10);
        }
    }

    public static Throwable r() {
        try {
            return (Throwable) Class.forName("io.netty.channel.epoll.Epoll").getDeclaredMethod("unavailabilityCause", null).invoke(null, null);
        } catch (Exception e10) {
            return e10;
        }
    }

    public static vj.v0.k s(Channel channel) {
        ChannelConfig channelConfigConfig = channel.config();
        vj.v0.k.a aVar = new vj.v0.k.a();
        Integer num = (Integer) channelConfigConfig.getOption(ChannelOption.SO_LINGER);
        if (num != null) {
            aVar.f17351d = num;
        }
        Integer num2 = (Integer) channelConfigConfig.getOption(ChannelOption.SO_TIMEOUT);
        if (num2 != null) {
            aVar.f17350c = num2;
        }
        for (Map.Entry<ChannelOption<?>, Object> entry : channelConfigConfig.getOptions().entrySet()) {
            ChannelOption<?> key = entry.getKey();
            if (!key.equals(ChannelOption.SO_LINGER) && !key.equals(ChannelOption.SO_TIMEOUT)) {
                aVar.b(key.name(), String.valueOf(entry.getValue()));
            }
        }
        s0.c cVarA = s0.a(channel);
        if (cVarA != null) {
            aVar.f17349b = cVarA.f21293a;
            x7<Map.Entry<String, String>> it = cVarA.f21294b.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                aVar.b(next.getKey(), next.getValue());
            }
        }
        return aVar.d();
    }

    @b1.e
    public static boolean t() {
        try {
            return ((Boolean) Class.forName("io.netty.channel.epoll.Epoll").getDeclaredMethod("isAvailable", null).invoke(null, null)).booleanValue();
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (Exception e10) {
            throw new RuntimeException("Exception while checking Epoll availability", e10);
        }
    }

    @gm.j
    public static ChannelOption<Integer> u() {
        return q("TCP_USER_TIMEOUT");
    }

    public static ChannelFactory<ServerChannel> v() {
        return new a();
    }

    public static y2 w(Throwable th2) {
        y2 y2VarN = y2.n(th2);
        if (y2VarN.f17568a != y2.b.UNKNOWN) {
            return y2VarN;
        }
        if (th2 instanceof ClosedChannelException) {
            if (th2.getCause() != null) {
                return y2.f17563t.u("channel closed").t(th2);
            }
            ClosedChannelException closedChannelException = new ClosedChannelException();
            closedChannelException.initCause(th2);
            return y2.f17550g.u("channel closed").t(closedChannelException);
        }
        if ((th2 instanceof DecoderException) && (th2.getCause() instanceof SSLException)) {
            return y2.f17563t.u("ssl exception").t(th2);
        }
        if (th2 instanceof IOException) {
            return y2.f17563t.u("io exception").t(th2);
        }
        if (th2 instanceof UnresolvedAddressException) {
            return y2.f17563t.u("unresolved address").t(th2);
        }
        return th2 instanceof Http2Exception ? y2.f17562s.u("http2 exception").t(th2) : y2VarN;
    }
}
