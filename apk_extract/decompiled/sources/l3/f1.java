package l3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f1 extends i1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Class f7236c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    @Override // l3.i1
    public final void a(long j8, Object obj) {
        Object objUnmodifiableList;
        List list = (List) x2.i(j8, obj);
        if (list instanceof e1) {
            objUnmodifiableList = ((e1) list).a();
        } else {
            if (f7236c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof x1) && (list instanceof y0)) {
                r rVar = (r) ((y0) list);
                boolean z2 = rVar.f7286a;
                if (z2 && z2) {
                    rVar.f7286a = false;
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        x2.p(j8, obj, objUnmodifiableList);
    }

    @Override // l3.i1
    public final void b(long j8, Object obj, Object obj2) {
        List list;
        List list2;
        List listB;
        List list3 = (List) x2.i(j8, obj2);
        int size = list3.size();
        List list4 = (List) x2.i(j8, obj);
        if (list4.isEmpty()) {
            if (list4 instanceof e1) {
                listB = new d1(size);
            } else {
                listB = ((list4 instanceof x1) && (list4 instanceof y0)) ? ((y0) list4).b(size) : new ArrayList(size);
            }
            x2.p(j8, obj, listB);
            list2 = listB;
        } else {
            if (f7236c.isAssignableFrom(list4.getClass())) {
                ArrayList arrayList = new ArrayList(list4.size() + size);
                arrayList.addAll(list4);
                x2.p(j8, obj, arrayList);
                list = arrayList;
            } else if (list4 instanceof s2) {
                d1 d1Var = new d1(list4.size() + size);
                d1Var.addAll(d1Var.f7231b.size(), (s2) list4);
                x2.p(j8, obj, d1Var);
                list = d1Var;
            } else if ((list4 instanceof x1) && (list4 instanceof y0)) {
                y0 y0Var = (y0) list4;
                if (!((r) y0Var).f7286a) {
                    list2 = list4;
                    list2 = list4;
                    list2 = list4;
                    y0 y0VarB = y0Var.b(list4.size() + size);
                    x2.p(j8, obj, y0VarB);
                    list2 = y0VarB;
                }
            }
            list2 = list;
        }
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        int size2 = list2.size();
        int size3 = list3.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list3);
        }
        if (size2 > 0) {
            list3 = list2;
        }
        x2.p(j8, obj, list3);
    }
}
