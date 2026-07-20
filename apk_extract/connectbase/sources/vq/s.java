package vq;

import java.util.ArrayList;
import kn.r1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@in.g
@r1({"SMAP\nInlineList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InlineList.kt\nkotlinx/coroutines/internal/InlineList\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,49:1\n1#2:50\n*E\n"})
public final class s<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public final Object f17878a;

    public /* synthetic */ s(Object obj) {
        this.f17878a = obj;
    }

    public static final /* synthetic */ s a(Object obj) {
        return new s(obj);
    }

    @os.l
    public static <E> Object b(@os.m Object obj) {
        return obj;
    }

    public static Object c(Object obj, int i10, kn.w wVar) {
        if ((i10 & 1) != 0) {
            return null;
        }
        return obj;
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof s) && kn.l0.g(obj, ((s) obj2).f17878a);
    }

    public static final boolean e(Object obj, Object obj2) {
        return kn.l0.g(obj, obj2);
    }

    public static final void f(Object obj, @os.l jn.l<? super E, l2> lVar) {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof ArrayList)) {
            lVar.invoke(obj);
            return;
        }
        kn.l0.n(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList arrayList = (ArrayList) obj;
        int size = arrayList.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            } else {
                lVar.invoke((Object) arrayList.get(size));
            }
        }
    }

    public static int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @os.l
    public static final Object h(Object obj, E e10) {
        if (obj == null) {
            return e10;
        }
        if (obj instanceof ArrayList) {
            kn.l0.n(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ((ArrayList) obj).add(e10);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e10);
        return arrayList;
    }

    public static String i(Object obj) {
        return em.a.a("InlineList(holder=", obj, ')');
    }

    public boolean equals(Object obj) {
        return d(this.f17878a, obj);
    }

    public int hashCode() {
        return g(this.f17878a);
    }

    public final /* synthetic */ Object j() {
        return this.f17878a;
    }

    public String toString() {
        return i(this.f17878a);
    }
}
