package lo;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import dp.f;
import eo.e;
import eo.k0;
import hp.d;
import kn.l0;
import mo.b;
import mo.c;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final void a(@l c cVar, @l b bVar, @l e eVar, @l f fVar) {
        mo.a location;
        mo.e position;
        l0.p(cVar, "<this>");
        l0.p(bVar, TypedValues.TransitionType.S_FROM);
        l0.p(eVar, "scopeOwner");
        l0.p(fVar, "name");
        if (cVar == c.a.f10855a || (location = bVar.getLocation()) == null) {
            return;
        }
        if (cVar.a()) {
            position = location.getPosition();
        } else {
            mo.e.Companion.getClass();
            position = mo.e.f10857a;
        }
        mo.e eVar2 = position;
        String strA = location.a();
        String strB = d.m(eVar).b();
        l0.o(strB, "getFqName(scopeOwner).asString()");
        mo.f fVar2 = mo.f.CLASSIFIER;
        String strB2 = fVar.b();
        l0.o(strB2, "name.asString()");
        cVar.b(strA, eVar2, strB, fVar2, strB2);
    }

    public static final void b(@l c cVar, @l b bVar, @l k0 k0Var, @l f fVar) {
        l0.p(cVar, "<this>");
        l0.p(bVar, TypedValues.TransitionType.S_FROM);
        l0.p(k0Var, "scopeOwner");
        l0.p(fVar, "name");
        String strB = k0Var.e().b();
        l0.o(strB, "scopeOwner.fqName.asString()");
        String strB2 = fVar.b();
        l0.o(strB2, "name.asString()");
        c(cVar, bVar, strB, strB2);
    }

    public static final void c(@l c cVar, @l b bVar, @l String str, @l String str2) {
        mo.a location;
        mo.e position;
        l0.p(cVar, "<this>");
        l0.p(bVar, TypedValues.TransitionType.S_FROM);
        l0.p(str, "packageFqName");
        l0.p(str2, "name");
        if (cVar == c.a.f10855a || (location = bVar.getLocation()) == null) {
            return;
        }
        if (cVar.a()) {
            position = location.getPosition();
        } else {
            mo.e.Companion.getClass();
            position = mo.e.f10857a;
        }
        cVar.b(location.a(), position, str, mo.f.PACKAGE, str2);
    }
}
