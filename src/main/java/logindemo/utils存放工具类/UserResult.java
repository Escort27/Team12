package logindemo.utils存放工具类;

public class UserResult<T> {
    private String code;
    private String msg;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public UserResult() {
    }

    public UserResult(T data) {
        this.data = data;
    }

    public static UserResult success() {
        UserResult result = new UserResult<>();
        result.setCode("0");
        result.setMsg("成功");
        return result;
    }

    public static <T> UserResult<T> success(T data) {
        UserResult<T> result = new UserResult<>(data);
        result.setCode("0");
        result.setMsg("成功");
        return result;
    }

    public static <T> UserResult<T> success(T data, String msg) {
        UserResult<T> result = new UserResult<>(data);
        result.setCode("0");
        result.setMsg(msg);
        return result;
    }

    public static UserResult error(String code, String msg) {
        UserResult result = new UserResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}