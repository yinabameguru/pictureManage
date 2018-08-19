function f(currentPage,pageCount){
	
	var first=document.getElementById("first");
	var prev=document.getElementById("prev");
	var next=document.getElementById("next");
	var end=document.getElementById("end");
	var firstRight = document.getElementById("firstRight");
    var nextRight = document.getElementById("nextRight");
    var prevRight = document.getElementById("prevRight");
	
	if(currentPage==1){
		
		first.href="javascript:void(0);";
		prev.href="javascript:void(0);";
		firstRight.href = "javascript:void(0);";                    
        prevRight.href = "javascript:void(0);";
		
		
	}
	if(currentPage==pageCount){
		
		end.href="javascript:void(0);";
		next.href="javascript:void(0);";
		nextRight.href = "javascript:void(0);";
		
		
	}
}
var interval;

function startSecond(name) {

	interval = window.setInterval("changeSecond('"+name+"')", 1000);

};

function changeSecond(name) {
	var second = document.getElementById("second");

	var svalue = second.innerHTML;

	svalue = svalue - 1;

	if (svalue == 0) {
		window.clearInterval(interval);
		location.href = "/pictureManage/IndexServlet?currentPage=1&User="+name+"";
		return;
	}

	second.innerHTML = svalue;
}

//获取XMLHttpRequest对象
function getXMLHttpRequest() {
	var xmlhttp;
	if (window.XMLHttpRequest) {// code for all new browsers
		xmlhttp = new XMLHttpRequest();
	} else if (window.ActiveXObject) {// code for IE5 and IE6
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	return xmlhttp;

}





