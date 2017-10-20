(function($){

    $.fn.extend({
        /**
         * option参数需要传的4个必须参数
         * perPageSize  分页大小参数名  默认 page_size
         * curPage 页号参数名  默认page_no
         * rows_name JSON数据列列参数名   默认rows
         * total_name JSON数据总数参数名    默认total
         * 
         * 	function initChannel(param) {
		$("#channelList").table_list({
			total_name : 'totalRows',
			rows_name : 'resultList',
			page_size_name : 'perPageSize',
			page_no_name : 'curPage'
		}, param);
	}
	
         * **/
    	/**
    	 * option 参数
    	 * 可设置页面中定义的分页相关名称 
    	 *attrTotalRows(默认：totalRows):总行数属性名称 
    	 *attrPageSize(默认：pageSize)：每页大小属性名称
    	 *attrPageNum(默认：pageNum) 当前页页号的名称
    	 *url：请求URL
    	 *perPageSize:分页大小
    	 * curPageNum:当前页号
    	 */
       "table_list":function(option,obj){
            var $this=this;
            var pagination=$(this).find('.pages');
            var table={
                id:$this.attr("id"),
                attrTotalRowsNm:option.totalRowsNm==undefined?'totalRows':option.totalRowsNm,
                attrPageSizeNm:option.attrPageSizeNm==undefined?'perPageSize':option.attrPageSizeNm,
                attrPageNumNm:option.attrPageNumNm==undefined?'curPageNum':option.attrPageNumNm,
                attrOprColumNm:option.attrOprColumNm==undefined?'id':option.attrOprColumNm,
                url:option.url==undefined?$(this).attr("url"):option.url,
                perPageSize:$(this).attr("perPageSize")==undefined?5:$(this).attr("perPageSize"),
                curPageNum:obj.curPageNum==undefined?1:obj.curPageNum,
                oprtFunc:option.oprtJson
            };
           
            obj.pageSize = table.perPageSize;
            var list_id=$('#'+table.id+' .information_list #dataItem' );
            $.post(table.url,obj,function(data){
                var totalRows=data.totalRows;
                $(pagination).attr("totalRows",totalRows);
                $(pagination).attr("totalPage",Math.ceil(totalRows/table.perPageSize));
                $(this).attr("curPageNum",obj.curPageNum).attr("totalPage",Math.ceil(totalRows/table.perPageSize));
               
               
                	 //jquery如何遍历数组
                    var content= list_id.children().eq(0).prop("outerHTML");
                	if(totalRows==0){
                    	 list_id.children().eq(0).children().each(function(index){
                     		$(this).html("");
                     	});
                    	var temp= list_id.children().eq(0).prop("outerHTML");
                    	list_id.children().remove(); 
                    	list_id.append(temp);
                    }else{
                    	list_id.children().remove(); 
                        list_id.children().eq(1).html('');
                    }
                    $.each(data.resultList,function(index,jsonObj){
                        if(totalRows==index){
                        	list_id.append(content);
                            return false;
                        }
                        if(index<table.perPageSize){
                        	list_id.append(content);
     	                    var divNode = list_id.children().eq(index);
     	                      divNode.find("*[name]").each(function(i,columns){
    	                        var value=jsonObj[$(this).attr("name")];
    	                        if($(this).attr("name")==table.attrOprColumNm){
    	                        	$(this).html("");
    	                        	 divNode.attr("value",value);
    	                        	if(table.oprtFunc !=undefined){
    	                        		var l=table.oprtFunc.length;
    	                        		console.log(table.oprtFunc);
    	                        		for(var i=0;i<l;){
    	                        			$(this).append("<a href='javascript:;' onclick='invokeCallback("+table.oprtFunc[i].oprFunc+",\""+value+"\")'>"+table.oprtFunc[i].oprFuncNm+"</a>")
    	                        			i++;
    	                        			if(i<l){
    	                        				$(this).append("||");
    	                        			}
    	                        	    }	
    	                        	}else{
    	                        		$(this).html(value);
    	                        	}
    	                        		
    	                        	
    	                        }else{
    	                        	 $(this).html(value);
    	                        }
    	                    });
                        }
                       
                    });
                   
                    $('#dataItem').css("border-top-width","1px");
                    $(pagination).table_list_pagination(table,obj);

               
                },"json");
        },
        "table_list_pagination":function(table,obj){
            var $this=this;
            //定义分页结构体
            var pageinfo={
                currentPage : $(this).attr("curPageNum")*1, // 当前页码
                pageCount : $(this).attr("totalPage") // 总页码
            };
            $(this).find(' li').remove();

            if(pageinfo.pageCount<2){
            	return false;
            }
            //初始起始页数、结束页数
            var start=0,end=10;
            if(pageinfo.currentPage>=10){
            	start=pageinfo.currentPage-5;
            }
            if(pageinfo.pageCount>pageinfo.currentPage+5){
            	end=pageinfo.currentPage+5;
            }
            else{
            	end=pageinfo.pageCount;
            }
            var html=[];
            if(pageinfo.currentPage!=1){
            	//如果不是第一页则有前一页
            	html.push("<li class='page_prev' style='cursor:pointer;display:inline;'><a>前一页</a></li>");
            }
            if(pageinfo.pageCount>10&&pageinfo.currentPage>9){
            	html.push("<li class='nomal'style='cursor:pointer;display:inline;'><a >1</a></li>");
            }
            for(var i=start;i<end;i++){
                if((i+1)==pageinfo.currentPage){
                	html.push("<li class='active' style='cursor:pointer;display:inline;'><a>"+(i+1)+"</a></li>");
                } else{
                	html.push("<li class='nomal' style='cursor:pointer;display:inline;'><a>"+(i+1)+"</a></li>");
                }
            }

            if(pageinfo.pageCount>10&&pageinfo.currentPage<pageinfo.pageCount-4){
            	html.push("<li class='nomal' style='cursor:pointer;display:inline;'><a >"+pageinfo.pageCount+"</a></li>");
            }
            if(pageinfo.currentPage!=pageinfo.pageCount){
            	html.push("<li class='page_next' style='cursor:pointer;display:inline;'><a >后一页</a></li>");
            }
            $this.html(html.join(""));
            //绑定数据处理函数
            $this.find(".nomal a").bind("click",function(){
                redirectTo($(this).html());
            });
            $this.find(".page_prev a").bind("click",function(){
                redirectTo(pageinfo.currentPage-1);
            });
            $this.find(".page_next a").bind("click",function(){
                redirectTo(pageinfo.currentPage+1);
            });
            
            function redirectTo(page){
            	 if($("#select_all").length>0){
                     $("#select_all")[0].checked=false;
                 }
                $this.attr("curPageNum",page);
                obj.curPageNum=page;
                $('#'+table.id).table_list({oprtJson:table.oprtFunc},obj);

            }
            return $this;
        }
    });

})(jQuery);
$(function(){
    $(".table_list").each(function(){
        $(this).table_list({},{});
    });
});

function invokeCallback(func,obj){
	if(typeof func ==="function"){
		func(obj);
	}
};