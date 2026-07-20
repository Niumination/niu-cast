package af;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class b5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Collection f188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Collection f189d;
    public final int e;
    public final e5 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f191h;

    public b5(List list, Collection collection, Collection collection2, e5 e5Var, boolean z2, boolean z3, boolean z5, int i8) {
        this.f187b = list;
        v8.i(collection, "drainedSubstreams");
        this.f188c = collection;
        this.f = e5Var;
        this.f189d = collection2;
        this.f190g = z2;
        this.f186a = z3;
        this.f191h = z5;
        this.e = i8;
        v8.n(!z3 || list == null, "passThrough should imply buffer is null");
        v8.n((z3 && e5Var == null) ? false : true, "passThrough should imply winningSubstream != null");
        v8.n(!z3 || (collection.size() == 1 && collection.contains(e5Var)) || (collection.size() == 0 && e5Var.f246b), "passThrough should imply winningSubstream is drained");
        v8.n((z2 && e5Var == null) ? false : true, "cancelled should imply committed");
    }

    public final b5 a(e5 e5Var) {
        Collection collectionUnmodifiableCollection;
        v8.n(!this.f191h, "hedging frozen");
        v8.n(this.f == null, "already committed");
        Collection collection = this.f189d;
        if (collection == null) {
            collectionUnmodifiableCollection = Collections.singleton(e5Var);
        } else {
            ArrayList arrayList = new ArrayList(collection);
            arrayList.add(e5Var);
            collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
        }
        return new b5(this.f187b, this.f188c, collectionUnmodifiableCollection, this.f, this.f190g, this.f186a, this.f191h, this.e + 1);
    }

    public final b5 b(e5 e5Var) {
        ArrayList arrayList = new ArrayList(this.f189d);
        arrayList.remove(e5Var);
        return new b5(this.f187b, this.f188c, Collections.unmodifiableCollection(arrayList), this.f, this.f190g, this.f186a, this.f191h, this.e);
    }

    public final b5 c(e5 e5Var, e5 e5Var2) {
        ArrayList arrayList = new ArrayList(this.f189d);
        arrayList.remove(e5Var);
        arrayList.add(e5Var2);
        return new b5(this.f187b, this.f188c, Collections.unmodifiableCollection(arrayList), this.f, this.f190g, this.f186a, this.f191h, this.e);
    }

    public final b5 d(e5 e5Var) {
        e5Var.f246b = true;
        Collection collection = this.f188c;
        if (!collection.contains(e5Var)) {
            return this;
        }
        ArrayList arrayList = new ArrayList(collection);
        arrayList.remove(e5Var);
        return new b5(this.f187b, Collections.unmodifiableCollection(arrayList), this.f189d, this.f, this.f190g, this.f186a, this.f191h, this.e);
    }

    public final b5 e(e5 e5Var) {
        List list;
        v8.n(!this.f186a, "Already passThrough");
        boolean z2 = e5Var.f246b;
        Collection collectionUnmodifiableCollection = this.f188c;
        if (!z2) {
            if (collectionUnmodifiableCollection.isEmpty()) {
                collectionUnmodifiableCollection = Collections.singletonList(e5Var);
            } else {
                ArrayList arrayList = new ArrayList(collectionUnmodifiableCollection);
                arrayList.add(e5Var);
                collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
        }
        Collection collection = collectionUnmodifiableCollection;
        e5 e5Var2 = this.f;
        boolean z3 = e5Var2 != null;
        if (z3) {
            v8.n(e5Var2 == e5Var, "Another RPC attempt has already committed");
            list = null;
        } else {
            list = this.f187b;
        }
        return new b5(list, collection, this.f189d, this.f, this.f190g, z3, this.f191h, this.e);
    }
}
