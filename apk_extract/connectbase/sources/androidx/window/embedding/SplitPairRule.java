package androidx.window.embedding;

import androidx.window.core.ExperimentalWindowApi;
import java.util.LinkedHashSet;
import java.util.Set;
import k0.d;
import kn.l0;
import kn.w;
import nm.h0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
public final class SplitPairRule extends SplitRule {
    private final boolean clearTop;

    @l
    private final Set<SplitPairFilter> filters;
    private final int finishPrimaryWithSecondary;
    private final int finishSecondaryWithPrimary;

    public /* synthetic */ SplitPairRule(Set set, int i10, int i11, boolean z10, int i12, int i13, float f10, int i14, int i15, w wVar) {
        this(set, (i15 & 2) != 0 ? 0 : i10, (i15 & 4) != 0 ? 1 : i11, (i15 & 8) != 0 ? false : z10, (i15 & 16) != 0 ? 0 : i12, (i15 & 32) == 0 ? i13 : 0, (i15 & 64) != 0 ? 0.5f : f10, (i15 & 128) != 0 ? 3 : i14);
    }

    @Override // androidx.window.embedding.SplitRule
    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPairRule) || !super.equals(obj)) {
            return false;
        }
        SplitPairRule splitPairRule = (SplitPairRule) obj;
        return l0.g(this.filters, splitPairRule.filters) && this.finishPrimaryWithSecondary == splitPairRule.finishPrimaryWithSecondary && this.finishSecondaryWithPrimary == splitPairRule.finishSecondaryWithPrimary && this.clearTop == splitPairRule.clearTop;
    }

    public final boolean getClearTop() {
        return this.clearTop;
    }

    @l
    public final Set<SplitPairFilter> getFilters() {
        return this.filters;
    }

    public final int getFinishPrimaryWithSecondary() {
        return this.finishPrimaryWithSecondary;
    }

    public final int getFinishSecondaryWithPrimary() {
        return this.finishSecondaryWithPrimary;
    }

    @Override // androidx.window.embedding.SplitRule
    public int hashCode() {
        return Boolean.hashCode(this.clearTop) + d.a(this.finishSecondaryWithPrimary, d.a(this.finishPrimaryWithSecondary, (this.filters.hashCode() + (super.hashCode() * 31)) * 31, 31), 31);
    }

    @l
    public final SplitPairRule plus$window_release(@l SplitPairFilter splitPairFilter) {
        l0.p(splitPairFilter, "filter");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(splitPairFilter);
        return new SplitPairRule(h0.a6(linkedHashSet), this.finishPrimaryWithSecondary, this.finishSecondaryWithPrimary, this.clearTop, getMinWidth(), getMinSmallestWidth(), getSplitRatio(), getLayoutDirection());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitPairRule(@l Set<SplitPairFilter> set, int i10, int i11, boolean z10, int i12, int i13, float f10, int i14) {
        super(i12, i13, f10, i14);
        l0.p(set, "filters");
        this.finishPrimaryWithSecondary = i10;
        this.finishSecondaryWithPrimary = i11;
        this.clearTop = z10;
        this.filters = h0.a6(set);
    }
}
