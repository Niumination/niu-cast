package androidx.window.embedding;

import android.app.Activity;
import androidx.window.core.ExperimentalWindowApi;
import java.util.List;
import java.util.Set;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
public interface EmbeddingInterfaceCompat {

    public interface EmbeddingCallbackInterface {
        void onSplitInfoChanged(@l List<SplitInfo> list);
    }

    boolean isActivityEmbedded(@l Activity activity);

    void setEmbeddingCallback(@l EmbeddingCallbackInterface embeddingCallbackInterface);

    void setSplitRules(@l Set<? extends EmbeddingRule> set);
}
