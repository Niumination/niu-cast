package f5;

import com.google.gson.annotations.SerializedName;
import d5.h;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements h<String> {

    @SerializedName("broad_width_app_list")
    private List<String> mDataList;

    @Override // d5.h
    public List<String> b() {
        return this.mDataList;
    }
}
