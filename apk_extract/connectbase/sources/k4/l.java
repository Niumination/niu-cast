package k4;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Size;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8963a = "ImgUtils";

    /* JADX WARN: Code duplicated, block: B:35:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    public static String a(Bitmap bitmap) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        String strEncodeToString = null;
        strEncodeToString = null;
        strEncodeToString = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            if (bitmap == null) {
                return null;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                        byteArrayOutputStream.flush();
                        strEncodeToString = Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                    } catch (IOException e10) {
                        e = e10;
                        m.d(f8963a, e);
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.flush();
                            byteArrayOutputStream.close();
                        }
                        return strEncodeToString;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.flush();
                            byteArrayOutputStream2.close();
                        } catch (IOException e11) {
                            m.d(f8963a, e11);
                        }
                    }
                    throw th;
                }
            } catch (IOException e12) {
                e = e12;
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.flush();
                    byteArrayOutputStream2.close();
                }
                throw th;
            }
        } catch (IOException e13) {
            m.d(f8963a, e13);
        }
        return strEncodeToString;
    }

    public static Bitmap b(byte[] bArr) {
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }

    public static byte[] c(Drawable drawable) {
        return d(drawable, 100);
    }

    public static byte[] d(Drawable drawable, int i10) {
        if (drawable == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bitmapCreateBitmap.getHeight() * bitmapCreateBitmap.getWidth() * 4);
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, i10, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static String e(Context context, Uri uri, String str) {
        Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
        String string = null;
        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
            m.b(f8963a, "Failed to find data");
            return null;
        }
        try {
            try {
                string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(str));
            } catch (IllegalArgumentException e10) {
                m.c(f8963a, e10.getMessage());
            }
            return string;
        } finally {
            cursorQuery.close();
        }
    }

    @Nullable
    public static String f(Context context, Uri uri) {
        if (uri != null) {
            return e(context, uri, "owner_package_name");
        }
        m.b(f8963a, "ill uri");
        return null;
    }

    public static byte[] g(Icon icon, Context context) throws PackageManager.NameNotFoundException {
        Drawable drawableLoadDrawable;
        if (icon == null || (drawableLoadDrawable = icon.loadDrawable(context)) == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableLoadDrawable.getIntrinsicWidth(), drawableLoadDrawable.getIntrinsicHeight(), drawableLoadDrawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawableLoadDrawable.setBounds(0, 0, drawableLoadDrawable.getIntrinsicWidth(), drawableLoadDrawable.getIntrinsicHeight());
        drawableLoadDrawable.draw(canvas);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bitmapCreateBitmap.getHeight() * bitmapCreateBitmap.getWidth() * 4);
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Nullable
    public static Bitmap h(Context context, Uri uri, int i10, int i11) {
        try {
            return context.getContentResolver().loadThumbnail(uri, new Size(i10, i11), null);
        } catch (IOException e10) {
            m.d(f8963a, e10);
            return null;
        }
    }

    @Nullable
    public static Drawable i(Context context, Uri uri) {
        try {
            return Drawable.createFromStream(context.getContentResolver().openInputStream(uri), null);
        } catch (FileNotFoundException e10) {
            m.d(f8963a, e10);
            return null;
        }
    }

    @Nullable
    public static String j(Context context, Uri uri) {
        if (uri == null) {
            m.b(f8963a, "ill uri");
            return null;
        }
        if (DocumentsContract.isDocumentUri(context, uri)) {
            m.b(f8963a, "file belong to DocumentProvider");
            return null;
        }
        if (!t2.a.f15437d.equalsIgnoreCase(uri.getScheme())) {
            m.b(f8963a, "file no belong to MediaStore");
        }
        return e(context, uri, "_data");
    }

    @Nullable
    public static String k(Context context, Uri uri, int i10, int i11) {
        Bitmap bitmapH = h(context, uri, i10, i11);
        if (bitmapH != null) {
            return a(bitmapH);
        }
        m.b(f8963a, "load thumbnail fail");
        return null;
    }
}
