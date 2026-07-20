package e5;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class n implements Externalizable {
    private static final long serialVersionUID = 1;
    private boolean hasExampleNumber;
    private boolean hasNationalNumberPattern;
    private String nationalNumberPattern_ = "";
    private List<Integer> possibleLength_ = new ArrayList();
    private List<Integer> possibleLengthLocalOnly_ = new ArrayList();
    private String exampleNumber_ = "";

    public static m newBuilder() {
        return new m();
    }

    public n addPossibleLength(int i8) {
        this.possibleLength_.add(Integer.valueOf(i8));
        return this;
    }

    public n addPossibleLengthLocalOnly(int i8) {
        this.possibleLengthLocalOnly_.add(Integer.valueOf(i8));
        return this;
    }

    public n clearExampleNumber() {
        this.hasExampleNumber = false;
        this.exampleNumber_ = "";
        return this;
    }

    public n clearNationalNumberPattern() {
        this.hasNationalNumberPattern = false;
        this.nationalNumberPattern_ = "";
        return this;
    }

    public n clearPossibleLength() {
        this.possibleLength_.clear();
        return this;
    }

    public n clearPossibleLengthLocalOnly() {
        this.possibleLengthLocalOnly_.clear();
        return this;
    }

    public boolean exactlySameAs(n nVar) {
        return this.nationalNumberPattern_.equals(nVar.nationalNumberPattern_) && this.possibleLength_.equals(nVar.possibleLength_) && this.possibleLengthLocalOnly_.equals(nVar.possibleLengthLocalOnly_) && this.exampleNumber_.equals(nVar.exampleNumber_);
    }

    public String getExampleNumber() {
        return this.exampleNumber_;
    }

    public String getNationalNumberPattern() {
        return this.nationalNumberPattern_;
    }

    public int getPossibleLength(int i8) {
        return this.possibleLength_.get(i8).intValue();
    }

    public int getPossibleLengthCount() {
        return this.possibleLength_.size();
    }

    public List<Integer> getPossibleLengthList() {
        return this.possibleLength_;
    }

    public int getPossibleLengthLocalOnly(int i8) {
        return this.possibleLengthLocalOnly_.get(i8).intValue();
    }

    public int getPossibleLengthLocalOnlyCount() {
        return this.possibleLengthLocalOnly_.size();
    }

    public List<Integer> getPossibleLengthLocalOnlyList() {
        return this.possibleLengthLocalOnly_;
    }

    public boolean hasExampleNumber() {
        return this.hasExampleNumber;
    }

    public boolean hasNationalNumberPattern() {
        return this.hasNationalNumberPattern;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        if (objectInput.readBoolean()) {
            setNationalNumberPattern(objectInput.readUTF());
        }
        int i8 = objectInput.readInt();
        for (int i9 = 0; i9 < i8; i9++) {
            this.possibleLength_.add(Integer.valueOf(objectInput.readInt()));
        }
        int i10 = objectInput.readInt();
        for (int i11 = 0; i11 < i10; i11++) {
            this.possibleLengthLocalOnly_.add(Integer.valueOf(objectInput.readInt()));
        }
        if (objectInput.readBoolean()) {
            setExampleNumber(objectInput.readUTF());
        }
    }

    public n setExampleNumber(String str) {
        this.hasExampleNumber = true;
        this.exampleNumber_ = str;
        return this;
    }

    public n setNationalNumberPattern(String str) {
        this.hasNationalNumberPattern = true;
        this.nationalNumberPattern_ = str;
        return this;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeBoolean(this.hasNationalNumberPattern);
        if (this.hasNationalNumberPattern) {
            objectOutput.writeUTF(this.nationalNumberPattern_);
        }
        int possibleLengthCount = getPossibleLengthCount();
        objectOutput.writeInt(possibleLengthCount);
        for (int i8 = 0; i8 < possibleLengthCount; i8++) {
            objectOutput.writeInt(this.possibleLength_.get(i8).intValue());
        }
        int possibleLengthLocalOnlyCount = getPossibleLengthLocalOnlyCount();
        objectOutput.writeInt(possibleLengthLocalOnlyCount);
        for (int i9 = 0; i9 < possibleLengthLocalOnlyCount; i9++) {
            objectOutput.writeInt(this.possibleLengthLocalOnly_.get(i9).intValue());
        }
        objectOutput.writeBoolean(this.hasExampleNumber);
        if (this.hasExampleNumber) {
            objectOutput.writeUTF(this.exampleNumber_);
        }
    }
}
