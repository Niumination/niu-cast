package wi;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.transsion.widgetslib.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f18277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<fj.a> f18278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<Boolean> f18279c = new ArrayList();

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f18280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextView f18281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CheckBox f18282c;

        public b() {
        }

        public void b(fj.a aVar) {
            Drawable drawableA = aVar.a();
            String strB = aVar.b();
            if (drawableA != null) {
                this.f18280a.setImageDrawable(drawableA);
            }
            if (strB != null) {
                this.f18281b.setText(strB);
            }
        }

        public void c(View view) {
            this.f18280a = (ImageView) view.findViewById(R.id.image_select_item_icon);
            this.f18281b = (TextView) view.findViewById(R.id.text_select_item_title);
            this.f18282c = (CheckBox) view.findViewById(R.id.check_select_item);
        }

        public b(C0470a c0470a) {
        }
    }

    public a(Context context, List<fj.a> list, boolean z10) {
        this.f18277a = context;
        this.f18278b = list;
        c(z10);
    }

    public int a() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f18279c.size(); i11++) {
            if (this.f18279c.get(i11).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    public List<Boolean> b() {
        return this.f18279c;
    }

    public final void c(boolean z10) {
        for (int i10 = 0; i10 < this.f18278b.size(); i10++) {
            this.f18279c.add(Boolean.valueOf(z10));
        }
    }

    public void d(int i10) {
        List<Boolean> list = this.f18279c;
        list.set(i10, Boolean.valueOf(!list.get(i10).booleanValue()));
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18278b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f18278b.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        b bVar;
        View view2;
        fj.a aVar = this.f18278b.get(i10);
        if (view == null) {
            View viewInflate = LayoutInflater.from(this.f18277a).inflate(R.layout.os_select_dialog_item_layout, viewGroup, false);
            b bVar2 = new b();
            bVar2.c(viewInflate);
            viewInflate.setTag(bVar2);
            view2 = viewInflate;
            bVar = bVar2;
        } else {
            b bVar3 = (b) view.getTag();
            view2 = view;
            bVar = bVar3;
        }
        bVar.b(aVar);
        bVar.f18282c.setChecked(this.f18279c.get(i10).booleanValue());
        return view2;
    }
}
