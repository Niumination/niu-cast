package androidx.core.util;

import b.a;
import java.util.Objects;
import x.b;

/* JADX INFO: loaded from: classes.dex */
@a({"UnknownNullness"})
public interface Predicate<T> {
    @a({"MissingNullability"})
    static <T> Predicate<T> isEqual(@a({"MissingNullability"}) final Object obj) {
        return obj == null ? new b() : new Predicate() { // from class: x.c
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj2) {
                return obj.equals(obj2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default boolean lambda$and$0(Predicate predicate, Object obj) {
        return test(obj) && predicate.test(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default boolean lambda$negate$1(Object obj) {
        return !test(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default boolean lambda$or$2(Predicate predicate, Object obj) {
        return test(obj) || predicate.test(obj);
    }

    @a({"MissingNullability"})
    static <T> Predicate<T> not(@a({"MissingNullability"}) Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return predicate.negate();
    }

    @a({"MissingNullability"})
    default Predicate<T> and(@a({"MissingNullability"}) final Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return new Predicate() { // from class: x.d
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return this.f19886a.lambda$and$0(predicate, obj);
            }
        };
    }

    @a({"MissingNullability"})
    default Predicate<T> negate() {
        return new Predicate() { // from class: x.e
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return this.f19888a.lambda$negate$1(obj);
            }
        };
    }

    @a({"MissingNullability"})
    default Predicate<T> or(@a({"MissingNullability"}) final Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return new Predicate() { // from class: x.a
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return this.f19883a.lambda$or$2(predicate, obj);
            }
        };
    }

    boolean test(T t10);
}
