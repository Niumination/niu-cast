package c3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.n0;
import kn.r1;
import kn.u1;
import lm.l2;
import nm.z;
import r2.u;
import r2.v;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nFileTransferTaskManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTransferTaskManager.kt\ncom/transsion/airtransfer/filetransfer/process/file/FileTransferTaskManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 DataBus.kt\ncom/transsion/airtransfer/filetransfer/databus/DataBus\n*L\n1#1,141:1\n1549#2:142\n1620#2,3:143\n288#2,2:151\n288#2,2:153\n288#2,2:155\n288#2,2:157\n1855#2,2:159\n1855#2,2:161\n1855#2,2:163\n38#3,5:146\n*S KotlinDebug\n*F\n+ 1 FileTransferTaskManager.kt\ncom/transsion/airtransfer/filetransfer/process/file/FileTransferTaskManager\n*L\n35#1:142\n35#1:143,3\n49#1:151,2\n62#1:153,2\n66#1:155,2\n70#1:157,2\n83#1:159,2\n125#1:161,2\n137#1:163,2\n40#1:146,5\n*E\n"})
public final class m implements y2.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final String f1315c = "FileTransferTaskManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final m f1313a = new m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final ArrayList<r2.k> f1314b = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final y2.e f1316d = y2.f.f20685a;

    public static final class a extends n0 implements jn.a<l2> {
        final /* synthetic */ long $taskId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j10) {
            super(0);
            this.$taskId = j10;
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            invoke2();
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            q2.c.f13803b.getClass();
            q qVar = q2.c.f13806e;
            if (qVar != null) {
                qVar.onCancel(this.$taskId, false);
            }
        }
    }

    @r1({"SMAP\nFileTransferTaskManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTransferTaskManager.kt\ncom/transsion/airtransfer/filetransfer/process/file/FileTransferTaskManager$checkAndHandleZeroFiles$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,141:1\n766#2:142\n857#2,2:143\n1855#2,2:145\n*S KotlinDebug\n*F\n+ 1 FileTransferTaskManager.kt\ncom/transsion/airtransfer/filetransfer/process/file/FileTransferTaskManager$checkAndHandleZeroFiles$1\n*L\n106#1:142\n106#1:143,2\n109#1:145,2\n*E\n"})
    public static final class b extends n0 implements jn.a<l2> {
        final /* synthetic */ u $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(u uVar) {
            super(0);
            this.$data = uVar;
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ l2 invoke() throws IOException {
            invoke2();
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws IOException {
            r2.k kVarD = m.f1313a.d(this.$data.f14207h);
            if (kVarD != null) {
                u uVar = this.$data;
                List<r2.j> list = kVarD.f14189c;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (((r2.j) obj).f14178c == 0) {
                        arrayList.add(obj);
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    new File(q2.a.f13797a.a(), ((r2.j) it.next()).f14177b).createNewFile();
                }
                if (arrayList.size() == kVarD.f14189c.size()) {
                    q2.c.f13803b.getClass();
                    p pVar = q2.c.f13805d;
                    if (pVar != null) {
                        pVar.onFinish(uVar.f14207h);
                    }
                }
            }
        }
    }

    @Override // y2.d
    public void a() {
        Iterator<T> it = f1314b.iterator();
        while (it.hasNext()) {
            ((r2.k) it.next()).f14191e = 4;
        }
        r2.p.b(u2.b.f16175b, new r2.a(0L, 1, null), null, 2, null);
    }

    @Override // y2.d
    public void b(boolean z10, long j10, @os.m String str) {
        u uVar = new u(j10, z10, str);
        r2.k kVarD = d(j10);
        if (!z10) {
            if (kVarD != null) {
                kVarD.f14191e = 5;
            }
            l(kVarD);
        } else if (kVarD != null) {
            kVarD.f14191e = 1;
        }
        j(uVar);
        r2.p.b(u2.b.f16175b, uVar, null, 2, null);
    }

    @Override // y2.d
    public long c(@os.l List<? extends x2.c> list, @os.m String str) {
        l0.p(list, "fileData");
        long jA = f1316d.a();
        List<? extends x2.c> list2 = list;
        ArrayList arrayList = new ArrayList(z.b0(list2, 10));
        for (x2.c cVar : list2) {
            Long l10 = cVar.f19997a;
            arrayList.add(new r2.j(l10 != null ? l10.longValue() : f1316d.a(), cVar.c(), cVar.N1(), ""));
        }
        r2.k kVar = new r2.k(jA, list, arrayList, str, 0, 16, null);
        f1314b.add(kVar);
        j3.b.f8554a.e(f1315c, "send file " + kVar);
        nq.k.f(u2.b.f16175b, null, null, new u2.b.e(new v(kVar), null, null), 3, null);
        return kVar.f14187a;
    }

    @Override // y2.d
    public void clear() {
        Iterator<T> it = f1314b.iterator();
        while (it.hasNext()) {
            f1313a.k((r2.k) it.next());
        }
        f1314b.clear();
    }

    @Override // y2.d
    @os.m
    public r2.k d(long j10) {
        Object next;
        Iterator<T> it = f1314b.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((r2.k) next).f14187a == j10) {
                return (r2.k) next;
            }
        }
        next = null;
        return (r2.k) next;
    }

    @Override // y2.d
    public void e(@os.l r2.k kVar) {
        l0.p(kVar, "taskInfo");
        f1314b.add(kVar);
    }

    @Override // y2.d
    public void f(long j10) {
        Object next;
        Iterator<T> it = f1314b.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((r2.k) next).f14187a != j10);
        r2.k kVar = (r2.k) next;
        if (kVar != null) {
            kVar.f14191e = 4;
        }
        l(kVar);
    }

    @Override // y2.d
    @os.m
    public r2.k g(long j10) {
        Object obj;
        Object next;
        Iterator<T> it = f1314b.iterator();
        do {
            obj = null;
            if (it.hasNext()) {
                next = it.next();
                for (Object obj2 : ((r2.k) next).f14189c) {
                    if (((r2.j) obj2).f14176a == j10) {
                        obj = obj2;
                        break;
                    }
                }
            }
            return (r2.k) obj;
        } while (obj == null);
        obj = next;
        return (r2.k) obj;
    }

    @Override // y2.d
    public void h(long j10, int i10) {
        r2.k kVarD = d(j10);
        if (kVarD != null) {
            kVarD.f14191e = i10;
            f1313a.l(kVarD);
        }
    }

    @Override // y2.d
    public void i(long j10) {
        Object next;
        Iterator<T> it = f1314b.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((r2.k) next).f14187a != j10);
        r2.k kVar = (r2.k) next;
        if (kVar == null || !kVar.p()) {
            r2.p.b(u2.b.f16175b, new r2.a(j10), null, 2, null);
        } else {
            r2.p.a(u2.b.f16175b, new r2.d(j10, 0L, 0L), new a(j10));
        }
    }

    public final void j(u uVar) {
        if (uVar.f14208i) {
            uVar.d(new b(uVar));
        }
    }

    public final void k(r2.k kVar) {
        List<x2.c> list;
        if (kVar == null || (list = kVar.f14188b) == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            s2.b.c((x2.c) it.next());
        }
    }

    public final void l(r2.k kVar) {
        k(kVar);
        u1.a(f1314b).remove(kVar);
    }
}
