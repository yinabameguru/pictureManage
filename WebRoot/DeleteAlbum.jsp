<%@page import="com.jza.domain.Album"%>
<%@ page language="java" import="java.util.*" import="com.jza.service.BgService" import="com.jza.service.DeleteAlbumService" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.0 Transitional//EN">
<html>
  <head>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="shortcut icon" href="https://www.mygalgame.com/favicon.ico" type="image/x-icon">
		<link rel="bookmark" href="https://www.mygalgame.com/favicon.ico" type="image/x-icon">
		<meta http-equiv="Cache-Control" content="no-transform">
		<meta http-equiv="Cache-Control" content="no-siteapp">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="renderer" content="webkit">
		<title>MyPicture</title>
		<meta content="[blockquote]游戏截图[/blockquote]    [blockquote]游戏简介[/blo" name="description">
		<meta content="柚子社, 纯爱, " name="keywords">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="dns-prefetch" href="https://www.mygalgame.com/">
		<link rel="stylesheet" id="abc_style-css" href="./css/style.css" type="text/css" media="all">
		<link rel="stylesheet" id="bootstrap-style-css" href="./css/bootstrap.css" type="text/css" media="all">
		<link rel="stylesheet" id="fontawesome-style-css" href="./css/font-awesome.min.css" type="text/css" media="all">
		<link rel="stylesheet" id="mystyle-css" href="./css/myblog.css" type="text/css" media="all">
		<script src="./js/push.js"></script>
		<script src="./js/hm.js"></script>
		<script type="text/javascript" src="./js/jquery.js"></script>
		<script type="text/javascript" src="./js/jquery-migrate.min.js"></script>
		<script type="text/javascript" src="./js/jquery.cookie.js"></script>
		<script type="text/javascript" src="./js/script.js"></script>
		<script type="text/javascript" src="./js/bootstrap.js"></script>
		<script type="text/javascript" src="./js/jquery.icheck.js"></script>
		<script type="text/javascript" src="./js/jquery.validate.js"></script>
		<script type="text/javascript" src="./js/jquery.lazyload.min.js"></script>
		<script type="text/javascript" src="./js/myblog.js"></script>
		<script type="text/javascript" src="./js/jiao.js"></script>
		<script type="text/javascript">
			/* <![CDATA[ */
			var favorites_data = {
				"ajaxurl": "https:\/\/www.mygalgame.com\/wp-admin\/admin-ajax.php",
				"nonce": "b562150927",
				"favorite": "\u6536\u85cf\u6587\u7ae0 <i class=\"sf-icon-star-empty\"><\/i>",
				"favorited": "\u53d6\u6d88\u6536\u85cf <i class=\"sf-icon-star-full\"><\/i>",
				"includecount": "1",
				"indicate_loading": "",
				"loading_text": "Loading",
				"loading_image": "<img src=\"https:\/\/www.mygalgame.com\/wp-content\/plugins\/favorites\/assets\/images\/loading.gif\" class=\"simplefavorites-loading\" aria-hidden=\"true\" \/>",
				"loading_image_active": "<img src=\"https:\/\/www.mygalgame.com\/wp-content\/plugins\/favorites\/assets\/images\/loading.gif\" class=\"simplefavorites-loading\" aria-hidden=\"true\" \/>",
				"loading_image_preload": "",
				"cache_enabled": "1",
				"button_options": {
					"button_type": "custom",
					"custom_colors": false,
					"box_shadow": false,
					"include_count": true,
					"default": {
						"background_default": false,
						"border_default": false,
						"text_default": false,
						"icon_default": false,
						"count_default": false
					},
					"active": {
						"background_active": false,
						"border_active": false,
						"text_active": false,
						"icon_active": false,
						"count_active": false
					}
				},
				"authentication_modal_content": "<p>Please login to add favorites.<\/p><p><a href=\"#\" data-favorites-modal-close>Dismiss this notice<\/a><\/p>",
				"authentication_redirect": "",
				"dev_mode": "",
				"logged_in": "",
				"user_id": "0",
				"authentication_redirect_url": "https:\/\/www.mygalgame.com\/wp-login.php"
			}; /* ]]> */
		</script>
		<script type="text/javascript" src="./js/favorites.min.js"></script>
		<link rel="prev" title="心跳~心跳~文学部！" href="https://www.mygalgame.com/xintiaoxintiaowenxuebu.html">
		<link rel="canonical" href="https://www.mygalgame.com/qianlianwanhua.html">
		<link rel="canonical" href="https://www.mygalgame.com/qianlianwanhua.html">
