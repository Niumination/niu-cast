package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import gq.m;
import java.util.Iterator;
import jn.p;
import k4.f;
import kn.l0;
import kn.r1;
import lm.l2;
import ln.d;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nMenu.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Menu.kt\nandroidx/core/view/MenuKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,90:1\n1#2:91\n*E\n"})
public final class MenuKt {

    /* JADX INFO: renamed from: androidx.core.view.MenuKt$iterator$1, reason: invalid class name */
    @r1({"SMAP\nMenu.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Menu.kt\nandroidx/core/view/MenuKt$iterator$1\n+ 2 Menu.kt\nandroidx/core/view/MenuKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,90:1\n83#2:91\n1#3:92\n*S KotlinDebug\n*F\n+ 1 Menu.kt\nandroidx/core/view/MenuKt$iterator$1\n*L\n74#1:91\n74#1:92\n*E\n"})
    public static final class AnonymousClass1 implements Iterator<MenuItem>, d {
        final /* synthetic */ Menu $this_iterator;
        private int index;

        public AnonymousClass1(Menu menu) {
            this.$this_iterator = menu;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.size();
        }

        @Override // java.util.Iterator
        public void remove() {
            l2 l2Var;
            Menu menu = this.$this_iterator;
            int i10 = this.index - 1;
            this.index = i10;
            MenuItem item = menu.getItem(i10);
            if (item != null) {
                l0.o(item, "getItem(index)");
                menu.removeItem(item.getItemId());
                l2Var = l2.f10208a;
            } else {
                l2Var = null;
            }
            if (l2Var == null) {
                throw new IndexOutOfBoundsException();
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        @l
        public MenuItem next() {
            Menu menu = this.$this_iterator;
            int i10 = this.index;
            this.index = i10 + 1;
            MenuItem item = menu.getItem(i10);
            if (item != null) {
                return item;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(@l Menu menu, @l MenuItem menuItem) {
        l0.p(menu, "<this>");
        l0.p(menuItem, "item");
        int size = menu.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (l0.g(menu.getItem(i10), menuItem)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(@l Menu menu, @l jn.l<? super MenuItem, l2> lVar) {
        l0.p(menu, "<this>");
        l0.p(lVar, f.f8937e);
        int size = menu.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = menu.getItem(i10);
            l0.o(item, "getItem(index)");
            lVar.invoke(item);
        }
    }

    public static final void forEachIndexed(@l Menu menu, @l p<? super Integer, ? super MenuItem, l2> pVar) {
        l0.p(menu, "<this>");
        l0.p(pVar, f.f8937e);
        int size = menu.size();
        for (int i10 = 0; i10 < size; i10++) {
            Integer numValueOf = Integer.valueOf(i10);
            MenuItem item = menu.getItem(i10);
            l0.o(item, "getItem(index)");
            pVar.invoke(numValueOf, item);
        }
    }

    @l
    public static final MenuItem get(@l Menu menu, int i10) {
        l0.p(menu, "<this>");
        MenuItem item = menu.getItem(i10);
        l0.o(item, "getItem(index)");
        return item;
    }

    @l
    public static final m<MenuItem> getChildren(@l final Menu menu) {
        l0.p(menu, "<this>");
        return new m<MenuItem>() { // from class: androidx.core.view.MenuKt$children$1
            @Override // gq.m
            @l
            public Iterator<MenuItem> iterator() {
                return MenuKt.iterator(menu);
            }
        };
    }

    public static final int getSize(@l Menu menu) {
        l0.p(menu, "<this>");
        return menu.size();
    }

    public static final boolean isEmpty(@l Menu menu) {
        l0.p(menu, "<this>");
        return menu.size() == 0;
    }

    public static final boolean isNotEmpty(@l Menu menu) {
        l0.p(menu, "<this>");
        return menu.size() != 0;
    }

    @l
    public static final Iterator<MenuItem> iterator(@l Menu menu) {
        l0.p(menu, "<this>");
        return new AnonymousClass1(menu);
    }

    public static final void minusAssign(@l Menu menu, @l MenuItem menuItem) {
        l0.p(menu, "<this>");
        l0.p(menuItem, "item");
        menu.removeItem(menuItem.getItemId());
    }

    public static final void removeItemAt(@l Menu menu, int i10) {
        l2 l2Var;
        l0.p(menu, "<this>");
        MenuItem item = menu.getItem(i10);
        if (item != null) {
            menu.removeItem(item.getItemId());
            l2Var = l2.f10208a;
        } else {
            l2Var = null;
        }
        if (l2Var == null) {
            throw new IndexOutOfBoundsException();
        }
    }
}
