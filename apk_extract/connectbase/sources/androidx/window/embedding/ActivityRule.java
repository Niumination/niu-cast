package androidx.window.embedding;

import androidx.window.core.ExperimentalWindowApi;
import java.util.LinkedHashSet;
import java.util.Set;
import kn.l0;
import kn.w;
import nm.h0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
public final class ActivityRule extends EmbeddingRule {
    private final boolean alwaysExpand;

    @l
    private final Set<ActivityFilter> filters;

    public /* synthetic */ ActivityRule(Set set, boolean z10, int i10, w wVar) {
        this(set, (i10 & 2) != 0 ? false : z10);
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityRule)) {
            return false;
        }
        ActivityRule activityRule = (ActivityRule) obj;
        return l0.g(this.filters, activityRule.filters) && this.alwaysExpand == activityRule.alwaysExpand;
    }

    public final boolean getAlwaysExpand() {
        return this.alwaysExpand;
    }

    @l
    public final Set<ActivityFilter> getFilters() {
        return this.filters;
    }

    public int hashCode() {
        return Boolean.hashCode(this.alwaysExpand) + (this.filters.hashCode() * 31);
    }

    @l
    public final ActivityRule plus$window_release(@l ActivityFilter activityFilter) {
        l0.p(activityFilter, "filter");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(activityFilter);
        return new ActivityRule(h0.a6(linkedHashSet), this.alwaysExpand);
    }

    public ActivityRule(@l Set<ActivityFilter> set, boolean z10) {
        l0.p(set, "filters");
        this.alwaysExpand = z10;
        this.filters = h0.a6(set);
    }
}
