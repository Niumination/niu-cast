package com.transsion.core.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public class ViewBitmapRecycleUtil {
    private static void bitmapRecycle(ImageView imageView) {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmap;
        try {
            if ((imageView.getDrawable() instanceof BitmapDrawable) && (bitmapDrawable = (BitmapDrawable) imageView.getDrawable()) != null && (bitmap = bitmapDrawable.getBitmap()) != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            imageView.setImageBitmap(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void bitmapsRecycle(View view) {
        if (!(view instanceof ViewGroup)) {
            if (view instanceof ImageView) {
                bitmapRecycle((ImageView) view);
            }
        } else {
            int i8 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i8 >= viewGroup.getChildCount()) {
                    return;
                }
                bitmapsRecycle(viewGroup.getChildAt(i8));
                i8++;
            }
        }
    }
}
