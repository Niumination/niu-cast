package af;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class d3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f3 f217b;

    public /* synthetic */ d3(f3 f3Var, int i8) {
        this.f216a = i8;
        this.f217b = f3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList;
        switch (this.f216a) {
            case 0:
                f3 f3Var = this.f217b;
                if (f3Var.f281d.A == null) {
                    AtomicReference atomicReference = f3Var.f278a;
                    if (atomicReference.get() == j3.f344i0) {
                        atomicReference.set(null);
                    }
                    f3Var.f281d.E.a(j3.f0);
                    return;
                }
                return;
            case 1:
                if (this.f217b.f278a.get() == j3.f344i0) {
                    this.f217b.f278a.set(null);
                }
                LinkedHashSet linkedHashSet = this.f217b.f281d.A;
                if (linkedHashSet != null) {
                    Iterator it = linkedHashSet.iterator();
                    while (it.hasNext()) {
                        ((e3) it.next()).a("Channel is forcefully shutdown", null);
                    }
                }
                r rVar = this.f217b.f281d.E;
                ze.q2 q2Var = j3.f342e0;
                rVar.a(q2Var);
                synchronized (rVar.f538a) {
                    arrayList = new ArrayList((HashSet) rVar.f539b);
                    break;
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((b0) it2.next()).h(q2Var);
                }
                ((j3) rVar.f541d).D.a(q2Var);
                return;
            default:
                this.f217b.f281d.m();
                return;
        }
    }
}
