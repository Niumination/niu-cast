package e5;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class l implements Externalizable {
    private static final long serialVersionUID = 1;
    private List<j> metadata_ = new ArrayList();

    public static k newBuilder() {
        return new k();
    }

    public l addMetadata(j jVar) {
        jVar.getClass();
        this.metadata_.add(jVar);
        return this;
    }

    public l clear() {
        this.metadata_.clear();
        return this;
    }

    public int getMetadataCount() {
        return this.metadata_.size();
    }

    public List<j> getMetadataList() {
        return this.metadata_;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        int i8 = objectInput.readInt();
        for (int i9 = 0; i9 < i8; i9++) {
            j jVar = new j();
            jVar.readExternal(objectInput);
            this.metadata_.add(jVar);
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        int metadataCount = getMetadataCount();
        objectOutput.writeInt(metadataCount);
        for (int i8 = 0; i8 < metadataCount; i8++) {
            this.metadata_.get(i8).writeExternal(objectOutput);
        }
    }
}
