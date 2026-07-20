package f1;

import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public final class p6 {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class b {
        public static final b NEXT_LOWER = new a("NEXT_LOWER", 0);
        public static final b NEXT_HIGHER = new C0119b("NEXT_HIGHER", 1);
        public static final b INVERTED_INSERTION_INDEX = new c("INVERTED_INSERTION_INDEX", 2);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b[] f5200a = a();

        public final enum a extends b {
            public a(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // f1.p6.b
            public int resultIndex(int higherIndex) {
                return higherIndex - 1;
            }
        }

        /* JADX INFO: renamed from: f1.p6$b$b, reason: collision with other inner class name */
        public final enum C0119b extends b {
            public C0119b(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // f1.p6.b
            public int resultIndex(int higherIndex) {
                return higherIndex;
            }
        }

        public final enum c extends b {
            public c(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // f1.p6.b
            public int resultIndex(int higherIndex) {
                return ~higherIndex;
            }
        }

        public b(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static /* synthetic */ b[] a() {
            return new b[]{NEXT_LOWER, NEXT_HIGHER, INVERTED_INSERTION_INDEX};
        }

        public static b valueOf(String name) {
            return (b) Enum.valueOf(b.class, name);
        }

        public static b[] values() {
            return (b[]) f5200a.clone();
        }

        public abstract int resultIndex(int higherIndex);

        public b(String str, int i10, a aVar) {
            super(str, i10);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class c {
        public static final c ANY_PRESENT = new a("ANY_PRESENT", 0);
        public static final c LAST_PRESENT = new b("LAST_PRESENT", 1);
        public static final c FIRST_PRESENT = new C0120c("FIRST_PRESENT", 2);
        public static final c FIRST_AFTER = new d("FIRST_AFTER", 3);
        public static final c LAST_BEFORE = new e("LAST_BEFORE", 4);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ c[] f5201a = a();

        public final enum a extends c {
            public a(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // f1.p6.c
            public <E> int resultIndex(Comparator<? super E> comparator, @m5 E key, List<? extends E> list, int foundIndex) {
                return foundIndex;
            }
        }

        public final enum b extends c {
            public b(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // f1.p6.c
            public <E> int resultIndex(Comparator<? super E> comparator, @m5 E e10, List<? extends E> list, int i10) {
                int size = list.size() - 1;
                while (i10 < size) {
                    int i11 = ((i10 + size) + 1) >>> 1;
                    if (comparator.compare(list.get(i11), e10) > 0) {
                        size = i11 - 1;
                    } else {
                        i10 = i11;
                    }
                }
                return i10;
            }
        }

        /* JADX INFO: renamed from: f1.p6$c$c, reason: collision with other inner class name */
        public final enum C0120c extends c {
            public C0120c(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // f1.p6.c
            public <E> int resultIndex(Comparator<? super E> comparator, @m5 E e10, List<? extends E> list, int i10) {
                int i11 = 0;
                while (i11 < i10) {
                    int i12 = (i11 + i10) >>> 1;
                    if (comparator.compare(list.get(i12), e10) < 0) {
                        i11 = i12 + 1;
                    } else {
                        i10 = i12;
                    }
                }
                return i11;
            }
        }

        public final enum d extends c {
            public d(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // f1.p6.c
            public <E> int resultIndex(Comparator<? super E> comparator, @m5 E key, List<? extends E> list, int foundIndex) {
                return c.LAST_PRESENT.resultIndex(comparator, key, list, foundIndex) + 1;
            }
        }

        public final enum e extends c {
            public e(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // f1.p6.c
            public <E> int resultIndex(Comparator<? super E> comparator, @m5 E key, List<? extends E> list, int foundIndex) {
                return c.FIRST_PRESENT.resultIndex(comparator, key, list, foundIndex) - 1;
            }
        }

        public c(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static /* synthetic */ c[] a() {
            return new c[]{ANY_PRESENT, LAST_PRESENT, FIRST_PRESENT, FIRST_AFTER, LAST_BEFORE};
        }

        public static c valueOf(String name) {
            return (c) Enum.valueOf(c.class, name);
        }

        public static c[] values() {
            return (c[]) f5201a.clone();
        }

        public abstract <E> int resultIndex(Comparator<? super E> comparator, @m5 E key, List<? extends E> list, int foundIndex);

        public c(String str, int i10, a aVar) {
            super(str, i10);
        }
    }

    public static <E, K extends Comparable> int a(List<E> list, c1.t<? super E, K> keyFunction, K key, c presentBehavior, b absentBehavior) {
        key.getClass();
        return b(list, keyFunction, key, l5.natural(), presentBehavior, absentBehavior);
    }

    public static <E, K> int b(List<E> list, c1.t<? super E, K> keyFunction, @m5 K key, Comparator<? super K> keyComparator, c presentBehavior, b absentBehavior) {
        return d(p4.D(list, keyFunction), key, keyComparator, presentBehavior, absentBehavior);
    }

    public static <E extends Comparable> int c(List<? extends E> list, E e10, c presentBehavior, b absentBehavior) {
        e10.getClass();
        return d(list, e10, l5.natural(), presentBehavior, absentBehavior);
    }

    public static <E> int d(List<? extends E> list, @m5 E e10, Comparator<? super E> comparator, c cVar, b bVar) {
        comparator.getClass();
        list.getClass();
        cVar.getClass();
        bVar.getClass();
        if (!(list instanceof RandomAccess)) {
            list = p4.r(list);
        }
        int size = list.size() - 1;
        int i10 = 0;
        while (i10 <= size) {
            int i11 = (i10 + size) >>> 1;
            int iCompare = comparator.compare(e10, list.get(i11));
            if (iCompare < 0) {
                size = i11 - 1;
            } else {
                if (iCompare <= 0) {
                    return cVar.resultIndex(comparator, e10, list.subList(i10, size + 1), i11 - i10) + i10;
                }
                i10 = i11 + 1;
            }
        }
        return bVar.resultIndex(i10);
    }
}
