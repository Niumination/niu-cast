package androidx.window.embedding;

import android.app.Activity;
import android.content.Intent;
import android.view.WindowMetrics;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.core.PredicateAdapter;
import b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import jn.p;
import kn.l0;
import kn.l1;
import kn.n0;
import nm.h0;
import nm.o1;
import nm.z;
import os.l;
import y1.o;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
public final class EmbeddingAdapter {

    @l
    private final PredicateAdapter predicateAdapter;

    /* JADX INFO: renamed from: androidx.window.embedding.EmbeddingAdapter$translateActivityIntentPredicates$1, reason: invalid class name */
    public static final class AnonymousClass1 extends n0 implements p<Activity, Intent, Boolean> {
        final /* synthetic */ Set<SplitPairFilter> $splitPairFilters;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Set<SplitPairFilter> set) {
            super(2);
            this.$splitPairFilters = set;
        }

        @Override // jn.p
        @l
        public final Boolean invoke(@l Activity activity, @l Intent intent) {
            l0.p(activity, "first");
            l0.p(intent, o.r.f20674f);
            Set<SplitPairFilter> set = this.$splitPairFilters;
            boolean z10 = false;
            if (set == null || !set.isEmpty()) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    if (((SplitPairFilter) it.next()).matchesActivityIntentPair(activity, intent)) {
                        z10 = true;
                        break;
                    }
                }
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX INFO: renamed from: androidx.window.embedding.EmbeddingAdapter$translateActivityPairPredicates$1, reason: invalid class name and case insensitive filesystem */
    public static final class C06291 extends n0 implements p<Activity, Activity, Boolean> {
        final /* synthetic */ Set<SplitPairFilter> $splitPairFilters;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06291(Set<SplitPairFilter> set) {
            super(2);
            this.$splitPairFilters = set;
        }

        @Override // jn.p
        @l
        public final Boolean invoke(@l Activity activity, @l Activity activity2) {
            l0.p(activity, "first");
            l0.p(activity2, o.r.f20674f);
            Set<SplitPairFilter> set = this.$splitPairFilters;
            boolean z10 = false;
            if (set == null || !set.isEmpty()) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    if (((SplitPairFilter) it.next()).matchesActivityPair(activity, activity2)) {
                        z10 = true;
                        break;
                    }
                }
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX INFO: renamed from: androidx.window.embedding.EmbeddingAdapter$translateActivityPredicates$1, reason: invalid class name and case insensitive filesystem */
    public static final class C06301 extends n0 implements jn.l<Activity, Boolean> {
        final /* synthetic */ Set<ActivityFilter> $activityFilters;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06301(Set<ActivityFilter> set) {
            super(1);
            this.$activityFilters = set;
        }

        @Override // jn.l
        @l
        public final Boolean invoke(@l Activity activity) {
            l0.p(activity, "activity");
            Set<ActivityFilter> set = this.$activityFilters;
            boolean z10 = false;
            if (set == null || !set.isEmpty()) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    if (((ActivityFilter) it.next()).matchesActivity(activity)) {
                        z10 = true;
                        break;
                    }
                }
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX INFO: renamed from: androidx.window.embedding.EmbeddingAdapter$translateIntentPredicates$1, reason: invalid class name and case insensitive filesystem */
    public static final class C06311 extends n0 implements jn.l<Intent, Boolean> {
        final /* synthetic */ Set<ActivityFilter> $activityFilters;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06311(Set<ActivityFilter> set) {
            super(1);
            this.$activityFilters = set;
        }

        @Override // jn.l
        @l
        public final Boolean invoke(@l Intent intent) {
            l0.p(intent, "intent");
            Set<ActivityFilter> set = this.$activityFilters;
            boolean z10 = false;
            if (set == null || !set.isEmpty()) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    if (((ActivityFilter) it.next()).matchesIntent(intent)) {
                        z10 = true;
                        break;
                    }
                }
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX INFO: renamed from: androidx.window.embedding.EmbeddingAdapter$translateParentMetricsPredicate$1, reason: invalid class name and case insensitive filesystem */
    public static final class C06321 extends n0 implements jn.l<WindowMetrics, Boolean> {
        final /* synthetic */ SplitRule $splitRule;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06321(SplitRule splitRule) {
            super(1);
            this.$splitRule = splitRule;
        }

