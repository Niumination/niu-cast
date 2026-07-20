package q1;

import f1.p4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@o0
public abstract class k0<V, C> extends u<V, C> {

    @gm.a
    public List<b<V>> I;

    public static final class a<V> extends k0<V, List<V>> {
        public a(f1.e3<? extends s1<? extends V>> futures, boolean allMustSucceed) {
            super(futures, allMustSucceed);
            U();
        }

        @Override // q1.k0
        /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
        public List<V> a0(List<b<V>> values) {
            ArrayList arrayListU = p4.u(values.size());
            Iterator<b<V>> it = values.iterator();
            while (it.hasNext()) {
                b<V> next = it.next();
                arrayListU.add(next != null ? next.f13586a : null);
            }
            return Collections.unmodifiableList(arrayListU);
        }
    }

    public static final class b<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c2
        public final V f13586a;

        public b(@c2 V value) {
            this.f13586a = value;
        }
    }

    public k0(f1.e3<? extends s1<? extends V>> futures, boolean allMustSucceed) {
        super(futures, allMustSucceed, true);
        List<b<V>> listEmptyList = futures.isEmpty() ? Collections.emptyList() : p4.u(futures.size());
        for (int i10 = 0; i10 < futures.size(); i10++) {
            listEmptyList.add(null);
        }
        this.I = listEmptyList;
    }

    @Override // q1.u
    public final void P(int index, @c2 V returnValue) {
        List<b<V>> list = this.I;
        if (list != null) {
            list.set(index, new b<>(returnValue));
        }
    }

    @Override // q1.u
    public final void S() {
        List<b<V>> list = this.I;
        if (list != null) {
            B(a0(list));
        }
    }

    @Override // q1.u
    public void Z(u.a reason) {
        super.Z(reason);
        this.I = null;
    }

    public abstract C a0(List<b<V>> values);
}
