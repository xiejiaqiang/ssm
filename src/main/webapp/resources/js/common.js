/**
*功能描述：公共方法
**/
//全局变量
var isMock = false
//ajax调用
 function callAjax(url,parmas,mockData,callBack){
	if(isMock){
		callBack(mockData);
		return;
	}
	$.ajax({
		type : 'POST',
		dataType : 'json',
		url :url,
		data : parmas,
		cache : false,
		async : false,
		success : function(resp){
			if (resp.map.success == false) {
                layer.alert(resp.map.message,{icon: 2});
			} else {
				callBack(resp.map);
			}
		},
		error : function(x,e,s){
			return false;
		}
	});
}
//toastr提示框 msg:消息  title：标题  toastr   shortCutFunction：success成功、info信息、warning警告、error错误
function callToastr(title,msg,toastr,shortCutFunction){


    var i = -1;
    var toastCount = 0;
    var $toastlast;
    var getMessage = function () {
        var msg = 'Hi, welcome to Inspinia. This is example of Toastr notification box.';
        return msg;
    };
        var toastIndex = toastCount++;
        if (!msg) {
            msg = getMessage();
        }
        $("#toastrOptions").text("Command: toastr[" + shortCutFunction + "](\"" + msg + (title ? "\", \"" + title : '') + "\")\n\ntoastr.options = " + JSON.stringify(toastr.options, null, 2));
        var $toast = toastr[shortCutFunction](msg, title); // Wire up an event handler to a button in the toast, if it exists
        $toastlast = $toast;
        if ($toast.find('#okBtn').length) {
            $toast.delegate('#okBtn', 'click', function () {
                alert('you clicked me. i was toast #' + toastIndex + '. goodbye!');
                $toast.remove();
            });
        }
        if ($toast.find('#surpriseBtn').length) {
            $toast.delegate('#surpriseBtn', 'click', function () {
                alert('Surprise! you clicked me. i was toast #' + toastIndex + '. You could perform an action here.');
            });
        }

    function getLastToast() {
        return $toastlast;
    }
}
function layerAlert(errorMsg,iconIndex){
    parent.layer.alert(errorMsg , {
        icon: iconIndex,
        skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
    })
}
$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};
Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "H+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};