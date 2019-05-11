package pub.hqs.pojo;

/**
 * @program: JavaSample
 * @description: 统一的返回类型
 * @author: hqs.pub
 * @create: 2019-05-11 23:11
 **/
public class ResultMsg {
    private boolean result;
    private String message;
    private Object data;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
