<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8"/>
    <title>弹幕</title>
<link rel="stylesheet" type="text/css" href="/css/barrager.css">
<link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">	
<link rel="stylesheet" href="/css/baguetterbox/baguetteBox.min.css">
<link rel="stylesheet" href="css/baguetterbox/gallery-clean.css">
</head>
<body onload="connect()" bgcolor="#FF6600">
<noscript><h2 style="color: #e80b0a;">Sorry，浏览器不支持WebSocket</h2></noscript>
  <div class="htmleaf-container">
		<div class="container gallery-container">

		    <h1>Bootstrap 3 Gallery</h1>
	    
		    <p class="page-description text-center">Clean Layout With Minimal Styles</p>
		    
		    <div class="tz-gallery">
				<div class='row'>
				</div>
		    </div>

		</div>

	</div>


          
<script type="text/javascript" src="/js/plugins/sockjs/sockjs.min.js"></script>
<script type="text/javascript" src="/js/plugins/stomp/stomp.js"></script>
<script type="text/javascript" src="/js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="/js/plugins/barrage/jquery.barrager.min.js"></script>
<script type="text/javascript" src="js/plugins/baguetterbox/baguetteBox.min.js"></script>

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
			if($('#baguetteBox-overlay')) {
				$('#baguetteBox-overlay').barrager(data);
			}
			
		}
	}
	
	function showImage(data){
		if(data){
			var html = "<div class='col-sm-6 col-md-4'><div class='thumbnail'><a class='lightbox' href='"+data.path+"'><img src='"+data.path+"' width='200' height='200' alt='Traffic'></a><div class='caption'><h3>Thumbnail label</h3><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p></div></div></div>";
			console.log(html);
			$(".row").append(html);
			baguetteBox.run('.tz-gallery');
		}
	}
</script>
</body>
</html>