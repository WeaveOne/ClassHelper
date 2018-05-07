<!DOCTYPE html>
<html class="login-bg">
<head>
	<title>登陆界面</title>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
    <!-- bootstrap -->
    <link href="/css/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="/css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
    <link href="/css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="/css/layout.css" />
    <link rel="stylesheet" type="text/css" href="/css/elements.css" />
    <link rel="stylesheet" type="text/css" href="/css/icons.css" />

    <!-- libraries -->
    <link rel="stylesheet" type="text/css" href="/css/lib/font-awesome.css" />
    
    <!-- this page specific styles -->
    <link rel="stylesheet" href="/css/compiled/signin.css" type="text/css" media="screen" />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>


    <div class="row-fluid login-wrapper">
        <a class="brand" href="index.html"></a>

        <div class="span4 box">
            <div class="content-wrap">
                <h6>课堂助手 </h6>
                <input class="span12" id='id' type="text" placeholder="教师工号" />
                <input class="span12" id='name' type="password" placeholder="教师姓名" />
                <div class="remember">
                    <input id="remember-me" type="checkbox" />
                    <label for="remember-me">记住我</label>
                </div>
                <a class="btn-glow primary login" href="javascript:login()">登录</a>
            </div>
        </div>
    </div>

	<!-- scripts -->
    <script src="/js/jquery-latest.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/theme.js"></script>

    <!-- pre load bg imgs -->
    <script type="text/javascript">
        $(function () {
            // bg switcher
            var $btns = $(".bg-switch .bg");
            $btns.click(function (e) {
                e.preventDefault();
                $btns.removeClass("active");
                $(this).addClass("active");
                var bg = $(this).data("img");

                $("html").css("background-image", "url('/images/bgs/" + bg + "')");
            });

        });
        function login(){
        	var id = $("#id").val();
        	var name = $("#name").val();
        	window.location.href = "/login/check?t_id="+id + "&t_name="+name;
        }
    </script>

</body>
</html>