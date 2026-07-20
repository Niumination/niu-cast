package ge;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.transsion.widgetslib.R$drawable;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.R$layout;
import com.transsion.widgetslib.widget.tablayout.OSTabLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OSTabLayout f5166a;

    public c(OSTabLayout oSTabLayout) {
        this.f5166a = oSTabLayout;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f5166a.f3670d.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i8) {
        return this.f5166a.f3670d.get(i8);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i8) {
        return i8;
    }

    @Override // android.widget.Adapter
    public final View getView(int i8, View view, ViewGroup viewGroup) {
        b bVar;
        OSTabLayout oSTabLayout = this.f5166a;
        if (view == null) {
            b bVar2 = new b();
            View viewInflate = LayoutInflater.from(oSTabLayout.getContext()).inflate(R$layout.os_tab_overflow_popup_item, viewGroup, false);
            bVar2.f5165a = (TextView) viewInflate.findViewById(R$id.os_tab_overflow_popup_item_text);
            viewInflate.setTag(bVar2);
            bVar = bVar2;
            view = viewInflate;
        } else {
            bVar = (b) view.getTag();
        }
        view.setBackgroundResource(R$drawable.os_press_primary_bg);
        bVar.f5165a.setText((CharSequence) oSTabLayout.f3670d.get(i8));
        boolean z2 = oSTabLayout.f3672i[i8];
        view.setEnabled(z2);
        view.setAlpha(z2 ? 1.0f : 0.3f);
        view.setOnClickListener(new ce.c(this, i8, 1));
        return view;
    }
}
