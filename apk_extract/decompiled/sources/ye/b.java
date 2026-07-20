package ye;

import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;
import androidx.work.WorkRequest;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import k3.lb;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import se.d4;
import se.g4;
import se.h4;
import se.i2;
import se.m6;
import se.o6;
import we.m;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements WifiP2pManager.ActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f11168b;

    public /* synthetic */ b(d dVar, int i8) {
        this.f11167a = i8;
        this.f11168b = dVar;
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
    public final void onFailure(int i8) {
        switch (this.f11167a) {
            case 0:
                String strH = o.d.h(i8, "connect failed: ", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("welinkBLE", strH, null);
                }
                d dVar = this.f11168b;
                dVar.f11184o = 0;
                dVar.f11180k = null;
                dVar.p = null;
                g4 g4Var = dVar.f11174c;
                if (g4Var != null) {
                    g4Var.a(i8);
                }
                break;
            case 1:
                we.h.g("createGroup onFailure");
                g4 g4Var2 = this.f11168b.f11174c;
                if (g4Var2 != null) {
                    g4Var2.c();
                }
                break;
            case 2:
                String strH2 = o.d.h(i8, "disconnect P2P onFailure:", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("welinkBLE", strH2, null);
                }
                g4 g4Var3 = this.f11168b.f11174c;
                if (g4Var3 != null) {
                    g4Var3.d(false);
                }
                break;
            case 3:
                we.h.g("removeGroup onFailure");
                d dVar2 = this.f11168b;
                dVar2.f11184o = 0;
                dVar2.f11180k = null;
                dVar2.p = null;
                g4 g4Var4 = dVar2.f11174c;
                Intrinsics.checkNotNull(g4Var4);
                g4Var4.a(i8);
                break;
            case 4:
                we.h.g("removeGroup onFailure");
                d dVar3 = this.f11168b;
                dVar3.f11179j = null;
                dVar3.f11180k = null;
                g4 g4Var5 = dVar3.f11174c;
                if (g4Var5 != null) {
                    g4Var5.c();
                }
                break;
            case 5:
                we.h.g("removeGroup onFailure");
                d dVar4 = this.f11168b;
                dVar4.f11179j = null;
                dVar4.f11180k = null;
                g4 g4Var6 = dVar4.f11174c;
                if (g4Var6 != null) {
                    g4Var6.e(i8);
                }
                break;
            default:
                String strH3 = o.d.h(i8, "removeGroup onFailure:", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("welinkBLE", strH3, null);
                }
                g4 g4Var7 = this.f11168b.f11174c;
                if (g4Var7 != null) {
                    g4Var7.e(i8);
                }
                break;
        }
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
    public final void onSuccess() {
        int i8 = 3;
        switch (this.f11167a) {
            case 0:
                we.h.g("connect onSuccess");
                d dVar = this.f11168b;
                dVar.f11184o = 1;
                g4 g4Var = dVar.f11174c;
                if (g4Var != null) {
                    we.h.h("NearP2pManager", "onConnectSuccess");
                    ka.d dVar2 = g4Var.f9745a.f9766i;
                    if (dVar2 != null) {
                        we.h.b((String) dVar2.f6817b, "GroupClientConnectingResult result=true");
                        h4 h4Var = (h4) dVar2.f6816a;
                        if (h4Var != null) {
                            m6 newState = new m6();
                            Intrinsics.checkNotNullParameter(newState, "newState");
                            h4Var.f9764g = newState;
                        }
                    }
                    h4 h4Var2 = g4Var.f9745a;
                    h4Var2.getClass();
                    b0.b bVar = new b0.b(100, i8, h4Var2);
                    ConcurrentHashMap concurrentHashMap = m.f10734a;
                    m.a(256, WorkRequest.MIN_BACKOFF_MILLIS, h4Var2.a(), bVar);
                    ConcurrentHashMap.KeySetView keySetView = g4Var.f9745a.f9767j;
                    Intrinsics.checkNotNullExpressionValue(keySetView, "access$getExecutorListenerPairs$p(...)");
                    h4 h4Var3 = g4Var.f9745a;
                    synchronized (keySetView) {
                        try {
                            ConcurrentHashMap.KeySetView<Pair> keySetView2 = h4Var3.f9767j;
                            Intrinsics.checkNotNullExpressionValue(keySetView2, "access$getExecutorListenerPairs$p(...)");
                            for (Pair pair : keySetView2) {
                                ((Executor) pair.getFirst()).execute(new d4(pair, 3));
                            }
                            Unit unit = Unit.INSTANCE;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    return;
                }
                return;
            case 1:
                we.h.g("createGroup onSuccess");
                g4 g4Var2 = this.f11168b.f11174c;
                if (g4Var2 != null) {
                    we.h.h("NearP2pManager", "onCreateGroupSuccess");
                    ka.d dVar3 = g4Var2.f9745a.f9766i;
                    if (dVar3 != null) {
                        we.h.b((String) dVar3.f6817b, "CreatingGroupOwnerResult success=true");
                        h4 h4Var4 = (h4) dVar3.f6816a;
                        if (h4Var4 != null) {
                            o6 newState2 = new o6();
                            Intrinsics.checkNotNullParameter(newState2, "newState");
                            h4Var4.f9765h = newState2;
                        }
                    }
                    h4 h4Var5 = g4Var2.f9745a;
                    ConcurrentHashMap.KeySetView executorListenerPairs = h4Var5.f9767j;
                    Intrinsics.checkNotNullExpressionValue(executorListenerPairs, "executorListenerPairs");
                    synchronized (executorListenerPairs) {
                        try {
                            ConcurrentHashMap.KeySetView<Pair> executorListenerPairs2 = h4Var5.f9767j;
                            Intrinsics.checkNotNullExpressionValue(executorListenerPairs2, "executorListenerPairs");
                            for (Pair pair2 : executorListenerPairs2) {
                                ((Executor) pair2.getFirst()).execute(new d4(pair2, 2));
                            }
                            Unit unit2 = Unit.INSTANCE;
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                    return;
                }
                return;
            case 2:
                we.h.g("disconnect P2P onSuccess");
                d dVar4 = this.f11168b;
                dVar4.f11184o = 0;
                dVar4.p = null;
                g4 g4Var3 = dVar4.f11174c;
                if (g4Var3 != null) {
                    g4Var3.d(false);
                    return;
                }
                return;
            case 3:
                we.h.g("removeGroup onSuccess");
                d dVar5 = this.f11168b;
                dVar5.b(dVar5.f11176g, dVar5.f11177h, dVar5.e, dVar5.f11175d, dVar5.f);
                return;
            case 4:
                we.h.g("removeGroup onSuccess, create new group now");
                d dVar6 = this.f11168b;
                g4 g4Var4 = dVar6.f11174c;
                if (g4Var4 != null) {
                    List list = dVar6.f11178i;
                    i2 i2Var = dVar6.f11179j;
                    h4 h4Var6 = g4Var4.f9745a;
                    synchronized (g4Var4) {
                        we.h.h("NearP2pManager", "Group Removed, start timer to delay create group again");
                        a0.g gVar = new a0.g(h4Var6, 18, list, i2Var);
                        ConcurrentHashMap concurrentHashMap2 = m.f10734a;
                        m.a(259, 1100L, h4Var6.a(), gVar);
                        Unit unit3 = Unit.INSTANCE;
                    }
                    return;
                }
                return;
            case 5:
                we.h.g("removeGroup onSuccess");
                d dVar7 = this.f11168b;
                dVar7.getClass();
                we.h.g("Removing persistent groups, nothing to do");
                dVar7.f11179j = null;
                dVar7.f11180k = null;
                g4 g4Var5 = dVar7.f11174c;
                if (g4Var5 != null) {
                    g4Var5.f();
                    return;
                }
                return;
            default:
                we.h.g("removeGroup onSuccess");
                d dVar8 = this.f11168b;
                dVar8.getClass();
                we.h.g("Removing persistent groups, nothing to do");
                g4 g4Var6 = dVar8.f11174c;
                if (g4Var6 != null) {
                    g4Var6.f();
                }
                dVar8.p = null;
                dVar8.f11179j = null;
                return;
        }
    }
}
