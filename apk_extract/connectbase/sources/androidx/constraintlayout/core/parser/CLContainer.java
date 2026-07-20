package androidx.constraintlayout.core.parser;

import java.util.ArrayList;
import java.util.Iterator;
import n.a;

/* JADX INFO: loaded from: classes.dex */
public class CLContainer extends CLElement {
    ArrayList<CLElement> mElements;

    public CLContainer(char[] cArr) {
        super(cArr);
        this.mElements = new ArrayList<>();
    }

    public static CLElement allocate(char[] cArr) {
        return new CLContainer(cArr);
    }

    public void add(CLElement cLElement) {
        this.mElements.add(cLElement);
        if (CLParser.DEBUG) {
            System.out.println("added element " + cLElement + " to " + this);
        }
    }

    public CLElement get(String str) throws CLParsingException {
        Iterator<CLElement> it = this.mElements.iterator();
        while (it.hasNext()) {
            CLKey cLKey = (CLKey) it.next();
            if (cLKey.content().equals(str)) {
                return cLKey.getValue();
            }
        }
        throw new CLParsingException(a.a("no element for key <", str, ">"), this);
    }

    public CLArray getArray(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLArray) {
            return (CLArray) cLElement;
        }
        StringBuilder sbA = e.a.a("no array found for key <", str, ">, found [");
        sbA.append(cLElement.getStrClass());
        sbA.append("] : ");
        sbA.append(cLElement);
        throw new CLParsingException(sbA.toString(), this);
    }

    public CLArray getArrayOrNull(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLArray) {
            return (CLArray) orNull;
        }
        return null;
    }

    public boolean getBoolean(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLToken) {
            return ((CLToken) cLElement).getBoolean();
        }
        StringBuilder sbA = e.a.a("no boolean found for key <", str, ">, found [");
        sbA.append(cLElement.getStrClass());
        sbA.append("] : ");
        sbA.append(cLElement);
        throw new CLParsingException(sbA.toString(), this);
    }

    public float getFloat(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement != null) {
            return cLElement.getFloat();
        }
        StringBuilder sbA = e.a.a("no float found for key <", str, ">, found [");
        sbA.append(cLElement.getStrClass());
        sbA.append("] : ");
        sbA.append(cLElement);
        throw new CLParsingException(sbA.toString(), this);
    }

    public float getFloatOrNaN(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLNumber) {
            return orNull.getFloat();
        }
        return Float.NaN;
    }

    public int getInt(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement != null) {
            return cLElement.getInt();
        }
        StringBuilder sbA = e.a.a("no int found for key <", str, ">, found [");
        sbA.append(cLElement.getStrClass());
        sbA.append("] : ");
        sbA.append(cLElement);
        throw new CLParsingException(sbA.toString(), this);
    }

    public CLObject getObject(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLObject) {
            return (CLObject) cLElement;
        }
        StringBuilder sbA = e.a.a("no object found for key <", str, ">, found [");
        sbA.append(cLElement.getStrClass());
        sbA.append("] : ");
        sbA.append(cLElement);
        throw new CLParsingException(sbA.toString(), this);
    }

    public CLObject getObjectOrNull(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLObject) {
            return (CLObject) orNull;
        }
        return null;
    }

    public CLElement getOrNull(String str) {
        Iterator<CLElement> it = this.mElements.iterator();
        while (it.hasNext()) {
            CLKey cLKey = (CLKey) it.next();
            if (cLKey.content().equals(str)) {
                return cLKey.getValue();
            }
        }
        return null;
    }

    public String getString(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLString) {
            return cLElement.content();
        }
        throw new CLParsingException("no string found for key <" + str + ">, found [" + (cLElement != null ? cLElement.getStrClass() : null) + "] : " + cLElement, this);
    }

    public String getStringOrNull(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLString) {
            return orNull.content();
        }
        return null;
    }

    public boolean has(String str) {
        for (CLElement cLElement : this.mElements) {
            if ((cLElement instanceof CLKey) && ((CLKey) cLElement).content().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> names() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (CLElement cLElement : this.mElements) {
            if (cLElement instanceof CLKey) {
                arrayList.add(((CLKey) cLElement).content());
            }
        }
        return arrayList;
    }

    public void put(String str, CLElement cLElement) {
        Iterator<CLElement> it = this.mElements.iterator();
        while (it.hasNext()) {
            CLKey cLKey = (CLKey) it.next();
            if (cLKey.content().equals(str)) {
                cLKey.set(cLElement);
                return;
            }
        }
        this.mElements.add((CLKey) CLKey.allocate(str, cLElement));
    }

    public void putNumber(String str, float f10) {
        put(str, new CLNumber(f10));
    }

    public void remove(String str) {
        ArrayList arrayList = new ArrayList();
        for (CLElement cLElement : this.mElements) {
            if (((CLKey) cLElement).content().equals(str)) {
                arrayList.add(cLElement);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.mElements.remove((CLElement) it.next());
        }
    }

    public int size() {
        return this.mElements.size();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (CLElement cLElement : this.mElements) {
            if (sb2.length() > 0) {
                sb2.append("; ");
            }
            sb2.append(cLElement);
        }
        return super.toString() + " = <" + ((Object) sb2) + " >";
    }

    public String getStringOrNull(int i10) {
        CLElement orNull = getOrNull(i10);
        if (orNull instanceof CLString) {
            return orNull.content();
        }
        return null;
    }

    public CLElement getOrNull(int i10) {
        if (i10 < 0 || i10 >= this.mElements.size()) {
            return null;
        }
        return this.mElements.get(i10);
    }

    public String getString(int i10) throws CLParsingException {
        CLElement cLElement = get(i10);
        if (cLElement instanceof CLString) {
            return cLElement.content();
        }
        throw new CLParsingException(h.a.a("no string at index ", i10), this);
    }

    public float getFloat(int i10) throws CLParsingException {
        CLElement cLElement = get(i10);
        if (cLElement != null) {
            return cLElement.getFloat();
        }
        throw new CLParsingException(h.a.a("no float at index ", i10), this);
    }

    public int getInt(int i10) throws CLParsingException {
        CLElement cLElement = get(i10);
        if (cLElement != null) {
            return cLElement.getInt();
        }
        throw new CLParsingException(h.a.a("no int at index ", i10), this);
    }

    public CLArray getArray(int i10) throws CLParsingException {
        CLElement cLElement = get(i10);
        if (cLElement instanceof CLArray) {
            return (CLArray) cLElement;
        }
        throw new CLParsingException(h.a.a("no array at index ", i10), this);
    }

    public boolean getBoolean(int i10) throws CLParsingException {
        CLElement cLElement = get(i10);
        if (cLElement instanceof CLToken) {
            return ((CLToken) cLElement).getBoolean();
        }
        throw new CLParsingException(h.a.a("no boolean at index ", i10), this);
    }

    public CLObject getObject(int i10) throws CLParsingException {
        CLElement cLElement = get(i10);
        if (cLElement instanceof CLObject) {
            return (CLObject) cLElement;
        }
        throw new CLParsingException(h.a.a("no object at index ", i10), this);
    }

    public CLElement get(int i10) throws CLParsingException {
        if (i10 >= 0 && i10 < this.mElements.size()) {
            return this.mElements.get(i10);
        }
        throw new CLParsingException(h.a.a("no element at index ", i10), this);
    }
}
