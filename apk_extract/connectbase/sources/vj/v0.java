package vj;

import java.net.SocketAddress;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class v0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f17281f = Logger.getLogger(v0.class.getName());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final v0 f17282g = new v0();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ boolean f17283h = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentNavigableMap<Long, a1<j>> f17284a = new ConcurrentSkipListMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentNavigableMap<Long, a1<b>> f17285b = new ConcurrentSkipListMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentMap<Long, a1<b>> f17286c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentMap<Long, a1<l>> f17287d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentMap<Long, h> f17288e = new ConcurrentHashMap();

    @hm.b
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f17289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final u f17290b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.j
        public final c f17291c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f17292d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f17293e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f17294f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f17295g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final List<m1> f17296h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final List<m1> f17297i;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f17298a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public u f17299b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public c f17300c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public long f17301d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public long f17302e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public long f17303f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public long f17304g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public List<m1> f17305h = Collections.emptyList();

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public List<m1> f17306i = Collections.emptyList();

            public b a() {
                return new b(this.f17298a, this.f17299b, this.f17300c, this.f17301d, this.f17302e, this.f17303f, this.f17304g, this.f17305h, this.f17306i);
            }

            public a b(long j10) {
                this.f17303f = j10;
                return this;
            }

            public a c(long j10) {
                this.f17301d = j10;
                return this;
            }

            public a d(long j10) {
                this.f17302e = j10;
                return this;
            }

            public a e(c cVar) {
                this.f17300c = cVar;
                return this;
            }

            public a f(long j10) {
                this.f17304g = j10;
                return this;
            }

            public a g(List<m1> list) {
                c1.h0.g0(this.f17305h.isEmpty());
                list.getClass();
                this.f17306i = Collections.unmodifiableList(list);
                return this;
            }

            public a h(u uVar) {
                this.f17299b = uVar;
                return this;
            }

            public a i(List<m1> list) {
                c1.h0.g0(this.f17306i.isEmpty());
                list.getClass();
                this.f17305h = Collections.unmodifiableList(list);
                return this;
            }

            public a j(String str) {
                this.f17298a = str;
                return this;
            }
        }

        public b(String str, u uVar, @gm.j c cVar, long j10, long j11, long j12, long j13, List<m1> list, List<m1> list2) {
            c1.h0.h0(list.isEmpty() || list2.isEmpty(), "channels can have subchannels only, subchannels can have either sockets OR subchannels, neither can have both");
            this.f17289a = str;
            this.f17290b = uVar;
            this.f17291c = cVar;
            this.f17292d = j10;
            this.f17293e = j11;
            this.f17294f = j12;
            this.f17295g = j13;
            this.f17296h = list;
            list2.getClass();
            this.f17297i = list2;
        }
    }

    @hm.b
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f17307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f17308b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<b> f17309c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Long f17310a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Long f17311b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public List<b> f17312c = Collections.emptyList();

            public c a() {
                c1.h0.F(this.f17310a, "numEventsLogged");
                c1.h0.F(this.f17311b, "creationTimeNanos");
                return new c(this.f17310a.longValue(), this.f17311b.longValue(), this.f17312c);
            }

            public a b(long j10) {
                this.f17311b = Long.valueOf(j10);
                return this;
            }

            public a c(List<b> list) {
                this.f17312c = Collections.unmodifiableList(new ArrayList(list));
                return this;
            }

            public a d(long j10) {
                this.f17310a = Long.valueOf(j10);
                return this;
            }
        }

        @hm.b
        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f17313a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final EnumC0456b f17314b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final long f17315c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            @gm.j
            public final m1 f17316d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            @gm.j
            public final m1 f17317e;

            public static final class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public String f17318a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public EnumC0456b f17319b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public Long f17320c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public m1 f17321d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                public m1 f17322e;

                public b a() {
                    c1.h0.F(this.f17318a, "description");
                    c1.h0.F(this.f17319b, "severity");
                    c1.h0.F(this.f17320c, "timestampNanos");
                    c1.h0.h0(this.f17321d == null || this.f17322e == null, "at least one of channelRef and subchannelRef must be null");
                    return new b(this.f17318a, this.f17319b, this.f17320c.longValue(), this.f17321d, this.f17322e);
                }

                public a b(m1 m1Var) {
                    this.f17321d = m1Var;
                    return this;
                }

                public a c(String str) {
                    this.f17318a = str;
                    return this;
                }

                public a d(EnumC0456b enumC0456b) {
                    this.f17319b = enumC0456b;
                    return this;
                }

                public a e(m1 m1Var) {
                    this.f17322e = m1Var;
                    return this;
                }

                public a f(long j10) {
                    this.f17320c = Long.valueOf(j10);
                    return this;
                }
            }

            /* JADX INFO: renamed from: vj.v0$c$b$b, reason: collision with other inner class name */
            public enum EnumC0456b {
                CT_UNKNOWN,
                CT_INFO,
                CT_WARNING,
                CT_ERROR
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return c1.b0.a(this.f17313a, bVar.f17313a) && c1.b0.a(this.f17314b, bVar.f17314b) && this.f17315c == bVar.f17315c && c1.b0.a(this.f17316d, bVar.f17316d) && c1.b0.a(this.f17317e, bVar.f17317e);
            }

            public int hashCode() {
                return Arrays.hashCode(new Object[]{this.f17313a, this.f17314b, Long.valueOf(this.f17315c), this.f17316d, this.f17317e});
            }

            public String toString() {
                return c1.z.c(this).j("description", this.f17313a).j("severity", this.f17314b).e("timestampNanos", this.f17315c).j("channelRef", this.f17316d).j("subchannelRef", this.f17317e).toString();
            }

            public b(String str, EnumC0456b enumC0456b, long j10, @gm.j m1 m1Var, @gm.j m1 m1Var2) {
                this.f17313a = str;
                this.f17314b = (EnumC0456b) c1.h0.F(enumC0456b, "severity");
                this.f17315c = j10;
                this.f17316d = m1Var;
                this.f17317e = m1Var2;
            }
        }

        public c(long j10, long j11, List<b> list) {
            this.f17307a = j10;
            this.f17308b = j11;
            this.f17309c = list;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f17324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.j
        public final Object f17325b;

        public d(String str, @gm.j Object obj) {
            str.getClass();
            this.f17324a = str;
            c1.h0.h0(obj == null || obj.getClass().getName().endsWith("com.google.protobuf.Any"), "the 'any' object must be of type com.google.protobuf.Any");
            this.f17325b = obj;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<a1<b>> f17326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f17327b;

        public e(List<a1<b>> list, boolean z10) {
            list.getClass();
            this.f17326a = list;
            this.f17327b = z10;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<a1<j>> f17330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f17331b;

        public g(List<a1<j>> list, boolean z10) {
            list.getClass();
            this.f17330a = list;
            this.f17331b = z10;
        }
    }

    public static final class h extends ConcurrentSkipListMap<Long, a1<l>> {
        private static final long serialVersionUID = -7883772124944661414L;

        public h() {
        }

        public h(a aVar) {
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<m1> f17332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f17333b;

        public i(List<m1> list, boolean z10) {
            this.f17332a = list;
            this.f17333b = z10;
        }
    }

    @hm.b
    public static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f17334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f17335b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f17336c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f17337d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<a1<l>> f17338e;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public long f17339a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public long f17340b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public long f17341c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public long f17342d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public List<a1<l>> f17343e = new ArrayList();

            public a a(List<a1<l>> list) {
                c1.h0.F(list, "listenSockets");
                Iterator<a1<l>> it = list.iterator();
                while (it.hasNext()) {
                    this.f17343e.add((a1) c1.h0.F(it.next(), "null listen socket"));
                }
                return this;
            }

            public j b() {
                return new j(this.f17339a, this.f17340b, this.f17341c, this.f17342d, this.f17343e);
            }

            public a c(long j10) {
                this.f17341c = j10;
                return this;
            }

            public a d(long j10) {
                this.f17339a = j10;
                return this;
            }

            public a e(long j10) {
                this.f17340b = j10;
                return this;
            }

            public a f(long j10) {
                this.f17342d = j10;
                return this;
            }
        }

        public j(long j10, long j11, long j12, long j13, List<a1<l>> list) {
            this.f17334a = j10;
            this.f17335b = j11;
            this.f17336c = j12;
            this.f17337d = j13;
            list.getClass();
            this.f17338e = list;
        }
    }

    public static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, String> f17344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.j
        public final Integer f17345b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.j
        public final Integer f17346c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @gm.j
        public final m f17347d;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Map<String, String> f17348a = new HashMap();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public m f17349b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Integer f17350c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Integer f17351d;

            public a a(String str, int i10) {
                this.f17348a.put(str, Integer.toString(i10));
                return this;
            }

            public a b(String str, String str2) {
                Map<String, String> map = this.f17348a;
                str2.getClass();
                map.put(str, str2);
                return this;
            }

            public a c(String str, boolean z10) {
                this.f17348a.put(str, Boolean.toString(z10));
                return this;
            }

            public k d() {
                return new k(this.f17350c, this.f17351d, this.f17349b, this.f17348a);
            }

            public a e(Integer num) {
                this.f17351d = num;
                return this;
            }

            public a f(Integer num) {
                this.f17350c = num;
                return this;
            }

            public a g(m mVar) {
                this.f17349b = mVar;
                return this;
            }
        }

        public k(@gm.j Integer num, @gm.j Integer num2, @gm.j m mVar, Map<String, String> map) {
            map.getClass();
            this.f17345b = num;
            this.f17346c = num2;
            this.f17347d = mVar;
            this.f17344a = Collections.unmodifiableMap(new HashMap(map));
        }
    }

    public static final class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @gm.j
        public final o f17352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.j
        public final SocketAddress f17353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.j
        public final SocketAddress f17354c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final k f17355d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @gm.j
        public final f f17356e;

        public l(o oVar, @gm.j SocketAddress socketAddress, @gm.j SocketAddress socketAddress2, k kVar, f fVar) {
            this.f17352a = oVar;
            this.f17353b = (SocketAddress) c1.h0.F(socketAddress, "local socket");
            this.f17354c = socketAddress2;
            kVar.getClass();
            this.f17355d = kVar;
            this.f17356e = fVar;
        }
    }

    public static final class m {
        public final int A;
        public final int B;
        public final int C;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f17358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f17359c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f17360d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f17361e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f17362f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f17363g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f17364h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f17365i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f17366j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f17367k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f17368l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f17369m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f17370n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f17371o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final int f17372p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final int f17373q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final int f17374r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final int f17375s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final int f17376t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final int f17377u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final int f17378v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final int f17379w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final int f17380x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final int f17381y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final int f17382z;

        public static final class a {
            public int A;
            public int B;
            public int C;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f17383a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f17384b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f17385c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f17386d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f17387e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public int f17388f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f17389g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public int f17390h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public int f17391i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f17392j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public int f17393k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public int f17394l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public int f17395m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public int f17396n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public int f17397o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public int f17398p;

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            public int f17399q;

            /* JADX INFO: renamed from: r, reason: collision with root package name */
            public int f17400r;

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            public int f17401s;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            public int f17402t;

            /* JADX INFO: renamed from: u, reason: collision with root package name */
            public int f17403u;

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public int f17404v;

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public int f17405w;

            /* JADX INFO: renamed from: x, reason: collision with root package name */
            public int f17406x;

            /* JADX INFO: renamed from: y, reason: collision with root package name */
            public int f17407y;

            /* JADX INFO: renamed from: z, reason: collision with root package name */
            public int f17408z;

            public a A(int i10) {
                this.f17408z = i10;
                return this;
            }

            public a B(int i10) {
                this.f17389g = i10;
                return this;
            }

            public a C(int i10) {
                this.f17383a = i10;
                return this;
            }

            public a D(int i10) {
                this.f17395m = i10;
                return this;
            }

            public m a() {
                return new m(this.f17383a, this.f17384b, this.f17385c, this.f17386d, this.f17387e, this.f17388f, this.f17389g, this.f17390h, this.f17391i, this.f17392j, this.f17393k, this.f17394l, this.f17395m, this.f17396n, this.f17397o, this.f17398p, this.f17399q, this.f17400r, this.f17401s, this.f17402t, this.f17403u, this.f17404v, this.f17405w, this.f17406x, this.f17407y, this.f17408z, this.A, this.B, this.C);
            }

            public a b(int i10) {
                this.B = i10;
                return this;
            }

            public a c(int i10) {
                this.f17392j = i10;
                return this;
            }

            public a d(int i10) {
                this.f17387e = i10;
                return this;
            }

            public a e(int i10) {
                this.f17384b = i10;
                return this;
            }

            public a f(int i10) {
                this.f17399q = i10;
                return this;
            }

            public a g(int i10) {
                this.f17403u = i10;
                return this;
            }

            public a h(int i10) {
                this.f17401s = i10;
                return this;
            }

            public a i(int i10) {
                this.f17402t = i10;
                return this;
            }

            public a j(int i10) {
                this.f17400r = i10;
                return this;
            }

            public a k(int i10) {
                this.f17397o = i10;
                return this;
            }

            public a l(int i10) {
                this.f17388f = i10;
                return this;
            }

            public a m(int i10) {
                this.f17404v = i10;
                return this;
            }

            public a n(int i10) {
                this.f17386d = i10;
                return this;
            }

            public a o(int i10) {
                this.f17394l = i10;
                return this;
            }

            public a p(int i10) {
                this.f17405w = i10;
                return this;
            }

            public a q(int i10) {
                this.f17390h = i10;
                return this;
            }

            public a r(int i10) {
                this.C = i10;
                return this;
            }

            public a s(int i10) {
                this.f17398p = i10;
                return this;
            }

            public a t(int i10) {
                this.f17385c = i10;
                return this;
            }

            public a u(int i10) {
                this.f17391i = i10;
                return this;
            }

            public a v(int i10) {
                this.f17406x = i10;
                return this;
            }

            public a w(int i10) {
                this.f17407y = i10;
                return this;
            }

            public a x(int i10) {
                this.f17396n = i10;
                return this;
            }

            public a y(int i10) {
                this.A = i10;
                return this;
            }

            public a z(int i10) {
                this.f17393k = i10;
                return this;
            }
        }

        public m(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33, int i34, int i35, int i36, int i37, int i38) {
            this.f17357a = i10;
            this.f17358b = i11;
            this.f17359c = i12;
            this.f17360d = i13;
            this.f17361e = i14;
            this.f17362f = i15;
            this.f17363g = i16;
            this.f17364h = i17;
            this.f17365i = i18;
            this.f17366j = i19;
            this.f17367k = i20;
            this.f17368l = i21;
            this.f17369m = i22;
            this.f17370n = i23;
            this.f17371o = i24;
            this.f17372p = i25;
            this.f17373q = i26;
            this.f17374r = i27;
            this.f17375s = i28;
            this.f17376t = i29;
            this.f17377u = i30;
            this.f17378v = i31;
            this.f17379w = i32;
            this.f17380x = i33;
            this.f17381y = i34;
            this.f17382z = i35;
            this.A = i36;
            this.B = i37;
            this.C = i38;
        }
    }

    @hm.b
    public static final class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f17412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f17413b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f17414c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f17415d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f17416e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f17417f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f17418g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f17419h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f17420i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f17421j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final long f17422k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final long f17423l;

        public o(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21) {
            this.f17412a = j10;
            this.f17413b = j11;
            this.f17414c = j12;
            this.f17415d = j13;
            this.f17416e = j14;
            this.f17417f = j15;
            this.f17418g = j16;
            this.f17419h = j17;
            this.f17420i = j18;
            this.f17421j = j19;
            this.f17422k = j20;
            this.f17423l = j21;
        }
    }

    @b1.e
    public v0() {
    }

    public static <T extends a1<?>> void b(Map<Long, T> map, T t10) {
        map.put(Long.valueOf(t10.e().f17063c), t10);
    }

    public static <T extends a1<?>> boolean i(Map<Long, T> map, c1 c1Var) {
        return map.containsKey(Long.valueOf(c1Var.f17063c));
    }

    public static long v(m1 m1Var) {
        return m1Var.e().f17063c;
    }

    public static v0 w() {
        return f17282g;
    }

    public static <T extends a1<?>> void x(Map<Long, T> map, T t10) {
        map.remove(Long.valueOf(t10.e().f17063c));
    }

    public void A(a1<b> a1Var) {
        x(this.f17285b, a1Var);
    }

    public void B(a1<j> a1Var) {
        x(this.f17284a, a1Var);
        this.f17288e.remove(Long.valueOf(a1Var.e().f17063c));
    }

    public void C(a1<j> a1Var, a1<l> a1Var2) {
        x(this.f17288e.get(Long.valueOf(a1Var.e().f17063c)), a1Var2);
    }

    public void D(a1<b> a1Var) {
        x(this.f17286c, a1Var);
    }

    public void c(a1<l> a1Var) {
        b(this.f17287d, a1Var);
    }

    public void d(a1<l> a1Var) {
        b(this.f17287d, a1Var);
    }

    public void e(a1<b> a1Var) {
        b(this.f17285b, a1Var);
    }

    public void f(a1<j> a1Var) {
        this.f17288e.put(Long.valueOf(a1Var.e().f17063c), new h(null));
        b(this.f17284a, a1Var);
    }

    public void g(a1<j> a1Var, a1<l> a1Var2) {
        b(this.f17288e.get(Long.valueOf(a1Var.e().f17063c)), a1Var2);
    }

    public void h(a1<b> a1Var) {
        b(this.f17286c, a1Var);
    }

    @b1.e
    public boolean j(c1 c1Var) {
        return i(this.f17287d, c1Var);
    }

    @b1.e
    public boolean k(c1 c1Var) {
        return i(this.f17284a, c1Var);
    }

    @b1.e
    public boolean l(c1 c1Var) {
        return i(this.f17286c, c1Var);
    }

    @gm.j
    public a1<b> m(long j10) {
        return this.f17285b.get(Long.valueOf(j10));
    }

    public a1<b> n(long j10) {
        return this.f17285b.get(Long.valueOf(j10));
    }

    public e o(long j10, int i10) {
        ArrayList arrayList = new ArrayList();
        Iterator<a1<b>> it = this.f17285b.tailMap(Long.valueOf(j10)).values().iterator();
        while (it.hasNext() && arrayList.size() < i10) {
            arrayList.add(it.next());
        }
        return new e(arrayList, !it.hasNext());
    }

    @gm.j
    public a1<j> p(long j10) {
        return this.f17284a.get(Long.valueOf(j10));
    }

    public final a1<l> q(long j10) {
        Iterator<h> it = this.f17288e.values().iterator();
        while (it.hasNext()) {
            a1<l> a1Var = it.next().get(Long.valueOf(j10));
            if (a1Var != null) {
                return a1Var;
            }
        }
        return null;
    }

    @gm.j
    public i r(long j10, long j11, int i10) {
        h hVar = this.f17288e.get(Long.valueOf(j10));
        if (hVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(i10);
        Iterator<a1<l>> it = hVar.tailMap(Long.valueOf(j11)).values().iterator();
        while (arrayList.size() < i10 && it.hasNext()) {
            arrayList.add(it.next());
        }
        return new i(arrayList, !it.hasNext());
    }

    public g s(long j10, int i10) {
        ArrayList arrayList = new ArrayList(i10);
        Iterator<a1<j>> it = this.f17284a.tailMap(Long.valueOf(j10)).values().iterator();
        while (it.hasNext() && arrayList.size() < i10) {
            arrayList.add(it.next());
        }
        return new g(arrayList, !it.hasNext());
    }

    @gm.j
    public a1<l> t(long j10) {
        a1<l> a1Var = this.f17287d.get(Long.valueOf(j10));
        return a1Var != null ? a1Var : q(j10);
    }

    @gm.j
    public a1<b> u(long j10) {
        return this.f17286c.get(Long.valueOf(j10));
    }

    public void y(a1<l> a1Var) {
        x(this.f17287d, a1Var);
    }

    public void z(a1<l> a1Var) {
        x(this.f17287d, a1Var);
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @gm.j
        public final n f17328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.j
        public final d f17329b;

        public f(n nVar) {
            nVar.getClass();
            this.f17328a = nVar;
            this.f17329b = null;
        }

        public f(d dVar) {
            this.f17328a = null;
            dVar.getClass();
            this.f17329b = dVar;
        }
    }

    @hm.b
    public static final class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f17409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.j
        public final Certificate f17410b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.j
        public final Certificate f17411c;

        public n(String str, Certificate certificate, Certificate certificate2) {
            this.f17409a = str;
            this.f17410b = certificate;
            this.f17411c = certificate2;
        }

        public n(SSLSession sSLSession) {
            String cipherSuite = sSLSession.getCipherSuite();
            Certificate[] localCertificates = sSLSession.getLocalCertificates();
            Certificate certificate = null;
            Certificate certificate2 = localCertificates != null ? localCertificates[0] : null;
            try {
                Certificate[] peerCertificates = sSLSession.getPeerCertificates();
                if (peerCertificates != null) {
                    certificate = peerCertificates[0];
                }
            } catch (SSLPeerUnverifiedException e10) {
                v0.f17281f.log(Level.FINE, String.format("Peer cert not available for peerHost=%s", sSLSession.getPeerHost()), (Throwable) e10);
            }
            this.f17409a = cipherSuite;
            this.f17410b = certificate2;
            this.f17411c = certificate;
        }
    }
}
