package b4;

import android.app.Application;
import com.transsion.backup.model.AlbumFile;
import com.transsion.backup.model.AlbumInfo;
import com.transsion.backup.model.AuthResult;
import com.transsion.backup.model.BackupMessage;
import com.transsion.backup.model.PageData;
import java.util.Collection;
import java.util.List;
import jn.p;
import jq.h0;
import k4.j;
import kn.l0;
import lm.d1;
import lm.l2;
import nq.k;
import nq.k1;
import nq.s0;
import nq.t0;
import os.l;
import os.m;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final String f726b = "BackupManager";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f728d = 3000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @m
    public static f4.b f731g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static c4.d f732h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static c4.e f733i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @m
    public static f4.a f735k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @m
    public static jn.l<? super String, l2> f736l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final a f725a = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public static final s0 f729e = t0.a(k1.c());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public static final g4.a f730f = g4.a.f6407a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f727c = 50314;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f734j = f727c;

    /* JADX INFO: renamed from: b4.a$a, reason: collision with other inner class name */
    public static final class C0028a extends c2.a<BackupMessage<AuthResult>> {
    }

    public static final class b extends c2.a<BackupMessage<List<? extends Long>>> {
    }

    @xm.f(c = "com.transsion.backup.BackupManager$handRequestMessage$1", f = "BackupManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends o implements p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ Object $data;
        final /* synthetic */ int $type;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i10, Object obj, um.d<? super c> dVar) {
            super(2, dVar);
            this.$type = i10;
            this.$data = obj;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            return new c(this.$type, this.$data, dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            int i10 = this.$type;
            if (i10 == 1) {
                a.f725a.h(this.$data);
            } else if (i10 != 2) {
                switch (i10) {
                    case 5:
                        a.f725a.k(this.$data);
                        break;
                    case 6:
                        a.f725a.o(this.$data, 1);
                        break;
                    case 7:
                        a.f725a.o(this.$data, 0);
                        break;
                    case 8:
                        a.f725a.j();
                        break;
                    case 9:
                        a.f725a.v(this.$data);
                        break;
                }
            } else {
                a.f725a.t();
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m um.d<? super l2> dVar) {
            return ((c) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public static final class d implements f4.a {
        @Override // f4.a
        public void a(@l List<AlbumFile> list) {
            l0.p(list, "files");
            c4.d dVar = a.f732h;
            if (dVar == null) {
                l0.S("albumManager");
                dVar = null;
            }
            a.f730f.i(list, dVar.i());
        }
    }

    @xm.f(c = "com.transsion.backup.BackupManager$onBackupRequest$1", f = "BackupManager.kt", i = {}, l = {164}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends o implements p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ int $backupType;
        final /* synthetic */ BackupMessage<List<Long>> $message;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(BackupMessage<List<Long>> backupMessage, int i10, um.d<? super e> dVar) {
            super(2, dVar);
            this.$message = backupMessage;
            this.$backupType = i10;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            return new e(this.$message, this.$backupType, dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                c4.d dVar = a.f732h;
                if (dVar == null) {
                    l0.S("albumManager");
                    dVar = null;
                }
                List<Long> data = this.$message.getData();
                this.label = 1;
                obj = dVar.c(data, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            e4.c.x(e4.c.f4049b, (List) obj, null, this.$backupType, 2, null);
            return l2.f10208a;
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m um.d<? super l2> dVar) {
            return ((e) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public static final class f extends c2.a<BackupMessage<List<? extends Long>>> {
    }

    public final void h(Object obj) {
        f4.b bVar;
        BackupMessage backupMessage = (BackupMessage) j.a.f8962a.b(obj.toString(), new C0028a().getType());
        k4.m.e(f726b, "authRequest auth: " + backupMessage);
        AuthResult authResult = (AuthResult) backupMessage.getData();
        if (authResult == null || (bVar = f731g) == null) {
            return;
        }
        bVar.onRequest(authResult.getDeviceName(), authResult.getDeviceId());
    }

    public final void i() {
        k4.m.e(f726b, "backup");
        c4.d dVar = f732h;
        if (dVar == null) {
            l0.S("albumManager");
            dVar = null;
        }
        e4.c.x(e4.c.f4049b, dVar.e(), null, 0, 6, null);
    }

    public final void j() {
        e4.c.f4049b.r();
    }

    public final void k(Object obj) {
        BackupMessage backupMessage = (BackupMessage) j.a.f8962a.b(obj.toString(), new b().getType());
        List list = (List) backupMessage.getData();
        int size = list != null ? list.size() : 0;
        List<Long> list2 = (List) backupMessage.getData();
        if (list2 != null) {
            c4.d dVar = f732h;
            if (dVar == null) {
                l0.S("albumManager");
                dVar = null;
            }
            dVar.g(list2);
        }
        o4.b.f12074a.a(size);
    }

    public final void l(int i10, @l Object obj) {
        l0.p(obj, "data");
        k4.m.e(f726b, "handRequestMessage type: " + i10);
        k.f(f729e, null, null, new c(i10, obj, null), 3, null);
    }

    public final void m(@l Application application) {
        l0.p(application, "context");
        f732h = i4.a.f7717a.a() ? new c4.b(application) : new c4.c(application);
        c4.d dVar = f732h;
        if (dVar == null) {
            l0.S("albumManager");
            dVar = null;
        }
        f733i = new c4.e(dVar);
        q2.b.f13800a.r(application, k4.m.f8964a, 4);
    }

    public final void n() {
        d dVar = new d();
        c4.d dVar2 = f732h;
        if (dVar2 == null) {
            l0.S("albumManager");
            dVar2 = null;
        }
        dVar2.d(dVar);
        f735k = dVar;
    }

    public final void o(Object obj, int i10) {
        BackupMessage backupMessage = (BackupMessage) j.a.f8962a.b(obj.toString(), new f().getType());
        k4.m.e(f726b, "onBackupRequest message: " + backupMessage);
        Collection collection = (Collection) backupMessage.getData();
        if (collection == null || collection.isEmpty()) {
            return;
        }
        k.f(f729e, null, null, new e(backupMessage, i10, null), 3, null);
    }

    public final void p(boolean z10, boolean z11) {
        f730f.c(new AuthResult(z10, z11));
    }

    public final void q(@l f4.c cVar, @l f4.b bVar, @l jn.l<? super String, l2> lVar) {
        l0.p(cVar, "fileListener");
        l0.p(bVar, "authListener");
        l0.p(lVar, "autoBackupState");
        f731g = bVar;
        e4.c.f4049b.y(cVar);
        f736l = lVar;
        r();
        n();
    }

    public final void r() {
        for (int i10 = 0; i10 < 11; i10++) {
            c4.e eVar = f733i;
            if (eVar == null) {
                l0.S("albumThumbServer");
                eVar = null;
            }
            if (eVar.s(f734j)) {
                f730f.b(f734j);
                return;
            }
            f734j++;
        }
    }

    public final void s() {
        c4.d dVar = null;
        f731g = null;
        e4.c.f4049b.B();
        c4.e eVar = f733i;
        if (eVar == null) {
            l0.S("albumThumbServer");
            eVar = null;
        }
        eVar.t();
        f4.a aVar = f735k;
        if (aVar != null) {
            c4.d dVar2 = f732h;
            if (dVar2 == null) {
                l0.S("albumManager");
            } else {
                dVar = dVar2;
            }
            dVar.h(aVar);
        }
    }

    public final void t() {
        k4.m.e(f726b, "syncAlbumData start");
        c4.d dVar = f732h;
        c4.d dVar2 = null;
        if (dVar == null) {
            l0.S("albumManager");
            dVar = null;
        }
        List<AlbumFile> listE = dVar.e();
        int size = listE.size();
        m2.b.a("syncAlbumData size: ", listE.size(), f726b);
        c4.d dVar3 = f732h;
        if (dVar3 == null) {
            l0.S("albumManager");
        } else {
            dVar2 = dVar3;
        }
        List<AlbumInfo> listI = dVar2.i();
        if (listE.size() > 3000) {
            int size2 = (listE.size() / 3000) + 1;
            for (int i10 = 0; i10 < size2; i10++) {
                int i11 = i10 * 3000;
                List<AlbumFile> listSubList = listE.subList(i11, Math.min(i11 + 3000, listE.size()));
                m2.b.a("syncAlbumData page data size ", j.a.f8962a.g(listSubList).length(), f726b);
                f730f.g(new PageData<>(i10, size2, listSubList), listI);
            }
        } else {
            f730f.g(new PageData<>(0, 0, listE, 3, null), listI);
        }
        o4.b.f12074a.b(size);
    }

    public final void u(@l String str) {
        l0.p(str, "data");
        k4.m.e(f726b, "syncAutoBackupState autoBackupState: " + str);
        g4.a.f6407a.k(str);
    }

    public final void v(Object obj) {
        k4.m.e(f726b, "syncAutoBackupState autoBackupState: " + obj);
        jn.l<? super String, l2> lVar = f736l;
        if (lVar != null) {
            lVar.invoke(obj.toString());
        }
        if (h0.T2(obj.toString(), "false", false, 2, null)) {
            e4.c.f4049b.u();
        }
    }
}
