package io.zino.knotgrass.domain;

import com.google.common.hash.Hashing;
import org.bson.Document;

import java.nio.charset.StandardCharsets;

public class BlockDO {

    public final static String COLLECTION = "blocks";
    public final static String PRP_UUID = "uuid";
    public final static String PRP_INDEX = "index";
    public final static String PRP_CREATE_AT = "create_at";
    public final static String PRP_PRE_UUID = "pre_uuid";
    public final static String PRP_PRE_HASH = "pre_hash";
    public final static String PRP_DATA = "pre_data";
    public final static String PRP_MINER_UUID = "miner_uuid";
    public final static String PRP_HASH = "hash";
    public final static String PRP_NONCE = "nonce";

    private String uuid;
    private Long index;
    private Long createAt;

    private String preUuid;
    private String prehash;

    private String data;

    private String minnerUuid;

    private String hash;
    private Long nonce;

    public BlockDO() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public String getPreUuid() {
        return preUuid;
    }

    public void setPreUuid(String preUuid) {
        this.preUuid = preUuid;
    }

    public String getPrehash() {
        return prehash;
    }

    public void setPrehash(String prehash) {
        this.prehash = prehash;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMinnerUuid() {
        return minnerUuid;
    }

    public void setMinnerUuid(String minnerUuid) {
        this.minnerUuid = minnerUuid;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Long getNonce() {
        return nonce;
    }

    public void setNonce(Long nonce) {
        this.nonce = nonce;
    }

    @Override
    public String toString() {
        return "BlockDO{" +
                "uuid='" + uuid + '\'' +
                ", index=" + index +
                ", createAt=" + createAt +
                ", preUuid='" + preUuid + '\'' +
                ", prehash='" + prehash + '\'' +
                ", data='" + data + '\'' +
                ", minnerUuid='" + minnerUuid + '\'' +
                ", hash='" + hash + '\'' +
                ", nonce=" + nonce +
                '}';
    }

    public static Document saveTo(BlockDO blockDO) {
        Document doc = new Document();
        doc.put(BlockDO.PRP_UUID, blockDO.getUuid());
        doc.put(BlockDO.PRP_INDEX, blockDO.getIndex());
        doc.put(BlockDO.PRP_CREATE_AT, blockDO.getCreateAt());
        doc.put(BlockDO.PRP_PRE_UUID, blockDO.getPreUuid());
        doc.put(BlockDO.PRP_PRE_HASH, blockDO.getPrehash());
        doc.put(BlockDO.PRP_DATA, blockDO.getData());
        doc.put(BlockDO.PRP_MINER_UUID, blockDO.getMinnerUuid());
        doc.put(BlockDO.PRP_HASH, blockDO.getHash());
        doc.put(BlockDO.PRP_NONCE, blockDO.getNonce());
        return doc;
    }

    public static BlockDO loadFrom(Document doc) {
        BlockDO blk = new BlockDO();
        blk.setUuid(doc.getString(BlockDO.PRP_UUID));
        blk.setIndex(doc.getLong(BlockDO.PRP_INDEX));
        blk.setCreateAt(doc.getLong(BlockDO.PRP_CREATE_AT));
        blk.setPreUuid(doc.getString(BlockDO.PRP_PRE_UUID));
        blk.setPrehash(doc.getString(BlockDO.PRP_PRE_HASH));
        blk.setData(doc.getString(BlockDO.PRP_DATA));
        blk.setMinnerUuid(doc.getString(BlockDO.PRP_MINER_UUID));
        blk.setHash(doc.getString(BlockDO.PRP_HASH));
        blk.setNonce(doc.getLong(BlockDO.PRP_NONCE));
        return blk;
    }

    public String computeHash() {
        return Hashing.sha256()
                .hashString(this.toString(), StandardCharsets.UTF_8)
                .toString();
    }

}
