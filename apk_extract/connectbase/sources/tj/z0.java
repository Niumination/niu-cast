package tj;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z0 extends tj.d implements Externalizable {
    private static final long serialVersionUID = 1;
    private sj.x value;
    private boolean wasConfig;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f15759b;

        static {
            int[] iArr = new int[d.values().length];
            f15759b = iArr;
            try {
                iArr[d.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15759b[d.NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15759b[d.INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15759b[d.LONG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15759b[d.DOUBLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15759b[d.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15759b[d.LIST.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f15759b[d.OBJECT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[c.values().length];
            f15758a = iArr2;
            try {
                iArr2[c.ORIGIN_DESCRIPTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f15758a[c.ORIGIN_LINE_NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f15758a[c.ORIGIN_END_LINE_NUMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f15758a[c.ORIGIN_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f15758a[c.ORIGIN_URL.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f15758a[c.ORIGIN_RESOURCE.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f15758a[c.ORIGIN_COMMENTS.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f15758a[c.ORIGIN_NULL_URL.ordinal()] = 8;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f15758a[c.ORIGIN_NULL_RESOURCE.ordinal()] = 9;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f15758a[c.ORIGIN_NULL_COMMENTS.ordinal()] = 10;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f15758a[c.END_MARKER.ordinal()] = 11;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f15758a[c.ROOT_VALUE.ordinal()] = 12;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f15758a[c.ROOT_WAS_CONFIG.ordinal()] = 13;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f15758a[c.VALUE_DATA.ordinal()] = 14;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f15758a[c.VALUE_ORIGIN.ordinal()] = 15;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f15758a[c.UNKNOWN.ordinal()] = 16;
            } catch (NoSuchFieldError unused24) {
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f15760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ByteArrayOutputStream f15761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final DataOutput f15762c;

        public b(c cVar) {
            this.f15760a = cVar;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f15761b = byteArrayOutputStream;
            this.f15762c = new DataOutputStream(byteArrayOutputStream);
        }
    }

    public enum c {
        UNKNOWN,
        END_MARKER,
        ROOT_VALUE,
        ROOT_WAS_CONFIG,
        VALUE_DATA,
        VALUE_ORIGIN,
        ORIGIN_DESCRIPTION,
        ORIGIN_LINE_NUMBER,
        ORIGIN_END_LINE_NUMBER,
        ORIGIN_TYPE,
        ORIGIN_URL,
        ORIGIN_COMMENTS,
        ORIGIN_NULL_URL,
        ORIGIN_NULL_COMMENTS,
        ORIGIN_RESOURCE,
        ORIGIN_NULL_RESOURCE;

        public static c forInt(int i10) {
            return i10 < values().length ? values()[i10] : UNKNOWN;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'INT' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class d {
        public static final d BOOLEAN;
        public static final d DOUBLE;
        public static final d INT;
        public static final d LIST;
        public static final d LONG;
        public static final d NULL;
        public static final d OBJECT;
        public static final d STRING;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ d[] f15764a;
        sj.z configType;

        static {
            d dVar = new d("NULL", 0, sj.z.NULL);
            NULL = dVar;
            d dVar2 = new d("BOOLEAN", 1, sj.z.BOOLEAN);
            BOOLEAN = dVar2;
            sj.z zVar = sj.z.NUMBER;
            d dVar3 = new d("INT", 2, zVar);
            INT = dVar3;
            d dVar4 = new d("LONG", 3, zVar);
            LONG = dVar4;
            d dVar5 = new d("DOUBLE", 4, zVar);
            DOUBLE = dVar5;
            d dVar6 = new d("STRING", 5, sj.z.STRING);
            STRING = dVar6;
            d dVar7 = new d("LIST", 6, sj.z.LIST);
            LIST = dVar7;
            d dVar8 = new d("OBJECT", 7, sj.z.OBJECT);
            OBJECT = dVar8;
            f15764a = new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8};
        }

        public d(String str, int i10, sj.z zVar) {
            super(str, i10);
            this.configType = zVar;
        }

        public static d forInt(int i10) {
            if (i10 < values().length) {
                return values()[i10];
            }
            return null;
        }

        public static d forValue(sj.x xVar) {
            sj.z zVarValueType = xVar.valueType();
            if (zVarValueType != sj.z.NUMBER) {
                for (d dVar : values()) {
                    if (dVar.configType == zVarValueType) {
                        return dVar;
                    }
                }
            } else {
                if (xVar instanceof p) {
                    return INT;
                }
                if (xVar instanceof q) {
                    return LONG;
                }
                if (xVar instanceof l) {
                    return DOUBLE;
                }
            }
            throw new sj.c.d("don't know how to serialize " + xVar);
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) f15764a.clone();
        }
    }

    public z0() {
        super(null);
    }

    public static c g(DataInput dataInput) throws IOException {
        int unsignedByte = dataInput.readUnsignedByte();
        if (unsignedByte != c.UNKNOWN.ordinal()) {
            return c.forInt(unsignedByte);
        }
        throw new IOException(k.b.a("field code ", unsignedByte, " is not supposed to be on the wire"));
    }

    public static tj.d i(DataInput dataInput, g1 g1Var) throws IOException {
        tj.d dVarJ = null;
        g1 origin = null;
        while (true) {
            c cVarG = g(dataInput);
            if (cVarG == c.END_MARKER) {
                if (dVarJ != null) {
                    return dVarJ;
                }
                throw new IOException("No value data found in serialization of value");
            }
            if (cVarG == c.VALUE_DATA) {
                if (origin == null) {
                    throw new IOException("Origin must be stored before value data");
                }
                dataInput.readInt();
                dVarJ = j(dataInput, origin);
            } else if (cVarG == c.VALUE_ORIGIN) {
                dataInput.readInt();
                origin = readOrigin(dataInput, g1Var);
            } else {
                m(dataInput);
            }
        }
    }

    public static tj.d j(DataInput dataInput, g1 g1Var) throws IOException {
        int unsignedByte = dataInput.readUnsignedByte();
        d dVarForInt = d.forInt(unsignedByte);
        if (dVarForInt == null) {
            throw new IOException(h.a.a("Unknown serialized value type: ", unsignedByte));
        }
        int i10 = 0;
        switch (a.f15759b[dVarForInt.ordinal()]) {
            case 1:
                return new g(g1Var, dataInput.readBoolean());
            case 2:
                return new c0(g1Var);
            case 3:
                return new p(g1Var, dataInput.readInt(), dataInput.readUTF());
            case 4:
                return new q(g1Var, dataInput.readLong(), dataInput.readUTF());
            case 5:
                return new l(g1Var, dataInput.readDouble(), dataInput.readUTF());
            case 6:
                return new g0.a(g1Var, dataInput.readUTF());
            case 7:
                int i11 = dataInput.readInt();
                ArrayList arrayList = new ArrayList(i11);
                while (i10 < i11) {
                    arrayList.add(i(dataInput, g1Var));
                    i10++;
                }
                return new e1(g1Var, arrayList);
            case 8:
                int i12 = dataInput.readInt();
                HashMap map = new HashMap(i12);
                while (i10 < i12) {
                    map.put(dataInput.readUTF(), i(dataInput, g1Var));
                    i10++;
                }
                return new f1(g1Var, map);
            default:
                throw new IOException("Unhandled serialized value type: " + dVarForInt);
        }
    }

    public static sj.c l() {
        return new sj.c.d(z0.class.getName().concat(" should not exist outside of serialization"));
    }

    public static void m(DataInput dataInput) throws IOException {
        int i10 = dataInput.readInt();
        int iSkipBytes = dataInput.skipBytes(i10);
        if (iSkipBytes < i10) {
            dataInput.readFully(new byte[i10 - iSkipBytes]);
        }
    }

    public static void q(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(c.END_MARKER.ordinal());
    }

    public static void r(DataOutput dataOutput, b bVar) throws IOException {
        byte[] byteArray = bVar.f15761b.toByteArray();
        dataOutput.writeByte(bVar.f15760a.ordinal());
        dataOutput.writeInt(byteArray.length);
        dataOutput.write(byteArray);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0094 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x0007 A[SYNTHETIC] */
    public static g1 readOrigin(DataInput dataInput, g1 g1Var) throws IOException {
        Object utf;
        EnumMap enumMap = new EnumMap(c.class);
        while (true) {
            c cVarG = g(dataInput);
            switch (a.f15758a[cVarG.ordinal()]) {
                case 1:
                    dataInput.readInt();
                    utf = dataInput.readUTF();
                    if (utf != null) {
                        enumMap.put(cVarG, utf);
                    }
                    break;
                case 2:
                    dataInput.readInt();
                    utf = Integer.valueOf(dataInput.readInt());
                    if (utf != null) {
                        enumMap.put(cVarG, utf);
                    }
                    break;
                case 3:
                    dataInput.readInt();
                    utf = Integer.valueOf(dataInput.readInt());
                    if (utf != null) {
                        enumMap.put(cVarG, utf);
                    }
                    break;
                case 4:
                    dataInput.readInt();
                    utf = Integer.valueOf(dataInput.readUnsignedByte());
                    if (utf != null) {
                        enumMap.put(cVarG, utf);
                    }
                    break;
                case 5:
                    dataInput.readInt();
                    utf = dataInput.readUTF();
                    if (utf != null) {
                        enumMap.put(cVarG, utf);
                    }
                    break;
                case 6:
                    dataInput.readInt();
                    utf = dataInput.readUTF();
                    if (utf != null) {
                        enumMap.put(cVarG, utf);
                    }
                    break;
                case 7:
                    dataInput.readInt();
                    int i10 = dataInput.readInt();
                    ArrayList arrayList = new ArrayList(i10);
                    for (int i11 = 0; i11 < i10; i11++) {
                        arrayList.add(dataInput.readUTF());
                    }
                    utf = arrayList;
                    if (utf != null) {
                        enumMap.put(cVarG, utf);
                    }
                    break;
                case 8:
                case 9:
                case 10:
                    dataInput.readInt();
                    utf = "";
                    if (utf != null) {
                        enumMap.put(cVarG, utf);
                    }
                    break;
                case 11:
                    return g1.j(g1Var, enumMap);
                case 12:
                case 13:
                case 14:
                case 15:
                    throw new IOException("Not expecting this field here: " + cVarG);
                case 16:
                    m(dataInput);
                default:
                    utf = null;
                    if (utf != null) {
                        enumMap.put(cVarG, utf);
                    }
                    break;
            }
        }
    }

    private Object readResolve() throws ObjectStreamException {
        return this.wasConfig ? ((sj.n) this.value).toConfig() : this.value;
    }

    public static void s(DataOutput dataOutput, c cVar, Object obj) throws IOException {
        switch (a.f15758a[cVar.ordinal()]) {
            case 1:
                dataOutput.writeUTF((String) obj);
                return;
            case 2:
                dataOutput.writeInt(((Integer) obj).intValue());
                return;
            case 3:
                dataOutput.writeInt(((Integer) obj).intValue());
                return;
            case 4:
                dataOutput.writeByte(((Integer) obj).intValue());
                return;
            case 5:
                dataOutput.writeUTF((String) obj);
                return;
            case 6:
                dataOutput.writeUTF((String) obj);
                return;
            case 7:
                List list = (List) obj;
                dataOutput.writeInt(list.size());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    dataOutput.writeUTF((String) it.next());
                }
                return;
            case 8:
            case 9:
            case 10:
                return;
            default:
                throw new IOException("Unhandled field from origin: " + cVar);
        }
    }

    public static void t(DataOutput dataOutput, sj.x xVar, g1 g1Var) throws IOException {
        b bVar = new b(c.VALUE_ORIGIN);
        writeOrigin(bVar.f15762c, (g1) xVar.origin(), g1Var);
        r(dataOutput, bVar);
        b bVar2 = new b(c.VALUE_DATA);
        u(bVar2.f15762c, xVar);
        r(dataOutput, bVar2);
        q(dataOutput);
    }

    public static void u(DataOutput dataOutput, sj.x xVar) throws IOException {
        d dVarForValue = d.forValue(xVar);
        dataOutput.writeByte(dVarForValue.ordinal());
        switch (a.f15759b[dVarForValue.ordinal()]) {
            case 1:
                dataOutput.writeBoolean(((g) xVar).unwrapped().booleanValue());
                break;
            case 3:
                dataOutput.writeInt(((p) xVar).unwrapped().intValue());
                dataOutput.writeUTF(((d0) xVar).transformToString());
                break;
            case 4:
                dataOutput.writeLong(((q) xVar).unwrapped().longValue());
                dataOutput.writeUTF(((d0) xVar).transformToString());
                break;
            case 5:
                dataOutput.writeDouble(((l) xVar).unwrapped().doubleValue());
                dataOutput.writeUTF(((d0) xVar).transformToString());
                break;
            case 6:
                dataOutput.writeUTF(((g0) xVar).unwrapped());
                break;
            case 7:
                sj.j jVar = (sj.j) xVar;
                dataOutput.writeInt(jVar.size());
                Iterator<sj.x> it = jVar.iterator();
                while (it.hasNext()) {
                    t(dataOutput, it.next(), (g1) jVar.origin());
                }
                break;
            case 8:
                sj.n nVar = (sj.n) xVar;
                dataOutput.writeInt(nVar.size());
                for (Map.Entry<String, sj.x> entry : nVar.entrySet()) {
                    dataOutput.writeUTF(entry.getKey());
                    t(dataOutput, entry.getValue(), (g1) nVar.origin());
                }
                break;
        }
    }

    public static void writeOrigin(DataOutput dataOutput, g1 g1Var, g1 g1Var2) throws IOException {
        for (Map.Entry<c, Object> entry : (g1Var != null ? g1Var.y(g1Var2) : Collections.emptyMap()).entrySet()) {
            b bVar = new b(entry.getKey());
            s(bVar.f15762c, bVar.f15760a, entry.getValue());
            r(dataOutput, bVar);
        }
        q(dataOutput);
    }

    @Override // tj.d
    public boolean equals(Object obj) {
        if (!(obj instanceof z0) || !canEqual(obj)) {
            return false;
        }
        z0 z0Var = (z0) obj;
        return this.wasConfig == z0Var.wasConfig && this.value.equals(z0Var.value);
    }

    public final DataInput f(ObjectInput objectInput) throws IOException {
        byte[] bArr = new byte[objectInput.readInt()];
        objectInput.readFully(bArr);
        return new DataInputStream(new ByteArrayInputStream(bArr));
    }

    @Override // tj.d
    public int hashCode() {
        return (((this.value.hashCode() + 41) * 41) + (this.wasConfig ? 1 : 0)) * 41;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        while (true) {
            c cVarG = g(objectInput);
            if (cVarG == c.END_MARKER) {
                return;
            }
            DataInput dataInputF = f(objectInput);
            if (cVarG == c.ROOT_VALUE) {
                this.value = i(dataInputF, null);
            } else if (cVarG == c.ROOT_WAS_CONFIG) {
                this.wasConfig = dataInputF.readBoolean();
            }
        }
    }

    @Override // tj.d
    public final String toString() {
        return getClass().getSimpleName() + "(value=" + this.value + ",wasConfig=" + this.wasConfig + ")";
    }

    @Override // sj.x
    public Object unwrapped() {
        throw l();
    }

    @Override // sj.x
    public sj.z valueType() {
        throw l();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        if (((tj.d) this.value).resolveStatus() != y0.RESOLVED) {
            throw new NotSerializableException("tried to serialize a value with unresolved substitutions, need to Config#resolve() first, see API docs");
        }
        b bVar = new b(c.ROOT_VALUE);
        t(bVar.f15762c, this.value, null);
        r(objectOutput, bVar);
        b bVar2 = new b(c.ROOT_WAS_CONFIG);
        bVar2.f15762c.writeBoolean(this.wasConfig);
        r(objectOutput, bVar2);
        q(objectOutput);
    }

    public z0(sj.x xVar) {
        this();
        this.value = xVar;
        this.wasConfig = false;
    }

    @Override // tj.d
    public z0 newCopy(sj.o oVar) {
        throw l();
    }

    public z0(sj.a aVar) {
        this(aVar.root());
        this.wasConfig = true;
    }
}
