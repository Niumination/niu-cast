package tj;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
public final class e1 extends tj.d implements sj.j, h0, Serializable {
    private static final long serialVersionUID = 2;
    private final boolean resolved;
    private final List<tj.d> value;

    public class a extends tj.d.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p0 f15597b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(p0 p0Var) {
            super();
            this.f15597b = p0Var;
        }

        @Override // tj.d.b
        public tj.d b(String str, tj.d dVar) {
            return dVar.relativized(this.f15597b);
        }
    }

    public class b implements Iterator<sj.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f15599a;

        public b(Iterator it) {
            this.f15599a = it;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public sj.x next() {
            return (sj.x) this.f15599a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f15599a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw e1.i("iterator().remove");
        }
    }

    public static class c implements ListIterator<sj.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListIterator f15601a;

        public c(ListIterator listIterator) {
            this.f15601a = listIterator;
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(sj.x xVar) {
            throw e1.i("listIterator().add");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public sj.x next() {
            return (sj.x) this.f15601a.next();
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public sj.x previous() {
            return (sj.x) this.f15601a.previous();
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void set(sj.x xVar) {
            throw e1.i("listIterator().set");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f15601a.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f15601a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f15601a.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f15601a.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw e1.i("listIterator().remove");
        }
    }

    public static class d implements tj.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public u0 f15602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x0 f15603b;

        public d(u0 u0Var, x0 x0Var) {
            this.f15602a = u0Var;
            this.f15603b = x0Var;
        }

        @Override // tj.d.a
        public tj.d a(String str, tj.d dVar) throws tj.d.c {
            w0<? extends tj.d> w0VarL = this.f15602a.l(dVar, this.f15603b);
            this.f15602a = w0VarL.f15744a;
            return w0VarL.f15745b;
        }
    }

    public e1(sj.o oVar, List<tj.d> list) {
        this(oVar, list, y0.fromValues(list));
    }

    public static UnsupportedOperationException i(String str) {
        return new UnsupportedOperationException(n.a.a("ConfigList is immutable, you can't call List.'", str, "'"));
    }

    public static ListIterator<sj.x> j(ListIterator<tj.d> listIterator) {
        return new c(listIterator);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new z0(this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends sj.x> collection) {
        throw i("addAll");
    }

    @Override // tj.d
    public boolean canEqual(Object obj) {
        return obj instanceof e1;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw i("clear");
    }

    public final e1 concatenate(e1 e1Var) {
        g1 g1VarP = g1.p(origin(), e1Var.origin());
        ArrayList arrayList = new ArrayList(e1Var.value.size() + this.value.size());
        arrayList.addAll(this.value);
        arrayList.addAll(e1Var.value);
        return new e1(g1VarP, arrayList);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.value.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.value.containsAll(collection);
    }

    @Override // tj.d
    public boolean equals(Object obj) {
        if (!(obj instanceof e1) || !canEqual(obj)) {
            return false;
        }
        List<tj.d> list = this.value;
        List<tj.d> list2 = ((e1) obj).value;
        return list == list2 || list.equals(list2);
    }

    public final e1 f(tj.d.b bVar, y0 y0Var) {
        try {
            return g(bVar, y0Var);
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new sj.c.d("unexpected checked exception", e11);
        }
    }

    public final e1 g(tj.d.a aVar, y0 y0Var) throws Exception {
        ArrayList arrayList = null;
        int i10 = 0;
        for (tj.d dVar : this.value) {
            tj.d dVarA = aVar.a(null, dVar);
            if (arrayList == null && dVarA != dVar) {
                arrayList = new ArrayList();
                for (int i11 = 0; i11 < i10; i11++) {
                    arrayList.add(this.value.get(i11));
                }
            }
            if (arrayList != null && dVarA != null) {
                arrayList.add(dVarA);
            }
            i10++;
        }
        if (arrayList != null) {
            return y0Var != null ? new e1(origin(), arrayList, y0Var) : new e1(origin(), arrayList);
        }
        return this;
    }

    @Override // tj.h0
    public boolean hasDescendant(tj.d dVar) {
        return tj.d.hasDescendantInList(this.value, dVar);
    }

    @Override // tj.d
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.value.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.value.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<sj.x> iterator() {
        return new b(this.value.iterator());
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.value.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<sj.x> listIterator() {
        return new c(this.value.listIterator());
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw i("removeAll");
    }

    @Override // tj.d
    public void render(StringBuilder sb2, int i10, boolean z10, sj.s sVar) {
        if (this.value.isEmpty()) {
            sb2.append("[]");
            return;
        }
        sb2.append("[");
        if (sVar.f15097c) {
            sb2.append('\n');
        }
        for (tj.d dVar : this.value) {
            if (sVar.f15095a) {
                for (String str : dVar.origin().description().split("\n")) {
                    tj.d.indent(sb2, i10 + 1, sVar);
                    sb2.append('#');
                    if (!str.isEmpty()) {
                        sb2.append(' ');
                    }
                    sb2.append(str);
                    sb2.append("\n");
                }
            }
            if (sVar.f15096b) {
                for (String str2 : dVar.origin().comments()) {
                    tj.d.indent(sb2, i10 + 1, sVar);
                    sb2.append("# ");
                    sb2.append(str2);
                    sb2.append("\n");
                }
            }
            int i11 = i10 + 1;
            tj.d.indent(sb2, i11, sVar);
            dVar.render(sb2, i11, z10, sVar);
            sb2.append(ks.g.f9491d);
            if (sVar.f15097c) {
                sb2.append('\n');
            }
        }
        sb2.setLength(sb2.length() - 1);
        if (sVar.f15097c) {
            sb2.setLength(sb2.length() - 1);
            sb2.append('\n');
            tj.d.indent(sb2, i10, sVar);
        }
        sb2.append("]");
    }

    @Override // tj.d
    public y0 resolveStatus() {
        return y0.fromBoolean(this.resolved);
    }

    @Override // tj.d
    public w0<? extends e1> resolveSubstitutions(u0 u0Var, x0 x0Var) throws tj.d.c {
        if (!this.resolved && !u0Var.c()) {
            try {
                d dVar = new d(u0Var, x0Var.e(this));
                return new w0<>(dVar.f15602a, g(dVar, u0Var.f15735b.f15101b ? null : y0.RESOLVED));
            } catch (RuntimeException e10) {
                throw e10;
            } catch (tj.d.c e11) {
                throw e11;
            } catch (Exception e12) {
                throw new sj.c.d("unexpected checked exception", e12);
            }
        }
        return new w0<>(u0Var, this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw i("retainAll");
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.value.size();
    }

    @Override // java.util.List
    public List<sj.x> subList(int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        Iterator<tj.d> it = this.value.subList(i10, i11).iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.value.toArray();
    }

    @Override // sj.x
    public sj.z valueType() {
        return sj.z.LIST;
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends sj.x> collection) {
        throw i("addAll");
    }

    @Override // java.util.List
    public sj.x get(int i10) {
        return this.value.get(i10);
    }

    @Override // tj.d
    public e1 newCopy(sj.o oVar) {
        return new e1(oVar, this.value);
    }

    @Override // tj.d
    public e1 relativized(p0 p0Var) {
        return f(new a(p0Var), resolveStatus());
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw i("remove");
    }

    @Override // tj.h0
    public e1 replaceChild(tj.d dVar, tj.d dVar2) {
        List<tj.d> listReplaceChildInList = tj.d.replaceChildInList(this.value, dVar, dVar2);
        if (listReplaceChildInList == null) {
            return null;
        }
        return new e1(origin(), listReplaceChildInList);
    }

    @Override // java.util.List
    public sj.x set(int i10, sj.x xVar) {
        throw i("set");
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.value.toArray(tArr);
    }

    @Override // sj.x
    public List<Object> unwrapped() {
        ArrayList arrayList = new ArrayList();
        Iterator<tj.d> it = this.value.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().unwrapped());
        }
        return arrayList;
    }

    public e1(sj.o oVar, List<tj.d> list, y0 y0Var) {
        super(oVar);
        this.value = list;
        this.resolved = y0Var == y0.RESOLVED;
        if (y0Var == y0.fromValues(list)) {
            return;
        }
        throw new sj.c.d("SimpleConfigList created with wrong resolve status: " + this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(sj.x xVar) {
        throw i("add");
    }

    @Override // java.util.List
    public ListIterator<sj.x> listIterator(int i10) {
        return new c(this.value.listIterator(i10));
    }

    @Override // java.util.List
    public sj.x remove(int i10) {
        throw i("remove");
    }

    @Override // java.util.List
    public void add(int i10, sj.x xVar) {
        throw i("add");
    }

    @Override // tj.d, sj.x
    public e1 withOrigin(sj.o oVar) {
        return (e1) super.withOrigin(oVar);
    }
}
