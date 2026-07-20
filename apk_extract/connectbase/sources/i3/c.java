package i3;

import java.io.IOException;
import java.io.InputStream;
import kn.l0;
import kn.w;
import lm.d1;
import lm.l2;
import os.l;
import os.m;
import r2.g;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends f3.a<g> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public static final a f7701f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public static final String f7702g = "SocketDataReceiver";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final InputStream f7703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final byte[] f7704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public final g f7705e;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    @xm.f(c = "com.transsion.airtransfer.filetransfer.transmission.socket.SocketDataReceiver", f = "SocketDataReceiver.kt", i = {0, 0, 1, 1, 2, 2, 3}, l = {32, 37, 41, 46}, m = "read", n = {"this", "dataMessage", "this", "dataMessage", "this", "dataMessage", "this"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0"})
    public static final class b extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public b(um.d<? super b> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.this.b(this);
        }
    }

    public c(@l InputStream inputStream) {
        l0.p(inputStream, "inputStream");
        this.f7703c = inputStream;
        this.f7704d = new byte[1048576];
        this.f7705e = new g();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [i3.c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v1, types: [r2.g] */
    /* JADX WARN: Type inference failed for: r12v10, types: [i3.c] */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v5, types: [i3.c] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [i3.c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v10, types: [i3.c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v2, types: [i3.c] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    @Override // z2.a
    @m
    public Object b(@l um.d<? super g> dVar) {
        b bVar;
        ?? r12;
        ?? r10;
        g gVar;
        ?? r11;
        g gVar2;
        ?? r13;
        int i10;
        byte[] bArr;
        c cVar;
        if (dVar instanceof b) {
            bVar = (b) dVar;
            int i11 = bVar.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                bVar.label = i11 - Integer.MIN_VALUE;
            } else {
                bVar = new b(dVar);
            }
        } else {
            bVar = new b(dVar);
        }
        Object obj = bVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        ?? r14 = bVar.label;
        try {
            if (r14 != 0) {
                if (r14 != 1) {
                    if (r14 == 2) {
                        gVar2 = (g) bVar.L$1;
                        c cVar2 = (c) bVar.L$0;
                        d1.n(obj);
                        r13 = cVar2;
                    } else {
                        if (r14 != 3) {
                            if (r14 != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            c cVar3 = (c) bVar.L$0;
                            d1.n(obj);
                            r12 = cVar3;
                            r12.stop();
                            r10 = r12;
                            return r10.f7705e;
                        }
                        gVar2 = (g) bVar.L$1;
                        cVar = (c) bVar.L$0;
                    }
                    gVar = gVar2;
                    ?? r15 = r13;
                    r15.stop();
                    return r15.f7705e;
                }
                gVar2 = (g) bVar.L$1;
                cVar = (c) bVar.L$0;
                d1.n(obj);
                r11 = cVar;
            } else {
                d1.n(obj);
                gVar = new g();
                try {
                    u2.b bVar2 = u2.b.f16175b;
                    Integer num = new Integer(2);
                    bVar.L$0 = this;
                    bVar.L$1 = gVar;
                    bVar.label = 1;
                    if (bVar2.r(gVar, num, bVar) == aVar) {
                        return aVar;
                    }
                    r11 = this;
                    gVar2 = gVar;
                } catch (IOException e10) {
                    r14 = this;
                    this = gVar;
                    e = e10;
                    j3.b.f8554a.d(f7702g, e);
                    byte[] bArr2 = r14.f7704d;
                    bVar.L$0 = r14;
                    bVar.L$1 = null;
                    bVar.label = 4;
                    if (this.e(bArr2, 0, -1, bVar) == aVar) {
                        return aVar;
                    }
                    r12 = r14;
                    r12.stop();
                    r10 = r12;
                }
            }
            do {
                if (gVar2.f14165d) {
                    j3.b.f8554a.e(f7702g, "socket read data is finish ");
                    r10 = r11;
                    return r10.f7705e;
                }
                i10 = r11.f7703c.read(r11.f7704d);
                if (i10 == -1) {
                    byte[] bArr3 = r11.f7704d;
                    bVar.L$0 = r11;
                    bVar.L$1 = gVar2;
                    bVar.label = 2;
                    r13 = r11;
                    if (gVar2.e(bArr3, 0, -1, bVar) == aVar) {
                        return aVar;
                    }
                    gVar = gVar2;
                    ?? r16 = r13;
                    r16.stop();
                    return r16.f7705e;
                }
                bArr = r11.f7704d;
                bVar.L$0 = r11;
                bVar.L$1 = gVar2;
                bVar.label = 3;
            } while (gVar2.e(bArr, 0, i10, bVar) != aVar);
            return aVar;
        } catch (IOException e11) {
            e = e11;
        }
    }

    @Override // f3.a
    public Object f(g gVar, um.d dVar) {
        return l2.f10208a;
    }

    @m
    public Object j(@l g gVar, @l um.d<? super l2> dVar) {
        return l2.f10208a;
    }

    @Override // f3.a, z2.a
    public void stop() {
        this.f5840b = true;
        try {
            this.f7703c.close();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
