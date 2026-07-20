package f1;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public final class m4<E> extends f<E> {
    public m4(int distinctElements) {
        super(distinctElements);
    }

    public static <E> m4<E> create() {
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
        return new k5(distinctElements);
    }

    public static <E> m4<E> create(int distinctElements) {
        return new m4<>(distinctElements);
    }

    public static <E> m4<E> create(Iterable<? extends E> elements) {
        m4<E> m4VarCreate = create(c5.l(elements));
        g4.a(m4VarCreate, elements);
        return m4VarCreate;
    }
}
