package l1;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public final class n implements o, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f7148a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f7149b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f7150c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f7151d = new ArrayList();
    public final r1.l e;

    public n(r1.l lVar) {
        lVar.getClass();
        this.e = lVar;
    }

    public final void a(Path.Op op) {
        Matrix matrixE;
        Matrix matrixE2;
        Path path = this.f7149b;
        path.reset();
        Path path2 = this.f7148a;
        path2.reset();
        ArrayList arrayList = this.f7151d;
        for (int size = arrayList.size() - 1; size >= 1; size--) {
            o oVar = (o) arrayList.get(size);
            if (oVar instanceof e) {
                e eVar = (e) oVar;
                ArrayList arrayList2 = (ArrayList) eVar.f();
                for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                    Path path3 = ((o) arrayList2.get(size2)).getPath();
                    m1.q qVar = eVar.f7105k;
                    if (qVar != null) {
                        matrixE2 = qVar.e();
                    } else {
                        matrixE2 = eVar.f7099c;
                        matrixE2.reset();
                    }
                    path3.transform(matrixE2);
                    path.addPath(path3);
                }
            } else {
                path.addPath(oVar.getPath());
            }
        }
        int i8 = 0;
        o oVar2 = (o) arrayList.get(0);
        if (oVar2 instanceof e) {
            e eVar2 = (e) oVar2;
            List listF = eVar2.f();
            while (true) {
                ArrayList arrayList3 = (ArrayList) listF;
                if (i8 >= arrayList3.size()) {
                    break;
                }
                Path path4 = ((o) arrayList3.get(i8)).getPath();
                m1.q qVar2 = eVar2.f7105k;
                if (qVar2 != null) {
                    matrixE = qVar2.e();
                } else {
                    matrixE = eVar2.f7099c;
                    matrixE.reset();
                }
                path4.transform(matrixE);
                path2.addPath(path4);
                i8++;
            }
        } else {
            path2.set(oVar2.getPath());
        }
        this.f7150c.op(path2, path, op);
    }

    @Override // l1.d
    public final void b(List list, List list2) {
        int i8 = 0;
        while (true) {
            ArrayList arrayList = this.f7151d;
            if (i8 >= arrayList.size()) {
                return;
            }
            ((o) arrayList.get(i8)).b(list, list2);
            i8++;
        }
    }

    @Override // l1.k
    public final void f(ListIterator listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            d dVar = (d) listIterator.previous();
            if (dVar instanceof o) {
                this.f7151d.add((o) dVar);
                listIterator.remove();
            }
        }
    }

    @Override // l1.o
    public final Path getPath() {
        Path path = this.f7150c;
        path.reset();
        r1.l lVar = this.e;
        if (lVar.f9273b) {
            return path;
        }
        int i8 = m.f7147a[lVar.f9272a.ordinal()];
        if (i8 == 1) {
            int i9 = 0;
            while (true) {
                ArrayList arrayList = this.f7151d;
                if (i9 >= arrayList.size()) {
                    break;
                }
                path.addPath(((o) arrayList.get(i9)).getPath());
                i9++;
            }
        } else if (i8 == 2) {
            a(Path.Op.UNION);
        } else if (i8 == 3) {
            a(Path.Op.REVERSE_DIFFERENCE);
        } else if (i8 == 4) {
            a(Path.Op.INTERSECT);
        } else if (i8 == 5) {
            a(Path.Op.XOR);
        }
        return path;
    }
}
