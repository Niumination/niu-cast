package p0;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
@b.b(19)
public class l implements n, j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f12633d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u0.h f12635f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f12630a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f12631b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f12632c = new Path();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<n> f12634e = new ArrayList();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12636a;

        static {
            int[] iArr = new int[u0.h.a.values().length];
            f12636a = iArr;
            try {
                iArr[u0.h.a.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12636a[u0.h.a.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12636a[u0.h.a.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12636a[u0.h.a.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12636a[u0.h.a.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public l(u0.h hVar) {
        this.f12633d = hVar.c();
        this.f12635f = hVar;
    }

    public final void a() {
        for (int i10 = 0; i10 < this.f12634e.size(); i10++) {
            this.f12632c.addPath(this.f12634e.get(i10).getPath());
        }
    }

    @Override // p0.c
    public void b(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < this.f12634e.size(); i10++) {
            this.f12634e.get(i10).b(list, list2);
        }
    }

    @Override // p0.j
    public void d(ListIterator<c> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            c cVarPrevious = listIterator.previous();
            if (cVarPrevious instanceof n) {
                this.f12634e.add((n) cVarPrevious);
                listIterator.remove();
            }
        }
    }

    @b.b(19)
    public final void e(Path.Op op2) {
        this.f12631b.reset();
        this.f12630a.reset();
        for (int size = this.f12634e.size() - 1; size >= 1; size--) {
            n nVar = this.f12634e.get(size);
            if (nVar instanceof d) {
                d dVar = (d) nVar;
                List<n> listI = dVar.i();
                for (int size2 = listI.size() - 1; size2 >= 0; size2--) {
                    Path path = listI.get(size2).getPath();
                    path.transform(dVar.j());
                    this.f12631b.addPath(path);
                }
            } else {
                this.f12631b.addPath(nVar.getPath());
            }
        }
        n nVar2 = this.f12634e.get(0);
        if (nVar2 instanceof d) {
            d dVar2 = (d) nVar2;
            List<n> listI2 = dVar2.i();
            for (int i10 = 0; i10 < listI2.size(); i10++) {
                Path path2 = listI2.get(i10).getPath();
                path2.transform(dVar2.j());
                this.f12630a.addPath(path2);
            }
        } else {
            this.f12630a.set(nVar2.getPath());
        }
        this.f12632c.op(this.f12630a, this.f12631b, op2);
    }

    @Override // p0.c
    public String getName() {
        return this.f12633d;
    }

    @Override // p0.n
    public Path getPath() {
        this.f12632c.reset();
        if (this.f12635f.d()) {
            return this.f12632c;
        }
        int i10 = a.f12636a[this.f12635f.b().ordinal()];
        if (i10 == 1) {
            a();
        } else if (i10 == 2) {
            e(Path.Op.UNION);
        } else if (i10 == 3) {
            e(Path.Op.REVERSE_DIFFERENCE);
        } else if (i10 == 4) {
            e(Path.Op.INTERSECT);
        } else if (i10 == 5) {
            e(Path.Op.XOR);
        }
        return this.f12632c;
    }
}
