package d6;

import android.os.Handler;
import androidx.core.app.NotificationCompat;
import com.tencent.qgame.animplayer.AnimView;
import k3.j1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends Lambda implements Function0 {
    final /* synthetic */ e6.b $fileContainer;
    final /* synthetic */ AnimView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(AnimView animView, e6.b bVar) {
        super(0);
        this.this$0 = animView;
        this.$fileContainer = bVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m140invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m140invoke() {
        Handler handler;
        if (this.this$0.getVisibility() != 0) {
            Intrinsics.checkNotNullParameter("AnimPlayer.AnimView", "tag");
            Intrinsics.checkNotNullParameter("AnimView is GONE, can't play", NotificationCompat.CATEGORY_MESSAGE);
            return;
        }
        if (this.this$0.f2299a.c()) {
            Intrinsics.checkNotNullParameter("AnimPlayer.AnimView", "tag");
            Intrinsics.checkNotNullParameter("is running can not start", NotificationCompat.CATEGORY_MESSAGE);
            return;
        }
        AnimView animView = this.this$0;
        e6.b fileContainer = this.$fileContainer;
        animView.f2303h = fileContainer;
        d dVar = animView.f2299a;
        dVar.getClass();
        Intrinsics.checkNotNullParameter(fileContainer, "fileContainer");
        dVar.f4321m = true;
        dVar.e();
        t tVar = dVar.f4314d;
        if (tVar == null || (j1.a(tVar.f4348c, "anim_render_thread") && j1.a(tVar.f4349d, "anim_decode_thread"))) {
            t tVar2 = dVar.f4314d;
            if (tVar2 == null || (handler = tVar2.f4348c.f4335b) == null) {
                return;
            }
            handler.post(new b(dVar, fileContainer, 0));
            return;
        }
        dVar.f4321m = false;
        t tVar3 = dVar.f4314d;
        if (tVar3 != null) {
            tVar3.c(10003, "0x3 thread create fail");
        }
        t tVar4 = dVar.f4314d;
        if (tVar4 == null) {
            return;
        }
        tVar4.a();
    }
}
