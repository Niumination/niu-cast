package d6;

import com.tencent.qgame.animplayer.AnimView;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements f6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnimView f4326a;

    public f(AnimView animView) {
        this.f4326a = animView;
    }

    @Override // f6.a
    public final void a() {
        AnimView animView = this.f4326a;
        Pair<e6.b, Boolean> mPlayBuff = animView.getMPlayBuff();
        Unit unit = null;
        if (mPlayBuff != null) {
            e6.b fileContainer = mPlayBuff.getFirst();
            boolean zBooleanValue = mPlayBuff.getSecond().booleanValue();
            animView.getClass();
            Intrinsics.checkNotNullParameter(fileContainer, "fileContainer");
            animView.e(new j(animView, fileContainer, zBooleanValue));
            animView.setMPlayBuff(null);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            if (animView.f2305j) {
                animView.a();
            } else {
                e6.b bVar = animView.f2303h;
                if (bVar != null) {
                    bVar.close();
                }
            }
            f6.a aVar = animView.f2302d;
            if (aVar == null) {
                return;
            }
            aVar.a();
        }
    }

    @Override // f6.a
    public final void b() {
        int i8 = AnimView.p;
        AnimView animView = this.f4326a;
        animView.a();
        f6.a aVar = animView.f2302d;
        if (aVar == null) {
            return;
        }
        aVar.b();
    }

    @Override // f6.a
    public final void c(int i8, String str) {
        f6.a aVar = this.f4326a.f2302d;
        if (aVar == null) {
            return;
        }
        aVar.c(i8, str);
    }

    @Override // f6.a
    public final void d() {
        f6.a aVar = this.f4326a.f2302d;
        if (aVar == null) {
            return;
        }
        aVar.d();
    }

    @Override // f6.a
    public final void e(int i8, a aVar) {
        f6.a aVar2 = this.f4326a.f2302d;
        if (aVar2 == null) {
            return;
        }
        aVar2.e(i8, aVar);
    }

    @Override // f6.a
    public final boolean f(a config) {
        Intrinsics.checkNotNullParameter(config, "config");
        AnimView animView = this.f4326a;
        j6.k kVar = animView.f2304i;
        int i8 = config.f4295b;
        int i9 = config.f4296c;
        kVar.f = i8;
        kVar.f6120g = i9;
        f6.a aVar = animView.f2302d;
        Boolean boolValueOf = aVar == null ? null : Boolean.valueOf(aVar.f(config));
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(config, "config");
        return true;
    }
}
