<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <title>弹幕</title>
    <script type="text/javascript" src="/js/plugins/sockjs/sockjs.min.js"></script>
    <script type="text/javascript" src="/js/plugins/stomp/stomp.js"></script>
    <script type="text/javascript" src="/js/jquery-3.1.1.js"></script>
    <style>
            *{
                margin: 0;
                padding: 0;
            }
            #box{
                width: 1300px;
                height: 600px;
                border: 1px solid black;
                background: skyblue;
                margin: 50px auto;
                position: relative;
                overflow: hidden;
            }
            #txt{
                width: 400px;
                height: 50px;
                margin-left: 25%;
                
            }
            #btn{
                width: 100px;
                height: 50px;
                border: 1px solid black;
                position: absolute;
                background: gray;
                text-align: center;
                line-height: 50px;
                text-decoration: none;
                font-size: 20px;
            }
            span{
                position: absolute;
            }
            </style>
             <script>
            $(function(){
                $("#btn").click(function(){
                    //定义一个变量存储输入的字符串
                    $str = $("#txt").val();
                    //定义一个变量用来存储top值。最小值是0，最大值是600.
                    $top = Math.random() * 560;
                    //定义词一个变量存储字体的大小,最小值10，最大值40.
                    $fon = Math.random() * 30 + 10;
                    //设置span的颜色
                    $arr = ["red","blue","yellow","black","green","pink","orange","purple","white","sienna"];
                    $num = Math.floor(Math.random() * 10);
                    $col = $arr[$num];
                    //为span设置随机的速度,最快速度为2000.
                    $speed = Math.random() * 10000 + 2000;
                    //创建span节点追加到div中
                    $("<span></span>").appendTo("#box").text($str).addClass("span").siblings().removeClass("span");
                    $(".span").css({"font-size":$fon});
                    //获取span的宽度
                    $wid = $(".span").width();
                    //设置样式
                    $(".span").css({"top":$top,"color":$col,"right":-$wid});
                    //设置目的地、速度、运动方式、回调函数。
                    $(".span").animate({"left":-$wid},$speed,"linear",function(){
                        $(this).remove();
                    });
                })
            })
        </script>
</head>
<body onload="connect()">
<noscript><h2 style="color: #e80b0a;">Sorry，浏览器不支持WebSocket</h2></noscript>
 <div id="box"></div>
        <input type="text" id="txt"/>
        <a href="javascript:;" id="btn">发表评论</a>
<script type="text/javascript">
    var stompClient = null;
    function connect() {
         var socket = new SockJS('/barrage');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            console.log('Connected:' + frame);
            stompClient.subscribe('/user/1/message', function (response) {
            	console.log(JSON.parse(response.body).responseMessage);
                showBarrage(JSON.parse(response.body).responseMessage);
            })
        });
    }
    function disconnect() {
        if (stompClient != null) {
            stompClient.disconnect();
        }
        setConnected(false);
        console.log('Disconnected');
    }
	
	function showBarrage(data){
		//定义一个变量存储输入的字符串
                    $str = data;
                    //定义一个变量用来存储top值。最小值是0，最大值是600.
                    $top = Math.random() * 560;
                    //定义词一个变量存储字体的大小,最小值10，最大值40.
                    $fon = Math.random() * 30 + 10;
                    //设置span的颜色
                    $arr = ["red","blue","yellow","black","green","pink","orange","purple","white","sienna"];
                    $num = Math.floor(Math.random() * 10);
                    $col = $arr[$num];
                    //为span设置随机的速度,最快速度为2000.
                    $speed = Math.random() * 10000 + 1000;
                    //创建span节点追加到div中
                    $("<span></span>").appendTo("#box").text($str).addClass("span").siblings().removeClass("span");
                    $(".span").css({"font-size":$fon});
                    //获取span的宽度
                    $wid = $(".span").width();
                    //设置样式
                    $(".span").css({"top":$top,"color":$col,"right":-$wid});
                    //设置目的地、速度、运动方式、回调函数。
                    $(".span").animate({"left":-$wid},$speed,"linear",function(){
                        $(this).remove();
                    });
	}
</script>
</body>
</html>