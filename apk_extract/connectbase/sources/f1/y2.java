package f1;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public final class y2<E> extends f<E> {

    @b1.c
    @b1.d
    private static final long serialVersionUID = 0;

    public y2(int distinctElements) {
        super(distinctElements);
    }

    public static <E> y2<E> create() {
        return create(3);
    }

    @Override // f1.i, java.util.AbstractCollection, java.util.Collection, f1.b5
    public /* bridge */ /* synthetic */ boolean contains(@gm.a Object element) {
        return super.contains(element);
    }

    @Override // f1.i, f1.b5, f1.r6, f1.s6
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // f1.i, f1.b5
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // f1.i, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // f1.f
    public j5<E> newBackingMap(int distinctElements) {
        return new j5<>(distinctElements);
    }

    public static <E> y2<E> create(int distinctElements) {
        return new y2<>(distinctElements);
    }

    public static <E> y2<E> create(Iterable<? extends E> elements) {
        y2<E> y2VarCreate = create(c5.l(elements));
        g4.a(y2VarCreate, elements);
        return y2VarCreate;
    }
}
