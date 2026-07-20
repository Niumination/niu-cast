package c4;

import androidx.core.app.NotificationCompat;
import com.transsion.connectx.mirror.source.pad.FloatingWindow;
import ik.j0;
import ik.r0;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import jn.p;
import jn.q;
import jq.d0;
import jq.e0;
import jq.h0;
import kn.k1;
import kn.l0;
import kn.l1;
import kn.n0;
import kn.r1;
import kn.w;
import lm.d1;
import lm.l2;
import nm.x;
import nq.k;
import nq.s0;
import os.l;
import os.m;
import wk.z;
import xm.o;
import yk.f0;
import yk.u;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nAlbumThumbServer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AlbumThumbServer.kt\ncom/transsion/backup/album/AlbumThumbServer\n+ 2 ApplicationResponseFunctions.kt\nio/ktor/response/ApplicationResponseFunctionsKt\n*L\n1#1,152:1\n23#2,9:153\n*S KotlinDebug\n*F\n+ 1 AlbumThumbServer.kt\ncom/transsion/backup/album/AlbumThumbServer\n*L\n122#1:153,9\n*E\n"})
public final class e implements s0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public static final a f1358d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public static final String f1359e = "AlbumThumbServer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final c4.d f1360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s0 f1361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m
    public al.l f1362c;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    @r1({"SMAP\nAlbumThumbServer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AlbumThumbServer.kt\ncom/transsion/backup/album/AlbumThumbServer$createMediaApi$1\n+ 2 ApplicationCallPipeline.kt\nio/ktor/application/ApplicationCallPipelineKt\n+ 3 ApplicationResponseFunctions.kt\nio/ktor/response/ApplicationResponseFunctionsKt\n*L\n1#1,152:1\n68#2:153\n68#2:154\n68#2:164\n68#2:174\n68#2:175\n68#2:176\n23#3,9:155\n23#3,9:165\n*S KotlinDebug\n*F\n+ 1 AlbumThumbServer.kt\ncom/transsion/backup/album/AlbumThumbServer$createMediaApi$1\n*L\n56#1:153\n59#1:154\n64#1:164\n72#1:174\n76#1:175\n83#1:176\n59#1:155,9\n64#1:165,9\n*E\n"})
    @xm.f(c = "com.transsion.backup.album.AlbumThumbServer$createMediaApi$1", f = "AlbumThumbServer.kt", i = {}, l = {162, 172, 75, 83}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends o implements q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public b(um.d<? super b> dVar) {
            super(3, dVar);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
            Closeable closeable;
            Closeable closeable2;
            Throwable th2;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    d1.n(obj);
                    return l2.f10208a;
                }
                if (i10 == 2) {
                    d1.n(obj);
                    return l2.f10208a;
                }
                if (i10 != 3 && i10 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                closeable = (Closeable) this.L$0;
                try {
                    d1.n(obj);
                    closeable = closeable;
                    l2 l2Var = l2.f10208a;
                    dn.c.a(closeable, null);
                    return l2Var;
                } catch (Throwable th3) {
                    th = th3;
                    closeable2 = closeable;
                    th2 = th;
                    try {
                        throw th2;
                    } catch (Throwable th4) {
                        dn.c.a(closeable2, th2);
                        throw th4;
                    }
                }
            }
            d1.n(obj);
            nl.f fVar = (nl.f) this.L$0;
            String str = ((dk.b) fVar.getContext()).getParameters().get(dc.d.f3692w);
            Long lZ0 = str != null ? d0.Z0(str) : null;
            k4.m.e(e.f1359e, "get media id: " + lZ0);
            if (lZ0 == null) {
                dk.b bVar = (dk.b) fVar.getContext();
                r0.f8158c.getClass();
                r0 r0Var = r0.B;
                if (!(r0Var instanceof byte[])) {
                    try {
                        vk.i.b(bVar.e(), l1.A(r0.class));
                    } catch (Throwable unused) {
                    }
                }
                vk.d dVarC = bVar.e().c();
                this.label = 1;
                if (dVarC.g(bVar, r0Var, this) == aVar) {
                    return aVar;
                }
                return l2.f10208a;
            }
            String strA = e.this.f1360a.a(lZ0.longValue());
            if (strA == null) {
                dk.b bVar2 = (dk.b) fVar.getContext();
                r0.f8158c.getClass();
                r0 r0Var2 = r0.B;
                if (!(r0Var2 instanceof byte[])) {
                    try {
                        vk.i.b(bVar2.e(), l1.A(r0.class));
                    } catch (Throwable unused2) {
                    }
                }
                vk.d dVarC2 = bVar2.e().c();
                this.label = 2;
                if (dVarC2.g(bVar2, r0Var2, this) == aVar) {
                    return aVar;
                }
                return l2.f10208a;
            }
            ik.i iVarB = ik.i.f7981f.b(strA);
            k4.m.e(e.f1359e, "get media type: " + iVarB);
            boolean zS2 = e0.s2(strA, "video/", false, 2, null);
            InputStream inputStreamF = e.this.f1360a.f(lZ0.longValue());
            e eVar = e.this;
            try {
                long jAvailable = inputStreamF.available();
                uk.d dVarD = ((dk.b) fVar.getContext()).d();
                j0.f8048a.getClass();
                String strQ = uk.e.q(dVarD, j0.f8061g0);
                k4.m.e(e.f1359e, "get media isVideo: " + zS2 + " rangeHeader: " + strQ);
                if (!zS2 || strQ == null) {
                    dk.b bVar3 = (dk.b) fVar.getContext();
                    this.L$0 = inputStreamF;
                    this.label = 4;
                    if (eVar.o(bVar3, inputStreamF, iVarB, this) == aVar) {
                        return aVar;
                    }
                } else {
                    dk.b bVar4 = (dk.b) fVar.getContext();
                    this.L$0 = inputStreamF;
                    this.label = 3;
                    if (eVar.p(bVar4, inputStreamF, jAvailable, strQ, iVarB, this) == aVar) {
                        return aVar;
                    }
                }
                closeable = inputStreamF;
                l2 l2Var2 = l2.f10208a;
                dn.c.a(closeable, null);
                return l2Var2;
            } catch (Throwable th5) {
                th = th5;
                closeable2 = inputStreamF;
                th2 = th;
                throw th2;
            }
        }

        @Override // jn.q
        @m
        public final Object invoke(@l nl.f<l2, dk.b> fVar, @l l2 l2Var, @m um.d<? super l2> dVar) {
            b bVar = e.this.new b(dVar);
            bVar.L$0 = fVar;
            return bVar.invokeSuspend(l2.f10208a);
        }
    }

    @r1({"SMAP\nAlbumThumbServer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AlbumThumbServer.kt\ncom/transsion/backup/album/AlbumThumbServer$createThumbnailApi$1\n+ 2 ApplicationCallPipeline.kt\nio/ktor/application/ApplicationCallPipelineKt\n+ 3 ApplicationResponseFunctions.kt\nio/ktor/response/ApplicationResponseFunctionsKt\n*L\n1#1,152:1\n68#2:153\n68#2:154\n68#2:155\n68#2:165\n23#3,9:156\n23#3,9:166\n*S KotlinDebug\n*F\n+ 1 AlbumThumbServer.kt\ncom/transsion/backup/album/AlbumThumbServer$createThumbnailApi$1\n*L\n91#1:153\n95#1:154\n97#1:155\n99#1:165\n97#1:156,9\n99#1:166,9\n*E\n"})
    @xm.f(c = "com.transsion.backup.album.AlbumThumbServer$createThumbnailApi$1", f = "AlbumThumbServer.kt", i = {0, 1}, l = {da.b.f3634e, 163, 173}, m = "invokeSuspend", n = {"$this$get", "$this$get"}, s = {"L$0", "L$0"})
    public static final class c extends o implements q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public c(um.d<? super c> dVar) {
            super(3, dVar);
        }

        /* JADX WARN: Code duplicated, block: B:32:0x00aa  */
        /* JADX WARN: Code duplicated, block: B:37:0x00da A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:44:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            nl.f fVar;
            l2 l2Var;
            nl.f fVar2;
            dk.b bVar;
            r0 r0Var;
            vk.d dVarC;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1 || i10 == 2) {
                    fVar2 = (nl.f) this.L$0;
                    d1.n(obj);
                } else {
                    if (i10 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                return l2.f10208a;
            }
            d1.n(obj);
            fVar = (nl.f) this.L$0;
            String str = ((dk.b) fVar.getContext()).getParameters().get(dc.d.f3692w);
            Long lZ0 = str != null ? d0.Z0(str) : null;
            if (lZ0 != null) {
                byte[] bArrG = e.g(e.this, lZ0.longValue());
                if (bArrG != null) {
                    dk.b bVar2 = (dk.b) fVar.getContext();
                    this.L$0 = fVar;
                    this.label = 1;
                    if (vk.b.i(bVar2, bArrG, null, null, null, this, 14, null) == aVar) {
                        return aVar;
                    }
                } else {
                    dk.b bVar3 = (dk.b) fVar.getContext();
                    r0.f8158c.getClass();
                    r0 r0Var2 = r0.B;
                    if (!(r0Var2 instanceof byte[])) {
                        try {
                            vk.i.b(bVar3.e(), l1.A(r0.class));
                        } catch (Throwable unused) {
                        }
                    }
                    vk.d dVarC2 = bVar3.e().c();
                    this.L$0 = fVar;
                    this.label = 2;
                    if (dVarC2.g(bVar3, r0Var2, this) == aVar) {
                        return aVar;
                    }
                }
                fVar2 = fVar;
            } else {
                l2Var = null;
            }
            if (l2Var == null) {
                bVar = (dk.b) fVar.getContext();
                r0.f8158c.getClass();
                r0Var = r0.f8182x;
                if (!(r0Var instanceof byte[])) {
                    try {
                        vk.i.b(bVar.e(), l1.A(r0.class));
                    } catch (Throwable unused2) {
                    }
                }
                dVarC = bVar.e().c();
                this.L$0 = null;
                this.label = 3;
                if (dVarC.g(bVar, r0Var, this) == aVar) {
                    return aVar;
                }
            }
            return l2.f10208a;
            fVar = fVar2;
            l2Var = l2.f10208a;
            if (l2Var == null) {
                bVar = (dk.b) fVar.getContext();
                r0.f8158c.getClass();
                r0Var = r0.f8182x;
                if (!(r0Var instanceof byte[])) {
                    vk.i.b(bVar.e(), l1.A(r0.class));
                }
                dVarC = bVar.e().c();
                this.L$0 = null;
                this.label = 3;
                if (dVarC.g(bVar, r0Var, this) == aVar) {
                    return aVar;
                }
            }
            return l2.f10208a;
        }

        @Override // jn.q
        @m
        public final Object invoke(@l nl.f<l2, dk.b> fVar, @l l2 l2Var, @m um.d<? super l2> dVar) {
            c cVar = e.this.new c(dVar);
            cVar.L$0 = fVar;
            return cVar.invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "com.transsion.backup.album.AlbumThumbServer$handleFullRequest$2", f = "AlbumThumbServer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends o implements p<OutputStream, um.d<? super l2>, Object> {
        final /* synthetic */ InputStream $fileStream;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(InputStream inputStream, um.d<? super d> dVar) {
            super(2, dVar);
            this.$fileStream = inputStream;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            d dVar2 = new d(this.$fileStream, dVar);
            dVar2.L$0 = obj;
            return dVar2;
        }

        @Override // jn.p
        @m
        public final Object invoke(@l OutputStream outputStream, @m um.d<? super l2> dVar) {
            return ((d) create(outputStream, dVar)).invokeSuspend(l2.f10208a);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) throws IOException {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            dn.b.k(this.$fileStream, (OutputStream) this.L$0, 8192);
            return l2.f10208a;
        }
    }

    /* JADX INFO: renamed from: c4.e$e, reason: collision with other inner class name */
    @xm.f(c = "com.transsion.backup.album.AlbumThumbServer", f = "AlbumThumbServer.kt", i = {1, 1, 1, 1, 1, 1}, l = {160, 125, 131}, m = "handleRangeRequest", n = {NotificationCompat.CATEGORY_CALL, "fileStream", "contentType", "fileLength", FloatingWindow.f2048b0, FloatingWindow.f2049c0}, s = {"L$0", "L$1", "L$2", "J$0", "J$1", "J$2"})
    public static final class C0059e extends xm.d {
        long J$0;
        long J$1;
        long J$2;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C0059e(um.d<? super C0059e> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return e.this.p(null, null, 0L, null, null, this);
        }
    }

    @xm.f(c = "com.transsion.backup.album.AlbumThumbServer$handleRangeRequest$2", f = "AlbumThumbServer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends o implements p<s0, um.d<? super Long>, Object> {
        final /* synthetic */ InputStream $fileStream;
        final /* synthetic */ long $start;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(InputStream inputStream, long j10, um.d<? super f> dVar) {
            super(2, dVar);
            this.$fileStream = inputStream;
            this.$start = j10;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            return new f(this.$fileStream, this.$start, dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            return new Long(this.$fileStream.skip(this.$start));
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m um.d<? super Long> dVar) {
            return ((f) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @r1({"SMAP\nAlbumThumbServer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AlbumThumbServer.kt\ncom/transsion/backup/album/AlbumThumbServer$handleRangeRequest$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,152:1\n1#2:153\n*E\n"})
    @xm.f(c = "com.transsion.backup.album.AlbumThumbServer$handleRangeRequest$3", f = "AlbumThumbServer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends o implements p<OutputStream, um.d<? super l2>, Object> {
        final /* synthetic */ InputStream $fileStream;
        final /* synthetic */ long $length;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(long j10, InputStream inputStream, um.d<? super g> dVar) {
            super(2, dVar);
            this.$length = j10;
            this.$fileStream = inputStream;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            g gVar = new g(this.$length, this.$fileStream, dVar);
            gVar.L$0 = obj;
            return gVar;
        }

        @Override // jn.p
        @m
        public final Object invoke(@l OutputStream outputStream, @m um.d<? super l2> dVar) {
            return ((g) create(outputStream, dVar)).invokeSuspend(l2.f10208a);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) throws IOException {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            OutputStream outputStream = (OutputStream) this.L$0;
            byte[] bArr = new byte[8192];
            k1.f fVar = new k1.f();
            for (long j10 = this.$length; j10 > 0; j10 -= (long) fVar.element) {
                int i10 = this.$fileStream.read(bArr);
                fVar.element = i10;
                if (i10 == -1) {
                    break;
                }
                outputStream.write(bArr, 0, i10);
            }
            outputStream.flush();
            return l2.f10208a;
        }
    }

    public static final class h extends n0 implements jn.l<z, l2> {
        public h() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(z zVar) {
            invoke2(zVar);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@l z zVar) {
            l0.p(zVar, "$this$routing");
            e.this.m(zVar);
            e.this.l(zVar);
        }
    }

    public static final class i extends n0 implements jn.l<dk.a, l2> {
        public i() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(dk.a aVar) {
            invoke2(aVar);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@l dk.a aVar) {
            l0.p(aVar, "$this$embeddedServer");
            e.this.r(aVar);
        }
    }

    @xm.f(c = "com.transsion.backup.album.AlbumThumbServer$stop$1", f = "AlbumThumbServer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class j extends o implements p<s0, um.d<? super l2>, Object> {
        int label;

        public j(um.d<? super j> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            return e.this.new j(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) throws Throwable {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            al.l lVar = e.this.f1362c;
            if (lVar != null) {
                lVar.d(2000L, 5000L);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m um.d<? super l2> dVar) {
            return ((j) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public e(@l c4.d dVar) {
        l0.p(dVar, "albumManager");
        this.f1360a = dVar;
        this.f1361b = s2.d.a();
    }

    public static final byte[] g(e eVar, long j10) {
        return eVar.f1360a.b(j10);
    }

    @Override // nq.s0
    @l
    public um.g getCoroutineContext() {
        return this.f1361b.getCoroutineContext();
    }

    public final void l(z zVar) {
        wk.d0.f(zVar, "/media/{id}", new b(null));
    }

    public final void m(z zVar) {
        wk.d0.f(zVar, "/thumbnail/{id}", new c(null));
    }

    public final byte[] n(long j10) {
        return this.f1360a.b(j10);
    }

    public final Object o(dk.b bVar, InputStream inputStream, ik.i iVar, um.d<? super l2> dVar) {
        Object objQ = vk.b.q(bVar, iVar, null, new d(inputStream, null), dVar, 2, null);
        return objQ == wm.a.COROUTINE_SUSPENDED ? objQ : l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0148 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public final Object p(dk.b bVar, InputStream inputStream, long j10, String str, ik.i iVar, um.d<? super l2> dVar) {
        C0059e c0059e;
        InputStream inputStream2;
        ik.i iVar2;
        dk.b bVar2;
        long j11;
        long j12;
        long j13;
        g gVar;
        if (dVar instanceof C0059e) {
            c0059e = (C0059e) dVar;
            int i10 = c0059e.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c0059e.label = i10 - Integer.MIN_VALUE;
            } else {
                c0059e = new C0059e(dVar);
            }
        } else {
            c0059e = new C0059e(dVar);
        }
        Object obj = c0059e.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = c0059e.label;
        if (i11 == 0) {
            d1.n(obj);
            List listR4 = h0.R4(h0.a4(str, "bytes="), new String[]{"-"}, false, 0, 6, null);
            Long lZ0 = d0.Z0((String) listR4.get(0));
            long jLongValue = lZ0 != null ? lZ0.longValue() : 0L;
            Long lZ1 = d0.Z0((String) listR4.get(1));
            long jLongValue2 = lZ1 != null ? lZ1.longValue() : j10 - 1;
            long j14 = jLongValue;
            if (j14 < 0 || jLongValue2 >= j10 || j14 > jLongValue2) {
                r0.f8158c.getClass();
                r0 r0Var = r0.N;
                if (!(r0Var instanceof byte[])) {
                    try {
                        vk.i.b(bVar.e(), l1.A(r0.class));
                    } catch (Throwable unused) {
                    }
                }
                vk.d dVarC = bVar.e().c();
                c0059e.label = 1;
                if (dVarC.g(bVar, r0Var, c0059e) == aVar) {
                    return aVar;
                }
                return l2.f10208a;
            }
            nq.n0 n0VarC = nq.k1.c();
            f fVar = new f(inputStream, j14, null);
            c0059e.L$0 = bVar;
            c0059e.L$1 = inputStream;
            c0059e.L$2 = iVar;
            c0059e.J$0 = j10;
            c0059e.J$1 = j14;
            c0059e.J$2 = jLongValue2;
            c0059e.label = 2;
            if (k.g(n0VarC, fVar, c0059e) == aVar) {
                return aVar;
            }
            inputStream2 = inputStream;
            iVar2 = iVar;
            bVar2 = bVar;
            j11 = jLongValue2;
            j12 = j14;
            j13 = j10;
            long j15 = (j11 - j12) + 1;
            vk.a aVarE = bVar2.e();
            r0.f8158c.getClass();
            aVarE.a(r0.f8171m);
            vk.a aVarE2 = bVar2.e();
            j0.f8048a.getClass();
            String str2 = j0.f8084s;
            StringBuilder sbA = j.b.a("bytes ", j12, "-");
            sbA.append(j11);
            sbA.append("/");
            sbA.append(j13);
            vk.c.m(aVarE2, str2, sbA.toString());
            gVar = new g(j15, inputStream2, null);
            c0059e.L$0 = null;
            c0059e.L$1 = null;
            c0059e.L$2 = null;
            c0059e.label = 3;
            if (vk.b.q(bVar2, iVar2, null, gVar, c0059e, 2, null) == aVar) {
                return aVar;
            }
        } else {
            if (i11 == 1) {
                d1.n(obj);
                return l2.f10208a;
            }
            if (i11 == 2) {
                j11 = c0059e.J$2;
                j12 = c0059e.J$1;
                j13 = c0059e.J$0;
                iVar2 = (ik.i) c0059e.L$2;
                inputStream2 = (InputStream) c0059e.L$1;
                bVar2 = (dk.b) c0059e.L$0;
                d1.n(obj);
                long j16 = (j11 - j12) + 1;
                vk.a aVarE3 = bVar2.e();
                r0.f8158c.getClass();
                aVarE3.a(r0.f8171m);
                vk.a aVarE4 = bVar2.e();
                j0.f8048a.getClass();
                String str3 = j0.f8084s;
                StringBuilder sbA2 = j.b.a("bytes ", j12, "-");
                sbA2.append(j11);
                sbA2.append("/");
                sbA2.append(j13);
                vk.c.m(aVarE4, str3, sbA2.toString());
                gVar = new g(j16, inputStream2, null);
                c0059e.L$0 = null;
                c0059e.L$1 = null;
                c0059e.L$2 = null;
                c0059e.label = 3;
                if (vk.b.q(bVar2, iVar2, null, gVar, c0059e, 2, null) == aVar) {
                    return aVar;
                }
            } else {
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
        }
        return l2.f10208a;
    }

    public final void r(dk.a aVar) {
        wk.e0.b(aVar, new h());
    }

    public final boolean s(int i10) {
        try {
            this.f1362c = ((al.l) u.a(this, al.h.f338a, (60 & 2) != 0 ? 80 : i10, (60 & 4) != 0 ? "0.0.0.0" : null, (60 & 8) != 0 ? x.k(f0.a()) : null, (60 & 16) != 0 ? um.i.INSTANCE : null, (60 & 32) != 0 ? u.b.INSTANCE : null, new i())).b(false);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @l
    public final nq.l2 t() {
        return k.f(this, null, null, new j(null), 3, null);
    }
}