        @Override // jn.l
        @l
        public final Boolean invoke(@l WindowMetrics windowMetrics) {
            l0.p(windowMetrics, "windowMetrics");
            return Boolean.valueOf(this.$splitRule.checkParentMetrics(windowMetrics));
        }
    }

    public EmbeddingAdapter(@l PredicateAdapter predicateAdapter) {
        l0.p(predicateAdapter, "predicateAdapter");
        this.predicateAdapter = predicateAdapter;
    }

    @a({"ClassVerificationFailure", "NewApi"})
    private final Object translateActivityIntentPredicates(Set<SplitPairFilter> set) {
        return this.predicateAdapter.buildPairPredicate(l1.d(Activity.class), l1.f9319a.d(Intent.class), new AnonymousClass1(set));
    }

    @a({"ClassVerificationFailure", "NewApi"})
    private final Object translateActivityPairPredicates(Set<SplitPairFilter> set) {
        return this.predicateAdapter.buildPairPredicate(l1.d(Activity.class), l1.f9319a.d(Activity.class), new C06291(set));
    }

    @a({"ClassVerificationFailure", "NewApi"})
    private final Object translateActivityPredicates(Set<ActivityFilter> set) {
        return this.predicateAdapter.buildPredicate(l1.d(Activity.class), new C06301(set));
    }

    private final androidx.window.extensions.embedding.ActivityRule translateActivityRule(ActivityRule activityRule, Class<?> cls) {
        androidx.window.extensions.embedding.ActivityRule activityRuleBuild = ((androidx.window.extensions.embedding.ActivityRule.Builder) androidx.window.extensions.embedding.ActivityRule.Builder.class.getConstructor(cls, cls).newInstance(translateActivityPredicates(activityRule.getFilters()), translateIntentPredicates(activityRule.getFilters()))).setShouldAlwaysExpand(activityRule.getAlwaysExpand()).build();
        l0.o(activityRuleBuild, "ActivityRuleBuilder::cla…and)\n            .build()");
        return activityRuleBuild;
    }

    @a({"ClassVerificationFailure", "NewApi"})
    private final Object translateIntentPredicates(Set<ActivityFilter> set) {
        return this.predicateAdapter.buildPredicate(l1.d(Intent.class), new C06311(set));
    }

    @a({"ClassVerificationFailure", "NewApi"})
    private final Object translateParentMetricsPredicate(SplitRule splitRule) {
        return this.predicateAdapter.buildPredicate(l1.d(WindowMetrics.class), new C06321(splitRule));
    }

    @a({"WrongConstant"})
    private final androidx.window.extensions.embedding.SplitPairRule translateSplitPairRule(SplitPairRule splitPairRule, Class<?> cls) {
        androidx.window.extensions.embedding.SplitPairRule.Builder finishSecondaryWithPrimary = ((androidx.window.extensions.embedding.SplitPairRule.Builder) androidx.window.extensions.embedding.SplitPairRule.Builder.class.getConstructor(cls, cls, cls).newInstance(translateActivityPairPredicates(splitPairRule.getFilters()), translateActivityIntentPredicates(splitPairRule.getFilters()), translateParentMetricsPredicate(splitPairRule))).setSplitRatio(splitPairRule.getSplitRatio()).setLayoutDirection(splitPairRule.getLayoutDirection()).setShouldClearTop(splitPairRule.getClearTop()).setFinishPrimaryWithSecondary(splitPairRule.getFinishPrimaryWithSecondary()).setFinishSecondaryWithPrimary(splitPairRule.getFinishSecondaryWithPrimary());
        l0.o(finishSecondaryWithPrimary, "SplitPairRuleBuilder::cl…nishSecondaryWithPrimary)");
        androidx.window.extensions.embedding.SplitPairRule splitPairRuleBuild = finishSecondaryWithPrimary.build();
        l0.o(splitPairRuleBuild, "builder.build()");
        return splitPairRuleBuild;
    }

