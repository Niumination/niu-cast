package androidx.window.embedding;

import android.content.Intent;
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
public final class SplitPlaceholderRule extends SplitRule {

    @l
    private final Set<ActivityFilter> filters;
    private final int finishPrimaryWithSecondary;
    private final boolean isSticky;

    @l
    private final Intent placeholderIntent;

    public /* synthetic */ SplitPlaceholderRule(Set set, Intent intent, boolean z10, int i10, int i11, int i12, float f10, int i13, int i14, w wVar) {
        this(set, intent, z10, (i14 & 8) != 0 ? 1 : i10, (i14 & 16) != 0 ? 0 : i11, (i14 & 32) != 0 ? 0 : i12, (i14 & 64) != 0 ? 0.5f : f10, (i14 & 128) != 0 ? 3 : i13);
    }

    @Override // androidx.window.embedding.SplitRule
    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPlaceholderRule) || !super.equals(obj)) {
            return false;
        }
        SplitPlaceholderRule splitPlaceholderRule = (SplitPlaceholderRule) obj;
        return l0.g(this.placeholderIntent, splitPlaceholderRule.placeholderIntent) && this.isSticky == splitPlaceholderRule.isSticky && this.finishPrimaryWithSecondary == splitPlaceholderRule.finishPrimaryWithSecondary && l0.g(this.filters, splitPlaceholderRule.filters);
    }

    @l
    public final Set<ActivityFilter> getFilters() {
        return this.filters;
    }

    public final int getFinishPrimaryWithSecondary() {
        return this.finishPrimaryWithSecondary;
    }

    @l
    public final Intent getPlaceholderIntent() {
        return this.placeholderIntent;
    }

    @Override // androidx.window.embedding.SplitRule
    public int hashCode() {
        return this.filters.hashCode() + d.a(this.finishPrimaryWithSecondary, (Boolean.hashCode(this.isSticky) + ((this.placeholderIntent.hashCode() + (super.hashCode() * 31)) * 31)) * 31, 31);
    }

    public final boolean isSticky() {
        return this.isSticky;
    }

    @l
    public final SplitPlaceholderRule plus$window_release(@l ActivityFilter activityFilter) {
        l0.p(activityFilter, "filter");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(activityFilter);
        return new SplitPlaceholderRule(h0.a6(linkedHashSet), this.placeholderIntent, this.isSticky, this.finishPrimaryWithSecondary, getMinWidth(), getMinSmallestWidth(), getSplitRatio(), getLayoutDirection());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitPlaceholderRule(@l Set<ActivityFilter> set, @l Intent intent, boolean z10, int i10, int i11, int i12, float f10, int i13) {
        super(i11, i12, f10, i13);
        l0.p(set, "filters");
        l0.p(intent, "placeholderIntent");
        this.placeholderIntent = intent;
        this.isSticky = z10;
        this.finishPrimaryWithSecondary = i10;
        this.filters = h0.a6(set);
    }
}
