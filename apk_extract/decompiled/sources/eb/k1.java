package eb;

import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketServer;
import com.transsion.iotservice.multiscreen.pc.state.BaseState;
import com.transsion.iotservice.multiscreen.pc.state.Initial;
import com.transsion.iotservice.multiscreen.pc.state.PhysicalConnected;
import com.transsion.iotservice.multiscreen.pc.state.PhysicalConnecting;
import com.transsion.iotservice.multiscreen.pc.state.PhysicalScanning;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.QrConnectFailedDialog;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.UsbConnectFailDialog;
import k3.gc;
import k3.gd;
import k3.pb;
import k3.ub;
import k3.y8;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class k1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f4766b = "none";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f4767c = "";
    public static volatile hc.c e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k1 f4765a = new k1();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gc.b f4768d = new gc.b();
    public static final qi.c f = li.h0.a(li.v0.f7499b);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final j1 f4769g = new j1();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:18:0x0032 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x003d A[RETURN, SYNTHETIC] */
    public static int e() {
        switch (f4766b) {
            case "ble_from_peer":
                return 4;
            case "qr":
                return 8;
            case "ble":
                return 2;
            case "nfc":
                return 8;
            case "cable":
                return 16;
            default:
                return 0;
        }
    }

    public static Object g(hc.c cVar, ContinuationImpl continuationImpl) {
        String log = "onConnected:" + cVar + " IP:" + f4767c;
        Intrinsics.checkNotNullParameter("PhysicalConnectManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("PhysicalConnectManager"), log);
        }
        y yVar = y.f4799a;
        y.i("onConnected");
        int i8 = cVar.e;
        String log2 = "isAirCast:" + (i8 == 8) + " serviceType : " + i8;
        Intrinsics.checkNotNullParameter("PhysicalConnectManager", "tag");
        Intrinsics.checkNotNullParameter(log2, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("PhysicalConnectManager"), log2);
        }
        if (i8 == 8) {
            y.f = 6;
        } else if (y.f != 3 && y.f != 4 && y.f != 5) {
            y.f = 0;
            String strM = o.d.m("setLinkType:", "ConnectionManager", "tag", "log", y.f);
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("ConnectionManager"), strM);
            }
        }
        if (!Intrinsics.areEqual(y.f4804h, new PhysicalConnecting())) {
            return Unit.INSTANCE;
        }
        e = cVar;
        Object objF = yVar.f(continuationImpl);
        return objF == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objF : Unit.INSTANCE;
    }

    public static Unit i() {
        li.l0.p(f, si.e.f10118a, null, new i1(null), 2);
        return Unit.INSTANCE;
    }

    public static void j(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        String log = h0.a.k("updateConnectType:now type:", f4766b, " target type:", type);
        Intrinsics.checkNotNullParameter("PhysicalConnectManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("PhysicalConnectManager"), log);
        }
        if (Intrinsics.areEqual(f4766b, "cable") && Intrinsics.areEqual(type, "none")) {
            na.n.b(false);
        }
        f4766b = type;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ec A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
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
    public final Object a(hc.a aVar, ContinuationImpl continuationImpl) {
        z0 z0Var;
        hc.c cVar;
        k1 k1Var;
        hc.c cVar2;
        hc.b bVar;
        String log;
        if (continuationImpl instanceof z0) {
            z0Var = (z0) continuationImpl;
            int i8 = z0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                z0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                z0Var = new z0(this, continuationImpl);
            }
        } else {
            z0Var = new z0(this, continuationImpl);
        }
        Object objA = z0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = z0Var.label;
        if (i9 != 0) {
            if (i9 == 1) {
                hc.c cVar3 = (hc.c) z0Var.L$1;
                this = (k1) z0Var.L$0;
                ResultKt.throwOnFailure(objA);
                cVar = cVar3;
            } else {
                if (i9 != 2) {
                    if (i9 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    hc.b bVar2 = (hc.b) z0Var.L$0;
                    ResultKt.throwOnFailure(objA);
                    return bVar2;
                }
                hc.c cVar4 = (hc.c) z0Var.L$1;
                k1 k1Var2 = (k1) z0Var.L$0;
                ResultKt.throwOnFailure(objA);
                cVar2 = cVar4;
                k1Var = k1Var2;
            }
            bVar = (hc.b) objA;
            log = "connectWithBle:get connect result device:" + bVar;
            Intrinsics.checkNotNullParameter("PhysicalConnectManager", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("PhysicalConnectManager"), log);
            }
            z0Var.L$0 = bVar;
            z0Var.L$1 = null;
            z0Var.label = 3;
            if (k1Var.h(bVar, cVar2, z0Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return bVar;
        }
        ResultKt.throwOnFailure(objA);
        y yVar = y.f4799a;
        y.i("connectWithBle");
        if (y.f4804h.compareTo((BaseState) new PhysicalScanning()) > 0) {
            Intrinsics.checkNotNullParameter("PhysicalConnectManager", "tag");
            Intrinsics.checkNotNullParameter("connectWithBle:not scanning state", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("PhysicalConnectManager"), "connectWithBle:not scanning state");
            }
            return new hc.b(false, "failed", null, null, 0, null, 0, 0, null, TypedValues.PositionType.TYPE_CURVE_FIT);
        }
        e = aVar;
        z0Var.L$0 = this;
        z0Var.L$1 = aVar;
        z0Var.label = 1;
        if (y.g(z0Var) == coroutine_suspended) {
            cVar = aVar;
            return coroutine_suspended;
        }
        cVar = aVar;
        gc.b bVar3 = f4768d;
        z0Var.L$0 = this;
        z0Var.L$1 = cVar;
        z0Var.label = 2;
        objA = bVar3.a(cVar, z0Var);
        if (objA == coroutine_suspended) {
            return coroutine_suspended;
        }
        hc.c cVar5 = cVar;
        k1Var = this;
        cVar2 = cVar5;
        bVar = (hc.b) objA;
        log = "connectWithBle:get connect result device:" + bVar;
        Intrinsics.checkNotNullParameter("PhysicalConnectManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("PhysicalConnectManager"), log);
        }
        z0Var.L$0 = bVar;
        z0Var.L$1 = null;
        z0Var.label = 3;
        if (k1Var.h(bVar, cVar2, z0Var) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return bVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(hc.a aVar, ContinuationImpl continuationImpl) {
        a1 a1Var;
        if (continuationImpl instanceof a1) {
            a1Var = (a1) continuationImpl;
            int i8 = a1Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                a1Var.label = i8 - Integer.MIN_VALUE;
            } else {
                a1Var = new a1(this, continuationImpl);
            }
        } else {
            a1Var = new a1(this, continuationImpl);
        }
        Object objR = a1Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = a1Var.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(objR);
            a1Var.L$0 = this;
            a1Var.L$1 = aVar;
            a1Var.label = 1;
            li.l lVar = new li.l(1, IntrinsicsKt.intercepted(a1Var));
            lVar.s();
            f1 f1Var = new f1(lVar, null);
            qi.c cVar = f;
            li.g2 g2VarP = li.l0.p(cVar, null, null, f1Var, 3);
            li.l0.p(cVar, null, null, new d1(new e1(aVar, lVar, 0), lVar, g2VarP, null), 3);
            t0 t0Var = new t0(g2VarP, 2);
            lVar.v(t0Var);
            na.a.a(lVar, t0Var);
            objR = lVar.r();
            if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(a1Var);
            }
            if (objR == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                if (i9 == 2) {
                    ResultKt.throwOnFailure(objR);
                    return new hc.b(false, null, null, null, 0, null, 0, 0, null, TypedValues.PositionType.TYPE_POSITION_TYPE);
                }
                if (i9 == 3) {
                    ResultKt.throwOnFailure(objR);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            aVar = (hc.a) a1Var.L$1;
            this = (k1) a1Var.L$0;
            ResultKt.throwOnFailure(objR);
        }
        if (objR == null) {
            a1Var.L$0 = null;
            a1Var.L$1 = null;
            a1Var.label = 2;
            if (this.f(true, a1Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return new hc.b(false, null, null, null, 0, null, 0, 0, null, TypedValues.PositionType.TYPE_POSITION_TYPE);
        }
        this.getClass();
        j("nfc");
        a1Var.L$0 = null;
        a1Var.L$1 = null;
        a1Var.label = 3;
        objR = this.a(aVar, a1Var);
        return objR == coroutine_suspended ? coroutine_suspended : objR;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:33:0x00dd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x00de  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object c(hc.c cVar, String str, ContinuationImpl continuationImpl) {
        b1 b1Var;
        hc.b bVar;
        String log;
        hc.c cVarA;
        if (continuationImpl instanceof b1) {
            b1Var = (b1) continuationImpl;
            int i8 = b1Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                b1Var.label = i8 - Integer.MIN_VALUE;
            } else {
                b1Var = new b1(this, continuationImpl);
            }
        } else {
            b1Var = new b1(this, continuationImpl);
        }
        Object objA = b1Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = b1Var.label;
        if (i9 != 0) {
            if (i9 == 1) {
                cVar = (hc.c) b1Var.L$1;
                this = (k1) b1Var.L$0;
                ResultKt.throwOnFailure(objA);
            } else {
                if (i9 != 2) {
                    if (i9 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    hc.b bVar2 = (hc.b) b1Var.L$0;
                    ResultKt.throwOnFailure(objA);
                    return bVar2;
                }
                this = (k1) b1Var.L$0;
                ResultKt.throwOnFailure(objA);
            }
            bVar = (hc.b) objA;
            log = "connectWithP2P: connect result device:" + bVar;
            Intrinsics.checkNotNullParameter("PhysicalConnectManager", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("PhysicalConnectManager"), log);
            }
            cVarA = y8.a(bVar);
            b1Var.L$0 = bVar;
            b1Var.label = 3;
            if (this.h(bVar, cVarA, b1Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return bVar;
        }
        ResultKt.throwOnFailure(objA);
        y yVar = y.f4799a;
        y.i("connectWithP2P");
        if (y.f4804h.compareTo((BaseState) new PhysicalScanning()) > 0) {
            ob.b.f8417b.n(cVar.f5288c, cVar.f5286a);
            return new hc.b(false, null, null, null, 0, null, 0, 0, null, TypedValues.PositionType.TYPE_POSITION_TYPE);
        }
        e = cVar;
        j(str);
        b1Var.L$0 = this;
        b1Var.L$1 = cVar;
        b1Var.label = 1;
        if (y.g(b1Var) == coroutine_suspended) {
            return coroutine_suspended;
        }
        gc.b bVar3 = f4768d;
        b1Var.L$0 = this;
        b1Var.L$1 = null;
        b1Var.label = 2;
        objA = bVar3.a(cVar, b1Var);
        if (objA == coroutine_suspended) {
            return coroutine_suspended;
        }
        bVar = (hc.b) objA;
        log = "connectWithP2P: connect result device:" + bVar;
        Intrinsics.checkNotNullParameter("PhysicalConnectManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("PhysicalConnectManager"), log);
        }
        cVarA = y8.a(bVar);
        b1Var.L$0 = bVar;
        b1Var.label = 3;
        if (this.h(bVar, cVarA, b1Var) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return bVar;
    }

    /* JADX WARN: Code duplicated, block: B:61:0x01e8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:64:0x0203  */
    /* JADX WARN: Code duplicated, block: B:67:0x0210  */
    /* JADX WARN: Code duplicated, block: B:69:0x0220 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:70:0x0221  */
    /* JADX WARN: Code duplicated, block: B:72:0x0223  */
    /* JADX WARN: Code duplicated, block: B:74:0x0239 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:75:0x023a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object d(ContinuationImpl continuationImpl) throws Throwable {
        c1 c1Var;
        k1 k1Var;
        hc.e eVar;
        hc.b bVar;
        String log;
        hc.b bVar2;
        k1 k1Var2 = this;
        if (continuationImpl instanceof c1) {
            c1Var = (c1) continuationImpl;
            int i8 = c1Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                c1Var.label = i8 - Integer.MIN_VALUE;
            } else {
                c1Var = new c1(k1Var2, continuationImpl);
            }
        } else {
            c1Var = new c1(k1Var2, continuationImpl);
        }
        Object objU = c1Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = c1Var.label;
        if (i9 != 0) {
            if (i9 == 1) {
                k1Var2 = (k1) c1Var.L$0;
                ResultKt.throwOnFailure(objU);
            } else if (i9 == 2) {
                eVar = (hc.e) c1Var.L$1;
                k1Var = (k1) c1Var.L$0;
                ResultKt.throwOnFailure(objU);
                gc.b bVar3 = f4768d;
                c1Var.L$0 = k1Var;
                c1Var.L$1 = eVar;
                c1Var.label = 3;
                objU = bVar3.a(eVar, c1Var);
                if (objU == coroutine_suspended) {
                    return coroutine_suspended;
                }
                bVar = (hc.b) objU;
                log = "get connect result device:" + bVar;
                Intrinsics.checkNotNullParameter("PhysicalConnectManager", "tag");
                Intrinsics.checkNotNullParameter(log, "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("PhysicalConnectManager"), log);
                }
                if (bVar.f5279a) {
                    c1Var.L$0 = bVar;
                    c1Var.L$1 = null;
                    c1Var.label = 4;
                    k1Var.getClass();
                    if (g(eVar, c1Var) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return bVar;
                }
                int i10 = UsbConnectFailDialog.e;
                gd.a(pb.a());
                c1Var.L$0 = bVar;
                c1Var.L$1 = null;
                c1Var.label = 5;
                if (k1Var.f(false, c1Var) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                bVar2 = bVar;
            } else if (i9 == 3) {
                eVar = (hc.e) c1Var.L$1;
                k1Var = (k1) c1Var.L$0;
                ResultKt.throwOnFailure(objU);
                bVar = (hc.b) objU;
                log = "get connect result device:" + bVar;
                Intrinsics.checkNotNullParameter("PhysicalConnectManager", "tag");
                Intrinsics.checkNotNullParameter(log, "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("PhysicalConnectManager"), log);
                }
                if (bVar.f5279a) {
                    c1Var.L$0 = bVar;
                    c1Var.L$1 = null;
                    c1Var.label = 4;
                    k1Var.getClass();
                    if (g(eVar, c1Var) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return bVar;
                }
                int i11 = UsbConnectFailDialog.e;
                gd.a(pb.a());
                c1Var.L$0 = bVar;
                c1Var.L$1 = null;
                c1Var.label = 5;
                if (k1Var.f(false, c1Var) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                bVar2 = bVar;
            } else {
                if (i9 == 4) {
                    hc.b bVar4 = (hc.b) c1Var.L$0;
                    ResultKt.throwOnFailure(objU);
                    return bVar4;
                }
                if (i9 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bVar2 = (hc.b) c1Var.L$0;
                ResultKt.throwOnFailure(objU);
            }
            sj.a aVar = jc.a.f6146a;
            jc.a.b(f4769g);
            y0.b("cable connect failed");
            return bVar2;
        }
        ResultKt.throwOnFailure(objU);
        y yVar = y.f4799a;
        y.i("connectWithUsb");
        if (y.f4804h.compareTo((BaseState) new Initial()) > 0) {
            Intrinsics.checkNotNullParameter("PhysicalConnectManager", "tag");
            Intrinsics.checkNotNullParameter("connectWithUsb:isConnected already.", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("PhysicalConnectManager"), "connectWithUsb:isConnected already.");
            }
            na.k kVar = na.k.f8141a;
            Application applicationA = pb.a();
            String string = pb.a().getString(R$string.module_this_pc_using);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            kVar.b(applicationA, string);
            return new hc.b(false, null, null, null, 0, null, 0, 0, null, TypedValues.PositionType.TYPE_POSITION_TYPE);
        }
        if (ub.b()) {
            Intrinsics.checkNotNullParameter("PhysicalConnectManager", "tag");
            Intrinsics.checkNotNullParameter("connectWithUsb:wifi hotspot open.", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("PhysicalConnectManager"), "connectWithUsb:wifi hotspot open.");
            }
            na.k kVar2 = na.k.f8141a;
            Application applicationA2 = pb.a();
            String string2 = pb.a().getResources().getString(R$string.module_pc_close_hotspot_conn_toast);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            kVar2.d(applicationA2, string2);
            return new hc.b(false, null, null, null, 0, null, 0, 0, null, TypedValues.PositionType.TYPE_POSITION_TYPE);
        }
        j("cable");
        Lazy lazy = na.m.f8144a;
        c1Var.L$0 = k1Var2;
        c1Var.label = 1;
        if (na.m.b() != null) {
            objU = Boxing.boxBoolean(true);
        } else {
            na.m.c();
            if (na.m.f8145b) {
                objU = li.l0.u(li.v0.f7499b, new na.l(null), c1Var);
            } else {
                Intrinsics.checkNotNullParameter("TranNetApiProxy", "tag");
                Intrinsics.checkNotNullParameter("ensureInit : new tran net not supported", "log");
                if (gc.f6462a <= 6) {
                    Log.e(gc.f6463b.concat("TranNetApiProxy"), "ensureInit : new tran net not supported");
                }
                objU = Boxing.boxBoolean(false);
            }
        }
        if (objU == coroutine_suspended) {
            return coroutine_suspended;
        }
        if (!((Boolean) objU).booleanValue()) {
            Intrinsics.checkNotNullParameter("PhysicalConnectManager", "tag");
            Intrinsics.checkNotNullParameter("connectWithUsb:TranNetApiProxy not support", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("PhysicalConnectManager"), "connectWithUsb:TranNetApiProxy not support");
            }
            na.k kVar3 = na.k.f8141a;
            Application applicationA3 = pb.a();
            String string3 = pb.a().getString(R$string.module_pc_connect_fail);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            kVar3.b(applicationA3, string3);
            k1Var2.getClass();
            j("none");
            return new hc.b(false, null, null, null, 0, null, 0, 0, null, TypedValues.PositionType.TYPE_POSITION_TYPE);
        }
        hc.e eVar2 = new hc.e();
        e = eVar2;
        sj.a aVar2 = jc.a.f6146a;
        jc.a.a(f4769g);
        y0 y0Var = y0.f4813a;
        y0.d("cable connecting");
        y yVar2 = y.f4799a;
        c1Var.L$0 = k1Var2;
        c1Var.L$1 = eVar2;
        c1Var.label = 2;
        if (y.g(c1Var) == coroutine_suspended) {
            return coroutine_suspended;
        }
        k1Var = k1Var2;
        eVar = eVar2;
        gc.b bVar5 = f4768d;
        c1Var.L$0 = k1Var;
        c1Var.L$1 = eVar;
        c1Var.label = 3;
        objU = bVar5.a(eVar, c1Var);
        if (objU == coroutine_suspended) {
            return coroutine_suspended;
        }
        bVar = (hc.b) objU;
        log = "get connect result device:" + bVar;
        Intrinsics.checkNotNullParameter("PhysicalConnectManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("PhysicalConnectManager"), log);
        }
        if (bVar.f5279a) {
            c1Var.L$0 = bVar;
            c1Var.L$1 = null;
            c1Var.label = 4;
            k1Var.getClass();
            if (g(eVar, c1Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return bVar;
        }
        int i12 = UsbConnectFailDialog.e;
        gd.a(pb.a());
        c1Var.L$0 = bVar;
        c1Var.L$1 = null;
        c1Var.label = 5;
        if (k1Var.f(false, c1Var) == coroutine_suspended) {
            return coroutine_suspended;
        }
        bVar2 = bVar;
        sj.a aVar3 = jc.a.f6146a;
        jc.a.b(f4769g);
        y0.b("cable connect failed");
        return bVar2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object f(boolean z2, ContinuationImpl continuationImpl) {
        g1 g1Var;
        int i8;
        if (continuationImpl instanceof g1) {
            g1Var = (g1) continuationImpl;
            int i9 = g1Var.label;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                g1Var.label = i9 - Integer.MIN_VALUE;
            } else {
                g1Var = new g1(this, continuationImpl);
            }
        } else {
            g1Var = new g1(this, continuationImpl);
        }
        Object obj = g1Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = g1Var.label;
        if (i10 != 0) {
            if (i10 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        BaseState baseState = y.f4804h;
        String str = f4766b;
        hc.c cVar = e;
        String log = "onConnectFailed:" + baseState + " connectType:" + str + " serviceType:" + (cVar != null ? Boxing.boxInt(cVar.e) : null);
        Intrinsics.checkNotNullParameter("PhysicalConnectManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("PhysicalConnectManager"), log);
        }
        if (TextUtils.equals(f4766b, "qr")) {
            TCCPHandshakeSocketServer tCCPHandshakeSocketServer = l2.f4772a;
            l2.d();
            Function1 function1 = QrConnectFailedDialog.f2754c;
            Application context = pb.a();
            hc.c cVar2 = e;
            Integer numBoxInt = cVar2 != null ? Boxing.boxInt(cVar2.e) : null;
            if (numBoxInt != null && numBoxInt.intValue() == 8) {
                i8 = 6;
            } else {
                if (numBoxInt != null) {
                    numBoxInt.intValue();
                }
                i8 = 0;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            QrConnectFailedDialog.f2754c = null;
            Intent intent = new Intent(context, (Class<?>) QrConnectFailedDialog.class);
            intent.setFlags(268435456);
            intent.putExtra("serviceType", i8);
            context.startActivity(intent);
        }
        f4767c = "";
        if (!Intrinsics.areEqual(y.f4804h, new PhysicalConnecting()) && (!Intrinsics.areEqual(f4766b, "ble_from_peer") || baseState.compareTo((BaseState) new PhysicalConnected()) >= 0)) {
            return Unit.INSTANCE;
        }
        if (z2) {
            ob.b bVar = ob.b.f8417b;
            hc.c cVar3 = e;
            String str2 = cVar3 != null ? cVar3.f5288c : null;
            hc.c cVar4 = e;
            bVar.n(str2, cVar4 != null ? cVar4.f5286a : null);
        }
        g1Var.label = 1;
        if (i() == coroutine_suspended) {
            return coroutine_suspended;
        }
        y yVar = y.f4799a;
        g1Var.label = 2;
        if (y.f4799a.j("onConnectFailed", true, g1Var) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    public final Object h(hc.b bVar, hc.c cVar, ContinuationImpl continuationImpl) {
        ob.b.f8417b.getClass();
        Intrinsics.checkNotNullParameter("start_from_phone", "startFrom");
        ob.b.f8422i = "start_from_phone";
        if (bVar.f5279a) {
            String str = bVar.f5282d;
            if (!StringsKt.isBlank(str)) {
                f4767c = str;
                Object objG = g(cVar, continuationImpl);
                return objG == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objG : Unit.INSTANCE;
            }
        }
        Object objF = f(true, continuationImpl);
        return objF == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objF : Unit.INSTANCE;
    }
}
