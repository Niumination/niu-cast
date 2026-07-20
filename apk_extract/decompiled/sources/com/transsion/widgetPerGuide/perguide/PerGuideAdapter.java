package com.transsion.widgetPerGuide.perguide;

import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.widgetPerGuide.R$attr;
import com.transsion.widgetPerGuide.R$color;
import com.transsion.widgetPerGuide.R$dimen;
import com.transsion.widgetPerGuide.R$id;
import com.transsion.widgetPerGuide.R$layout;
import ed.a;
import ed.e;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/widgetPerGuide/perguide/PerGuideAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/transsion/widgetPerGuide/perguide/PerGuideAdapter$PerGuideHolder;", "PerGuideHolder", "widgetPerGuide_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PerGuideAdapter extends RecyclerView.Adapter<PerGuideHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f2964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PerGuideDialog f2965b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/transsion/widgetPerGuide/perguide/PerGuideAdapter$PerGuideHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "widgetPerGuide_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public final class PerGuideHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f2966b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PerGuideAdapter f2967a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PerGuideHolder(PerGuideAdapter perGuideAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.f2967a = perGuideAdapter;
        }
    }

    public PerGuideAdapter(ArrayList perDats) {
        Intrinsics.checkNotNullParameter(perDats, "perDats");
        this.f2964a = perDats;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        ArrayList arrayList = this.f2964a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i8) {
        PackageItemInfo permissionInfo;
        String string;
        int i9;
        int i10;
        int i11;
        String str = null;
        int i12 = 0;
        PerGuideHolder holder = (PerGuideHolder) viewHolder;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Object obj = this.f2964a.get(i8);
        Intrinsics.checkNotNullExpressionValue(obj, "perDats[position]");
        e perDat = (e) obj;
        int adapterPosition = holder.getAdapterPosition();
        Intrinsics.checkNotNullParameter(perDat, "perDat");
        Context context = holder.itemView.getContext();
        ImageView imageView = (ImageView) holder.itemView.findViewById(R$id.img_per_item_icon);
        TextView textView = (TextView) holder.itemView.findViewById(R$id.tv_per_name);
        TextView textView2 = (TextView) holder.itemView.findViewById(R$id.tv_per_intro);
        LinearLayout linearLayout = (LinearLayout) holder.itemView.findViewById(R$id.ll_des);
        Switch r7 = (Switch) holder.itemView.findViewById(R$id.switch_per);
        perDat.getClass();
        imageView.setVisibility(8);
        textView2.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        if (j.s()) {
            layoutParams2.setMarginStart(context.getResources().getDimensionPixelSize(R$dimen.os_ultra_small_per_item_no_icon_text_margin));
        } else {
            layoutParams2.setMarginStart(context.getResources().getDimensionPixelSize(R$dimen.os_per_item_no_icon_text_margin));
        }
        linearLayout.setLayoutParams(layoutParams2);
        r7.setTag(Integer.valueOf(adapterPosition));
        r7.setChecked(perDat.f4841d);
        PerGuideAdapter perGuideAdapter = holder.f2967a;
        r7.setOnCheckedChangeListener(new a(perGuideAdapter, i12));
        if (j.s()) {
            layoutParams2.setMarginEnd(context.getResources().getDimensionPixelSize(R$dimen.os_ultra_small_per_item_icon_margin_start));
        } else {
            layoutParams2.setMarginEnd(context.getResources().getDimensionPixelSize(R$dimen.os_per_item_icon_margin_start));
        }
        r7.setVisibility(8);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.checkNotNullParameter(null, "groupName");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            try {
                permissionInfo = context.getPackageManager().getPermissionGroupInfo(null, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                permissionInfo = null;
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            permissionInfo = context.getPackageManager().getPermissionInfo(null, 0);
        }
        if (permissionInfo != null) {
            if (!(permissionInfo instanceof PermissionGroupInfo) || (i11 = ((PermissionGroupInfo) permissionInfo).descriptionRes) <= 0) {
                string = "";
            } else {
                string = context.getString(i11);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(groupInfo.descriptionRes)");
            }
            if ((permissionInfo instanceof PermissionInfo) && (i10 = ((PermissionInfo) permissionInfo).descriptionRes) > 0) {
                string = context.getString(i10);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(groupInfo.descriptionRes)");
            }
            if (TextUtils.isEmpty(perDat.f4838a) && !TextUtils.isEmpty(string)) {
                Intrinsics.checkNotNullParameter(string, "<set-?>");
                perDat.f4838a = string;
            }
            if (TextUtils.isEmpty(perDat.f4839b) && !TextUtils.isEmpty(string)) {
                Intrinsics.checkNotNullParameter(string, "<set-?>");
                perDat.f4839b = string;
            }
            if (perDat.f4840c <= 0 && (i9 = permissionInfo.icon) > 0) {
                perDat.f4840c = i9;
            }
        }
        String str2 = perDat.f4838a;
        if (str2 != null) {
            perGuideAdapter.getClass();
            Intrinsics.checkNotNullParameter(str2, "<this>");
        } else {
            str2 = null;
        }
        textView.setText(str2);
        String str3 = perDat.f4839b;
        if (str3 != null) {
            perGuideAdapter.getClass();
            Intrinsics.checkNotNullParameter(str3, "<this>");
            str = str3;
        }
        textView2.setText(str);
        int i13 = perDat.f4840c;
        if (i13 > 0) {
            Drawable drawable = context.getDrawable(i13);
            Intrinsics.checkNotNull(drawable);
            Drawable drawableMutate = drawable.mutate();
            Intrinsics.checkNotNullExpressionValue(drawableMutate, "drawable!!.mutate()");
            int i14 = R$attr.os_icon_secondary;
            int i15 = R$color.os_icon_secondary_hios;
            String[] strArr = j.f8764a;
            drawableMutate.setTint(j.d(i14, context.getColor(i15), context));
            imageView.setImageDrawable(drawableMutate);
        }
        if (r7.getVisibility() == 0) {
            holder.itemView.setOnClickListener(new ce.a(r7, 1));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i8) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.getContext();
        View itemView = j.s() ? LayoutInflater.from(parent.getContext()).inflate(R$layout.os_ultra_small_per_item_layout, parent, false) : LayoutInflater.from(parent.getContext()).inflate(R$layout.os_per_item_layout, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new PerGuideHolder(this, itemView);
    }
}
