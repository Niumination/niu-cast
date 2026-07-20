package hp;

import eo.d1;
import eo.e1;
import eo.h1;
import eo.t0;
import eo.w0;
import eo.y;
import java.util.Comparator;
import java.util.List;
import lm.l2;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public class g implements Comparator<eo.m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f7485a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gp.c f7486b = gp.c.f6761a.b(new a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ boolean f7487c = false;

    public static class a implements jn.l<gp.f, l2> {
        @Override // jn.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public l2 invoke(gp.f fVar) {
            fVar.b(false);
            fVar.m(true);
            fVar.j(gp.a.UNLESS_EMPTY);
            fVar.l(gp.e.ALL);
            return l2.f10208a;
        }
    }

    public static class b implements Comparator<eo.m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f7488a = new b();

        @os.m
        public static Integer c(eo.m mVar, eo.m mVar2) {
            int iD = d(mVar2) - d(mVar);
            if (iD != 0) {
                return Integer.valueOf(iD);
            }
            if (d.B(mVar) && d.B(mVar2)) {
                return 0;
            }
            int iCompareTo = mVar.getName().compareTo(mVar2.getName());
            if (iCompareTo != 0) {
                return Integer.valueOf(iCompareTo);
            }
            return null;
        }

        public static int d(eo.m mVar) {
            if (d.B(mVar)) {
                return 8;
            }
            if (mVar instanceof eo.l) {
                return 7;
            }
            if (mVar instanceof t0) {
                return ((t0) mVar).R() == null ? 6 : 5;
            }
            if (mVar instanceof y) {
                return ((y) mVar).R() == null ? 4 : 3;
            }
            if (mVar instanceof eo.e) {
                return 2;
            }
            return mVar instanceof d1 ? 1 : 0;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(eo.m mVar, eo.m mVar2) {
            Integer numC = c(mVar, mVar2);
            if (numC != null) {
                return numC.intValue();
            }
            return 0;
        }
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(eo.m mVar, eo.m mVar2) {
        Integer numC = b.c(mVar, mVar2);
        if (numC != null) {
            return numC.intValue();
        }
        if ((mVar instanceof d1) && (mVar2 instanceof d1)) {
            gp.c cVar = f7486b;
            int iCompareTo = cVar.y(((d1) mVar).r0()).compareTo(cVar.y(((d1) mVar2).r0()));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        } else if ((mVar instanceof eo.a) && (mVar2 instanceof eo.a)) {
            eo.a aVar = (eo.a) mVar;
            eo.a aVar2 = (eo.a) mVar2;
            w0 w0VarR = aVar.R();
            w0 w0VarR2 = aVar2.R();
            if (w0VarR != null) {
                gp.c cVar2 = f7486b;
                int iCompareTo2 = cVar2.y(w0VarR.getType()).compareTo(cVar2.y(w0VarR2.getType()));
                if (iCompareTo2 != 0) {
                    return iCompareTo2;
                }
            }
            List<h1> listH = aVar.h();
            List<h1> listH2 = aVar2.h();
            for (int i10 = 0; i10 < Math.min(listH.size(), listH2.size()); i10++) {
                gp.c cVar3 = f7486b;
                int iCompareTo3 = cVar3.y(listH.get(i10).getType()).compareTo(cVar3.y(listH2.get(i10).getType()));
                if (iCompareTo3 != 0) {
                    return iCompareTo3;
                }
            }
            int size = listH.size() - listH2.size();
            if (size != 0) {
                return size;
            }
            List<e1> typeParameters = aVar.getTypeParameters();
            List<e1> typeParameters2 = aVar2.getTypeParameters();
            for (int i11 = 0; i11 < Math.min(typeParameters.size(), typeParameters2.size()); i11++) {
                List<f0> upperBounds = typeParameters.get(i11).getUpperBounds();
                List<f0> upperBounds2 = typeParameters2.get(i11).getUpperBounds();
                int size2 = upperBounds.size() - upperBounds2.size();
                if (size2 != 0) {
                    return size2;
                }
                for (int i12 = 0; i12 < upperBounds.size(); i12++) {
                    gp.c cVar4 = f7486b;
                    int iCompareTo4 = cVar4.y(upperBounds.get(i12)).compareTo(cVar4.y(upperBounds2.get(i12)));
                    if (iCompareTo4 != 0) {
                        return iCompareTo4;
                    }
                }
            }
            int size3 = typeParameters.size() - typeParameters2.size();
            if (size3 != 0) {
                return size3;
            }
            if ((aVar instanceof eo.b) && (aVar2 instanceof eo.b)) {
                int iOrdinal = ((eo.b) aVar).getKind().ordinal() - ((eo.b) aVar2).getKind().ordinal();
                if (iOrdinal != 0) {
                    return iOrdinal;
                }
            }
        } else {
            if (!(mVar instanceof eo.e) || !(mVar2 instanceof eo.e)) {
                throw new AssertionError(String.format("Unsupported pair of descriptors:\n'%s' Class: %s\n%s' Class: %s", mVar, mVar.getClass(), mVar2, mVar2.getClass()));
            }
            eo.e eVar = (eo.e) mVar;
            eo.e eVar2 = (eo.e) mVar2;
            if (eVar.getKind().ordinal() != eVar2.getKind().ordinal()) {
                return eVar.getKind().ordinal() - eVar2.getKind().ordinal();
            }
            if (eVar.a0() != eVar2.a0()) {
                return eVar.a0() ? 1 : -1;
            }
        }
        gp.c cVar5 = f7486b;
        int iCompareTo5 = cVar5.s(mVar).compareTo(cVar5.s(mVar2));
        return iCompareTo5 != 0 ? iCompareTo5 : d.g(mVar).getName().compareTo(d.g(mVar2).getName());
    }
}
