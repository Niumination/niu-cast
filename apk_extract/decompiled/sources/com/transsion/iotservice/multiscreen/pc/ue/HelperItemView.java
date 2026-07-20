package com.transsion.iotservice.multiscreen.pc.ue;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.databinding.LayoutListItemGroupBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import pb.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ue/HelperItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lpb/b;", "item", "", "setContentItem", "(Lpb/b;)V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nHelperItemView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HelperItemView.kt\ncom/transsion/iotservice/multiscreen/pc/ue/HelperItemView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,42:1\n1557#2:43\n1628#2,3:44\n37#3:47\n36#3,3:48\n*S KotlinDebug\n*F\n+ 1 HelperItemView.kt\ncom/transsion/iotservice/multiscreen/pc/ue/HelperItemView\n*L\n29#1:43\n29#1:44,3\n31#1:47\n31#1:48,3\n*E\n"})
public final class HelperItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutListItemGroupBinding f2679a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HelperItemView(Context context) {
        this(context, null, 6, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setContentItem(b item) {
        Intrinsics.checkNotNullParameter(item, "item");
        LayoutListItemGroupBinding layoutListItemGroupBinding = this.f2679a;
        layoutListItemGroupBinding.f2630d.setText(item.f8712a);
        layoutListItemGroupBinding.f2628b.setImageResource(item.f8714c);
        List list = item.f8715d;
        boolean zIsEmpty = list.isEmpty();
        TextView textView = layoutListItemGroupBinding.f2629c;
        int i8 = item.f8713b;
        if (zIsEmpty) {
            textView.setText(i8);
            return;
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.i(list2));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(getContext().getString(((Number) it.next()).intValue()));
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        textView.setText(getContext().getString(i8, Arrays.copyOf(strArr, strArr.length)));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HelperItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ HelperItemView(Context context, AttributeSet attributeSet, int i8, int i9) {
        this(context, (i8 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HelperItemView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.checkNotNullParameter(context, "context");
        View viewInflate = View.inflate(context, R$layout.layout_list_item_group, this);
        int i9 = R$id.cl_setting;
        if (((ConstraintLayout) ViewBindings.findChildViewById(viewInflate, i9)) != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
            int i10 = R$id.iv_helper;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, i10);
            if (imageView != null) {
                i10 = R$id.tv_setting_desc;
                TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, i10);
                if (textView != null) {
                    i10 = R$id.tv_setting_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, i10);
                    if (textView2 != null) {
                        this.f2679a = new LayoutListItemGroupBinding(constraintLayout, imageView, textView, textView2);
                        return;
                    }
                }
            }
            i9 = i10;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i9)));
    }
}
