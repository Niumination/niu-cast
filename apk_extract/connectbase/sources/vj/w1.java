package vj;

import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes2.dex */
@hm.b
public final class w1<ReqT, RespT> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ boolean f17479k = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f17480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @gm.j
    public final String f17482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c<ReqT> f17483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c<RespT> f17484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @gm.j
    public final Object f17485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f17486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f17487h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f17488i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicReferenceArray<Object> f17489j;

    public static final class b<ReqT, RespT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c<ReqT> f17490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c<RespT> f17491b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f17492c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f17493d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f17494e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f17495f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Object f17496g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f17497h;

        public b() {
        }

        @gm.c
        public w1<ReqT, RespT> a() {
            return new w1<>(this.f17492c, this.f17493d, this.f17490a, this.f17491b, this.f17496g, this.f17494e, this.f17495f, this.f17497h);
        }

        public b<ReqT, RespT> b(String str) {
            this.f17493d = str;
            return this;
        }

        public b<ReqT, RespT> c(boolean z10) {
            this.f17494e = z10;
            if (!z10) {
                this.f17495f = false;
            }
            return this;
        }

        public b<ReqT, RespT> d(c<ReqT> cVar) {
            this.f17490a = cVar;
            return this;
        }

        public b<ReqT, RespT> e(c<RespT> cVar) {
            this.f17491b = cVar;
            return this;
        }

        public b<ReqT, RespT> f(boolean z10) {
            this.f17495f = z10;
            if (z10) {
                this.f17494e = true;
            }
            return this;
        }

        public b<ReqT, RespT> g(boolean z10) {
            this.f17497h = z10;
            return this;
        }

        public b<ReqT, RespT> h(@gm.j Object obj) {
            this.f17496g = obj;
            return this;
        }

        public b<ReqT, RespT> i(d dVar) {
            this.f17492c = dVar;
            return this;
        }

        public b(a aVar) {
        }
    }

    public interface c<T> {
        InputStream a(T t10);

        T c(InputStream inputStream);
    }

    public enum d {
        UNARY,
        CLIENT_STREAMING,
        SERVER_STREAMING,
        BIDI_STREAMING,
        UNKNOWN;

        public final boolean clientSendsOneMessage() {
            return this == UNARY || this == SERVER_STREAMING;
        }

        public final boolean serverSendsOneMessage() {
            return this == UNARY || this == CLIENT_STREAMING;
        }
    }

    @e0("https://github.com/grpc/grpc-java/issues/2222")
    public interface e<T> extends f<T> {
        @gm.j
        T d();
    }

    @e0("https://github.com/grpc/grpc-java/issues/2222")
    public interface f<T> extends c<T> {
        Class<T> b();
    }

    @Deprecated
    public static <RequestT, ResponseT> w1<RequestT, ResponseT> a(d dVar, String str, c<RequestT> cVar, c<ResponseT> cVar2) {
        return new w1<>(dVar, str, cVar, cVar2, null, false, false, false);
    }

    @gm.j
    @e0("https://github.com/grpc/grpc-java/issues/5635")
    public static String b(String str) {
        int iLastIndexOf = ((String) c1.h0.F(str, "fullMethodName")).lastIndexOf(47);
        if (iLastIndexOf == -1) {
            return null;
        }
        return str.substring(iLastIndexOf + 1);
    }

    @gm.j
    public static String c(String str) {
        int iLastIndexOf = ((String) c1.h0.F(str, "fullMethodName")).lastIndexOf(47);
        if (iLastIndexOf == -1) {
            return null;
        }
        return str.substring(0, iLastIndexOf);
    }

    public static String d(String str, String str2) {
        return ((String) c1.h0.F(str, "fullServiceName")) + "/" + ((String) c1.h0.F(str2, "methodName"));
    }

    @gm.c
    public static <ReqT, RespT> b<ReqT, RespT> p() {
        return q(null, null);
    }

    @gm.c
    public static <ReqT, RespT> b<ReqT, RespT> q(c<ReqT> cVar, c<RespT> cVar2) {
        b<ReqT, RespT> bVar = new b<>();
        bVar.f17490a = cVar;
        bVar.f17491b = cVar2;
        return bVar;
    }

    @gm.j
    @e0("https://github.com/grpc/grpc-java/issues/5635")
    public String e() {
        return b(this.f17481b);
    }

    public String f() {
        return this.f17481b;
    }

    public final Object g(int i10) {
        return this.f17489j.get(i10);
    }

    public c<ReqT> h() {
        return this.f17483d;
    }

    public c<RespT> i() {
        return this.f17484e;
    }

    @gm.j
    public Object j() {
        return this.f17485f;
    }

    @gm.j
    @e0("https://github.com/grpc/grpc-java/issues/5635")
    public String k() {
        return this.f17482c;
    }

    public d l() {
        return this.f17480a;
    }

    public boolean m() {
        return this.f17486g;
    }

    public boolean n() {
        return this.f17487h;
    }

    public boolean o() {
        return this.f17488i;
    }

    public ReqT r(InputStream inputStream) {
        return this.f17483d.c(inputStream);
    }

    public RespT s(InputStream inputStream) {
        return this.f17484e.c(inputStream);
    }

    public final void t(int i10, Object obj) {
        this.f17489j.lazySet(i10, obj);
    }

    public String toString() {
        c1.z.b bVarJ = c1.z.c(this).j("fullMethodName", this.f17481b).j(ik.y0.a.f8215h, this.f17480a).g("idempotent", this.f17486g).g("safe", this.f17487h).g("sampledToLocalTracing", this.f17488i).j("requestMarshaller", this.f17483d).j("responseMarshaller", this.f17484e).j("schemaDescriptor", this.f17485f);
        bVarJ.f1267d = true;
        return bVarJ.toString();
    }

    public InputStream u(ReqT reqt) {
        return this.f17483d.a(reqt);
    }

    public InputStream v(RespT respt) {
        return this.f17484e.a(respt);
    }

    @gm.c
    public b<ReqT, RespT> w() {
        return (b<ReqT, RespT>) x(this.f17483d, this.f17484e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @gm.c
    public <NewReqT, NewRespT> b<NewReqT, NewRespT> x(c<NewReqT> cVar, c<NewRespT> cVar2) {
        b bVarQ = q(null, null);
        bVarQ.f17490a = cVar;
        bVarQ.f17491b = cVar2;
        bVarQ.f17492c = this.f17480a;
        bVarQ.f17493d = this.f17481b;
        b<ReqT, RespT> bVarF = bVarQ.c(this.f17486g).f(this.f17487h);
        bVarF.f17497h = this.f17488i;
        bVarF.f17496g = this.f17485f;
        return bVarF;
    }

    public w1(d dVar, String str, c<ReqT> cVar, c<RespT> cVar2, Object obj, boolean z10, boolean z11, boolean z12) {
        this.f17489j = new AtomicReferenceArray<>(2);
        this.f17480a = (d) c1.h0.F(dVar, ik.y0.a.f8215h);
        this.f17481b = (String) c1.h0.F(str, "fullMethodName");
        this.f17482c = c(str);
        this.f17483d = (c) c1.h0.F(cVar, "requestMarshaller");
        this.f17484e = (c) c1.h0.F(cVar2, "responseMarshaller");
        this.f17485f = obj;
        this.f17486g = z10;
        this.f17487h = z11;
        this.f17488i = z12;
    }
}
