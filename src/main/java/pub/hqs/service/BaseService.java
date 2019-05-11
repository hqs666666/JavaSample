package pub.hqs.service;

import pub.hqs.pojo.ResultMsg;

/**
 * @program: JavaSample
 * @description: 服务基类
 * @author: hqs.pub
 * @create: 2019-05-06 21:20
 **/
public class BaseService implements IBaseService {
    protected ResultMsg createResultMsg() {
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setResult(true);
        return resultMsg;
    }

    protected ResultMsg createResultMsg(int rows) {
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setResult(rows > 0);
        resultMsg.setMessage(rows > 0 ? "保存成功" : "保存失败");
        return resultMsg;
    }

    protected ResultMsg createResultMsg(String message) {
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setResult(true);
        resultMsg.setMessage(message);
        return resultMsg;
    }

    protected ResultMsg createResultMsg(String message, Object data) {
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setResult(true);
        resultMsg.setMessage(message);
        resultMsg.setData(data);
        return resultMsg;
    }

    protected ResultMsg createErrorResultMsg(String message) {
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setResult(false);
        resultMsg.setMessage(message);
        return resultMsg;
    }
}
