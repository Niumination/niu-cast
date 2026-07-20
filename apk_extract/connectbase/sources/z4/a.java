package z4;

import android.graphics.drawable.Drawable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Serializable {
    private String mAppName;
    private Drawable mImage;
    private String mPackageName;

    public a(String str, String str2, Drawable drawable) {
        this.mAppName = str;
        this.mPackageName = str2;
        this.mImage = drawable;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public Drawable getImage() {
        return this.mImage;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public void setImage(Drawable drawable) {
        this.mImage = drawable;
    }

    public void setPackageName(String str) {
        this.mPackageName = str;
    }
}
