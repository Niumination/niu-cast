package com.transsion.backup.model;

import i0.a;
import java.util.List;
import k0.d;
import kn.l0;
import kn.w;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class PageData<T> {
    private final int currentPage;

    @m
    private final List<T> data;
    private final int totalPage;

    public PageData() {
        this(0, 0, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PageData copy$default(PageData pageData, int i10, int i11, List list, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = pageData.currentPage;
        }
        if ((i12 & 2) != 0) {
            i11 = pageData.totalPage;
        }
        if ((i12 & 4) != 0) {
            list = pageData.data;
        }
        return pageData.copy(i10, i11, list);
    }

    public final int component1() {
        return this.currentPage;
    }

    public final int component2() {
        return this.totalPage;
    }

    @m
    public final List<T> component3() {
        return this.data;
    }

    @l
    public final PageData<T> copy(int i10, int i11, @m List<? extends T> list) {
        return new PageData<>(i10, i11, list);
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PageData)) {
            return false;
        }
        PageData pageData = (PageData) obj;
        return this.currentPage == pageData.currentPage && this.totalPage == pageData.totalPage && l0.g(this.data, pageData.data);
    }

    public final int getCurrentPage() {
        return this.currentPage;
    }

    @m
    public final List<T> getData() {
        return this.data;
    }

    public final int getTotalPage() {
        return this.totalPage;
    }

    public int hashCode() {
        int iA = d.a(this.totalPage, Integer.hashCode(this.currentPage) * 31, 31);
        List<T> list = this.data;
        return iA + (list == null ? 0 : list.hashCode());
    }

    @l
    public String toString() {
        int i10 = this.currentPage;
        int i11 = this.totalPage;
        List<T> list = this.data;
        StringBuilder sbA = a.a("PageData(currentPage=", i10, ", totalPage=", i11, ", data=");
        sbA.append(list);
        sbA.append(")");
        return sbA.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PageData(int i10, int i11, @m List<? extends T> list) {
        this.currentPage = i10;
        this.totalPage = i11;
        this.data = list;
    }

    public /* synthetic */ PageData(int i10, int i11, List list, int i12, w wVar) {
        this((i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? 1 : i11, (i12 & 4) != 0 ? null : list);
    }
}
