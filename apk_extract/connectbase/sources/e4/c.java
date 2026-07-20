package e4;

import android.os.Handler;
import android.os.Looper;
import com.transsion.backup.model.AlbumFile;
import com.transsion.connectx.mirror.source.receiver.HomeKeyReceiver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.r1;
import lm.c1;
import lm.d1;
import lm.l2;
import nm.y;
import nm.z;
import nq.k;
import nq.p;
import nq.q;
import nq.s0;
import os.l;
import os.m;
import pq.f0;
import r2.w;
import x2.e;
import x2.g;
import xm.f;
import xm.h;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nBackupFileTransferManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BackupFileTransferManager.kt\ncom/transsion/backup/filetransfer/BackupFileTransferManager\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,185:1\n314#2,11:186\n1549#3:197\n1620#3,3:198\n1774#3,4:201\n1#4:205\n*S KotlinDebug\n*F\n+ 1 BackupFileTransferManager.kt\ncom/transsion/backup/filetransfer/BackupFileTransferManager\n*L\n88#1:186,11\n144#1:197\n144#1:198,3\n163#1:201,4\n*E\n"})
public final class c implements s0, g {
    public static int H = 0;
    public static int I = 0;

    @l
    public static final Runnable J;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final c f4049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final String f4050c = "BackupFileTransferManag";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f4051d = 50241;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f4052e = 50341;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f4053f = 10;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f4054g = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @m
    public static List<AlbumFile> f4055i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @m
    public static Long f4056n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @m
    public static f4.c f4057p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static int f4058v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @l
    public static pq.l<d> f4059w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @m
    public static p<? super Boolean> f4060x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static boolean f4061y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @l
    public static final Handler f4062z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s0 f4063a = s2.d.a();

