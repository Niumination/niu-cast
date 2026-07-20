package rs;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class b implements ps.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f14851a = "[ ";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f14852b = " ]";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f14853c = ", ";
    private static final long serialVersionUID = -2849567615646933777L;
    private final String name;
    private List<ps.d> referenceList = new CopyOnWriteArrayList();

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("A marker name cannot be null");
        }
        this.name = str;
    }

    @Override // ps.d
    public void add(ps.d dVar) {
        if (dVar == null) {
            throw new IllegalArgumentException("A null value cannot be added to a Marker as reference.");
        }
        if (contains(dVar) || dVar.contains(this)) {
            return;
        }
        this.referenceList.add(dVar);
    }

    @Override // ps.d
    public boolean contains(ps.d dVar) {
        if (dVar == null) {
            throw new IllegalArgumentException("Other cannot be null");
        }
        if (equals(dVar)) {
            return true;
        }
        if (!hasReferences()) {
            return false;
        }
        Iterator<ps.d> it = this.referenceList.iterator();
        while (it.hasNext()) {
            if (it.next().contains(dVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // ps.d
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof ps.d)) {
            return this.name.equals(((ps.d) obj).getName());
        }
        return false;
    }

    @Override // ps.d
    public String getName() {
        return this.name;
    }

    @Override // ps.d
    public boolean hasChildren() {
        return hasReferences();
    }

    @Override // ps.d
    public boolean hasReferences() {
        return this.referenceList.size() > 0;
    }

    @Override // ps.d
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override // ps.d
    public Iterator<ps.d> iterator() {
        return this.referenceList.iterator();
    }

    @Override // ps.d
    public boolean remove(ps.d dVar) {
        return this.referenceList.remove(dVar);
    }

    public String toString() {
        if (!hasReferences()) {
            return getName();
        }
        Iterator<ps.d> it = iterator();
        StringBuilder sb2 = new StringBuilder(getName());
        sb2.append(' ');
        sb2.append(f14851a);
        while (it.hasNext()) {
            sb2.append(it.next().getName());
            if (it.hasNext()) {
                sb2.append(f14853c);
            }
        }
        sb2.append(f14852b);
        return sb2.toString();
    }

    @Override // ps.d
    public boolean contains(String str) {
        if (str != null) {
            if (this.name.equals(str)) {
                return true;
            }
            if (!hasReferences()) {
                return false;
            }
            Iterator<ps.d> it = this.referenceList.iterator();
            while (it.hasNext()) {
                if (it.next().contains(str)) {
                    return true;
                }
            }
            return false;
        }
        throw new IllegalArgumentException("Other cannot be null");
    }
}
