<%@page import="java.io.BufferedInputStream"%>
<%@page import="com.jza.domain.Album"%>
<%@ page language="java" import="java.util.*" import="com.jza.service.BgService" import="java.text.SimpleDateFormat" import="java.util.Calendar" import="com.jza.service.IndexService"  pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.0 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon">
		<link rel="bookmark" href="./img/favicon.ico" type="image/x-icon">
		<meta http-equiv="Cache-Control" content="no-transform">
		<meta http-equiv="Cache-Control" content="no-siteapp">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="renderer" content="webkit">
		<title>MyPicture</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!--		<link rel="dns-prefetch" href="https://www.mygalgame.com/">-->
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
				"nonce": "8fae543247",
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
						
		</style>
  </head>
  <%
  ArrayList<Album> albums = (ArrayList<Album>)session.getAttribute("albums");
  ArrayList<Album> randomAlbum=(ArrayList<Album>)session.getAttribute("randomAlbum");
  ArrayList<Album> newAlbums=(ArrayList<Album>)session.getAttribute("newAlbums");
	int currentPage=1,pageCount=-1;
	String cp = (String)session.getAttribute("currentPage");
	Integer pc=(Integer) session.getAttribute("pageCount");
	String name = (String)session.getAttribute("User");
	Integer user_id = (Integer)session.getAttribute("user_id");
	String searchCount = (String)session.getAttribute("searchCount");
	if(cp!=null){
		currentPage=Integer.parseInt(cp);
	}
	if(pc!=null){
		pageCount=pc;
	}
  %>
  <script type="text/javascript">
function search(searchCount)
  {
	
  
  if(searchCount=="aa"){
	  alert("搜索到0条记录");
  }
  }
</script>
	<body class="home blog" ondragstart="return false" aos-easing="ease-out-back" aos-duration="1000" aos-delay="0" onload="f(<%=currentPage %>,<%=pageCount %>);search('<%=searchCount%>')">
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
		<div class="GalMenu GalDropDown" style="top: 0px; left: 615px; display: none; opacity: 1;">
			<div class="circle" id="gal">
				<div class="ring">
					<a href="/pictureManage/IndexServlet?currentPage=1&User=<%=name %>" title="" class="menuItem" style="left: 50%; top: 15%;" id="firstRight">首页</a>
					<a href="/pictureManage/IndexServlet?currentPage=<%=currentPage+1 %>&User=<%=name %>" title="" class="menuItem" style="left: 80.3109%; top: 32.5%;" id="nextRight">下一页</a>
					<a href="/pictureManage/ToDeleteAlbum?user_id=<%=user_id %>" title="" class="menuItem" style="left: 80.3109%; top: 67.5%;">删除相册</a>
					<a href="javascript:void(0)" title="" class="menuItem" style="left: 50%; top: 85%;"></a>
					<a href="/pictureManage/AddAlbum.jsp?user_id=<%=user_id %>" title="" class="menuItem" style="left: 19.6891%; top: 67.5%;">新建相册</a>
					<a href="/pictureManage/IndexServlet?currentPage=<%=currentPage-1 %>&User=<%=name %>" title="" class="menuItem" style="left: 19.6891%; top: 32.5%;" id="prevRight">上一页</a>
				</div>