    @f(c = "com.transsion.backup.filetransfer.BackupFileTransferManager", f = "BackupFileTransferManager.kt", i = {0, 0, 1, 1}, l = {80, 81, 186, da.b.f3634e}, m = "execSendFile", n = {"this", "sendFilesTask", "this", "sendFilesTask"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class a extends xm.d {
        Object L$0;
        Object L$1;
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
            return c.this.s(null, this);
        }
    }

    @f(c = "com.transsion.backup.filetransfer.BackupFileTransferManager$sendFiles$1", f = "BackupFileTransferManager.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends o implements jn.p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ int $backupType;
        final /* synthetic */ List<AlbumFile> $files;
        final /* synthetic */ String $ip;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(List<AlbumFile> list, String str, int i10, um.d<? super b> dVar) {
            super(2, dVar);
            this.$files = list;
            this.$ip = str;
            this.$backupType = i10;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            return new b(this.$files, this.$ip, this.$backupType, dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                pq.l lVar = c.f4059w;
                d dVar = new d(this.$files, this.$ip, this.$backupType);
                this.label = 1;
                if (lVar.L(dVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            k4.m.e(c.f4050c, "sendFiles " + this.$files);
            return l2.f10208a;
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m um.d<? super l2> dVar) {
            return ((b) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: renamed from: e4.c$c, reason: collision with other inner class name */
    @f(c = "com.transsion.backup.filetransfer.BackupFileTransferManager$startSendFileTask$1", f = "BackupFileTransferManager.kt", i = {}, l = {70, 74}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0094c extends o implements jn.p<s0, um.d<? super l2>, Object> {
        int label;

        public C0094c(um.d<? super C0094c> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            return new C0094c(dVar);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0029  */
        /* JADX WARN: Code duplicated, block: B:15:0x0033 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:18:0x005d A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005b -> B:11:0x0023). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:18:0x005d
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r6) {
            /*
                r5 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1c
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                lm.d1.n(r6)
                goto L23
            L10:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L18:
                lm.d1.n(r6)
                goto L34
            L1c:
                lm.d1.n(r6)
                e4.c r6 = e4.c.f4049b
                e4.c.f4061y = r3
            L23:
                boolean r6 = e4.c.l()
                if (r6 == 0) goto L5e
                pq.l<e4.d> r6 = e4.c.f4059w
                r5.label = r3
                java.lang.Object r6 = r6.n(r5)
                if (r6 != r0) goto L34
                return r0
            L34:
                e4.d r6 = (e4.d) r6
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r4 = "sendFilesTask "
                r1.<init>(r4)
                r1.append(r6)
                java.lang.String r1 = r1.toString()
                java.lang.String r4 = "BackupFileTransferManag"
                k4.m.e(r4, r1)
                e4.c r1 = e4.c.f4049b
                r4 = 50241(0xc441, float:7.0403E-41)
                e4.c.H = r4
                r4 = 50341(0xc4a5, float:7.0543E-41)
                e4.c.I = r4
                r5.label = r2
                java.lang.Object r6 = r1.s(r6, r5)
                if (r6 != r0) goto L23
                return r0
            L5e:
                lm.l2 r5 = lm.l2.f10208a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: e4.c.C0094c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m um.d<? super l2> dVar) {
            return ((C0094c) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    static {
        c cVar = new c();
        f4049b = cVar;
        q2.b.f13800a.h(cVar);
        cVar.A();
        f4059w = pq.o.d(0, null, null, 7, null);
        f4062z = new Handler(Looper.getMainLooper());
        H = f4051d;
        I = f4052e;
        J = new e4.b();
    }

    public static final void t() {
        k4.m.e(f4050c, "handshake timeout");
        f4049b.v();
    }

    public static /* synthetic */ nq.l2 x(c cVar, List list, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return cVar.w(list, str, i10);
    }

    public final nq.l2 A() {
        return k.f(this, null, null, new C0094c(null), 3, null);
    }

    public final void B() {
        f4061y = false;
        f0.a.b(f4059w, null, 1, null);
        f4057p = null;
        u();
    }

    @Override // x2.d
    public void b(long j10, @l w wVar) {
        l0.p(wVar, HomeKeyReceiver.f2161e);
        k4.m.e(f4050c, "onFail task " + j10 + " fail reason " + wVar.name());
        f4.c cVar = f4057p;
        if (cVar != null) {
            cVar.onFail(j10, wVar.ordinal());
        }
        u();
    }

    @Override // x2.g
    public void e(long j10, boolean z10, @m String str) {
        k4.m.e(f4050c, "onAccept task " + j10 + " accept " + z10 + " extend " + str);
        f4056n = Long.valueOf(j10);
    }

    @Override // x2.g
    public void f(@l String str) {
        l0.p(str, "data");
        k4.m.e(f4050c, "onHandshake data " + str);
        f4062z.removeCallbacks(J);
        List<AlbumFile> list = f4055i;
        if (list != null) {
            q2.b bVar = q2.b.f13800a;
            List<AlbumFile> list2 = list;
            ArrayList arrayList = new ArrayList(z.b0(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(new e4.a((AlbumFile) it.next()));
            }
            e.a.d(bVar, arrayList, null, false, 6, null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x005f  */
    @Override // x2.d
    public void g(long j10) {
        int i10;
        k4.m.e(f4050c, "onstart task " + j10);
        f4.c cVar = f4057p;
        if (cVar != null) {
            cVar.onStart(j10, f4058v);
        }
        if (f4058v == 0) {
            List<AlbumFile> list = f4055i;
            int i11 = 0;
            int size = list != null ? list.size() : 0;
            List<AlbumFile> list2 = f4055i;
            if (list2 != null) {
                List<AlbumFile> list3 = list2;
                if ((list3 instanceof Collection) && list3.isEmpty()) {
                    i10 = 0;
                } else {
                    Iterator<T> it = list3.iterator();
                    i10 = 0;
                    while (it.hasNext()) {
                        if (((AlbumFile) it.next()).getType() == 1 && (i10 = i10 + 1) < 0) {
                            y.Y();
                        }
                    }
                }
            } else {
                i10 = 0;
            }
            List<AlbumFile> list4 = f4055i;
            if (list4 != null) {
                Iterator<T> it2 = list4.iterator();
                long size2 = 0;
                while (it2.hasNext()) {
                    size2 += ((AlbumFile) it2.next()).getSize();
                }
                i11 = ((int) size2) / 1048576;
            }
            o4.b.f12074a.d(size, i10, i11);
        }
    }

    @Override // nq.s0
    @l
    public um.g getCoroutineContext() {
        return this.f4063a.getCoroutineContext();
    }

    @Override // x2.d
    public void onCancel(long j10, boolean z10) {
        k4.m.e(f4050c, "onCancel task " + j10 + " remote cancel " + z10);
        f4.c cVar = f4057p;
        if (cVar != null) {
            cVar.onCancel(j10, z10);
        }
        u();
    }

    @Override // x2.d
    public void onFinish(long j10) {
        k4.m.e(f4050c, "onfinish task " + j10);
        f4.c cVar = f4057p;
        if (cVar != null) {
            cVar.onFinish(j10);
        }
        u();
    }

    @Override // x2.d
    public void onProgress(long j10, double d10, int i10, int i11) {
        StringBuilder sbA = j.b.a("onProgress task ", j10, " progress ");
        sbA.append(d10);
        sbA.append(" fileIndex ");
        sbA.append(i10);
        sbA.append(" totalCount ");
        sbA.append(i11);
        k4.m.e(f4050c, sbA.toString());
        f4.c cVar = f4057p;
        if (cVar != null) {
            cVar.onProgress(j10, d10, i10, i11);
        }
    }

    public final void r() {
        k4.m.e(f4050c, "cancel currentTaskId:" + f4056n);
        if (f4056n == null) {
            u();
            return;
        }
        q2.b bVar = q2.b.f13800a;
        Long l10 = f4056n;
        e.a.b(bVar, l10 != null ? l10.longValue() : 0L, false, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:34:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:36:0x00de A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:41:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:43:0x0101 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x0105  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object s(d dVar, um.d<? super l2> dVar2) {
        a aVar;
        c cVar;
        d dVar3;
        boolean zBooleanValue;
        int i10;
        Object objZ;
        if (dVar2 instanceof a) {
            aVar = (a) dVar2;
            int i11 = aVar.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                aVar.label = i11 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar2);
            }
        } else {
            aVar = new a(dVar2);
        }
        Object objC = aVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i12 = aVar.label;
        if (i12 == 0) {
            d1.n(objC);
            aVar.L$0 = this;
            aVar.L$1 = dVar;
            aVar.label = 1;
            if (nq.d1.b(500L, aVar) == aVar2) {
                return aVar2;
            }
        } else {
            if (i12 != 1) {
                if (i12 != 2) {
                    if (i12 == 3) {
                        d1.n(objC);
                        return l2.f10208a;
                    }
                    if (i12 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(objC);
                    return l2.f10208a;
                }
                dVar3 = (d) aVar.L$1;
                cVar = (c) aVar.L$0;
                d1.n(objC);
                zBooleanValue = ((Boolean) objC).booleanValue();
                k4.m.e(f4050c, "createFileTransfer " + zBooleanValue);
                if (zBooleanValue) {
                    i10 = H;
                    H = i10 + 1;
                    I++;
                    if (i10 - 50240 > 10) {
                        return l2.f10208a;
                    }
                    aVar.L$0 = null;
                    aVar.L$1 = null;
                    aVar.label = 4;
                    if (cVar.s(dVar3, aVar) == aVar2) {
                        return aVar2;
                    }
                    return l2.f10208a;
                }
                f4055i = dVar3.f4064a;
                f4058v = dVar3.f4066c;
                g4.a.f6407a.a(H, I);
                f4062z.postDelayed(J, r4.a.O);
                aVar.L$0 = null;
                aVar.L$1 = null;
                aVar.label = 3;
                q qVar = new q(wm.c.e(aVar), 1);
                qVar.F();
                f4060x = qVar;
                objZ = qVar.z();
                if (objZ == aVar2) {
                    h.c(aVar);
                }
                if (objZ == aVar2) {
                    return aVar2;
                }
                return l2.f10208a;
            }
            dVar = (d) aVar.L$1;
            this = (c) aVar.L$0;
            d1.n(objC);
        }
        q2.b bVar = q2.b.f13800a;
        String str = dVar.f4065b;
        if (str == null) {
            str = "";
        }
        String strB = s2.e.b(str, H, I);
        aVar.L$0 = this;
        aVar.L$1 = dVar;
        aVar.label = 2;
        objC = bVar.c(strB, aVar);
        if (objC == aVar2) {
            return aVar2;
        }
        d dVar4 = dVar;
        cVar = this;
        dVar3 = dVar4;
        zBooleanValue = ((Boolean) objC).booleanValue();
        k4.m.e(f4050c, "createFileTransfer " + zBooleanValue);
        if (zBooleanValue) {
            i10 = H;
            H = i10 + 1;
            I++;
            if (i10 - 50240 > 10) {
                return l2.f10208a;
            }
            aVar.L$0 = null;
            aVar.L$1 = null;
            aVar.label = 4;
            if (cVar.s(dVar3, aVar) == aVar2) {
                return aVar2;
            }
            return l2.f10208a;
        }
        f4055i = dVar3.f4064a;
        f4058v = dVar3.f4066c;
        g4.a.f6407a.a(H, I);
        f4062z.postDelayed(J, r4.a.O);
        aVar.L$0 = null;
        aVar.L$1 = null;
        aVar.label = 3;
        q qVar2 = new q(wm.c.e(aVar), 1);
        qVar2.F();
        f4060x = qVar2;
        objZ = qVar2.z();
        if (objZ == aVar2) {
            h.c(aVar);
        }
        if (objZ == aVar2) {
            return aVar2;
        }
        return l2.f10208a;
    }

    public final void u() {
        q2.b.f13800a.release();
        v();
        f4056n = null;
    }

    public final void v() {
        p<? super Boolean> pVar;
        try {
            p<? super Boolean> pVar2 = f4060x;
            if (pVar2 == null || !pVar2.isActive() || (pVar = f4060x) == null) {
                return;
            }
            c1.a aVar = c1.Companion;
            pVar.resumeWith(c1.m59constructorimpl(Boolean.TRUE));
        } catch (Exception e10) {
            k4.m.e(f4050c, "err: " + e10);
        }
    }

    @l
    public final nq.l2 w(@l List<AlbumFile> list, @m String str, int i10) {
        l0.p(list, "files");
        return k.f(this, null, null, new b(list, str, i10, null), 3, null);
    }

    public final void y(@m f4.c cVar) {
        f4059w = pq.o.d(0, null, null, 7, null);
        A();
        f4057p = cVar;
    }
}