<%
		int[] bg = BgService.randomCommon(0, 50, 7);
		%>
		<style type="text/css">

			
			.cb-slideshow li:nth-child(1) span {
				background-image: url(img/bg/<%=bg[0]%>.jpg);
			}
			
			.cb-slideshow li:nth-child(2) span {
				background-image: url(img/bg/<%=bg[1]%>.jpg);
			}
			
			.cb-slideshow li:nth-child(3) span {
				background-image: url(img/bg/<%=bg[2]%>.jpg);
			}
			
			.cb-slideshow li:nth-child(4) span {
				background-image: url(img/bg/<%=bg[3]%>.jpg);
			}
						
			.cb-slideshow li:nth-child(5) span {
				background-image: url(img/bg/<%=bg[4]%>.jpg);
			}
			
			
			.cb-slideshow li:nth-child(6) span {
				background-image: url(img/bg/<%=bg[5]%>.jpg);
			}
			
			@media (min-width: 767px) {
				.large {
					background: url('img/bg/<%=bg[6]%>.jpg') no-repeat;
				}
			}
		</style>
		<style type="text/css">
			.highslide img {
				cursor: url(images/zoomin.cur), pointer !important;
			}
			
			.highslide-viewport-size {
				position: fixed;
				width: 100%;
				height: 100%;
				left: 0;
				top: 0
			}
		</style>
		<style type="text/css">
		
		.tdRight{
		width: 180px;
		border-width:1px 1px 1px 1px;  
		border-bottom-color: #7AAB78;
		border-right-color:  #7AAB78;
		border-radius:20px;
		}
		.td1{
		width: 170px;
		}
		.td2{
		width: 150px;
		}
		.td3{
		width: 100px;
		}
		.td4{
		width: 100px;
		}
		</style>
  </head>
  		<%
  		String name = (String)session.getAttribute("User");
  		ArrayList<Album> albums = (ArrayList<Album>)request.getAttribute("Albums");
  		ArrayList<Album> randomAlbum=(ArrayList<Album>)session.getAttribute("randomAlbum");
  		ArrayList<Album> newAlbums=(ArrayList<Album>)session.getAttribute("newAlbums");
  		%>
  <body class="post-template-default single single-post postid-14458 single-format-standard" ondragstart="return false" aos-easing="ease-out-back" aos-duration="1000" aos-delay="0">
		<section class="hidden-xs">
			<ul class="cb-slideshow">
				<li><span>苟利</span></li>
				<li><span>国家</span></li>
				<li><span>生死以</span></li>
				<li><span>岂能</span></li>
				<li><span>祸福</span></li>
				<li><span>趋避之</span></li>
			</ul>
		</section>
		
		<div id="overlay" class="magnify" style="display: none;">
			<div class="large"></div><img class="small" src="./img/rpic.png" width="1920"></div>
		<header id="zan-header" class="navbar navbar-inverse">
			<div class="container">
				<div class="navbar-header">
					<a href="/pictureManage/IndexServlet?currentPage=1&User=<%=name %>">
						<div class="navbar-brand" style="width: 180px;"></div>
					</a> <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse"> <span class="fa fa-reorder fa-lg"></span> </button> </div>
				<div class="navbar-collapse bs-navbar-collapse collapse">
					<ul id="menu-caidan" class="nav navbar-nav">
						<li id="menu-item-43" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-43">
							<a href="/pictureManage/IndexServlet?currentPage=1&User=<%=name %>"><i class="fa fa-home"></i>首页</a>
						</li>
						
					</ul>
				</div>
			</div>
		</header>
		<div id="zan-bodyer">
			<div class="container">
				<div class="row">
					<div class="col-md-8">
						<!-- 广告 -->
						<!-- 广告结束 -->
						<!-- 内容主体 -->
						<article class="article container well a-rotateinLT mybody3">
							
							
							<div class="centent-article">
								<figure class="thumbnail hidden-xs"></figure>
								<div class="title-article">
									<h1>删除相册<br><span class="label label-info" style="font-size:13px;"></span></h1> 
									</div><br/><br/>
								
								<div class="alert alert-success">
								
								    <table align="center" class="tab">
								    <tr>
								    <th class="td1">标题</th>
								    <th class="td2">日期</th>
								    <!-- <th class="td3">标签</th> -->
								    <th class="td4"></th>
								    </tr> 
								    <%
								    for (int i=0;i<albums.size();i++ )
								    {
								    	Album album = albums.get(i);
								    %>
								    <tr>
								    <td class="td1"><%=album.getAlbum_title() %></td>
								    <td class="td2"><%=album.getAlbum_date() %></td>
								    <!-- <td class="td3"></td> -->
								    <td class="td4"><a href="/pictureManage/DeleteAlbumServlet?Album_id=<%=album.getAlbum_id()%>&user_id=<%=album.getUser_id() %>" onClick="{if(confirm('确定清除您所选择的记录吗？')){return true;}return false;}">删除</a></td>
								    </tr>
								    <%} %>
								    </table>

								</div>
								<p>&nbsp;</p>
								
								
								
								<div style="float:right"> </div>
							</div>
						</article>
						<!-- 内容主体结束 -->
						<!-- 广告 -->
						<!-- 广告结束 -->
						
					</div>
					<aside class="col-md-4" id="sidebar">
						<aside id="zan_search-7">
							<div class="search aos-init aos-animate" aos="fade-up" aos-duration="2000">
								<form class="form-inline clearfix" method="get" id="searchform" action="/pictureManage/SearchServlet"> <input class="form-control" type="text" name="s" id="s" placeholder="请选用正确的关键词"> <button type="submit" class="btn btn-danger btn-small" name="s"><i class="fa fa-search"></i></button> </form>
							</div>
						</aside>
						<aside id="zan_rand_posts-12">
							<div class="panel panel2 panel-zan recent hidden-xs aos-init" aos="fade-up" aos-duration="2000">
								<div class="panel-heading"> <i class="fa fa-refresh"></i> 随机相册 <i class="fa fa-times-circle panel-remove"></i> <i class="fa fa-chevron-circle-up panel-toggle"></i> </div>
								<ul class="list-group list-group-flush">
								<%
								for(int i=0;i<8;i++){
									Album a = randomAlbum.get(i);
								
								%>
									<li class="list-group-item"> <span class="post-title"> <a href="/pictureManage/SearchServlet?s=<%=a.getAlbum_title()%>"> <%=a.getAlbum_title() %> </a> </span> <span class="badge"><%=a.getAlbum_date() %></span> </li>
								<%} %>
								</ul>
							</div>
						</aside>
						<aside id="zan_hotest_posts-4">
							<div class="panel panel2 panel-zan hot hidden-xs aos-init" aos="fade-up" aos-duration="2000">
								<div class="panel-heading"> <i class="fa fa-fire"></i> 最新相册 <i class="fa fa-times-circle panel-remove"></i> <i class="fa fa-chevron-circle-up panel-toggle"></i> </div>
								<ul class="list-group list-group-flush">
								<%
								for(int i=0;i<8;i++){
									Album a= newAlbums.get(i);
								
								%>
									<li class="list-group-item"> <span class="post-title"> <a href="/pictureManage/SearchServlet?s=<%=a.getAlbum_title()%>"> <%=a.getAlbum_title() %> </a> </span> <span class="badge"><%=a.getAlbum_date() %></span> </li>
								<%} %>
								</ul>
							</div>
						</aside>
					</aside>
				</div>
			</div>
		</div>
		<footer id="zan-footer">
			<div class="container"> © 2014-2017 忧郁的弟弟 .Powered by WordPress. Theme By 忧郁的弟弟 |
				<a href="https://www.mygalgame.com/donate.html" target="_blank">Donate</a> |
				<a href="https://www.mygalgame.com/sitemap.html" target="_blank">站点地图</a>
				<script>
					var _hmt = _hmt || [];
					(function() {
						var hm = document.createElement("script");
						hm.src = "https://hm.baidu.com/hm.js?adcc4ec4333e6dc2eb154cc6d7e91846";
						var s = document.getElementsByTagName("script")[0];
						s.parentNode.insertBefore(hm, s)
					})();
				</script>
				<script>
					(function() {
						var bp = document.createElement('script');
						var curProtocol = window.location.protocol.split(':')[0];
						if(curProtocol === 'https') {
							bp.src = 'https://zz.bdstatic.com/linksubmit/push.js'
						} else {
							bp.src = 'http://push.zhanzhang.baidu.com/push.js'
						}
						var s = document.getElementsByTagName("script")[0];
						s.parentNode.insertBefore(bp, s)
					})();
				</script>
			</div>
		</footer>
		<div id="zan-gotop" style="bottom: -40px;"> <i class="fa fa-angle-up"></i></div>
		<div class="advanced-browser-check" style="display:none;" data-url="{&quot;abc_url&quot;:&quot;https:\/\/www.mygalgame.com\/wp-admin\/admin-ajax.php&quot;}"></div>
		<link rel="stylesheet" href="./css/highslide.css" type="text/css">
		<script type="text/javascript" src="./js/highslide.js"></script>
		<script type="text/javascript">
			jQuery(document).ready(function($) {
				hs.graphicsDir = "https://www.mygalgame.com/wp-content/themes/mygalgame/highslide/graphics/";
				hs.outlineType = "rounded-white";
				hs.dimmingOpacity = 0.8;
				hs.outlineWhileAnimating = true;
				hs.showCredits = false;
				hs.captionEval = "this.thumb.alt";
				hs.numberPosition = "caption";
				hs.align = "center";
				hs.transitions = ["expand", "crossfade"];
				hs.addSlideshow({
					interval: 5000,
					repeat: true,
					useControls: true,
					fixedControls: "fit",
					overlayOptions: {
						opacity: 0.75,
						position: "bottom center",
						hideOnMouseOut: true
					}
				})
			});
		</script>
		<script type="text/javascript" src="./js/myblog_bd.js"></script><canvas width="1535" height="694" style="position: fixed; top: 0px; left: 0px; pointer-events: none; z-index: 888;"></canvas>
		<script type="text/javascript" src="./js/myblog_min.js"></script>
		<script type="text/javascript">
			var smiley = jQuery("#smilelink");
			clone = smiley.clone();
			comment = jQuery("#comment");
			smiley.remove();
			comment.before(smiley);

			function grin(a) {
				var b;
				a = ' ' + a + ' ';
				if(document.getElementById('comment') && document.getElementById('comment').type == 'textarea') {
					b = document.getElementById('comment')
				} else {
					return false
				}
				if(document.selection) {
					b.focus();
					sel = document.selection.createRange();
					sel.text = a;
					b.focus()
				} else if(b.selectionStart || b.selectionStart == '0') {
					var c = b.selectionStart;
					var d = b.selectionEnd;
					var e = d;
					b.value = b.value.substring(0, c) + a + b.value.substring(d, b.value.length);
					e += a.length;
					b.focus();
					b.selectionStart = e;
					b.selectionEnd = e
				} else {
					b.value += a;
					b.focus()
				}
			}
		</script>
		<!--<script type="text/javascript">
			if(window["\x64\x6f\x63\x75\x6d\x65\x6e\x74"]["\x64\x6f\x6d\x61\x69\x6e"] != "\x6d\x79\x67\x61\x6c\x67\x61\x6d\x65\x2e\x63\x6f\x6d" && window["\x64\x6f\x63\x75\x6d\x65\x6e\x74"]["\x64\x6f\x6d\x61\x69\x6e"] != "\x77\x77\x77\x2e\x6d\x79\x67\x61\x6c\x67\x61\x6d\x65\x2e\x63\x6f\x6d") {
				window["\x6c\x6f\x63\x61\x74\x69\x6f\x6e"]["\x68\x72\x65\x66"] = "\x68\x74\x74\x70\x73\x3a\x2f\x2f\x77\x77\x77\x2e\x6d\x79\x67\x61\x6c\x67\x61\x6d\x65\x2e\x63\x6f\x6d\x2f\x3f\x67\x6f\x66\x64\x3d" + window["\x64\x6f\x63\x75\x6d\x65\x6e\x74"]["\x64\x6f\x6d\x61\x69\x6e"];
			}
		</script>-->
		<!--压缩前: 56069 bytes; 压缩后: 51497 bytes; 已压缩：8.15% by 忧郁的弟弟-->
		<div class="highslide-container" style="padding: 0px; border: none; margin: 0px; position: absolute; left: 0px; top: 0px; width: 100%; z-index: 1001; direction: ltr;">
			<a class="highslide-loading" title="点击关闭" href="javascript:;" style="position: absolute; top: -9999px; opacity: 0.75; z-index: 1060;">正在加载中...</a>
			<div style="display: none;"></div>
			<div class="highslide-viewport highslide-viewport-size" style="padding: 0px; border: none; margin: 0px; visibility: hidden; display: none;"></div>
			<div class="highslide-dimming highslide-viewport-size" style="padding: 0px; border: none; margin: 0px; visibility: visible; opacity: 0; display: none;"></div>
			<table cellspacing="0" style="padding: 0px; border: none; margin: 0px; visibility: hidden; position: absolute; border-collapse: collapse; width: 0px;">
				<tbody style="padding: 0px; border: none; margin: 0px;">
					<tr style="padding: 0px; border: none; margin: 0px; height: auto;">
						<td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;https://www.mygalgame.com/wp-content/themes/mygalgame/highslide/graphics/outlines/rounded-white.png&quot;) 0px 0px; height: 20px; width: 20px;"></td>
						<td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;https://www.mygalgame.com/wp-content/themes/mygalgame/highslide/graphics/outlines/rounded-white.png&quot;) 0px -40px; height: 20px; width: 20px;"></td>
						<td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;https://www.mygalgame.com/wp-content/themes/mygalgame/highslide/graphics/outlines/rounded-white.png&quot;) -20px 0px; height: 20px; width: 20px;"></td>
					</tr>
					<tr style="padding: 0px; border: none; margin: 0px; height: auto;">
						<td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;https://www.mygalgame.com/wp-content/themes/mygalgame/highslide/graphics/outlines/rounded-white.png&quot;) 0px -80px; height: 20px; width: 20px;"></td>
						<td class="rounded-white highslide-outline" style="padding: 0px; border: none; margin: 0px; position: relative;"></td>
						<td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;https://www.mygalgame.com/wp-content/themes/mygalgame/highslide/graphics/outlines/rounded-white.png&quot;) -20px -80px; height: 20px; width: 20px;"></td>
					</tr>
					<tr style="padding: 0px; border: none; margin: 0px; height: auto;">
						<td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;https://www.mygalgame.com/wp-content/themes/mygalgame/highslide/graphics/outlines/rounded-white.png&quot;) 0px -20px; height: 20px; width: 20px;"></td>
						<td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;https://www.mygalgame.com/wp-content/themes/mygalgame/highslide/graphics/outlines/rounded-white.png&quot;) 0px -60px; height: 20px; width: 20px;"></td>
						<td style="padding: 0px; border: none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;https://www.mygalgame.com/wp-content/themes/mygalgame/highslide/graphics/outlines/rounded-white.png&quot;) -20px -20px; height: 20px; width: 20px;"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</body>
</html>
