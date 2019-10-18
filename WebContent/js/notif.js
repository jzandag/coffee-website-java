
function sleep(milliseconds) {
  var start = new Date().getTime();
  for (var i = 0; i < 1e7; i++) {
    if ((new Date().getTime() - start) > milliseconds){
      break;
    }
  }
}
$(document).ready(function(){
	
	
	function checkNotif(){
		$.ajax({
			url: baseUrl+"/notifList?id="+$('#idId').text(),
			data:{},
			success:function(data){
				var result = JSON.parse(data);
				
				var row = "";
				if(result.content.length > 0) {
					for(var i in result.content){
						if(result.content[i].isRead == 'false')
						row += "<a style=\"background-color:#bbbbbb\" href=\"#\">"+result.content[i].description+"</a>";
						else
							row += "<a href=\"#\">"+result.content[i].description+"</a>";
					}
					$('#myDropdown').empty();
	    			$('#myDropdown').html(row);
				}
				else{
					$('#myDropdown').empty();
	    			$('#myDropdown').html('<a href=#s>No notifications</a>');
				}
				if(result.totalRecords == 0)
					$('.badge-light').html('');
				else
					$('.badge-light').html(result.totalRecords);
				
			},
	        error:function(dat){
	            //alert(dat.queue_list);
	            
	        }
		});
	}
	checkNotif();
	$('.dropbtn').click(function(event){
		console.log($('#idId').text());
		$('#myDropdown').toggle();
		$.ajax({
    		url: baseUrl+"/notifList?id="+$('#idId').text(),
    		data:{},
    		success:function(data){
    			var result = JSON.parse(data);
    			
    			var row = "";
    			if(result.content.length > 0) {
    				for(var i in result.content){
    					if(result.content[i].isRead == 'false')
    						row += "<a style=\"background-color:#bbbbbb\" href=\"#\">"+result.content[i].description+"</a>";
    						else
    							row += "<a href=\"#\">"+result.content[i].description+"</a>";
    				}
    				$('#myDropdown').empty();
        			$('#myDropdown').html(row);
    			}
    			else{
    				$('#myDropdown').empty();
        			$('#myDropdown').html('<a href=#s>No notifications</a>');
    			}
    			if(result.totalRecords == 0)
    				$('badge-light').html();
    			else
    				$('badge-light').html(result.totalRecords);
    			
    		},
            error:function(dat){
                //alert(dat.queue_list);
                
            }
    	});
	
		$.ajax({
    		url: baseUrl+"/clearNotif?id="+$('#idId').text(),
    		data:{},
    		success:function(data){
    			var result = JSON.parse(data);
    			
    		},
            error:function(dat){
                //alert(dat.queue_list);
                
            }
    	});
		
		$.ajax({
    		url: baseUrl+"/notifList?id="+$('#idId').text(),
    		data:{},
    		success:function(data){
    			var result = JSON.parse(data);
    			if(result.totalRecords == 0)
    				$('badge-light').html();
    			else
    				$('badge-light').html(result.totalRecords);
    			
    		},
            error:function(dat){
                //alert(dat.queue_list);
                
            }
    	});
		
	});
	
	
	
});