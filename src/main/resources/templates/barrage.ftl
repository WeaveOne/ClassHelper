<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <title>弹幕</title>
<link rel="stylesheet" type="text/css" href="/css/barrager.css">
</head>
<body onload="connect()" bgcolor="#FF6600">
<noscript><h2 style="color: #e80b0a;">Sorry，浏览器不支持WebSocket</h2></noscript>
  <div id="images">
  
</div>


          
<script type="text/javascript" src="/js/plugins/sockjs/sockjs.min.js"></script>
<script type="text/javascript" src="/js/plugins/stomp/stomp.js"></script>
<script type="text/javascript" src="/js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="/js/plugins/barrage/jquery.barrager.min.js"></script>
<script type="text/javascript">
    var stompClient = null;
    function connect() {
         var socket = new SockJS('/barrage');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            console.log('Connected:' + frame);
            stompClient.subscribe('/user/1/message', function (response) {
            	console.log(JSON.parse(response.body));
                showBarrage(JSON.parse(response.body));
            })
        });
         var socket2 = new SockJS('/barrage');
          stompClient2 = Stomp.over(socket2);
        stompClient2.connect({}, function (frame) {
            console.log('Connected:' + frame);
            stompClient2.subscribe('/user/1/image', function (response) {
            console.log(JSON.parse(response.body));
                showImage(JSON.parse(response.body));
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
		if(data){
			$('body').barrager(data);
		}
	}
	
	function showImage(data){
		if(data){
			var html = "<a href='javascript:;' i='"+data.path+"' class='Slide Two'><img src='"+data.path+"' ></a>";
			console.log(html);
			$("#images").append(html);
		}
	}
</script>
</body>
</html>