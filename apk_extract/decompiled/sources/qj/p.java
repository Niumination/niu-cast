package qj;

import java.util.RandomAccess;
import kotlin.collections.AbstractList;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends AbstractList implements RandomAccess {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f9208c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j[] f9209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f9210b;

    public p(j[] jVarArr, int[] iArr) {
        this.f9209a = jVarArr;
        this.f9210b = iArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof j) {
            return super.contains((j) obj);
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final Object get(int i8) {
        return this.f9209a[i8];
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    /* JADX INFO: renamed from: getSize */
    public final int get_size() {
        return this.f9209a.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof j) {
            return super.indexOf((j) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof j) {
            return super.lastIndexOf((j) obj);
        }
        return -1;
    }
}
