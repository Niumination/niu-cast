package ld;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.widgetslib.R$layout;
import com.transsion.widgetslib.adapter.RecyclerAdapter;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends RecyclerAdapter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference f7374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7375d;

    public h(List list, int i8) {
        super(list);
        this.f7375d = i8;
    }

    @Override // com.transsion.widgetslib.adapter.RecyclerAdapter
    public final void a(RecyclerAdapter.Holder holder, int i8, Object obj) {
        View view;
        i iVar = (i) holder;
        CheckedTextView checkedTextView = iVar.f7376c;
        List list = this.f3040a;
        checkedTextView.setText((CharSequence) list.get(i8));
        WeakReference weakReference = this.f7374c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        z = false;
        boolean z2 = false;
        CheckedTextView checkedTextView2 = iVar.f7376c;
        int i9 = this.f7375d;
        if (i9 == 1) {
            checkedTextView2.setChecked(((j) this.f7374c.get()).p == i8);
            return;
        }
        if (i9 != 2) {
            if (i9 != 6 || (view = iVar.f7377d) == null) {
                return;
            }
            view.setVisibility(i8 == list.size() - 1 ? 8 : 0);
            return;
        }
        boolean[] zArr = ((j) this.f7374c.get()).q;
        if (zArr != null && zArr[i8]) {
            z2 = true;
        }
        checkedTextView2.setChecked(z2);
    }

    public int getCheckedItemCount() {
        WeakReference weakReference = this.f7374c;
        if (weakReference == null || weakReference.get() == null || ((j) this.f7374c.get()).q == null) {
            return 0;
        }
        int i8 = 0;
        for (boolean z2 : ((j) this.f7374c.get()).q) {
            if (z2) {
                i8++;
            }
        }
        return i8;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i8) {
        i iVar;
        int i9 = this.f7375d;
        if (i9 == 6) {
            viewGroup.getContext();
            iVar = pd.j.s() ? new i(viewGroup, R$layout.os_ultra_small_prompt_dialog_list_button_item) : new i(viewGroup, R$layout.os_prompt_dialog_list_button_item);
        } else {
            iVar = new i(viewGroup, R$layout.os_prompt_dialog_list_item_compat);
        }
        iVar.setSetOnClickListener(this.f3041b != null);
        iVar.setChoiceMode(i9);
        return iVar;
    }

    public void setSelectedPst(int i8) {
        boolean[] zArr;
        WeakReference weakReference = this.f7374c;
        if (weakReference == null || weakReference.get() == null || i8 < 0) {
            return;
        }
        int itemCount = getItemCount();
        List list = this.f3040a;
        int i9 = this.f7375d;
        if (i9 != 1) {
            if (i9 != 2 || (zArr = ((j) this.f7374c.get()).q) == null || zArr.length > itemCount) {
                return;
            }
            zArr[i8] = !zArr[i8];
            notifyItemChanged(i8, i8 < list.size() ? list.get(i8) : null);
            return;
        }
        int i10 = ((j) this.f7374c.get()).p;
        if (i10 >= 0 && i10 < itemCount) {
            notifyItemChanged(i10, i8 < list.size() ? list.get(i8) : null);
        }
        if (i8 < itemCount) {
            ((j) this.f7374c.get()).p = i8;
            notifyItemChanged(((j) this.f7374c.get()).p, i8 < list.size() ? list.get(i8) : null);
        }
    }

    public void setWeakReference(j jVar) {
        this.f7374c = new WeakReference(jVar);
    }
}
