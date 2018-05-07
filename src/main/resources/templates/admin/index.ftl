<!DOCTYPE html>
<html>
<head>
<title>后台管理</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- bootstrap -->
<link href="/admin/css/bootstrap/bootstrap.css" rel="stylesheet" />
<link href="/admin/css/bootstrap/bootstrap-responsive.css"
	rel="stylesheet" />
<link href="/admin/css/bootstrap/bootstrap-overrides.css"
	type="text/css" rel="stylesheet" />

<!-- libraries -->
<link href="/admin/css/lib/jquery-ui-1.10.2.custom.css" rel="stylesheet"
	type="text/css" />
<link href="/admin/css/lib/font-awesome.css" type="text/css"
	rel="stylesheet" />

<!-- global styles -->
<link rel="stylesheet" type="text/css" href="/admin/css/layout.css" />
<link rel="stylesheet" type="text/css" href="/admin/css/elements.css" />
<link rel="stylesheet" type="text/css" href="/admin/css/icons.css" />

<!-- this page specific styles -->
<link rel="stylesheet" href="/admin/css/compiled/index.css"
	type="text/css" media="screen" />


<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
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
			<li class="active">
				<div class="pointer">
					<div class="arrow"></div>
					<div class="arrow_border"></div>
				</div> <a href="/admin/index"> <i class="icon-home"></i> <span>后台首页</span>
			</a>
			</li>
			<li><a class="dropdown-toggle" href="#"> <i
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

			<!-- upper main stats -->
			<div id="main-stats">
				<div class="row-fluid stats-row">
					<div class="span3 stat">
						<div class="data">
							<span class="number">${cnts.teacher}</span> 个教师
						</div>
					</div>
					<div class="span3 stat">
						<div class="data">
							<span class="number">${cnts.student}</span> 个学生
						</div>
					</div>
					<div class="span3 stat">
						<div class="data">
							<span class="number">${cnts.signin}</span> 次签到记录
						</div>
					</div>
					<div class="span3 stat last">
						<div class="data">
							<span class="number">${cnts.file}</span> 个资源文件
						</div>
					</div>
				</div>
			</div>
			<!-- end upper main stats -->

			<div id="pad-wrapper">

				<!-- statistics chart built with jQuery Flot -->
				<div class="row-fluid chart">
					<h4>统计</h4>
					<div class="span12">
						<div id="statsChart"></div>
					</div>
				</div>
				<!-- end statistics chart -->





			</div>
			<!-- end table sample -->
		</div>
	</div>
	</div>


	<!-- scripts -->
	<script src="/admin/js/jquery-latest.js"></script>
	<script src="/admin/js/bootstrap.min.js"></script>
	<script src="/admin/js/jquery-ui-1.10.2.custom.min.js"></script>
	<!-- knob -->
	<script src="/admin/js/jquery.knob.js"></script>
	<!-- flot charts -->
	<script src="/admin/js/jquery.flot.js"></script>
	<script src="/admin/js/jquery.flot.stack.js"></script>
	<script src="/admin/js/jquery.flot.resize.js"></script>
	<script src="/admin/js/theme.js"></script>

	<script type="text/javascript">
		$(function() {

			// jQuery Knobs
			$(".knob").knob();

			// jQuery UI Sliders
			$(".slider-sample1").slider({
				value : 100,
				min : 1,
				max : 500
			});
			$(".slider-sample2").slider({
				range : "min",
				value : 130,
				min : 1,
				max : 500
			});
			$(".slider-sample3").slider({
				range : true,
				min : 0,
				max : 500,
				values : [ 40, 170 ],
			});
			var visits = [
			<#if data?? && (data?size > 0) > 
			 <#list data as d>
			    <#if d_index==0>
			 	  [${d.month},${d.cnt}]
			 	<#else>
			    ,[${d.month},${d.cnt}]
			 	</#if>
			 </#list>
			 </#if>
			 ]
			// jQuery Flot Chart
			//var visits = [ [ 1, 50 ], [ 2, 40 ], [ 3, 45 ], [ 4, 23 ],
			//		[ 5, 55 ], [ 6, 65 ], [ 7, 61 ], [ 8, 70 ], [ 9, 65 ],
			//		[ 10, 75 ], [ 11, 57 ], [ 12, 59 ] ];
		

			var plot = $.plot($("#statsChart"), [ {
				data : visits,
				label : "签到记录"
			} ], {
				series : {
					lines : {
						show : true,
						lineWidth : 1,
						fill : true,
						fillColor : {
							colors : [ {
								opacity : 0.1
							}, {
								opacity : 0.13
							} ]
						}
					},
					points : {
						show : true,
						lineWidth : 2,
						radius : 3
					},
					shadowSize : 0,
					stack : true
				},
				grid : {
					hoverable : true,
					clickable : true,
					tickColor : "#f9f9f9",
					borderWidth : 0
				},
				legend : {
					// show: false
					labelBoxBorderColor : "#fff"
				},
				colors : [ "#a7b5c5", "#30a0eb" ],
				xaxis : {
					ticks : [ [ 01, "一月" ], [ 02, "二月" ], [ 03, "三月" ],
							[ 04, "四月" ], [05, "五月" ], [ 06, "六月" ], [ 07, "七月" ],
							[08, "八月" ], [ 09, "九月" ], [ 10, "十月" ],
							[ 11, "十一月" ], [ 12, "十二月" ] ],
					font : {
						size : 12,
						family : "Open Sans, Arial",
						variant : "small-caps",
						color : "#697695"
					}
				},
				yaxis : {
					ticks : 3,
					tickDecimals : 0,
					font : {
						size : 12,
						color : "#9da3a9"
					}
				}
			});

			function showTooltip(x, y, contents) {
				$('<div id="tooltip">' + contents + '</div>').css({
					position : 'absolute',
					display : 'none',
					top : y - 30,
					left : x - 50,
					color : "#fff",
					padding : '2px 5px',
					'border-radius' : '6px',
					'background-color' : '#000',
					opacity : 0.80
				}).appendTo("body").fadeIn(200);
			}

			var previousPoint = null;
			$("#statsChart")
					.bind(
							"plothover",
							function(event, pos, item) {
								if (item) {
									if (previousPoint != item.dataIndex) {
										previousPoint = item.dataIndex;

										$("#tooltip").remove();
										var x = item.datapoint[0].toFixed(0), y = item.datapoint[1]
												.toFixed(0);

										var month = item.series.xaxis.ticks[item.dataIndex].label;

										showTooltip(item.pageX, item.pageY,
												item.series.label + " of "
														+ month + ": " + y);
									}
								} else {
									$("#tooltip").remove();
									previousPoint = null;
								}
							});
		});
	</script>

</body>
</html>