package io.zino.knotgrass;

public class ServerConfig{
	private String uuid;
        private String url;
        private Integer port;
        private String sign;

        ServrConfig(String uuid, String url, Integer port, String sign){
        	this.uuid = uuid;
                this.url = url;
                this.port = port;
                this.sign = sign;
	}

        public String getUuid(){return this.uuid;}
        public String getUrl(){return this.url;}
        public Integer getPort(){return this.port;}
        public String getSign(){return this.sign;}
}

