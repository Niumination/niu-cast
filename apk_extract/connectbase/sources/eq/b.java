package eq;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import jn.l;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: Add missing generic type declarations: [N] */
    public static class a<N> extends AbstractC0107b<N, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f4658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean[] f4659b;

        public a(l lVar, boolean[] zArr) {
            this.f4658a = lVar;
            this.f4659b = zArr;
        }

        @Override // eq.b.AbstractC0107b, eq.b.e
        public boolean b(N n10) {
            if (((Boolean) this.f4658a.invoke(n10)).booleanValue()) {
                this.f4659b[0] = true;
            }
            return !this.f4659b[0];
        }

        @Override // eq.b.e
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean result() {
            return Boolean.valueOf(this.f4659b[0]);
        }
    }

    /* JADX INFO: renamed from: eq.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC0107b<N, R> implements e<N, R> {
        @Override // eq.b.e
        public void a(N n10) {
        }

        @Override // eq.b.e
        public boolean b(N n10) {
            return true;
        }
    }

    public static abstract class c<N, R, C extends Iterable<R>> extends AbstractC0107b<N, C> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final C f4660a;

        public c(@os.l C c10) {
            if (c10 == null) {
                c(0);
            }
            this.f4660a = c10;
        }

        public static /* synthetic */ void c(int i10) {
            String str = i10 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i10 != 1 ? 3 : 2];
            if (i10 != 1) {
                objArr[0] = "result";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/DFS$CollectingNodeHandler";
            }
            if (i10 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS$CollectingNodeHandler";
            } else {
                objArr[1] = "result";
            }
            if (i10 != 1) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i10 == 1) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // eq.b.e
        @os.l
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public C result() {
            C c10 = this.f4660a;
            if (c10 == null) {
                c(1);
            }
            return c10;
        }
    }

    public interface d<N> {
        @os.l
        Iterable<? extends N> a(N n10);
    }

    public interface e<N, R> {
        void a(N n10);

        boolean b(N n10);

        R result();
    }

    public static abstract class f<N, R> extends c<N, R, LinkedList<R>> {
        public f() {
            super(new LinkedList());
        }
    }

    public interface g<N> {
        boolean a(N n10);
    }

    public static class h<N> implements g<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<N> f4661a;

        public h() {
            this(new HashSet());
        }

        public static /* synthetic */ void b(int i10) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visited", "kotlin/reflect/jvm/internal/impl/utils/DFS$VisitedWithSet", "<init>"));
        }

        @Override // eq.b.g
        public boolean a(N n10) {
            return this.f4661a.add(n10);
        }

        public h(@os.l Set<N> set) {
            if (set == null) {
                b(0);
            }
            this.f4661a = set;
        }
    }

    public static /* synthetic */ void a(int i10) {
        Object[] objArr = new Object[3];
        switch (i10) {
            case 1:
            case 5:
            case 8:
            case 11:
            case 15:
            case 18:
            case 21:
            case 23:
                objArr[0] = "neighbors";
                break;
            case 2:
            case 12:
            case 16:
            case 19:
            case 24:
                objArr[0] = "visited";
                break;
            case 3:
            case 6:
            case 13:
            case 25:
                objArr[0] = "handler";
                break;
            case 4:
            case 7:
            case 17:
            case 20:
            default:
                objArr[0] = "nodes";
                break;
            case 9:
                objArr[0] = "predicate";
                break;
            case 10:
            case 14:
                objArr[0] = "node";
                break;
            case 22:
                objArr[0] = "current";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS";
        switch (i10) {
            case 7:
            case 8:
            case 9:
                objArr[2] = "ifAny";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "dfsFromNode";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                objArr[2] = "topologicalOrder";
                break;
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "doDfs";
                break;
            default:
                objArr[2] = "dfs";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static <N, R> R b(@os.l Collection<N> collection, @os.l d<N> dVar, @os.l e<N, R> eVar) {
        if (collection == null) {
            a(4);
        }
        if (dVar == null) {
            a(5);
        }
        if (eVar == null) {
            a(6);
        }
        return (R) c(collection, dVar, new h(), eVar);
    }

    public static <N, R> R c(@os.l Collection<N> collection, @os.l d<N> dVar, @os.l g<N> gVar, @os.l e<N, R> eVar) {
        if (collection == null) {
            a(0);
        }
        if (dVar == null) {
            a(1);
        }
        if (gVar == null) {
            a(2);
        }
        if (eVar == null) {
            a(3);
        }
        Iterator<N> it = collection.iterator();
        while (it.hasNext()) {
            d(it.next(), dVar, gVar, eVar);
        }
        return eVar.result();
    }

    public static <N> void d(@os.l N n10, @os.l d<N> dVar, @os.l g<N> gVar, @os.l e<N, ?> eVar) {
        if (n10 == null) {
            a(22);
        }
        if (dVar == null) {
            a(23);
        }
        if (gVar == null) {
            a(24);
        }
        if (eVar == null) {
            a(25);
        }
        if (gVar.a(n10) && eVar.b(n10)) {
            Iterator<? extends N> it = dVar.a(n10).iterator();
            while (it.hasNext()) {
                d(it.next(), dVar, gVar, eVar);
            }
            eVar.a(n10);
        }
    }

    public static <N> Boolean e(@os.l Collection<N> collection, @os.l d<N> dVar, @os.l l<N, Boolean> lVar) {
        if (collection == null) {
            a(7);
        }
        if (dVar == null) {
            a(8);
        }
        if (lVar == null) {
            a(9);
        }
        return (Boolean) b(collection, dVar, new a(lVar, new boolean[1]));
    }
}
