package f6;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public class k {
    public static void a(ImageView imageView) {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmap;
        try {
            if ((imageView.getDrawable() instanceof BitmapDrawable) && (bitmapDrawable = (BitmapDrawable) imageView.getDrawable()) != null && (bitmap = bitmapDrawable.getBitmap()) != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            imageView.setImageBitmap(null);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void b(View view) {
        if (!(view instanceof ViewGroup)) {
            if (view instanceof ImageView) {
                a((ImageView) view);
            }
        } else {
            int i10 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i10 >= viewGroup.getChildCount()) {
                    return;
                }
                b(viewGroup.getChildAt(i10));
                i10++;
            }
        }
    }
}
