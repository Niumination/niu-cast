package h5;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h implements d5.h<g> {

    @SerializedName("secure_page_list")
    private List<g> mDataList;

    @Override // d5.h
    public List<g> b() {
        return this.mDataList;
    }
}
