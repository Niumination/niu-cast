package u1;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;
import k3.od;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f5.a f10275a = f5.a.g("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f5.a f10276b = f5.a.g("k");

    /* JADX WARN: Code duplicated, block: B:22:0x0068  */
    /* JADX WARN: Code duplicated, block: B:24:0x0095  */
    /* JADX WARN: Code duplicated, block: B:26:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:76:0x019e  */
    /* JADX WARN: Multi-variable type inference failed */
    public static q1.d a(v1.e eVar, j1.j jVar) {
        q1.a aVar;
        q1.b bVarB;
        List list;
        q1.b bVar;
        q1.b bVar2;
        boolean z2;
        boolean z3 = false;
        Object[] objArr = eVar.s() == v1.c.BEGIN_OBJECT;
        if (objArr != false) {
            eVar.c();
        }
        q1.b bVar3 = null;
        q1.b bVarB2 = null;
        se.e eVarA = null;
        q1.e eVarB = null;
        q1.a aVar2 = null;
        q1.b bVarB3 = null;
        q1.a aVarD = null;
        q1.b bVarB4 = null;
        q1.b bVarB5 = null;
        while (eVar.i()) {
            switch (eVar.w(f10275a)) {
                case 0:
                    eVar.c();
                    while (eVar.i()) {
                        if (eVar.w(f10276b) != 0) {
                            eVar.A();
                            eVar.B();
                        } else {
                            eVarA = a.a(eVar, jVar);
                        }
                    }
                    eVar.h();
                    bVarB2 = bVarB2;
                    z3 = false;
                    break;
                case 1:
                    eVarB = a.b(eVar, jVar);
                    z3 = false;
                    break;
                case 2:
                    aVar2 = new q1.a(q.a(eVar, jVar, 1.0f, f.f10288i, z3), 4);
                    bVarB2 = bVarB2;
                    z3 = false;
                    break;
                case 3:
                    jVar.a("Lottie doesn't support 3D layers.");
                    bVarB = od.b(eVar, jVar, z3);
                    list = (List) bVarB.f574b;
                    if (list.isEmpty()) {
                        bVar = bVarB;
                        bVar2 = bVarB2;
                        if (((x1.a) list.get(z3 ? 1 : 0)).f10807b == null) {
                            z2 = false;
                            list.set(0, new x1.a(jVar, Float.valueOf(0.0f), Float.valueOf(0.0f), (Interpolator) null, 0.0f, Float.valueOf(jVar.f5974m)));
                        }
                        z3 = z2;
                        bVar3 = bVar;
                        bVarB2 = bVar2;
                    } else {
                        bVar = bVarB;
                        bVar2 = bVarB2;
                        list.add(new x1.a(jVar, Float.valueOf(0.0f), Float.valueOf(0.0f), (Interpolator) null, 0.0f, Float.valueOf(jVar.f5974m)));
                    }
                    z2 = false;
                    z3 = z2;
                    bVar3 = bVar;
                    bVarB2 = bVar2;
                    break;
                case 4:
                    bVarB = od.b(eVar, jVar, z3);
                    list = (List) bVarB.f574b;
                    if (list.isEmpty()) {
                        bVar = bVarB;
                        bVar2 = bVarB2;
                        if (((x1.a) list.get(z3 ? 1 : 0)).f10807b == null) {
                            z2 = false;
                            list.set(0, new x1.a(jVar, Float.valueOf(0.0f), Float.valueOf(0.0f), (Interpolator) null, 0.0f, Float.valueOf(jVar.f5974m)));
                        }
                        z3 = z2;
                        bVar3 = bVar;
                        bVarB2 = bVar2;
                    } else {
                        bVar = bVarB;
                        bVar2 = bVarB2;
                        list.add(new x1.a(jVar, Float.valueOf(0.0f), Float.valueOf(0.0f), (Interpolator) null, 0.0f, Float.valueOf(jVar.f5974m)));
                    }
                    z2 = false;
                    z3 = z2;
                    bVar3 = bVar;
                    bVarB2 = bVar2;
                    break;
                case 5:
                    aVarD = od.d(eVar, jVar);
                    break;
                case 6:
                    bVarB4 = od.b(eVar, jVar, z3);
                    break;
                case 7:
                    bVarB5 = od.b(eVar, jVar, z3);
                    break;
                case 8:
                    bVarB3 = od.b(eVar, jVar, z3);
                    break;
                case 9:
                    bVarB2 = od.b(eVar, jVar, z3);
                    break;
                default:
                    eVar.A();
                    eVar.B();
                    break;
            }
        }
        q1.b bVar4 = bVarB2;
        if (objArr != false) {
            eVar.h();
        }
        se.e eVar2 = (eVarA == null || (eVarA.isStatic() && ((PointF) ((x1.a) ((ArrayList) eVarA.f9720b).get(0)).f10807b).equals(0.0f, 0.0f))) ? null : eVarA;
        q1.e eVar3 = (eVarB == null || (!(eVarB instanceof q1.c) && eVarB.isStatic() && ((PointF) ((x1.a) eVarB.getKeyframes().get(0)).f10807b).equals(0.0f, 0.0f))) ? null : eVarB;
        if (bVar3 == null || (bVar3.isStatic() && ((Float) ((x1.a) ((List) bVar3.f574b).get(0)).f10807b).floatValue() == 0.0f)) {
            bVar3 = null;
        }
        if (aVar2 == null) {
            aVar = null;
        } else {
            if (aVar2.isStatic()) {
                x1.d dVar = (x1.d) ((x1.a) ((List) aVar2.f574b).get(0)).f10807b;
                if (dVar.f10826a == 1.0f && dVar.f10827b == 1.0f) {
                    aVar = null;
                }
            }
            aVar = aVar2;
        }
        return new q1.d(eVar2, eVar3, aVar, bVar3, aVarD, bVarB4, bVarB5, (bVarB3 == null || (bVarB3.isStatic() && ((Float) ((x1.a) ((List) bVarB3.f574b).get(0)).f10807b).floatValue() == 0.0f)) ? null : bVarB3, (bVar4 == 0 || (bVar4.isStatic() && ((Float) ((x1.a) ((List) bVar4.f574b).get(0)).f10807b).floatValue() == 0.0f)) ? null : bVar4);
    }
}
