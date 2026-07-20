package androidx.work;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import li.j;
import m4.l;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n"}, d2 = {"<anonymous>", "", "R"}, k = 3, mv = {1, 5, 1}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ListenableFutureKt$await$2$1 implements Runnable {
    final /* synthetic */ j $cancellableContinuation;
    final /* synthetic */ l $this_await;

    public ListenableFutureKt$await$2$1(j jVar, l lVar) {
        this.$cancellableContinuation = jVar;
        this.$this_await = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.$cancellableContinuation.resumeWith(Result.m159constructorimpl(this.$this_await.get()));
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause == null) {
                cause = th2;
            }
            if (th2 instanceof CancellationException) {
                this.$cancellableContinuation.b(cause);
                return;
            }
            j jVar = this.$cancellableContinuation;
            Result.Companion companion = Result.INSTANCE;
            jVar.resumeWith(Result.m159constructorimpl(ResultKt.createFailure(cause)));
        }
    }
}
