<!DOCTYPE html>
<html>
<head>
	<title>慕课商城 - 后台管理</title>
    
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
    <link rel="stylesheet" href="/admin/css/compiled/new-user.css" type="text/css" media="screen" />


    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>

	<!-- navbar -->
	<div class="navbar navbar-inverse">
		<div class="navbar-inner">
			<button type="button" class="btn btn-navbar visible-phone"
				id="menu-toggler">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<a class="brand" href="/admin/index"
				style="font-weight: 700; font-family: Microsoft Yahei">后台管理</a>

			<ul class="nav pull-right">
				<li class="settings hidden-phone"><a href="/admin/logout"
					role="button"> <i class="icon-share-alt"></i>
				</a></li>
			</ul>
			
		</div>
	</div>
	<!-- end navbar -->

	<!-- sidebar -->
	<div id="sidebar-nav">
		<ul id="dashboard-menu">
			<li >
				<div class="pointer">
					<div class="arrow"></div>
					<div class="arrow_border"></div>
				</div> <a href="/admin/index"> <i class="icon-home"></i> <span>后台首页</span>
			</a>
			</li>
			<li class="active"><a class="dropdown-toggle" href="#"> <i
					class="icon-group"></i> <span>用户管理</span> <i
					class="icon-chevron-down"></i>
			</a>
				<ul class="submenu">
					<li><a href="/admin/teacher">教师管理</a></li>
					<li><a href="/admin/student/1">用户管理</a></li>
				</ul></li>
			<li>
                <a href="/admin/file/1">
                    <i class="icon-th-large"></i>
                    <span>资源管理</span>
                </a>
            </li>	
		</ul>
	</div>
	<!-- end sidebar -->


	<!-- main container -->
    <div class="content">
        
        <div class="container-fluid">
            <div id="pad-wrapper" class="new-user">
                <div class="row-fluid header">
                    <h3>添加教师</h3>
                </div>

                <div class="row-fluid form-wrapper">
                    <!-- left column -->
                    <div class="span9 with-sidebar">
                        <div class="container">
                            <form class="new_user_form inline-input" aciton="/admin/teacherAdd" method="post"/>
                                <div class="span12 field-box">
                                    <label>教师工号:</label>
                                    <input class="span9" id ="id" type="text" />
                                </div>
                               
                                <div class="span12 field-box">
                                    <label>教师姓名:</label>
                                    <input class="span9" id = "name" type="text" />
                                </div>
                                <div class="span12 field-box">
                                    <label>电话:</label>
                                    <input class="span9" id="phone" type="text" />
                                </div>
                                <div class="span11 field-box actions">
                                    <input type="button" onclick="add()" class="btn-glow primary" value="添加" />
                                    <span>OR</span>
                                    <input type="reset" value="重置" class="reset" />
                                </div>
                            </form>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <!-- end main container -->


	<!-- scripts -->
    <script src="/admin/js/jquery-latest.js"></script>
    <script src="/admin/js/bootstrap.min.js"></script>
    <script src="/admin/js/theme.js"></script>

    <script type="text/javascript">
       function add(){
       		$.ajax({
       			url:"/admin/teacherAdd",
       			data:{
       				id:$("#id").val(),
       				name:$("#name").val(),
       				phone:$("#phone").val()
       			},
       			success:function(data){
       				window.location.href="/admin/teacher";
       			}
       		});
       }
    </script>

</body>
</html>