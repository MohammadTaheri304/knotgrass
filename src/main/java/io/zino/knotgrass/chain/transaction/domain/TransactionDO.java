package io.zino.knotgrass.chain.transaction.domain;

import com.google.gson.Gson;
import org.bson.Document;

import java.util.Objects;

public class TransactionDO {
    private final static Gson GSON = new Gson();

    public final static String COLLECTION = "transactions";
    public final static String PRP_UUID = "uuid";
    public final static String PRP_CREATE_AT = "create_at";
    public final static String PRP_FROM_UUID = "from_uuid";
    public final static String PRP_TO_UUID = "to_uuid";
    public final static String PRP_AMOUNT = "amount";
    public final static String PRP_SIG = "sig";

    private String uuid;
    private Long createAt;
    private String fromUuid;
    private String toUuid;
    private Long amount;
    private String sig;

    public TransactionDO() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public String getFromUuid() {
        return fromUuid;
    }

    public void setFromUuid(String fromUuid) {
        this.fromUuid = fromUuid;
    }

    public String getToUuid() {
        return toUuid;
    }

    public void setToUuid(String toUuid) {
        this.toUuid = toUuid;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    @Override
    public String toString() {
        return GSON.toJson(this);
    }

    public static Document saveTo(TransactionDO transactionDO) {
        Document doc = new Document();
        doc.put(TransactionDO.PRP_UUID, transactionDO.getUuid());
        doc.put(TransactionDO.PRP_CREATE_AT, transactionDO.getCreateAt());
        doc.put(TransactionDO.PRP_AMOUNT, transactionDO.getAmount());
        doc.put(TransactionDO.PRP_FROM_UUID, transactionDO.getFromUuid());
        doc.put(TransactionDO.PRP_TO_UUID, transactionDO.getToUuid());
        doc.put(TransactionDO.PRP_SIG, transactionDO.getSig());
        return doc;
    }

    public static TransactionDO loadFrom(Document doc) {
        TransactionDO tnx = new TransactionDO();
        tnx.setUuid(doc.getString(TransactionDO.PRP_UUID));
        tnx.setCreateAt(doc.getLong(TransactionDO.PRP_CREATE_AT));
        tnx.setAmount(doc.getLong(TransactionDO.PRP_AMOUNT));
        tnx.setFromUuid(doc.getString(TransactionDO.PRP_FROM_UUID));
        tnx.setToUuid(doc.getString(TransactionDO.PRP_TO_UUID));
        tnx.setSig(doc.getString(TransactionDO.PRP_SIG));
        return tnx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDO that = (TransactionDO) o;
        return Objects.equals(uuid, that.uuid) &&
                Objects.equals(fromUuid, that.fromUuid) &&
                Objects.equals(toUuid, that.toUuid) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(sig, that.sig);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uuid, fromUuid, toUuid, amount, sig);
    }
}
