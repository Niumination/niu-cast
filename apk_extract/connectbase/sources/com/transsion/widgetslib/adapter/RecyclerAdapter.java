package com.transsion.widgetslib.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.widgetslib.adapter.RecyclerAdapter.Holder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RecyclerAdapter<T, VH extends Holder> extends RecyclerView.Adapter<VH> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<T> f2307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AdapterView.OnItemClickListener f2308b;

    public static abstract class Holder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2310b;

        public Holder(View view) {
            super(view);
        }

        public void a(boolean z10) {
            this.f2309a = z10;
        }

        public void b(boolean z10) {
            this.f2310b = z10;
        }

        public Holder(ViewGroup viewGroup, int i10) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(i10, viewGroup, false));
        }
    }

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f2311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f2312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f2313c;

        public a(View view, Object obj, int i10) {
            this.f2311a = view;
            this.f2312b = obj;
            this.f2313c = i10;
        }

        /* JADX WARN: Multi-variable type inference failed */
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
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RecyclerAdapter.this.d(this.f2311a, this.f2312b, this.f2313c);
            RecyclerAdapter recyclerAdapter = RecyclerAdapter.this;
            AdapterView.OnItemClickListener onItemClickListener = recyclerAdapter.f2308b;
            if (onItemClickListener != null) {
                View view2 = this.f2311a;
                int i10 = this.f2313c;
                onItemClickListener.onItemClick(null, view2, i10, recyclerAdapter.getItemId(i10));
            }
        }
    }

    public class b implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f2315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f2316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f2317c;

        public b(View view, Object obj, int i10) {
            this.f2315a = view;
            this.f2316b = obj;
            this.f2317c = i10;
        }

        /* JADX WARN: Multi-variable type inference failed */
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
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return RecyclerAdapter.this.e(this.f2315a, this.f2316b, this.f2317c);
        }
    }

    public RecyclerAdapter(List<T> list) {
        this.f2307a = list;
    }

    public List<T> a() {
        return this.f2307a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull VH vh2, int i10) {
        T t10 = this.f2307a.get(i10);
        if (t10 == null) {
            return;
        }
        c(vh2, i10, t10);
        View view = vh2.itemView;
        if (vh2.f2309a) {
            view.setOnClickListener(new a(view, t10, i10));
        }
        if (vh2.f2310b) {
            view.setOnLongClickListener(new b(view, t10, i10));
        }
    }

    public abstract void c(@NonNull VH vh2, int i10, T t10);

    public void d(View view, T t10, int i10) {
    }

    public boolean e(View view, T t10, int i10) {
        return false;
    }

    public void f(AdapterView.OnItemClickListener onItemClickListener) {
        this.f2308b = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<T> list = this.f2307a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
