package d6;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.qgame.animplayer.AnimView;
import com.tencent.qgame.animplayer.textureview.InnerTextureView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnimView f4325b;

    public /* synthetic */ e(AnimView animView, int i8) {
        this.f4324a = i8;
        this.f4325b = animView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    public final void run() {
        Object[] objArr = 0;
        AnimView this$0 = this.f4325b;
        switch (this.f4324a) {
            case 0:
                int i8 = AnimView.p;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.removeAllViews();
                Context context = this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                InnerTextureView innerTextureView = new InnerTextureView(context, objArr == true ? 1 : 0, 6, 0);
                innerTextureView.setPlayer(this$0.f2299a);
                innerTextureView.setOpaque(false);
                innerTextureView.setSurfaceTextureListener(this$0);
                j6.k kVar = this$0.f2304i;
                kVar.getClass();
                ViewGroup.LayoutParams layoutParams = innerTextureView.getLayoutParams();
                FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 == null) {
                    layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                }
                FrameLayout.LayoutParams layoutParamsB = layoutParams2;
                if (kVar.f6119d <= 0 || kVar.e <= 0 || kVar.f <= 0 || kVar.f6120g <= 0) {
                    String msg = "params error: layoutWidth=" + kVar.f6119d + ", layoutHeight=" + kVar.e + ", videoWidth=" + kVar.f + ", videoHeight=" + kVar.f6120g;
                    Intrinsics.checkNotNullParameter("AnimPlayer.ScaleTypeUtil", "tag");
                    Intrinsics.checkNotNullParameter(msg, "msg");
                } else {
                    layoutParamsB = kVar.a().b(kVar.f6119d, kVar.e, kVar.f, kVar.f6120g, layoutParamsB);
                }
                innerTextureView.setLayoutParams(layoutParamsB);
                Unit unit = Unit.INSTANCE;
                this$0.e = innerTextureView;
                this$0.addView(innerTextureView);
                break;
            default:
                int i9 = AnimView.p;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                InnerTextureView innerTextureView2 = this$0.e;
                if (innerTextureView2 != null) {
                    innerTextureView2.setSurfaceTextureListener(null);
                }
                this$0.e = null;
                this$0.removeAllViews();
                break;
        }
    }
}
