package io.zino.knotgrass.domain;

import com.google.common.hash.Hashing;
import org.bson.Document;

import java.nio.charset.StandardCharsets;

public class SignedBlockDO extends UnsignedBlockDO{

    public final static String COLLECTION = "blocks";
    public final static String PRP_UUID = "uuid";
    public final static String PRP_INDEX = "index";
    public final static String PRP_CREATE_AT = "create_at";
    public final static String PRP_PRE_UUID = "pre_uuid";
    public final static String PRP_PRE_HASH = "pre_hash";
    public final static String PRP_DATA = "pre_data";
    public final static String PRP_MINER_UUID = "miner_uuid";
    public final static String PRP_SIGN = "sign";
    public final static String PRP_NONCE = "nonce";

    private String sign;

    public SignedBlockDO() {
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public static Document saveTo(SignedBlockDO blockDO) {
        Document doc = new Document();
        doc.put(SignedBlockDO.PRP_UUID, blockDO.getUuid());
        doc.put(SignedBlockDO.PRP_INDEX, blockDO.getIndex());
        doc.put(SignedBlockDO.PRP_CREATE_AT, blockDO.getCreateAt());
        doc.put(SignedBlockDO.PRP_PRE_UUID, blockDO.getPreUuid());
        doc.put(SignedBlockDO.PRP_PRE_HASH, blockDO.getPrehash());
        doc.put(SignedBlockDO.PRP_DATA, blockDO.getData());
        doc.put(SignedBlockDO.PRP_MINER_UUID, blockDO.getMinerUuid());
        doc.put(SignedBlockDO.PRP_SIGN, blockDO.getSign());
        doc.put(SignedBlockDO.PRP_NONCE, blockDO.getNonce());
        return doc;
    }

    public static SignedBlockDO loadFrom(Document doc) {
        SignedBlockDO blk = new SignedBlockDO();
        blk.setUuid(doc.getString(SignedBlockDO.PRP_UUID));
        blk.setIndex(doc.getLong(SignedBlockDO.PRP_INDEX));
        blk.setCreateAt(doc.getLong(SignedBlockDO.PRP_CREATE_AT));
        blk.setPreUuid(doc.getString(SignedBlockDO.PRP_PRE_UUID));
        blk.setPrehash(doc.getString(SignedBlockDO.PRP_PRE_HASH));
        blk.setData(doc.getString(SignedBlockDO.PRP_DATA));
        blk.setMinerUuid(doc.getString(SignedBlockDO.PRP_MINER_UUID));
        blk.setSign(doc.getString(SignedBlockDO.PRP_SIGN));
        blk.setNonce(doc.getLong(SignedBlockDO.PRP_NONCE));
        return blk;
    }

    public String computeHash() {
        return Hashing.sha256()
                .hashString(this.toString(), StandardCharsets.UTF_8)
                .toString();
    }

}
