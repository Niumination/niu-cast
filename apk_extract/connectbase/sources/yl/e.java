package yl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.io.OutputStream;
import kn.l0;
import nq.l2;
import os.l;
import os.m;
import pl.n;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final n f21454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final a f21455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m
    public byte[] f21456c;

    public static final class a extends yl.a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ l2 f21457g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ e f21458h;

        /* JADX INFO: renamed from: yl.e$a$a, reason: collision with other inner class name */
        @xm.f(c = "io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1", f = "Blocking.kt", i = {0, 0, 1}, l = {TypedValues.AttributesType.TYPE_PATH_ROTATE, 99}, m = "loop", n = {"this", "this_$iv", "this"}, s = {"L$0", "L$1", "L$0"})
        public static final class C0550a extends xm.d {
            Object L$0;
            Object L$1;
            int label;
            /* synthetic */ Object result;

            public C0550a(um.d<? super C0550a> dVar) {
                super(dVar);
            }

            @Override // xm.a
            @m
            public final Object invokeSuspend(@l Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return a.this.i(this);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l2 l2Var, e eVar) {
            super(l2Var);
            this.f21457g = l2Var;
            this.f21458h = eVar;
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0059 A[Catch: all -> 0x002e, TryCatch #1 {all -> 0x002e, blocks: (B:13:0x002a, B:24:0x0049, B:26:0x0059, B:29:0x005f, B:39:0x0080, B:41:0x0084, B:44:0x0098, B:45:0x0099, B:47:0x009d, B:20:0x0041), top: B:65:0x0020 }] */
        /* JADX WARN: Code duplicated, block: B:28:0x005e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:39:0x0080 A[Catch: all -> 0x002e, TRY_ENTER, TryCatch #1 {all -> 0x002e, blocks: (B:13:0x002a, B:24:0x0049, B:26:0x0059, B:29:0x005f, B:39:0x0080, B:41:0x0084, B:44:0x0098, B:45:0x0099, B:47:0x009d, B:20:0x0041), top: B:65:0x0020 }] */
        /* JADX WARN: Code duplicated, block: B:41:0x0084 A[Catch: all -> 0x002e, TryCatch #1 {all -> 0x002e, blocks: (B:13:0x002a, B:24:0x0049, B:26:0x0059, B:29:0x005f, B:39:0x0080, B:41:0x0084, B:44:0x0098, B:45:0x0099, B:47:0x009d, B:20:0x0041), top: B:65:0x0020 }] */
        /* JADX WARN: Code duplicated, block: B:43:0x0097  */
        /* JADX WARN: Code duplicated, block: B:44:0x0098 A[Catch: all -> 0x002e, TryCatch #1 {all -> 0x002e, blocks: (B:13:0x002a, B:24:0x0049, B:26:0x0059, B:29:0x005f, B:39:0x0080, B:41:0x0084, B:44:0x0098, B:45:0x0099, B:47:0x009d, B:20:0x0041), top: B:65:0x0020 }] */
        /* JADX WARN: Code duplicated, block: B:45:0x0099 A[Catch: all -> 0x002e, TryCatch #1 {all -> 0x002e, blocks: (B:13:0x002a, B:24:0x0049, B:26:0x0059, B:29:0x005f, B:39:0x0080, B:41:0x0084, B:44:0x0098, B:45:0x0099, B:47:0x009d, B:20:0x0041), top: B:65:0x0020 }] */
        /* JADX WARN: Code duplicated, block: B:47:0x009d A[Catch: all -> 0x002e, TRY_LEAVE, TryCatch #1 {all -> 0x002e, blocks: (B:13:0x002a, B:24:0x0049, B:26:0x0059, B:29:0x005f, B:39:0x0080, B:41:0x0084, B:44:0x0098, B:45:0x0099, B:47:0x009d, B:20:0x0041), top: B:65:0x0020 }] */
        /* JADX WARN: Code duplicated, block: B:49:0x00b6 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0097 -> B:23:0x0048). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x009b -> B:23:0x0048). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00b4 -> B:23:0x0048). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // yl.a
        @os.m
        public java.lang.Object i(@os.l um.d<? super lm.l2> r9) {
            /*
                Method dump skipped, instruction units count: 225
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: yl.e.a.i(um.d):java.lang.Object");
        }
    }

    public e(@m l2 l2Var, @l n nVar) {
        l0.p(nVar, "channel");
        this.f21454a = nVar;
        b.d();
        this.f21455b = new a(l2Var, this);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            this.f21455b.o(b.f21445a);
            this.f21455b.n();
        } catch (Throwable th2) {
            throw new IOException(th2);
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() {
        this.f21455b.o(b.f21446b);
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i10) {
        try {
            byte[] bArr = this.f21456c;
            if (bArr == null) {
                bArr = new byte[1];
                this.f21456c = bArr;
            }
            bArr[0] = (byte) i10;
            this.f21455b.p(bArr, 0, 1);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(@m byte[] bArr, int i10, int i11) {
        a aVar = this.f21455b;
        l0.m(bArr);
        aVar.p(bArr, i10, i11);
    }
}
