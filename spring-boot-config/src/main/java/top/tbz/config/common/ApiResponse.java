package top.tbz.config.common;

import lombok.Getter;

/**
 * @author kimihiro
 */
@Getter
public class ApiResponse<T> {
    private final String status;
    private final String message;
    private final T data;
    public ApiResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <ResultStatus> ApiResponse<ResultStatus> success(String msg, ResultStatus rs) {
        return new ApiResponse<>("success", "发送成功" , rs);
    }

    public static <T> ApiResponse<T> fail(String msg) {
        return new ApiResponse<>("fail", "发送失败", null);
    }

}
