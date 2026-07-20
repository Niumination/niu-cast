package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import gq.m;
import gq.q;
import java.util.Iterator;
import jn.p;
import k4.f;
import kn.l0;
import lm.l2;
import ln.d;
import os.l;
import tn.u;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGroupKt {

    /* JADX INFO: renamed from: androidx.core.view.ViewGroupKt$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<View>, d {
        final /* synthetic */ ViewGroup $this_iterator;
        private int index;

        public AnonymousClass1(ViewGroup viewGroup) {
            this.$this_iterator = viewGroup;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.getChildCount();
        }

        @Override // java.util.Iterator
        public void remove() {
            ViewGroup viewGroup = this.$this_iterator;
            int i10 = this.index - 1;
            this.index = i10;
            viewGroup.removeViewAt(i10);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        @l
        public View next() {
            ViewGroup viewGroup = this.$this_iterator;
            int i10 = this.index;
            this.index = i10 + 1;
            View childAt = viewGroup.getChildAt(i10);
            if (childAt != null) {
                return childAt;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(@l ViewGroup viewGroup, @l View view) {
        l0.p(viewGroup, "<this>");
        l0.p(view, "view");
        return viewGroup.indexOfChild(view) != -1;
    }

    public static final void forEach(@l ViewGroup viewGroup, @l jn.l<? super View, l2> lVar) {
        l0.p(viewGroup, "<this>");
        l0.p(lVar, f.f8937e);
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            l0.o(childAt, "getChildAt(index)");
            lVar.invoke(childAt);
        }
    }

    public static final void forEachIndexed(@l ViewGroup viewGroup, @l p<? super Integer, ? super View, l2> pVar) {
        l0.p(viewGroup, "<this>");
        l0.p(pVar, f.f8937e);
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            Integer numValueOf = Integer.valueOf(i10);
            View childAt = viewGroup.getChildAt(i10);
            l0.o(childAt, "getChildAt(index)");
            pVar.invoke(numValueOf, childAt);
        }
    }

    @l
    public static final View get(@l ViewGroup viewGroup, int i10) {
        l0.p(viewGroup, "<this>");
        View childAt = viewGroup.getChildAt(i10);
        if (childAt != null) {
            return childAt;
        }
        StringBuilder sbA = h.b.a("Index: ", i10, ", Size: ");
        sbA.append(viewGroup.getChildCount());
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    @l
    public static final m<View> getChildren(@l final ViewGroup viewGroup) {
        l0.p(viewGroup, "<this>");
        return new m<View>() { // from class: androidx.core.view.ViewGroupKt$children$1
            @Override // gq.m
            @l
            public Iterator<View> iterator() {
                return ViewGroupKt.iterator(viewGroup);
            }
        };
    }

    @l
    public static final m<View> getDescendants(@l ViewGroup viewGroup) {
        l0.p(viewGroup, "<this>");
        return q.b(new ViewGroupKt$descendants$1(viewGroup, null));
    }

    @l
    public static final tn.l getIndices(@l ViewGroup viewGroup) {
        l0.p(viewGroup, "<this>");
        return u.W1(0, viewGroup.getChildCount());
    }

    public static final int getSize(@l ViewGroup viewGroup) {
        l0.p(viewGroup, "<this>");
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(@l ViewGroup viewGroup) {
        l0.p(viewGroup, "<this>");
        return viewGroup.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(@l ViewGroup viewGroup) {
        l0.p(viewGroup, "<this>");
        return viewGroup.getChildCount() != 0;
    }

    @l
    public static final Iterator<View> iterator(@l ViewGroup viewGroup) {
        l0.p(viewGroup, "<this>");
        return new AnonymousClass1(viewGroup);
    }

    public static final void minusAssign(@l ViewGroup viewGroup, @l View view) {
        l0.p(viewGroup, "<this>");
        l0.p(view, "view");
        viewGroup.removeView(view);
    }

    public static final void plusAssign(@l ViewGroup viewGroup, @l View view) {
        l0.p(viewGroup, "<this>");
        l0.p(view, "view");
        viewGroup.addView(view);
    }

    public static final void setMargins(@l ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i10) {
        l0.p(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i10, i10, i10, i10);
    }

    public static final void updateMargins(@l ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i10, @Px int i11, @Px int i12, @Px int i13) {
        l0.p(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i10, i11, i12, i13);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = marginLayoutParams.leftMargin;
        }
        if ((i14 & 2) != 0) {
            i11 = marginLayoutParams.topMargin;
        }
        if ((i14 & 4) != 0) {
            i12 = marginLayoutParams.rightMargin;
        }
        if ((i14 & 8) != 0) {
            i13 = marginLayoutParams.bottomMargin;
        }
        l0.p(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i10, i11, i12, i13);
    }

    @RequiresApi(17)
    @b.a({"ClassVerificationFailure"})
    public static final void updateMarginsRelative(@l ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i10, @Px int i11, @Px int i12, @Px int i13) {
        l0.p(marginLayoutParams, "<this>");
        marginLayoutParams.setMarginStart(i10);
        marginLayoutParams.topMargin = i11;
        marginLayoutParams.setMarginEnd(i12);
        marginLayoutParams.bottomMargin = i13;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = marginLayoutParams.getMarginStart();
        }
        if ((i14 & 2) != 0) {
            i11 = marginLayoutParams.topMargin;
        }
        if ((i14 & 4) != 0) {
            i12 = marginLayoutParams.getMarginEnd();
        }
        if ((i14 & 8) != 0) {
            i13 = marginLayoutParams.bottomMargin;
        }
        l0.p(marginLayoutParams, "<this>");
        marginLayoutParams.setMarginStart(i10);
        marginLayoutParams.topMargin = i11;
        marginLayoutParams.setMarginEnd(i12);
        marginLayoutParams.bottomMargin = i13;
    }
}
