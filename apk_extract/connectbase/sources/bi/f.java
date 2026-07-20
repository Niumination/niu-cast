package bi;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class f implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator[] f855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f856b = 0;

    public f(Set... setArr) {
        this.f855a = new Iterator[setArr.length];
        for (int i10 = 0; i10 < setArr.length; i10++) {
            this.f855a[i10] = setArr[i10].iterator();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f855a[this.f856b].hasNext()) {
            return true;
        }
        int i10 = this.f856b + 1;
        this.f856b = i10;
        Iterator[] itArr = this.f855a;
        return i10 < itArr.length && itArr[i10].hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        return this.f855a[this.f856b].next();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f855a[this.f856b].remove();
    }
}
