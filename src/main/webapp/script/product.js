function save(){
	var url="back/prd/save"
	var paramJson={};
	var prdCd = $('input[name="productCd"]').val();
	var prdNm = $('input[name="productNm"]').val();
	var basePrice = $('input[name="basePrice"]').val();
	var price = $('input[name="price"]').val();
	var unit = $('input[name="unit"]').val();
	var param = $('input[name="param"]').val();
	paramJson.productCd = prdCd;
	paramJson.productNm = prdNm;
	paramJson.basePrice = basePrice;
	paramJson.price = price;
	paramJson.unit = unit;
	paramJson.param = param;
	console.log(paramJson);
	$.post(url,paramJson,function(data){
		var data = JSON.parse(data);
		console.log(data);
		var tips = '';
		if(data.code=='OK'){
			tips ="保存产品基础信息成功";
		}else if(data.code =='EXIST'){
			tips ="当前产品型号已存在，无需录入";
		}else {
			tips ="保存产品基础信息失败";
		}
		messageAlert('操作提示!',tips);
	});
}

$("#uploadBtn").attr("disabled",false); 
$("#uploadBtn").click(function(){
    var fileValue = $("#file").val();  
    if(fileValue == null || fileValue == ""){  
    	messageAlert('操作提示!',"请选择文件");
        return;   
    }  
    var obj = $("#file");  
    var photoExt=obj.val().substr(obj.val().lastIndexOf(".")).toLowerCase();//获得文件后缀名  
    if(photoExt!=".xls" && photoExt!=".xlsx"){  
    	messageAlert('操作提示!',"请选择xls或是xlsx格式的文件，不支持其他格式文件");
        return false;  
    }  
    var fileSize = 0;  
    var isIE = /msie/i.test(navigator.userAgent) && !window.opera;        
    if (isIE && !obj.files) {       
        var filePath = obj.val();        
        var fileSystem = new ActiveXObject("Scripting.FileSystemObject");    
        var file = fileSystem.GetFile (filePath);          
        fileSize = file.Size;       
    }else {   
        fileSize = obj.get(0).files[0].size;     
    }   
    fileSize=Math.round(fileSize/1024*100)/100; //单位为KB  
    if(fileSize > 5000){  
        messageAlert('操作提示!',"文件不能大于5M");
        return false;  
    }  
    $("#progressBar").width("0%");  
    $(this).attr("disabled",true);  
    $("#progressBar").parent().show();  
    $("#progressBar").parent().addClass("active");  
    uploadFile(); 
});
$("#clearBtn").click(function(){
    var fileValue = $("#file").val('');  
});

function uploadFile() {  
    var fileObj = $("#file").get(0).files[0]; // js 获取文件对象  
    console.info("上传的文件："+fileObj);  
    var url = "back/prd/upload"; // 接收上传文件的后台地址   
    var form = new FormData();  
    form.append("file", fileObj); // 文件对象  
    var xhr = new XMLHttpRequest();  
    xhr.open("post", url, true);  
    xhr.onload = function() {  
        messageAlert('操作提示!',"上传完成");
        $("#uploadBtn").attr('disabled', false);  
        $("#uploadBtn").val("上传");  
        $("#progressBar").parent().removeClass("active");  
        $("#progressBar").parent().hide();  
    };  
    xhr.upload.addEventListener("progress", progressFunction, false);  
    xhr.send(form);  
}  

function progressFunction(evt) {  
    var progressBar = $("#progressBar");  
    if (evt.lengthComputable) {  
        var completePercent = Math.round(evt.loaded / evt.total * 100)+ "%";  
        progressBar.width(completePercent);  
        $("#uploadBtn").val("正在上传 " + completePercent);  
    }  
};  