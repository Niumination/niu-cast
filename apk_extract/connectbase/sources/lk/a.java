package lk;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import jn.p;
import kn.l0;
import kn.n0;
import kn.w;
import nm.k0;
import os.l;
import p6.s;

/* JADX INFO: loaded from: classes2.dex */
public final class a<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final C0264a f10100b = new C0264a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final b<T> f10101a;

    /* JADX INFO: renamed from: lk.a$a, reason: collision with other inner class name */
    public static final class C0264a {

        /* JADX INFO: renamed from: lk.a$a$a, reason: collision with other inner class name */
        public static final class C0265a extends n0 implements jn.l<T, Integer> {
            public static final C0265a INSTANCE = new C0265a();

            public C0265a() {
                super(1);
            }

            /* JADX WARN: Incorrect types in method signature: (TT;)Ljava/lang/Integer; */
            @Override // jn.l
            @l
            public final Integer invoke(@l CharSequence charSequence) {
                l0.p(charSequence, "it");
                return Integer.valueOf(charSequence.length());
            }
        }

        /* JADX INFO: renamed from: lk.a$a$b */
        public static final class b extends n0 implements p<T, Integer, Character> {
            public static final b INSTANCE = new b();

            public b() {
                super(2);
            }

            /* JADX WARN: Incorrect types in method signature: (TT;I)Ljava/lang/Character; */
            @l
            public final Character invoke(@l CharSequence charSequence, int i10) {
                l0.p(charSequence, s.f13016a);
                return Character.valueOf(charSequence.charAt(i10));
            }

            @Override // jn.p
            public /* bridge */ /* synthetic */ Character invoke(Object obj, Integer num) {
                return invoke((CharSequence) obj, num.intValue());
            }
        }

        public C0264a() {
        }

        @l
        public final <T extends CharSequence> a<T> a(@l List<? extends T> list) {
            l0.p(list, TypedValues.TransitionType.S_FROM);
            return b(list, C0265a.INSTANCE, b.INSTANCE);
        }

        @l
        public final <T> a<T> b(@l List<? extends T> list, @l jn.l<? super T, Integer> lVar, @l p<? super T, ? super Integer, Character> pVar) {
            T next;
            l0.p(list, TypedValues.TransitionType.S_FROM);
            l0.p(lVar, "length");
            l0.p(pVar, "charAt");
            List<? extends T> list2 = list;
            Iterator<T> it = list2.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    Integer numInvoke = lVar.invoke(next);
                    do {
                        T next2 = it.next();
                        Integer numInvoke2 = lVar.invoke(next2);
                        if (numInvoke.compareTo(numInvoke2) < 0) {
                            next = next2;
                            numInvoke = numInvoke2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            Integer numInvoke3 = next != null ? lVar.invoke(next) : null;
            if (numInvoke3 == null) {
                throw new NoSuchElementException("Unable to build char tree from an empty list");
            }
            int iIntValue = numInvoke3.intValue();
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (lVar.invoke(it2.next()).intValue() == 0) {
                        throw new IllegalArgumentException("There should be no empty entries");
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            c(arrayList, list, iIntValue, 0, lVar, pVar);
            arrayList.trimToSize();
            return new a<>(new b((char) 0, k0.INSTANCE, arrayList));
        }

        public final <T> void c(List<b<T>> list, List<? extends T> list2, int i10, int i11, jn.l<? super T, Integer> lVar, p<? super T, ? super Integer, Character> pVar) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (T t10 : list2) {
                Character chInvoke = pVar.invoke(t10, Integer.valueOf(i11));
                chInvoke.charValue();
                Object arrayList = linkedHashMap.get(chInvoke);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(chInvoke, arrayList);
                }
                ((List) arrayList).add(t10);
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                char cCharValue = ((Character) entry.getKey()).charValue();
                List list3 = (List) entry.getValue();
                int i12 = i11 + 1;
                ArrayList arrayList2 = new ArrayList();
                C0264a c0264a = a.f10100b;
                List list4 = list3;
                ArrayList arrayList3 = new ArrayList();
                for (T t11 : list4) {
                    if (lVar.invoke(t11).intValue() > i12) {
                        arrayList3.add(t11);
                    }
                }
                c0264a.c(arrayList2, arrayList3, i10, i12, lVar, pVar);
                arrayList2.trimToSize();
                ArrayList arrayList4 = new ArrayList();
                for (T t12 : list4) {
                    if (lVar.invoke(t12).intValue() == i12) {
                        arrayList4.add(t12);
                    }
                }
                list.add(new b<>(cCharValue, arrayList4, arrayList2));
            }
        }

        public C0264a(w wVar) {
        }
    }

    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char f10102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @l
        public final List<T> f10103b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @l
        public final List<b<T>> f10104c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @l
        public final b<T>[] f10105d;

        /* JADX WARN: Multi-variable type inference failed */
        public b(char c10, @l List<? extends T> list, @l List<b<T>> list2) {
            l0.p(list, "exact");
            l0.p(list2, "children");
            this.f10102a = c10;
            this.f10103b = list;
            this.f10104c = list2;
            b<T>[] bVarArr = new b[256];
            for (int i10 = 0; i10 < 256; i10++) {
                Iterator<T> it = this.f10104c.iterator();
                b<T> bVar = null;
                boolean z10 = false;
                b<T> bVar2 = null;
                while (true) {
                    if (!it.hasNext()) {
                        if (!z10) {
                            break;
                        }
                        bVar = bVar2;
                        break;
                    } else {
                        T next = it.next();
                        if (((b) next).f10102a == i10) {
                            if (z10) {
                                break;
                            }
                            z10 = true;
                            bVar2 = next;
                        }
                    }
                }
                bVarArr[i10] = bVar;
            }
            this.f10105d = bVarArr;
        }

        @l
        public final b<T>[] a() {
            return this.f10105d;
        }

        public final char b() {
            return this.f10102a;
        }

        @l
        public final List<b<T>> c() {
            return this.f10104c;
        }

        @l
        public final List<T> d() {
            return this.f10103b;
        }
    }

    public a(@l b<T> bVar) {
        l0.p(bVar, "root");
        this.f10101a = bVar;
    }

    public static /* synthetic */ List c(a aVar, CharSequence charSequence, int i10, int i11, boolean z10, p pVar, int i12, Object obj) {
        int i13 = (i12 & 2) != 0 ? 0 : i10;
        if ((i12 & 4) != 0) {
            i11 = charSequence.length();
        }
        return aVar.b(charSequence, i13, i11, (i12 & 8) != 0 ? false : z10, pVar);
    }

    @l
    public final b<T> a() {
        return this.f10101a;
    }

    @l
    public final List<T> b(@l CharSequence charSequence, int i10, int i11, boolean z10, @l p<? super Character, ? super Integer, Boolean> pVar) {
        l0.p(charSequence, "sequence");
        l0.p(pVar, "stopPredicate");
        if (charSequence.length() == 0) {
            throw new IllegalArgumentException("Couldn't search in char tree for empty string");
        }
        b<T> bVar = this.f10101a;
        while (i10 < i11) {
            int i12 = i10 + 1;
            char cCharAt = charSequence.charAt(i10);
            if (pVar.invoke(Character.valueOf(cCharAt), Integer.valueOf(cCharAt)).booleanValue()) {
                break;
            }
            b<T>[] bVarArr = bVar.f10105d;
            b<T> bVar2 = bVarArr[cCharAt];
            if (bVar2 == null) {
                bVar = z10 ? bVarArr[Character.toLowerCase(cCharAt)] : null;
                if (bVar == null) {
                    return k0.INSTANCE;
                }
            } else {
                bVar = bVar2;
            }
            i10 = i12;
        }
        return bVar.f10103b;
    }
}
