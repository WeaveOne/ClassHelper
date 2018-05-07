<!DOCTYPE html>
<html>
<head>
	<title>后台管理</title>
    
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
    <link href="/admin/css/lib/font-awesome.css" type="text/css" rel="stylesheet" />
    
    <!-- this page specific styles -->
    <link rel="stylesheet" href="/admin/css/compiled/user-list.css" type="text/css" media="screen" />


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
            <div id="pad-wrapper" class="users-list">
                <div class="row-fluid header">
                    <h3>学生</h3>
                </div>

                <!-- Users table -->
                <div class="row-fluid table">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th class="span4 sortable">
                                   		 学号
                                </th>
                                <th class="span3 sortable">
                                    	姓名
                                </th>

                                 <th class="span2 sortable">
                                  		 操作
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                        <!-- row -->
                       <#if data?? && (data?size > 0) > 
			             <#list data as d>
			             	 <tr class="first">
                            <td>
                                <span class="subtext">${d.id}</span>
                            </td>
                            <td>
                               ${d.name}
                            </td>
                             <td>
                                <a href="/admin/deleteStudent?id=${d.id}">delete</a>
                            </td>
                        </tr>
			              </#list>
			            </#if>
                       
                        </tbody>
                    </table>
                </div>
                <div class="pagination pull-right">
                    <ul>
                        <#if cnt.page==1>
                        	 <li style="display:none"><a href="#">&#8249;</a></li>
                        <#else>
                        	 <li><a href="/admin/student/${cnt.page-1}">&#8249;</a></li>
                         </#if>
			            <#list 1..cnt.cnt as t>
			            <#if cnt.page==t>
                          <li><a class="active" href="/admin/student/${t}">${t}</a></li>
                        <#else>
                        	 <li><a href="/admin/student/${t}">${t}</a></li>
                        </#if>
                        </#list>
                          <#if cnt.page==cnt.cnt>
                           <li style="display:none"><a href="#">&#8250;</a></li>
                        <#else>
                          <li><a href="/admin/student/${cnt.page+1}">&#8250;</a></li>
                        </#if>
                    </ul>
                </div>
                <!-- end users table -->
            </div>
        </div>
    </div>
    <!-- end main container -->


	<!-- scripts -->
    <script src="/admin/js/jquery-latest.js"></script>
    <script src="/admin/js/bootstrap.min.js"></script>
    <script src="/admin/js/theme.js"></script>

</body>
</html>