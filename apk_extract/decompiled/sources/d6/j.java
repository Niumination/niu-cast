package d6;

import android.os.Handler;
import androidx.core.app.NotificationCompat;
import com.tencent.qgame.animplayer.AnimView;
import k3.j1;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends Lambda implements Function0 {
    final /* synthetic */ e6.b $fileContainer;
    final /* synthetic */ boolean $isLoop;
    final /* synthetic */ AnimView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(AnimView animView, e6.b bVar, boolean z2) {
        super(0);
        this.this$0 = animView;
        this.$fileContainer = bVar;
        this.$isLoop = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m141invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m141invoke() {
        Handler handler;
        if (this.this$0.getVisibility() != 0) {
            Intrinsics.checkNotNullParameter("AnimPlayer.AnimView", "tag");
            Intrinsics.checkNotNullParameter("AnimView is GONE, can't play", NotificationCompat.CATEGORY_MESSAGE);
            return;
        }
        if (this.this$0.f2299a.c()) {
            AnimView animView = this.this$0;
            d dVar = animView.f2299a;
            t tVar = dVar.f4314d;
            if (tVar != null) {
                tVar.f4353j = true;
            }
            l lVar = dVar.e;
            if (lVar != null) {
                lVar.f4332h = true;
            }
            animView.setMPlayBuff(new Pair<>(this.$fileContainer, Boolean.valueOf(this.$isLoop)));
            return;
        }
        AnimView animView2 = this.this$0;
        e6.b fileContainer = this.$fileContainer;
        animView2.f2303h = fileContainer;
        boolean z2 = this.$isLoop;
        d dVar2 = animView2.f2299a;
        dVar2.getClass();
        Intrinsics.checkNotNullParameter(fileContainer, "fileContainer");
        dVar2.f4321m = true;
        dVar2.e();
        t tVar2 = dVar2.f4314d;
        if (tVar2 == null || (j1.a(tVar2.f4348c, "anim_render_thread") && j1.a(tVar2.f4349d, "anim_decode_thread"))) {
            t tVar3 = dVar2.f4314d;
            if (tVar3 == null || (handler = tVar3.f4348c.f4335b) == null) {
                return;
            }
            handler.post(new c(dVar2, fileContainer, z2, 0));
            return;
        }
        dVar2.f4321m = false;
        t tVar4 = dVar2.f4314d;
        if (tVar4 != null) {
            tVar4.c(10003, "0x3 thread create fail");
        }
        t tVar5 = dVar2.f4314d;
        if (tVar5 == null) {
            return;
        }
        tVar5.a();
    }
}
