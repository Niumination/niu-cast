package q2;

import c3.p;
import c3.q;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kn.l0;
import kn.r1;
import lm.d1;
import lm.l2;
import nm.d0;
import nq.k;
import nq.o0;
import nq.s0;
import os.l;
import os.m;
import pq.f0;
import pq.o;
import r2.f;
import s2.d;
import um.g;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nFileTransferStateManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTransferStateManager.kt\ncom/transsion/airtransfer/filetransfer/FileTransferStateManager\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n1#1,90:1\n48#2,4:91\n*S KotlinDebug\n*F\n+ 1 FileTransferStateManager.kt\ncom/transsion/airtransfer/filetransfer/FileTransferStateManager\n*L\n60#1:91,4\n*E\n"})
public final class c implements s0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final String f13804c = "FileTransferStateManage";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m
    public static p f13805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @m
    public static q f13806e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s0 f13810a = d.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final c f13803b = new c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public static final Map<String, f> f13807f = new LinkedHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public static pq.l<Boolean> f13808g = o.d(0, null, null, 7, null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @l
    public static final ArrayList<String> f13809i = new ArrayList<>();

    @xm.f(c = "com.transsion.airtransfer.filetransfer.FileTransferStateManager", f = "FileTransferStateManager.kt", i = {}, l = {44}, m = "getConnectResult", n = {}, s = {})
    public static final class a extends xm.d {
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.this.f(this);
        }
    }

    @r1({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n+ 2 FileTransferStateManager.kt\ncom/transsion/airtransfer/filetransfer/FileTransferStateManager\n*L\n1#1,110:1\n60#2:111\n*E\n"})
    public static final class b extends um.a implements o0 {
        public b(o0.b bVar) {
            super(bVar);
        }

        @Override // nq.o0
        public void g0(@l g gVar, @l Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: q2.c$c, reason: collision with other inner class name */
    @r1({"SMAP\nFileTransferStateManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTransferStateManager.kt\ncom/transsion/airtransfer/filetransfer/FileTransferStateManager$start$2\n+ 2 DataBus.kt\ncom/transsion/airtransfer/filetransfer/databus/DataBus\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,90:1\n45#2,2:91\n1726#3,3:93\n1726#3,3:96\n*S KotlinDebug\n*F\n+ 1 FileTransferStateManager.kt\ncom/transsion/airtransfer/filetransfer/FileTransferStateManager$start$2\n*L\n64#1:91,2\n68#1:93,3\n69#1:96,3\n*E\n"})
    @xm.f(c = "com.transsion.airtransfer.filetransfer.FileTransferStateManager$start$2", f = "FileTransferStateManager.kt", i = {}, l = {ms.a.W, 69}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0339c extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0339c(String str, um.d<? super C0339c> dVar) {
            super(2, dVar);
            this.$url = str;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            return new C0339c(this.$url, dVar);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x00a8  */
        /* JADX WARN: Code duplicated, block: B:50:0x00b1 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:51:0x0040 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:52:? A[LOOP:1: B:22:0x00a2->B:52:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0053 -> B:14:0x0056). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r8) {
            /*
                Method dump skipped, instruction units count: 241
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: q2.c.C0339c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m um.d<? super l2> dVar) {
            return ((C0339c) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @m
    public final Object f(@l um.d<? super Boolean> dVar) {
        a aVar;
        boolean zBooleanValue;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object objN = aVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        try {
            if (i11 == 0) {
                d1.n(objN);
                pq.l<Boolean> lVar = f13808g;
                aVar.label = 1;
                objN = lVar.n(aVar);
                if (objN == aVar2) {
                    return aVar2;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(objN);
            }
            zBooleanValue = ((Boolean) objN).booleanValue();
        } catch (Exception e10) {
            e10.printStackTrace();
            zBooleanValue = false;
        }
        if (!zBooleanValue) {
            ArrayList<String> arrayList = f13809i;
            d0.P0(arrayList);
            if (arrayList.isEmpty()) {
                q2.b.f13800a.release();
            }
        }
        f13807f.clear();
        j3.b.f8554a.e(f13804c, "getConnectResult isSuccess:" + zBooleanValue);
        return Boolean.valueOf(zBooleanValue);
    }

    @m
    public final p g() {
        return f13805d;
    }

    @Override // nq.s0
    @l
    public g getCoroutineContext() {
        return this.f13810a.getCoroutineContext();
    }

    @m
    public final q i() {
        return f13806e;
    }

    public final boolean j(@l String str) {
        l0.p(str, RtspHeaders.Values.URL);
        return f13809i.contains(str);
    }

    public final void k() {
        f13807f.clear();
        f0.a.b(f13808g, null, 1, null);
        f13808g = o.d(0, null, null, 7, null);
        f13809i.clear();
    }

    public final void l(@l x2.f fVar) {
        l0.p(fVar, "listener");
        f13805d = new p(fVar);
    }

    public final void m(@l x2.g gVar) {
        l0.p(gVar, "listener");
        f13806e = new q(gVar);
    }

    public final void n(@m p pVar) {
        f13805d = pVar;
    }

    public final void o(@m q qVar) {
        f13806e = qVar;
    }

    @l
    public final nq.l2 p(@l String str) {
        l0.p(str, RtspHeaders.Values.URL);
        return k.f(this, new b((g.c<?>) o0.f11887j), null, new C0339c(str, null), 2, null);
    }

    public final void r(@l String str) {
        l0.p(str, "tag");
        f13807f.put(str, null);
    }
}
