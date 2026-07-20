package l3;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class h2 extends AbstractMap {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f7243i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7244a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7247d;
    public volatile i4.l e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f7245b = Collections.emptyList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f7246c = Collections.emptyMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map f7248h = Collections.emptyMap();

    public h2(int i8) {
        this.f7244a = i8;
    }

    public final int a() {
        return this.f7245b.size();
    }

    public final Iterable b() {
        return this.f7246c.isEmpty() ? k2.f7260b : this.f7246c.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        h();
        int iE = e(comparable);
        if (iE >= 0) {
            return ((l2) this.f7245b.get(iE)).setValue(obj);
        }
        h();
        boolean zIsEmpty = this.f7245b.isEmpty();
        int i8 = this.f7244a;
        if (zIsEmpty && !(this.f7245b instanceof ArrayList)) {
            this.f7245b = new ArrayList(i8);
        }
        int i9 = -(iE + 1);
        if (i9 >= i8) {
            return g().put(comparable, obj);
        }
        if (this.f7245b.size() == i8) {
            l2 l2Var = (l2) this.f7245b.remove(i8 - 1);
            g().put(l2Var.f7265a, l2Var.f7266b);
        }
        this.f7245b.add(i9, new l2(this, comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        h();
        if (!this.f7245b.isEmpty()) {
            this.f7245b.clear();
        }
        if (this.f7246c.isEmpty()) {
            return;
        }
        this.f7246c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return e(comparable) >= 0 || this.f7246c.containsKey(comparable);
    }

    public final Map.Entry d(int i8) {
        return (Map.Entry) this.f7245b.get(i8);
    }

    public final int e(Comparable comparable) {
        int size = this.f7245b.size();
        int i8 = size - 1;
        int i9 = 0;
        if (i8 >= 0) {
            int iCompareTo = comparable.compareTo(((l2) this.f7245b.get(i8)).f7265a);
            if (iCompareTo > 0) {
                return -(size + 1);
            }
            if (iCompareTo == 0) {
                return i8;
            }
        }
        while (i9 <= i8) {
            int i10 = (i9 + i8) / 2;
            int iCompareTo2 = comparable.compareTo(((l2) this.f7245b.get(i10)).f7265a);
            if (iCompareTo2 < 0) {
                i8 = i10 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i10;
                }
                i9 = i10 + 1;
            }
        }
        return -(i9 + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.e == null) {
            this.e = new i4.l(this, 2);
        }
        return this.e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h2)) {
            return super.equals(obj);
        }
        h2 h2Var = (h2) obj;
        int size = size();
        if (size != h2Var.size()) {
            return false;
        }
        int size2 = this.f7245b.size();
        if (size2 != h2Var.f7245b.size()) {
            return entrySet().equals(h2Var.entrySet());
        }
        for (int i8 = 0; i8 < size2; i8++) {
            if (!d(i8).equals(h2Var.d(i8))) {
                return false;
            }
        }
        if (size2 != size) {
            return this.f7246c.equals(h2Var.f7246c);
        }
        return true;
    }

    public final Object f(int i8) {
        h();
        Object obj = ((l2) this.f7245b.remove(i8)).f7266b;
        if (!this.f7246c.isEmpty()) {
            Iterator it = g().entrySet().iterator();
            List list = this.f7245b;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new l2(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    public final SortedMap g() {
        h();
        if (this.f7246c.isEmpty() && !(this.f7246c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f7246c = treeMap;
            this.f7248h = treeMap.descendingMap();
        }
        return (SortedMap) this.f7246c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iE = e(comparable);
        return iE >= 0 ? ((l2) this.f7245b.get(iE)).f7266b : this.f7246c.get(comparable);
    }

    public final void h() {
        if (this.f7247d) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.f7245b.size();
        int iHashCode = 0;
        for (int i8 = 0; i8 < size; i8++) {
            iHashCode += ((l2) this.f7245b.get(i8)).hashCode();
        }
        return this.f7246c.size() > 0 ? this.f7246c.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        h();
        Comparable comparable = (Comparable) obj;
        int iE = e(comparable);
        if (iE >= 0) {
            return f(iE);
        }
        if (this.f7246c.isEmpty()) {
            return null;
        }
        return this.f7246c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f7246c.size() + this.f7245b.size();
    }
}
