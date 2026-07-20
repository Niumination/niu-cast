package androidx.window.embedding;

import android.app.Activity;
import android.content.Context;
import androidx.core.util.Consumer;
import androidx.window.core.ExperimentalWindowApi;
import in.n;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kn.l0;
import kn.w;
import lm.l2;
import nm.h0;
import nm.m0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
public final class SplitController {

    @m
    private static volatile SplitController globalInstance = null;
    public static final boolean sDebug = false;

    @l
    private final EmbeddingBackend embeddingBackend;

    @l
    private Set<? extends EmbeddingRule> staticSplitRules;

    @l
    public static final Companion Companion = new Companion(null);

    @l
    private static final ReentrantLock globalLock = new ReentrantLock();

    public static final class Companion {
        public /* synthetic */ Companion(w wVar) {
            this();
        }

        @n
        @l
        public final SplitController getInstance() {
            if (SplitController.globalInstance == null) {
                ReentrantLock reentrantLock = SplitController.globalLock;
                reentrantLock.lock();
                try {
                    if (SplitController.globalInstance == null) {
                        Companion companion = SplitController.Companion;
                        SplitController.globalInstance = new SplitController(null);
                    }
                    l2 l2Var = l2.f10208a;
                    reentrantLock.unlock();
                } catch (Throwable th2) {
                    reentrantLock.unlock();
                    throw th2;
                }
            }
            SplitController splitController = SplitController.globalInstance;
            l0.m(splitController);
            return splitController;
        }

        @n
        public final void initialize(@l Context context, int i10) {
            l0.p(context, "context");
            Set<EmbeddingRule> splitRules$window_release = new SplitRuleParser().parseSplitRules$window_release(context, i10);
            SplitController companion = getInstance();
            if (splitRules$window_release == null) {
                splitRules$window_release = m0.INSTANCE;
            }
            companion.setStaticSplitRules(splitRules$window_release);
        }

        private Companion() {
        }
    }

    public /* synthetic */ SplitController(w wVar) {
        this();
    }

    @n
    @l
    public static final SplitController getInstance() {
        return Companion.getInstance();
    }

    @n
    public static final void initialize(@l Context context, int i10) {
        Companion.initialize(context, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setStaticSplitRules(Set<? extends EmbeddingRule> set) {
        this.staticSplitRules = set;
        this.embeddingBackend.setSplitRules(set);
    }

    public final void addSplitListener(@l Activity activity, @l Executor executor, @l Consumer<List<SplitInfo>> consumer) {
        l0.p(activity, "activity");
        l0.p(executor, "executor");
        l0.p(consumer, "consumer");
        this.embeddingBackend.registerSplitListenerForActivity(activity, executor, consumer);
    }

    public final void clearRegisteredRules() {
        this.embeddingBackend.setSplitRules(this.staticSplitRules);
    }

    @l
    public final Set<EmbeddingRule> getSplitRules() {
        return h0.a6(this.embeddingBackend.getSplitRules());
    }

    public final boolean isActivityEmbedded(@l Activity activity) {
        l0.p(activity, "activity");
        return this.embeddingBackend.isActivityEmbedded(activity);
    }

    public final boolean isSplitSupported() {
        return this.embeddingBackend.isSplitSupported();
    }

    public final void registerRule(@l EmbeddingRule embeddingRule) {
        l0.p(embeddingRule, "rule");
        this.embeddingBackend.registerRule(embeddingRule);
    }

    public final void removeSplitListener(@l Consumer<List<SplitInfo>> consumer) {
        l0.p(consumer, "consumer");
        this.embeddingBackend.unregisterSplitListenerForActivity(consumer);
    }

    public final void unregisterRule(@l EmbeddingRule embeddingRule) {
        l0.p(embeddingRule, "rule");
        this.embeddingBackend.unregisterRule(embeddingRule);
    }

    private SplitController() {
        this.embeddingBackend = ExtensionEmbeddingBackend.Companion.getInstance();
        this.staticSplitRules = m0.INSTANCE;
    }
}