<!-- 				<audio id="audio" src="https://www.mygalgame.com/wp-content/themes/mygalgame/ui/audio/oni.mp3"></audio>-->	
			
			</div>
		</div>
		<div id="overlay" class="magnify" style="display: none;">
			<div class="large" style="left: 665px; top: 40px; background-position: -697px -46px; display: block;"></div><img class="small" src="./images/rpic.png" width="1920"></div>
		<header id="zan-header" class="navbar navbar-inverse">
			<div class="container">
				<div class="navbar-header">
					<a href="/pictureManage/IndexServlet?currentPage=1&User=<%=name %>">
						<div class="navbar-brand"></div>
					</a> <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse"> <span class="fa fa-reorder fa-lg"></span> </button> </div>
				<div class="navbar-collapse bs-navbar-collapse collapse">
					<ul id="menu-caidan" class="nav navbar-nav">
						<li id="menu-item-43" class="menu-item menu-item-type-custom menu-item-object-custom current-menu-item current_page_item menu-item-43">
							<a href="/pictureManage/IndexServlet?currentPage=1&User=<%=name %>"><i class="fa fa-home"></i>首页</a>
						</li>
					</ul>
				</div>
			</div>
		</header>
		
		<div id="zan-bodyer">
			<div class="container">
				<div class="row">
					<div id="mainstay" class="col-md-8">
						<!-- 公告 -->
						<div class="well mybody2"> <button type="button" class="close" data-dismiss="alert">×</button> <b><font color="#FF0000">公告</font></b><br><br>内容 </div>
						<!-- 公告结束 -->
						<!-- 内容主体 -->
						<div id="article-list">
						<%
							for (int i = 0; i < albums.size(); i++) {	
							Album a = albums.get(i);
							IndexService index = new IndexService();
							int photoCount = index.findPhotoCount(a.getAlbum_id().toString());
							String album_id = a.getAlbum_id().toString();
							ArrayList<String> types = index.findAlbumType(album_id);
							
						%>
						
							<div class="article well clearfix mybody3 aos-init aos-animate" aos="flip-up"> <i class="fa fa-bookmark article-stick visible-md visible-lg"></i>
								<%!
								int month = 0;
								int day = 0;
								%>
								<%
								try {
									 
								    Date date = a.getAlbum_date();
								    
								 
								    
								    Calendar c1 = Calendar.getInstance();
								    c1.setTime(date);
								    
								    month = c1.get(Calendar.MONTH)+1;
								    day = c1.get(Calendar.DAY_OF_MONTH);
								    
								  
								} catch (Exception e) {}
								%>
								
								<div class="data-article hidden-xs"> <span class="month"><%=month %>月</span> <span class="day"><%=day %></span> </div>
								<!-- 大型设备文章属性 -->
								<section class="hidden-xs">
								
									<div class="title-article">
										<h1><a href="/pictureManage/PhotoServlet?album_id=<%=a.getAlbum_id() %>&Date=<%=a.getAlbum_date() %>&photoCount=<%=photoCount %>&title=<%=a.getAlbum_title() %>&album_describe=<%=a.getAlbum_describe() %>" target="_blank"><span class="animated_h1"><%=a.getAlbum_title() %></span><br><span class="label label-info" style="font-size:13px;"></span></a></h1> </div>
									<div class="tag-article">
									
									<span class="label label-zan"><i class="fa fa-tags"></i>
									<%for(int j=0;j<types.size();j++){ %>
									 <a href="javascript:void(0)" rel="tag"><%=types.get(j) %></a>
									 <%} %>
									 </span>
									
									<span class="label label-zan"><i class="fa fa-eye"></i> <%=photoCount %></span></div>
									<div class="alert alert-zan mybody3">
										<p style="text-align: center;">
											<a href="/pictureManage/PhotoServlet?album_id=<%=a.getAlbum_id() %>&Date=<%=a.getAlbum_date() %>&photoCount=<%=photoCount %>&title=<%=a.getAlbum_title() %>" target="_blank"> </a>
										</p>
										<div class="ih-item square effect bottom_to_top">
											<a href="/pictureManage/PhotoServlet?album_id=<%=a.getAlbum_id() %>&Date=<%=a.getAlbum_date() %>&photoCount=<%=photoCount %>&title=<%=a.getAlbum_title() %>" target="_blank">
												<div class="img">
													<img src="/pictureManage/AlbumCover<%=i %>Servlet" alt="">
												</div>
												<div class="info">
													<p><%=a.getAlbum_describe() %></p>
												</div>
											</a>
										</div>
										<a href="/pictureManage/PhotoServlet?album_id=<%=a.getAlbum_id() %>&Date=<%=a.getAlbum_date() %>&photoCount=<%=photoCount %>&title=<%=a.getAlbum_title() %>" target="_blank"> </a>
										<p></p>
									</div>
									
								</section>
								
								<!-- 大型设备文章属性结束 -->
								
	
							</div>
								<%} %>
						</div>
						<!-- 内容主体结束 -->
						<!-- 分页 -->
						
						<div id="zan-page" class="clearfix">
							<ul class="pagination pagination-zan pull-right">
								
								<li>
									<a href="/pictureManage/IndexServlet?currentPage=1&User=<%=name %>" id="first">首页</a>
								</li>
								<li>
									<a href="/pictureManage/IndexServlet?currentPage=<%=currentPage-1 %>&User=<%=name %>" id="prev" >上一页</a>
								</li>
								<li>
									<a href="javascript:void(0)">第<%=currentPage %>页/共<%=pageCount %>页</a>
								</li>
								<li>
									<a href="/pictureManage/IndexServlet?currentPage=<%=currentPage+1 %>&User=<%=name %>" id="next">下一页</a>
								</li>
								<li>
									<a href="/pictureManage/IndexServlet?currentPage=<%=pageCount %>&User=<%=name %>" id="end">尾页</a>
								</li>
							</ul>
						</div>
						
						<!-- 分页结束 -->
					</div>
					<aside class="col-md-4" id="sidebar">
						<aside id="zan_search-7">
							<div class="search aos-init aos-animate" aos="fade-up" aos-duration="2000">
								<form class="form-inline clearfix" method="get" id="searchform" action="/pictureManage/SearchServlet"> <input class="form-control" type="text" name="s" id="s" placeholder="请选用正确的关键词"> <button type="submit" class="btn btn-danger btn-small" name="s"><i class="fa fa-search"></i></button> </form>
							</div>
						</aside>
						<aside id="zan_login-5">
							<div class="panel panel-zan aos-init aos-animate" aos="flip-right" aos-duration="3000">
								<div class="panel-heading"><i class="fa fa-book"></i>功能列表</div>
								<div class="login-form clearfix">
								<form action="/pictureManage/AddAlbum.jsp?user_id=<%=user_id %>" method="post">
									<button class="btn btn-inverse-primary pull-left" type="submit" name="submit">新建相册</button>
								</form>
								<form action="/pictureManage/ToDeleteAlbum?user_id=<%=user_id %>" method="post">
									<button class="btn btn-inverse-primary pull-left" type="submit" name="submit" style="margin-left: 10px;">删除相册</button>
								</form>
									</div>

							</div>
						</aside>
						<%
						
						%>
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
						<aside id="zan_sets-10">
							<div class="panel panel-zan hidden-xs aos-init" aos="fade-up" aos-duration="2000">
										<div class="panel-heading"> 热门标签 <i class="fa fa-times-circle panel-remove"></i> <i class="fa fa-chevron-circle-up panel-toggle"></i> </div>
									
								<div class="tab-content">
								<%
								int max=15;
						        int min=5;
						        Random random = new Random();

						        int s = random.nextInt(max)%(max-min+1) + min;
								%>
									<div class="cloud-tags tab-pane nav bs-sidenav active" id="sidebar-tags">
									<%
									IndexService index = new IndexService();
									ArrayList<String> types = index.findAllAlbumType();
									for(int k=0;k<types.size();k++){ 
									%>
										<a href="javascript:void(0)" class="tag-cloud-link tag-link-91 tag-link-position-1" style="font-size: <%=random.nextInt(max)%(max-min+1) + min%>pt;"><%=types.get(k)%></a>										
									<%} %>
									</div>
									<!-- <div class="tab-pane active nav bs-sidenav fade in" id="sidebar-links">
										<li>
											<a href="http://kdays.net/days/" title="Galgame综合向论坛" target="_blank">KDays Forum</a>
										</li>
										<li>
											<a href="http://www.gal123.com/" title="绅士导航♂" target="_blank">绅士导航♂</a>
										</li>
										<li>
											<a href="http://www.moe123.com/" title="萌导航" target="_blank">萌导航</a>
										</li>
									</div> -->
								</div>
							</div>
						</aside>
					</aside>
				</div>
			</div>
		</div>
		<footer id="zan-footer">
			<div class="container"> © 2014-2017 忧郁的弟弟 .Powered by WordPress. Theme By 忧郁的弟弟 |
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
		<div id="zan-gotop"> <i class="fa fa-angle-up"></i></div>
		<div class="advanced-browser-check" style="display:none;" data-url="{&quot;abc_url&quot;:&quot;https:\/\/www.mygalgame.com\/wp-admin\/admin-ajax.php&quot;}"></div>
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
<!--		<script type="text/javascript">
			if(window["\x64\x6f\x63\x75\x6d\x65\x6e\x74"]["\x64\x6f\x6d\x61\x69\x6e"] != "\x6d\x79\x67\x61\x6c\x67\x61\x6d\x65\x2e\x63\x6f\x6d" && window["\x64\x6f\x63\x75\x6d\x65\x6e\x74"]["\x64\x6f\x6d\x61\x69\x6e"] != "\x77\x77\x77\x2e\x6d\x79\x67\x61\x6c\x67\x61\x6d\x65\x2e\x63\x6f\x6d") {
				window["\x6c\x6f\x63\x61\x74\x69\x6f\x6e"]["\x68\x72\x65\x66"] = "\x68\x74\x74\x70\x73\x3a\x2f\x2f\x77\x77\x77\x2e\x6d\x79\x67\x61\x6c\x67\x61\x6d\x65\x2e\x63\x6f\x6d\x2f\x3f\x67\x6f\x66\x64\x3d" + window["\x64\x6f\x63\x75\x6d\x65\x6e\x74"]["\x64\x6f\x6d\x61\x69\x6e"];
			}
		</script>-->
		<!--压缩前: 75237 bytes; 压缩后: 68087 bytes; 已压缩：9.5% by 忧郁的弟弟-->
	</body>


</html>
