package rd;

import androidx.recyclerview.widget.RecyclerView;
import com.transsion.widgetslib.view.damping.OSScrollbarLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f9419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSScrollbarLayout f9420b;

    public k(OSScrollbarLayout oSScrollbarLayout, RecyclerView recyclerView) {
        this.f9420b = oSScrollbarLayout;
        this.f9419a = recyclerView;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i8, int i9) {
        super.onScrolled(recyclerView, i8, i9);
        boolean z2 = i9 > 0;
        OSScrollbarLayout oSScrollbarLayout = this.f9420b;
        oSScrollbarLayout.f3234w = z2;
        RecyclerView recyclerView2 = this.f9419a;
        oSScrollbarLayout.i(recyclerView2, recyclerView2.computeVerticalScrollRange(), recyclerView2.computeVerticalScrollOffset());
        oSScrollbarLayout.g();
    }
}
