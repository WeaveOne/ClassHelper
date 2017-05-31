package cn.willvi.controller.appbarrage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.willvi.controller.BaseController;
import cn.willvi.util.PageData;

@Controller
@RequestMapping(value = "/barrage")
public class BarrageController extends BaseController {

	@Autowired
	private SimpMessageSendingOperations simpMessageSendingOperations;

	@MessageMapping("/welcome")
	@SendTo("/topic/getResponse")
	public ResponseMessage say(RequestMessage message) {
		System.out.println(message.getName());
		return new ResponseMessage("welcome," + message.getName() + " !");
	}

	/**
	 * 这里用的是@SendToUser，这就是发送给单一客户端的标志。本例中， 客户端接收一对一消息的主题应该是“/user/” + 用户Id +
	 * “/message” ,这里的用户id可以是一个普通的字符串，只要每个用户端都使用自己的id并且服务端知道每个用户的id就行。
	 * 
	 * @return
	 */
	@MessageMapping("/message")
	@SendToUser("/message")
	public ResponseMessage handleSubscribe() {
		return new ResponseMessage("连接成功");
	}

	/**
	 * 测试对指定用户发送消息方法
	 * 
	 * @return
	 */
	@RequestMapping(path = "/send")
	@ResponseBody
	public ResponseMessage send() {
		PageData pd = new PageData();
		pd = this.getPageData();
		String uid = pd.getString("id");
		String content = pd.getString("content");
		simpMessageSendingOperations.convertAndSendToUser(uid, "/message",
				new ResponseMessage(content));
		return new ResponseMessage("成功");
	}

	@RequestMapping(value = "/index")
	public String bragger() {

		return "barrage";
	}
}
