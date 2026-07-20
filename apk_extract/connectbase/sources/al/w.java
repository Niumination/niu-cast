package al;

import androidx.constraintlayout.widget.ConstraintLayout;
import ik.a0;
import ik.b0;
import ik.c0;
import ik.j0;
import ik.y;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.codec.http.DefaultHttpContent;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http.multipart.Attribute;
import io.netty.handler.codec.http.multipart.FileUpload;
import io.netty.handler.codec.http.multipart.HttpPostMultipartRequestDecoder;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import kn.l0;
import kn.n0;
import lm.d1;
import lm.l2;
import tl.g0;
import tl.s0;
import tl.w0;

/* JADX INFO: loaded from: classes2.dex */
public final class w implements nk.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final HttpPostMultipartRequestDecoder f406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final ByteBufAllocator f407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final pl.k f408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final ArrayList<nk.u> f409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f410e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f411f;

    public static final class a extends n0 implements jn.a<g0> {
        final /* synthetic */ InterfaceHttpData $part;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceHttpData interfaceHttpData) {
            super(0);
            this.$part = interfaceHttpData;
        }

        @Override // jn.a
        @os.l
        public final g0 invoke() throws IOException {
            if (!((FileUpload) this.$part).isInMemory()) {
                File file = ((FileUpload) this.$part).getFile();
                l0.o(file, "part.file");
                return cm.b.b(new FileInputStream(file), null, 1, null);
            }
            InterfaceHttpData interfaceHttpData = this.$part;
            tl.s sVarA = w0.a(0);
            try {
                byte[] bArr = ((FileUpload) interfaceHttpData).get();
                l0.o(bArr, "part.get()");
                s0.r(sVarA, bArr, 0, 0, 6, null);
                return sVarA.z2();
            } catch (Throwable th2) {
                sVarA.close();
                throw th2;
            }
        }
    }

    public static final class b extends n0 implements jn.a<l2> {
        final /* synthetic */ InterfaceHttpData $part;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceHttpData interfaceHttpData) {
            super(0);
            this.$part = interfaceHttpData;
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            invoke2();
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((FileUpload) this.$part).delete();
        }
    }

    public static final class c extends n0 implements jn.a<l2> {
        final /* synthetic */ InterfaceHttpData $part;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(InterfaceHttpData interfaceHttpData) {
            super(0);
            this.$part = interfaceHttpData;
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            invoke2();
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((Attribute) this.$part).delete();
        }
    }

    @xm.f(c = "io.ktor.server.netty.NettyMultiPartData", f = "NettyMultiPartData.kt", i = {0, 0}, l = {82}, m = "doDecode", n = {"this", "buf"}, s = {"L$0", "L$1"})
    public static final class d extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public d(um.d<? super d> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return w.this.g(this);
        }
    }

    @xm.f(c = "io.ktor.server.netty.NettyMultiPartData", f = "NettyMultiPartData.kt", i = {0}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF, 54}, m = "readNextSuspend", n = {"this"}, s = {"L$0"})
    public static final class e extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public e(um.d<? super e> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return w.this.l(this);
        }
    }

    public w(@os.l HttpPostMultipartRequestDecoder httpPostMultipartRequestDecoder, @os.l ByteBufAllocator byteBufAllocator, @os.l pl.k kVar) {
        l0.p(httpPostMultipartRequestDecoder, "decoder");
        l0.p(byteBufAllocator, "alloc");
        l0.p(kVar, "channel");
        this.f406a = httpPostMultipartRequestDecoder;
        this.f407b = byteBufAllocator;
        this.f408c = kVar;
        this.f409d = new ArrayList<>();
    }

    @Override // nk.p
    @os.m
    public Object b(@os.l um.d<? super nk.u> dVar) throws IOException {
        while (!this.f410e && !this.f411f) {
            InterfaceHttpData interfaceHttpDataE = e();
            if (interfaceHttpDataE == null) {
                if (!this.f408c.p0()) {
                    return l(dVar);
                }
                this.f410e = true;
                return null;
            }
            nk.u uVarD = d(interfaceHttpDataE);
            if (uVarD != null) {
                this.f409d.add(uVarD);
                return uVarD;
            }
            interfaceHttpDataE.release();
        }
        return null;
    }

    public final nk.u d(InterfaceHttpData interfaceHttpData) throws IOException {
        if (interfaceHttpData instanceof FileUpload) {
            return new nk.u.b(new a(interfaceHttpData), new b(interfaceHttpData), k((FileUpload) interfaceHttpData));
        }
        if (!(interfaceHttpData instanceof Attribute)) {
            return null;
        }
        Attribute attribute = (Attribute) interfaceHttpData;
        String value = attribute.getValue();
        l0.o(value, "part.value");
        return new nk.u.c(value, new c(interfaceHttpData), j(attribute));
    }

    public final InterfaceHttpData e() {
        try {
            return this.f406a.next();
        } catch (HttpPostRequestDecoder.EndOfDataDecoderException unused) {
            return null;
        }
    }

    public final void f() {
        if (this.f411f) {
            return;
        }
        this.f411f = true;
        this.f406a.destroy();
        Iterator<T> it = this.f409d.iterator();
        while (it.hasNext()) {
            ((nk.u) it.next()).f11544a.invoke();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object g(um.d<? super Boolean> dVar) {
        d dVar2;
        w wVar;
        ByteBuf byteBuf;
        if (dVar instanceof d) {
            dVar2 = (d) dVar;
            int i10 = dVar2.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                dVar2.label = i10 - Integer.MIN_VALUE;
            } else {
                dVar2 = new d(dVar);
            }
        } else {
            dVar2 = new d(dVar);
        }
        Object objN0 = dVar2.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = dVar2.label;
        if (i11 == 0) {
            d1.n(objN0);
            pl.k kVar = this.f408c;
            if (kVar.p0()) {
                this.f406a.offer((HttpContent) LastHttpContent.EMPTY_LAST_CONTENT);
                return Boolean.FALSE;
            }
            ByteBuf byteBufBuffer = this.f407b.buffer(tn.u.I(kVar.d(), 256, 4096));
            ByteBuffer byteBufferNioBuffer = byteBufBuffer.nioBuffer(byteBufBuffer.writerIndex(), byteBufBuffer.writableBytes());
            l0.o(byteBufferNioBuffer, "bb");
            dVar2.L$0 = this;
            dVar2.L$1 = byteBufBuffer;
            dVar2.label = 1;
            objN0 = kVar.n0(byteBufferNioBuffer, dVar2);
            if (objN0 == aVar) {
                return aVar;
            }
            wVar = this;
            byteBuf = byteBufBuffer;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteBuf = (ByteBuf) dVar2.L$1;
            wVar = (w) dVar2.L$0;
            d1.n(objN0);
        }
        int iIntValue = ((Number) objN0).intValue();
        if (iIntValue == -1) {
            byteBuf.release();
            wVar.f406a.offer((HttpContent) LastHttpContent.EMPTY_LAST_CONTENT);
            return Boolean.FALSE;
        }
        byteBuf.writerIndex(iIntValue);
        wVar.f406a.offer((HttpContent) new DefaultHttpContent(byteBuf));
        byteBuf.release();
        return Boolean.TRUE;
    }

    @os.l
    public final ByteBufAllocator h() {
        return this.f407b;
    }

    public final boolean i() {
        try {
            return this.f406a.hasNext();
        } catch (HttpPostRequestDecoder.EndOfDataDecoderException unused) {
            return false;
        }
    }

    public final b0 j(Attribute attribute) {
        b0.a aVar = b0.f7939b;
        c0 c0Var = new c0(0, 1, null);
        j0 j0Var = j0.f8048a;
        j0Var.getClass();
        String str = j0.f8086t;
        ik.i.f.f8020a.getClass();
        a0.b(c0Var, str, ik.i.f.f8022c);
        j0Var.getClass();
        String str2 = j0.f8074n;
        ik.f.f7961d.getClass();
        ik.f fVar = ik.f.f7963f;
        String name = attribute.getName();
        l0.o(name, "name");
        c0Var.a(str2, fVar.j("name", name).toString());
        return c0Var.f();
    }

    public final b0 k(FileUpload fileUpload) {
        b0.a aVar = b0.f7939b;
        c0 c0Var = new c0(0, 1, null);
        if (fileUpload.getContentType() != null) {
            j0.f8048a.getClass();
            String str = j0.f8086t;
            String contentType = fileUpload.getContentType();
            l0.o(contentType, "contentType");
            c0Var.a(str, contentType);
        }
        if (fileUpload.getContentTransferEncoding() != null) {
            j0.f8048a.getClass();
            String str2 = j0.f8095x0;
            String contentTransferEncoding = fileUpload.getContentTransferEncoding();
            l0.o(contentTransferEncoding, "contentTransferEncoding");
            c0Var.a(str2, contentTransferEncoding);
        }
        if (fileUpload.getFilename() != null) {
            j0.f8048a.getClass();
            String str3 = j0.f8074n;
            ik.f.f7961d.getClass();
            ik.f fVar = ik.f.f7962e;
            String name = fileUpload.getName();
            l0.o(name, "name");
            y yVar = new y("name", name);
            String filename = fileUpload.getFilename();
            l0.o(filename, ik.f.b.f7967b);
            c0Var.a(str3, fVar.k(nm.y.O(yVar, new y(ik.f.b.f7967b, filename))).toString());
        }
        j0.f8048a.getClass();
        c0Var.a(j0.f8080q, String.valueOf(fileUpload.length()));
        return c0Var.f();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0047 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x0050  */
    /* JADX WARN: Code duplicated, block: B:26:0x0061 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0045 -> B:20:0x0048). Please report as a decompilation issue!!! */
    public final Object l(um.d<? super nk.u> dVar) throws IOException {
        e eVar;
        if (dVar instanceof e) {
            eVar = (e) dVar;
            int i10 = eVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                eVar.label = i10 - Integer.MIN_VALUE;
            } else {
                eVar = new e(dVar);
            }
        } else {
            eVar = new e(dVar);
        }
        Object objG = eVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = eVar.label;
        if (i11 == 0) {
            d1.n(objG);
            eVar.L$0 = this;
            eVar.label = 1;
            objG = this.g(eVar);
            if (objG == aVar) {
                return aVar;
            }
            if (((Boolean) objG).booleanValue()) {
            }
            eVar.L$0 = null;
            eVar.label = 2;
            objG = this.b(eVar);
            if (objG == aVar) {
                return aVar;
            }
        } else if (i11 == 1) {
            this = (w) eVar.L$0;
            d1.n(objG);
            if (((Boolean) objG).booleanValue() || this.i()) {
                eVar.L$0 = null;
                eVar.label = 2;
                objG = this.b(eVar);
                if (objG == aVar) {
                    return aVar;
                }
            }
            eVar.L$0 = this;
            eVar.label = 1;
            objG = this.g(eVar);
            if (objG == aVar) {
                return aVar;
            }
            if (((Boolean) objG).booleanValue()) {
            }
            eVar.L$0 = null;
            eVar.label = 2;
            objG = this.b(eVar);
            if (objG == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(objG);
        }
        return objG;
    }
}
