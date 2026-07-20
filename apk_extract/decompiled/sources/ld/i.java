package ld;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.adapter.RecyclerAdapter;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends RecyclerAdapter.Holder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CheckedTextView f7376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f7377d;
    public final Context e;

    public i(ViewGroup viewGroup, int i8) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(i8, viewGroup, false));
        this.e = viewGroup.getContext();
        this.f7376c = (CheckedTextView) this.itemView.findViewById(R$id.text_list_item_compat);
        this.f7377d = this.itemView.findViewById(R$id.view_divider);
    }

    public void setChoiceMode(int i8) {
        Drawable cVar;
        Context context = this.e;
        if (i8 == 1) {
            cVar = new md.e(context);
        } else {
            cVar = i8 == 2 ? new md.c(context, false) : null;
        }
        if (cVar != null) {
            this.f7376c.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, cVar, (Drawable) null);
        }
    }
}
