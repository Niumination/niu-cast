package zd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.R$layout;
import com.transsion.widgetslib.widget.FootOperationBar;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FootOperationBar f11288a;

    public g(FootOperationBar footOperationBar) {
        this.f11288a = footOperationBar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f11288a.f3370b.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i8) {
        return this.f11288a.f3370b.get(i8);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i8) {
        return i8;
    }

    @Override // android.widget.Adapter
    public final View getView(int i8, View view, ViewGroup viewGroup) {
        f fVar;
        FootOperationBar footOperationBar = this.f11288a;
        if (view == null) {
            view = LayoutInflater.from(footOperationBar.getContext()).inflate(R$layout.os_foot_opt_bar_popup_item, viewGroup, false);
            fVar = new f();
            fVar.f11287a = (TextView) view.findViewById(R$id.os_foot_opt_bar_popup_item_text);
            view.setTag(fVar);
        } else {
            fVar = (f) view.getTag();
        }
        fVar.f11287a.setText((CharSequence) footOperationBar.f3370b.get(i8));
        boolean z2 = footOperationBar.f3375j[i8];
        View viewFindViewById = view.findViewById(R$id.os_fob_layout);
        if (viewFindViewById == null) {
            view.setEnabled(z2);
            view.setAlpha(z2 ? 1.0f : 0.4f);
        } else {
            viewFindViewById.setEnabled(z2);
            viewFindViewById.setAlpha(z2 ? 1.0f : 0.4f);
        }
        view.setOnClickListener(new ce.c(this, i8 + footOperationBar.f3381r, 3));
        return view;
    }
}