    @a({"WrongConstant"})
    private final androidx.window.extensions.embedding.SplitPlaceholderRule translateSplitPlaceholderRule(SplitPlaceholderRule splitPlaceholderRule, Class<?> cls) {
        androidx.window.extensions.embedding.SplitPlaceholderRule.Builder finishPrimaryWithSecondary = ((androidx.window.extensions.embedding.SplitPlaceholderRule.Builder) androidx.window.extensions.embedding.SplitPlaceholderRule.Builder.class.getConstructor(Intent.class, cls, cls, cls).newInstance(splitPlaceholderRule.getPlaceholderIntent(), translateActivityPredicates(splitPlaceholderRule.getFilters()), translateIntentPredicates(splitPlaceholderRule.getFilters()), translateParentMetricsPredicate(splitPlaceholderRule))).setSplitRatio(splitPlaceholderRule.getSplitRatio()).setLayoutDirection(splitPlaceholderRule.getLayoutDirection()).setSticky(splitPlaceholderRule.isSticky()).setFinishPrimaryWithSecondary(splitPlaceholderRule.getFinishPrimaryWithSecondary());
        l0.o(finishPrimaryWithSecondary, "SplitPlaceholderRuleBuil…nishPrimaryWithSecondary)");
        androidx.window.extensions.embedding.SplitPlaceholderRule splitPlaceholderRuleBuild = finishPrimaryWithSecondary.build();
        l0.o(splitPlaceholderRuleBuild, "builder.build()");
        return splitPlaceholderRuleBuild;
    }

    @l
    public final List<SplitInfo> translate(@l List<? extends androidx.window.extensions.embedding.SplitInfo> list) {
        l0.p(list, "splitInfoList");
        List<? extends androidx.window.extensions.embedding.SplitInfo> list2 = list;
        ArrayList arrayList = new ArrayList(z.b0(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(translate((androidx.window.extensions.embedding.SplitInfo) it.next()));
        }
        return arrayList;
    }

    private final SplitInfo translate(androidx.window.extensions.embedding.SplitInfo splitInfo) {
        boolean zIsEmpty;
        androidx.window.extensions.embedding.ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
        l0.o(primaryActivityStack, "splitInfo.primaryActivityStack");
        boolean zIsEmpty2 = false;
        try {
            zIsEmpty = primaryActivityStack.isEmpty();
        } catch (NoSuchMethodError unused) {
            zIsEmpty = false;
        }
        List activities = primaryActivityStack.getActivities();
        l0.o(activities, "primaryActivityStack.activities");
        ActivityStack activityStack = new ActivityStack(activities, zIsEmpty);
        androidx.window.extensions.embedding.ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
        l0.o(secondaryActivityStack, "splitInfo.secondaryActivityStack");
        try {
            zIsEmpty2 = secondaryActivityStack.isEmpty();
        } catch (NoSuchMethodError unused2) {
        }
        List activities2 = secondaryActivityStack.getActivities();
        l0.o(activities2, "secondaryActivityStack.activities");
        return new SplitInfo(activityStack, new ActivityStack(activities2, zIsEmpty2), splitInfo.getSplitRatio());
    }

    @l
    public final Set<androidx.window.extensions.embedding.EmbeddingRule> translate(@l Set<? extends EmbeddingRule> set) {
        androidx.window.extensions.embedding.SplitPairRule splitPairRuleTranslateActivityRule;
        l0.p(set, "rules");
        Class<?> clsPredicateClassOrNull$window_release = this.predicateAdapter.predicateClassOrNull$window_release();
        if (clsPredicateClassOrNull$window_release == null) {
            return o1.k();
        }
        ArrayList arrayList = new ArrayList(z.b0(set, 10));
        for (EmbeddingRule embeddingRule : set) {
            if (embeddingRule instanceof SplitPairRule) {
                splitPairRuleTranslateActivityRule = translateSplitPairRule((SplitPairRule) embeddingRule, clsPredicateClassOrNull$window_release);
            } else if (embeddingRule instanceof SplitPlaceholderRule) {
                splitPairRuleTranslateActivityRule = translateSplitPlaceholderRule((SplitPlaceholderRule) embeddingRule, clsPredicateClassOrNull$window_release);
            } else {
                if (!(embeddingRule instanceof ActivityRule)) {
                    throw new IllegalArgumentException("Unsupported rule type");
                }
                splitPairRuleTranslateActivityRule = translateActivityRule((ActivityRule) embeddingRule, clsPredicateClassOrNull$window_release);
            }
            arrayList.add((androidx.window.extensions.embedding.EmbeddingRule) splitPairRuleTranslateActivityRule);
        }
        return h0.a6(arrayList);
    }
}
