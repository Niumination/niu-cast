package nm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lm.b2;
import lm.h2;
import lm.x1;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nArrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Arrays.kt\nkotlin/collections/ArraysKt__ArraysKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,161:1\n1#2:162\n*E\n"})
public class n extends m {
    /* JADX WARN: Multi-variable type inference failed */
    @lm.f1(version = "1.3")
    @in.i(name = "contentDeepEquals")
    @lm.z0
    public static final <T> boolean g(@os.m T[] tArr, @os.m T[] tArr2) {
        if (tArr == tArr2) {
            return true;
        }
        if (tArr == 0 || tArr2 == 0 || tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            Object[] objArr = tArr[i10];
            Object[] objArr2 = tArr2[i10];
            if (objArr != objArr2) {
                if (objArr == 0 || objArr2 == 0) {
                    return false;
                }
                if ((objArr instanceof Object[]) && (objArr2 instanceof Object[])) {
                    if (!g(objArr, objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof byte[]) && (objArr2 instanceof byte[])) {
                    if (!Arrays.equals((byte[]) objArr, (byte[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof short[]) && (objArr2 instanceof short[])) {
                    if (!Arrays.equals((short[]) objArr, (short[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof int[]) && (objArr2 instanceof int[])) {
                    if (!Arrays.equals((int[]) objArr, (int[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof long[]) && (objArr2 instanceof long[])) {
                    if (!Arrays.equals((long[]) objArr, (long[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof float[]) && (objArr2 instanceof float[])) {
                    if (!Arrays.equals((float[]) objArr, (float[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof double[]) && (objArr2 instanceof double[])) {
                    if (!Arrays.equals((double[]) objArr, (double[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof char[]) && (objArr2 instanceof char[])) {
                    if (!Arrays.equals((char[]) objArr, (char[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof boolean[]) && (objArr2 instanceof boolean[])) {
                    if (!Arrays.equals((boolean[]) objArr, (boolean[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof lm.t1) && (objArr2 instanceof lm.t1)) {
                    if (!qm.g.U0(((lm.t1) objArr).f10219a, ((lm.t1) objArr2).f10219a)) {
                        return false;
                    }
                } else if ((objArr instanceof h2) && (objArr2 instanceof h2)) {
                    if (!qm.g.S0(((h2) objArr).f10197a, ((h2) objArr2).f10197a)) {
                        return false;
                    }
                } else if ((objArr instanceof x1) && (objArr2 instanceof x1)) {
                    if (!qm.g.T0(((x1) objArr).f10228a, ((x1) objArr2).f10228a)) {
                        return false;
                    }
                } else if ((objArr instanceof b2) && (objArr2 instanceof b2)) {
                    if (!qm.g.V0(((b2) objArr).f10181a, ((b2) objArr2).f10181a)) {
                        return false;
                    }
                } else if (!kn.l0.g(objArr, objArr2)) {
                    return false;
                }
            }
        }
        return true;
    }

    @in.i(name = "contentDeepToString")
    @lm.f1(version = "1.3")
    @lm.z0
    @os.l
    public static final <T> String h(@os.m T[] tArr) {
        if (tArr == null) {
            return d6.a.E;
        }
        int length = tArr.length;
        if (length > 429496729) {
            length = 429496729;
        }
        StringBuilder sb2 = new StringBuilder((length * 5) + 2);
        i(tArr, sb2, new ArrayList());
        String string = sb2.toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void i(T[] tArr, StringBuilder sb2, List<Object[]> list) {
        if (list.contains(tArr)) {
            sb2.append("[...]");
            return;
        }
        list.add(tArr);
        sb2.append(ks.a.f9445d);
        int length = tArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(", ");
            }
            Object[] objArr = tArr[i10];
            if (objArr == 0) {
                sb2.append(d6.a.E);
            } else if (objArr instanceof Object[]) {
                i(objArr, sb2, list);
            } else if (objArr instanceof byte[]) {
                String string = Arrays.toString((byte[]) objArr);
                kn.l0.o(string, "toString(...)");
                sb2.append(string);
            } else if (objArr instanceof short[]) {
                String string2 = Arrays.toString((short[]) objArr);
                kn.l0.o(string2, "toString(...)");
                sb2.append(string2);
            } else if (objArr instanceof int[]) {
                String string3 = Arrays.toString((int[]) objArr);
                kn.l0.o(string3, "toString(...)");
                sb2.append(string3);
            } else if (objArr instanceof long[]) {
                String string4 = Arrays.toString((long[]) objArr);
                kn.l0.o(string4, "toString(...)");
                sb2.append(string4);
            } else if (objArr instanceof float[]) {
                String string5 = Arrays.toString((float[]) objArr);
                kn.l0.o(string5, "toString(...)");
                sb2.append(string5);
            } else if (objArr instanceof double[]) {
                String string6 = Arrays.toString((double[]) objArr);
                kn.l0.o(string6, "toString(...)");
                sb2.append(string6);
            } else if (objArr instanceof char[]) {
                String string7 = Arrays.toString((char[]) objArr);
                kn.l0.o(string7, "toString(...)");
                sb2.append(string7);
            } else if (objArr instanceof boolean[]) {
                String string8 = Arrays.toString((boolean[]) objArr);
                kn.l0.o(string8, "toString(...)");
                sb2.append(string8);
            } else if (objArr instanceof lm.t1) {
                sb2.append(qm.g.a1(((lm.t1) objArr).f10219a));
            } else if (objArr instanceof h2) {
                sb2.append(qm.g.c1(((h2) objArr).f10197a));
            } else if (objArr instanceof x1) {
                sb2.append(qm.g.b1(((x1) objArr).f10228a));
            } else if (objArr instanceof b2) {
                sb2.append(qm.g.d1(((b2) objArr).f10181a));
            } else {
                sb2.append(objArr.toString());
            }
        }
        sb2.append(']');
        list.remove(y.J(list));
    }

    @os.l
    public static final <T> List<T> j(@os.l T[][] tArr) {
        kn.l0.p(tArr, "<this>");
        int length = 0;
        for (T[] tArr2 : tArr) {
            length += tArr2.length;
        }
        ArrayList arrayList = new ArrayList(length);
        for (T[] tArr3 : tArr) {
            d0.s0(arrayList, tArr3);
        }
        return arrayList;
    }

    /* JADX WARN: Incorrect types in method signature: <C:[Ljava/lang/Object;:TR;R:Ljava/lang/Object;>(TC;Ljn/a<+TR;>;)TR; */
    @lm.f1(version = "1.3")
    @an.f
    public static final Object k(Object[] objArr, jn.a aVar) {
        kn.l0.p(aVar, "defaultValue");
        return objArr.length == 0 ? aVar.invoke() : objArr;
    }

    @lm.f1(version = "1.3")
    @an.f
    public static final boolean l(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    @os.l
    public static final <T, R> lm.t0<List<T>, List<R>> m(@os.l lm.t0<? extends T, ? extends R>[] t0VarArr) {
        kn.l0.p(t0VarArr, "<this>");
        ArrayList arrayList = new ArrayList(t0VarArr.length);
        ArrayList arrayList2 = new ArrayList(t0VarArr.length);
        for (lm.t0<? extends T, ? extends R> t0Var : t0VarArr) {
            arrayList.add(t0Var.getFirst());
            arrayList2.add(t0Var.getSecond());
        }
        return new lm.t0<>(arrayList, arrayList2);
    }
}
