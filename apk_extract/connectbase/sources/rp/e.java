package rp;

import eo.h0;
import eo.h1;
import eo.j0;
import eo.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kn.l0;
import lm.t0;
import nm.c1;
import nm.d1;
import nm.v0;
import vp.f0;
import vp.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final h0 f14710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final j0 f14711b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14712a;

        static {
            int[] iArr = new int[yo.a.b.C0559b.c.EnumC0564c.values().length];
            iArr[yo.a.b.C0559b.c.EnumC0564c.BYTE.ordinal()] = 1;
            iArr[yo.a.b.C0559b.c.EnumC0564c.CHAR.ordinal()] = 2;
            iArr[yo.a.b.C0559b.c.EnumC0564c.SHORT.ordinal()] = 3;
            iArr[yo.a.b.C0559b.c.EnumC0564c.INT.ordinal()] = 4;
            iArr[yo.a.b.C0559b.c.EnumC0564c.LONG.ordinal()] = 5;
            iArr[yo.a.b.C0559b.c.EnumC0564c.FLOAT.ordinal()] = 6;
            iArr[yo.a.b.C0559b.c.EnumC0564c.DOUBLE.ordinal()] = 7;
            iArr[yo.a.b.C0559b.c.EnumC0564c.BOOLEAN.ordinal()] = 8;
            iArr[yo.a.b.C0559b.c.EnumC0564c.STRING.ordinal()] = 9;
            iArr[yo.a.b.C0559b.c.EnumC0564c.CLASS.ordinal()] = 10;
            iArr[yo.a.b.C0559b.c.EnumC0564c.ENUM.ordinal()] = 11;
            iArr[yo.a.b.C0559b.c.EnumC0564c.ANNOTATION.ordinal()] = 12;
            iArr[yo.a.b.C0559b.c.EnumC0564c.ARRAY.ordinal()] = 13;
            f14712a = iArr;
        }
    }

    public e(@os.l h0 h0Var, @os.l j0 j0Var) {
        l0.p(h0Var, "module");
        l0.p(j0Var, "notFoundClasses");
        this.f14710a = h0Var;
        this.f14711b = j0Var;
    }

    @os.l
    public final fo.c a(@os.l yo.a.b bVar, @os.l ap.c cVar) {
        l0.p(bVar, "proto");
        l0.p(cVar, "nameResolver");
        eo.e eVarE = e(x.a(cVar, bVar.getId()));
        Map mapZ = d1.z();
        if (bVar.getArgumentCount() != 0 && !vp.x.r(eVarE) && hp.d.t(eVarE)) {
            Collection<eo.d> collectionG = eVarE.g();
            l0.o(collectionG, "annotationClass.constructors");
            eo.d dVar = (eo.d) nm.h0.i5(collectionG);
            if (dVar != null) {
                List<h1> listH = dVar.h();
                l0.o(listH, "constructor.valueParameters");
                List<h1> list = listH;
                int iJ = c1.j(nm.z.b0(list, 10));
                if (iJ < 16) {
                    iJ = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
                for (Object obj : list) {
                    linkedHashMap.put(((h1) obj).getName(), obj);
                }
                List<yo.a.b.C0559b> argumentList = bVar.getArgumentList();
                l0.o(argumentList, "proto.argumentList");
                ArrayList arrayList = new ArrayList();
                for (yo.a.b.C0559b c0559b : argumentList) {
                    l0.o(c0559b, "it");
                    t0<dp.f, jp.g<?>> t0VarD = d(c0559b, linkedHashMap, cVar);
                    if (t0VarD != null) {
                        arrayList.add(t0VarD);
                    }
                }
                mapZ = d1.D0(arrayList);
            }
        }
        return new fo.d(eVarE.q(), mapZ, z0.f4654a);
    }

    public final boolean b(jp.g<?> gVar, f0 f0Var, yo.a.b.C0559b.c cVar) {
        yo.a.b.C0559b.c.EnumC0564c type = cVar.getType();
        int i10 = type == null ? -1 : a.f14712a[type.ordinal()];
        if (i10 == 10) {
            eo.h hVarD = f0Var.G0().d();
            eo.e eVar = hVarD instanceof eo.e ? (eo.e) hVarD : null;
            if (eVar != null && !ao.h.j0(eVar)) {
                return false;
            }
        } else {
            if (i10 != 13) {
                return l0.g(gVar.a(this.f14710a), f0Var);
            }
            if (!(gVar instanceof jp.b) || ((jp.b) gVar).b().size() != cVar.getArrayElementList().size()) {
                throw new IllegalStateException(l0.C("Deserialized ArrayValue should have the same number of elements as the original array value: ", gVar).toString());
            }
            f0 f0VarK = this.f14710a.n().k(f0Var);
            l0.o(f0VarK, "builtIns.getArrayElementType(expectedType)");
            jp.b bVar = (jp.b) gVar;
            Iterable iterableI = nm.y.I(bVar.b());
            if (!(iterableI instanceof Collection) || !((Collection) iterableI).isEmpty()) {
                Iterator it = iterableI.iterator();
                while (it.hasNext()) {
                    int iNextInt = ((v0) it).nextInt();
                    jp.g<?> gVar2 = bVar.b().get(iNextInt);
                    yo.a.b.C0559b.c arrayElement = cVar.getArrayElement(iNextInt);
                    l0.o(arrayElement, "value.getArrayElement(i)");
                    if (!b(gVar2, f0VarK, arrayElement)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final ao.h c() {
        return this.f14710a.n();
    }

    public final t0<dp.f, jp.g<?>> d(yo.a.b.C0559b c0559b, Map<dp.f, ? extends h1> map, ap.c cVar) {
        h1 h1Var = map.get(x.b(cVar, c0559b.getNameId()));
        if (h1Var == null) {
            return null;
        }
        dp.f fVarB = x.b(cVar, c0559b.getNameId());
        f0 type = h1Var.getType();
        l0.o(type, "parameter.type");
        yo.a.b.C0559b.c value = c0559b.getValue();
        l0.o(value, "proto.value");
        return new t0<>(fVarB, g(type, value, cVar));
    }

    public final eo.e e(dp.b bVar) {
        return eo.x.c(this.f14710a, bVar, this.f14711b);
    }

    @os.l
    public final jp.g<?> f(@os.l f0 f0Var, @os.l yo.a.b.C0559b.c cVar, @os.l ap.c cVar2) {
        jp.g<?> wVar;
        l0.p(f0Var, "expectedType");
        l0.p(cVar, "value");
        l0.p(cVar2, "nameResolver");
        Boolean boolD = ap.b.O.d(cVar.getFlags());
        l0.o(boolD, "IS_UNSIGNED.get(value.flags)");
        boolean zBooleanValue = boolD.booleanValue();
        yo.a.b.C0559b.c.EnumC0564c type = cVar.getType();
        switch (type == null ? -1 : a.f14712a[type.ordinal()]) {
            case 1:
                byte intValue = (byte) cVar.getIntValue();
                wVar = zBooleanValue ? new jp.w(intValue) : new jp.d(intValue);
                break;
            case 2:
                return new jp.e((char) cVar.getIntValue());
            case 3:
                short intValue2 = (short) cVar.getIntValue();
                wVar = zBooleanValue ? new jp.z(intValue2) : new jp.u(intValue2);
                break;
            case 4:
                int intValue3 = (int) cVar.getIntValue();
                wVar = zBooleanValue ? new jp.x(intValue3) : new jp.m(intValue3);
                break;
            case 5:
                long intValue4 = cVar.getIntValue();
                return zBooleanValue ? new jp.y(intValue4) : new jp.r(intValue4);
            case 6:
                return new jp.l(cVar.getFloatValue());
            case 7:
                return new jp.i(cVar.getDoubleValue());
            case 8:
                return new jp.c(cVar.getIntValue() != 0);
            case 9:
                return new jp.v(cVar2.c(cVar.getStringValue()));
            case 10:
                return new jp.q(x.a(cVar2, cVar.getClassId()), cVar.getArrayDimensionCount());
            case 11:
                return new jp.j(x.a(cVar2, cVar.getClassId()), x.b(cVar2, cVar.getEnumValueId()));
            case 12:
                yo.a.b annotation = cVar.getAnnotation();
                l0.o(annotation, "value.annotation");
                wVar = new jp.a(a(annotation, cVar2));
                break;
            case 13:
                List<yo.a.b.C0559b.c> arrayElementList = cVar.getArrayElementList();
                l0.o(arrayElementList, "value.arrayElementList");
                List<yo.a.b.C0559b.c> list = arrayElementList;
                ArrayList arrayList = new ArrayList(nm.z.b0(list, 10));
                for (yo.a.b.C0559b.c cVar3 : list) {
                    n0 n0VarI = this.f14710a.n().i();
                    l0.o(n0VarI, "builtIns.anyType");
                    l0.o(cVar3, "it");
                    arrayList.add(f(n0VarI, cVar3, cVar2));
                }
                return new m(arrayList, f0Var);
            default:
                throw new IllegalStateException(("Unsupported annotation argument type: " + cVar.getType() + " (expected " + f0Var + ')').toString());
        }
        return wVar;
    }

    public final jp.g<?> g(f0 f0Var, yo.a.b.C0559b.c cVar, ap.c cVar2) {
        jp.g<?> gVarF = f(f0Var, cVar, cVar2);
        if (!b(gVarF, f0Var, cVar)) {
            gVarF = null;
        }
        if (gVarF != null) {
            return gVarF;
        }
        return jp.k.f8778b.a("Unexpected argument value: actual type " + cVar.getType() + " != expected type " + f0Var);
    }
}
