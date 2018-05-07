<!DOCTYPE html>
<html class="login-bg">
<head>
	<title>课堂助手 - 后台管理</title>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
    <!-- bootstrap -->
    <link href="/admin/css/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="/admin/css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
    <link href="/admin/css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="/admin/css/layout.css" />
    <link rel="stylesheet" type="text/css" href="/admin/css/elements.css" />
    <link rel="stylesheet" type="text/css" href="/admin/css/icons.css" />

    <!-- libraries -->
    <link rel="stylesheet" type="text/css" href="/admin/css/lib/font-awesome.css" />
    
    <!-- this page specific styles -->
    <link rel="stylesheet" href="/admin/css/compiled/signin.css" type="text/css" media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>


    <div class="row-fluid login-wrapper">
        <a class="brand" href="index.html"></a>

        <div class="span4 box">
            <div class="content-wrap">
                <h6>课堂助手 - 后台管理</h6>
                <input class="span12" type="text" id="account" placeholder="管理员账号" />
                <input class="span12" type="password" id = "password" placeholder="管理员密码" />
                <a class="btn-glow primary login" href="javascript:login()">登录</a>
            </div>
        </div>

    </div>

	<!-- scripts -->
    <script src="/admin/js/jquery-latest.js"></script>
    <script src="/admin/js/bootstrap.min.js"></script>
    <script src="/admin/js/theme.js"></script>

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

                $("html").css("background-image", "url('/admin/img/bgs/" + bg + "')");
            });

        });
        function login(){
        	var id = $("#account").val();
        	var name = $("#password").val();
        	window.location.href = "/admin/check?account="+account + "&password="+password;
        }
    </script>

</body>
</html>