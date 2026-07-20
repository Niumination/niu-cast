package af;

import android.app.Application;
import android.util.Log;
import com.transsion.atomiccore.hostsdk.utils.AtomicCoreUtils;
import com.transsion.iotservice.multiscreen.pc.R$string;
import java.util.ArrayDeque;
import java.util.concurrent.ScheduledFuture;
import k3.ee;
import k3.gc;
import k3.v8;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d2 implements q3, fb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f215c;

    public d2(int i8) {
        switch (i8) {
            case 3:
                this.f214b = new Object();
                break;
            default:
                this.f214b = LazyKt.lazy(new bb.s(10));
                this.f215c = LazyKt.lazy(new bb.s(11));
                gb.c cVar = gb.c.f5123b;
                bb.s sVar = new bb.s(12);
                cVar.getClass();
                gb.c.e = sVar;
                break;
        }
    }

    @Override // fb.a
    public void a(int i8) {
        Intrinsics.checkNotNullParameter("Atomic-AtomicImpl", "tag");
        Intrinsics.checkNotNullParameter("showSuccess", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("Atomic-AtomicImpl"), "showSuccess");
        }
        gb.a aVarF = f();
        gb.f fVar = (gb.f) ((Lazy) this.f215c).getValue();
        fVar.getClass();
        Intrinsics.checkNotNullParameter("Atomic-SendBuilder", "tag");
        Intrinsics.checkNotNullParameter("buildSendSuccess", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("Atomic-SendBuilder"), "buildSendSuccess");
        }
        gb.c.f5123b.getClass();
        gb.d dVar = gb.c.f5125d;
        if (dVar != null) {
            fVar.f5135c = dVar;
        }
        String strA = fVar.f5135c.f5129c == 5 ? ee.a(fVar.b(), R$string.md_copy_success, "") : ee.a(fVar.b(), R$string.md_transfer_success, "");
        String strA2 = fVar.f5135c.f5129c == 5 ? ee.a(fVar.b(), R$string.md_share_to_device, fVar.f5135c.f5128b) : ee.a(fVar.b(), R$string.md_transfer_to_device, fVar.f5135c.f5128b);
        y6.g gVar = fVar.f5133a;
        k3.f2.c(gVar, "", "success");
        k3.f2.b(gVar, strA, strA2, new gb.e("success", ""));
        JSONObject jSONObjectD = k3.f2.d();
        aVarF.getClass();
        gb.a.b(gVar, jSONObjectD);
    }

    @Override // fb.a
    public void b(boolean z2) {
        String strO = o.d.o("closeNotification, isCancel: ", z2, "Atomic-AtomicImpl", "tag", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("Atomic-AtomicImpl"), strO);
        }
        this.f213a = false;
        if (z2) {
            f().getClass();
            gb.c.f5123b.getClass();
            e7.a aVar = gb.c.f5124c;
            if (aVar != null) {
                Intrinsics.checkNotNullParameter("Atomic-AtomicBusiness", "tag");
                Intrinsics.checkNotNullParameter("cancel", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("Atomic-AtomicBusiness"), "cancel");
                }
                AtomicCoreUtils.cancelAtomicCoreData(aVar);
            }
        }
    }

    @Override // fb.a
    public void c(Application context, int i8, int i9, int i10) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter("Atomic-AtomicImpl", "tag");
        Intrinsics.checkNotNullParameter("updateTaskProgress", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("Atomic-AtomicImpl"), "updateTaskProgress");
        }
        gb.c.f5123b.getClass();
        gb.d dVar = gb.c.f5125d;
        if (dVar != null) {
            dVar.f5129c = i10;
            dVar.f5130d = i8;
            dVar.e = i9;
        }
        gb.a aVarF = f();
        y6.g gVarA = ((gb.f) ((Lazy) this.f215c).getValue()).a();
        JSONObject jSONObjectA = k3.f2.a(false);
        aVarF.getClass();
        gb.a.b(gVarA, jSONObjectA);
    }

    @Override // fb.a
    public void d(Application context, int i8, int i9, int i10, int i11) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter("Atomic-AtomicImpl", "tag");
        Intrinsics.checkNotNullParameter("updateProgress", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("Atomic-AtomicImpl"), "updateProgress");
        }
        if (this.f213a) {
            gb.c.f5123b.getClass();
            gb.d dVar = gb.c.f5125d;
            if (dVar != null) {
                dVar.f5127a = i8;
                dVar.f5129c = i9;
                dVar.f5130d = i10;
                dVar.e = i11;
            }
            gb.a aVarF = f();
            y6.g gVarA = ((gb.f) ((Lazy) this.f215c).getValue()).a();
            JSONObject jSONObjectA = k3.f2.a(false);
            aVarF.getClass();
            gb.a.b(gVarA, jSONObjectA);
            return;
        }
        this.f213a = true;
        gb.c cVar = gb.c.f5123b;
        eb.k1 k1Var = eb.k1.f4765a;
        hc.c cVar2 = eb.k1.e;
        if (cVar2 == null || (str = cVar2.f5287b) == null) {
            str = "";
        }
        gb.d dVar2 = new gb.d(str, i8, i9, i10, i11);
        cVar.getClass();
        gb.c.f5125d = dVar2;
        gb.a aVarF2 = f();
        y6.g gVarA2 = ((gb.f) ((Lazy) this.f215c).getValue()).a();
        aVarF2.getClass();
        gb.a.a(gVarA2);
    }

    @Override // fb.a
    public void e() {
        Intrinsics.checkNotNullParameter("Atomic-AtomicImpl", "tag");
        Intrinsics.checkNotNullParameter("showFail", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("Atomic-AtomicImpl"), "showFail");
        }
        gb.a aVarF = f();
        gb.f fVar = (gb.f) ((Lazy) this.f215c).getValue();
        fVar.getClass();
        Intrinsics.checkNotNullParameter("Atomic-SendBuilder", "tag");
        Intrinsics.checkNotNullParameter("buildSendFailed", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("Atomic-SendBuilder"), "buildSendFailed");
        }
        gb.c.f5123b.getClass();
        gb.d dVar = gb.c.f5125d;
        if (dVar != null) {
            fVar.f5135c = dVar;
        }
        String strA = fVar.f5135c.f5129c == 5 ? ee.a(fVar.b(), R$string.md_copy_fail, "") : ee.a(fVar.b(), R$string.md_transfer_fail, "");
        String strA2 = fVar.f5135c.f5129c == 5 ? ee.a(fVar.b(), R$string.md_share_to_device, fVar.f5135c.f5128b) : ee.a(fVar.b(), R$string.md_transfer_to_device, fVar.f5135c.f5128b);
        y6.g gVar = fVar.f5133a;
        k3.f2.c(gVar, "", "failed");
        k3.f2.b(gVar, strA, strA2, new gb.e("failed", ""));
        JSONObject jSONObjectD = k3.f2.d();
        aVarF.getClass();
        gb.a.b(gVar, jSONObjectD);
    }

    public gb.a f() {
        return (gb.a) ((Lazy) this.f214b).getValue();
    }

    public void g(ScheduledFuture scheduledFuture) {
        synchronized (this.f214b) {
            if (!this.f213a) {
                this.f215c = scheduledFuture;
            }
        }
    }

    public void h(boolean z2) {
        a2 a2Var = (a2) this.f214b;
        f2 f2Var = (f2) this.f215c;
        f2Var.getClass();
        f2Var.f267j.execute(new y1(f2Var, a2Var, z2));
    }

    public void i(ze.q2 q2Var) {
        f2 f2Var = (f2) this.f215c;
        f2Var.f266i.g(ze.h.INFO, "{0} SHUTDOWN with {1}", ((a2) this.f214b).d(), f2.i(q2Var));
        this.f213a = true;
        f2Var.f267j.execute(new e(16, this, q2Var));
    }

    public void j() {
        v8.n(this.f213a, "transportShutdown() must be called before transportTerminated().");
        f2 f2Var = (f2) this.f215c;
        ze.i iVar = f2Var.f266i;
        ze.h hVar = ze.h.INFO;
        a2 a2Var = (a2) this.f214b;
        iVar.g(hVar, "{0} Terminated", a2Var.d());
        ze.o0.b(f2Var.f264g.f11393d, a2Var);
        y1 y1Var = new y1(f2Var, a2Var, false);
        ze.v2 v2Var = f2Var.f267j;
        v2Var.execute(y1Var);
        v2Var.execute(new c2(this, 1));
    }

    public void k(q3.i iVar) {
        synchronized (this.f214b) {
            try {
                if (((ArrayDeque) this.f215c) == null) {
                    this.f215c = new ArrayDeque();
                }
                ((ArrayDeque) this.f215c).add(iVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void l(q3.f fVar) {
        q3.i iVar;
        synchronized (this.f214b) {
            if (((ArrayDeque) this.f215c) != null && !this.f213a) {
                this.f213a = true;
                while (true) {
                    synchronized (this.f214b) {
                        try {
                            iVar = (q3.i) ((ArrayDeque) this.f215c).poll();
                            if (iVar == null) {
                                this.f213a = false;
                                return;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    iVar.a(fVar);
                }
            }
        }
    }

    public d2(f2 f2Var, a2 a2Var) {
        this.f215c = f2Var;
        this.f213a = false;
        this.f214b = a2Var;
    }

    public d2(Object obj) {
        this.f214b = obj;
    }
}
