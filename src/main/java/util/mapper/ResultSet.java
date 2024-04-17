package util.mapper;

import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResultSet {
    private String resultCode;
    private String msg;
    private Map<String, Object> result;
    private Object extraData;

    public ResultSet(String resultCode, String msg, Map<String, Object> result) {
        this.resultCode = resultCode;
        this.msg = msg;
        this.result = result;
    }

    public ResultSet(String resultCode, String msg, Map<String, Object> result, Object extraData) {
        this.resultCode = resultCode;
        this.msg = msg;
        this.result = result;
        this.extraData = extraData;
    }


    public ResultSet(String resultCode, String msg) {
        this.resultCode = resultCode;
        this.msg = msg;
    }

    public boolean isFail() {
        return isSuccess() == false;
    }

    public boolean isSuccess() {
        return resultCode.startsWith("S");
    }


}
