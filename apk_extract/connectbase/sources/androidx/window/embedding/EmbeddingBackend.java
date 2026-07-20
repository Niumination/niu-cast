package androidx.window.embedding;

import android.app.Activity;
import androidx.core.util.Consumer;
import androidx.window.core.ExperimentalWindowApi;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
public interface EmbeddingBackend {
    @l
    Set<EmbeddingRule> getSplitRules();

    boolean isActivityEmbedded(@l Activity activity);

    boolean isSplitSupported();

    void registerRule(@l EmbeddingRule embeddingRule);

    void registerSplitListenerForActivity(@l Activity activity, @l Executor executor, @l Consumer<List<SplitInfo>> consumer);

    void setSplitRules(@l Set<? extends EmbeddingRule> set);

    void unregisterRule(@l EmbeddingRule embeddingRule);

    void unregisterSplitListenerForActivity(@l Consumer<List<SplitInfo>> consumer);
}
